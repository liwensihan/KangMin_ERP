package com.yidu.model;

public class ErpQualityDetail {
    private String qdetId;

    private String quaId;

    private String rawId;

    private String kinId;

    private Integer qdetGood;

    private Integer qdetBab;

    private String remark;

    private String createtime;
    
    private String kindName;
    private String rawName;
    /**
     * 原材料名字
     * @return
     */
    public String getRawName() {
		return rawName;
	}
    /**
     * 原材料名字
     * @param rawName
     */
	public void setRawName(String rawName) {
		this.rawName = rawName;
	}
    /**
     * 药品名字
     * @return
     */
	public String getKindName() {
		return kindName;
	}
    /**
     * 药品名字
     * @param kindName
     */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
    /**
     * 质检明细id
     * @return
     */
	public String getQdetId() {
        return qdetId;
    }
    /**
     * 质检明细id
     * @param qdetId
     */
    public void setQdetId(String qdetId) {
        this.qdetId = qdetId == null ? null : qdetId.trim();
    }
    /**
     * 质检id
     * @return
     */
    public String getQuaId() {
        return quaId;
    }
    /**
     * 质检id
     * @param quaId
     */
    public void setQuaId(String quaId) {
        this.quaId = quaId == null ? null : quaId.trim();
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
        this.rawId = rawId == null ? null : rawId.trim();
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
     * 良品
     * @return
     */
    public Integer getQdetGood() {
        return qdetGood;
    }
    /**
     * 良品
     * @param qdetGood
     */
    public void setQdetGood(Integer qdetGood) {
        this.qdetGood = qdetGood;
    }
    /**
     * 不良品
     * @return
     */
    public Integer getQdetBab() {
        return qdetBab;
    }
    /**
     * 不良品
     * @param qdetBab
     */
    public void setQdetBab(Integer qdetBab) {
        this.qdetBab = qdetBab;
    }
    /**
     * 备注
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
}