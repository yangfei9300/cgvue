package com.ruoyi.CgShifouchaochu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 定位问题（是否超出）对象 cg_shifouchaochu
 * 
 * @author ruoyi
 * @date 2024-08-30
 */
public class CgShifouchaochu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long uId;

    /** 小 */
    @Excel(name = "小")
    private Double lat;

    /** 大 */
    @Excel(name = "大")
    private Double lon;

    /** 1在范围2超出范围 */
    @Excel(name = "1在范围2超出范围")
    private String type;

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
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uId", getuId())
            .append("lat", getLat())
            .append("lon", getLon())
            .append("type", getType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
