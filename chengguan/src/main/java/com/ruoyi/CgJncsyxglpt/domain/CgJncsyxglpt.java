package com.ruoyi.CgJncsyxglpt.domain;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
/**
 * 济南市城市服务运行管理平台对象 cg_jncsyxglpt
 *
 * @author ruoyi
 * @date 2024-09-23
 */
public class CgJncsyxglpt extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 时限 */
    @Excel(name = "时限")
    private String shixian;

    /** 剩余时间 */
    @Excel(name = "剩余时间")
    private String shengyushijian;

    /** 案件号 */
    @Excel(name = "案件号")
    private String anjianhao;

    /** 区域 */
    @Excel(name = "区域")
    private String quyu;

    /** 状态 */
    @Excel(name = "状态")
    private String zhuangtai;

    /** 当前环节 */
    @Excel(name = "当前环节")
    private String dangqianhuanjie;

    /** 案件来源 */
    @Excel(name = "案件来源")
    private String anjianlaiyuan;

    /** 来件时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "来件时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date laijianshijian;

    /** 类别 */
    @Excel(name = "类别")
    private String leibie;

    /** 事发位置 */
    @Excel(name = "事发位置")
    private String shifaweizhi;

    /** 问题描述 */
    @Excel(name = "问题描述")
    private String wentimiaoshu;

    /** 事发时间 */
    @Excel(name = "事发时间")
    private String shifashijian;

    /** 到期时间 */
    @Excel(name = "到期时间")
    private String daoqishijian;

    /** 处理人姓名 */
    @Excel(name = "处理人姓名")
    private String tName;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setShixian(String shixian)
    {
        this.shixian = shixian;
    }

    public String getShixian()
    {
        return shixian;
    }
    public void setShengyushijian(String shengyushijian)
    {
        this.shengyushijian = shengyushijian;
    }

    public String getShengyushijian()
    {
        return shengyushijian;
    }
    public void setAnjianhao(String anjianhao)
    {
        this.anjianhao = anjianhao;
    }

    public String getAnjianhao()
    {
        return anjianhao;
    }
    public void setQuyu(String quyu)
    {
        this.quyu = quyu;
    }

    public String getQuyu()
    {
        return quyu;
    }
    public void setZhuangtai(String zhuangtai)
    {
        this.zhuangtai = zhuangtai;
    }

    public String getZhuangtai()
    {
        return zhuangtai;
    }
    public void setDangqianhuanjie(String dangqianhuanjie)
    {
        this.dangqianhuanjie = dangqianhuanjie;
    }

    public String getDangqianhuanjie()
    {
        return dangqianhuanjie;
    }
    public void setAnjianlaiyuan(String anjianlaiyuan)
    {
        this.anjianlaiyuan = anjianlaiyuan;
    }

    public String getAnjianlaiyuan()
    {
        return anjianlaiyuan;
    }
    public void setLaijianshijian(Date laijianshijian)
    {
        this.laijianshijian = laijianshijian;
    }

    public Date getLaijianshijian()
    {
        return laijianshijian;
    }
    public void setLeibie(String leibie)
    {
        this.leibie = leibie;
    }

    public String getLeibie()
    {
        return leibie;
    }
    public void setShifaweizhi(String shifaweizhi)
    {
        this.shifaweizhi = shifaweizhi;
    }

    public String getShifaweizhi()
    {
        return shifaweizhi;
    }
    public void setWentimiaoshu(String wentimiaoshu)
    {
        this.wentimiaoshu = wentimiaoshu;
    }

    public String getWentimiaoshu()
    {
        return wentimiaoshu;
    }
    public void setShifashijian(String shifashijian)
    {
        this.shifashijian = shifashijian;
    }

    public String getShifashijian()
    {
        return shifashijian;
    }
    public void setDaoqishijian(String daoqishijian)
    {
        this.daoqishijian = daoqishijian;
    }

    public String getDaoqishijian()
    {
        return daoqishijian;
    }
    public void settName(String tName)
    {
        this.tName = tName;
    }

    public String gettName()
    {
        return tName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("shixian", getShixian())
                .append("shengyushijian", getShengyushijian())
                .append("anjianhao", getAnjianhao())
                .append("quyu", getQuyu())
                .append("zhuangtai", getZhuangtai())
                .append("dangqianhuanjie", getDangqianhuanjie())
                .append("anjianlaiyuan", getAnjianlaiyuan())
                .append("laijianshijian", getLaijianshijian())
                .append("leibie", getLeibie())
                .append("shifaweizhi", getShifaweizhi())
                .append("wentimiaoshu", getWentimiaoshu())
                .append("shifashijian", getShifashijian())
                .append("daoqishijian", getDaoqishijian())
                .append("tName", gettName())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
