package com.ruoyi.CgEventType.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgEventType.mapper.CgEventTypeMapper;
import com.ruoyi.CgEventType.domain.CgEventType;
import com.ruoyi.CgEventType.service.ICgEventTypeService;

/**
 * 事件类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
@Service
public class CgEventTypeServiceImpl implements ICgEventTypeService 
{
    @Autowired
    private CgEventTypeMapper cgEventTypeMapper;

    /**
     * 查询事件类型
     * 
     * @param id 事件类型主键
     * @return 事件类型
     */
    @Override
    public CgEventType selectCgEventTypeById(Long id)
    {
        return cgEventTypeMapper.selectCgEventTypeById(id);
    }

    /**
     * 查询事件类型列表
     * 
     * @param cgEventType 事件类型
     * @return 事件类型
     */
    @Override
    public List<CgEventType> selectCgEventTypeList(CgEventType cgEventType)
    {
        return cgEventTypeMapper.selectCgEventTypeList(cgEventType);
    }

    /**
     * 新增事件类型
     * 
     * @param cgEventType 事件类型
     * @return 结果
     */
    @Override
    public int insertCgEventType(CgEventType cgEventType)
    {
        cgEventType.setCreateTime(DateUtils.getNowDate());
        return cgEventTypeMapper.insertCgEventType(cgEventType);
    }

    /**
     * 修改事件类型
     * 
     * @param cgEventType 事件类型
     * @return 结果
     */
    @Override
    public int updateCgEventType(CgEventType cgEventType)
    {
        cgEventType.setUpdateTime(DateUtils.getNowDate());
        return cgEventTypeMapper.updateCgEventType(cgEventType);
    }

    /**
     * 批量删除事件类型
     * 
     * @param ids 需要删除的事件类型主键
     * @return 结果
     */
    @Override
    public int deleteCgEventTypeByIds(Long[] ids)
    {
        return cgEventTypeMapper.deleteCgEventTypeByIds(ids);
    }

    /**
     * 删除事件类型信息
     * 
     * @param id 事件类型主键
     * @return 结果
     */
    @Override
    public int deleteCgEventTypeById(Long id)
    {
        return cgEventTypeMapper.deleteCgEventTypeById(id);
    }
}
