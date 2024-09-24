package com.ruoyi.CgFenHistory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分数记录对象 cg_fen_history
 *
 * @author ruoyi
 * @date 2024-09-12
 */
public class CgFenHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户ID */
    private Long uId;
    @Excel(name = "姓名")
    private String name;

    /** 分数 */
    @Excel(name = "分数")
    private double fen;

    /** 分数类型1.迟到2早退 */
    @Excel(name = "扣分类型")
    private String fenType;



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
    public void setFen(double fen)
    {
        this.fen = fen;
    }

    public double getFen()
    {
        return fen;
    }
    public void setFenType(String fenType)
    {
        this.fenType = fenType;
    }

    public String getFenType()
    {
        return fenType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("uId", getuId())
                .append("fen", getFen())
                .append("fenType", getFenType())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
