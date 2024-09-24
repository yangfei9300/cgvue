package com.ruoyi.CgTeamKaohe.controller;

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
import com.ruoyi.CgTeamKaohe.domain.CgTeamKaohe;
import com.ruoyi.CgTeamKaohe.service.ICgTeamKaoheService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 每月队考核Controller
 * 
 * @author ruoyi
 * @date 2024-09-22
 */
@RestController
@RequestMapping("/CgTeamKaohe/CgTeamKaohe")
public class CgTeamKaoheController extends BaseController
{
    @Autowired
    private ICgTeamKaoheService cgTeamKaoheService;

    /**
     * 查询每月队考核列表
     */
    @PreAuthorize("@ss.hasPermi('CgTeamKaohe:CgTeamKaohe:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgTeamKaohe cgTeamKaohe)
    {
        startPage();
        List<CgTeamKaohe> list = cgTeamKaoheService.selectCgTeamKaoheList(cgTeamKaohe);
        return getDataTable(list);
    }

    /**
     * 导出每月队考核列表
     */
    @PreAuthorize("@ss.hasPermi('CgTeamKaohe:CgTeamKaohe:export')")
    @Log(title = "每月队考核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgTeamKaohe cgTeamKaohe)
    {
        List<CgTeamKaohe> list = cgTeamKaoheService.selectCgTeamKaoheList(cgTeamKaohe);
        ExcelUtil<CgTeamKaohe> util = new ExcelUtil<CgTeamKaohe>(CgTeamKaohe.class);
        util.exportExcel(response, list, "每月队考核数据");
    }

    /**
     * 获取每月队考核详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgTeamKaohe:CgTeamKaohe:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgTeamKaoheService.selectCgTeamKaoheById(id));
    }

    /**
     * 新增每月队考核
     */
    @PreAuthorize("@ss.hasPermi('CgTeamKaohe:CgTeamKaohe:add')")
    @Log(title = "每月队考核", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgTeamKaohe cgTeamKaohe)
    {
        return toAjax(cgTeamKaoheService.insertCgTeamKaohe(cgTeamKaohe));
    }

    /**
     * 修改每月队考核
     */
    @PreAuthorize("@ss.hasPermi('CgTeamKaohe:CgTeamKaohe:edit')")
    @Log(title = "每月队考核", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgTeamKaohe cgTeamKaohe)
    {
        return toAjax(cgTeamKaoheService.updateCgTeamKaohe(cgTeamKaohe));
    }

    /**
     * 删除每月队考核
     */
    @PreAuthorize("@ss.hasPermi('CgTeamKaohe:CgTeamKaohe:remove')")
    @Log(title = "每月队考核", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgTeamKaoheService.deleteCgTeamKaoheByIds(ids));
    }
}
