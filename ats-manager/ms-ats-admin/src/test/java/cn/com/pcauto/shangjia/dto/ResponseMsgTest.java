package cn.com.pcauto.shangjia.dto;

import cn.com.pcauto.shangjia.ats.dto.ResponseMsg;
import com.google.gson.Gson;
import org.junit.Test;


/**
 * @author Dereck
 */
public class ResponseMsgTest {

    @Test
    public void testFormat(){

        ResponseMsg msg = new ResponseMsg();
        msg.setCode(0)
                .setMsg("OK")
                .setSub_code("err.auth_failure");
        Gson gson = new Gson();
        String json = gson.toJson(msg);
        System.out.println(json);
    }

}
