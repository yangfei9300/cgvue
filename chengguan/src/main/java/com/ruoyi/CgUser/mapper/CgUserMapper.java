package com.ruoyi.CgUser.mapper;

import java.util.List;
import com.ruoyi.CgUser.domain.CgUser;

/**
 * 用户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
public interface CgUserMapper 
{
    /**
     * 查询用户信息
     * 
     * @param id 用户信息主键
     * @return 用户信息
     */
    public CgUser selectCgUserById(Long id);

    /**
     * 查询用户信息列表
     * 
     * @param cgUser 用户信息
     * @return 用户信息集合
     */
    public List<CgUser> selectCgUserList(CgUser cgUser);
    public List<CgUser> selectCgUserList1(CgUser cgUser);
    public List<CgUser> getKqoqinExcel1(CgUser cgUser);



    /**
     * 新增用户信息
     * 
     * @param cgUser 用户信息
     * @return 结果
     */
    public int insertCgUser(CgUser cgUser);

    /**
     * 修改用户信息
     * 
     * @param cgUser 用户信息
     * @return 结果
     */
    public int updateCgUser(CgUser cgUser);

    /**
     * 删除用户信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    public int deleteCgUserById(Long id);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCgUserByIds(Long[] ids);
}
