package com.ruoyi.CgScheduling.controller;

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
import com.ruoyi.CgScheduling.domain.CgScheduling;
import com.ruoyi.CgScheduling.service.ICgSchedulingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 上班时刻Controller
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
@RestController
@RequestMapping("/CgScheduling/CgScheduling")
public class CgSchedulingController extends BaseController
{
    @Autowired
    private ICgSchedulingService cgSchedulingService;

    /**
     * 查询上班时刻列表
     */
    @PreAuthorize("@ss.hasPermi('CgScheduling:CgScheduling:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgScheduling cgScheduling)
    {
        startPage();
        List<CgScheduling> list = cgSchedulingService.selectCgSchedulingList(cgScheduling);
        return getDataTable(list);
    }

    /**
     * 导出上班时刻列表
     */
    @PreAuthorize("@ss.hasPermi('CgScheduling:CgScheduling:export')")
    @Log(title = "上班时刻", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgScheduling cgScheduling)
    {
        List<CgScheduling> list = cgSchedulingService.selectCgSchedulingList(cgScheduling);
        ExcelUtil<CgScheduling> util = new ExcelUtil<CgScheduling>(CgScheduling.class);
        util.exportExcel(response, list, "上班时刻数据");
    }

    /**
     * 获取上班时刻详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgScheduling:CgScheduling:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgSchedulingService.selectCgSchedulingById(id));
    }

    /**
     * 新增上班时刻
     */
    @PreAuthorize("@ss.hasPermi('CgScheduling:CgScheduling:add')")
    @Log(title = "上班时刻", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgScheduling cgScheduling)
    {
        return toAjax(cgSchedulingService.insertCgScheduling(cgScheduling));
    }

    /**
     * 修改上班时刻
     */
    @PreAuthorize("@ss.hasPermi('CgScheduling:CgScheduling:edit')")
    @Log(title = "上班时刻", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgScheduling cgScheduling)
    {
        return toAjax(cgSchedulingService.updateCgScheduling(cgScheduling));
    }

    /**
     * 删除上班时刻
     */
    @PreAuthorize("@ss.hasPermi('CgScheduling:CgScheduling:remove')")
    @Log(title = "上班时刻", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgSchedulingService.deleteCgSchedulingByIds(ids));
    }
}
