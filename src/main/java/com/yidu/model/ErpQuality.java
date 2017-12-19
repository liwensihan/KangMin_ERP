package com.yidu.model;

import java.util.List;

public class ErpQuality {
    private String quaId;//质检id、

    private String indentId;//生产id

    private String purcId;//采购id

    private String quaSreial;//质检编号

    private String quaQc;//质检qc

    private Integer quaGood;//质检好的

    private Integer quaBab;//质检不良品

    private Integer quaIsva;//质检状态

    private Integer isva;//是否有效

    private String creater;//创建人

    private String createtime;//创建时间

    private String remark;//备注
    
    private List<ErpQualityDetail> det;//质检明细的集合
    /**
     * 质检明细的集合
     * @return
     */
    public List<ErpQualityDetail> getDet() {
		return det;
	}
    /**
     * 质检明细的集合
     * @param det
     */
	public void setDet(List<ErpQualityDetail> det) {
		this.det = det;
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
     * 创建生产id
     * @return
     */
    public String getIndentId() {
        return indentId;
    }
    /**
     * 生产id
     * @param indentId
     */
    public void setIndentId(String indentId) {
        this.indentId = indentId == null ? null : indentId.trim();
    }
    /**
     * 采购id
     * @return
     */
    public String getPurcId() {
        return purcId;
    }
    /**
     * 采购id
     * @param purcId
     */
    public void setPurcId(String purcId) {
        this.purcId = purcId == null ? null : purcId.trim();
    }
    /**
     * 质检编号
     * @return
     */
    public String getQuaSreial() {
        return quaSreial;
    }
    /**
     * 质检编号
     * @param quaSreial
     */
    public void setQuaSreial(String quaSreial) {
        this.quaSreial = quaSreial == null ? null : quaSreial.trim();
    }
    /**
     * 质检人
     * @return
     */
    public String getQuaQc() {
        return quaQc;
    }
    /**
     * 质检人
     * @param quaQc
     */
    public void setQuaQc(String quaQc) {
        this.quaQc = quaQc == null ? null : quaQc.trim();
    }
    /**
     * 良品
     * @return
     */
    public Integer getQuaGood() {
        return quaGood;
    }
    /**
     * 良品
     * @param quaGood
     */
    public void setQuaGood(Integer quaGood) {
        this.quaGood = quaGood;
    }
    /**
     * 不良品
     * @return
     */
    public Integer getQuaBab() {
        return quaBab;
    }
    /**
     * 不良品
     * @param quaBab
     */
    public void setQuaBab(Integer quaBab) {
        this.quaBab = quaBab;
    }
    /**
     * 质检状态
     * @return
     */
    public Integer getQuaIsva() {
        return quaIsva;
    }
    /**
     * 质检状态
     * @param quaIsva
     */
    public void setQuaIsva(Integer quaIsva) {
        this.quaIsva = quaIsva;
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
     * 
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
}