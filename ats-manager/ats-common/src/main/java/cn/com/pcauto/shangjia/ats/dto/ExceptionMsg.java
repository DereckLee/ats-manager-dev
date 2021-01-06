package cn.com.pcauto.shangjia.ats.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Setter
@Getter
public class ExceptionMsg {

    private String msName;
    private String user;
    private String msUrl;
    private String referer;
    private Date time;
    private String exception;
    private Integer code;
    private String msg;
}
