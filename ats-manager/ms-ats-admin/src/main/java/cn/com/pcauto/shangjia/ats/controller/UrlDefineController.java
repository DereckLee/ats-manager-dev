package cn.com.pcauto.shangjia.ats.controller;


import cn.com.pcauto.shangjia.ats.dto.RequestMsg;
import cn.com.pcauto.shangjia.ats.dto.ResponseMsg;
import cn.com.pcauto.shangjia.ats.entity.UrlDefine;
import cn.com.pcauto.shangjia.ats.exception.AtsException;
import cn.com.pcauto.shangjia.ats.service.UrlDefineService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Dereck
 * @since 2021-01-05
 */
@RestController
@RequestMapping("/ats-url-define")
public class UrlDefineController {


    @Autowired
    private UrlDefineService atsUrlDefineService;

    /**
     * 获取URL定义列表
     *
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<ResponseMsg>
            listServers(@RequestParam(value = "pageNo",defaultValue ="1",required = false) Integer pageNo,
                        @RequestParam(value = "pageSize",defaultValue ="8",required = false) Integer pageSize){

        QueryWrapper<UrlDefine> query = new QueryWrapper<>();

        //设置分页参数
        Page<UrlDefine> page = new Page<>(pageNo, pageSize);
        page = atsUrlDefineService.page(page,query);

        //封装返回体
        ResponseMsg res = new ResponseMsg();
        res.setCode(0)
                .setSub_code("success")
                .setMsg("成功获取URL定义列表")
                .setData(page.getRecords());
        return ResponseEntity.ok(res);
    }


    /**
     * 查看Url定义
     * @param
     * @return
     */
    @PostMapping("/view")
    public ResponseEntity<ResponseMsg> view(@RequestBody RequestMsg<Integer> requestMsg){
        Integer id = (Integer) requestMsg.getData().get("id");
        UrlDefine atsUrlDefine = atsUrlDefineService.getById(id);

        if(atsUrlDefine==null)
            throw new AtsException(1,"URL定义不存在");

        ResponseMsg res = new ResponseMsg();
        res.setCode(0)
                .setSub_code("success")
                .setMsg("成功获取URL定义数据")
                .setData(atsUrlDefine);

        return ResponseEntity.ok(res);
    }



    /**
     * 更新or修改 URL定义信息
     *
     * @return
     */
    @PostMapping("/save")
    public void saveServer(@RequestBody RequestMsg<UrlDefine> requestMsg){

        UrlDefine urlDefine = requestMsg.getRequestBody(UrlDefine.class);
        try {
            if(urlDefine.getId()==null){

                atsUrlDefineService.save(urlDefine);
            }else {
                atsUrlDefineService.updateById(urlDefine);
            }
        } catch (Exception e) {
            throw new AtsException(1,"URL定义信息保存失败");
        }


    }


    /**
     * 删除URL定义
     * @param id
     */
    @PostMapping("/delete")
    public void deleteById(@RequestParam("id") Integer id){

        if(id==null || id.intValue()<0){
            throw new AtsException(2,"err.info");
        }
        atsUrlDefineService.removeById(id);
    }

    /**
     * 批量删除URL定义
     * @param ids
     */
    @PostMapping("/deleteBatchUrl")
    public void deleteByIds(@RequestParam("ids") List<Integer> ids){

        if(!CollectionUtils.isEmpty(ids)){
            atsUrlDefineService.removeByIds(ids);
        }
    }





}
