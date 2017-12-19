package com.yidu.model;

import java.math.BigDecimal;

public class ErpFdproform {
    private String fdproId;

    private String fdproSerial;

    private String annexId;

    private String staId;

    private int fdproWarecount;

    private double fdproSumprice;

    private String fdproTime;

    private Integer fdproIsva;

    private String createtime;

    private String creater;

    private String remark;
    
    private String staName;
    
    private String annexName;
    
    private String isva;
    
    
    
    
	public int getFdproWarecount() {
		return fdproWarecount;
	}

	public void setFdproWarecount(int fdproWarecount) {
		this.fdproWarecount = fdproWarecount;
	}

	public double getFdproSumprice() {
		return fdproSumprice;
	}

	public void setFdproSumprice(double fdproSumprice) {
		this.fdproSumprice = fdproSumprice;
	}

	public String getIsva() {
		return isva;
	}

	public void setIsva(String isva) {
		this.isva = isva;
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

	public String getAnnexName() {
		return annexName;
	}

	public void setAnnexName(String annexName) {
		this.annexName = annexName;
	}

	public String getFdproId() {
        return fdproId;
    }

    public void setFdproId(String fdproId) {
        this.fdproId = fdproId == null ? null : fdproId.trim();
    }

    public String getFdproSerial() {
        return fdproSerial;
    }

    public void setFdproSerial(String fdproSerial) {
        this.fdproSerial = fdproSerial == null ? null : fdproSerial.trim();
    }

    public String getAnnexId() {
        return annexId;
    }

    public void setAnnexId(String annexId) {
        this.annexId = annexId == null ? null : annexId.trim();
    }

    public String getStaId() {
        return staId;
    }

    public void setStaId(String staId) {
        this.staId = staId == null ? null : staId.trim();
    }

    

    

    public String getFdproTime() {
        return fdproTime;
    }

    public void setFdproTime(String fdproTime) {
        this.fdproTime = fdproTime == null ? null : fdproTime.trim();
    }

    public Integer getFdproIsva() {
        return fdproIsva;
    }

    public void setFdproIsva(Integer fdproIsva) {
        this.fdproIsva = fdproIsva;
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