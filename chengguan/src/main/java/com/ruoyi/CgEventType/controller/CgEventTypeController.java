package com.ruoyi.CgEventType.controller;

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
import com.ruoyi.CgEventType.domain.CgEventType;
import com.ruoyi.CgEventType.service.ICgEventTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 事件类型Controller
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
@RestController
@RequestMapping("/CgEventType/CgEventType")
public class CgEventTypeController extends BaseController
{
    @Autowired
    private ICgEventTypeService cgEventTypeService;

    /**
     * 查询事件类型列表
     */
    @PreAuthorize("@ss.hasPermi('CgEventType:CgEventType:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgEventType cgEventType)
    {
        startPage();
        List<CgEventType> list = cgEventTypeService.selectCgEventTypeList(cgEventType);
        return getDataTable(list);
    }

    /**
     * 导出事件类型列表
     */
    @PreAuthorize("@ss.hasPermi('CgEventType:CgEventType:export')")
    @Log(title = "事件类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgEventType cgEventType)
    {
        List<CgEventType> list = cgEventTypeService.selectCgEventTypeList(cgEventType);
        ExcelUtil<CgEventType> util = new ExcelUtil<CgEventType>(CgEventType.class);
        util.exportExcel(response, list, "事件类型数据");
    }

    /**
     * 获取事件类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgEventType:CgEventType:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgEventTypeService.selectCgEventTypeById(id));
    }

    /**
     * 新增事件类型
     */
    @PreAuthorize("@ss.hasPermi('CgEventType:CgEventType:add')")
    @Log(title = "事件类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgEventType cgEventType)
    {
        return toAjax(cgEventTypeService.insertCgEventType(cgEventType));
    }

    /**
     * 修改事件类型
     */
    @PreAuthorize("@ss.hasPermi('CgEventType:CgEventType:edit')")
    @Log(title = "事件类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgEventType cgEventType)
    {
        return toAjax(cgEventTypeService.updateCgEventType(cgEventType));
    }

    /**
     * 删除事件类型
     */
    @PreAuthorize("@ss.hasPermi('CgEventType:CgEventType:remove')")
    @Log(title = "事件类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgEventTypeService.deleteCgEventTypeByIds(ids));
    }
}
