package com.ruoyi.web.controller.api;

import com.ruoyi.CgAttendance.domain.CgAttendance;
import com.ruoyi.CgAttendance.service.ICgAttendanceService;
import com.ruoyi.CgUser.domain.CgUser;
import com.ruoyi.DateUtils;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/public")
public class UtilsApi {

    @Autowired
    private ICgAttendanceService cgAttendanceService;

    //    生成一个人一月的考勤表
    @PostMapping("/tonewUserKaoqin")
    public Map<String, Object> tonewUserKaoqin(@RequestBody CgAttendance cgAttendance)
    {
        Map<String,Object> map=new HashMap<>();
        cgAttendance.setAttendDate(new Date());
        // 获取当前日期
        LocalDate today = LocalDate.now();
        cgAttendance.getParams().put("year",today.getYear());
        cgAttendance.getParams().put("month",today.getMonthValue());
        //判断是否有考勤表
        List<CgAttendance> lustCgAttendance= cgAttendanceService.getKqList(cgAttendance);
        if(lustCgAttendance.size()==0){
            String [][] monthdays= DateUtils.getMonthInfos();
            for(int a=0;a<monthdays.length;a++){
                CgAttendance cgAttendance1=new CgAttendance();
                cgAttendance1.setuId(cgAttendance.getuId());
                cgAttendance1.setAttendDate(DateUtils.strZhaunDate(monthdays[a][0]));
                cgAttendance1.setWeekNum(monthdays[a][1]);
                cgAttendanceService.insertCgAttendance(cgAttendance1);
            }
        }
        map.put("msg","操作成功");
        map.put("code",200);
        return map;
    }


    @Autowired
    private ServerConfig serverConfig;
    @PostMapping("/upload")
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("url", url);
            ajax.put("fileName", fileName);
            ajax.put("newFileName", FileUtils.getName(fileName));
            ajax.put("originalFilename", file.getOriginalFilename());
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }
}
