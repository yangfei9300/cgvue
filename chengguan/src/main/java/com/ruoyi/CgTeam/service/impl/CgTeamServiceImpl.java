package com.ruoyi.CgTeam.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgTeam.mapper.CgTeamMapper;
import com.ruoyi.CgTeam.domain.CgTeam;
import com.ruoyi.CgTeam.service.ICgTeamService;

/**
 * 队伍列Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
@Service
public class CgTeamServiceImpl implements ICgTeamService 
{
    @Autowired
    private CgTeamMapper cgTeamMapper;

    /**
     * 查询队伍列
     * 
     * @param id 队伍列主键
     * @return 队伍列
     */
    @Override
    public CgTeam selectCgTeamById(Long id)
    {
        return cgTeamMapper.selectCgTeamById(id);
    }

    /**
     * 查询队伍列列表
     * 
     * @param cgTeam 队伍列
     * @return 队伍列
     */
    @Override
    public List<CgTeam> selectCgTeamList(CgTeam cgTeam)
    {
        return cgTeamMapper.selectCgTeamList(cgTeam);
    }

    /**
     * 新增队伍列
     * 
     * @param cgTeam 队伍列
     * @return 结果
     */
    @Override
    public int insertCgTeam(CgTeam cgTeam)
    {
        cgTeam.setCreateTime(DateUtils.getNowDate());
        return cgTeamMapper.insertCgTeam(cgTeam);
    }

    /**
     * 修改队伍列
     * 
     * @param cgTeam 队伍列
     * @return 结果
     */
    @Override
    public int updateCgTeam(CgTeam cgTeam)
    {
        cgTeam.setUpdateTime(DateUtils.getNowDate());
        return cgTeamMapper.updateCgTeam(cgTeam);
    }

    /**
     * 批量删除队伍列
     * 
     * @param ids 需要删除的队伍列主键
     * @return 结果
     */
    @Override
    public int deleteCgTeamByIds(Long[] ids)
    {
        return cgTeamMapper.deleteCgTeamByIds(ids);
    }

    /**
     * 删除队伍列信息
     * 
     * @param id 队伍列主键
     * @return 结果
     */
    @Override
    public int deleteCgTeamById(Long id)
    {
        return cgTeamMapper.deleteCgTeamById(id);
    }
}
