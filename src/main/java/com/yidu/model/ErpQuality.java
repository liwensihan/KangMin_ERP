package com.yidu.model;
/**
 * 质检表
 * @author 大晶儿
 * @Date 
 */
public class ErpQuality {
	
    private String quaId;

    private String indentId;

    private String quaSreial;

    private String quaQc;

    private Integer quaGood;

    private Integer quaBab;

    private Integer quaIsva;

    private Integer isva;

    private String creater;

    private String createtime;

    private String remark;

    public String getQuaId() {
        return quaId;
    }

    public void setQuaId(String quaId) {
        this.quaId = quaId == null ? null : quaId.trim();
    }

    public String getIndentId() {
        return indentId;
    }

    public void setIndentId(String indentId) {
        this.indentId = indentId == null ? null : indentId.trim();
    }

    public String getQuaSreial() {
        return quaSreial;
    }

    public void setQuaSreial(String quaSreial) {
        this.quaSreial = quaSreial == null ? null : quaSreial.trim();
    }

    public String getQuaQc() {
        return quaQc;
    }

    public void setQuaQc(String quaQc) {
        this.quaQc = quaQc == null ? null : quaQc.trim();
    }

    public Integer getQuaGood() {
        return quaGood;
    }

    public void setQuaGood(Integer quaGood) {
        this.quaGood = quaGood;
    }

    public Integer getQuaBab() {
        return quaBab;
    }

    public void setQuaBab(Integer quaBab) {
        this.quaBab = quaBab;
    }

    public Integer getQuaIsva() {
        return quaIsva;
    }

    public void setQuaIsva(Integer quaIsva) {
        this.quaIsva = quaIsva;
    }

    public Integer getIsva() {
        return isva;
    }

    public void setIsva(Integer isva) {
        this.isva = isva;
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
}