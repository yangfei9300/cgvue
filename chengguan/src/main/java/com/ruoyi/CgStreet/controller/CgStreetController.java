package com.ruoyi.CgStreet.controller;

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
import com.ruoyi.CgStreet.domain.CgStreet;
import com.ruoyi.CgStreet.service.ICgStreetService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 街道Controller
 * 
 * @author ruoyi
 * @date 2024-08-19
 */
@RestController
@RequestMapping("/CgStreet/CgStreet")
public class CgStreetController extends BaseController
{
    @Autowired
    private ICgStreetService cgStreetService;

    /**
     * 查询街道列表
     */
    @PreAuthorize("@ss.hasPermi('CgStreet:CgStreet:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgStreet cgStreet)
    {
        startPage();
        List<CgStreet> list = cgStreetService.selectCgStreetList(cgStreet);
        return getDataTable(list);
    }

    /**
     * 导出街道列表
     */
    @PreAuthorize("@ss.hasPermi('CgStreet:CgStreet:export')")
    @Log(title = "街道", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgStreet cgStreet)
    {
        List<CgStreet> list = cgStreetService.selectCgStreetList(cgStreet);
        ExcelUtil<CgStreet> util = new ExcelUtil<CgStreet>(CgStreet.class);
        util.exportExcel(response, list, "街道数据");
    }

    /**
     * 获取街道详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgStreet:CgStreet:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgStreetService.selectCgStreetById(id));
    }

    /**
     * 新增街道
     */
    @PreAuthorize("@ss.hasPermi('CgStreet:CgStreet:add')")
    @Log(title = "街道", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgStreet cgStreet)
    {
        return toAjax(cgStreetService.insertCgStreet(cgStreet));
    }

    /**
     * 修改街道
     */
    @PreAuthorize("@ss.hasPermi('CgStreet:CgStreet:edit')")
    @Log(title = "街道", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgStreet cgStreet)
    {
        return toAjax(cgStreetService.updateCgStreet(cgStreet));
    }

    /**
     * 删除街道
     */
    @PreAuthorize("@ss.hasPermi('CgStreet:CgStreet:remove')")
    @Log(title = "街道", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgStreetService.deleteCgStreetByIds(ids));
    }
}
