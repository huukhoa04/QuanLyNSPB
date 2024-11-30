package com.quanlynspb.models.bean;

public class PhongBan {
    private String idPb;
    private String tenPb;
    private String desc;
    public PhongBan(String idPb, String tenPb, String desc) {
        this.idPb = idPb;
        this.tenPb = tenPb;
        this.desc = desc;
    }
    public String getIdPb() {
        return idPb;
    }
    public void setIdPb(String idPb) {
        this.idPb = idPb;
    }
    public String getTenPb() {
        return tenPb;
    }
    public void setTenPb(String tenPb) {
        this.tenPb = tenPb;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
