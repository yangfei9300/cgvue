package com.ruoyi.CgPHszs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgPHszs.mapper.CgPHszsMapper;
import com.ruoyi.CgPHszs.domain.CgPHszs;
import com.ruoyi.CgPHszs.service.ICgPHszsService;

/**
 * 华山指数Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
@Service
public class CgPHszsServiceImpl implements ICgPHszsService 
{
    @Autowired
    private CgPHszsMapper cgPHszsMapper;

    /**
     * 查询华山指数
     * 
     * @param id 华山指数主键
     * @return 华山指数
     */
    @Override
    public CgPHszs selectCgPHszsById(Long id)
    {
        return cgPHszsMapper.selectCgPHszsById(id);
    }

    /**
     * 查询华山指数列表
     * 
     * @param cgPHszs 华山指数
     * @return 华山指数
     */
    @Override
    public List<CgPHszs> selectCgPHszsList(CgPHszs cgPHszs)
    {
        return cgPHszsMapper.selectCgPHszsList(cgPHszs);
    }

    /**
     * 新增华山指数
     * 
     * @param cgPHszs 华山指数
     * @return 结果
     */
    @Override
    public int insertCgPHszs(CgPHszs cgPHszs)
    {
        return cgPHszsMapper.insertCgPHszs(cgPHszs);
    }

    /**
     * 修改华山指数
     * 
     * @param cgPHszs 华山指数
     * @return 结果
     */
    @Override
    public int updateCgPHszs(CgPHszs cgPHszs)
    {
        return cgPHszsMapper.updateCgPHszs(cgPHszs);
    }

    /**
     * 批量删除华山指数
     * 
     * @param ids 需要删除的华山指数主键
     * @return 结果
     */
    @Override
    public int deleteCgPHszsByIds(Long[] ids)
    {
        return cgPHszsMapper.deleteCgPHszsByIds(ids);
    }

    /**
     * 删除华山指数信息
     * 
     * @param id 华山指数主键
     * @return 结果
     */
    @Override
    public int deleteCgPHszsById(Long id)
    {
        return cgPHszsMapper.deleteCgPHszsById(id);
    }
}
