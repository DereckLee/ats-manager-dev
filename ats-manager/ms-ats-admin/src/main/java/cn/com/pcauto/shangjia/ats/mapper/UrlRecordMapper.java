package cn.com.pcauto.shangjia.ats.mapper;

import cn.com.pcauto.shangjia.ats.entity.UrlRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Dereck
 * @since 2021-01-05
 */
public interface UrlRecordMapper extends BaseMapper<UrlRecord> {


    /**
     * 将数据分表插入
     * @param atsUrlRecord
     * @param tabName
     */
    void saveDynamically(@Param("entity") UrlRecord atsUrlRecord, @Param("tabName") String tabName);

    /**
     * 对特定的表进行数据删除
     * @param id 记录Id
     * @param tabName
     */
    @Delete("DELETE FROM #{tabName} WHERE id=#{id}")
    void removeByIdAndTabName(@Param("id") Long id, @Param("tabName") String tabName);

    /**
     * 查询特定的表数据
     * @param id
     * @param tabName
     * @return
     */
    @Select("SELECT `id`,`define_id`,`url`,`md5_url`,`md5_content`,`push_time`," +
            "`purge_time`,`status`,`status_msg`,`page_total`,`create_time`," +
            "`update_time`,`create_by`,`update_by`,`val1` ,`val2` ,`val3`,`val4`," +
            "`val5`,`val6`,`val7`,`val8`,`val9`,`val10` FROM #{tabName} WHERE id=#{id}")
    UrlRecord selectByIdAndTabName(@Param("id") Long id, @Param("tabName")String tabName);


    /**
     * 更新特定表的数据
     * @param entity
     * @param tabName
     */
    void updateByIdAndTabName(@Param("entity")UrlRecord entity,@Param("tabName") String tabName);


    /**
     * 获取表的总记录数
     * @param tabName
     * @return
     */
    @Select("SELECT COUNT(*) FROM #{tabName}")
    Integer getCountByTabName(String tabName);


    /**
     * 查询某个表下的一定量的数据
     * @param tabName
     * @param offset 跳过的记录数/偏移量
     * @param size 要查询的记录数
     * @return
     */
    @Select("SELECT `id`,`define_id`,`url`,`md5_url`,`md5_content`,`push_time`," +
            "`purge_time`,`status`,`status_msg`,`page_total`,`create_time`," +
            "`update_time`,`create_by`,`update_by`,`val1` ,`val2` ,`val3`,`val4`," +
            "`val5`,`val6`,`val7`,`val8`,`val9`,`val10` FROM #{tabName} LIMIT #{offset},#{size}")
    List<UrlRecord> limitSelectByTabName(@Param("tabName")String tabName,
                                @Param("offset")Integer offset,
                                @Param("size")Integer size);


}
