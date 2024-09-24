package com.ruoyi.cg_p_ssx.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.cg_p_ssx.service.impl.ICgPSsxService;
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
import com.ruoyi.cg_p_ssx.domain.CgPSsx;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 十四扣分项Controller
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
@RestController
@RequestMapping("/cg_p_ssx/cg_p_ssx")
public class CgPSsxController extends BaseController
{
    @Autowired
    private ICgPSsxService cgPSsxService;

    /**
     * 查询十四扣分项列表
     */
    @PreAuthorize("@ss.hasPermi('cg_p_ssx:cg_p_ssx:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgPSsx cgPSsx)
    {
        startPage();
        List<CgPSsx> list = cgPSsxService.selectCgPSsxList(cgPSsx);
        return getDataTable(list);
    }

    /**
     * 导出十四扣分项列表
     */
    @PreAuthorize("@ss.hasPermi('cg_p_ssx:cg_p_ssx:export')")
    @Log(title = "十四扣分项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgPSsx cgPSsx)
    {
        List<CgPSsx> list = cgPSsxService.selectCgPSsxList(cgPSsx);
        ExcelUtil<CgPSsx> util = new ExcelUtil<CgPSsx>(CgPSsx.class);
        util.exportExcel(response, list, "十四扣分项数据");
    }

    /**
     * 获取十四扣分项详细信息
     */
    @PreAuthorize("@ss.hasPermi('cg_p_ssx:cg_p_ssx:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgPSsxService.selectCgPSsxById(id));
    }

    /**
     * 新增十四扣分项
     */
    @PreAuthorize("@ss.hasPermi('cg_p_ssx:cg_p_ssx:add')")
    @Log(title = "十四扣分项", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgPSsx cgPSsx)
    {
        return toAjax(cgPSsxService.insertCgPSsx(cgPSsx));
    }

    /**
     * 修改十四扣分项
     */
    @PreAuthorize("@ss.hasPermi('cg_p_ssx:cg_p_ssx:edit')")
    @Log(title = "十四扣分项", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgPSsx cgPSsx)
    {
        return toAjax(cgPSsxService.updateCgPSsx(cgPSsx));
    }

    /**
     * 删除十四扣分项
     */
    @PreAuthorize("@ss.hasPermi('cg_p_ssx:cg_p_ssx:remove')")
    @Log(title = "十四扣分项", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgPSsxService.deleteCgPSsxByIds(ids));
    }
}
