package com.ruoyi.CgShifouchaochu.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgShifouchaochu.mapper.CgShifouchaochuMapper;
import com.ruoyi.CgShifouchaochu.domain.CgShifouchaochu;
import com.ruoyi.CgShifouchaochu.service.ICgShifouchaochuService;

/**
 * 定位问题（是否超出）Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-30
 */
@Service
public class CgShifouchaochuServiceImpl implements ICgShifouchaochuService
{
    @Autowired
    private CgShifouchaochuMapper cgShifouchaochuMapper;

    /**
     * 查询定位问题（是否超出）
     * 
     * @param id 定位问题（是否超出）主键
     * @return 定位问题（是否超出）
     */
    @Override
    public CgShifouchaochu selectCgShifouchaochuById(Long id)
    {
        return cgShifouchaochuMapper.selectCgShifouchaochuById(id);
    }

    /**
     * 查询定位问题（是否超出）列表
     * 
     * @param cgShifouchaochu 定位问题（是否超出）
     * @return 定位问题（是否超出）
     */
    @Override
    public List<CgShifouchaochu> selectCgShifouchaochuList(CgShifouchaochu cgShifouchaochu)
    {
        return cgShifouchaochuMapper.selectCgShifouchaochuList(cgShifouchaochu);
    }

    @Override
    public List<CgShifouchaochu> getNowhistory(CgShifouchaochu cgShifouchaochu) {
        return cgShifouchaochuMapper.getNowhistory(cgShifouchaochu);
    }

    @Override
    public List<CgShifouchaochu> getDayids(CgShifouchaochu cgShifouchaochu) {
        return cgShifouchaochuMapper.getDayids(cgShifouchaochu);
    }
    @Override
public List<CgShifouchaochu> getDayWaichu(CgShifouchaochu cgShifouchaochu) {
    return cgShifouchaochuMapper.getDayWaichu(cgShifouchaochu);
}

    /**
     * 新增定位问题（是否超出）
     * 
     * @param cgShifouchaochu 定位问题（是否超出）
     * @return 结果
     */
    @Override
    public int insertCgShifouchaochu(CgShifouchaochu cgShifouchaochu)
    {
        cgShifouchaochu.setCreateTime(DateUtils.getNowDate());
        return cgShifouchaochuMapper.insertCgShifouchaochu(cgShifouchaochu);
    }

    /**
     * 修改定位问题（是否超出）
     * 
     * @param cgShifouchaochu 定位问题（是否超出）
     * @return 结果
     */
    @Override
    public int updateCgShifouchaochu(CgShifouchaochu cgShifouchaochu)
    {
        cgShifouchaochu.setUpdateTime(DateUtils.getNowDate());
        return cgShifouchaochuMapper.updateCgShifouchaochu(cgShifouchaochu);
    }

    /**
     * 批量删除定位问题（是否超出）
     * 
     * @param ids 需要删除的定位问题（是否超出）主键
     * @return 结果
     */
    @Override
    public int deleteCgShifouchaochuByIds(Long[] ids)
    {
        return cgShifouchaochuMapper.deleteCgShifouchaochuByIds(ids);
    }

    /**
     * 删除定位问题（是否超出）信息
     * 
     * @param id 定位问题（是否超出）主键
     * @return 结果
     */
    @Override
    public int deleteCgShifouchaochuById(Long id)
    {
        return cgShifouchaochuMapper.deleteCgShifouchaochuById(id);
    }
}
