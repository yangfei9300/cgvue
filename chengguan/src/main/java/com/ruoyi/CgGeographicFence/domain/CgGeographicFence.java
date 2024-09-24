package com.ruoyi.CgGeographicFence.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 地址围栏对象 cg_geographic_fence
 * 
 * @author ruoyi
 * @date 2024-07-30
 */
public class CgGeographicFence extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 地理围栏名称 */
    @Excel(name = "地理围栏名称")
    private String name;

    /** 类型1.圆形2.多边形 */
    @Excel(name = "类型1.圆形2.多边形")
    private Long type;

    /** 地理围栏信息（坐标啥的） */
    @Excel(name = "地理围栏信息", readConverterExp = "坐=标啥的")
    private String info;

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
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setInfo(String info) 
    {
        this.info = info;
    }

    public String getInfo() 
    {
        return info;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("remark", getRemark())
            .append("type", getType())
            .append("info", getInfo())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
