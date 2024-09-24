package com.ruoyi.CgFileZip.controller;

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
import com.ruoyi.CgFileZip.domain.CgFileZip;
import com.ruoyi.CgFileZip.service.ICgFileZipService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文件Controller
 * 
 * @author ruoyi
 * @date 2024-08-29
 */
@RestController
@RequestMapping("/CgFileZip/CgFileZip")
public class CgFileZipController extends BaseController
{
    @Autowired
    private ICgFileZipService cgFileZipService;

    /**
     * 查询文件列表
     */
    @PreAuthorize("@ss.hasPermi('CgFileZip:CgFileZip:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgFileZip cgFileZip)
    {
        startPage();
        List<CgFileZip> list = cgFileZipService.selectCgFileZipList(cgFileZip);
        return getDataTable(list);
    }

    /**
     * 导出文件列表
     */
    @PreAuthorize("@ss.hasPermi('CgFileZip:CgFileZip:export')")
    @Log(title = "文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgFileZip cgFileZip)
    {
        List<CgFileZip> list = cgFileZipService.selectCgFileZipList(cgFileZip);
        ExcelUtil<CgFileZip> util = new ExcelUtil<CgFileZip>(CgFileZip.class);
        util.exportExcel(response, list, "文件数据");
    }

    /**
     * 获取文件详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgFileZip:CgFileZip:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgFileZipService.selectCgFileZipById(id));
    }

    /**
     * 新增文件
     */
    @PreAuthorize("@ss.hasPermi('CgFileZip:CgFileZip:add')")
    @Log(title = "文件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgFileZip cgFileZip)
    {
        return toAjax(cgFileZipService.insertCgFileZip(cgFileZip));
    }

    /**
     * 修改文件
     */
    @PreAuthorize("@ss.hasPermi('CgFileZip:CgFileZip:edit')")
    @Log(title = "文件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgFileZip cgFileZip)
    {
        return toAjax(cgFileZipService.updateCgFileZip(cgFileZip));
    }

    /**
     * 删除文件
     */
    @PreAuthorize("@ss.hasPermi('CgFileZip:CgFileZip:remove')")
    @Log(title = "文件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgFileZipService.deleteCgFileZipByIds(ids));
    }
}
