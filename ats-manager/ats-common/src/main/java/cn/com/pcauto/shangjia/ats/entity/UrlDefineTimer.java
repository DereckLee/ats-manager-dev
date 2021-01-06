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
@TableName("ats_url_define_timer")
public class UrlDefineTimer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 前端主机
     */
    private String frontHost;

    /**
     * 后端内网主机
     */
    private String backInnerHost;

    /**
     * 后端外网主机
     */
    private String backOuterHost;

    /**
     * uri
     */
    private String uri;

    /**
     * 优先级，越小越高
     */
    private Integer priority;

    /**
     * url定义的实现类
     */
    private String className;

    /**
     * 是否排序，0：否，1：是
     */
    private Integer sortParam;

    /**
     * 缓存时间，单位s
     */
    private Integer cacheExpire;

    /**
     * 定时执行间隔，单位s
     */
    private Integer timerInterval;

    /**
     * 缓存有效参数，逗号隔开
     */
    private String includeParam;

    /**
     * 排除的参数，逗号隔开
     */
    private String excludeParam;

    /**
     * 扩展属性
     */
    private String extend;

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


}
