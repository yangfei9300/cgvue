package com.ruoyi.CgEventType.mapper;

import java.util.List;
import com.ruoyi.CgEventType.domain.CgEventType;

/**
 * 事件类型Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
public interface CgEventTypeMapper 
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
     * 删除事件类型
     * 
     * @param id 事件类型主键
     * @return 结果
     */
    public int deleteCgEventTypeById(Long id);

    /**
     * 批量删除事件类型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgEventTypeByIds(Long[] ids);
}
