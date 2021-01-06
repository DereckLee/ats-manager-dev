package cn.com.pcauto.shangjia.ats.service.impl;

import cn.com.pcauto.shangjia.ats.entity.UrlRecord;
import cn.com.pcauto.shangjia.ats.entity.UrlRecordTimer;
import cn.com.pcauto.shangjia.ats.exception.AtsException;
import cn.com.pcauto.shangjia.ats.mapper.UrlRecordTimerMapper;
import cn.com.pcauto.shangjia.ats.service.UrlRecordTimerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  定时Url实体(UrlRecordTimer)服务实现类
 * </p>
 *
 * @author Dereck
 * @since 2021-01-05
 */
@Service
public class UrlRecordTimerServiceImpl extends ServiceImpl<UrlRecordTimerMapper, UrlRecordTimer>
        implements UrlRecordTimerService {

    @Resource
    private UrlRecordTimerMapper urlRecordTimerMapper;

    /**
     *
     * @param atsUrlRecordTimer
     */
    @Override
    public void saveDynamically(UrlRecordTimer atsUrlRecordTimer) {

    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public UrlRecordTimer selectById(Long id) {
        UrlRecordTimer condition = new UrlRecordTimer().setId(id);

        String tabName = "ats_url_record_timer_" + Math.abs(condition.getTabNo());

        UrlRecordTimer urlRecordTimer = null;
        try {
            urlRecordTimer = urlRecordTimerMapper.selectByIdAndTabName(id, tabName);
        } catch (Exception e) {
            throw new AtsException(1,"获取“定时Url实体”失败");
        }
        return urlRecordTimer;
    }



    @Override
    public List<UrlRecord> findByPage(Integer pageNo, Integer pageSize) {

        return null;
    }
}

