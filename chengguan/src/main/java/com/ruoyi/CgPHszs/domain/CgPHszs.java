package com.ruoyi.CgPHszs.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 华山指数对象 cg_p_hszs
 * 
 * @author ruoyi
 * @date 2024-08-22
 */
public class CgPHszs extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 还乡店中队 */
    @Excel(name = "还乡店中队")
    private String dui1;

    /** 环宇城中队 */
    @Excel(name = "环宇城中队")
    private String dui2;

    /** 珑城中队 */
    @Excel(name = "珑城中队")
    private String dui3;

    /** 卧牛中队 */
    @Excel(name = "卧牛中队")
    private String dui4;

    /** 御山中队 */
    @Excel(name = "御山中队")
    private String dui5;

    /** 将军中队 */
    @Excel(name = "将军中队")
    private String dui6;

    /** 指数 */
    @Excel(name = "指数")
    private String zhishu;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDui1(String dui1) 
    {
        this.dui1 = dui1;
    }

    public String getDui1() 
    {
        return dui1;
    }
    public void setDui2(String dui2) 
    {
        this.dui2 = dui2;
    }

    public String getDui2() 
    {
        return dui2;
    }
    public void setDui3(String dui3) 
    {
        this.dui3 = dui3;
    }

    public String getDui3() 
    {
        return dui3;
    }
    public void setDui4(String dui4) 
    {
        this.dui4 = dui4;
    }

    public String getDui4() 
    {
        return dui4;
    }
    public void setDui5(String dui5) 
    {
        this.dui5 = dui5;
    }

    public String getDui5() 
    {
        return dui5;
    }
    public void setDui6(String dui6) 
    {
        this.dui6 = dui6;
    }

    public String getDui6() 
    {
        return dui6;
    }
    public void setZhishu(String zhishu) 
    {
        this.zhishu = zhishu;
    }

    public String getZhishu() 
    {
        return zhishu;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dui1", getDui1())
            .append("dui2", getDui2())
            .append("dui3", getDui3())
            .append("dui4", getDui4())
            .append("dui5", getDui5())
            .append("dui6", getDui6())
            .append("zhishu", getZhishu())
            .toString();
    }
}
