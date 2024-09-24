package com.ruoyi.CgPSsxHistory.controller;

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
import com.ruoyi.CgPSsxHistory.domain.CgPSsxHistory;
import com.ruoyi.CgPSsxHistory.service.ICgPSsxHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 十四扣分项目每月记录Controller
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
@RestController
@RequestMapping("/CgPSsxHistory/CgPSsxHistory")
public class CgPSsxHistoryController extends BaseController
{
    @Autowired
    private ICgPSsxHistoryService cgPSsxHistoryService;

    /**
     * 查询十四扣分项目每月记录列表
     */
    @PreAuthorize("@ss.hasPermi('CgPSsxHistory:CgPSsxHistory:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgPSsxHistory cgPSsxHistory)
    {
        startPage();
        List<CgPSsxHistory> list = cgPSsxHistoryService.selectCgPSsxHistoryList(cgPSsxHistory);
        return getDataTable(list);
    }

    /**
     * 导出十四扣分项目每月记录列表
     */
    @PreAuthorize("@ss.hasPermi('CgPSsxHistory:CgPSsxHistory:export')")
    @Log(title = "十四扣分项目每月记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgPSsxHistory cgPSsxHistory)
    {
        List<CgPSsxHistory> list = cgPSsxHistoryService.selectCgPSsxHistoryList(cgPSsxHistory);
        ExcelUtil<CgPSsxHistory> util = new ExcelUtil<CgPSsxHistory>(CgPSsxHistory.class);
        util.exportExcel(response, list, "十四扣分项目每月记录数据");
    }

    /**
     * 获取十四扣分项目每月记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgPSsxHistory:CgPSsxHistory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgPSsxHistoryService.selectCgPSsxHistoryById(id));
    }

    /**
     * 新增十四扣分项目每月记录
     */
    @PreAuthorize("@ss.hasPermi('CgPSsxHistory:CgPSsxHistory:add')")
    @Log(title = "十四扣分项目每月记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgPSsxHistory cgPSsxHistory)
    {
        return toAjax(cgPSsxHistoryService.insertCgPSsxHistory(cgPSsxHistory));
    }

    /**
     * 修改十四扣分项目每月记录
     */
    @PreAuthorize("@ss.hasPermi('CgPSsxHistory:CgPSsxHistory:edit')")
    @Log(title = "十四扣分项目每月记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgPSsxHistory cgPSsxHistory)
    {
        return toAjax(cgPSsxHistoryService.updateCgPSsxHistory(cgPSsxHistory));
    }

    /**
     * 删除十四扣分项目每月记录
     */
    @PreAuthorize("@ss.hasPermi('CgPSsxHistory:CgPSsxHistory:remove')")
    @Log(title = "十四扣分项目每月记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgPSsxHistoryService.deleteCgPSsxHistoryByIds(ids));
    }
}
