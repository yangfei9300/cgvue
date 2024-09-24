package com.ruoyi.CgHeartShi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.CgHeartShi.domain.CgHeartShiExcel;
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
import com.ruoyi.CgHeartShi.domain.CgHeartShi;
import com.ruoyi.CgHeartShi.service.ICgHeartShiService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 热心服务事项Controller
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
@RestController
@RequestMapping("/CgHeartShi/CgHeartShi")
public class CgHeartShiController extends BaseController
{
    @Autowired
    private ICgHeartShiService cgHeartShiService;

    /**
     * 查询热心服务事项列表
     */
    @PreAuthorize("@ss.hasPermi('CgHeartShi:CgHeartShi:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgHeartShi cgHeartShi)
    {
        startPage();
        List<CgHeartShi> list = cgHeartShiService.getHearts(cgHeartShi);
        return getDataTable(list);
    }

    /**
     * 导出热心服务事项列表
     */
    @PreAuthorize("@ss.hasPermi('CgHeartShi:CgHeartShi:export')")
    @Log(title = "热心服务事项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgHeartShi cgHeartShi)
    {
        List<CgHeartShi> list = cgHeartShiService.getHearts(cgHeartShi);
        List<CgHeartShiExcel> lustExcel=new ArrayList<>();
        for(int a=0;a<list.size();a++){
            CgHeartShiExcel cgHeartShiExcel=new CgHeartShiExcel();
            cgHeartShiExcel.setTitle(list.get(a).getTitle());
            cgHeartShiExcel.setContent(list.get(a).getContent());
            cgHeartShiExcel.setdId(list.get(a).getParams().get("tName").toString());
            cgHeartShiExcel.setuId(list.get(a).getParams().get("uName").toString());
            cgHeartShiExcel.setFen(list.get(a).getFen());
            cgHeartShiExcel.setFenTime(list.get(a).getFenTime());
            cgHeartShiExcel.setRemark(list.get(a).getRemark());
            lustExcel.add(cgHeartShiExcel);
        }

        ExcelUtil<CgHeartShiExcel> util = new ExcelUtil<CgHeartShiExcel>(CgHeartShiExcel.class);
        util.exportExcel(response, lustExcel, "热心服务事项数据");
    }

    /**
     * 获取热心服务事项详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgHeartShi:CgHeartShi:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {

        return success(cgHeartShiService.selectCgHeartShiById(id));
    }

    /**
     * 新增热心服务事项
     */
    @PreAuthorize("@ss.hasPermi('CgHeartShi:CgHeartShi:add')")
    @Log(title = "热心服务事项", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgHeartShi cgHeartShi)
    {
        return toAjax(cgHeartShiService.insertCgHeartShi(cgHeartShi));
    }

    /**
     * 修改热心服务事项
     */
    @PreAuthorize("@ss.hasPermi('CgHeartShi:CgHeartShi:edit')")
    @Log(title = "热心服务事项", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgHeartShi cgHeartShi)
    {
        if(cgHeartShi.getFenTime()==null&&cgHeartShi.getFen()!=null){
            cgHeartShi.setFenTime(new Date());
        }
        return toAjax(cgHeartShiService.updateCgHeartShi(cgHeartShi));
    }

    /**
     * 删除热心服务事项
     */
    @PreAuthorize("@ss.hasPermi('CgHeartShi:CgHeartShi:remove')")
    @Log(title = "热心服务事项", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgHeartShiService.deleteCgHeartShiByIds(ids));
    }
}
