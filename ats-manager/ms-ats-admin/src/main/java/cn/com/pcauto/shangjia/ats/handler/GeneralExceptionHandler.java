package cn.com.pcauto.shangjia.ats.handler;


import cn.com.pcauto.shangjia.ats.dto.ExceptionMsg;
import cn.com.pcauto.shangjia.ats.exception.AtsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 全局的异常处理
 * @author Dereck
 */
@ControllerAdvice
@ResponseBody
public class GeneralExceptionHandler {


    @ExceptionHandler(value= Exception.class)
    public ResponseEntity<ExceptionMsg> exceptionHandler(HttpServletRequest request, Exception e){
        AtsException myException = null;
        ExceptionMsg msg = new ExceptionMsg();

        if(e instanceof AtsException){
            myException = (AtsException) e;
            msg.setMsg(myException.getMsg());

        }else {
            msg.setMsg(e.getMessage());
        }
        msg.setCode(1)
                .setException(e.getStackTrace().toString())
                .setMsName("ms-ats-admin")//Temp
                .setMsUrl(request.getRequestURL().toString())
                .setReferer(request.getHeader("referer"))
                .setTime(new Date())//temp
                .setUser("user_name");
        return ResponseEntity.ok(msg);
    }
}
