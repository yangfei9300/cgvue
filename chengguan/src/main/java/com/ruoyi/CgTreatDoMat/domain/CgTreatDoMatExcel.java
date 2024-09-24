package com.ruoyi.CgTreatDoMat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 待办事件对象 cg_treat_do_mat
 * 
 * @author ruoyi
 * @date 2024-07-29
 */
public class CgTreatDoMatExcel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 待办事件类型 */
    @Excel(name = "待办事件类型")
    private String type;

    /** 待办事件标题 */
    @Excel(name = "待办事件标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

//    /** 相关照片 */
//    @Excel(name = "相关照片")
//    private String imgs;




    /** 提交的队伍ID */
    @Excel(name = "提交的队伍")
    private String tTId;

    /** 提交的用户ID */
    @Excel(name = "提交的用户")
    private String uTId;

    /** 处理的队伍ID */
    @Excel(name = "处理的队伍")
    private String cTId;

    /** 处理的用户ID */
    @Excel(name = "处理的用户")
    private String cUId;

    /** 处理结果 */
    @Excel(name = "处理结果")
    private String resultContent;

//    /** 处理结果图片 */
//    @Excel(name = "处理结果图片")
//    private String resultImgs;

    /** 处理开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "处理开始时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date resultStartTime;

    /** 处理完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "处理完成时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date resultEndTime;

    /** 最晚改善时间 */
    @Excel(name = "最晚改善时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;


    /** 打分 */
    @Excel(name = "打分")
    private double fenNum;

    /** 打分时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "打分时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date fenTime;

    /** 晚了多久/分钟 */
//    @Excel(name = "晚了多久/分钟")
//    private Long wanTime;

    /** 打分备注 */
    @Excel(name = "打分备注")
    private String fenRemark;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String gettTId() {
        return tTId;
    }

    public void settTId(String tTId) {
        this.tTId = tTId;
    }

    public String getuTId() {
        return uTId;
    }

    public void setuTId(String uTId) {
        this.uTId = uTId;
    }

    public String getcTId() {
        return cTId;
    }

    public void setcTId(String cTId) {
        this.cTId = cTId;
    }

    public String getcUId() {
        return cUId;
    }

    public void setcUId(String cUId) {
        this.cUId = cUId;
    }

    public String getResultContent() {
        return resultContent;
    }

    public void setResultContent(String resultContent) {
        this.resultContent = resultContent;
    }


    public Date getResultStartTime() {
        return resultStartTime;
    }

    public void setResultStartTime(Date resultStartTime) {
        this.resultStartTime = resultStartTime;
    }

    public Date getResultEndTime() {
        return resultEndTime;
    }

    public void setResultEndTime(Date resultEndTime) {
        this.resultEndTime = resultEndTime;
    }

    public double getFenNum() {
        return fenNum;
    }

    public void setFenNum(double fenNum) {
        this.fenNum = fenNum;
    }

    public Date getFenTime() {
        return fenTime;
    }

    public void setFenTime(Date fenTime) {
        this.fenTime = fenTime;
    }
//
//    public Long getWanTime() {
//        return wanTime;
//    }
//
//    public void setWanTime(Long wanTime) {
//        this.wanTime = wanTime;
//    }

    public String getFenRemark() {
        return fenRemark;
    }

    public void setFenRemark(String fenRemark) {
        this.fenRemark = fenRemark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
