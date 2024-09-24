package com.ruoyi.CgScheduling.mapper;

import java.util.List;
import com.ruoyi.CgScheduling.domain.CgScheduling;

/**
 * 上班时刻Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
public interface CgSchedulingMapper 
{
    /**
     * 查询上班时刻
     * 
     * @param id 上班时刻主键
     * @return 上班时刻
     */
    public CgScheduling selectCgSchedulingById(Long id);

    /**
     * 查询上班时刻列表
     * 
     * @param cgScheduling 上班时刻
     * @return 上班时刻集合
     */
    public List<CgScheduling> selectCgSchedulingList(CgScheduling cgScheduling);

    /**
     * 新增上班时刻
     * 
     * @param cgScheduling 上班时刻
     * @return 结果
     */
    public int insertCgScheduling(CgScheduling cgScheduling);

    /**
     * 修改上班时刻
     * 
     * @param cgScheduling 上班时刻
     * @return 结果
     */
    public int updateCgScheduling(CgScheduling cgScheduling);

    /**
     * 删除上班时刻
     * 
     * @param id 上班时刻主键
     * @return 结果
     */
    public int deleteCgSchedulingById(Long id);

    /**
     * 批量删除上班时刻
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgSchedulingByIds(Long[] ids);
}
