package com.ruoyi.CgFileZip.mapper;

import java.util.List;
import com.ruoyi.CgFileZip.domain.CgFileZip;

/**
 * 文件Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-29
 */
public interface CgFileZipMapper 
{
    /**
     * 查询文件
     * 
     * @param id 文件主键
     * @return 文件
     */
    public CgFileZip selectCgFileZipById(Long id);

    /**
     * 查询文件列表
     * 
     * @param cgFileZip 文件
     * @return 文件集合
     */
    public List<CgFileZip> selectCgFileZipList(CgFileZip cgFileZip);

    /**
     * 新增文件
     * 
     * @param cgFileZip 文件
     * @return 结果
     */
    public int insertCgFileZip(CgFileZip cgFileZip);

    /**
     * 修改文件
     * 
     * @param cgFileZip 文件
     * @return 结果
     */
    public int updateCgFileZip(CgFileZip cgFileZip);

    /**
     * 删除文件
     * 
     * @param id 文件主键
     * @return 结果
     */
    public int deleteCgFileZipById(Long id);

    /**
     * 批量删除文件
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgFileZipByIds(Long[] ids);
}
