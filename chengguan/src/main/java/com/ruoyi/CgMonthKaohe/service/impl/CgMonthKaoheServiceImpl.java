package com.ruoyi.CgMonthKaohe.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgMonthKaohe.mapper.CgMonthKaoheMapper;
import com.ruoyi.CgMonthKaohe.domain.CgMonthKaohe;
import com.ruoyi.CgMonthKaohe.service.ICgMonthKaoheService;

/**
 * 每月考勤Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-13
 */
@Service
public class CgMonthKaoheServiceImpl implements ICgMonthKaoheService
{
    @Autowired
    private CgMonthKaoheMapper cgMonthKaoheMapper;

    /**
     * 查询每月考勤
     * 
     * @param id 每月考勤主键
     * @return 每月考勤
     */
    @Override
    public CgMonthKaohe selectCgMonthKaoheById(Long id)
    {
        return cgMonthKaoheMapper.selectCgMonthKaoheById(id);
    }

    /**
     * 查询每月考勤列表
     * 
     * @param cgMonthKaohe 每月考勤
     * @return 每月考勤
     */
    @Override
    public List<CgMonthKaohe> selectCgMonthKaoheList(CgMonthKaohe cgMonthKaohe)
    {
        return cgMonthKaoheMapper.selectCgMonthKaoheList(cgMonthKaohe);
    }

    @Override
    public List<CgMonthKaohe> selectCgMonthKaoheList1(CgMonthKaohe cgMonthKaohe) {
        return cgMonthKaoheMapper.selectCgMonthKaoheList1(cgMonthKaohe);
    }

    @Override
    public List<CgMonthKaohe> getTeamLaohe(CgMonthKaohe cgMonthKaohe) {
        return cgMonthKaoheMapper.getTeamLaohe(cgMonthKaohe);
    }


    /**
     * 新增每月考勤
     * 
     * @param cgMonthKaohe 每月考勤
     * @return 结果
     */
    @Override
    public int insertCgMonthKaohe(CgMonthKaohe cgMonthKaohe)
    {
        cgMonthKaohe.setCreateTime(DateUtils.getNowDate());
        return cgMonthKaoheMapper.insertCgMonthKaohe(cgMonthKaohe);
    }

    /**
     * 修改每月考勤
     * 
     * @param cgMonthKaohe 每月考勤
     * @return 结果
     */
    @Override
    public int updateCgMonthKaohe(CgMonthKaohe cgMonthKaohe)
    {
        cgMonthKaohe.setUpdateTime(DateUtils.getNowDate());
        return cgMonthKaoheMapper.updateCgMonthKaohe(cgMonthKaohe);
    }

    /**
     * 批量删除每月考勤
     * 
     * @param ids 需要删除的每月考勤主键
     * @return 结果
     */
    @Override
    public int deleteCgMonthKaoheByIds(Long[] ids)
    {
        return cgMonthKaoheMapper.deleteCgMonthKaoheByIds(ids);
    }

    /**
     * 删除每月考勤信息
     * 
     * @param id 每月考勤主键
     * @return 结果
     */
    @Override
    public int deleteCgMonthKaoheById(Long id)
    {
        return cgMonthKaoheMapper.deleteCgMonthKaoheById(id);
    }
}
