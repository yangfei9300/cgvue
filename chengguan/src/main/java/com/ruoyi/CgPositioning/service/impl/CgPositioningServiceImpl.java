package com.ruoyi.CgPositioning.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgPositioning.mapper.CgPositioningMapper;
import com.ruoyi.CgPositioning.domain.CgPositioning;
import com.ruoyi.CgPositioning.service.ICgPositioningService;

/**
 * 定位记录表Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-06
 */
@Service
public class CgPositioningServiceImpl implements ICgPositioningService 
{
    @Autowired
    private CgPositioningMapper cgPositioningMapper;

    /**
     * 查询定位记录表
     * 
     * @param id 定位记录表主键
     * @return 定位记录表
     */
    @Override
    public CgPositioning selectCgPositioningById(Long id)
    {
        return cgPositioningMapper.selectCgPositioningById(id);
    }

    /**
     * 查询定位记录表列表
     * 
     * @param cgPositioning 定位记录表
     * @return 定位记录表
     */
    @Override
    public List<CgPositioning> selectCgPositioningList(CgPositioning cgPositioning)
    {
        return cgPositioningMapper.selectCgPositioningList(cgPositioning);
    }

    /**
     * 新增定位记录表
     * 
     * @param cgPositioning 定位记录表
     * @return 结果
     */
    @Override
    public int insertCgPositioning(CgPositioning cgPositioning)
    {
        cgPositioning.setCreateTime(DateUtils.getNowDate());
        return cgPositioningMapper.insertCgPositioning(cgPositioning);
    }

    /**
     * 修改定位记录表
     * 
     * @param cgPositioning 定位记录表
     * @return 结果
     */
    @Override
    public int updateCgPositioning(CgPositioning cgPositioning)
    {
        cgPositioning.setUpdateTime(DateUtils.getNowDate());
        return cgPositioningMapper.updateCgPositioning(cgPositioning);
    }

    /**
     * 批量删除定位记录表
     * 
     * @param ids 需要删除的定位记录表主键
     * @return 结果
     */
    @Override
    public int deleteCgPositioningByIds(Long[] ids)
    {
        return cgPositioningMapper.deleteCgPositioningByIds(ids);
    }

    /**
     * 删除定位记录表信息
     * 
     * @param id 定位记录表主键
     * @return 结果
     */
    @Override
    public int deleteCgPositioningById(Long id)
    {
        return cgPositioningMapper.deleteCgPositioningById(id);
    }
}
