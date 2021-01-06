package cn.com.pcauto.shangjia.ats.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtsException extends RuntimeException{

    //统一返回的异常信息
    private String msg;
    private Integer code;

    public AtsException(Integer code, String msg) {
        super();
        this.msg = msg;
        this.code=code;
    }
}
