package com.ruoyi.CgHeartShi.service;

import java.util.List;
import com.ruoyi.CgHeartShi.domain.CgHeartShi;

/**
 * 热心服务事项Service接口
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
public interface ICgHeartShiService 
{
    /**
     * 查询热心服务事项
     * 
     * @param id 热心服务事项主键
     * @return 热心服务事项
     */
    public CgHeartShi selectCgHeartShiById(Long id);

    /**
     * 查询热心服务事项列表
     * 
     * @param cgHeartShi 热心服务事项
     * @return 热心服务事项集合
     */
    public List<CgHeartShi> selectCgHeartShiList(CgHeartShi cgHeartShi);
    public List<CgHeartShi> getMyHrhs(CgHeartShi cgHeartShi);
    public List<CgHeartShi> getHearts(CgHeartShi cgHeartShi);
    /**
     * 新增热心服务事项
     * 
     * @param cgHeartShi 热心服务事项
     * @return 结果
     */
    public int insertCgHeartShi(CgHeartShi cgHeartShi);

    /**
     * 修改热心服务事项
     * 
     * @param cgHeartShi 热心服务事项
     * @return 结果
     */
    public int updateCgHeartShi(CgHeartShi cgHeartShi);

    /**
     * 批量删除热心服务事项
     * 
     * @param ids 需要删除的热心服务事项主键集合
     * @return 结果
     */
    public int deleteCgHeartShiByIds(Long[] ids);

    /**
     * 删除热心服务事项信息
     * 
     * @param id 热心服务事项主键
     * @return 结果
     */
    public int deleteCgHeartShiById(Long id);
}
