package com.yidu.model;

public class ErpPersonelRole {
    private String perRoleId;

    private String roleId;

    private String staId;

    public String getPerRoleId() {
        return perRoleId;
    }

    public void setPerRoleId(String perRoleId) {
        this.perRoleId = perRoleId == null ? null : perRoleId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getStaId() {
        return staId;
    }

    public void setStaId(String staId) {
        this.staId = staId == null ? null : staId.trim();
    }
}