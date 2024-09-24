package com.ruoyi.CgHeartShi.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 热心服务事项对象 cg_heart_shi
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
public class CgHeartShi extends BaseEntity
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
    @Excel(name = "图片")
    private String imgs;

    /** 纬度 */
    @Excel(name = "纬度")
    private String lat;

    /** 经度 */
    @Excel(name = "经度")
    private String lng;

    /** 队ID */
    @Excel(name = "队ID")
    private Long dId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long uId;

    /** 打分 */
    @Excel(name = "打分")
    private Long fen;

    /** 打分时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    yyyy-MM-dd HH:mm:ss
    @Excel(name = "打分时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date fenTime;

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

    public String getContent() 
    {
        return content;
    }
    public void setImgs(String imgs) 
    {
        this.imgs = imgs;
    }

    public String getImgs() 
    {
        return imgs;
    }
    public void setLat(String lat) 
    {
        this.lat = lat;
    }

    public String getLat() 
    {
        return lat;
    }
    public void setLng(String lng) 
    {
        this.lng = lng;
    }

    public String getLng() 
    {
        return lng;
    }
    public void setdId(Long dId) 
    {
        this.dId = dId;
    }

    public Long getdId() 
    {
        return dId;
    }
    public void setuId(Long uId) 
    {
        this.uId = uId;
    }

    public Long getuId() 
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
            .append("content", getContent())
            .append("imgs", getImgs())
            .append("lat", getLat())
            .append("lng", getLng())
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
