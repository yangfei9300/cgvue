package com.ruoyi.CgShifouchaochu.controller;

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
import com.ruoyi.CgShifouchaochu.domain.CgShifouchaochu;
import com.ruoyi.CgShifouchaochu.service.ICgShifouchaochuService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 定位问题（是否超出）Controller
 * 
 * @author ruoyi
 * @date 2024-08-30
 */
@RestController
@RequestMapping("/CgShifouchaochu/CgShifouchaochu")
public class CgShifouchaochuController extends BaseController
{
    @Autowired
    private ICgShifouchaochuService cgShifouchaochuService;

    /**
     * 查询定位问题（是否超出）列表
     */
    @PreAuthorize("@ss.hasPermi('CgShifouchaochu:CgShifouchaochu:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgShifouchaochu cgShifouchaochu)
    {
        startPage();
        List<CgShifouchaochu> list = cgShifouchaochuService.selectCgShifouchaochuList(cgShifouchaochu);
        return getDataTable(list);
    }

    /**
     * 导出定位问题（是否超出）列表
     */
    @PreAuthorize("@ss.hasPermi('CgShifouchaochu:CgShifouchaochu:export')")
    @Log(title = "定位问题（是否超出）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgShifouchaochu cgShifouchaochu)
    {
        List<CgShifouchaochu> list = cgShifouchaochuService.selectCgShifouchaochuList(cgShifouchaochu);
        ExcelUtil<CgShifouchaochu> util = new ExcelUtil<CgShifouchaochu>(CgShifouchaochu.class);
        util.exportExcel(response, list, "定位问题（是否超出）数据");
    }

    /**
     * 获取定位问题（是否超出）详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgShifouchaochu:CgShifouchaochu:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgShifouchaochuService.selectCgShifouchaochuById(id));
    }

    /**
     * 新增定位问题（是否超出）
     */
    @PreAuthorize("@ss.hasPermi('CgShifouchaochu:CgShifouchaochu:add')")
    @Log(title = "定位问题（是否超出）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgShifouchaochu cgShifouchaochu)
    {
        return toAjax(cgShifouchaochuService.insertCgShifouchaochu(cgShifouchaochu));
    }

    /**
     * 修改定位问题（是否超出）
     */
    @PreAuthorize("@ss.hasPermi('CgShifouchaochu:CgShifouchaochu:edit')")
    @Log(title = "定位问题（是否超出）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgShifouchaochu cgShifouchaochu)
    {
        return toAjax(cgShifouchaochuService.updateCgShifouchaochu(cgShifouchaochu));
    }

    /**
     * 删除定位问题（是否超出）
     */
    @PreAuthorize("@ss.hasPermi('CgShifouchaochu:CgShifouchaochu:remove')")
    @Log(title = "定位问题（是否超出）", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgShifouchaochuService.deleteCgShifouchaochuByIds(ids));
    }
}
