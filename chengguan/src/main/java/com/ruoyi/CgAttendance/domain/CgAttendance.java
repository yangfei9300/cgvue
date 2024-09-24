package com.ruoyi.CgAttendance.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 考勤（每天00点更新）对象 cg_attendance
 *
 * @author ruoyi
 * @date 2024-07-31
 */

public class CgAttendance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    public Long getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Long checkInId) {
        this.checkInId = checkInId;
    }

    public Long getCheckOutId() {
        return checkOutId;
    }

    public void setCheckOutId(Long checkOutId) {
        this.checkOutId = checkOutId;
    }

    /** 旷工秒数 */
    @Excel(name = "旷工秒数")
    private int kSecont;

    public int getkSecont() {
        return kSecont;
    }

    public void setkSecont(int kSecont) {
        this.kSecont = kSecont;
    }

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long uId;

    /** 考勤日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "考勤日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date attendDate;

    /** 上班打卡时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "上班打卡时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date checkIn;

    /** 下班打卡时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "下班打卡时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date checkOut;

    /** 考勤状态（出勤、迟到、缺勤、早退、加班） */
    @Excel(name = "考勤状态", readConverterExp = "出=勤、迟到、缺勤、早退、加班")
    private String status;

    /** 加班时间/小时 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "加班时间/小时", width = 30, dateFormat = "yyyy-MM-dd")
    private double overtimeHours;


    /** 上班打卡ID */
    @Excel(name = "上班打卡ID")
    private Long checkInId;
    /** 下班打卡ID */
    @Excel(name = "下班打卡ID")
    private Long checkOutId;


    /** 周几 */
    @Excel(name = "周几")
    private String weekNum;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setuId(Long uId)
    {
        this.uId = uId;
    }

    public Long getuId()
    {
        return uId;
    }
    public void setAttendDate(Date attendDate)
    {
        this.attendDate = attendDate;
    }

    public Date getAttendDate()
    {
        return attendDate;
    }
    public void setCheckIn(Date checkIn)
    {
        this.checkIn = checkIn;
    }

    public Date getCheckIn()
    {
        return checkIn;
    }
    public void setCheckOut(Date checkOut)
    {
        this.checkOut = checkOut;
    }

    public Date getCheckOut()
    {
        return checkOut;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setOvertimeHours(double overtimeHours)
    {
        this.overtimeHours = overtimeHours;
    }

    public double getOvertimeHours()
    {
        return overtimeHours;
    }
    public void setWeekNum(String weekNum)
    {
        this.weekNum = weekNum;
    }

    public String getWeekNum()
    {
        return weekNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("uId", getuId())
                .append("attendDate", getAttendDate())
                .append("checkIn", getCheckIn())
                .append("checkOut", getCheckOut())
                .append("status", getStatus())
                .append("overtimeHours", getOvertimeHours())
                .append("weekNum", getWeekNum())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
