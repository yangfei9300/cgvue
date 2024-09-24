package com.ruoyi.CgGeographicFence.service;

import java.util.List;
import com.ruoyi.CgGeographicFence.domain.CgGeographicFence;

/**
 * 地址围栏Service接口
 * 
 * @author ruoyi
 * @date 2024-07-30
 */
public interface ICgGeographicFenceService 
{
    /**
     * 查询地址围栏
     * 
     * @param id 地址围栏主键
     * @return 地址围栏
     */
    public CgGeographicFence selectCgGeographicFenceById(Long id);

    /**
     * 查询地址围栏列表
     * 
     * @param cgGeographicFence 地址围栏
     * @return 地址围栏集合
     */
    public List<CgGeographicFence> selectCgGeographicFenceList(CgGeographicFence cgGeographicFence);

    /**
     * 新增地址围栏
     * 
     * @param cgGeographicFence 地址围栏
     * @return 结果
     */
    public int insertCgGeographicFence(CgGeographicFence cgGeographicFence);

    /**
     * 修改地址围栏
     * 
     * @param cgGeographicFence 地址围栏
     * @return 结果
     */
    public int updateCgGeographicFence(CgGeographicFence cgGeographicFence);

    /**
     * 批量删除地址围栏
     * 
     * @param ids 需要删除的地址围栏主键集合
     * @return 结果
     */
    public int deleteCgGeographicFenceByIds(Long[] ids);

    /**
     * 删除地址围栏信息
     * 
     * @param id 地址围栏主键
     * @return 结果
     */
    public int deleteCgGeographicFenceById(Long id);
}
