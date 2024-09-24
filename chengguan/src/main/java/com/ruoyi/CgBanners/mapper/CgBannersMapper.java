package com.ruoyi.CgBanners.mapper;

import java.util.List;
import com.ruoyi.CgBanners.domain.CgBanners;

/**
 * 轮播图Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
public interface CgBannersMapper 
{
    /**
     * 查询轮播图
     * 
     * @param id 轮播图主键
     * @return 轮播图
     */
    public CgBanners selectCgBannersById(Long id);

    /**
     * 查询轮播图列表
     * 
     * @param cgBanners 轮播图
     * @return 轮播图集合
     */
    public List<CgBanners> selectCgBannersList(CgBanners cgBanners);

    /**
     * 新增轮播图
     * 
     * @param cgBanners 轮播图
     * @return 结果
     */
    public int insertCgBanners(CgBanners cgBanners);

    /**
     * 修改轮播图
     * 
     * @param cgBanners 轮播图
     * @return 结果
     */
    public int updateCgBanners(CgBanners cgBanners);

    /**
     * 删除轮播图
     * 
     * @param id 轮播图主键
     * @return 结果
     */
    public int deleteCgBannersById(Long id);

    /**
     * 批量删除轮播图
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgBannersByIds(Long[] ids);
}
