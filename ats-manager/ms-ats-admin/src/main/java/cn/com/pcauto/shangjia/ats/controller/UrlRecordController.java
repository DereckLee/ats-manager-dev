package cn.com.pcauto.shangjia.ats.controller;


import cn.com.pcauto.shangjia.ats.dto.ResponseMsg;
import cn.com.pcauto.shangjia.ats.entity.UrlRecord;
import cn.com.pcauto.shangjia.ats.exception.AtsException;
import cn.com.pcauto.shangjia.ats.service.UrlRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  URL实体Controller
 * </p>
 *
 * @author Dereck
 * @since 2021-01-05
 */
@RestController
@RequestMapping("/ats-url-record")
public class UrlRecordController {


    @Autowired
    private UrlRecordService urlRecordService;

    /**
     * 获取URL定义列表
     *
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<ResponseMsg>
                listServers(@RequestParam(value = "pageNo",defaultValue ="1",required = false) Integer pageNo,
                            @RequestParam(value = "pageSize",defaultValue ="8",required = false) Integer pageSize)
    {

        //分表下的分页查询
        List<UrlRecord> urlRecords = urlRecordService.findByPage(pageNo,pageSize);

        //封装返回体
        ResponseMsg res = new ResponseMsg();
        res.setCode(0)
                .setSub_code("success")
                .setMsg("成功获取URL实体分页列表")
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
        //定位表，查询Url定义
        UrlRecord urlRecord = urlRecordService.selectById(id);

        ResponseMsg res = new ResponseMsg();
        res.setCode(0)
                .setSub_code("success")
                .setMsg("成功获取URL定义数据")
                .setData(urlRecord);

        return ResponseEntity.ok(res);
    }



    /**
     * 更新or修改 URL定义信息
     *
     * @return
     */
    @PostMapping("/save")
    public void saveServer(@RequestBody UrlRecord urlRecord){

        try {
            if(urlRecord.getId()== null){
                //分表插入
                urlRecordService.saveDynamically(urlRecord);
            }else {
                //定位表，更新
                urlRecordService.updateByIdDynamically(urlRecord);
            }
        } catch (Exception e) {
            throw new AtsException(1,"URL定义信息保存失败");
        }

    }


    /**
     * 删除URL实体
     * @param id
     */
    @GetMapping("/delete")
    public void deleteById(@RequestParam("id") Long id){

        if(id==null || id.longValue()<0 ||id.longValue()>99){
            throw new AtsException(1,"err.info");
        }
        //获取数据存储的表
        UrlRecord urlRecord = new UrlRecord();
        urlRecord.setId(id);
        Integer tabNo = urlRecord.getTabNo();
        urlRecordService.removeByIdAndTaNo(id,tabNo);
    }



}
