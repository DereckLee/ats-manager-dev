package cn.com.pcauto.shangjia.ats.config;


import cn.com.pcauto.shangjia.ats.utils.IdWorker;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Dereck
 */
@Configuration
public class AtsConfig {


    /**
     * Id生成器，可用于分布式系统
     */
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }


}
