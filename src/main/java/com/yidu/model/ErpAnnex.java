package com.yidu.model;

import java.math.BigDecimal;

public class ErpAnnex {
    private String annexId;			//分店ID
    private String annexNumber;		//分店编号
    private String annexName;		//分店名称
    private String annexAdd;		//分店地址
    private String annexPhone;		//分店电话
    private BigDecimal annexPrice;	//分店总资产
    private String annexBoss;		//分店负责人姓名
    private String annexTime;		//分店创建时间
    private String creater;			//创建人
    private Integer isva;			//是否有效
    private String createtime;		//创建时间
    private String remark;			//备注
    
    /**
     * 分店ID
     * @return
     */
    public String getAnnexId() {
        return annexId;
    }
    /**
     * 分店ID
     * @param annexId
     */
    public void setAnnexId(String annexId) {
        this.annexId = annexId == null ? null : annexId.trim();
    }
    /**
     * 分店编号
     * @return
     */
    public String getAnnexNumber() {
        return annexNumber;
    }
    /**
     * 分店编号
     * @param annexNumber
     */
    public void setAnnexNumber(String annexNumber) {
        this.annexNumber = annexNumber == null ? null : annexNumber.trim();
    }
    /**
     * 分店名称
     * @return
     */
    public String getAnnexName() {
        return annexName;
    }
    /**
     * 分店名称
     * @param annexName
     */
    public void setAnnexName(String annexName) {
        this.annexName = annexName == null ? null : annexName.trim();
    }
    /**
     * 分店地址
     * @return
     */
    public String getAnnexAdd() {
        return annexAdd;
    }
    /**
     * 分店地址
     * @param annexAdd
     */
    public void setAnnexAdd(String annexAdd) {
        this.annexAdd = annexAdd == null ? null : annexAdd.trim();
    }
    /**
     * 分店电话
     * @return
     */
    public String getAnnexPhone() {
        return annexPhone;
    }
    /**
     * 分店电话
     * @param annexPhone
     */
    public void setAnnexPhone(String annexPhone) {
        this.annexPhone = annexPhone == null ? null : annexPhone.trim();
    }
    /**
     * 分店总资产
     * @return
     */
    public BigDecimal getAnnexPrice() {
        return annexPrice;
    }
    /**
     * 分店总资产
     * @param annexPrice
     */
    public void setAnnexPrice(BigDecimal annexPrice) {
        this.annexPrice = annexPrice;
    }
    /**
     * 分店负责人姓名
     * @return
     */
    public String getAnnexBoss() {
        return annexBoss;
    }
    /**
     * 分店负责人姓名
     * @param annexBoss
     */
    public void setAnnexBoss(String annexBoss) {
        this.annexBoss = annexBoss == null ? null : annexBoss.trim();
    }
    /**
     * 分店创建时间
     * @return
     */
    public String getAnnexTime() {
        return annexTime;
    }
    /**
     * 分店创建时间
     * @param annexTime
     */
    public void setAnnexTime(String annexTime) {
        this.annexTime = annexTime == null ? null : annexTime.trim();
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