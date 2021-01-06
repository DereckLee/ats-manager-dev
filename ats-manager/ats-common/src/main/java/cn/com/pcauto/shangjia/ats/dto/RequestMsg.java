package cn.com.pcauto.shangjia.ats.dto;


import com.google.gson.Gson;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


/**
 * @author Dereck
 */
@Data
public class RequestMsg<T> {
    private AuthInfo authInfo;//基础数据
    private Map<String,Object> data;//业务参数

    @Autowired
    private Gson gson;

    /**
     *
     * @return
     */
    public T getRequestBody(Class<T> type){
        Gson gson = new Gson();
        String json = gson.toJson(this.data);
        return gson.fromJson(json,type);
    }

}
