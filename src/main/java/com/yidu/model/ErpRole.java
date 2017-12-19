package com.yidu.model;

public class ErpRole {
    private String roleId;

    private String roleColor;

    private String roleName;

    private String isva;

    private String createtime;

    private String creater;

    private String remark;
    
    private int page;
    
    private int limit;
    
    private String erpModelId;
    
    private String modelName;
    
    private String modelId;
    
    
    /**
     * 模型Id
     * @return
     */
    public String getModelId() {
		return modelId;
	}
    
    /**
     * 模型Id
     * @return
     */
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	
	/**
     * 模型名称
     * @return
     */
	public String getModelName() {
		return modelName;
	}
	
	/**
     * 模型名称
     * @return
     */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	
	public String getErpModelId() {
		return erpModelId;
	}

	public void setErpModelId(String erpModelId) {
		this.erpModelId = erpModelId;
	}
	
	/**
     * 页面page
     * @return
     */
	public int getPage() {
		return page;
	}
	
	/**
     * 页面page
     * @return
     */
	public void setPage(int page) {
		this.page = page;
	}

	/**
     * 页面limit
     * @return
     */
	public int getLimit() {
		return limit;
	}

	/**
     * 页面limit
     * @return
     */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
     * 角色id
     * @return
     */
	public String getRoleId() {
        return roleId;
    }

	/**
     * 角色id
     * @return
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    
    public String getRoleColor() {
        return roleColor;
    }

    public void setRoleColor(String roleColor) {
        this.roleColor = roleColor == null ? null : roleColor.trim();
    }

    /**
     * 角色名称
     * @return
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名称
     * @return
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 是否存在
     * @return
     */
    public String getIsva() {
        return isva;
    }

    /**
     * 是否存在
     * @return
     */
    public void setIsva(String isva) {
        this.isva = isva == null ? null : isva.trim();
    }

    /**
     * 创建时间
     * @return
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     * @return
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    /**
     * 创建人
     * @return
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 创建人
     * @return
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * 备注信息
     * @return
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注信息
     * @return
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}