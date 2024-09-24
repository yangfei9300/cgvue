package com.ruoyi.CgTeam.service;

import java.util.List;
import com.ruoyi.CgTeam.domain.CgTeam;

/**
 * 队伍列Service接口
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
public interface ICgTeamService 
{
    /**
     * 查询队伍列
     * 
     * @param id 队伍列主键
     * @return 队伍列
     */
    public CgTeam selectCgTeamById(Long id);

    /**
     * 查询队伍列列表
     * 
     * @param cgTeam 队伍列
     * @return 队伍列集合
     */
    public List<CgTeam> selectCgTeamList(CgTeam cgTeam);

    /**
     * 新增队伍列
     * 
     * @param cgTeam 队伍列
     * @return 结果
     */
    public int insertCgTeam(CgTeam cgTeam);

    /**
     * 修改队伍列
     * 
     * @param cgTeam 队伍列
     * @return 结果
     */
    public int updateCgTeam(CgTeam cgTeam);

    /**
     * 批量删除队伍列
     * 
     * @param ids 需要删除的队伍列主键集合
     * @return 结果
     */
    public int deleteCgTeamByIds(Long[] ids);

    /**
     * 删除队伍列信息
     * 
     * @param id 队伍列主键
     * @return 结果
     */
    public int deleteCgTeamById(Long id);
}
