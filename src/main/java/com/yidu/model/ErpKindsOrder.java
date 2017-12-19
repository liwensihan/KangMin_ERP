package com.yidu.model;

import java.math.BigDecimal;

public class ErpKindsOrder {
	 private String kinordId;

	    private String kinId;

	    private String annexId;

	    private String kinordSerial;

	    private BigDecimal kinordNum;

	    private Integer kinordBusibess;

	    private Integer state;

	    private Integer isva;

	    private String createtime;

	    private String creater;

	    private String remark;

	    public String getKinordId() {
	        return kinordId;
	    }

	    public void setKinordId(String kinordId) {
	        this.kinordId = kinordId == null ? null : kinordId.trim();
	    }

	    public String getKinId() {
	        return kinId;
	    }

	    public void setKinId(String kinId) {
	        this.kinId = kinId == null ? null : kinId.trim();
	    }

	    public String getAnnexId() {
	        return annexId;
	    }

	    public void setAnnexId(String annexId) {
	        this.annexId = annexId == null ? null : annexId.trim();
	    }

	    public String getKinordSerial() {
	        return kinordSerial;
	    }

	    public void setKinordSerial(String kinordSerial) {
	        this.kinordSerial = kinordSerial == null ? null : kinordSerial.trim();
	    }

	    public BigDecimal getKinordNum() {
	        return kinordNum;
	    }

	    public void setKinordNum(BigDecimal kinordNum) {
	        this.kinordNum = kinordNum;
	    }

	    public Integer getKinordBusibess() {
	        return kinordBusibess;
	    }

	    public void setKinordBusibess(Integer kinordBusibess) {
	        this.kinordBusibess = kinordBusibess;
	    }

	    public Integer getState() {
	        return state;
	    }

	    public void setState(Integer state) {
	        this.state = state;
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