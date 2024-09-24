package com.ruoyi.CgUser.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.CgAttendance.domain.CgAttendance;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户信息对象 cg_user
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
public class CgUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 分 */
    @Excel(name = "分")
    private Long fen;

    /** 类型：1.城管中队2.洒水车中队 */
    @Excel(name = "类型：1.城管中队2.洒水车中队")
    private Long uType;

    /** 队：属于哪个队伍(队伍ID) */
    @Excel(name = "队：属于哪个队伍(队伍ID)")
    private Long teamId;

    /** 是否是队长1.是2否 */
    @Excel(name = "是否是队长1.是2否")
    private Long isDz;

    /** 社区ID */
    @Excel(name = "社区ID")
    private Long shequId;

    /** 街道ID */
    @Excel(name = "街道ID")
    private Long jiedaoId;

    /** 上班区域ID */
    @Excel(name = "上班区域ID")
    private Long areaId;

    @Excel(name = "lng")
    private double lng;
    @Excel(name = "lat")
    private double lat;



    /** 是否被禁用 */
    @Excel(name = "是否被禁用")
    private Long isJin;

    /** 早上上班时间 */
    @Excel(name = "早上上班时间")
    private Long workTimeZaoS;

    /** 早上下班时间 */
    @Excel(name = "早上下班时间")
    private Long workTimeZaoX;

    /** 下午上班时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下午上班时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date workTimeXiaS;

    /** 下午下班时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下午下班时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date workTimeXiaX;

    /** 上班时间ID */
    @Excel(name = "上班时间ID")
    private Long workTimeId;

    /** 休息类型 */
    @Excel(name = "休息类型")
    private Long restType;

    /** 备注 */
    @Excel(name = "备注")
    private String renark;

    private List<CgAttendance> cgAttendanceList;

    public List<CgAttendance> getCgAttendanceList() {
        return cgAttendanceList;
    }

    public void setCgAttendanceList(List<CgAttendance> cgAttendanceList) {
        this.cgAttendanceList = cgAttendanceList;
    }



    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setFen(Long fen) 
    {
        this.fen = fen;
    }
    {
        this.shequId = shequId;
    }

    public Long getShequId()
    {
        return shequId;
    }
    public void setJiedaoId(Long jiedaoId)
    {
        this.jiedaoId = jiedaoId;
    }

    public Long getJiedaoId()
    {
        return jiedaoId;
    }
    public Long getFen() 
    {
        return fen;
    }
    public void setuType(Long uType) 
    {
        this.uType = uType;
    }

    public Long getuType() 
    {
        return uType;
    }
    public void setTeamId(Long teamId) 
    {
        this.teamId = teamId;
    }

    public Long getTeamId() 
    {
        return teamId;
    }
    public void setIsDz(Long isDz) 
    {
        this.isDz = isDz;
    }

    public Long getIsDz() 
    {
        return isDz;
    }
    public void setAreaId(Long areaId) 
    {
        this.areaId = areaId;
    }

    public Long getAreaId() 
    {
        return areaId;
    }
    public void setIsJin(Long isJin) 
    {
        this.isJin = isJin;
    }

    public Long getIsJin() 
    {
        return isJin;
    }
    public void setWorkTimeZaoS(Long workTimeZaoS) 
    {
        this.workTimeZaoS = workTimeZaoS;
    }

    public Long getWorkTimeZaoS() 
    {
        return workTimeZaoS;
    }
    public void setWorkTimeZaoX(Long workTimeZaoX) 
    {
        this.workTimeZaoX = workTimeZaoX;
    }

    public Long getWorkTimeZaoX() 
    {
        return workTimeZaoX;
    }
    public void setWorkTimeXiaS(Date workTimeXiaS) 
    {
        this.workTimeXiaS = workTimeXiaS;
    }

    public Date getWorkTimeXiaS() 
    {
        return workTimeXiaS;
    }
    public void setWorkTimeXiaX(Date workTimeXiaX) 
    {
        this.workTimeXiaX = workTimeXiaX;
    }

    public Date getWorkTimeXiaX() 
    {
        return workTimeXiaX;
    }
    public void setRestType(Long restType) 
    {
        this.restType = restType;
    }

    public Long getRestType() 
    {
        return restType;
    }
    public void setRenark(String renark) 
    {
        this.renark = renark;
    }

    public String getRenark() 
    {
        return renark;
    }

    public void setWorkTimeId(Long workTimeId)
    {
        this.workTimeId = workTimeId;
    }

    public Long getWorkTimeId()
    {
        return workTimeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("avatar", getAvatar())
            .append("phone", getPhone())
            .append("password", getPassword())
            .append("email", getEmail())
            .append("fen", getFen())
            .append("uType", getuType())
            .append("teamId", getTeamId())
            .append("isDz", getIsDz())
            .append("areaId", getAreaId())
            .append("isJin", getIsJin())
            .append("workTimeZaoS", getWorkTimeZaoS())
            .append("workTimeZaoX", getWorkTimeZaoX())
            .append("workTimeXiaS", getWorkTimeXiaS())
            .append("workTimeXiaX", getWorkTimeXiaX())
            .append("restType", getRestType())
            .append("renark", getRenark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
