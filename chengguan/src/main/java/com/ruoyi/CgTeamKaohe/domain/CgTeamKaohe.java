package com.ruoyi.CgTeamKaohe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 每月队考核对象 cg_team_kaohe
 * 
 * @author ruoyi
 * @date 2024-09-22
 */
public class CgTeamKaohe extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 队伍ID */
    @Excel(name = "队伍ID")
    private Long tId;

    /** 队伍名称 */
    @Excel(name = "队伍名称")
    private String tName;

    /** 分数1 */
    @Excel(name = "分数1")
    private Double fen1;

    /** 分数2 */
    @Excel(name = "分数2")
    private Double fen2;

    /** 分数3 */
    @Excel(name = "分数3")
    private Double fen3;

    /** 分数4 */
    @Excel(name = "分数4")
    private Double fen4;

    /** 月份 */
    @Excel(name = "月份")
    private String month;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void settId(Long tId) 
    {
        this.tId = tId;
    }

    public Long gettId() 
    {
        return tId;
    }
    public void settName(String tName) 
    {
        this.tName = tName;
    }

    public String gettName() 
    {
        return tName;
    }
    public void setFen1(Double fen1) 
    {
        this.fen1 = fen1;
    }

    public Double getFen1() 
    {
        return fen1;
    }
    public void setFen2(Double fen2) 
    {
        this.fen2 = fen2;
    }

    public Double getFen2() 
    {
        return fen2;
    }
    public void setFen3(Double fen3) 
    {
        this.fen3 = fen3;
    }

    public Double getFen3() 
    {
        return fen3;
    }
    public void setFen4(Double fen4) 
    {
        this.fen4 = fen4;
    }

    public Double getFen4() 
    {
        return fen4;
    }
    public void setMonth(String month) 
    {
        this.month = month;
    }

    public String getMonth() 
    {
        return month;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tId", gettId())
            .append("tName", gettName())
            .append("fen1", getFen1())
            .append("fen2", getFen2())
            .append("fen3", getFen3())
            .append("fen4", getFen4())
            .append("month", getMonth())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
