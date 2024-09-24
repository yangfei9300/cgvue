package com.ruoyi.CgGeographicFence.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.CgGeographicFence.domain.CgGeographicFence;
import com.ruoyi.CgGeographicFence.service.ICgGeographicFenceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地址围栏Controller
 * 
 * @author ruoyi
 * @date 2024-07-30
 */
@RestController
@RequestMapping("/CgGeographicFence/CgGeographicFence")
public class CgGeographicFenceController extends BaseController
{
    @Autowired
    private ICgGeographicFenceService cgGeographicFenceService;

    /**
     * 查询地址围栏列表
     */
    @PreAuthorize("@ss.hasPermi('CgGeographicFence:CgGeographicFence:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgGeographicFence cgGeographicFence)
    {
        startPage();
        List<CgGeographicFence> list = cgGeographicFenceService.selectCgGeographicFenceList(cgGeographicFence);
        return getDataTable(list);
    }

    /**
     * 导出地址围栏列表
     */
    @PreAuthorize("@ss.hasPermi('CgGeographicFence:CgGeographicFence:export')")
    @Log(title = "地址围栏", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgGeographicFence cgGeographicFence)
    {
        List<CgGeographicFence> list = cgGeographicFenceService.selectCgGeographicFenceList(cgGeographicFence);
        ExcelUtil<CgGeographicFence> util = new ExcelUtil<CgGeographicFence>(CgGeographicFence.class);
        util.exportExcel(response, list, "地址围栏数据");
    }

    /**
     * 获取地址围栏详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgGeographicFence:CgGeographicFence:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgGeographicFenceService.selectCgGeographicFenceById(id));
    }

    /**
     * 新增地址围栏
     */
    @PreAuthorize("@ss.hasPermi('CgGeographicFence:CgGeographicFence:add')")
    @Log(title = "地址围栏", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgGeographicFence cgGeographicFence)
    {
        return toAjax(cgGeographicFenceService.insertCgGeographicFence(cgGeographicFence));
    }

    /**
     * 修改地址围栏
     */
    @PreAuthorize("@ss.hasPermi('CgGeographicFence:CgGeographicFence:edit')")
    @Log(title = "地址围栏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgGeographicFence cgGeographicFence)
    {
        return toAjax(cgGeographicFenceService.updateCgGeographicFence(cgGeographicFence));
    }

    /**
     * 删除地址围栏
     */
    @PreAuthorize("@ss.hasPermi('CgGeographicFence:CgGeographicFence:remove')")
    @Log(title = "地址围栏", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgGeographicFenceService.deleteCgGeographicFenceByIds(ids));
    }
}
