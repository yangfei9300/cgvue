package com.ruoyi.CgMonthKaohe.mapper;

import java.util.List;
import com.ruoyi.CgMonthKaohe.domain.CgMonthKaohe;

/**
 * 每月考勤Mapper接口
 * 
 * @author ruoyi
 * @date 2024-09-13
 */
public interface CgMonthKaoheMapper 
{
    /**
     * 查询每月考勤
     * 
     * @param id 每月考勤主键
     * @return 每月考勤
     */
    public CgMonthKaohe selectCgMonthKaoheById(Long id);

    /**
     * 查询每月考勤列表
     * 
     * @param cgMonthKaohe 每月考勤
     * @return 每月考勤集合
     */
    public List<CgMonthKaohe> selectCgMonthKaoheList(CgMonthKaohe cgMonthKaohe);
    public List<CgMonthKaohe> selectCgMonthKaoheList1(CgMonthKaohe cgMonthKaohe);
    public List<CgMonthKaohe> getTeamLaohe(CgMonthKaohe cgMonthKaohe);




    /**
     * 新增每月考勤
     * 
     * @param cgMonthKaohe 每月考勤
     * @return 结果
     */
    public int insertCgMonthKaohe(CgMonthKaohe cgMonthKaohe);

    /**
     * 修改每月考勤
     * 
     * @param cgMonthKaohe 每月考勤
     * @return 结果
     */
    public int updateCgMonthKaohe(CgMonthKaohe cgMonthKaohe);

    /**
     * 删除每月考勤
     * 
     * @param id 每月考勤主键
     * @return 结果
     */
    public int deleteCgMonthKaoheById(Long id);

    /**
     * 批量删除每月考勤
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgMonthKaoheByIds(Long[] ids);
}
