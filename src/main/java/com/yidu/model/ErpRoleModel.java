package com.yidu.model;

public class ErpRoleModel {
    private String roleModelId;

    private String modelId;

    private String roleId;

    public String getRoleModelId() {
        return roleModelId;
    }

    public void setRoleModelId(String roleModelId) {
        this.roleModelId = roleModelId == null ? null : roleModelId.trim();
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}