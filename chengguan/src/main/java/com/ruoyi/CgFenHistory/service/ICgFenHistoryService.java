package com.ruoyi.CgFenHistory.service;

import java.util.List;
import com.ruoyi.CgFenHistory.domain.CgFenHistory;
import com.ruoyi.CgMonthKaohe.domain.CgMonthKaohe;

/**
 * 分数记录Service接口
 * 
 * @author ruoyi
 * @date 2024-09-12
 */
public interface ICgFenHistoryService 
{
    /**
     * 查询分数记录
     * 
     * @param id 分数记录主键
     * @return 分数记录
     */
    public CgFenHistory selectCgFenHistoryById(Long id);

    /**
     * 查询分数记录列表
     * 
     * @param cgFenHistory 分数记录
     * @return 分数记录集合
     */
    public List<CgFenHistory> selectCgFenHistoryList(CgFenHistory cgFenHistory);
    public List<CgFenHistory> getMonthFens(CgFenHistory cgFenHistory);
    public List<CgFenHistory> selectCgFenHistoryList1(CgFenHistory cgFenHistory);
    /**
     * 新增分数记录
     * 
     * @param cgFenHistory 分数记录
     * @return 结果
     */
    public int insertCgFenHistory(CgFenHistory cgFenHistory);

    /**
     * 修改分数记录
     * 
     * @param cgFenHistory 分数记录
     * @return 结果
     */
    public int updateCgFenHistory(CgFenHistory cgFenHistory);

    /**
     * 批量删除分数记录
     * 
     * @param ids 需要删除的分数记录主键集合
     * @return 结果
     */
    public int deleteCgFenHistoryByIds(Long[] ids);

    /**
     * 删除分数记录信息
     * 
     * @param id 分数记录主键
     * @return 结果
     */
    public int deleteCgFenHistoryById(Long id);
}
