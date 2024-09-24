package com.ruoyi.CgDsfcpptxt.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import com.ruoyi.CgDsfcpptxt.domain.DisanfangExcwl1;
import com.ruoyi.CgEventType.domain.CgEventType;
import com.ruoyi.CgEventType.service.ICgEventTypeService;
import com.ruoyi.CgTreatDoMat.domain.CgTreatDoMat;
import com.ruoyi.CgTreatDoMat.service.ICgTreatDoMatService;
import com.ruoyi.CgUser.domain.CgUser;
import com.ruoyi.CgUser.service.ICgUserService;
import com.ruoyi.SendEmailUsingQQMail;
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
import com.ruoyi.CgDsfcpptxt.domain.CgDsfcpptxt;
import com.ruoyi.CgDsfcpptxt.service.ICgDsfcpptxtService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 第三方测评平台系统Controller
 *
 * @author ruoyi
 * @date 2024-08-27
 */
@RestController
@RequestMapping("/CgDsfcpptxt/CgDsfcpptxt")
public class CgDsfcpptxtController extends BaseController
{
    @Autowired
    private ICgDsfcpptxtService cgDsfcpptxtService;
    @Autowired
    private ICgUserService cgUserService;
    @Autowired
    private ICgEventTypeService cgEventTypeService;
    @Autowired
    private ICgTreatDoMatService cgTreatDoMatService;
    /**
     * 查询第三方测评平台系统列表
     */
    @PreAuthorize("@ss.hasPermi('CgDsfcpptxt:CgDsfcpptxt:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgDsfcpptxt cgDsfcpptxt)
    {
        startPage();
        List<CgDsfcpptxt> list = cgDsfcpptxtService.selectCgDsfcpptxtList(cgDsfcpptxt);
        return getDataTable(list);
    }

    /**
     * 导出第三方测评平台系统列表
     */
    @PreAuthorize("@ss.hasPermi('CgDsfcpptxt:CgDsfcpptxt:export')")
    @Log(title = "第三方测评平台系统", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgDsfcpptxt cgDsfcpptxt)
    {
        List<CgDsfcpptxt> list = cgDsfcpptxtService.selectCgDsfcpptxtList(cgDsfcpptxt);
        ExcelUtil<CgDsfcpptxt> util = new ExcelUtil<CgDsfcpptxt>(CgDsfcpptxt.class);
        util.exportExcel(response, list, "第三方测评平台系统数据");
    }

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public Map<String,Object> importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DisanfangExcwl1> util = new ExcelUtil<DisanfangExcwl1>(DisanfangExcwl1.class);
        List<DisanfangExcwl1> cgDsfcpptxtList = util.importExcel(file.getInputStream());
        String cpbhNo="";
        Map<String,Object> map11=new HashMap<>();
       for (int a=0;a<cgDsfcpptxtList.size();a++){

           CgDsfcpptxt cgDsfcpptxt1=new CgDsfcpptxt();
           cgDsfcpptxt1.setCode(cgDsfcpptxtList.get(a).getCepingxuhao());
           List<CgDsfcpptxt> listCgDsfcpptxt=cgDsfcpptxtService.selectCgDsfcpptxtList(cgDsfcpptxt1);
           if(listCgDsfcpptxt.size()>0){
               cpbhNo=cpbhNo+cgDsfcpptxtList.get(a).getCepingxuhao()+"-";
               continue;
           }
           CgUser cgUser=new CgUser();
           cgUser.getParams().put("name",cgDsfcpptxtList.get(a).getcName());
           List<CgUser> list=cgUserService.selectCgUserList(cgUser);



           cgDsfcpptxtList.get(a).setYingkoufenzhi(cgDsfcpptxtList.get(a).getYingkoufenzhi().replace(" ",""));
           String trimmedInput = cgDsfcpptxtList.get(a).getYingkoufenzhi().replace(" ","");
           // 将字符串转换为double
           double num = Double.parseDouble(trimmedInput);
           CgDsfcpptxt cgDsfcpptxt=new CgDsfcpptxt();
           cgDsfcpptxt.setCode(cgDsfcpptxtList.get(a).getCepingxuhao());
           cgDsfcpptxt.setSsjb(cgDsfcpptxtList.get(a).getSuoshujieban());
           cgDsfcpptxt.setCplx(cgDsfcpptxtList.get(a).getCepingleixing());
           cgDsfcpptxt.setCpnr(cgDsfcpptxtList.get(a).getCepingneirong());
           cgDsfcpptxt.setYkfz(num);
           cgDsfcpptxt.setWz(cgDsfcpptxtList.get(a).getWeizhi());
           cgDsfcpptxt.setZt(cgDsfcpptxtList.get(a).getZhuangtai());
           cgDsfcpptxt.setZbsj(cgDsfcpptxtList.get(a).getZhuanbanshijian());
           cgDsfcpptxt.setZgqk(cgDsfcpptxtList.get(a).getZhenggaiqingkuang());
           cgDsfcpptxt.setZgsj(cgDsfcpptxtList.get(a).getZhuanbanshijian());
           cgDsfcpptxt.setFhsj(cgDsfcpptxtList.get(a).getFuheshijian());
           cgDsfcpptxt.setJasj(cgDsfcpptxtList.get(a).getJieanshijian());
           cgDsfcpptxt.setZgsj(cgDsfcpptxtList.get(a).getZhenggaishijian());
           cgDsfcpptxt.setZgqx(cgDsfcpptxtList.get(a).getZhenggaiqixian());
           String code = cgDsfcpptxt.getCode().replace(" ","");

           String imgs1="http://39.100.77.115:9511/UploadImg/"+code+"1.jpg";
           String imgs2="http://39.100.77.115:9511/UploadImg/"+code+"4.jpg";
           cgDsfcpptxt.setCgDImgs(imgs1+","+imgs2);
           if(list.size()>0){
               cgDsfcpptxt.setCgCld(list.get(0).getTeamId());
               cgDsfcpptxt.setCgClr(list.get(0).getId());
           }
           cgDsfcpptxt.setIsEmail(1L);//发送成功
           try{
               SendEmailUsingQQMail.toSendEmail(list.get(0).getEmail(),"代办事件类型："+cgDsfcpptxt.getCplx()+"。内容："+cgDsfcpptxt.getCpnr());
           }catch (Throwable t){
               System.out.printf("奇艺高清");
               cgDsfcpptxt.setIsEmail(2L);//发送失败
           }
           cgDsfcpptxtService.insertCgDsfcpptxt(cgDsfcpptxt);

           //添加自己写的待办事项上去
           CgTreatDoMat cgTreatDoMat=new CgTreatDoMat();
           cgTreatDoMat.settTId(12L);
           cgTreatDoMat.setuTId(80L);
           cgTreatDoMat.setTypePt("1");

           String timeTotal=cgDsfcpptxt.getZgqx().replace("小时内","");
           timeTotal=timeTotal.replace(" ","");

           int timeTotalInt = Integer.parseInt(timeTotal);

//           查询待办事件类型
           CgEventType cgEventType=new CgEventType();
           cgEventType.setType("1");
           cgEventType.setName(cgDsfcpptxt.getCplx());
           cgEventType.setNumDay((long) (timeTotalInt/24));
           List<CgEventType> cgEventTypeList=  cgEventTypeService.selectCgEventTypeList(cgEventType);
            if(cgEventTypeList.size()>0){
                cgTreatDoMat.setType(cgEventTypeList.get(0).getId());
            }else{
                cgEventTypeService.insertCgEventType(cgEventType);
                cgTreatDoMat.setType(cgEventType.getId());
            }
           cgTreatDoMat.setTitle("");
           cgTreatDoMat.setContent(cgDsfcpptxt.getCpnr());
           cgTreatDoMat.setImgs(cgDsfcpptxt.getCgDImgs());
//           获取规定的结案时间
           Date endtime=strZhuanTime(cgDsfcpptxt.getZbsj(),timeTotalInt);
           cgTreatDoMat.setEndTime(endtime);
           cgTreatDoMat.setStatus(1L);
           cgTreatDoMat.setpCode(cgDsfcpptxt.getCode());
           cgTreatDoMatService.insertCgTreatDoMat(cgTreatDoMat);
           System.out.printf("cgDsfcpptxtList"+cgDsfcpptxtList.get(a).toString());
       }
        if(cpbhNo.indexOf("-")>=0){
            cpbhNo.substring(0, cpbhNo.length() - 1);
            map11.put("count",cpbhNo.split("-"));
            map11.put("msg",cpbhNo.split("-").length+"条未上传成功");
            map11.put("code",200);
        }else{
            map11.put("code",200);
            map11.put("msg","全部上传成功");
        }
        return map11;
    }

