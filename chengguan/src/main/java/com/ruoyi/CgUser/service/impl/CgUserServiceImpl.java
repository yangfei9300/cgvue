package com.ruoyi.CgUser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgUser.mapper.CgUserMapper;
import com.ruoyi.CgUser.domain.CgUser;
import com.ruoyi.CgUser.service.ICgUserService;

/**
 * 用户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
@Service
public class CgUserServiceImpl implements ICgUserService 
{
    @Autowired
    private CgUserMapper cgUserMapper;

    /**
     * 查询用户信息
     * 
     * @param id 用户信息主键
     * @return 用户信息
     */
    @Override
    public CgUser selectCgUserById(Long id)
    {
        return cgUserMapper.selectCgUserById(id);
    }

    /**
     * 查询用户信息列表
     * 
     * @param cgUser 用户信息
     * @return 用户信息
     */
    @Override
    public List<CgUser> selectCgUserList(CgUser cgUser)
    {
        return cgUserMapper.selectCgUserList(cgUser);
    }

    public List<CgUser> selectCgUserList1(CgUser cgUser)
    {
        return cgUserMapper.selectCgUserList1(cgUser);
    }


    @Override
    public List<CgUser> getKqoqinExcel1(CgUser cgUser) {
        return cgUserMapper.getKqoqinExcel1(cgUser);
    }

    /**
     * 新增用户信息
     * 
     * @param cgUser 用户信息
     * @return 结果
     */
    @Override
    public int insertCgUser(CgUser cgUser)
    {
        cgUser.setCreateTime(DateUtils.getNowDate());
        return cgUserMapper.insertCgUser(cgUser);
    }

    /**
     * 修改用户信息
     * 
     * @param cgUser 用户信息
     * @return 结果
     */
    @Override
    public int updateCgUser(CgUser cgUser)
    {
        cgUser.setUpdateTime(DateUtils.getNowDate());
        return cgUserMapper.updateCgUser(cgUser);
    }

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteCgUserByIds(Long[] ids)
    {
        return cgUserMapper.deleteCgUserByIds(ids);
    }

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteCgUserById(Long id)
    {
        return cgUserMapper.deleteCgUserById(id);
    }
}
