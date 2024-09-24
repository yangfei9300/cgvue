package com.ruoyi.CgUser.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.CgAttendance.domain.CgAttendance;
import com.ruoyi.CgAttendance.service.ICgAttendanceService;
import com.ruoyi.DateUtils;
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
import com.ruoyi.CgUser.domain.CgUser;
import com.ruoyi.CgUser.service.ICgUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户信息Controller
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
@RestController
@RequestMapping("/CgUser/CgUser")
public class CgUserController extends BaseController
{
    @Autowired
    private ICgUserService cgUserService;

    @Autowired
    private ICgAttendanceService cgAttendanceService;

    /**
     * 查询用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('CgUser:CgUser:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgUser cgUser)
    {
        startPage();
        List<CgUser> list = cgUserService.selectCgUserList1(cgUser);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('CgUser:CgUser:export')")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgUser cgUser)
    {
        List<CgUser> list = cgUserService.selectCgUserList(cgUser);
        ExcelUtil<CgUser> util = new ExcelUtil<CgUser>(CgUser.class);
        util.exportExcel(response, list, "用户信息数据");
    }

    /**
     * 获取用户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgUser:CgUser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgUserService.selectCgUserById(id));
    }

    /**
     * 新增用户信息
     */
    @PreAuthorize("@ss.hasPermi('CgUser:CgUser:add')")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgUser cgUser)
    {
        int count=cgUserService.insertCgUser(cgUser);

        CgAttendance cgAttendance3=new CgAttendance();
        cgAttendance3.setAttendDate(new Date());
        cgAttendance3.setuId(cgUser.getId());
        // 获取当前日期

        LocalDate today1 = LocalDate.now();
        cgAttendance3.getParams().put("year",today1.getYear());
        cgAttendance3.getParams().put("month",today1.getMonthValue());
        //判断是否有考勤表
        List<CgAttendance> lustCgAttendance1= cgAttendanceService.getKqList(cgAttendance3);
        if(lustCgAttendance1.size()==0){
            String [][] monthdays= DateUtils.getMonthInfos();
            for(int a=0;a<monthdays.length;a++){
                CgAttendance cgAttendance2=new CgAttendance();
                cgAttendance2.setuId(cgUser.getId());
                cgAttendance2.setAttendDate(DateUtils.strZhaunDate(monthdays[a][0]));
                cgAttendance2.setWeekNum(monthdays[a][1]);
                cgAttendanceService.insertCgAttendance(cgAttendance2);
            }
        }

        return toAjax(count);
    }

    /**
     * 修改用户信息
     */
    @PreAuthorize("@ss.hasPermi('CgUser:CgUser:edit')")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgUser cgUser)
    {
        return toAjax(cgUserService.updateCgUser(cgUser));
    }

    /**
     * 删除用户信息
     */
    @PreAuthorize("@ss.hasPermi('CgUser:CgUser:remove')")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgUserService.deleteCgUserByIds(ids));
    }
}
