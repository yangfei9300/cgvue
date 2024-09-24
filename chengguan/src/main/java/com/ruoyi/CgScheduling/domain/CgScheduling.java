package com.ruoyi.CgScheduling.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 上班时刻对象 cg_scheduling
 * 
 * @author ruoyi
 * @date 2024-07-31
 */
public class CgScheduling extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 上班时间名称 */
    @Excel(name = "上班时间名称")
    private String name;

    /** 分类ID */
    @Excel(name = "分类ID")
    private Long typeId;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    /** 中午下班时间 */
    @Excel(name = "中午下班时间")
    private String startEndTime;

    /** 下午上班上班时间 */
    @Excel(name = "下午上班上班时间")
    private String endStartTime;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endTime;

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
    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setStartEndTime(String startEndTime) 
    {
        this.startEndTime = startEndTime;
    }

    public String getStartEndTime() 
    {
        return startEndTime;
    }
    public void setEndStartTime(String endStartTime) 
    {
        this.endStartTime = endStartTime;
    }

    public String getEndStartTime() 
    {
        return endStartTime;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("typeId", getTypeId())
            .append("startTime", getStartTime())
            .append("startEndTime", getStartEndTime())
            .append("endStartTime", getEndStartTime())
            .append("endTime", getEndTime())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
