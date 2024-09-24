package com.ruoyi.CgEventType.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 事件类型对象 cg_event_type
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
public class CgEventType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 待办事件类型 */
    @Excel(name = "类型名称")
    private String name;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 处理总时间/天 */
    @Excel(name = "处理总时间/天")
    private Long numDay;

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
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setNumDay(Long numDay) 
    {
        this.numDay = numDay;
    }

    public Long getNumDay() 
    {
        return numDay;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("type", getType())
            .append("numDay", getNumDay())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
