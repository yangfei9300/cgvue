package com.ruoyi.CgBanners.controller;

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
import com.ruoyi.CgBanners.domain.CgBanners;
import com.ruoyi.CgBanners.service.ICgBannersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 轮播图Controller
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
@RestController
@RequestMapping("/CgBanners/CgBanners")
public class CgBannersController extends BaseController
{
    @Autowired
    private ICgBannersService cgBannersService;

    /**
     * 查询轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('CgBanners:CgBanners:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgBanners cgBanners)
    {
        startPage();
        List<CgBanners> list = cgBannersService.selectCgBannersList(cgBanners);
        return getDataTable(list);
    }

    /**
     * 导出轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('CgBanners:CgBanners:export')")
    @Log(title = "轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgBanners cgBanners)
    {
        List<CgBanners> list = cgBannersService.selectCgBannersList(cgBanners);
        ExcelUtil<CgBanners> util = new ExcelUtil<CgBanners>(CgBanners.class);
        util.exportExcel(response, list, "轮播图数据");
    }

    /**
     * 获取轮播图详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgBanners:CgBanners:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgBannersService.selectCgBannersById(id));
    }

    /**
     * 新增轮播图
     */
    @PreAuthorize("@ss.hasPermi('CgBanners:CgBanners:add')")
    @Log(title = "轮播图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgBanners cgBanners)
    {
        return toAjax(cgBannersService.insertCgBanners(cgBanners));
    }

    /**
     * 修改轮播图
     */
    @PreAuthorize("@ss.hasPermi('CgBanners:CgBanners:edit')")
    @Log(title = "轮播图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgBanners cgBanners)
    {
        return toAjax(cgBannersService.updateCgBanners(cgBanners));
    }

    /**
     * 删除轮播图
     */
    @PreAuthorize("@ss.hasPermi('CgBanners:CgBanners:remove')")
    @Log(title = "轮播图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgBannersService.deleteCgBannersByIds(ids));
    }
}
