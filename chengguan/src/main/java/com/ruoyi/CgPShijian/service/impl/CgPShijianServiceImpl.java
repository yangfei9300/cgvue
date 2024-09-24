package com.ruoyi.CgPShijian.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgPShijian.mapper.CgPShijianMapper;
import com.ruoyi.CgPShijian.domain.CgPShijian;
import com.ruoyi.CgPShijian.service.ICgPShijianService;

/**
 * 待办事件假数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
@Service
public class CgPShijianServiceImpl implements ICgPShijianService 
{
    @Autowired
    private CgPShijianMapper cgPShijianMapper;

    /**
     * 查询待办事件假数据
     * 
     * @param id 待办事件假数据主键
     * @return 待办事件假数据
     */
    @Override
    public CgPShijian selectCgPShijianById(Long id)
    {
        return cgPShijianMapper.selectCgPShijianById(id);
    }

    /**
     * 查询待办事件假数据列表
     * 
     * @param cgPShijian 待办事件假数据
     * @return 待办事件假数据
     */
    @Override
    public List<CgPShijian> selectCgPShijianList(CgPShijian cgPShijian)
    {
        return cgPShijianMapper.selectCgPShijianList(cgPShijian);
    }

    /**
     * 新增待办事件假数据
     * 
     * @param cgPShijian 待办事件假数据
     * @return 结果
     */
    @Override
    public int insertCgPShijian(CgPShijian cgPShijian)
    {
        cgPShijian.setCreateTime(DateUtils.getNowDate());
        return cgPShijianMapper.insertCgPShijian(cgPShijian);
    }

    /**
     * 修改待办事件假数据
     * 
     * @param cgPShijian 待办事件假数据
     * @return 结果
     */
    @Override
    public int updateCgPShijian(CgPShijian cgPShijian)
    {
        cgPShijian.setUpdateTime(DateUtils.getNowDate());
        return cgPShijianMapper.updateCgPShijian(cgPShijian);
    }

    /**
     * 批量删除待办事件假数据
     * 
     * @param ids 需要删除的待办事件假数据主键
     * @return 结果
     */
    @Override
    public int deleteCgPShijianByIds(Long[] ids)
    {
        return cgPShijianMapper.deleteCgPShijianByIds(ids);
    }

    /**
     * 删除待办事件假数据信息
     * 
     * @param id 待办事件假数据主键
     * @return 结果
     */
    @Override
    public int deleteCgPShijianById(Long id)
    {
        return cgPShijianMapper.deleteCgPShijianById(id);
    }
}
