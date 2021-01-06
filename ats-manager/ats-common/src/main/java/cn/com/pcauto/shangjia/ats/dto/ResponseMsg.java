package cn.com.pcauto.shangjia.ats.dto;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 统一的信息返回
 * @author Dereck
 */
@Data
@Accessors(chain = true)
public class ResponseMsg {

    //默认状态码：0=>success,[0,99]
    private Integer code = 0;
    private String msg = "";//提示信息
    private String sub_code = "succeed";//错误码 ==> code(对应）
    private Object data = new Object();//业务数据，无返回{}
}
