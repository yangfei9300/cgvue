package com.ruoyi.CgHeartShi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 热心服务事项对象 cg_heart_shi
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
public class CgHeartShiExcel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 图片 */




    /** 队ID */
    @Excel(name = "队ID")
    private String dId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String uId;

    /** 打分 */
    @Excel(name = "打分")
    private Long fen;

    /** 打分时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    yyyy-MM-dd HH:mm:ss
    @Excel(name = "打分时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date fenTime;

    @Excel(name = "备注")
    private String remark;

    public String getContent() {
        return content;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public void setdId(String dId)
    {
        this.dId = dId;
    }

    public String getdId()
    {
        return dId;
    }
    public void setuId(String uId)
    {
        this.uId = uId;
    }

    public String getuId()
    {
        return uId;
    }
    public void setFen(Long fen) 
    {
        this.fen = fen;
    }

    public Long getFen() 
    {
        return fen;
    }
    public void setFenTime(Date fenTime) 
    {
        this.fenTime = fenTime;
    }

    public Date getFenTime() 
    {
        return fenTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("dId", getdId())
            .append("uId", getuId())
            .append("fen", getFen())
            .append("remark", getRemark())
            .append("fenTime", getFenTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
