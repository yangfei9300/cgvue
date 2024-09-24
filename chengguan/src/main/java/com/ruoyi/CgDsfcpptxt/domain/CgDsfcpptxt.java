package com.ruoyi.CgDsfcpptxt.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 第三方测评平台系统对象 cg_dsfcpptxt
 * 
 * @author ruoyi
 * @date 2024-08-27
 */
public class CgDsfcpptxt extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String code;

    /** 次数 */
    @Excel(name = "次数")
    private Long frequency;

    /** 上次案件编号 */
    @Excel(name = "上次案件编号")
    private String upCode;

    /** 所属街办 */
    @Excel(name = "所属街办")
    private String ssjb;

    /** 测评类型 */
    @Excel(name = "测评类型")
    private String cplx;

    /** 测评内容 */
    @Excel(name = "测评内容")
    private String cpnr;

    /** 应扣分值 */
    @Excel(name = "应扣分值")
    private double ykfz;

    /** 位置 */
    @Excel(name = "位置")
    private String wz;

    /** 状态 */
    @Excel(name = "状态")
    private String zt;

    /** 转办时间 */
    @Excel(name = "转办时间")
    private String zbsj;

    /** 整改情况 */
    @Excel(name = "整改情况")
    private String zgqk;

    /** 整改时间 */
    @Excel(name = "整改时间")
    private String zgsj;

    /** 复核时间 */
    @Excel(name = "复核时间")
    private String fhsj;

    /** 结案时间 */
    @Excel(name = "结案时间")
    private String jasj;

    /** 整改期限 */
    @Excel(name = "整改期限")
    private String zgqx;

    /** 案件待处理图片 */
    @Excel(name = "案件待处理图片")
    private String cgDImgs;

    /** 案件已处理图片 */
    @Excel(name = "案件已处理图片")
    private String cdYImgs;

    /** 案件处理结果 */
    @Excel(name = "案件处理结果")
    private String cdYTxt;

    /** 案件结算结果 */
    @Excel(name = "案件结算结果")
    private String cdJTxt;

    /** 案件结算时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "案件结算时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cdJTime;
    /** 是否发送 */
    @Excel(name = "是否发送")
    private Long isEmail;
    /** 处理队ID */
    @Excel(name = "处理队ID")
    private Long cgCld;

    /** 处理人ID */
    @Excel(name = "处理人ID")
    private Long cgClr;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setFrequency(Long frequency) 
    {
        this.frequency = frequency;
    }

    public Long getFrequency() 
    {
        return frequency;
    }
    public void setUpCode(String upCode) 
    {
        this.upCode = upCode;
    }

    public String getUpCode() 
    {
        return upCode;
    }
    public void setSsjb(String ssjb) 
    {
        this.ssjb = ssjb;
    }

    public String getSsjb() 
    {
        return ssjb;
    }
    public void setCplx(String cplx) 
    {
        this.cplx = cplx;
    }

    public String getCplx() 
    {
        return cplx;
    }
    public void setCpnr(String cpnr) 
    {
        this.cpnr = cpnr;
    }

    public String getCpnr() 
    {
        return cpnr;
    }
    public void setYkfz(double ykfz)
    {
        this.ykfz = ykfz;
    }

    public double getYkfz()
    {
        return ykfz;
    }
    public void setWz(String wz) 
    {
        this.wz = wz;
    }

    public String getWz() 
    {
        return wz;
    }
    public void setZt(String zt) 
    {
        this.zt = zt;
    }

    public String getZt() 
    {
        return zt;
    }
    public void setZbsj(String zbsj) 
    {
        this.zbsj = zbsj;
    }

    public String getZbsj() 
    {
        return zbsj;
    }
    public void setZgqk(String zgqk) 
    {
        this.zgqk = zgqk;
    }

    public String getZgqk() 
    {
        return zgqk;
    }
    public void setZgsj(String zgsj) 
    {
        this.zgsj = zgsj;
    }

    public String getZgsj() 
    {
        return zgsj;
    }
    public void setFhsj(String fhsj) 
    {
        this.fhsj = fhsj;
    }

    public String getFhsj() 
    {
        return fhsj;
    }
    public void setJasj(String jasj) 
    {
        this.jasj = jasj;
    }

    public String getJasj() 
    {
        return jasj;
    }
    public void setZgqx(String zgqx) 
    {
        this.zgqx = zgqx;
    }

    public String getZgqx() 
    {
        return zgqx;
    }
    public void setCgDImgs(String cgDImgs) 
    {
        this.cgDImgs = cgDImgs;
    }

    public String getCgDImgs() 
    {
        return cgDImgs;
    }
    public void setCdYImgs(String cdYImgs) 
    {
        this.cdYImgs = cdYImgs;
    }

    public String getCdYImgs() 
    {
        return cdYImgs;
    }
    public void setCdYTxt(String cdYTxt) 
    {
        this.cdYTxt = cdYTxt;
    }

    public String getCdYTxt() 
    {
        return cdYTxt;
    }
    public void setCdJTxt(String cdJTxt) 
    {
        this.cdJTxt = cdJTxt;
    }

    public String getCdJTxt() 
    {
        return cdJTxt;
    }
    public void setCdJTime(Date cdJTime) 
    {
        this.cdJTime = cdJTime;
    }

    public Date getCdJTime() 
    {
        return cdJTime;
    }
    public void setCgCld(Long cgCld) 
    {
        this.cgCld = cgCld;
    }

    public Long getCgCld() 
    {
        return cgCld;
    }
    public void setCgClr(Long cgClr) 
    {
        this.cgClr = cgClr;
    }

    public Long getCgClr() 
    {
        return cgClr;
    }
    public void setIsEmail(Long isEmail)
    {
        this.isEmail = isEmail;
    }

    public Long getIsEmail()
    {
        return isEmail;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("frequency", getFrequency())
            .append("upCode", getUpCode())
            .append("ssjb", getSsjb())
            .append("cplx", getCplx())
            .append("cpnr", getCpnr())
            .append("ykfz", getYkfz())
            .append("wz", getWz())
            .append("zt", getZt())
            .append("zbsj", getZbsj())
            .append("zgqk", getZgqk())
            .append("zgsj", getZgsj())
            .append("fhsj", getFhsj())
            .append("jasj", getJasj())
            .append("zgqx", getZgqx())
            .append("cgDImgs", getCgDImgs())
            .append("cdYImgs", getCdYImgs())
            .append("cdYTxt", getCdYTxt())
            .append("cdJTxt", getCdJTxt())
            .append("cdJTime", getCdJTime())
            .append("cgCld", getCgCld())
            .append("cgClr", getCgClr())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
