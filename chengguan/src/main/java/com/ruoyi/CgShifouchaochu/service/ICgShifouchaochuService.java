package com.ruoyi.CgShifouchaochu.service;

import java.util.List;
import com.ruoyi.CgShifouchaochu.domain.CgShifouchaochu;

/**
 * 定位问题（是否超出）Service接口
 * 
 * @author ruoyi
 * @date 2024-08-30
 */
public interface ICgShifouchaochuService 
{
    /**
     * 查询定位问题（是否超出）
     * 
     * @param id 定位问题（是否超出）主键
     * @return 定位问题（是否超出）
     */
    public CgShifouchaochu selectCgShifouchaochuById(Long id);

    /**
     * 查询定位问题（是否超出）列表
     * 
     * @param cgShifouchaochu 定位问题（是否超出）
     * @return 定位问题（是否超出）集合
     */
    public List<CgShifouchaochu> selectCgShifouchaochuList(CgShifouchaochu cgShifouchaochu);
    public List<CgShifouchaochu> getNowhistory(CgShifouchaochu cgShifouchaochu);
    public List<CgShifouchaochu> getDayids(CgShifouchaochu cgShifouchaochu);
    public List<CgShifouchaochu> getDayWaichu(CgShifouchaochu cgShifouchaochu);
    /**
     * 新增定位问题（是否超出）
     * 
     * @param cgShifouchaochu 定位问题（是否超出）
     * @return 结果
     */
    public int insertCgShifouchaochu(CgShifouchaochu cgShifouchaochu);

    /**
     * 修改定位问题（是否超出）
     * 
     * @param cgShifouchaochu 定位问题（是否超出）
     * @return 结果
     */
    public int updateCgShifouchaochu(CgShifouchaochu cgShifouchaochu);

    /**
     * 批量删除定位问题（是否超出）
     * 
     * @param ids 需要删除的定位问题（是否超出）主键集合
     * @return 结果
     */
    public int deleteCgShifouchaochuByIds(Long[] ids);

    /**
     * 删除定位问题（是否超出）信息
     * 
     * @param id 定位问题（是否超出）主键
     * @return 结果
     */
    public int deleteCgShifouchaochuById(Long id);
}
