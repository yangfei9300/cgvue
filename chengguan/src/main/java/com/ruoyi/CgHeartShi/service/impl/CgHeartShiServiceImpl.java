package com.ruoyi.CgHeartShi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgHeartShi.mapper.CgHeartShiMapper;
import com.ruoyi.CgHeartShi.domain.CgHeartShi;
import com.ruoyi.CgHeartShi.service.ICgHeartShiService;

/**
 * 热心服务事项Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
@Service
public class CgHeartShiServiceImpl implements ICgHeartShiService 
{
    @Autowired
    private CgHeartShiMapper cgHeartShiMapper;

    /**
     * 查询热心服务事项
     * 
     * @param id 热心服务事项主键
     * @return 热心服务事项
     */
    @Override
    public CgHeartShi selectCgHeartShiById(Long id)
    {
        return cgHeartShiMapper.selectCgHeartShiById(id);
    }

    /**
     * 查询热心服务事项列表
     * 
     * @param cgHeartShi 热心服务事项
     * @return 热心服务事项
     */
    @Override
    public List<CgHeartShi> selectCgHeartShiList(CgHeartShi cgHeartShi)
    {
        return cgHeartShiMapper.selectCgHeartShiList(cgHeartShi);
    }

    @Override
    public List<CgHeartShi> getMyHrhs(CgHeartShi cgHeartShi) {
        return cgHeartShiMapper.getMyHrhs(cgHeartShi);
    }

    @Override
    public List<CgHeartShi> getHearts(CgHeartShi cgHeartShi) {
        return cgHeartShiMapper.getHearts(cgHeartShi);
    }

    /**
     * 新增热心服务事项
     * 
     * @param cgHeartShi 热心服务事项
     * @return 结果
     */
    @Override
    public int insertCgHeartShi(CgHeartShi cgHeartShi)
    {
        cgHeartShi.setCreateTime(DateUtils.getNowDate());
        return cgHeartShiMapper.insertCgHeartShi(cgHeartShi);
    }

    /**
     * 修改热心服务事项
     * 
     * @param cgHeartShi 热心服务事项
     * @return 结果
     */
    @Override
    public int updateCgHeartShi(CgHeartShi cgHeartShi)
    {
        cgHeartShi.setUpdateTime(DateUtils.getNowDate());
        return cgHeartShiMapper.updateCgHeartShi(cgHeartShi);
    }

    /**
     * 批量删除热心服务事项
     * 
     * @param ids 需要删除的热心服务事项主键
     * @return 结果
     */
    @Override
    public int deleteCgHeartShiByIds(Long[] ids)
    {
        return cgHeartShiMapper.deleteCgHeartShiByIds(ids);
    }

    /**
     * 删除热心服务事项信息
     * 
     * @param id 热心服务事项主键
     * @return 结果
     */
    @Override
    public int deleteCgHeartShiById(Long id)
    {
        return cgHeartShiMapper.deleteCgHeartShiById(id);
    }
}
