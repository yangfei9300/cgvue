package com.ruoyi.CgVastSecond.controller;

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
import com.ruoyi.CgVastSecond.domain.CgVastSecond;
import com.ruoyi.CgVastSecond.service.ICgVastSecondService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 旷工时间Controller
 * 
 * @author ruoyi
 * @date 2024-09-02
 */
@RestController
@RequestMapping("/CgVastSecond/CgVastSecond")
public class CgVastSecondController extends BaseController
{
    @Autowired
    private ICgVastSecondService cgVastSecondService;

    /**
     * 查询旷工时间列表
     */
    @PreAuthorize("@ss.hasPermi('CgVastSecond:CgVastSecond:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgVastSecond cgVastSecond)
    {
        startPage();
        List<CgVastSecond> list = cgVastSecondService.selectCgVastSecondList(cgVastSecond);
        return getDataTable(list);
    }

    /**
     * 导出旷工时间列表
     */
    @PreAuthorize("@ss.hasPermi('CgVastSecond:CgVastSecond:export')")
    @Log(title = "旷工时间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgVastSecond cgVastSecond)
    {
        List<CgVastSecond> list = cgVastSecondService.selectCgVastSecondList(cgVastSecond);
        ExcelUtil<CgVastSecond> util = new ExcelUtil<CgVastSecond>(CgVastSecond.class);
        util.exportExcel(response, list, "旷工时间数据");
    }

    /**
     * 获取旷工时间详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgVastSecond:CgVastSecond:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgVastSecondService.selectCgVastSecondById(id));
    }

    /**
     * 新增旷工时间
     */
    @PreAuthorize("@ss.hasPermi('CgVastSecond:CgVastSecond:add')")
    @Log(title = "旷工时间", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgVastSecond cgVastSecond)
    {
        return toAjax(cgVastSecondService.insertCgVastSecond(cgVastSecond));
    }

    /**
     * 修改旷工时间
     */
    @PreAuthorize("@ss.hasPermi('CgVastSecond:CgVastSecond:edit')")
    @Log(title = "旷工时间", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgVastSecond cgVastSecond)
    {
        return toAjax(cgVastSecondService.updateCgVastSecond(cgVastSecond));
    }

    /**
     * 删除旷工时间
     */
    @PreAuthorize("@ss.hasPermi('CgVastSecond:CgVastSecond:remove')")
    @Log(title = "旷工时间", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgVastSecondService.deleteCgVastSecondByIds(ids));
    }
}
