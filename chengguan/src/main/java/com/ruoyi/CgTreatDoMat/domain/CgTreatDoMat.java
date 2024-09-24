package com.ruoyi.CgTreatDoMat.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 待办事件对象 cg_treat_do_mat
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
public class CgTreatDoMat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 待办事件类型 */
    @Excel(name = "待办事件类型")
    private Long type;

    /** 待办事件标题 */
    @Excel(name = "待办事件标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 相关照片 */
    @Excel(name = "相关照片")
    private String imgs;

    /** 最晚改善时间 */
    @Excel(name = "最晚改善时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 经度 */
    @Excel(name = "经度")
    private BigDecimal lng;

    /** 纬度 */
    @Excel(name = "纬度")
    private BigDecimal lat;

    /** 提交的队伍ID */
    @Excel(name = "提交的队伍ID")
    private Long tTId;

    /** 提交的用户ID */
    @Excel(name = "提交的用户ID")
    private Long uTId;

    /** 处理的队伍ID */
    @Excel(name = "处理的队伍ID")
    private Long cTId;

    /** 处理的用户ID */
    @Excel(name = "处理的用户ID")
    private Long cUId;

    /** 处理结果 */
    @Excel(name = "处理结果")
    private String resultContent;

    /** 处理结果图片 */
    @Excel(name = "处理结果图片")
    private String resultImgs;

    /** 处理开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "处理开始时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date resultStartTime;

    /** 处理完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "处理完成时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date resultEndTime;

    /** 打分 */
    @Excel(name = "打分")
    private double fenNum;

    /** 打分时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "打分时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date fenTime;

    /** 晚了多久/分钟 */
    @Excel(name = "晚了多久/分钟")
    private Long wanTime;

    /** 打分备注 */
    @Excel(name = "打分备注")
    private String fenRemark;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;


    /** 平台1.本系统2.第三方测评平台系统 */
    @Excel(name = "平台")
    private String typePt;

    /** 编号 */
    @Excel(name = "编号")
    private String pCode;

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    /** 位置 */
    @Excel(name = "位置")
    private String weizhi;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
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
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setLng(BigDecimal lng) 
    {
        this.lng = lng;
    }

    public BigDecimal getLng() 
    {
        return lng;
    }
    public void setLat(BigDecimal lat)
    {
        this.lat = lat;
    }

    public BigDecimal getLat()
    {
        return lat;
    }
    public void settTId(Long tTId) 
    {
        this.tTId = tTId;
    }

    public Long gettTId() 
    {
        return tTId;
    }
    public void setuTId(Long uTId) 
    {
        this.uTId = uTId;
    }

    public Long getuTId() 
    {
        return uTId;
    }
    public void setcTId(Long cTId) 
    {
        this.cTId = cTId;
    }

    public Long getcTId() 
    {
        return cTId;
    }
    public void setcUId(Long cUId) 
    {
        this.cUId = cUId;
    }

    public Long getcUId() 
    {
        return cUId;
    }
    public void setResultContent(String resultContent) 
    {
        this.resultContent = resultContent;
    }

    public String getResultContent() 
    {
        return resultContent;
    }
    public void setResultImgs(String resultImgs) 
    {
        this.resultImgs = resultImgs;
    }

    public String getResultImgs() 
    {
        return resultImgs;
    }
    public void setResultStartTime(Date resultStartTime) 
    {
        this.resultStartTime = resultStartTime;
    }

    public Date getResultStartTime() 
    {
        return resultStartTime;
    }
    public void setResultEndTime(Date resultEndTime) 
    {
        this.resultEndTime = resultEndTime;
    }

    public Date getResultEndTime() 
    {
        return resultEndTime;
    }
    public void setFenNum(double fenNum)
    {
        this.fenNum = fenNum;
    }

    public double getFenNum()
    {
        return fenNum;
    }
    public void setFenTime(Date fenTime) 
    {
        this.fenTime = fenTime;
    }

    public Date getFenTime() 
    {
        return fenTime;
    }
    public void setWanTime(Long wanTime) 
    {
        this.wanTime = wanTime;
    }

    public Long getWanTime() 
    {
        return wanTime;
    }
    public void setFenRemark(String fenRemark) 
    {
        this.fenRemark = fenRemark;
    }

    public String getFenRemark() 
    {
        return fenRemark;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    public void setTypePt(String typePt)
    {
        this.typePt = typePt;
    }

    public String getTypePt()
    {
        return typePt;
    }

    public void setWeizhi(String weizhi)
    {
        this.weizhi = weizhi;
    }

    public String getWeizhi()
    {
        return weizhi;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("title", getTitle())
            .append("content", getContent())
            .append("imgs", getImgs())
            .append("endTime", getEndTime())
            .append("remark", getRemark())
            .append("lng", getLng())
            .append("lat", getLat())
            .append("tTId", gettTId())
            .append("uTId", getuTId())
            .append("cTId", getcTId())
            .append("cUId", getcUId())
            .append("resultContent", getResultContent())
            .append("resultImgs", getResultImgs())
            .append("resultStartTime", getResultStartTime())
            .append("resultEndTime", getResultEndTime())
            .append("fenNum", getFenNum())
            .append("fenTime", getFenTime())
            .append("wanTime", getWanTime())
            .append("fenRemark", getFenRemark())
            .append("status", getStatus())
                .append("typePt", getTypePt())
                .append("weizhi", getWeizhi())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
