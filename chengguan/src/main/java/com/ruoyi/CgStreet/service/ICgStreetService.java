package com.ruoyi.CgStreet.service;

import java.util.List;
import com.ruoyi.CgStreet.domain.CgStreet;

/**
 * 街道Service接口
 * 
 * @author ruoyi
 * @date 2024-08-19
 */
public interface ICgStreetService 
{
    /**
     * 查询街道
     * 
     * @param id 街道主键
     * @return 街道
     */
    public CgStreet selectCgStreetById(Long id);

    /**
     * 查询街道列表
     * 
     * @param cgStreet 街道
     * @return 街道集合
     */
    public List<CgStreet> selectCgStreetList(CgStreet cgStreet);

    /**
     * 新增街道
     * 
     * @param cgStreet 街道
     * @return 结果
     */
    public int insertCgStreet(CgStreet cgStreet);

    /**
     * 修改街道
     * 
     * @param cgStreet 街道
     * @return 结果
     */
    public int updateCgStreet(CgStreet cgStreet);

    /**
     * 批量删除街道
     * 
     * @param ids 需要删除的街道主键集合
     * @return 结果
     */
    public int deleteCgStreetByIds(Long[] ids);

    /**
     * 删除街道信息
     * 
     * @param id 街道主键
     * @return 结果
     */
    public int deleteCgStreetById(Long id);
}
