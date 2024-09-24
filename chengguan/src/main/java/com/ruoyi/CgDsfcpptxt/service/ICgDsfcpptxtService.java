package com.ruoyi.CgDsfcpptxt.service;

import java.util.List;
import com.ruoyi.CgDsfcpptxt.domain.CgDsfcpptxt;

/**
 * 第三方测评平台系统Service接口
 * 
 * @author ruoyi
 * @date 2024-08-27
 */
public interface ICgDsfcpptxtService 
{
    /**
     * 查询第三方测评平台系统
     * 
     * @param id 第三方测评平台系统主键
     * @return 第三方测评平台系统
     */
    public CgDsfcpptxt selectCgDsfcpptxtById(Long id);

    /**
     * 查询第三方测评平台系统列表
     * 
     * @param cgDsfcpptxt 第三方测评平台系统
     * @return 第三方测评平台系统集合
     */
    public List<CgDsfcpptxt> selectCgDsfcpptxtList(CgDsfcpptxt cgDsfcpptxt);

    /**
     * 新增第三方测评平台系统
     * 
     * @param cgDsfcpptxt 第三方测评平台系统
     * @return 结果
     */
    public int insertCgDsfcpptxt(CgDsfcpptxt cgDsfcpptxt);

    /**
     * 修改第三方测评平台系统
     * 
     * @param cgDsfcpptxt 第三方测评平台系统
     * @return 结果
     */
    public int updateCgDsfcpptxt(CgDsfcpptxt cgDsfcpptxt);

    /**
     * 批量删除第三方测评平台系统
     * 
     * @param ids 需要删除的第三方测评平台系统主键集合
     * @return 结果
     */
    public int deleteCgDsfcpptxtByIds(Long[] ids);

    /**
     * 删除第三方测评平台系统信息
     * 
     * @param id 第三方测评平台系统主键
     * @return 结果
     */
    public int deleteCgDsfcpptxtById(Long id);
}
