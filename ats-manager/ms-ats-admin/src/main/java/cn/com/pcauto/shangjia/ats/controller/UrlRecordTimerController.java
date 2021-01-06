package cn.com.pcauto.shangjia.ats.controller;


import cn.com.pcauto.shangjia.ats.dto.ResponseMsg;
import cn.com.pcauto.shangjia.ats.entity.UrlRecord;
import cn.com.pcauto.shangjia.ats.entity.UrlRecordTimer;
import cn.com.pcauto.shangjia.ats.exception.AtsException;
import cn.com.pcauto.shangjia.ats.service.UrlRecordTimerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/ats-url-record-timer")
public class UrlRecordTimerController {

    @Autowired
    private UrlRecordTimerService atsUrlRecordTimerService;


    /**
     * 获取URL定义列表
     *
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<ResponseMsg> listServers(@RequestParam(value = "pageNo",defaultValue ="1",required = false) Integer pageNo,
                                                   @RequestParam(value = "pageSize",defaultValue ="8",required = false) Integer pageSize){

        List<UrlRecord> urlRecords =
                atsUrlRecordTimerService.findByPage(pageNo,pageSize);

        //封装返回体
        ResponseMsg res = new ResponseMsg();
        res.setCode(0)
                .setSub_code("success")
                .setMsg("成功获取URL定义列表")
                .setData(urlRecords);
        return ResponseEntity.ok(res);
    }

    /**
     * 查看Url定义
     * @param id
     * @return
     */
    @GetMapping("/view")
    public ResponseEntity<ResponseMsg> view(@RequestParam("id") Long id){
        //到对应表查询URL实体
        UrlRecordTimer AtsUrlRecordTimer = atsUrlRecordTimerService.selectById(id);

        if(AtsUrlRecordTimer==null)
            throw new AtsException(1,"URL定义不存在");

        ResponseMsg res = new ResponseMsg();
        res.setCode(0)
                .setSub_code("success")
                .setMsg("成功获取URL定义数据")
                .setData(AtsUrlRecordTimer);

        return ResponseEntity.ok(res);
    }



    /**
     * 更新or修改 URL定义信息
     *
     * @return
     */
    @PostMapping("/save")
    public void saveServer(@RequestBody UrlRecordTimer AtsUrlRecordTimer){

        try {
            if(AtsUrlRecordTimer.getId()==null){
                //分表插入
                atsUrlRecordTimerService.saveDynamically(AtsUrlRecordTimer);

            }else {
                atsUrlRecordTimerService.updateById(AtsUrlRecordTimer);
            }
        } catch (Exception e) {
            throw new AtsException(1,"URL定义信息保存失败");
        }


    }


    /**
     * 删除URL定义
     * @param id
     */
    @GetMapping("/delete")
    public void deleteById(@RequestParam("id") Long id){

        if(id==null || id.intValue()<0){
            throw new AtsException(2,"err.info");
        }
        atsUrlRecordTimerService.removeById(id);
    }
    
    
    
    
    
}
