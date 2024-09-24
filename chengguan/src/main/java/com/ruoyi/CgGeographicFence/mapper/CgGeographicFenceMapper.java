package com.ruoyi.CgGeographicFence.mapper;

import java.util.List;
import com.ruoyi.CgGeographicFence.domain.CgGeographicFence;

/**
 * 地址围栏Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-30
 */
public interface CgGeographicFenceMapper 
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
     * 删除地址围栏
     * 
     * @param id 地址围栏主键
     * @return 结果
     */
    public int deleteCgGeographicFenceById(Long id);

    /**
     * 批量删除地址围栏
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgGeographicFenceByIds(Long[] ids);
}
