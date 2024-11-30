package com.quanlynspb.models.bean;

public class NhanVien {
    private String id;
    private String name;
    private String idPb;
    private String address;
    public NhanVien(String id, String name, String idPb, String address) {
        this.id = id;
        this.name = name;
        this.idPb = idPb;
        this.address = address;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIdPb() {
        return idPb;
    }
    public void setIdPb(String idPb) {
        this.idPb = idPb;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
