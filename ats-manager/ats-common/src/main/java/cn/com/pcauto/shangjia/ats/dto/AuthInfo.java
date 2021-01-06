package cn.com.pcauto.shangjia.ats.dto;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 *
 * @author Dereck
 */
@Data
@Accessors(chain = true)
public class AuthInfo {

    private Integer dealerId;
    private String cookie;
    private String user;
    private String referrer;

}
