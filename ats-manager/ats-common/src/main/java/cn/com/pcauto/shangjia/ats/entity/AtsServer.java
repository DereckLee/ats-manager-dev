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
@TableName("ats_server")
public class AtsServer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Long id;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 主机
     */
    private String host;

    /**
     * ats服务端口
     */
    private Integer port;

    /**
     * ats代理端口
     */
    private Integer agentPort;

    /**
     * 网络方式，1：内网，2：外网
     */
    private Integer netType;

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
