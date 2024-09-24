package com.ruoyi.CgJncsyxglpt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.ruoyi.CgJncsyxglpt.domain.CgJncsyxglpt;
import com.ruoyi.CgJncsyxglpt.service.ICgJncsyxglptService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 济南市城市服务运行管理平台Controller
 * 
 * @author ruoyi
 * @date 2024-09-23
 */
@RestController
@RequestMapping("/CgJncsyxglpt/CgJncsyxglpt")
public class CgJncsyxglptController extends BaseController
{
    @Autowired
    private ICgJncsyxglptService cgJncsyxglptService;

    /**
     * 查询济南市城市服务运行管理平台列表
     */
    @PreAuthorize("@ss.hasPermi('CgJncsyxglpt:CgJncsyxglpt:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgJncsyxglpt cgJncsyxglpt)
    {
        startPage();
        List<CgJncsyxglpt> list = cgJncsyxglptService.selectCgJncsyxglptList(cgJncsyxglpt);
        return getDataTable(list);
    }

    /**
     * 导出济南市城市服务运行管理平台列表
     */
    @PreAuthorize("@ss.hasPermi('CgJncsyxglpt:CgJncsyxglpt:export')")
    @Log(title = "济南市城市服务运行管理平台", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgJncsyxglpt cgJncsyxglpt)
    {
        List<CgJncsyxglpt> list = cgJncsyxglptService.selectCgJncsyxglptList(cgJncsyxglpt);
        ExcelUtil<CgJncsyxglpt> util = new ExcelUtil<CgJncsyxglpt>(CgJncsyxglpt.class);
        util.exportExcel(response, list, "济南市城市服务运行管理平台数据");
    }

    @PostMapping("/importData")
    public void importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CgJncsyxglpt> util = new ExcelUtil<CgJncsyxglpt>(CgJncsyxglpt.class);
        List<CgJncsyxglpt> cgDsfcpptxtList = util.importExcel(file.getInputStream());
        Map<String,Object> map11=new HashMap<>();
        for (int a=0;a<cgDsfcpptxtList.size();a++){
            System.out.printf("--"+cgDsfcpptxtList.get(a).toString());

        }
    }


    /**
     * 获取济南市城市服务运行管理平台详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgJncsyxglpt:CgJncsyxglpt:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgJncsyxglptService.selectCgJncsyxglptById(id));
    }

    /**
     * 新增济南市城市服务运行管理平台
     */
    @PreAuthorize("@ss.hasPermi('CgJncsyxglpt:CgJncsyxglpt:add')")
    @Log(title = "济南市城市服务运行管理平台", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgJncsyxglpt cgJncsyxglpt)
    {
        return toAjax(cgJncsyxglptService.insertCgJncsyxglpt(cgJncsyxglpt));
    }

    /**
     * 修改济南市城市服务运行管理平台
     */
    @PreAuthorize("@ss.hasPermi('CgJncsyxglpt:CgJncsyxglpt:edit')")
    @Log(title = "济南市城市服务运行管理平台", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgJncsyxglpt cgJncsyxglpt)
    {
        return toAjax(cgJncsyxglptService.updateCgJncsyxglpt(cgJncsyxglpt));
    }

    /**
     * 删除济南市城市服务运行管理平台
     */
    @PreAuthorize("@ss.hasPermi('CgJncsyxglpt:CgJncsyxglpt:remove')")
    @Log(title = "济南市城市服务运行管理平台", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgJncsyxglptService.deleteCgJncsyxglptByIds(ids));
    }
}
