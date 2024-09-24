package com.ruoyi.CgDakaHistory.mapper;

import java.util.List;
import com.ruoyi.CgDakaHistory.domain.CgDakaHistory;

/**
 * 打卡记录Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
public interface CgDakaHistoryMapper 
{
    /**
     * 查询打卡记录
     * 
     * @param id 打卡记录主键
     * @return 打卡记录
     */
    public CgDakaHistory selectCgDakaHistoryById(Long id);

    /**
     * 查询打卡记录列表
     * 
     * @param cgDakaHistory 打卡记录
     * @return 打卡记录集合
     */
    public List<CgDakaHistory> selectCgDakaHistoryList(CgDakaHistory cgDakaHistory);

    /**
     * 新增打卡记录
     * 
     * @param cgDakaHistory 打卡记录
     * @return 结果
     */
    public int insertCgDakaHistory(CgDakaHistory cgDakaHistory);

    /**
     * 修改打卡记录
     * 
     * @param cgDakaHistory 打卡记录
     * @return 结果
     */
    public int updateCgDakaHistory(CgDakaHistory cgDakaHistory);

    /**
     * 删除打卡记录
     * 
     * @param id 打卡记录主键
     * @return 结果
     */
    public int deleteCgDakaHistoryById(Long id);

    /**
     * 批量删除打卡记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgDakaHistoryByIds(Long[] ids);
}
