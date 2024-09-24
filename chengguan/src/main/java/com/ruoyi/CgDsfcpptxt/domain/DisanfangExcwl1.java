package com.ruoyi.CgDsfcpptxt.domain;

import com.ruoyi.common.annotation.Excel;

public class DisanfangExcwl1 {
    private static final long serialVersionUID = 1L;
    @Excel(name = "序号")
    private String xuhao;
    @Excel(name = "测评编号")
    private String cepingxuhao;
    @Excel(name = "所属街办")
    private String suoshujieban;
    @Excel(name = "测评类型")
    private String cepingleixing;
    @Excel(name = "测评内容")
    private String cepingneirong;
    @Excel(name = "应扣分值")
    private String yingkoufenzhi;
    @Excel(name = "位置")
    private String weizhi;
    @Excel(name = "状态")
    private String zhuangtai;
    @Excel(name = "转办时间")
    private String zhuanbanshijian;
    @Excel(name = "整改情况")
    private String zhenggaiqingkuang;
    @Excel(name = "整改时间")
    private String zhenggaishijian;
    @Excel(name = "复核时间")
    private String fuheshijian;
    @Excel(name = "结案时间")
    private String jieanshijian;
    @Excel(name = "整改期限")
    private String zhenggaiqixian;
    @Excel(name = "处理人姓名")
    private String cName;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getXuhao() {
        return xuhao;
    }

    public void setXuhao(String xuhao) {
        this.xuhao = xuhao;
    }

    public String getCepingxuhao() {
        return cepingxuhao;
    }

    public void setCepingxuhao(String cepingxuhao) {
        this.cepingxuhao = cepingxuhao;
    }

    public String getSuoshujieban() {
        return suoshujieban;
    }

    public void setSuoshujieban(String suoshujieban) {
        this.suoshujieban = suoshujieban;
    }

    public String getCepingleixing() {
        return cepingleixing;
    }

    public void setCepingleixing(String cepingleixing) {
        this.cepingleixing = cepingleixing;
    }

    public String getCepingneirong() {
        return cepingneirong;
    }

    public void setCepingneirong(String cepingneirong) {
        this.cepingneirong = cepingneirong;
    }

    public String getYingkoufenzhi() {
        return yingkoufenzhi;
    }

    public void setYingkoufenzhi(String yingkoufenzhi) {
        this.yingkoufenzhi = yingkoufenzhi;
    }

    public String getWeizhi() {
        return weizhi;
    }

    public void setWeizhi(String weizhi) {
        this.weizhi = weizhi;
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public String getZhuanbanshijian() {
        return zhuanbanshijian;
    }

    public void setZhuanbanshijian(String zhuanbanshijian) {
        this.zhuanbanshijian = zhuanbanshijian;
    }

    public String getZhenggaiqingkuang() {
        return zhenggaiqingkuang;
    }

    public void setZhenggaiqingkuang(String zhenggaiqingkuang) {
        this.zhenggaiqingkuang = zhenggaiqingkuang;
    }

    public String getZhenggaishijian() {
        return zhenggaishijian;
    }

    public void setZhenggaishijian(String zhenggaishijian) {
        this.zhenggaishijian = zhenggaishijian;
    }

    public String getFuheshijian() {
        return fuheshijian;
    }

    public void setFuheshijian(String fuheshijian) {
        this.fuheshijian = fuheshijian;
    }

    public String getJieanshijian() {
        return jieanshijian;
    }

    public void setJieanshijian(String jieanshijian) {
        this.jieanshijian = jieanshijian;
    }

    public String getZhenggaiqixian() {
        return zhenggaiqixian;
    }

    public void setZhenggaiqixian(String zhenggaiqixian) {
        this.zhenggaiqixian = zhenggaiqixian;
    }

    @Override
    public String toString() {
        return "DisanfangExcwl1{" +
                "xuhao='" + xuhao + '\'' +
                ", cepingxuhao='" + cepingxuhao + '\'' +
                ", suoshujieban='" + suoshujieban + '\'' +
                ", cepingleixing='" + cepingleixing + '\'' +
                ", cepingneirong='" + cepingneirong + '\'' +
                ", yingkoufenzhi='" + yingkoufenzhi + '\'' +
                ", weizhi='" + weizhi + '\'' +
                ", zhuangtai='" + zhuangtai + '\'' +
                ", zhuanbanshijian='" + zhuanbanshijian + '\'' +
                ", zhenggaiqingkuang='" + zhenggaiqingkuang + '\'' +
                ", zhenggaishijian='" + zhenggaishijian + '\'' +
                ", fuheshijian='" + fuheshijian + '\'' +
                ", jieanshijian='" + jieanshijian + '\'' +
                ", zhenggaiqixian='" + zhenggaiqixian + '\'' +
                ", cName='" + cName + '\'' +
                '}';
    }
}
