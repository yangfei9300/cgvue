package com.ruoyi.CgAttendance.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CgAttendance.mapper.CgAttendanceMapper;
import com.ruoyi.CgAttendance.domain.CgAttendance;
import com.ruoyi.CgAttendance.service.ICgAttendanceService;

/**
 * 考勤（每天00点更新）Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
@Service
public class CgAttendanceServiceImpl implements ICgAttendanceService
{
    @Autowired
    private CgAttendanceMapper cgAttendanceMapper;

    /**
     * 查询考勤（每天00点更新）
     * 
     * @param id 考勤（每天00点更新）主键
     * @return 考勤（每天00点更新）
     */
    @Override
    public CgAttendance selectCgAttendanceById(Long id)
    {
        return cgAttendanceMapper.selectCgAttendanceById(id);
    }

    /**
     * 查询考勤（每天00点更新）列表
     * 
     * @param cgAttendance 考勤（每天00点更新）
     * @return 考勤（每天00点更新）
     */
    @Override
    public List<CgAttendance> selectCgAttendanceList(CgAttendance cgAttendance)
    {
        return cgAttendanceMapper.selectCgAttendanceList(cgAttendance);
    }

    @Override
    public List<CgAttendance> getKqList(CgAttendance cgAttendance) {
        return cgAttendanceMapper.getKqList(cgAttendance);
    }
//    获取针一个人得正月得考勤
    public List<CgAttendance> getKqHistoryByUid(CgAttendance cgAttendance) {
        return cgAttendanceMapper.getKqHistoryByUid(cgAttendance);
    }

    public List<CgAttendance> getHoutaiKaoqinList(CgAttendance cgAttendance) {
        return cgAttendanceMapper.getHoutaiKaoqinList(cgAttendance);
    }

    /**
     * 新增考勤（每天00点更新）
     * 
     * @param cgAttendance 考勤（每天00点更新）
     * @return 结果
     */
    @Override
    public int insertCgAttendance(CgAttendance cgAttendance)
    {
        cgAttendance.setCreateTime(DateUtils.getNowDate());
        return cgAttendanceMapper.insertCgAttendance(cgAttendance);
    }

    /**
     * 修改考勤（每天00点更新）
     * 
     * @param cgAttendance 考勤（每天00点更新）
     * @return 结果
     */
    @Override
    public int updateCgAttendance(CgAttendance cgAttendance)
    {
        cgAttendance.setUpdateTime(DateUtils.getNowDate());
        return cgAttendanceMapper.updateCgAttendance(cgAttendance);
    }

    /**
     * 批量删除考勤（每天00点更新）
     * 
     * @param ids 需要删除的考勤（每天00点更新）主键
     * @return 结果
     */
    @Override
    public int deleteCgAttendanceByIds(Long[] ids)
    {
        return cgAttendanceMapper.deleteCgAttendanceByIds(ids);
    }

    /**
     * 删除考勤（每天00点更新）信息
     * 
     * @param id 考勤（每天00点更新）主键
     * @return 结果
     */
    @Override
    public int deleteCgAttendanceById(Long id)
    {
        return cgAttendanceMapper.deleteCgAttendanceById(id);
    }
}
