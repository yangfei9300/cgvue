package com.ruoyi.CgPDuiKaohe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 队考核对象 cg_p_dui_kaohe
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
public class CgPDuiKaohe extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 队名 */
    @Excel(name = "队名")
    private String teamName;

    /** 分数 */
    @Excel(name = "分数")
    private double fen;

    /** 时间 */
    @Excel(name = "时间")
    private String fTime;



    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTeamName(String teamName) 
    {
        this.teamName = teamName;
    }

    public String getTeamName() 
    {
        return teamName;
    }
    public void setFen(double fen)
    {
        this.fen = fen;
    }

    public double getFen()
    {
        return fen;
    }
    public void setfTime(String fTime) 
    {
        this.fTime = fTime;
    }

    public String getfTime() 
    {
        return fTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teamName", getTeamName())
            .append("fen", getFen())
            .append("fTime", getfTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
