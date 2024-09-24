package com.ruoyi.CgFenHistory.service.impl;

import java.util.List;

import com.ruoyi.CgMonthKaohe.domain.CgMonthKaohe;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgFenHistory.mapper.CgFenHistoryMapper;
import com.ruoyi.CgFenHistory.domain.CgFenHistory;
import com.ruoyi.CgFenHistory.service.ICgFenHistoryService;

/**
 * 分数记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-12
 */
@Service
public class CgFenHistoryServiceImpl implements ICgFenHistoryService 
{
    @Autowired
    private CgFenHistoryMapper cgFenHistoryMapper;

    /**
     * 查询分数记录
     * 
     * @param id 分数记录主键
     * @return 分数记录
     */
    @Override
    public CgFenHistory selectCgFenHistoryById(Long id)
    {
        return cgFenHistoryMapper.selectCgFenHistoryById(id);
    }

    /**
     * 查询分数记录列表
     * 
     * @param cgFenHistory 分数记录
     * @return 分数记录
     */
    @Override
    public List<CgFenHistory> selectCgFenHistoryList(CgFenHistory cgFenHistory)
    {
        return cgFenHistoryMapper.selectCgFenHistoryList(cgFenHistory);
    }

    @Override
    public List<CgFenHistory> getMonthFens(CgFenHistory cgFenHistory) {
        return cgFenHistoryMapper.getMonthFens(cgFenHistory);
    }

    @Override
    public List<CgFenHistory> selectCgFenHistoryList1(CgFenHistory cgFenHistory) {

        return cgFenHistoryMapper.selectCgFenHistoryList1(cgFenHistory);
    }

    /**
     * 新增分数记录
     * 
     * @param cgFenHistory 分数记录
     * @return 结果
     */
    @Override
    public int insertCgFenHistory(CgFenHistory cgFenHistory)
    {
        cgFenHistory.setCreateTime(DateUtils.getNowDate());
        return cgFenHistoryMapper.insertCgFenHistory(cgFenHistory);
    }

    /**
     * 修改分数记录
     * 
     * @param cgFenHistory 分数记录
     * @return 结果
     */
    @Override
    public int updateCgFenHistory(CgFenHistory cgFenHistory)
    {
        cgFenHistory.setUpdateTime(DateUtils.getNowDate());
        return cgFenHistoryMapper.updateCgFenHistory(cgFenHistory);
    }

    /**
     * 批量删除分数记录
     * 
     * @param ids 需要删除的分数记录主键
     * @return 结果
     */
    @Override
    public int deleteCgFenHistoryByIds(Long[] ids)
    {
        return cgFenHistoryMapper.deleteCgFenHistoryByIds(ids);
    }

    /**
     * 删除分数记录信息
     * 
     * @param id 分数记录主键
     * @return 结果
     */
    @Override
    public int deleteCgFenHistoryById(Long id)
    {
        return cgFenHistoryMapper.deleteCgFenHistoryById(id);
    }
}
