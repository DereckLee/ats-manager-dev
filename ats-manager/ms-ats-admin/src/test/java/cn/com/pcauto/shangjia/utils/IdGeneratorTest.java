package cn.com.pcauto.shangjia.utils;


import cn.com.pcauto.shangjia.ats.utils.IdWorker;
import org.junit.Test;

/**
 *
 * @author Dereck
 */
public class IdGeneratorTest {



    @Test
    public void testIdGen(){


        IdWorker idWorker = new IdWorker(1, 1);

        long id = idWorker.nextId();
        System.out.println(id);
        id = idWorker.nextId();
        System.out.println(id);
        id = idWorker.nextId();
        System.out.println(id);

    }

}
