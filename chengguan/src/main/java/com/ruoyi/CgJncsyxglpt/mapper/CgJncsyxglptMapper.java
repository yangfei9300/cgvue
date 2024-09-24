package com.ruoyi.CgJncsyxglpt.mapper;

import java.util.List;
import com.ruoyi.CgJncsyxglpt.domain.CgJncsyxglpt;

/**
 * 济南市城市服务运行管理平台Mapper接口
 * 
 * @author ruoyi
 * @date 2024-09-23
 */
public interface CgJncsyxglptMapper 
{
    /**
     * 查询济南市城市服务运行管理平台
     * 
     * @param id 济南市城市服务运行管理平台主键
     * @return 济南市城市服务运行管理平台
     */
    public CgJncsyxglpt selectCgJncsyxglptById(Long id);

    /**
     * 查询济南市城市服务运行管理平台列表
     * 
     * @param cgJncsyxglpt 济南市城市服务运行管理平台
     * @return 济南市城市服务运行管理平台集合
     */
    public List<CgJncsyxglpt> selectCgJncsyxglptList(CgJncsyxglpt cgJncsyxglpt);

    /**
     * 新增济南市城市服务运行管理平台
     * 
     * @param cgJncsyxglpt 济南市城市服务运行管理平台
     * @return 结果
     */
    public int insertCgJncsyxglpt(CgJncsyxglpt cgJncsyxglpt);

    /**
     * 修改济南市城市服务运行管理平台
     * 
     * @param cgJncsyxglpt 济南市城市服务运行管理平台
     * @return 结果
     */
    public int updateCgJncsyxglpt(CgJncsyxglpt cgJncsyxglpt);

    /**
     * 删除济南市城市服务运行管理平台
     * 
     * @param id 济南市城市服务运行管理平台主键
     * @return 结果
     */
    public int deleteCgJncsyxglptById(Long id);

    /**
     * 批量删除济南市城市服务运行管理平台
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgJncsyxglptByIds(Long[] ids);
}
