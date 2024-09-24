package com.ruoyi.CgTreatDoMat.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.CgFileZip.domain.CgFileZip;
import com.ruoyi.CgFileZip.service.ICgFileZipService;
import com.ruoyi.CgTreatDoMat.domain.CgTreatDoMatExcel;
import com.ruoyi.CgTreatDoMat.domain.OrderIdGenerator;
import com.ruoyi.CgTreatDoMat.service.ICgTreatDoMatService;
import com.ruoyi.Main1;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.file.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.CgTreatDoMat.domain.CgTreatDoMat;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 待办事件Controller
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
@RestController
@RequestMapping("/CgTreatDoMat/CgTreatDoMat")
public class CgTreatDoMatController extends BaseController
{
    @Autowired
    private ICgTreatDoMatService cgTreatDoMatService;
    @Autowired
    private ICgFileZipService cgFileZipService;

    /**
     * 查询待办事件列表
     */
    @PreAuthorize("@ss.hasPermi('CgTreatDoMat:CgTreatDoMat:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgTreatDoMat cgTreatDoMat)
    {
        startPage();
//      List<CgTreatDoMat> list = cgTreatDoMatService.selectCgTreatDoMatList(cgTreatDoMat);
        List<CgTreatDoMat> list = cgTreatDoMatService.getShijianList(cgTreatDoMat);
        return getDataTable(list);
    }


    //    导出待办事项相关图片
    @PostMapping("/exportImgs")
    public  Map<String, Object>  exportImgs(@RequestBody CgTreatDoMat cgTreatDoMat) throws IOException {
        Map<String, Object> map=new HashMap<>();
        cgTreatDoMat.getParams().put("status1","3_4");
        List<CgTreatDoMat> list = cgTreatDoMatService.getShijianList(cgTreatDoMat);
        List<CgTreatDoMatExcel> listExcel=new ArrayList<CgTreatDoMatExcel>();
        List<String> wenjianjias=new ArrayList<>();
        List<List<String>> imgssss=new ArrayList<>();
        for (int a=0;a<list.size();a++){
            String imgss=list.get(a).getImgs();
            String img []=imgss.split(",");
            if(img[0].indexOf("http")==-1){
                for (int b=0;b<img.length;b++){
                    img[b]="https://localhost:9013";
                }
            }else{
                wenjianjias.add(list.get(a).getpCode());
                List<String> iimg=new ArrayList<>();
                for (int b=0;b<img.length;b++){
                    iimg.add(img[b]);
                }
                imgssss.add(iimg);
            }
        }
        DownloadAndZipImages1 downloadAndZipImages1=new DownloadAndZipImages1();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        String filename="压缩包（"+formattedDateTime+"）";
        downloadAndZipImages1.getZip(wenjianjias,imgssss,filename);

        CgFileZip cgFileZip=new CgFileZip();
        cgFileZip.setFileAddress("https://cgjava.zsyflive.com/profile/"+filename+".zip");
        cgFileZip.setFilename(filename);
        cgFileZip.setCreateTime(new Date());

        cgFileZipService.insertCgFileZip(cgFileZip);


        map.put("zip","https://cgjava.zsyflive.com/profile/%E5%9B%BE%E7%89%87%E9%9B%86%E5%90%88.zip");

        return map;
    }



    /**
     * 导出待办事件列表
     */
    @PreAuthorize("@ss.hasPermi('CgTreatDoMat:CgTreatDoMat:export')")
    @Log(title = "待办事件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgTreatDoMat cgTreatDoMat)
    {
        List<CgTreatDoMat> list = cgTreatDoMatService.getShijianList(cgTreatDoMat);
        List<CgTreatDoMatExcel> listExcel=new ArrayList<CgTreatDoMatExcel>();
        for(int a=0;a<list.size();a++){
            CgTreatDoMatExcel obg=new CgTreatDoMatExcel();
            obg.setContent(list.get(a).getContent());
            obg.setTitle(list.get(a).getTitle());
            obg.setId((long)a);
            obg.setEndTime(list.get(a).getEndTime());
            if(list.get(a).getParams().get("ttname")!=null){
                obg.settTId(list.get(a).getParams().get("ttname").toString());
            }
            if(list.get(a).getParams().get("tuname")!=null){
                obg.setuTId(list.get(a).getParams().get("tuname").toString());
            }
            if(list.get(a).getParams().get("ctname")!=null){
                obg.setcTId(list.get(a).getParams().get("ctname").toString());
            }
            if(list.get(a).getParams().get("cuname")!=null){
               obg.setcUId(list.get(a).getParams().get("cuname").toString());
            }
            obg.setResultContent(list.get(a).getResultContent());
            obg.setResultEndTime(list.get(a).getResultEndTime());
            obg.setResultStartTime(list.get(a).getResultStartTime());
            obg.setFenNum(list.get(a).getFenNum());
            if(list.get(a).getParams().get("type_name")!=null){
                obg.setType(list.get(a).getParams().get("type_name").toString());
            }
//            obg.setWanTime(list.get(a).getWanTime());
            obg.setFenRemark(list.get(a).getFenRemark());
            obg.setFenTime(list.get(a).getFenTime());
            String  statuss[]=new String [4];
            statuss[0]= "已提交";
            statuss[1]= "处理中";
            statuss[2]= "处理完成";
            statuss[3]= "已打分";
            obg.setStatus(statuss[(int)(list.get(a).getStatus()-1)]);
            listExcel.add(obg);
        }
        ExcelUtil<CgTreatDoMatExcel> util = new ExcelUtil<CgTreatDoMatExcel>(CgTreatDoMatExcel.class);
        util.exportExcel(response, listExcel, "待办事件数据");
    }

    /**
     * 获取待办事件详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgTreatDoMat:CgTreatDoMat:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgTreatDoMatService.selectCgTreatDoMatById(id));
    }

    /**
     * 新增待办事件
     */
    @PreAuthorize("@ss.hasPermi('CgTreatDoMat:CgTreatDoMat:add')")
    @Log(title = "待办事件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgTreatDoMat cgTreatDoMat)
    {
        OrderIdGenerator orderIdGenerator=new OrderIdGenerator();
        cgTreatDoMat.setpCode(orderIdGenerator.generateOrderId());
        return toAjax(cgTreatDoMatService.insertCgTreatDoMat(cgTreatDoMat));
    }

    /**
     * 修改待办事件
     */
    @PreAuthorize("@ss.hasPermi('CgTreatDoMat:CgTreatDoMat:edit')")
    @Log(title = "待办事件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgTreatDoMat cgTreatDoMat)
    {
        return toAjax(cgTreatDoMatService.updateCgTreatDoMat(cgTreatDoMat));
    }

//    @PostMapping("/dafenDbsj")
//    public AjaxResult dafenDbsj(@RequestBody CgTreatDoMat cgTreatDoMat)
//    {
////        cgTreatDoMat.set
//        return toAjax(cgTreatDoMatService.updateCgTreatDoMat(cgTreatDoMat));
//    }



    /**
     * 删除待办事件
     */
    @PreAuthorize("@ss.hasPermi('CgTreatDoMat:CgTreatDoMat:remove')")
    @Log(title = "待办事件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgTreatDoMatService.deleteCgTreatDoMatByIds(ids));
    }
}
