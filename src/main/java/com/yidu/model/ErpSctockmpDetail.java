package com.yidu.model;

import java.math.BigDecimal;

/**
 * 分店销售明细订单模型
 * @author ouyang
 * @data 2017年11月23日13:40:27
 */
public class ErpSctockmpDetail {
    private String kmpId;		//明细ID
    private String saleId;		//销售订单ID
    private String kinId;		//商品ID
    private Integer kmpNum;		//商品数量
    private BigDecimal kmpPrice;//总价
    private String remake;		//备注
    private String isva;		//是否有效
    
    /**
     * 明细ID
     * @return
     */
    public String getKmpId() {
        return kmpId;
    }
    /**
     * 明细ID
     * @param kmpId
     */
    public void setKmpId(String kmpId) {
        this.kmpId = kmpId == null ? null : kmpId.trim();
    }
    /**
     * 销售订单ID
     * @return
     */
    public String getSaleId() {
        return saleId;
    }
    /**
     * 销售订单ID
     * @param saleId
     */
    public void setSaleId(String saleId) {
        this.saleId = saleId == null ? null : saleId.trim();
    }
    /**
     * 商品ID
     * @return
     */
    public String getKinId() {
        return kinId;
    }
    /**
     * 商品ID
     * @param kinId
     */
    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }
    /**
     * 商品数量
     * @return
     */
    public Integer getKmpNum() {
        return kmpNum;
    }
    /**
     * 商品数量
     * @param kmpNum
     */
    public void setKmpNum(Integer kmpNum) {
        this.kmpNum = kmpNum;
    }
    /**
     * 总价
     * @return
     */
    public BigDecimal getKmpPrice() {
        return kmpPrice;
    }
    /**
     * 总价
     * @param kmpPrice
     */
    public void setKmpPrice(BigDecimal kmpPrice) {
        this.kmpPrice = kmpPrice;
    }
    /**
     * 备注
     * @return
     */
    public String getRemake() {
        return remake;
    }
    /**
     * 备注
     * @param remake
     */
    public void setRemake(String remake) {
        this.remake = remake == null ? null : remake.trim();
    }
    /**
     * 是否有效
     * @return
     */
    public String getIsva() {
        return isva;
    }
    /**
     * 是否有效
     * @param isva
     */
    public void setIsva(String isva) {
        this.isva = isva == null ? null : isva.trim();
    }
}