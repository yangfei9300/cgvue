package com.ruoyi.CgMonthKaohe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 每月考勤对象 cg_month_kaohe
 *
 * @author ruoyi
 * @date 2024-09-13
 */
public class CgMonthKaohe extends BaseEntity
{

    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long uId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Excel(name = "用姓名")
    private String name;
    /** 分数1 */
    @Excel(name = "分数1")
    private double fen1;

    /** 分数2 */
    @Excel(name = "分数2")
    private double fen2;

    /** 分数3 */
    @Excel(name = "分数3")
    private double fen3;

    /** 分数4 */
    @Excel(name = "分数4")
    private double fen4;

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
    public void setuId(Long uId)
    {
        this.uId = uId;
    }

    public Long getuId()
    {
        return uId;
    }
    public void setFen1(double fen1)
    {
        this.fen1 = fen1;
    }

    public double getFen1()
    {
        return fen1;
    }
    public void setFen2(double fen2)
    {
        this.fen2 = fen2;
    }

    public double getFen2()
    {
        return fen2;
    }
    public void setFen3(double fen3)
    {
        this.fen3 = fen3;
    }

    public double getFen3()
    {
        return fen3;
    }

    public void setFen4(double fen4)
    {
        this.fen4 = fen4;
    }

    public double getFen4()
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
                .append("uId", getuId())
                .append("fen1", getFen1())
                .append("fen2", getFen2())
                .append("fen3", getFen3())
                .append("fen4", getFen4())
                .append("remark", getRemark())
                .append("month", getMonth())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
