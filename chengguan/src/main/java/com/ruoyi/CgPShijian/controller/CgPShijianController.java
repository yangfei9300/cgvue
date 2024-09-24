package com.ruoyi.CgPShijian.controller;

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
import com.ruoyi.CgPShijian.domain.CgPShijian;
import com.ruoyi.CgPShijian.service.ICgPShijianService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 待办事件假数据Controller
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
@RestController
@RequestMapping("/CgPShijian/CgPShijian")
public class CgPShijianController extends BaseController
{
    @Autowired
    private ICgPShijianService cgPShijianService;

    /**
     * 查询待办事件假数据列表
     */
    @PreAuthorize("@ss.hasPermi('CgPShijian:CgPShijian:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgPShijian cgPShijian)
    {
        startPage();
        List<CgPShijian> list = cgPShijianService.selectCgPShijianList(cgPShijian);
        return getDataTable(list);
    }

    /**
     * 导出待办事件假数据列表
     */
    @PreAuthorize("@ss.hasPermi('CgPShijian:CgPShijian:export')")
    @Log(title = "待办事件假数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgPShijian cgPShijian)
    {
        List<CgPShijian> list = cgPShijianService.selectCgPShijianList(cgPShijian);
        ExcelUtil<CgPShijian> util = new ExcelUtil<CgPShijian>(CgPShijian.class);
        util.exportExcel(response, list, "待办事件假数据数据");
    }

    /**
     * 获取待办事件假数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgPShijian:CgPShijian:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgPShijianService.selectCgPShijianById(id));
    }

    /**
     * 新增待办事件假数据
     */
    @PreAuthorize("@ss.hasPermi('CgPShijian:CgPShijian:add')")
    @Log(title = "待办事件假数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgPShijian cgPShijian)
    {
        return toAjax(cgPShijianService.insertCgPShijian(cgPShijian));
    }

    /**
     * 修改待办事件假数据
     */
    @PreAuthorize("@ss.hasPermi('CgPShijian:CgPShijian:edit')")
    @Log(title = "待办事件假数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgPShijian cgPShijian)
    {
        return toAjax(cgPShijianService.updateCgPShijian(cgPShijian));
    }

    /**
     * 删除待办事件假数据
     */
    @PreAuthorize("@ss.hasPermi('CgPShijian:CgPShijian:remove')")
    @Log(title = "待办事件假数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgPShijianService.deleteCgPShijianByIds(ids));
    }
}
