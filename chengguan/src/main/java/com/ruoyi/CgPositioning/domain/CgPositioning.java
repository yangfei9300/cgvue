package com.ruoyi.CgPositioning.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 定位记录表对象 cg_positioning
 *
 * @author ruoyi
 * @date 2024-08-06
 */
public class CgPositioning extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private Long uId;

    /** 小 */
    @Excel(name = "小")
    private Double lat;

    /** 大 */
    @Excel(name = "大")
    private Double lon;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 区 */
    @Excel(name = "区")
    private String district;

    /** 路 */
    @Excel(name = "路")
    private String street;

    /** 号 */
    @Excel(name = "号")
    private String streetNum;

    /** 地点 */
    @Excel(name = "地点")
    private String poiName;

    /** 城市编号 */
    @Excel(name = "城市编号")
    private String cityCode;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 是否包含 */
    @Excel(name = "是否包含")
    private Long isHava;

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
    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCountry()
    {
        return country;
    }
    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getProvince()
    {
        return province;
    }
    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity()
    {
        return city;
    }
    public void setDistrict(String district)
    {
        this.district = district;
    }

    public String getDistrict()
    {
        return district;
    }
    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getStreet()
    {
        return street;
    }
    public void setStreetNum(String streetNum)
    {
        this.streetNum = streetNum;
    }

    public String getStreetNum()
    {
        return streetNum;
    }
    public void setPoiName(String poiName)
    {
        this.poiName = poiName;
    }

    public String getPoiName()
    {
        return poiName;
    }
    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public String getCityCode()
    {
        return cityCode;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setIsHava(Long isHava)
    {
        this.isHava = isHava;
    }

    public Long getIsHava()
    {
        return isHava;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("uId", getuId())
                .append("lat", getLat())
                .append("lon", getLon())
                .append("country", getCountry())
                .append("province", getProvince())
                .append("city", getCity())
                .append("district", getDistrict())
                .append("street", getStreet())
                .append("streetNum", getStreetNum())
                .append("poiName", getPoiName())
                .append("cityCode", getCityCode())
                .append("address", getAddress())
                .append("isHava", getIsHava())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
