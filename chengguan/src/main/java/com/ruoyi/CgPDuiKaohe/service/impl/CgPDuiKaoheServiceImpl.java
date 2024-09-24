package com.ruoyi.CgPDuiKaohe.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgPDuiKaohe.mapper.CgPDuiKaoheMapper;
import com.ruoyi.CgPDuiKaohe.domain.CgPDuiKaohe;
import com.ruoyi.CgPDuiKaohe.service.ICgPDuiKaoheService;

/**
 * 队考核Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
@Service
public class CgPDuiKaoheServiceImpl implements ICgPDuiKaoheService 
{
    @Autowired
    private CgPDuiKaoheMapper cgPDuiKaoheMapper;

    /**
     * 查询队考核
     * 
     * @param id 队考核主键
     * @return 队考核
     */
    @Override
    public CgPDuiKaohe selectCgPDuiKaoheById(Long id)
    {
        return cgPDuiKaoheMapper.selectCgPDuiKaoheById(id);
    }

    /**
     * 查询队考核列表
     * 
     * @param cgPDuiKaohe 队考核
     * @return 队考核
     */
    @Override
    public List<CgPDuiKaohe> selectCgPDuiKaoheList(CgPDuiKaohe cgPDuiKaohe)
    {
        return cgPDuiKaoheMapper.selectCgPDuiKaoheList(cgPDuiKaohe);
    }

    @Override
    public List<CgPDuiKaohe> qcsall(CgPDuiKaohe cgPDuiKaohe) {
        return cgPDuiKaoheMapper.qcsall(cgPDuiKaohe);
    }

    /**
     * 新增队考核
     * 
     * @param cgPDuiKaohe 队考核
     * @return 结果
     */
    @Override
    public int insertCgPDuiKaohe(CgPDuiKaohe cgPDuiKaohe)
    {
        cgPDuiKaohe.setCreateTime(DateUtils.getNowDate());
        return cgPDuiKaoheMapper.insertCgPDuiKaohe(cgPDuiKaohe);
    }

    /**
     * 修改队考核
     * 
     * @param cgPDuiKaohe 队考核
     * @return 结果
     */
    @Override
    public int updateCgPDuiKaohe(CgPDuiKaohe cgPDuiKaohe)
    {
        return cgPDuiKaoheMapper.updateCgPDuiKaohe(cgPDuiKaohe);
    }

    /**
     * 批量删除队考核
     * 
     * @param ids 需要删除的队考核主键
     * @return 结果
     */
    @Override
    public int deleteCgPDuiKaoheByIds(Long[] ids)
    {
        return cgPDuiKaoheMapper.deleteCgPDuiKaoheByIds(ids);
    }

    /**
     * 删除队考核信息
     * 
     * @param id 队考核主键
     * @return 结果
     */
    @Override
    public int deleteCgPDuiKaoheById(Long id)
    {
        return cgPDuiKaoheMapper.deleteCgPDuiKaoheById(id);
    }
}
