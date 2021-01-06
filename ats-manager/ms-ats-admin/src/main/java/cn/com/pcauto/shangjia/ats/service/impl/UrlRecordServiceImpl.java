package cn.com.pcauto.shangjia.ats.service.impl;

import cn.com.pcauto.shangjia.ats.constants.AtsTabs;
import cn.com.pcauto.shangjia.ats.entity.UrlRecord;
import cn.com.pcauto.shangjia.ats.entity.UrlRecordTimer;
import cn.com.pcauto.shangjia.ats.exception.AtsException;
import cn.com.pcauto.shangjia.ats.mapper.UrlRecordMapper;
import cn.com.pcauto.shangjia.ats.service.UrlRecordService;
import cn.com.pcauto.shangjia.ats.utils.IdWorker;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Dereck
 * @since 2021-01-05
 */
@Service
public class UrlRecordServiceImpl
        extends ServiceImpl<UrlRecordMapper, UrlRecord> implements UrlRecordService {

    @Autowired
    private IdWorker idWorker;

    @Resource
    private UrlRecordMapper urlRecordMapper;

    /**
     * Url实体分表后的分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public List<UrlRecord> findByPage(Integer pageNo, Integer pageSize) {



        return null;
    }

    /**
     * 获取表的总记录数
     * @return
     */
    private int countRecordByTabName(String tabName){

        return urlRecordMapper.getCountByTabName(tabName)>0
                ? urlRecordMapper.getCountByTabName(tabName) : 0;
    }



    /**
     * 将数据分表保存
     * @param atsUrlRecord
     */
    @Override
    public void saveDynamically(UrlRecord atsUrlRecord) {

        atsUrlRecord.setId(idWorker.nextId());
        //获取将要插入数据的表名
        String tabName = "ats_url_record_" + +Math.abs(atsUrlRecord.getTabNo());
        urlRecordMapper.saveDynamically(atsUrlRecord,tabName);
    }

    /**
     *
     * @param id
     * @param tabNo
     */
    @Override
    public void removeByIdAndTaNo(Long id, Integer tabNo) {
        try {
            //拼接，获取将要删除数据的表名
            String tabName = AtsTabs.URL_RECORD + Math.abs(tabNo);
            urlRecordMapper.removeByIdAndTabName(id,tabName);
        } catch (Exception e) {
            throw new AtsException(1,"Url删除失败");
        }
    }

    /**
     *
     * @param urlRecord
     */
    @Override
    public void updateByIdDynamically(UrlRecord urlRecord) {
        urlRecordMapper.updateByIdAndTabName(urlRecord,urlRecord.getTabName());
    }


    /**
     *
     * @param id
     * @return
     */
    @Override
    public UrlRecord selectById(Long id) {

        UrlRecord condition = new UrlRecord().setId(id);
        //存储表
        String tabName = condition.getTabName();

        UrlRecord urlRecord = null;
        try {
            urlRecord = urlRecordMapper.selectByIdAndTabName(id, tabName);
        } catch (Exception e) {
            throw new AtsException(1,"获取Url实体失败");
        }

        return urlRecord;
    }
}
