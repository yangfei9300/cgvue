package com.ruoyi.cg_p_ssx.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cg_p_ssx.mapper.CgPSsxMapper;
import com.ruoyi.cg_p_ssx.domain.CgPSsx;

/**
 * 十四扣分项Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
@Service
public class CgPSsxServiceImpl implements com.ruoyi.cg_p_ssx.service.impl.ICgPSsxService
{
    @Autowired
    private CgPSsxMapper cgPSsxMapper;

    /**
     * 查询十四扣分项
     * 
     * @param id 十四扣分项主键
     * @return 十四扣分项
     */
    @Override
    public CgPSsx selectCgPSsxById(Long id)
    {
        return cgPSsxMapper.selectCgPSsxById(id);
    }

    /**
     * 查询十四扣分项列表
     * 
     * @param cgPSsx 十四扣分项
     * @return 十四扣分项
     */
    @Override
    public List<CgPSsx> selectCgPSsxList(CgPSsx cgPSsx)
    {
        return cgPSsxMapper.selectCgPSsxList(cgPSsx);
    }

    /**
     * 新增十四扣分项
     * 
     * @param cgPSsx 十四扣分项
     * @return 结果
     */
    @Override
    public int insertCgPSsx(CgPSsx cgPSsx)
    {
        cgPSsx.setCreateTime(DateUtils.getNowDate());
        return cgPSsxMapper.insertCgPSsx(cgPSsx);
    }

    /**
     * 修改十四扣分项
     * 
     * @param cgPSsx 十四扣分项
     * @return 结果
     */
    @Override
    public int updateCgPSsx(CgPSsx cgPSsx)
    {
        return cgPSsxMapper.updateCgPSsx(cgPSsx);
    }

    /**
     * 批量删除十四扣分项
     * 
     * @param ids 需要删除的十四扣分项主键
     * @return 结果
     */
    @Override
    public int deleteCgPSsxByIds(Long[] ids)
    {
        return cgPSsxMapper.deleteCgPSsxByIds(ids);
    }

    /**
     * 删除十四扣分项信息
     * 
     * @param id 十四扣分项主键
     * @return 结果
     */
    @Override
    public int deleteCgPSsxById(Long id)
    {
        return cgPSsxMapper.deleteCgPSsxById(id);
    }
}
