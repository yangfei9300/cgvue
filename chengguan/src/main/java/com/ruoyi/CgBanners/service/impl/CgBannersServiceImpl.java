package com.ruoyi.CgBanners.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgBanners.mapper.CgBannersMapper;
import com.ruoyi.CgBanners.domain.CgBanners;
import com.ruoyi.CgBanners.service.ICgBannersService;

/**
 * 轮播图Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
@Service
public class CgBannersServiceImpl implements ICgBannersService 
{
    @Autowired
    private CgBannersMapper cgBannersMapper;

    /**
     * 查询轮播图
     * 
     * @param id 轮播图主键
     * @return 轮播图
     */
    @Override
    public CgBanners selectCgBannersById(Long id)
    {
        return cgBannersMapper.selectCgBannersById(id);
    }

    /**
     * 查询轮播图列表
     * 
     * @param cgBanners 轮播图
     * @return 轮播图
     */
    @Override
    public List<CgBanners> selectCgBannersList(CgBanners cgBanners)
    {
        return cgBannersMapper.selectCgBannersList(cgBanners);
    }

    /**
     * 新增轮播图
     * 
     * @param cgBanners 轮播图
     * @return 结果
     */
    @Override
    public int insertCgBanners(CgBanners cgBanners)
    {
        cgBanners.setCreateTime(DateUtils.getNowDate());
        return cgBannersMapper.insertCgBanners(cgBanners);
    }

    /**
     * 修改轮播图
     * 
     * @param cgBanners 轮播图
     * @return 结果
     */
    @Override
    public int updateCgBanners(CgBanners cgBanners)
    {
        cgBanners.setUpdateTime(DateUtils.getNowDate());
        return cgBannersMapper.updateCgBanners(cgBanners);
    }

    /**
     * 批量删除轮播图
     * 
     * @param ids 需要删除的轮播图主键
     * @return 结果
     */
    @Override
    public int deleteCgBannersByIds(Long[] ids)
    {
        return cgBannersMapper.deleteCgBannersByIds(ids);
    }

    /**
     * 删除轮播图信息
     * 
     * @param id 轮播图主键
     * @return 结果
     */
    @Override
    public int deleteCgBannersById(Long id)
    {
        return cgBannersMapper.deleteCgBannersById(id);
    }
}
