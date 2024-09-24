package com.ruoyi.CgTeamKaohe.service;

import java.util.List;
import com.ruoyi.CgTeamKaohe.domain.CgTeamKaohe;

/**
 * 每月队考核Service接口
 * 
 * @author ruoyi
 * @date 2024-09-22
 */
public interface ICgTeamKaoheService 
{
    /**
     * 查询每月队考核
     * 
     * @param id 每月队考核主键
     * @return 每月队考核
     */
    public CgTeamKaohe selectCgTeamKaoheById(Long id);

    /**
     * 查询每月队考核列表
     * 
     * @param cgTeamKaohe 每月队考核
     * @return 每月队考核集合
     */
    public List<CgTeamKaohe> selectCgTeamKaoheList(CgTeamKaohe cgTeamKaohe);

    /**
     * 新增每月队考核
     * 
     * @param cgTeamKaohe 每月队考核
     * @return 结果
     */
    public int insertCgTeamKaohe(CgTeamKaohe cgTeamKaohe);

    /**
     * 修改每月队考核
     * 
     * @param cgTeamKaohe 每月队考核
     * @return 结果
     */
    public int updateCgTeamKaohe(CgTeamKaohe cgTeamKaohe);

    /**
     * 批量删除每月队考核
     * 
     * @param ids 需要删除的每月队考核主键集合
     * @return 结果
     */
    public int deleteCgTeamKaoheByIds(Long[] ids);

    /**
     * 删除每月队考核信息
     * 
     * @param id 每月队考核主键
     * @return 结果
     */
    public int deleteCgTeamKaoheById(Long id);
}
