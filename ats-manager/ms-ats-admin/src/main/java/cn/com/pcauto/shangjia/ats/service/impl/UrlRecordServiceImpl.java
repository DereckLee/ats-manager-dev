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
public class UrlRecordServiceImpl extends ServiceImpl<UrlRecordMapper, UrlRecord> implements UrlRecordService {

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

        QueryWrapper<UrlRecord> query = new QueryWrapper<>();

        //设置分页参数
        Page<UrlRecord> page = new Page<>(pageNo, pageSize);


        //按照表顺序，记录数的偏移量
        int offset = (pageNo-1)*pageSize;//起始点的偏移量
        List<UrlRecord> coll = new ArrayList<>();//存储查询的表
        Map<Integer,Integer> countTable = new HashMap<>();//表号->记录数
        int counter = 0;
        int frontOffset = 0;
        int behindOffset = 0;
        int startIndex = 0;//开始表
        int endIndex = 0;//最后的表

        for (int i = 0; i < 100; i++) {

            //String tabName = AtsTabs.URL_RECORD + i;
            //表的总记录数
            frontOffset += countRecordByTabName(AtsTabs.URL_RECORD + i);//前偏移
            behindOffset += countRecordByTabName(AtsTabs.URL_RECORD + (i+1));//后偏移


            countTable.put(i,countRecordByTabName(AtsTabs.URL_RECORD + i));//记录数

            //定位表查询的范围[startIndex,endIndex]
            if(offset > frontOffset && offset <= behindOffset){
                startIndex = i;
            }
            if((offset+pageSize) > frontOffset && (offset+pageSize) <= behindOffset){
                endIndex = i;
            }
        }
        //扫描查询{pageSize}条记录
        for (int i = startIndex; i <= endIndex; i++) {
            //size==0,跳过
            if(countTable.get(1) == 0)
                continue;

            //表记录数中不够，查询全部


            //

        }



        return coll;
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
