package com.ruoyi.CgTeam.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.CgGeographicFence.domain.CgGeographicFence;
import com.ruoyi.CgGeographicFence.service.ICgGeographicFenceService;
import com.ruoyi.CgScheduling.domain.CgScheduling;
import com.ruoyi.CgScheduling.service.ICgSchedulingService;
import com.ruoyi.CgUser.domain.CgUser;
import com.ruoyi.CgUser.service.ICgUserService;
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
import com.ruoyi.CgTeam.domain.CgTeam;
import com.ruoyi.CgTeam.service.ICgTeamService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 队伍列Controller
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
@RestController
@RequestMapping("/CgTeam/CgTeam")
public class CgTeamController extends BaseController
{
    @Autowired
    private ICgTeamService cgTeamService;
    @Autowired
    private ICgSchedulingService cgSchedulingService;
    @Autowired
    private ICgGeographicFenceService cgGeographicFenceService;
    @Autowired
    private ICgUserService cgUserService;
    /**
     * 查询队伍列列表
     */
    @PreAuthorize("@ss.hasPermi('CgTeam:CgTeam:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgTeam cgTeam)
    {
        startPage();
        List<CgTeam> list = cgTeamService.selectCgTeamList(cgTeam);
        for(int a=0;a<list.size();a++){
            if (list.get(a).getWorkTimeId()!=null){
                CgScheduling cgScheduling=cgSchedulingService.selectCgSchedulingById(list.get(a).getWorkTimeId());
                list.get(a).getParams().put("cgScheduling",cgScheduling);
            }
            if (list.get(a).getDlwlId()!=null){
              CgGeographicFence cgGeographicFence= cgGeographicFenceService.selectCgGeographicFenceById(list.get(a).getDlwlId());
                list.get(a).getParams().put("cgGeographicFence",cgGeographicFence);
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出队伍列列表
     */
    @PreAuthorize("@ss.hasPermi('CgTeam:CgTeam:export')")
    @Log(title = "队伍列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgTeam cgTeam)
    {
        List<CgTeam> list = cgTeamService.selectCgTeamList(cgTeam);
        ExcelUtil<CgTeam> util = new ExcelUtil<CgTeam>(CgTeam.class);
        util.exportExcel(response, list, "队伍列数据");
    }

    /**
     * 获取队伍列详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgTeam:CgTeam:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgTeamService.selectCgTeamById(id));
    }

    /**
     * 新增队伍列
     */
    @PreAuthorize("@ss.hasPermi('CgTeam:CgTeam:add')")
    @Log(title = "队伍列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgTeam cgTeam)
    {
        return toAjax(cgTeamService.insertCgTeam(cgTeam));
    }

    /**
     * 修改队伍列
     */
    @PreAuthorize("@ss.hasPermi('CgTeam:CgTeam:edit')")
    @Log(title = "队伍列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgTeam cgTeam)
    {
        return toAjax(cgTeamService.updateCgTeam(cgTeam));
    }



    @PostMapping("/tongbuTime")
    public AjaxResult tongbuTime(@RequestBody CgTeam cgTeam)
    {
//        修改地理围栏
        CgUser cgUser=new CgUser();
        cgUser.setTeamId(cgTeam.getId());
        List<CgUser> listCgUser=cgUserService.selectCgUserList(cgUser);
        int count=0;
        for (int a=0;a<listCgUser.size();a++){
            if(cgTeam.getType()==1){
                listCgUser.get(a).setAreaId(cgTeam.getDlwlId());
                cgUserService.updateCgUser(listCgUser.get(a));
            }else{
                listCgUser.get(a).setWorkTimeId(cgTeam.getWorkTimeId());
                cgUserService.updateCgUser(listCgUser.get(a));
            }
            count=count+1;
        }
        return toAjax(count);
    }

    /**
     * 删除队伍列
     */
    @PreAuthorize("@ss.hasPermi('CgTeam:CgTeam:remove')")
    @Log(title = "队伍列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgTeamService.deleteCgTeamByIds(ids));
    }
}