    public Date strZhuanTime(String dateTimeStr,int hours) throws ParseException {
        // 定义时间字符串
//        String dateTimeStr = "2024-08-06 09:25:52";
        dateTimeStr=dateTimeStr.replace(" ","");
        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss");

        // 将字符串转换为LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);

        // 加上100小时
        LocalDateTime newDateTime = dateTime.plusHours(hours);

        // 格式化新的日期时间并打印
        String newDateTimeStr = newDateTime.format(formatter);
        System.out.println("新的日期时间是: " + newDateTimeStr);





        // 设定日期时间格式
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // 将字符串转换为Date
            Date date = (Date) formatter1.parse(newDateTimeStr);





        return date;
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<CgDsfcpptxt> util = new ExcelUtil<CgDsfcpptxt>(CgDsfcpptxt.class);
        return util.importTemplateExcel("用户数据");
    }


    /**
     * 获取第三方测评平台系统详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgDsfcpptxt:CgDsfcpptxt:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgDsfcpptxtService.selectCgDsfcpptxtById(id));
    }

    /**
     * 新增第三方测评平台系统
     */
    @PreAuthorize("@ss.hasPermi('CgDsfcpptxt:CgDsfcpptxt:add')")
    @Log(title = "第三方测评平台系统", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgDsfcpptxt cgDsfcpptxt)
    {
        return toAjax(cgDsfcpptxtService.insertCgDsfcpptxt(cgDsfcpptxt));
    }

    /**
     * 修改第三方测评平台系统
     */
    @PreAuthorize("@ss.hasPermi('CgDsfcpptxt:CgDsfcpptxt:edit')")
    @Log(title = "第三方测评平台系统", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgDsfcpptxt cgDsfcpptxt)
    {
        return toAjax(cgDsfcpptxtService.updateCgDsfcpptxt(cgDsfcpptxt));
    }

    /**
     * 删除第三方测评平台系统
     */
    @PreAuthorize("@ss.hasPermi('CgDsfcpptxt:CgDsfcpptxt:remove')")
    @Log(title = "第三方测评平台系统", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgDsfcpptxtService.deleteCgDsfcpptxtByIds(ids));
    }
}
