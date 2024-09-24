package com.ruoyi.CgPSsxHistory.mapper;

import java.util.List;
import com.ruoyi.CgPSsxHistory.domain.CgPSsxHistory;

/**
 * 十四扣分项目每月记录Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
public interface CgPSsxHistoryMapper 
{
    /**
     * 查询十四扣分项目每月记录
     * 
     * @param id 十四扣分项目每月记录主键
     * @return 十四扣分项目每月记录
     */
    public CgPSsxHistory selectCgPSsxHistoryById(Long id);

    /**
     * 查询十四扣分项目每月记录列表
     * 
     * @param cgPSsxHistory 十四扣分项目每月记录
     * @return 十四扣分项目每月记录集合
     */
    public List<CgPSsxHistory> selectCgPSsxHistoryList(CgPSsxHistory cgPSsxHistory);

    /**
     * 新增十四扣分项目每月记录
     * 
     * @param cgPSsxHistory 十四扣分项目每月记录
     * @return 结果
     */
    public int insertCgPSsxHistory(CgPSsxHistory cgPSsxHistory);

    /**
     * 修改十四扣分项目每月记录
     * 
     * @param cgPSsxHistory 十四扣分项目每月记录
     * @return 结果
     */
    public int updateCgPSsxHistory(CgPSsxHistory cgPSsxHistory);

    /**
     * 删除十四扣分项目每月记录
     * 
     * @param id 十四扣分项目每月记录主键
     * @return 结果
     */
    public int deleteCgPSsxHistoryById(Long id);

    /**
     * 批量删除十四扣分项目每月记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgPSsxHistoryByIds(Long[] ids);
}
