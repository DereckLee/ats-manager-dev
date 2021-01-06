package cn.com.pcauto.shangjia.ats.mapper;

import cn.com.pcauto.shangjia.ats.entity.UrlRecordTimer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  UrlRecordTimer实体相关表的DAO接口
 * </p>
 *
 * @author Dereck
 * @since 2021-01-05
 */
public interface UrlRecordTimerMapper extends BaseMapper<UrlRecordTimer> {

    /**
     *
     * @param id
     * @param tabName
     * @return
     */
    @Select("SELECT `id`,`define_id`,`url`,`md5_url`,`md5_content`,`push_time`," +
            "`purge_time`,`status`,`status_msg`,`page_total`,`create_time`,`update_time`," +
            "`create_by`,`update_by`," +
            "FROM #{tabName} WHERE id=#{id}")
    UrlRecordTimer selectByIdAndTabName(@Param("id") Long id, @Param("tabName")String tabName);



}
