package cn.com.pcauto.shangjia.ats.controller;


import cn.com.pcauto.shangjia.ats.dto.ResponseMsg;
import cn.com.pcauto.shangjia.ats.entity.UrlDefineTimer;
import cn.com.pcauto.shangjia.ats.exception.AtsException;
import cn.com.pcauto.shangjia.ats.service.UrlDefineTimerService;
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
@RequestMapping("/ats-url-define-timer")
public class UrlDefineTimerController {


    @Autowired
    private UrlDefineTimerService atsUrlDefineTimerService;

    /**
     * 获取定时Url定义定时列表
     *
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<ResponseMsg> listServers(@RequestParam(value = "pageNo",defaultValue ="1",required = false) Integer pageNo,
                                                   @RequestParam(value = "pageSize",defaultValue ="8",required = false) Integer pageSize){

        QueryWrapper<UrlDefineTimer> query = new QueryWrapper<>();

        //设置分页参数
        Page<UrlDefineTimer> page = new Page<>(pageNo, pageSize);
        page = atsUrlDefineTimerService.page(page,query);

        //封装返回体
        ResponseMsg res = new ResponseMsg();
        res.setCode(0)
                .setSub_code("success")
                .setMsg("成功获取定时Url定义定时列表")
                .setData(page.getRecords());
        return ResponseEntity.ok(res);
    }


    /**
     * 查看定时Url定义
     * @param id
     * @return
     */
    @GetMapping("/view")
    public ResponseEntity<ResponseMsg> view(@RequestParam("id") Integer id){

        UrlDefineTimer atsUrlDefineTimer = atsUrlDefineTimerService.getById(id);

        if(atsUrlDefineTimer==null)
            throw new AtsException(1,"定时Url定义 不存在");

        ResponseMsg res = new ResponseMsg();
        res.setCode(0)
                .setSub_code("success")
                .setMsg("成功获取定时Url定义定时数据")
                .setData(atsUrlDefineTimer);

        return ResponseEntity.ok(res);
    }



    /**
     * 更新or修改 定时Url定义信息
     *
     * @return
     */
    @PostMapping("/save")
    public void saveServer(@RequestBody UrlDefineTimer AtsUrlDefineTimer){

        try {
            if(AtsUrlDefineTimer.getId()==null){

                atsUrlDefineTimerService.save(AtsUrlDefineTimer);
            }else {
                atsUrlDefineTimerService.updateById(AtsUrlDefineTimer);
            }
        } catch (Exception e) {
            throw new AtsException(1,"定时Url定义定时信息保存失败");
        }


    }


    /**
     * 删除定时Url定义
     * @param id
     */
    @GetMapping("/delete")
    public void deleteById(@RequestParam("id") Integer id){

        if(id==null || id.intValue()<0){
            throw new AtsException(2,"err.info");
        }
        atsUrlDefineTimerService.removeById(id);
    }

    /**
     * 批量删除URL定义
     * @param ids
     */
    @GetMapping("/deleteBatchUrl")
    public void deleteByIds(@RequestParam("ids") List<Integer> ids){

        try {
            if(!CollectionUtils.isEmpty(ids)){
                atsUrlDefineTimerService.removeByIds(ids);
            }
        } catch (Exception e) {
            throw new AtsException(1,"批量删除URL定义失败");
        }

    }
    
    
    
    

}
