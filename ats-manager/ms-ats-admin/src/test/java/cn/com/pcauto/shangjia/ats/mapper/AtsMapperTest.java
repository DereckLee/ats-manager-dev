package cn.com.pcauto.shangjia.ats.mapper;

import cn.com.pcauto.shangjia.ats.entity.AtsServer;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author Dereck
 * @since
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AtsMapperTest {


    @Resource
    private AtsServerMapper atsServerMapper;

    @Test
    public void testSelectAll(){

        AtsServer atsServer = new AtsServer();
        QueryWrapper<AtsServer> query = new QueryWrapper<>(atsServer);

        List<AtsServer> list = atsServerMapper.selectList(query);
        list.forEach(System.out::println);

    }

}
