package com.ruoyi.CgFileZip.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgFileZip.mapper.CgFileZipMapper;
import com.ruoyi.CgFileZip.domain.CgFileZip;
import com.ruoyi.CgFileZip.service.ICgFileZipService;

/**
 * 文件Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-29
 */
@Service
public class CgFileZipServiceImpl implements ICgFileZipService 
{
    @Autowired
    private CgFileZipMapper cgFileZipMapper;

    /**
     * 查询文件
     * 
     * @param id 文件主键
     * @return 文件
     */
    @Override
    public CgFileZip selectCgFileZipById(Long id)
    {
        return cgFileZipMapper.selectCgFileZipById(id);
    }

    /**
     * 查询文件列表
     * 
     * @param cgFileZip 文件
     * @return 文件
     */
    @Override
    public List<CgFileZip> selectCgFileZipList(CgFileZip cgFileZip)
    {
        return cgFileZipMapper.selectCgFileZipList(cgFileZip);
    }

    /**
     * 新增文件
     * 
     * @param cgFileZip 文件
     * @return 结果
     */
    @Override
    public int insertCgFileZip(CgFileZip cgFileZip)
    {
        cgFileZip.setCreateTime(DateUtils.getNowDate());
        return cgFileZipMapper.insertCgFileZip(cgFileZip);
    }

    /**
     * 修改文件
     * 
     * @param cgFileZip 文件
     * @return 结果
     */
    @Override
    public int updateCgFileZip(CgFileZip cgFileZip)
    {
        return cgFileZipMapper.updateCgFileZip(cgFileZip);
    }

    /**
     * 批量删除文件
     * 
     * @param ids 需要删除的文件主键
     * @return 结果
     */
    @Override
    public int deleteCgFileZipByIds(Long[] ids)
    {
        return cgFileZipMapper.deleteCgFileZipByIds(ids);
    }

    /**
     * 删除文件信息
     * 
     * @param id 文件主键
     * @return 结果
     */
    @Override
    public int deleteCgFileZipById(Long id)
    {
        return cgFileZipMapper.deleteCgFileZipById(id);
    }
}
