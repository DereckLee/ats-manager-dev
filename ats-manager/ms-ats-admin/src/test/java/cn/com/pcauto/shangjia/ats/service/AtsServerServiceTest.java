package cn.com.pcauto.shangjia.ats.service;


import cn.com.pcauto.shangjia.ats.entity.AtsServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 *
 * @author Dereck
 * @since
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AtsServerServiceTest {

    @Autowired
    private AtsServerService atsServerService;



    @Test
    public void testListServers(){
        List<AtsServer> list = atsServerService.list();
        list.forEach(System.out::println);
    }


}