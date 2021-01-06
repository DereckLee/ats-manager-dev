package cn.com.pcauto.shangjia.mapper;

import cn.com.pcauto.shangjia.ats.ATSAdminApplication;
import cn.com.pcauto.shangjia.ats.entity.UrlRecord;
import cn.com.pcauto.shangjia.ats.mapper.UrlRecordMapper;
import cn.com.pcauto.shangjia.ats.service.UrlRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@SpringBootTest(classes = ATSAdminApplication.class)
@RunWith(SpringRunner.class)
public class InsertionTest {


    @Resource
    private UrlRecordMapper atsUrlRecordMapper;

    @Resource
    private UrlRecordService atsUrlRecordService;


    @Test
    public void testInsert(){

        UrlRecord record = new UrlRecord();
        record.setDefineId(3l)
                .setUrl("kkkkkk")
                .setMd5Content("ooooo")
                .setMd5Url("llllll");

        atsUrlRecordService.saveDynamically(record);


    }

}