package com.ruoyi.CgPositioning.controller;

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
import com.ruoyi.CgPositioning.domain.CgPositioning;
import com.ruoyi.CgPositioning.service.ICgPositioningService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 定位记录表Controller
 * 
 * @author ruoyi
 * @date 2024-08-06
 */
@RestController
@RequestMapping("/CgPositioning/CgPositioning")
public class CgPositioningController extends BaseController
{
    @Autowired
    private ICgPositioningService cgPositioningService;

    /**
     * 查询定位记录表列表
     */
    @PreAuthorize("@ss.hasPermi('CgPositioning:CgPositioning:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgPositioning cgPositioning)
    {
        startPage();
        List<CgPositioning> list = cgPositioningService.selectCgPositioningList(cgPositioning);
        return getDataTable(list);
    }

    /**
     * 导出定位记录表列表
     */
    @PreAuthorize("@ss.hasPermi('CgPositioning:CgPositioning:export')")
    @Log(title = "定位记录表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgPositioning cgPositioning)
    {
        List<CgPositioning> list = cgPositioningService.selectCgPositioningList(cgPositioning);
        ExcelUtil<CgPositioning> util = new ExcelUtil<CgPositioning>(CgPositioning.class);
        util.exportExcel(response, list, "定位记录表数据");
    }

    /**
     * 获取定位记录表详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgPositioning:CgPositioning:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgPositioningService.selectCgPositioningById(id));
    }

    /**
     * 新增定位记录表
     */
    @PreAuthorize("@ss.hasPermi('CgPositioning:CgPositioning:add')")
    @Log(title = "定位记录表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgPositioning cgPositioning)
    {
        return toAjax(cgPositioningService.insertCgPositioning(cgPositioning));
    }

    /**
     * 修改定位记录表
     */
    @PreAuthorize("@ss.hasPermi('CgPositioning:CgPositioning:edit')")
    @Log(title = "定位记录表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgPositioning cgPositioning)
    {
        return toAjax(cgPositioningService.updateCgPositioning(cgPositioning));
    }

    /**
     * 删除定位记录表
     */
    @PreAuthorize("@ss.hasPermi('CgPositioning:CgPositioning:remove')")
    @Log(title = "定位记录表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgPositioningService.deleteCgPositioningByIds(ids));
    }
}
