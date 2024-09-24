package com.ruoyi.CgPHszs.controller;

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
import com.ruoyi.CgPHszs.domain.CgPHszs;
import com.ruoyi.CgPHszs.service.ICgPHszsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 华山指数Controller
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
@RestController
@RequestMapping("/CgPHszs/CgPHszs")
public class CgPHszsController extends BaseController
{
    @Autowired
    private ICgPHszsService cgPHszsService;

    /**
     * 查询华山指数列表
     */
    @PreAuthorize("@ss.hasPermi('CgPHszs:CgPHszs:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgPHszs cgPHszs)
    {
        startPage();
        List<CgPHszs> list = cgPHszsService.selectCgPHszsList(cgPHszs);
        return getDataTable(list);
    }

    /**
     * 导出华山指数列表
     */
    @PreAuthorize("@ss.hasPermi('CgPHszs:CgPHszs:export')")
    @Log(title = "华山指数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgPHszs cgPHszs)
    {
        List<CgPHszs> list = cgPHszsService.selectCgPHszsList(cgPHszs);
        ExcelUtil<CgPHszs> util = new ExcelUtil<CgPHszs>(CgPHszs.class);
        util.exportExcel(response, list, "华山指数数据");
    }

    /**
     * 获取华山指数详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgPHszs:CgPHszs:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgPHszsService.selectCgPHszsById(id));
    }

    /**
     * 新增华山指数
     */
    @PreAuthorize("@ss.hasPermi('CgPHszs:CgPHszs:add')")
    @Log(title = "华山指数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgPHszs cgPHszs)
    {
        return toAjax(cgPHszsService.insertCgPHszs(cgPHszs));
    }

    /**
     * 修改华山指数
     */
    @PreAuthorize("@ss.hasPermi('CgPHszs:CgPHszs:edit')")
    @Log(title = "华山指数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgPHszs cgPHszs)
    {
        return toAjax(cgPHszsService.updateCgPHszs(cgPHszs));
    }

    /**
     * 删除华山指数
     */
    @PreAuthorize("@ss.hasPermi('CgPHszs:CgPHszs:remove')")
    @Log(title = "华山指数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgPHszsService.deleteCgPHszsByIds(ids));
    }
}
