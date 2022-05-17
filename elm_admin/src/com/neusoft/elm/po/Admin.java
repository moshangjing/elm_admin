package com.neusoft.elm.po;

public class Admin {
    private Integer adminId;
    private String adminName;
    private String password;

    public Integer getAdminId() {
        return adminId;
    }
    public String getAdminName() {
        return adminName;
    }
    public String getPassword() {
        return password;
    }
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
