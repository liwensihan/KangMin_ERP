package com.yidu.model;

public class ErpInvedet {
    private String invedetId;//库存明细id

    private String bankId; //入库id

    private String wareId;//仓库id

    private String obId;//出库

    private String kinId;//商品id

    private Integer invedetNum; //数量

    private String creater;//创建人
    
    private String rawId;//原材料id
    
    private String createtime;//创建时间
    private String kinsName;
    private String rawName;
    
    public String getKinsName() {
		return kinsName;
	}

	public void setKinsName(String kinsName) {
		this.kinsName = kinsName;
	}

	public String getRawName() {
		return rawName;
	}

	public void setRawName(String rawName) {
		this.rawName = rawName;
	}

	public String getRawId() {
		return rawId;
	}

	public void setRawId(String rawId) {
		this.rawId = rawId;
	}

	private String remark;//备注

    private Integer isva;//是否有效

    public String getInvedetId() {
        return invedetId;
    }

    public void setInvedetId(String invedetId) {
        this.invedetId = invedetId == null ? null : invedetId.trim();
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
    }

    public String getWareId() {
        return wareId;
    }

    public void setWareId(String wareId) {
        this.wareId = wareId == null ? null : wareId.trim();
    }

    public String getObId() {
        return obId;
    }

    public void setObId(String obId) {
        this.obId = obId == null ? null : obId.trim();
    }

    public String getKinId() {
        return kinId;
    }

    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }

    public Integer getInvedetNum() {
        return invedetNum;
    }

    public void setInvedetNum(Integer invedetNum) {
        this.invedetNum = invedetNum;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIsva() {
        return isva;
    }

    public void setIsva(Integer isva) {
        this.isva = isva;
    }
}