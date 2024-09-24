package com.ruoyi.CgTeamKaohe.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgTeamKaohe.mapper.CgTeamKaoheMapper;
import com.ruoyi.CgTeamKaohe.domain.CgTeamKaohe;
import com.ruoyi.CgTeamKaohe.service.ICgTeamKaoheService;

/**
 * 每月队考核Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-22
 */
@Service
public class CgTeamKaoheServiceImpl implements ICgTeamKaoheService 
{
    @Autowired
    private CgTeamKaoheMapper cgTeamKaoheMapper;

    /**
     * 查询每月队考核
     * 
     * @param id 每月队考核主键
     * @return 每月队考核
     */
    @Override
    public CgTeamKaohe selectCgTeamKaoheById(Long id)
    {
        return cgTeamKaoheMapper.selectCgTeamKaoheById(id);
    }

    /**
     * 查询每月队考核列表
     * 
     * @param cgTeamKaohe 每月队考核
     * @return 每月队考核
     */
    @Override
    public List<CgTeamKaohe> selectCgTeamKaoheList(CgTeamKaohe cgTeamKaohe)
    {
        return cgTeamKaoheMapper.selectCgTeamKaoheList(cgTeamKaohe);
    }

    /**
     * 新增每月队考核
     * 
     * @param cgTeamKaohe 每月队考核
     * @return 结果
     */
    @Override
    public int insertCgTeamKaohe(CgTeamKaohe cgTeamKaohe)
    {
        cgTeamKaohe.setCreateTime(DateUtils.getNowDate());
        return cgTeamKaoheMapper.insertCgTeamKaohe(cgTeamKaohe);
    }

    /**
     * 修改每月队考核
     * 
     * @param cgTeamKaohe 每月队考核
     * @return 结果
     */
    @Override
    public int updateCgTeamKaohe(CgTeamKaohe cgTeamKaohe)
    {
        cgTeamKaohe.setUpdateTime(DateUtils.getNowDate());
        return cgTeamKaoheMapper.updateCgTeamKaohe(cgTeamKaohe);
    }

    /**
     * 批量删除每月队考核
     * 
     * @param ids 需要删除的每月队考核主键
     * @return 结果
     */
    @Override
    public int deleteCgTeamKaoheByIds(Long[] ids)
    {
        return cgTeamKaoheMapper.deleteCgTeamKaoheByIds(ids);
    }

    /**
     * 删除每月队考核信息
     * 
     * @param id 每月队考核主键
     * @return 结果
     */
    @Override
    public int deleteCgTeamKaoheById(Long id)
    {
        return cgTeamKaoheMapper.deleteCgTeamKaoheById(id);
    }
}
