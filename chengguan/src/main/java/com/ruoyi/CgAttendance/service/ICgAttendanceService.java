package com.ruoyi.CgAttendance.service;

import java.util.List;
import com.ruoyi.CgAttendance.domain.CgAttendance;

/**
 * 考勤（每天00点更新）Service接口
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
public interface ICgAttendanceService 
{
    /**
     * 查询考勤（每天00点更新）
     * 
     * @param id 考勤（每天00点更新）主键
     * @return 考勤（每天00点更新）
     */
    public CgAttendance selectCgAttendanceById(Long id);

    /**
     * 查询考勤（每天00点更新）列表
     * 
     * @param cgAttendance 考勤（每天00点更新）
     * @return 考勤（每天00点更新）集合
     */
    public List<CgAttendance> selectCgAttendanceList(CgAttendance cgAttendance);

    public List<CgAttendance> getKqList(CgAttendance cgAttendance);
    public List<CgAttendance> getKqHistoryByUid(CgAttendance cgAttendance);
    public List<CgAttendance> getHoutaiKaoqinList(CgAttendance cgAttendance);



    /**
     * 新增考勤（每天00点更新）
     * 
     * @param cgAttendance 考勤（每天00点更新）
     * @return 结果
     */
    public int insertCgAttendance(CgAttendance cgAttendance);

    /**
     * 修改考勤（每天00点更新）
     * 
     * @param cgAttendance 考勤（每天00点更新）
     * @return 结果
     */
    public int updateCgAttendance(CgAttendance cgAttendance);

    /**
     * 批量删除考勤（每天00点更新）
     * 
     * @param ids 需要删除的考勤（每天00点更新）主键集合
     * @return 结果
     */
    public int deleteCgAttendanceByIds(Long[] ids);

    /**
     * 删除考勤（每天00点更新）信息
     * 
     * @param id 考勤（每天00点更新）主键
     * @return 结果
     */
    public int deleteCgAttendanceById(Long id);
}
