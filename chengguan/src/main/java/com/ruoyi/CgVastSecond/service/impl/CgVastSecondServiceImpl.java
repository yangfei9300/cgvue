package com.ruoyi.CgVastSecond.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgVastSecond.mapper.CgVastSecondMapper;
import com.ruoyi.CgVastSecond.domain.CgVastSecond;
import com.ruoyi.CgVastSecond.service.ICgVastSecondService;

/**
 * 旷工时间Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-02
 */
@Service
public class CgVastSecondServiceImpl implements ICgVastSecondService 
{
    @Autowired
    private CgVastSecondMapper cgVastSecondMapper;

    /**
     * 查询旷工时间
     * 
     * @param id 旷工时间主键
     * @return 旷工时间
     */
    @Override
    public CgVastSecond selectCgVastSecondById(Long id)
    {
        return cgVastSecondMapper.selectCgVastSecondById(id);
    }

    /**
     * 查询旷工时间列表
     * 
     * @param cgVastSecond 旷工时间
     * @return 旷工时间
     */
    @Override
    public List<CgVastSecond> selectCgVastSecondList(CgVastSecond cgVastSecond)
    {
        return cgVastSecondMapper.selectCgVastSecondList(cgVastSecond);
    }

    @Override
    public List<CgVastSecond> getDayUserids(CgVastSecond cgVastSecond) {
        return cgVastSecondMapper.getDayUserids(cgVastSecond);
    }

    /**
     * 新增旷工时间
     * 
     * @param cgVastSecond 旷工时间
     * @return 结果
     */
    @Override
    public int insertCgVastSecond(CgVastSecond cgVastSecond)
    {
        cgVastSecond.setCreateTime(DateUtils.getNowDate());
        return cgVastSecondMapper.insertCgVastSecond(cgVastSecond);
    }

    /**
     * 修改旷工时间
     * 
     * @param cgVastSecond 旷工时间
     * @return 结果
     */
    @Override
    public int updateCgVastSecond(CgVastSecond cgVastSecond)
    {
        return cgVastSecondMapper.updateCgVastSecond(cgVastSecond);
    }

    /**
     * 批量删除旷工时间
     * 
     * @param ids 需要删除的旷工时间主键
     * @return 结果
     */
    @Override
    public int deleteCgVastSecondByIds(Long[] ids)
    {
        return cgVastSecondMapper.deleteCgVastSecondByIds(ids);
    }

    /**
     * 删除旷工时间信息
     * 
     * @param id 旷工时间主键
     * @return 结果
     */
    @Override
    public int deleteCgVastSecondById(Long id)
    {
        return cgVastSecondMapper.deleteCgVastSecondById(id);
    }
}
