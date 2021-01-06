package cn.com.pcauto.shangjia.ats.service;

import cn.com.pcauto.shangjia.ats.entity.UrlRecord;
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
public interface UrlRecordService extends IService<UrlRecord> {

    /**
     * 动态插入
     * @param atsUrlRecord
     */
    void saveDynamically(UrlRecord atsUrlRecord);

    /**
     * 删除对应表Url实体
     * @param id
     * @param tabNo
     */
    void removeByIdAndTaNo(Long id, Integer tabNo);


    /**
     * 更新对应表Url实体
     * @param urlRecord
     */
    void updateByIdDynamically(UrlRecord urlRecord);

    /**
     * 查询对应表Url实体
     * @param id
     * @return
     */
    UrlRecord selectById(Long id);

    /**
     * 对所有的表进行分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<UrlRecord> findByPage(Integer pageNo, Integer pageSize);
}
