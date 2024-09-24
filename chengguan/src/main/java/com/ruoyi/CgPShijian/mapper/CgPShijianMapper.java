package com.ruoyi.CgPShijian.mapper;

import java.util.List;
import com.ruoyi.CgPShijian.domain.CgPShijian;

/**
 * 待办事件假数据Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
public interface CgPShijianMapper 
{
    /**
     * 查询待办事件假数据
     * 
     * @param id 待办事件假数据主键
     * @return 待办事件假数据
     */
    public CgPShijian selectCgPShijianById(Long id);

    /**
     * 查询待办事件假数据列表
     * 
     * @param cgPShijian 待办事件假数据
     * @return 待办事件假数据集合
     */
    public List<CgPShijian> selectCgPShijianList(CgPShijian cgPShijian);

    /**
     * 新增待办事件假数据
     * 
     * @param cgPShijian 待办事件假数据
     * @return 结果
     */
    public int insertCgPShijian(CgPShijian cgPShijian);

    /**
     * 修改待办事件假数据
     * 
     * @param cgPShijian 待办事件假数据
     * @return 结果
     */
    public int updateCgPShijian(CgPShijian cgPShijian);

    /**
     * 删除待办事件假数据
     * 
     * @param id 待办事件假数据主键
     * @return 结果
     */
    public int deleteCgPShijianById(Long id);

    /**
     * 批量删除待办事件假数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgPShijianByIds(Long[] ids);
}
