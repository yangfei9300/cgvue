package com.ruoyi.CgAttendance.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.CgUser.domain.CgUser;
import com.ruoyi.CgUser.service.ICgUserService;
import com.ruoyi.DateUtils;
import com.ruoyi.Main1;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
import com.ruoyi.CgAttendance.domain.CgAttendance;
import com.ruoyi.CgAttendance.service.ICgAttendanceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 考勤（每天00点更新）Controller
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
@RestController
@RequestMapping("/CgAttendance/CgAttendance")
@Component("kaoqin")
public class CgAttendanceController extends BaseController
{
    @Autowired
    private ICgAttendanceService cgAttendanceService;
    @Autowired
    private ICgUserService cgUserService;

    /**
     * 查询考勤（每天00点更新）列表
     */
    @PreAuthorize("@ss.hasPermi('CgAttendance:CgAttendance:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgAttendance cgAttendance)
    {
        startPage();
        List<CgAttendance> list = cgAttendanceService.selectCgAttendanceList(cgAttendance);
        return getDataTable(list);
    }

    @PostMapping("/getKaoqinList")
    public TableDataInfo getKaoqinList(@RequestBody CgAttendance cgAttendance)
    {
        startPage();
        List<CgAttendance> list = cgAttendanceService.selectCgAttendanceList(cgAttendance);
        return getDataTable(list);
    }

//定时任务，每月零点执行 生成考勤
//    @PostMapping("/ase")
//    public void newKaoqin(String name){
////        获取所有得人
//        CgUser cgUser=new CgUser();
//        List<CgUser> cgList=cgUserService.selectCgUserList(cgUser);
//        for(int a=0;a<cgList.size();a++){
//            CgAttendance cgAttendance=new CgAttendance();
//            cgAttendance.setuId(cgList.get(a).getId());
//            cgAttendance.getParams().put("year",DateUtils12.getYM().split(",")[0]);
//            cgAttendance.getParams().put("month",DateUtils12.getYM().split(",")[1]);
//            List<CgAttendance> cgAttendanceList=cgAttendanceService.getKqList(cgAttendance);
//            if(cgAttendanceList.size()==0){
//                    String [][] monthdays= DateUtils.getMonthInfos();
//                    for(int b=0;b<monthdays.length;b++){
//                        CgAttendance cgAttendance2=new CgAttendance();
//                        cgAttendance2.setuId(cgList.get(a).getId());
//                        cgAttendance2.setAttendDate(DateUtils.strZhaunDate(monthdays[a][0]));
//                        cgAttendance2.setWeekNum(monthdays[a][1]);
//                        cgAttendanceService.insertCgAttendance(cgAttendance2);
//                    }
//            }
//        }
//
//    }

    @PostMapping("/getHoutaiKaoqinList")
    public TableDataInfo getHoutaiKaoqinList(@RequestBody CgAttendance cgAttendance)
    {
        startPage();
        List<CgAttendance> list = cgAttendanceService.getHoutaiKaoqinList(cgAttendance);
        return getDataTable(list);
    }



    /**
     * 导出考勤（每天00点更新）列表
     */
    @PreAuthorize("@ss.hasPermi('CgAttendance:CgAttendance:export')")
    @Log(title = "考勤（每天00点更新）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgAttendance cgAttendance)
    {
        List<CgAttendance> list = cgAttendanceService.selectCgAttendanceList(cgAttendance);
        ExcelUtil<CgAttendance> util = new ExcelUtil<CgAttendance>(CgAttendance.class);
        util.exportExcel(response, list, "考勤（每天00点更新）数据");
    }


    @PostMapping("/exportKaoqin")
    public void exportKaoqin(HttpServletResponse response, HttpServletRequest request, CgUser cgUser) throws IOException {

        List<CgUser> listUsers = cgUserService.getKqoqinExcel1(cgUser);
        List<List<String>> listStrs=new ArrayList<List<String>>();
//        表格第一行
        List<String> list1=new ArrayList<>();
//        list1.add("");
        for(int a=0;a<listUsers.size();a++){
            list1.add(listUsers.get(a).getName());
        }
        List<String> list2=new ArrayList<>();
        list2.add("");
        for(int a=0;a<listUsers.size();a++){
            list2.add("上午");
            list2.add("下午");
        }
        listStrs.add(list1);
        listStrs.add(list2);


//        for(int a=0;a<listUsers.size();a++){
//            if(listUsers.get(a).getCgAttendanceList().size()<=0){
//                CgAttendance cgAttendance3=new CgAttendance();
//                cgAttendance3.setAttendDate(new Date());
//                cgAttendance3.setuId(listUsers.get(a).getId());
//                // 获取当前日期
//                LocalDate today1 = LocalDate.now();
//                cgAttendance3.getParams().put("year",cgUser.getParams().get("checkIn").toString().split("-")[0]);
//                cgAttendance3.getParams().put("month",cgUser.getParams().get("checkIn").toString().split("-")[1]);
//                //判断是否有考勤表
//                List<CgAttendance> lustCgAttendance1= cgAttendanceService.getKqList(cgAttendance3);
//                if(lustCgAttendance1.size()==0){
//                    String [][] monthdays= DateUtils.getMonthInfos();
//                    for(int b=0;a<monthdays.length;b++){
//                        CgAttendance cgAttendance2=new CgAttendance();
//                        cgAttendance2.setuId(listUsers.get(b).getId());
//                        cgAttendance2.setAttendDate(DateUtils.strZhaunDate(monthdays[b][0]));
//                        cgAttendance2.setWeekNum(monthdays[b][1]);
//                        cgAttendanceService.insertCgAttendance(cgAttendance2);
//                    }
//                }
//            }
//        }
//        listUsers = cgUserService.getKqoqinExcel1(cgUser);

        String[] dates = DateRangeCalculator.calculateDateRangeAsStrings(cgUser.getParams().get("checkIn").toString(),
                cgUser.getParams().get("checkOut").toString());

        for(int a=0;a<dates.length;a++){
            List<String> list3=new ArrayList<>();
            list3.add(dates[a]);
            for(int b=0;b<listUsers.size();b++){
                if(listUsers.get(b).getCgAttendanceList().get(a).getParams()!=null){
                    if(listUsers.get(b).getCgAttendanceList().get(a).getParams().get("check_in_status")!=null){
                        String statusDaka=listUsers.get(b).getCgAttendanceList().get(a).getParams().get("check_in_status").toString();
                        if(statusDaka.equals("1")){
                            list3.add("正常");
                        }else   if(statusDaka.equals("2")){
                            list3.add("迟到");
                        }else   if(statusDaka.equals("3")){
                            list3.add("早退");
                        }
                    }else{
                        list3.add("缺卡");
                    }
                    if(listUsers.get(b).getCgAttendanceList().get(a).getParams().get("check_out_status")!=null){
                        String statusDaka=listUsers.get(b).getCgAttendanceList().get(a).getParams().get("check_out_status").toString();
                        if(statusDaka.equals("1")){
                            list3.add("正常");
                        }else   if(statusDaka.equals("2")){
                            list3.add("迟到");
                        }else   if(statusDaka.equals("3")){
                            list3.add("早退");
                        }
                    }else{
                        list3.add("缺卡");
                    }
                }else{
                    list3.add("缺卡");
                }
            }
            listStrs.add(list3);
        }

        FileOutputStream outputStream=Main1.hebing3(listStrs,response);
        String fileName="文件名称.xlsx";
        try
        {

            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = RuoYiConfig.getDownloadPath() + fileName;

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
        }
        catch (Exception e)
        {
        }
    }




    /**
     * 获取考勤（每天00点更新）详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgAttendance:CgAttendance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgAttendanceService.selectCgAttendanceById(id));
    }

    /**
     * 新增考勤（每天00点更新）
     */
    @PreAuthorize("@ss.hasPermi('CgAttendance:CgAttendance:add')")
    @Log(title = "考勤（每天00点更新）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgAttendance cgAttendance)
    {
        return toAjax(cgAttendanceService.insertCgAttendance(cgAttendance));
    }

    /**
     * 修改考勤（每天00点更新）
     */
    @PreAuthorize("@ss.hasPermi('CgAttendance:CgAttendance:edit')")
    @Log(title = "考勤（每天00点更新）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgAttendance cgAttendance)
    {
        return toAjax(cgAttendanceService.updateCgAttendance(cgAttendance));
    }

    /**
     * 删除考勤（每天00点更新）
     */
    @PreAuthorize("@ss.hasPermi('CgAttendance:CgAttendance:remove')")
    @Log(title = "考勤（每天00点更新）", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgAttendanceService.deleteCgAttendanceByIds(ids));
    }
}
