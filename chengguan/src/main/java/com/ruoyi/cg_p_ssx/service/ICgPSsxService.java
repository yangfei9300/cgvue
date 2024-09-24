package com.ruoyi.cg_p_ssx.service.impl;
import java.util.List;
import com.ruoyi.cg_p_ssx.domain.CgPSsx;

/**
 * 十四扣分项Service接口
 *
 * @author ruoyi
 * @date 2024-08-30
 */
public interface ICgPSsxService
{
    /**
     * 查询十四扣分项
     *
     * @param id 十四扣分项主键
     * @return 十四扣分项
     */
    public CgPSsx selectCgPSsxById(Long id);

    /**
     * 查询十四扣分项列表
     *
     * @param cgPSsx 十四扣分项
     * @return 十四扣分项集合
     */
    public List<CgPSsx> selectCgPSsxList(CgPSsx cgPSsx);

    /**
     * 新增十四扣分项
     *
     * @param cgPSsx 十四扣分项
     * @return 结果
     */
    public int insertCgPSsx(CgPSsx cgPSsx);

    /**
     * 修改十四扣分项
     *
     * @param cgPSsx 十四扣分项
     * @return 结果
     */
    public int updateCgPSsx(CgPSsx cgPSsx);

    /**
     * 批量删除十四扣分项
     *
     * @param ids 需要删除的十四扣分项主键集合
     * @return 结果
     */
    public int deleteCgPSsxByIds(Long[] ids);

    /**
     * 删除十四扣分项信息
     *
     * @param id 十四扣分项主键
     * @return 结果
     */
    public int deleteCgPSsxById(Long id);
}
