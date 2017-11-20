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
    
    
    
    
    
    public String getAnnexId() {
		return annexId;
	}

	public void setAnnexId(String annexId) {
		this.annexId = annexId;
	}

	public String getPerRoleId() {
		return perRoleId;
	}

	public void setPerRoleId(String perRoleId) {
		this.perRoleId = perRoleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDepaName() {
		return depaName;
	}

	public void setDepaName(String depaName) {
		this.depaName = depaName;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getStaId() {
        return staId;
    }

    public void setStaId(String staId) {
        this.staId = staId == null ? null : staId.trim();
    }

    public String getDepaId() {
        return depaId;
    }

    public void setDepaId(String depaId) {
        this.depaId = depaId == null ? null : depaId.trim();
    }

    public String getStaSerial() {
        return staSerial;
    }

    public void setStaSerial(String staSerial) {
        this.staSerial = staSerial == null ? null : staSerial.trim();
    }

    public String getStaName() {
        return staName;
    }

    public void setStaName(String staName) {
        this.staName = staName == null ? null : staName.trim();
    }

    public String getStaEmail() {
        return staEmail;
    }

    public void setStaEmail(String staEmail) {
        this.staEmail = staEmail == null ? null : staEmail.trim();
    }

    public String getStaPwd() {
        return staPwd;
    }

    public void setStaPwd(String staPwd) {
        this.staPwd = staPwd == null ? null : staPwd.trim();
    }

    public Short getStaAge() {
        return staAge;
    }

    public void setStaAge(Short staAge) {
        this.staAge = staAge;
    }

    public String getStaSex() {
        return staSex;
    }

    public void setStaSex(String staSex) {
        this.staSex = staSex == null ? null : staSex.trim();
    }

    public String getStaEntrytime() {
        return staEntrytime;
    }

    public void setStaEntrytime(String staEntrytime) {
        this.staEntrytime = staEntrytime == null ? null : staEntrytime.trim();
    }

    public String getStaDimissiontime() {
        return staDimissiontime;
    }

    public void setStaDimissiontime(String staDimissiontime) {
        this.staDimissiontime = staDimissiontime == null ? null : staDimissiontime.trim();
    }

    public String getStaImg() {
        return staImg;
    }

    public void setStaImg(String staImg) {
        this.staImg = staImg == null ? null : staImg.trim();
    }

    public String getStaBackgd() {
        return staBackgd;
    }

    public void setStaBackgd(String staBackgd) {
        this.staBackgd = staBackgd == null ? null : staBackgd.trim();
    }

    public Integer getIsva() {
        return isva;
    }

    public void setIsva(Integer isva) {
        this.isva = isva;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}