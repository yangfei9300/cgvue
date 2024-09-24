package com.ruoyi.CgPDuiKaohe.controller;

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
import com.ruoyi.CgPDuiKaohe.domain.CgPDuiKaohe;
import com.ruoyi.CgPDuiKaohe.service.ICgPDuiKaoheService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 队考核Controller
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
@RestController
@RequestMapping("/CgPDuiKaohe/CgPDuiKaohe")
public class CgPDuiKaoheController extends BaseController
{
    @Autowired
    private ICgPDuiKaoheService cgPDuiKaoheService;

    /**
     * 查询队考核列表
     */
    @PreAuthorize("@ss.hasPermi('CgPDuiKaohe:CgPDuiKaohe:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgPDuiKaohe cgPDuiKaohe)
    {
        startPage();
        List<CgPDuiKaohe> list = cgPDuiKaoheService.selectCgPDuiKaoheList(cgPDuiKaohe);
        return getDataTable(list);
    }

    /**
     * 导出队考核列表
     */
    @PreAuthorize("@ss.hasPermi('CgPDuiKaohe:CgPDuiKaohe:export')")
    @Log(title = "队考核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgPDuiKaohe cgPDuiKaohe)
    {
        List<CgPDuiKaohe> list = cgPDuiKaoheService.selectCgPDuiKaoheList(cgPDuiKaohe);
        ExcelUtil<CgPDuiKaohe> util = new ExcelUtil<CgPDuiKaohe>(CgPDuiKaohe.class);
        util.exportExcel(response, list, "队考核数据");
    }

    /**
     * 获取队考核详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgPDuiKaohe:CgPDuiKaohe:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgPDuiKaoheService.selectCgPDuiKaoheById(id));
    }

    /**
     * 新增队考核
     */
    @PreAuthorize("@ss.hasPermi('CgPDuiKaohe:CgPDuiKaohe:add')")
    @Log(title = "队考核", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgPDuiKaohe cgPDuiKaohe)
    {
        return toAjax(cgPDuiKaoheService.insertCgPDuiKaohe(cgPDuiKaohe));
    }

    /**
     * 修改队考核
     */
    @PreAuthorize("@ss.hasPermi('CgPDuiKaohe:CgPDuiKaohe:edit')")
    @Log(title = "队考核", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgPDuiKaohe cgPDuiKaohe)
    {
        return toAjax(cgPDuiKaoheService.updateCgPDuiKaohe(cgPDuiKaohe));
    }

    /**
     * 删除队考核
     */
    @PreAuthorize("@ss.hasPermi('CgPDuiKaohe:CgPDuiKaohe:remove')")
    @Log(title = "队考核", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgPDuiKaoheService.deleteCgPDuiKaoheByIds(ids));
    }
}
