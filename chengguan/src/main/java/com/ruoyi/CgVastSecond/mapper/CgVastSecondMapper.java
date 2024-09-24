package com.ruoyi.CgVastSecond.mapper;

import java.util.List;
import com.ruoyi.CgVastSecond.domain.CgVastSecond;

/**
 * 旷工时间Mapper接口
 * 
 * @author ruoyi
 * @date 2024-09-02
 */
public interface CgVastSecondMapper 
{
    /**
     * 查询旷工时间
     * 
     * @param id 旷工时间主键
     * @return 旷工时间
     */
    public CgVastSecond selectCgVastSecondById(Long id);

    /**
     * 查询旷工时间列表
     * 
     * @param cgVastSecond 旷工时间
     * @return 旷工时间集合
     */
    public List<CgVastSecond> selectCgVastSecondList(CgVastSecond cgVastSecond);
    public List<CgVastSecond> getDayUserids(CgVastSecond cgVastSecond);



    /**
     * 新增旷工时间
     * 
     * @param cgVastSecond 旷工时间
     * @return 结果
     */
    public int insertCgVastSecond(CgVastSecond cgVastSecond);

    /**
     * 修改旷工时间
     * 
     * @param cgVastSecond 旷工时间
     * @return 结果
     */
    public int updateCgVastSecond(CgVastSecond cgVastSecond);

    /**
     * 删除旷工时间
     * 
     * @param id 旷工时间主键
     * @return 结果
     */
    public int deleteCgVastSecondById(Long id);

    /**
     * 批量删除旷工时间
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgVastSecondByIds(Long[] ids);
}
