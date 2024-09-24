package com.ruoyi.CgStreet.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgStreet.mapper.CgStreetMapper;
import com.ruoyi.CgStreet.domain.CgStreet;
import com.ruoyi.CgStreet.service.ICgStreetService;

/**
 * 街道Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-19
 */
@Service
public class CgStreetServiceImpl implements ICgStreetService 
{
    @Autowired
    private CgStreetMapper cgStreetMapper;

    /**
     * 查询街道
     * 
     * @param id 街道主键
     * @return 街道
     */
    @Override
    public CgStreet selectCgStreetById(Long id)
    {
        return cgStreetMapper.selectCgStreetById(id);
    }

    /**
     * 查询街道列表
     * 
     * @param cgStreet 街道
     * @return 街道
     */
    @Override
    public List<CgStreet> selectCgStreetList(CgStreet cgStreet)
    {
        return cgStreetMapper.selectCgStreetList(cgStreet);
    }

    /**
     * 新增街道
     * 
     * @param cgStreet 街道
     * @return 结果
     */
    @Override
    public int insertCgStreet(CgStreet cgStreet)
    {
        cgStreet.setCreateTime(DateUtils.getNowDate());
        return cgStreetMapper.insertCgStreet(cgStreet);
    }

    /**
     * 修改街道
     * 
     * @param cgStreet 街道
     * @return 结果
     */
    @Override
    public int updateCgStreet(CgStreet cgStreet)
    {
        cgStreet.setUpdateTime(DateUtils.getNowDate());
        return cgStreetMapper.updateCgStreet(cgStreet);
    }

    /**
     * 批量删除街道
     * 
     * @param ids 需要删除的街道主键
     * @return 结果
     */
    @Override
    public int deleteCgStreetByIds(Long[] ids)
    {
        return cgStreetMapper.deleteCgStreetByIds(ids);
    }

    /**
     * 删除街道信息
     * 
     * @param id 街道主键
     * @return 结果
     */
    @Override
    public int deleteCgStreetById(Long id)
    {
        return cgStreetMapper.deleteCgStreetById(id);
    }
}
