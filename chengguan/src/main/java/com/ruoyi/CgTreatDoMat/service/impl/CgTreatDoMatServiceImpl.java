package com.ruoyi.CgTreatDoMat.service.impl;

import java.util.List;

import com.ruoyi.CgTreatDoMat.service.ICgTreatDoMatService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgTreatDoMat.mapper.CgTreatDoMatMapper;
import com.ruoyi.CgTreatDoMat.domain.CgTreatDoMat;

/**
 * 待办事件Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
@Service
public class CgTreatDoMatServiceImpl implements ICgTreatDoMatService
{
    @Autowired
    private CgTreatDoMatMapper cgTreatDoMatMapper;

    /**
     * 查询待办事件
     * 
     * @param id 待办事件主键
     * @return 待办事件
     */
    @Override
    public CgTreatDoMat selectCgTreatDoMatById(Long id)
    {
        return cgTreatDoMatMapper.selectCgTreatDoMatById(id);
    }

    /**
     * 查询待办事件列表
     * 
     * @param cgTreatDoMat 待办事件
     * @return 待办事件
     */
    @Override
    public List<CgTreatDoMat> selectCgTreatDoMatList(CgTreatDoMat cgTreatDoMat)
    {
        return cgTreatDoMatMapper.selectCgTreatDoMatList(cgTreatDoMat);
    }

    @Override
    public List<CgTreatDoMat> getShijianList(CgTreatDoMat cgTreatDoMat) {
        return cgTreatDoMatMapper.getShijianList(cgTreatDoMat);
    }

    @Override
    public List<CgTreatDoMat> gettotalfenMonth(CgTreatDoMat cgTreatDoMat) {
        return cgTreatDoMatMapper.gettotalfenMonth(cgTreatDoMat);
    }

    /**
     * 新增待办事件
     * 
     * @param cgTreatDoMat 待办事件
     * @return 结果
     */
    @Override
    public int insertCgTreatDoMat(CgTreatDoMat cgTreatDoMat)
    {
        cgTreatDoMat.setCreateTime(DateUtils.getNowDate());
        return cgTreatDoMatMapper.insertCgTreatDoMat(cgTreatDoMat);
    }

    /**
     * 修改待办事件
     * 
     * @param cgTreatDoMat 待办事件
     * @return 结果
     */
    @Override
    public int updateCgTreatDoMat(CgTreatDoMat cgTreatDoMat)
    {
        cgTreatDoMat.setUpdateTime(DateUtils.getNowDate());
        return cgTreatDoMatMapper.updateCgTreatDoMat(cgTreatDoMat);
    }

    /**
     * 批量删除待办事件
     * 
     * @param ids 需要删除的待办事件主键
     * @return 结果
     */
    @Override
    public int deleteCgTreatDoMatByIds(Long[] ids)
    {
        return cgTreatDoMatMapper.deleteCgTreatDoMatByIds(ids);
    }

    /**
     * 删除待办事件信息
     * 
     * @param id 待办事件主键
     * @return 结果
     */
    @Override
    public int deleteCgTreatDoMatById(Long id)
    {
        return cgTreatDoMatMapper.deleteCgTreatDoMatById(id);
    }
}
