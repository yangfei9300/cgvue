package com.ruoyi.CgMonthKaohe.controller;

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
import com.ruoyi.CgMonthKaohe.domain.CgMonthKaohe;
import com.ruoyi.CgMonthKaohe.service.ICgMonthKaoheService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 每月考勤Controller
 * 
 * @author ruoyi
 * @date 2024-09-13
 */
@RestController
@RequestMapping("/CgMonthKaohe/CgMonthKaohe")
public class CgMonthKaoheController extends BaseController
{
    @Autowired
    private ICgMonthKaoheService cgMonthKaoheService;

    /**
     * 查询每月考勤列表
     */
    @PreAuthorize("@ss.hasPermi('CgMonthKaohe:CgMonthKaohe:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgMonthKaohe cgMonthKaohe)
    {
        startPage();
        List<CgMonthKaohe> list = cgMonthKaoheService.selectCgMonthKaoheList1(cgMonthKaohe);
        return getDataTable(list);
    }

    /**
     * 导出每月考勤列表
     */
    @PreAuthorize("@ss.hasPermi('CgMonthKaohe:CgMonthKaohe:export')")
    @Log(title = "每月考勤", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgMonthKaohe cgMonthKaohe)
    {
        List<CgMonthKaohe> list = cgMonthKaoheService.selectCgMonthKaoheList1(cgMonthKaohe);
        ExcelUtil<CgMonthKaohe> util = new ExcelUtil<CgMonthKaohe>(CgMonthKaohe.class);
        util.exportExcel(response, list, "每月考勤数据");
    }

    /**
     * 获取每月考勤详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgMonthKaohe:CgMonthKaohe:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgMonthKaoheService.selectCgMonthKaoheById(id));
    }

    /**
     * 新增每月考勤
     */
    @PreAuthorize("@ss.hasPermi('CgMonthKaohe:CgMonthKaohe:add')")
    @Log(title = "每月考勤", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgMonthKaohe cgMonthKaohe)
    {
        return toAjax(cgMonthKaoheService.insertCgMonthKaohe(cgMonthKaohe));
    }

    /**
     * 修改每月考勤
     */
    @PreAuthorize("@ss.hasPermi('CgMonthKaohe:CgMonthKaohe:edit')")
    @Log(title = "每月考勤", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgMonthKaohe cgMonthKaohe)
    {
        return toAjax(cgMonthKaoheService.updateCgMonthKaohe(cgMonthKaohe));
    }

    /**
     * 删除每月考勤
     */
    @PreAuthorize("@ss.hasPermi('CgMonthKaohe:CgMonthKaohe:remove')")
    @Log(title = "每月考勤", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgMonthKaoheService.deleteCgMonthKaoheByIds(ids));
    }
}
