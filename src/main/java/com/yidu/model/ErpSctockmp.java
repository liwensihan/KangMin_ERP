package com.yidu.model;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 分店销售订单模型
 * @author ouyang
 * @data 2017年11月23日13:40:27
 */
public class ErpSctockmp {
    private String saleId;			//主键ID
    private String staffId;			//员工ID
    private String annexId;			//分店ID
    private String memberId;		//会员ID
    private BigDecimal saleNum;		//销售总数量
    private Date saleDate;			//订单时间
    private BigDecimal saleMoney;	//应付金额
    private BigDecimal saleMoney2;	//实付金额
    private BigDecimal saleMoney3;	//找零
    private String creater;			//创建人
    private String createtime;		//创建时间
    private String remark;			//备注
    
    /**
     * 主键ID 
     * @return
     */
    public String getSaleId() {
        return saleId;
    }
    /**
     * 主键ID
     * @param saleId
     */
    public void setSaleId(String saleId) {
        this.saleId = saleId == null ? null : saleId.trim();
    }
    /**
     * 员工ID
     * @return
     */
    public String getStaffId() {
        return staffId;
    }
    /**
     * 员工ID
     * @param staffId
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }
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
     * 会员ID
     * @return
     */
    public String getMemberId() {
        return memberId;
    }
    /**
     * 会员ID
     * @param memberId
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }
    /**
     * 销售总数量
     * @return
     */
    public BigDecimal getSaleNum() {
        return saleNum;
    }
    /**
     * 销售总数量
     * @param saleNum
     */
    public void setSaleNum(BigDecimal saleNum) {
        this.saleNum = saleNum;
    }
    /**
     * 订单时间
     * @return
     */
    public Date getSaleDate() {
        return saleDate;
    }
    /**
     * 订单时间
     * @param saleDate
     */
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    /**
     * 应付金额
     * @return
     */
    public BigDecimal getSaleMoney() {
        return saleMoney;
    }
    /**
     * 应付金额
     * @param saleMoney
     */
    public void setSaleMoney(BigDecimal saleMoney) {
        this.saleMoney = saleMoney;
    }
    /**
     * 实付金额
     * @return
     */
    public BigDecimal getSaleMoney2() {
        return saleMoney2;
    }
    /**
     * 实付金额
     * @param saleMoney2
     */
    public void setSaleMoney2(BigDecimal saleMoney2) {
        this.saleMoney2 = saleMoney2;
    }
    /**
     * 找零
     * @return
     */
    public BigDecimal getSaleMoney3() {
        return saleMoney3;
    }
    /**
     * 找零
     * @param saleMoney3
     */
    public void setSaleMoney3(BigDecimal saleMoney3) {
        this.saleMoney3 = saleMoney3;
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