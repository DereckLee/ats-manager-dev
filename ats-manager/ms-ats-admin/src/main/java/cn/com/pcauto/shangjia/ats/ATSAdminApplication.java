package cn.com.pcauto.shangjia.ats;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.com.pcauto.shangjia.ats.mapper")
public class ATSAdminApplication {


    public static void main(String[] args) {

        SpringApplication.run(ATSAdminApplication.class, args);
    }


    //分布式的ID生成器

}
