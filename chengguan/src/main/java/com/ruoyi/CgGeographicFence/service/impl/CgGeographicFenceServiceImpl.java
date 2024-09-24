package com.ruoyi.CgGeographicFence.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgGeographicFence.mapper.CgGeographicFenceMapper;
import com.ruoyi.CgGeographicFence.domain.CgGeographicFence;
import com.ruoyi.CgGeographicFence.service.ICgGeographicFenceService;

/**
 * 地址围栏Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-30
 */
@Service
public class CgGeographicFenceServiceImpl implements ICgGeographicFenceService 
{
    @Autowired
    private CgGeographicFenceMapper cgGeographicFenceMapper;

    /**
     * 查询地址围栏
     * 
     * @param id 地址围栏主键
     * @return 地址围栏
     */
    @Override
    public CgGeographicFence selectCgGeographicFenceById(Long id)
    {
        return cgGeographicFenceMapper.selectCgGeographicFenceById(id);
    }

    /**
     * 查询地址围栏列表
     * 
     * @param cgGeographicFence 地址围栏
     * @return 地址围栏
     */
    @Override
    public List<CgGeographicFence> selectCgGeographicFenceList(CgGeographicFence cgGeographicFence)
    {
        return cgGeographicFenceMapper.selectCgGeographicFenceList(cgGeographicFence);
    }

    /**
     * 新增地址围栏
     * 
     * @param cgGeographicFence 地址围栏
     * @return 结果
     */
    @Override
    public int insertCgGeographicFence(CgGeographicFence cgGeographicFence)
    {
        cgGeographicFence.setCreateTime(DateUtils.getNowDate());
        return cgGeographicFenceMapper.insertCgGeographicFence(cgGeographicFence);
    }

    /**
     * 修改地址围栏
     * 
     * @param cgGeographicFence 地址围栏
     * @return 结果
     */
    @Override
    public int updateCgGeographicFence(CgGeographicFence cgGeographicFence)
    {
        cgGeographicFence.setUpdateTime(DateUtils.getNowDate());
        return cgGeographicFenceMapper.updateCgGeographicFence(cgGeographicFence);
    }

    /**
     * 批量删除地址围栏
     * 
     * @param ids 需要删除的地址围栏主键
     * @return 结果
     */
    @Override
    public int deleteCgGeographicFenceByIds(Long[] ids)
    {
        return cgGeographicFenceMapper.deleteCgGeographicFenceByIds(ids);
    }

    /**
     * 删除地址围栏信息
     * 
     * @param id 地址围栏主键
     * @return 结果
     */
    @Override
    public int deleteCgGeographicFenceById(Long id)
    {
        return cgGeographicFenceMapper.deleteCgGeographicFenceById(id);
    }
}
