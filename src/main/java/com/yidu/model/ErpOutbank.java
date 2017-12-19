package com.yidu.model;

import java.util.List;

public class ErpOutbank {
    private String obId;//出库id

    private String kinordId;//分店采购id

    private String obNumber;//出库编号

    private String obTime;//出库时间

    private Integer obWarecount;//出库数量

    private Integer obBusibess;//书库状态

    private String obStaffid;//出库人

    private Integer isva;//是否有效

    private String createtime;//创建时间

    private String creater;//创建人

    private String remark;//备注
    
    private String staName;//出库人姓名
    
    private List<ErpInvedet> det;//库存明细
    /**
     * 库存明细集合
     * @return
     */
    public List<ErpInvedet> getDet() {
		return det;
	}
    /**
     * 库存明细集合
     * @param det
     */
	public void setDet(List<ErpInvedet> det) {
		this.det = det;
	}
    /**
     * 出库人名字
     * @return
     */
	public String getStaName() {
		return staName;
	}
    /**
     * 出库人名字
     * @param staName
     */
	public void setStaName(String staName) {
		this.staName = staName;
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
     * 分店采购id
     * @return
     */
    public String getKinordId() {
        return kinordId;
    }
    /**
     * 分店采购id
     * @param kinordId
     */
    public void setKinordId(String kinordId) {
        this.kinordId = kinordId == null ? null : kinordId.trim();
    }
    /**
     * 出库编号
     * @return
     */
    public String getObNumber() {
        return obNumber;
    }
    /**
     * 出库编号
     * @param obNumber
     */
    public void setObNumber(String obNumber) {
        this.obNumber = obNumber == null ? null : obNumber.trim();
    }
    /**
     * 出库时间
     * @return
     */
    public String getObTime() {
        return obTime;
    }
    /**
     * 出库时间
     * @param obTime
     */
    public void setObTime(String obTime) {
        this.obTime = obTime == null ? null : obTime.trim();
    }
    /**
     * 出库数量
     * @return
     */
    public Integer getObWarecount() {
        return obWarecount;
    }
    /**
     * 出库数量
     * @param obWarecount
     */
    public void setObWarecount(Integer obWarecount) {
        this.obWarecount = obWarecount;
    }
    /**
     * 出库状态
     * @return
     */
    public Integer getObBusibess() {
        return obBusibess;
    }
    /**
     * 出库状态
     * @param obBusibess
     */
    public void setObBusibess(Integer obBusibess) {
        this.obBusibess = obBusibess;
    }
    /**
     * 出库人id
     * @return
     */
    public String getObStaffid() {
        return obStaffid;
    }
    /**
     * 出库人id
     * @param obStaffid
     */
    public void setObStaffid(String obStaffid) {
        this.obStaffid = obStaffid == null ? null : obStaffid.trim();
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