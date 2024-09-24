package com.ruoyi.CgPSsxHistory.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 十四扣分项目每月记录对象 cg_p_ssx_history
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
public class CgPSsxHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 扣分项名 */
    @Excel(name = "扣分项名")
    private String name;

    /** 扣分项id */
    @Excel(name = "扣分项id")
    private Long kId;

    /** 扣分项年月份 */
    @Excel(name = "扣分项年月份", width = 30)
    private String month;

    /** 扣分项分数 */
    @Excel(name = "扣分项分数")
    private BigDecimal fen;

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
    public void setkId(Long kId) 
    {
        this.kId = kId;
    }

    public Long getkId() 
    {
        return kId;
    }
    public void setMonth(String month)
    {
        this.month = month;
    }

    public String getMonth()
    {
        return month;
    }
    public void setFen(BigDecimal fen) 
    {
        this.fen = fen;
    }

    public BigDecimal getFen() 
    {
        return fen;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("kId", getkId())
            .append("month", getMonth())
            .append("fen", getFen())
            .append("createTime", getCreateTime())
            .toString();
    }
}
