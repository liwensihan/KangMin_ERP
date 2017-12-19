package com.yidu.model;

public class ErpStaff {
	
	private String perRoleId;
	
    private String staId;

    private String depaId;

    private String staSerial;

    private String staName;

    private String staEmail;

    private String staPwd;

    private Short staAge;

    private String staSex;

    private String staEntrytime;

    private String staDimissiontime;

    private String staImg;

    private String staBackgd;

    private Integer isva;

    private String createtime;

    private String creater;

    private String remark;
    
    private String depaName;
    
    private String roleId;
    
    private String roleName;
    
    private int page;
    
    private int limit;
    
    private String annexId;
    
    private String annexName;
    
    
    
    
    
    
    /**
     * 分店名称
     * @return
     */
    public String getAnnexName() {
		return annexName;
	}
    
    /**
     * 分店名称
     * @return
     */
	public void setAnnexName(String annexName) {
		this.annexName = annexName;
	}
	
	/**
     * 分店Id
     * @return
     */
	public String getAnnexId() {
		return annexId;
	}
	
	/**
     * 分店Id
     * @return
     */
	public void setAnnexId(String annexId) {
		this.annexId = annexId;
	}
	
	/**
     * 角色Id
     * @return
     */
	public String getPerRoleId() {
		return perRoleId;
	}
	
	/**
     * 角色Id
     * @return
     */
	public void setPerRoleId(String perRoleId) {
		this.perRoleId = perRoleId;
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
		this.roleName = roleName;
	}
	
	/**
     * 角色id
     * @return
     */
	public String getRoleId() {
		return roleId;
	}
	
	/**
     * 角色Id
     * @return
     */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	/**
     * 部门名称
     * @return
     */
	public String getDepaName() {
		return depaName;
	}
	
	/**
     * 部门名称
     * @return
     */
	public void setDepaName(String depaName) {
		this.depaName = depaName;
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
     * 人员id
     * @return
     */
	public String getStaId() {
        return staId;
    }
	
	/**
     * 人员id
     * @return
     */
    public void setStaId(String staId) {
        this.staId = staId == null ? null : staId.trim();
    }
    
    /**
     * 部门id
     * @return
     */
    public String getDepaId() {
        return depaId;
    }
    
    /**
     * 部门id
     * @return
     */
    public void setDepaId(String depaId) {
        this.depaId = depaId == null ? null : depaId.trim();
    }
    
    /**
     * 人员编号
     * @return
     */
    public String getStaSerial() {
        return staSerial;
    }
    
    /**
     * 人员编号
     * @return
     */
    public void setStaSerial(String staSerial) {
        this.staSerial = staSerial == null ? null : staSerial.trim();
    }
    
    /**
     * 人员名称
     * @return
     */
    public String getStaName() {
        return staName;
    }
    
    /**
     * 人员名称
     * @return
     */
    public void setStaName(String staName) {
        this.staName = staName == null ? null : staName.trim();
    }
    
    /**
     * 人员邮箱
     * @return
     */
    public String getStaEmail() {
        return staEmail;
    }
    
    /**
     * 人员邮箱
     * @return
     */
    public void setStaEmail(String staEmail) {
        this.staEmail = staEmail == null ? null : staEmail.trim();
    }
    
    /**
     * 人员密码
     * @return
     */
    public String getStaPwd() {
        return staPwd;
    }
    
    /**
     * 人员密码
     * @return
     */
    public void setStaPwd(String staPwd) {
        this.staPwd = staPwd == null ? null : staPwd.trim();
    }
    
    /**
     * 人员年龄
     * @return
     */
    public Short getStaAge() {
        return staAge;
    }
    
    /**
     * 人员年龄
     * @return
     */
    public void setStaAge(Short staAge) {
        this.staAge = staAge;
    }
    
    /**
     * 人员性别
     * @return
     */
    public String getStaSex() {
        return staSex;
    }
    
    /**
     * 人员性别
     * @return
     */
    public void setStaSex(String staSex) {
        this.staSex = staSex == null ? null : staSex.trim();
    }
    
    /**
     * 人员入职时间
     * @return
     */
    public String getStaEntrytime() {
        return staEntrytime;
    }
    
    /**
     * 人员入职时间
     * @return
     */
    public void setStaEntrytime(String staEntrytime) {
        this.staEntrytime = staEntrytime == null ? null : staEntrytime.trim();
    }
    
    /**
     * 人员离职时间
     * @return
     */
    public String getStaDimissiontime() {
        return staDimissiontime;
    }
    
    /**
     * 人员离职时间
     * @return
     */
    public void setStaDimissiontime(String staDimissiontime) {
        this.staDimissiontime = staDimissiontime == null ? null : staDimissiontime.trim();
    }
    
    /**
     * 人员图片
     * @return
     */
    public String getStaImg() {
        return staImg;
    }
    
    /**
     * 人员图片
     * @return
     */
    public void setStaImg(String staImg) {
        this.staImg = staImg == null ? null : staImg.trim();
    }
    
    
    public String getStaBackgd() {
        return staBackgd;
    }

    public void setStaBackgd(String staBackgd) {
        this.staBackgd = staBackgd == null ? null : staBackgd.trim();
    }
    
    /**
     * 是否存在
     * @return
     */
    public Integer getIsva() {
        return isva;
    }
    
    /**
     * 是否存在
     * @return
     */
    public void setIsva(Integer isva) {
        this.isva = isva;
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