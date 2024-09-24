package com.ruoyi.CgTeamKaohe.mapper;

import java.util.List;
import com.ruoyi.CgTeamKaohe.domain.CgTeamKaohe;

/**
 * 每月队考核Mapper接口
 * 
 * @author ruoyi
 * @date 2024-09-22
 */
public interface CgTeamKaoheMapper 
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
     * 删除每月队考核
     * 
     * @param id 每月队考核主键
     * @return 结果
     */
    public int deleteCgTeamKaoheById(Long id);

    /**
     * 批量删除每月队考核
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgTeamKaoheByIds(Long[] ids);
}
