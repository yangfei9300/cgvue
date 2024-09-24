package com.ruoyi.CgPHszs.mapper;

import java.util.List;
import com.ruoyi.CgPHszs.domain.CgPHszs;

/**
 * 华山指数Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public interface CgPHszsMapper 
{
    /**
     * 查询华山指数
     * 
     * @param id 华山指数主键
     * @return 华山指数
     */
    public CgPHszs selectCgPHszsById(Long id);

    /**
     * 查询华山指数列表
     * 
     * @param cgPHszs 华山指数
     * @return 华山指数集合
     */
    public List<CgPHszs> selectCgPHszsList(CgPHszs cgPHszs);

    /**
     * 新增华山指数
     * 
     * @param cgPHszs 华山指数
     * @return 结果
     */
    public int insertCgPHszs(CgPHszs cgPHszs);

    /**
     * 修改华山指数
     * 
     * @param cgPHszs 华山指数
     * @return 结果
     */
    public int updateCgPHszs(CgPHszs cgPHszs);

    /**
     * 删除华山指数
     * 
     * @param id 华山指数主键
     * @return 结果
     */
    public int deleteCgPHszsById(Long id);

    /**
     * 批量删除华山指数
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgPHszsByIds(Long[] ids);
}
