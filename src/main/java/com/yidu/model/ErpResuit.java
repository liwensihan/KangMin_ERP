package com.yidu.model;
/**
 * 药效表
 * @author 大晶儿
 * @date 2017年10月19日
 */
public class ErpResuit {
    private String resId;//药效表id

    private String resSerial;//药效编号

    private String resName;//药效名字

    private Integer isva;//是否有效

    private String creater;//创建人

    private String createtime;//创建时间

    private String remark;//备注
	/**
	 * 药效表id
	 * @return
	 */
    public String getResId() {
        return resId;
    }
    /**
     * 药效表id
     * @param resId
     */
    public void setResId(String resId) {
        this.resId = resId == null ? null : resId.trim();
    }
    /**
     * 药效编号
     * @return
     */
    public String getResSerial() {
        return resSerial;
    }
    /**
     * 药效编号
     * @param resSerial
     */
    public void setResSerial(String resSerial) {
        this.resSerial = resSerial == null ? null : resSerial.trim();
    }
    /**
     * 药效名字
     * @return
     */
    public String getResName() {
        return resName;
    }
    /**
     * 药效名字
     * @param resName
     */
    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
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