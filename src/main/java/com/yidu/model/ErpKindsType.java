package com.yidu.model;
/**
 * 类型
 * @author 大晶儿
 * @date 2017年10月19日
 */
public class ErpKindsType {
    private String typeId;//类型id

    private String typeSerial; //类型编号

    private String typeName;//类型名字

    private String remark;//备注

    private String creater;//创建人

    private String createtime;//创建时间
	/**
	 * 类型id
	 * @return
	 */
    public String getTypeId() {
        return typeId;
    }
	/**
	 * 类型id
	 * @param typeId
	 */
    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }
	/**
	 * 类型编号
	 * @return
	 */
    public String getTypeSerial() {
        return typeSerial;
    }
    /**
     * 类型编号
     * @param typeSerial
     */
    public void setTypeSerial(String typeSerial) {
        this.typeSerial = typeSerial == null ? null : typeSerial.trim();
    }
    /**
     * 类型名字
     * @return
     */
    public String getTypeName() {
        return typeName;
    }
    /**
     * 类型名字
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
    /**
     * 类型备注
     * @return
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 类型备注
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
     * 创建时间随时
     * @param createtime
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}