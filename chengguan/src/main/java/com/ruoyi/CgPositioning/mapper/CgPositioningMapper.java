package com.ruoyi.CgPositioning.mapper;

import java.util.List;
import com.ruoyi.CgPositioning.domain.CgPositioning;

/**
 * 定位记录表Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-06
 */
public interface CgPositioningMapper 
{
    /**
     * 查询定位记录表
     * 
     * @param id 定位记录表主键
     * @return 定位记录表
     */
    public CgPositioning selectCgPositioningById(Long id);

    /**
     * 查询定位记录表列表
     * 
     * @param cgPositioning 定位记录表
     * @return 定位记录表集合
     */
    public List<CgPositioning> selectCgPositioningList(CgPositioning cgPositioning);

    /**
     * 新增定位记录表
     * 
     * @param cgPositioning 定位记录表
     * @return 结果
     */
    public int insertCgPositioning(CgPositioning cgPositioning);

    /**
     * 修改定位记录表
     * 
     * @param cgPositioning 定位记录表
     * @return 结果
     */
    public int updateCgPositioning(CgPositioning cgPositioning);

    /**
     * 删除定位记录表
     * 
     * @param id 定位记录表主键
     * @return 结果
     */
    public int deleteCgPositioningById(Long id);

    /**
     * 批量删除定位记录表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgPositioningByIds(Long[] ids);
}
