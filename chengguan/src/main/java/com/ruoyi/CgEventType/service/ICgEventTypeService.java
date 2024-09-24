package com.ruoyi.CgEventType.service;

import java.util.List;
import com.ruoyi.CgEventType.domain.CgEventType;

/**
 * 事件类型Service接口
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
public interface ICgEventTypeService 
{
    /**
     * 查询事件类型
     * 
     * @param id 事件类型主键
     * @return 事件类型
     */
    public CgEventType selectCgEventTypeById(Long id);

    /**
     * 查询事件类型列表
     * 
     * @param cgEventType 事件类型
     * @return 事件类型集合
     */
    public List<CgEventType> selectCgEventTypeList(CgEventType cgEventType);

    /**
     * 新增事件类型
     * 
     * @param cgEventType 事件类型
     * @return 结果
     */
    public int insertCgEventType(CgEventType cgEventType);

    /**
     * 修改事件类型
     * 
     * @param cgEventType 事件类型
     * @return 结果
     */
    public int updateCgEventType(CgEventType cgEventType);

    /**
     * 批量删除事件类型
     * 
     * @param ids 需要删除的事件类型主键集合
     * @return 结果
     */
    public int deleteCgEventTypeByIds(Long[] ids);

    /**
     * 删除事件类型信息
     * 
     * @param id 事件类型主键
     * @return 结果
     */
    public int deleteCgEventTypeById(Long id);
}
