package com.ruoyi.CgDsfcpptxt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgDsfcpptxt.mapper.CgDsfcpptxtMapper;
import com.ruoyi.CgDsfcpptxt.domain.CgDsfcpptxt;
import com.ruoyi.CgDsfcpptxt.service.ICgDsfcpptxtService;

/**
 * 第三方测评平台系统Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-27
 */
@Service
public class CgDsfcpptxtServiceImpl implements ICgDsfcpptxtService 
{
    @Autowired
    private CgDsfcpptxtMapper cgDsfcpptxtMapper;

    /**
     * 查询第三方测评平台系统
     * 
     * @param id 第三方测评平台系统主键
     * @return 第三方测评平台系统
     */
    @Override
    public CgDsfcpptxt selectCgDsfcpptxtById(Long id)
    {
        return cgDsfcpptxtMapper.selectCgDsfcpptxtById(id);
    }

    /**
     * 查询第三方测评平台系统列表
     * 
     * @param cgDsfcpptxt 第三方测评平台系统
     * @return 第三方测评平台系统
     */
    @Override
    public List<CgDsfcpptxt> selectCgDsfcpptxtList(CgDsfcpptxt cgDsfcpptxt)
    {
        return cgDsfcpptxtMapper.selectCgDsfcpptxtList(cgDsfcpptxt);
    }

    /**
     * 新增第三方测评平台系统
     * 
     * @param cgDsfcpptxt 第三方测评平台系统
     * @return 结果
     */
    @Override
    public int insertCgDsfcpptxt(CgDsfcpptxt cgDsfcpptxt)
    {
        cgDsfcpptxt.setCreateTime(DateUtils.getNowDate());
        return cgDsfcpptxtMapper.insertCgDsfcpptxt(cgDsfcpptxt);
    }

    /**
     * 修改第三方测评平台系统
     * 
     * @param cgDsfcpptxt 第三方测评平台系统
     * @return 结果
     */
    @Override
    public int updateCgDsfcpptxt(CgDsfcpptxt cgDsfcpptxt)
    {
        cgDsfcpptxt.setUpdateTime(DateUtils.getNowDate());
        return cgDsfcpptxtMapper.updateCgDsfcpptxt(cgDsfcpptxt);
    }

    /**
     * 批量删除第三方测评平台系统
     * 
     * @param ids 需要删除的第三方测评平台系统主键
     * @return 结果
     */
    @Override
    public int deleteCgDsfcpptxtByIds(Long[] ids)
    {
        return cgDsfcpptxtMapper.deleteCgDsfcpptxtByIds(ids);
    }

    /**
     * 删除第三方测评平台系统信息
     * 
     * @param id 第三方测评平台系统主键
     * @return 结果
     */
    @Override
    public int deleteCgDsfcpptxtById(Long id)
    {
        return cgDsfcpptxtMapper.deleteCgDsfcpptxtById(id);
    }
}
