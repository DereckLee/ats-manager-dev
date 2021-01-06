package cn.com.pcauto.shangjia.dto;

import cn.com.pcauto.shangjia.ats.entity.AtsServer;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.Date;

public class AtsServerTest {


    @Test
    public void testEntity(){

        Gson gson = new Gson();

        AtsServer server = new AtsServer();
        server.setId(3l)
                .setHost("127.0.0.1")
                .setAgentPort(342)
                .setCreateBy("hfsjf")
                .setCreateTime(new Date())
                .setLevel(2)
                .setNetType(1)
                .setUpdateBy("gds")
                .setUpdateTime(new Date()).setPort(424);

        String s = gson.toJson(server);
        System.out.println("s = " + s);

    }

}
