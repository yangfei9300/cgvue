package com.ruoyi.CgTeam.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 队伍列对象 cg_team
 *
 * @author ruoyi
 * @date 2024-08-09
 */
public class CgTeam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 队伍名称 */
    @Excel(name = "队伍名称")
    private String tName;

    /** 队伍类型1.城管大队2.洒水车3.公益岗 */
    @Excel(name = "队伍类型1.城管大队2.洒水车3.公益岗")
    private Long type;

    /** 早上上班时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "早上上班时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date workTimeZS;

    /** 早上下班时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "早上下班时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date workTimeZX;

    /** 下午上班时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下午上班时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date workTimeXS;

    /** 下午下班时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下午下班时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date workTimeXX;

    /** 地理围栏ID */
    @Excel(name = "地理围栏ID")
    private Long dlwlId;

    /** 工作时间 */
    @Excel(name = "工作时间")
    private Long workTimeId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void settName(String tName)
    {
        this.tName = tName;
    }

    public String gettName()
    {
        return tName;
    }
    public void setType(Long type)
    {
        this.type = type;
    }

    public Long getType()
    {
        return type;
    }
    public void setWorkTimeZS(Date workTimeZS)
    {
        this.workTimeZS = workTimeZS;
    }

    public Date getWorkTimeZS()
    {
        return workTimeZS;
    }
    public void setWorkTimeZX(Date workTimeZX)
    {
        this.workTimeZX = workTimeZX;
    }

    public Date getWorkTimeZX()
    {
        return workTimeZX;
    }
    public void setWorkTimeXS(Date workTimeXS)
    {
        this.workTimeXS = workTimeXS;
    }

    public Date getWorkTimeXS()
    {
        return workTimeXS;
    }
    public void setWorkTimeXX(Date workTimeXX)
    {
        this.workTimeXX = workTimeXX;
    }

    public Date getWorkTimeXX()
    {
        return workTimeXX;
    }
    public void setDlwlId(Long dlwlId)
    {
        this.dlwlId = dlwlId;
    }

    public Long getDlwlId()
    {
        return dlwlId;
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
                .append("tName", gettName())
                .append("type", getType())
                .append("workTimeZS", getWorkTimeZS())
                .append("workTimeZX", getWorkTimeZX())
                .append("workTimeXS", getWorkTimeXS())
                .append("workTimeXX", getWorkTimeXX())
                .append("dlwlId", getDlwlId())
                .append("workTimeId", getWorkTimeId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
