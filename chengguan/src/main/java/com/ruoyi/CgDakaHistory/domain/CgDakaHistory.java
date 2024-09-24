package com.ruoyi.CgDakaHistory.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 打卡记录对象 cg_daka_history
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
public class CgDakaHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long uId;

    /** 打卡类型1.上班2下班 */
    @Excel(name = "打卡类型1.上班2下班")
    private Long kaType;

    /** 打卡时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "打卡时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date kaTime;

    /** 纬度 */
    @Excel(name = "纬度")
    private Double lat;

    /** 经度 */
    @Excel(name = "经度")
    private Double lon;

    /** 地址信息 */
    @Excel(name = "地址信息")
    private String address;

    /** 状态1.正常2.迟到 */
    @Excel(name = "状态1.正常2.迟到")
    private Long status;

    /** 备注（备注信息，如迟到、早退等特殊情况说明） */
    @Excel(name = "备注", readConverterExp = "备=注信息，如迟到、早退等特殊情况说明")
    private String renark;

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
    public void setKaType(Long kaType) 
    {
        this.kaType = kaType;
    }
    /** 打卡时间表 */
    @Excel(name = "打卡时间表")
    private Long timeId;
    /** 考勤ID */
    @Excel(name = "考勤ID")
    private Long kqId;
    public Long getKaType() 
    {
        return kaType;
    }
    public void setKaTime(Date kaTime) 
    {
        this.kaTime = kaTime;
    }
    public void setTimeId(Long timeId)
    {
        this.timeId = timeId;
    }

    public Long getTimeId()
    {
        return timeId;
    }
    public Date getKaTime() 
    {
        return kaTime;
    }
    public void setLat(Double lat)
    {
        this.lat = lat;
    }

    public Double getLat()
    {
        return lat;
    }
    public void setLon(Double lon)
    {
        this.lon = lon;
    }

    public Double getLon()
    {
        return lon;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setRenark(String renark) 
    {
        this.renark = renark;
    }

    public String getRenark() 
    {
        return renark;
    }
    public void setKqId(Long kqId)
    {
        this.kqId = kqId;
    }

    public Long getKqId()
    {
        return kqId;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uId", getuId())
            .append("kaType", getKaType())
            .append("kaTime", getKaTime())
            .append("lat", getLat())
            .append("lon", getLon())
            .append("address", getAddress())
            .append("status", getStatus())
            .append("renark", getRenark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
