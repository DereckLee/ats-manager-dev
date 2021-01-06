package cn.com.pcauto.shangjia.ats.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Dereck
 * @since 2021-01-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UrlRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    //@TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Long id;

    /**
     * url定义id
     */
    private Long defineId;

    /**
     * url链接
     */
    private String url;

    /**
     * url摘要md5
     */
    private String md5Url;

    /**
     * 请求响应内容摘要md5
     */
    private String md5Content;

    /**
     * 推送父Ats时间
     */
    private Date pushTime;

    /**
     * 删除子Ats时间
     */
    private Date purgeTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 状态具体信息
     */
    private String statusMsg;

    /**
     * 分页链接，记录总页数
     */
    private Integer pageTotal;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 参数1
     */
    private Long val1;

    /**
     * 参数2
     */
    private Long val2;

    /**
     * 参数3
     */
    private Long val3;

    /**
     * 参数4
     */
    private Long val4;

    /**
     * 参数5
     */
    private Long val5;

    /**
     * 参数6
     */
    private Long val6;

    /**
     * 参数7
     */
    private Long val7;

    /**
     * 参数8
     */
    private Long val8;

    /**
     * 参数9
     */
    private Long val9;

    /**
     * 参数10
     */
    private Long val10;

    //插入数据库的表号
    private Integer tabNo;


    /**
     * 获取插入表的表号
     * 表名格式：
     * @return 如果id==null,则
     */
    public Integer  getTabNo(){
        if(this.tabNo!=null && tabNo.intValue()>0 && tabNo.intValue()<100)
            return this.tabNo;

        if(this.id == null)
            return -1;

        this.tabNo = id.intValue() % 100;
        return this.tabNo;
    }

    /**
     * 获取对数据存储的表名字
     * @return
     */
    public String getTabName(){
        return "ats_url_record_" + Math.abs(getTabNo());
    }




}
