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
@TableName("ats_url_define")
public class UrlDefine implements Serializable {

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
     * 类别id
     */
    private String classifyId;

    /**
     * url定义的实现类
     */
    private String className;

    /**
     * 刷新优先级
     */
    private Integer priority;

    /**
     * 嵌套优先级
     */
    private Integer relatePriority;

    /**
     * url链接
     */
    private String url;

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

    /**
     * 标志位1
     */
    private Integer tag1;

    /**
     * 标志位2
     */
    private Integer tag2;

    /**
     * 标志位3
     */
    private Integer tag3;

    /**
     * 标志位4
     */
    private Integer tag4;

    /**
     * 标志位5
     */
    private Integer tag5;

    /**
     * 标志位6
     */
    private Integer tag6;

    /**
     * 标志位7
     */
    private Integer tag7;

    /**
     * 标志位8
     */
    private Integer tag8;

    /**
     * 标志位9
     */
    private Integer tag9;

    /**
     * 标志位10
     */
    private Integer tag10;


}
