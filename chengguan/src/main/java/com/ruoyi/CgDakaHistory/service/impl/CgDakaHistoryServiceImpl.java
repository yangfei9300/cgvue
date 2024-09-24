package com.ruoyi.CgDakaHistory.service.impl;

import java.util.List;

import com.ruoyi.CgDakaHistory.service.ICgDakaHistoryService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgDakaHistory.mapper.CgDakaHistoryMapper;
import com.ruoyi.CgDakaHistory.domain.CgDakaHistory;

/**
 * 打卡记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
@Service
public class CgDakaHistoryServiceImpl implements ICgDakaHistoryService
{
    @Autowired
    private CgDakaHistoryMapper cgDakaHistoryMapper;

    /**
     * 查询打卡记录
     * 
     * @param id 打卡记录主键
     * @return 打卡记录
     */
    @Override
    public CgDakaHistory selectCgDakaHistoryById(Long id)
    {
        return cgDakaHistoryMapper.selectCgDakaHistoryById(id);
    }

    /**
     * 查询打卡记录列表
     * 
     * @param cgDakaHistory 打卡记录
     * @return 打卡记录
     */
    @Override
    public List<CgDakaHistory> selectCgDakaHistoryList(CgDakaHistory cgDakaHistory)
    {
        return cgDakaHistoryMapper.selectCgDakaHistoryList(cgDakaHistory);
    }

    /**
     * 新增打卡记录
     * 
     * @param cgDakaHistory 打卡记录
     * @return 结果
     */
    @Override
    public int insertCgDakaHistory(CgDakaHistory cgDakaHistory)
    {
        cgDakaHistory.setCreateTime(DateUtils.getNowDate());
        return cgDakaHistoryMapper.insertCgDakaHistory(cgDakaHistory);
    }

    /**
     * 修改打卡记录
     * 
     * @param cgDakaHistory 打卡记录
     * @return 结果
     */
    @Override
    public int updateCgDakaHistory(CgDakaHistory cgDakaHistory)
    {
        cgDakaHistory.setUpdateTime(DateUtils.getNowDate());
        return cgDakaHistoryMapper.updateCgDakaHistory(cgDakaHistory);
    }

    /**
     * 批量删除打卡记录
     * 
     * @param ids 需要删除的打卡记录主键
     * @return 结果
     */
    @Override
    public int deleteCgDakaHistoryByIds(Long[] ids)
    {
        return cgDakaHistoryMapper.deleteCgDakaHistoryByIds(ids);
    }

    /**
     * 删除打卡记录信息
     * 
     * @param id 打卡记录主键
     * @return 结果
     */
    @Override
    public int deleteCgDakaHistoryById(Long id)
    {
        return cgDakaHistoryMapper.deleteCgDakaHistoryById(id);
    }
}
