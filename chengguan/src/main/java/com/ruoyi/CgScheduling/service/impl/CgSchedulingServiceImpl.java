package com.ruoyi.CgScheduling.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgScheduling.mapper.CgSchedulingMapper;
import com.ruoyi.CgScheduling.domain.CgScheduling;
import com.ruoyi.CgScheduling.service.ICgSchedulingService;

/**
 * 上班时刻Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
@Service
public class CgSchedulingServiceImpl implements ICgSchedulingService 
{
    @Autowired
    private CgSchedulingMapper cgSchedulingMapper;

    /**
     * 查询上班时刻
     * 
     * @param id 上班时刻主键
     * @return 上班时刻
     */
    @Override
    public CgScheduling selectCgSchedulingById(Long id)
    {
        return cgSchedulingMapper.selectCgSchedulingById(id);
    }

    /**
     * 查询上班时刻列表
     * 
     * @param cgScheduling 上班时刻
     * @return 上班时刻
     */
    @Override
    public List<CgScheduling> selectCgSchedulingList(CgScheduling cgScheduling)
    {
        return cgSchedulingMapper.selectCgSchedulingList(cgScheduling);
    }

    /**
     * 新增上班时刻
     * 
     * @param cgScheduling 上班时刻
     * @return 结果
     */
    @Override
    public int insertCgScheduling(CgScheduling cgScheduling)
    {
        cgScheduling.setCreateTime(DateUtils.getNowDate());
        return cgSchedulingMapper.insertCgScheduling(cgScheduling);
    }

    /**
     * 修改上班时刻
     * 
     * @param cgScheduling 上班时刻
     * @return 结果
     */
    @Override
    public int updateCgScheduling(CgScheduling cgScheduling)
    {
        cgScheduling.setUpdateTime(DateUtils.getNowDate());
        return cgSchedulingMapper.updateCgScheduling(cgScheduling);
    }

    /**
     * 批量删除上班时刻
     * 
     * @param ids 需要删除的上班时刻主键
     * @return 结果
     */
    @Override
    public int deleteCgSchedulingByIds(Long[] ids)
    {
        return cgSchedulingMapper.deleteCgSchedulingByIds(ids);
    }

    /**
     * 删除上班时刻信息
     * 
     * @param id 上班时刻主键
     * @return 结果
     */
    @Override
    public int deleteCgSchedulingById(Long id)
    {
        return cgSchedulingMapper.deleteCgSchedulingById(id);
    }
}
