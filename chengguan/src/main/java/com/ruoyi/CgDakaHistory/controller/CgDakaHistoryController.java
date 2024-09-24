package com.ruoyi.CgDakaHistory.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.CgDakaHistory.service.ICgDakaHistoryService;
import com.ruoyi.CgUser.domain.CgUser;
import com.ruoyi.CgUser.service.ICgUserService;
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
import com.ruoyi.CgDakaHistory.domain.CgDakaHistory;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 打卡记录Controller
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
@RestController
@RequestMapping("/CgDakaHistory/CgDakaHistory")
public class CgDakaHistoryController extends BaseController
{
    @Autowired
    private ICgDakaHistoryService cgDakaHistoryService;
    @Autowired
    private ICgUserService cgUserService;
    /**
     * 查询打卡记录列表
     */
    @PreAuthorize("@ss.hasPermi('CgDakaHistory:CgDakaHistory:list')")
    @GetMapping("/list")
    public TableDataInfo list(CgDakaHistory cgDakaHistory)
    {
        startPage();
        List<CgDakaHistory> list = cgDakaHistoryService.selectCgDakaHistoryList(cgDakaHistory);
        for(int a=0;a<list.size();a++){
            CgUser cgUser=cgUserService.selectCgUserById(list.get(a).getuId());
            list.get(a).getParams().put("cgUser",cgUser);
        }
        return getDataTable(list);
    }




    /**
     * 导出打卡记录列表
     */
    @PreAuthorize("@ss.hasPermi('CgDakaHistory:CgDakaHistory:export')")
    @Log(title = "打卡记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CgDakaHistory cgDakaHistory)
    {
        List<CgDakaHistory> list = cgDakaHistoryService.selectCgDakaHistoryList(cgDakaHistory);
        ExcelUtil<CgDakaHistory> util = new ExcelUtil<CgDakaHistory>(CgDakaHistory.class);
        util.exportExcel(response, list, "打卡记录数据");
    }

    /**
     * 获取打卡记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('CgDakaHistory:CgDakaHistory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cgDakaHistoryService.selectCgDakaHistoryById(id));
    }

    /**
     * 新增打卡记录
     */
    @PreAuthorize("@ss.hasPermi('CgDakaHistory:CgDakaHistory:add')")
    @Log(title = "打卡记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CgDakaHistory cgDakaHistory)
    {
        return toAjax(cgDakaHistoryService.insertCgDakaHistory(cgDakaHistory));
    }

    /**
     * 修改打卡记录
     */
    @PreAuthorize("@ss.hasPermi('CgDakaHistory:CgDakaHistory:edit')")
    @Log(title = "打卡记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CgDakaHistory cgDakaHistory)
    {
        return toAjax(cgDakaHistoryService.updateCgDakaHistory(cgDakaHistory));
    }

    /**
     * 删除打卡记录
     */
    @PreAuthorize("@ss.hasPermi('CgDakaHistory:CgDakaHistory:remove')")
    @Log(title = "打卡记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cgDakaHistoryService.deleteCgDakaHistoryByIds(ids));
    }
}
