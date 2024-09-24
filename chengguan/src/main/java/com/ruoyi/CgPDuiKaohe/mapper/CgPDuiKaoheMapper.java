package com.ruoyi.CgPDuiKaohe.mapper;

import java.util.List;
import com.ruoyi.CgPDuiKaohe.domain.CgPDuiKaohe;

/**
 * 队考核Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
public interface CgPDuiKaoheMapper 
{
    /**
     * 查询队考核
     * 
     * @param id 队考核主键
     * @return 队考核
     */
    public CgPDuiKaohe selectCgPDuiKaoheById(Long id);

    /**
     * 查询队考核列表
     * 
     * @param cgPDuiKaohe 队考核
     * @return 队考核集合
     */
    public List<CgPDuiKaohe> selectCgPDuiKaoheList(CgPDuiKaohe cgPDuiKaohe);
    public List<CgPDuiKaohe> qcsall(CgPDuiKaohe cgPDuiKaohe);



    /**
     * 新增队考核
     * 
     * @param cgPDuiKaohe 队考核
     * @return 结果
     */
    public int insertCgPDuiKaohe(CgPDuiKaohe cgPDuiKaohe);

    /**
     * 修改队考核
     * 
     * @param cgPDuiKaohe 队考核
     * @return 结果
     */
    public int updateCgPDuiKaohe(CgPDuiKaohe cgPDuiKaohe);

    /**
     * 删除队考核
     * 
     * @param id 队考核主键
     * @return 结果
     */
    public int deleteCgPDuiKaoheById(Long id);

    /**
     * 批量删除队考核
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgPDuiKaoheByIds(Long[] ids);
}
