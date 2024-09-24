package com.ruoyi.CgPSsxHistory.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgPSsxHistory.mapper.CgPSsxHistoryMapper;
import com.ruoyi.CgPSsxHistory.domain.CgPSsxHistory;
import com.ruoyi.CgPSsxHistory.service.ICgPSsxHistoryService;

/**
 * 十四扣分项目每月记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
@Service
public class CgPSsxHistoryServiceImpl implements ICgPSsxHistoryService 
{
    @Autowired
    private CgPSsxHistoryMapper cgPSsxHistoryMapper;

    /**
     * 查询十四扣分项目每月记录
     * 
     * @param id 十四扣分项目每月记录主键
     * @return 十四扣分项目每月记录
     */
    @Override
    public CgPSsxHistory selectCgPSsxHistoryById(Long id)
    {
        return cgPSsxHistoryMapper.selectCgPSsxHistoryById(id);
    }

    /**
     * 查询十四扣分项目每月记录列表
     * 
     * @param cgPSsxHistory 十四扣分项目每月记录
     * @return 十四扣分项目每月记录
     */
    @Override
    public List<CgPSsxHistory> selectCgPSsxHistoryList(CgPSsxHistory cgPSsxHistory)
    {
        return cgPSsxHistoryMapper.selectCgPSsxHistoryList(cgPSsxHistory);
    }

    /**
     * 新增十四扣分项目每月记录
     * 
     * @param cgPSsxHistory 十四扣分项目每月记录
     * @return 结果
     */
    @Override
    public int insertCgPSsxHistory(CgPSsxHistory cgPSsxHistory)
    {
        cgPSsxHistory.setCreateTime(DateUtils.getNowDate());
        return cgPSsxHistoryMapper.insertCgPSsxHistory(cgPSsxHistory);
    }

    /**
     * 修改十四扣分项目每月记录
     * 
     * @param cgPSsxHistory 十四扣分项目每月记录
     * @return 结果
     */
    @Override
    public int updateCgPSsxHistory(CgPSsxHistory cgPSsxHistory)
    {
        return cgPSsxHistoryMapper.updateCgPSsxHistory(cgPSsxHistory);
    }

    /**
     * 批量删除十四扣分项目每月记录
     * 
     * @param ids 需要删除的十四扣分项目每月记录主键
     * @return 结果
     */
    @Override
    public int deleteCgPSsxHistoryByIds(Long[] ids)
    {
        return cgPSsxHistoryMapper.deleteCgPSsxHistoryByIds(ids);
    }

    /**
     * 删除十四扣分项目每月记录信息
     * 
     * @param id 十四扣分项目每月记录主键
     * @return 结果
     */
    @Override
    public int deleteCgPSsxHistoryById(Long id)
    {
        return cgPSsxHistoryMapper.deleteCgPSsxHistoryById(id);
    }
}
