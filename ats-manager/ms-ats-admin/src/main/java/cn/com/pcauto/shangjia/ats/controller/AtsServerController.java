package cn.com.pcauto.shangjia.ats.controller;


import cn.com.pcauto.shangjia.ats.dto.RequestMsg;
import cn.com.pcauto.shangjia.ats.dto.ResponseMsg;
import cn.com.pcauto.shangjia.ats.entity.AtsServer;
import cn.com.pcauto.shangjia.ats.exception.AtsException;
import cn.com.pcauto.shangjia.ats.service.AtsServerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Dereck
 * @since 2021-01-05
 */
@Slf4j
@RestController
@RequestMapping("/ats_server")
public class AtsServerController {

    @Autowired
    private AtsServerService atsServerService;

    /**
     * 获取服务器列表
     *
     * @return
     */
    @GetMapping("/server_list")
    public ResponseEntity<ResponseMsg> listServers(@RequestParam(value = "pageNo",defaultValue ="1",required = false) Integer pageNo,
                                                   @RequestParam(value = "pageSize",defaultValue ="8",required = false) Integer pageSize){

        QueryWrapper<AtsServer> query = new QueryWrapper<>();

        //设置分页参数
        Page<AtsServer> page = new Page<>(pageNo, pageSize);
        page = atsServerService.page(page,query);

        //封装返回体
        ResponseMsg res = new ResponseMsg();
        res.setCode(0)
                .setSub_code("success")
                .setMsg("成功获取URL定义列表")
                .setData(page.getRecords());
        return ResponseEntity.ok(res);
    }

    /**
     * 查看
     * 入参{id:xxx}
     * @param
     * @return
     */
    //@GetMapping("/view")
    @PostMapping("/view")
    public ResponseEntity<ResponseMsg> viewServer(@RequestBody RequestMsg<Integer> requestMsg){

        //
        Integer id = (Integer) requestMsg.getData().get("id");

        AtsServer server = atsServerService.getById(id);
        if(server == null)
            throw new AtsException(1,"服务器不存在");

        ResponseMsg res = new ResponseMsg();
        res.setCode(0)
                .setSub_code("success")
                .setMsg("成功获取服务器信息")
                .setData(server);

        return ResponseEntity.ok(res);
    }



    /**
     * 更新or修改 服务器信息
     *
     * @return
     */
    @PostMapping("/save")
    public void saveServer(@RequestBody RequestMsg<AtsServer> request){

        AtsServer atsServer = request.getRequestBody(AtsServer.class);
        try {
            if(atsServer.getId()==null){
                //
                atsServerService.save(atsServer);
            }else {
                //
                atsServerService.updateById(atsServer);
            }
        } catch (Exception e) {
            throw new AtsException(1,"服务器信息保存失败");
        }
    }

    /**
     *
     * @param
     */
    @PostMapping("/delete")
    public void deleteById(@RequestBody RequestMsg<AtsServer> request){
        Integer id = (Integer) request.getData().get("id");
        if(id==null || id.intValue()<0 ||id.intValue()>99){
            throw new AtsException(2,"err.info");
        }
        atsServerService.removeById(id);
    }

}
