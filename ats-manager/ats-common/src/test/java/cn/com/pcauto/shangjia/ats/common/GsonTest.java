package cn.com.pcauto.shangjia.ats.common;

import cn.com.pcauto.shangjia.ats.dto.AuthInfo;
import cn.com.pcauto.shangjia.ats.dto.RequestMsg;
import cn.com.pcauto.shangjia.ats.dto.ResponseMsg;
import cn.com.pcauto.shangjia.ats.entity.AtsServer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Test;

import javax.xml.ws.Response;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GsonTest {

    @Test
    public void test(){
        ResponseMsg msg = new ResponseMsg();
        Map<String,Object> map = new HashMap<>();
        map.put("_id",23583);
        //msg.setData(map);
        Gson gson = new Gson();
        String json = gson.toJson(msg);
        System.out.println("json = " + json);

    }

    @Test
    public void testRevParam(){
        ObjectMapper objectMapper = new ObjectMapper();



    }

    @Test
    public void testA(){



    }

}
