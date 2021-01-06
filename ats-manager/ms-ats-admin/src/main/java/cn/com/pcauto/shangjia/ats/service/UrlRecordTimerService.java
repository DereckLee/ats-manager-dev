package cn.com.pcauto.shangjia.ats.service;

import cn.com.pcauto.shangjia.ats.entity.UrlRecord;
import cn.com.pcauto.shangjia.ats.entity.UrlRecordTimer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Dereck
 * @since 2021-01-05
 */
public interface UrlRecordTimerService extends IService<UrlRecordTimer> {


    /**
     *
     * @param atsUrlRecordTimer
     */
    void saveDynamically(UrlRecordTimer atsUrlRecordTimer);


    /**
     *
     * @param id
     * @return
     */
    UrlRecordTimer selectById(Long id);

    /**
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<UrlRecord> findByPage(Integer pageNo, Integer pageSize);

}
