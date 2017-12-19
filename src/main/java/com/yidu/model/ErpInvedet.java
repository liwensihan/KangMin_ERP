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
    private String staName;//创建人名字
    private String cre;
    /**
     * 数据库的别名  创建时间
     * @return
     */
    public String getCre() {
		return cre;
	}
    /**
     * 数据库的别名  创建时间
     * @param cre
     */
	public void setCre(String cre) {
		this.cre = cre;
	}
    /**
     * 创建人的名字
     * @return
     */
	public String getStaName() {
		return staName;
	}
    /**
     * 创建人的时间
     * @param staName
     */
	public void setStaName(String staName) {
		this.staName = staName;
	}
    /**
     * 药品名字
     * @return
     */
	public String getKinsName() {
		return kinsName;
	}
    /**
     * 药品名字
     * @param kinsName
     */
	public void setKinsName(String kinsName) {
		this.kinsName = kinsName;
	}
    /**
     * 药效名字
     * @return
     */
	public String getRawName() {
		return rawName;
	}
    /**
     * 药效名字
     * @param rawName
     */
	public void setRawName(String rawName) {
		this.rawName = rawName;
	}
    /**
     * 药效id
     * @return
     */
	public String getRawId() {
		return rawId;
	}
    /**
     * 药效id
     * @param rawId
     */
	public void setRawId(String rawId) {
		this.rawId = rawId;
	}
    /**
     * 
     */
	private String remark;//备注

    private Integer isva;//是否有效
    /**
     * 库存明细的id
     */
    public String getInvedetId() {
        return invedetId;
    }
    /**
     * 库存明细的id
     * @param invedetId
     */
    public void setInvedetId(String invedetId) {
        this.invedetId = invedetId == null ? null : invedetId.trim();
    }
    /**
     * 入库id
     * @return
     */
    public String getBankId() {
        return bankId;
    }
    /**
     * 入库id
     * @param bankId
     */
    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
    }
    /**
     * 仓库id
     * @return
     */
    public String getWareId() {
        return wareId;
    }
    /**
     * 仓库id
     * @param wareId
     */
    public void setWareId(String wareId) {
        this.wareId = wareId == null ? null : wareId.trim();
    }
    /**
     * 出库id
     * @return
     */
    public String getObId() {
        return obId;
    }
    /**
     * 出库id
     * @param obId
     */
    public void setObId(String obId) {
        this.obId = obId == null ? null : obId.trim();
    }
    /**
     * 药品id
     * @return
     */
    public String getKinId() {
        return kinId;
    }
    /**
     * 药品id
     * @param kinId
     */
    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }
    /**
     * 库存明细数量
     * @return
     */
    public Integer getInvedetNum() {
        return invedetNum;
    }
    /**
     * 库存明细数量
     * @param invedetNum
     */
    public void setInvedetNum(Integer invedetNum) {
        this.invedetNum = invedetNum;
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
     * @param creater
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
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
     * @param createtime
     */
    

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
    /**
     * 备注信息
     * @return
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 备注
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    /**
     * 是否有效
     * @return
     */
    public Integer getIsva() {
        return isva;
    }
    /**
     * 是否有效
     * @param isva
     */
    public void setIsva(Integer isva) {
        this.isva = isva;
    }
}