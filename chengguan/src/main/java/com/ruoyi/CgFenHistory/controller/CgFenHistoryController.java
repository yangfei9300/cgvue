package com.ruoyi.CgFenHistory.controller;

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
import com.ruoyi.CgFenHistory.domain.CgFenHistory;
import com.ruoyi.CgFenHistory.service.ICgFenHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分数记录Controller
 * 
 * @author ruoyi
 * @date 2024-09-12
 */
@RestController
@RequestMapping("/CgFenHistory/CgFenHistory")
public class CgFenHistoryController extends BaseController
{
    @Autowired
    private ICgFenHistoryService cgFenHistoryService;

    /**
     * 查询分数记录列表
     */
    @PreAuthorize("@ss.hasPermi('CgFenHistory:CgFenHistory:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgFenHistory cgFenHistory)
    {
        startPage();
        List<CgFenHistory> list = cgFenHistoryService.selectCgFenHistoryList1(cgFenHistory);
        return getDataTable(list);
    }

    /**
     * 导出分数记录列表
     */
    @PreAuthorize("@ss.hasPermi('CgFenHistory:CgFenHistory:export')")
    @Log(title = "分数记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgFenHistory cgFenHistory)
    {
        List<CgFenHistory> list = cgFenHistoryService.selectCgFenHistoryList1(cgFenHistory);
        ExcelUtil<CgFenHistory> util = new ExcelUtil<CgFenHistory>(CgFenHistory.class);
        util.exportExcel(response, list, "分数记录数据");
    }

    /**
     * 获取分数记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgFenHistory:CgFenHistory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgFenHistoryService.selectCgFenHistoryById(id));
    }

    /**
     * 新增分数记录
     */
    @PreAuthorize("@ss.hasPermi('CgFenHistory:CgFenHistory:add')")
    @Log(title = "分数记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgFenHistory cgFenHistory)
    {
        return toAjax(cgFenHistoryService.insertCgFenHistory(cgFenHistory));
    }

    /**
     * 修改分数记录
     */
    @PreAuthorize("@ss.hasPermi('CgFenHistory:CgFenHistory:edit')")
    @Log(title = "分数记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgFenHistory cgFenHistory)
    {
        return toAjax(cgFenHistoryService.updateCgFenHistory(cgFenHistory));
    }

    /**
     * 删除分数记录
     */
    @PreAuthorize("@ss.hasPermi('CgFenHistory:CgFenHistory:remove')")
    @Log(title = "分数记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgFenHistoryService.deleteCgFenHistoryByIds(ids));
    }
}
