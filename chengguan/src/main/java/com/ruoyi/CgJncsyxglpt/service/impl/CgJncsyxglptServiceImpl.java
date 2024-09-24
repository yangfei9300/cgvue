package com.ruoyi.CgJncsyxglpt.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgJncsyxglpt.mapper.CgJncsyxglptMapper;
import com.ruoyi.CgJncsyxglpt.domain.CgJncsyxglpt;
import com.ruoyi.CgJncsyxglpt.service.ICgJncsyxglptService;

/**
 * 济南市城市服务运行管理平台Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-23
 */
@Service
public class CgJncsyxglptServiceImpl implements ICgJncsyxglptService 
{
    @Autowired
    private CgJncsyxglptMapper cgJncsyxglptMapper;

    /**
     * 查询济南市城市服务运行管理平台
     * 
     * @param id 济南市城市服务运行管理平台主键
     * @return 济南市城市服务运行管理平台
     */
    @Override
    public CgJncsyxglpt selectCgJncsyxglptById(Long id)
    {
        return cgJncsyxglptMapper.selectCgJncsyxglptById(id);
    }

    /**
     * 查询济南市城市服务运行管理平台列表
     * 
     * @param cgJncsyxglpt 济南市城市服务运行管理平台
     * @return 济南市城市服务运行管理平台
     */
    @Override
    public List<CgJncsyxglpt> selectCgJncsyxglptList(CgJncsyxglpt cgJncsyxglpt)
    {
        return cgJncsyxglptMapper.selectCgJncsyxglptList(cgJncsyxglpt);
    }

    /**
     * 新增济南市城市服务运行管理平台
     * 
     * @param cgJncsyxglpt 济南市城市服务运行管理平台
     * @return 结果
     */
    @Override
    public int insertCgJncsyxglpt(CgJncsyxglpt cgJncsyxglpt)
    {
        cgJncsyxglpt.setCreateTime(DateUtils.getNowDate());
        return cgJncsyxglptMapper.insertCgJncsyxglpt(cgJncsyxglpt);
    }

    /**
     * 修改济南市城市服务运行管理平台
     * 
     * @param cgJncsyxglpt 济南市城市服务运行管理平台
     * @return 结果
     */
    @Override
    public int updateCgJncsyxglpt(CgJncsyxglpt cgJncsyxglpt)
    {
        cgJncsyxglpt.setUpdateTime(DateUtils.getNowDate());
        return cgJncsyxglptMapper.updateCgJncsyxglpt(cgJncsyxglpt);
    }

    /**
     * 批量删除济南市城市服务运行管理平台
     * 
     * @param ids 需要删除的济南市城市服务运行管理平台主键
     * @return 结果
     */
    @Override
    public int deleteCgJncsyxglptByIds(Long[] ids)
    {
        return cgJncsyxglptMapper.deleteCgJncsyxglptByIds(ids);
    }

    /**
     * 删除济南市城市服务运行管理平台信息
     * 
     * @param id 济南市城市服务运行管理平台主键
     * @return 结果
     */
    @Override
    public int deleteCgJncsyxglptById(Long id)
    {
        return cgJncsyxglptMapper.deleteCgJncsyxglptById(id);
    }
}
