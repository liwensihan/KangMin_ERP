package com.yidu.model;

import java.util.List;

/**
 * 仓库表Model
 * @author Gjwen
 * 2017年11月9日-下午1:50:46
 */
public class ErpWarehouse {
    private String wareId;//仓库ID

    private String kinId;//货品ID
    
    private String rawId;//原材料ID

    private Integer wareNum;

    private String createtime;

    private Integer isva;
    private String creater;

    private String remark;
	/**
     * 加的jsp需要用到的属性
     * 相当于vo跟数据库无关联
     */
    private String rawName;//原材料名称
    
    private String rawPrice;//原材料价格
    
    private String kinName;//货品名称
    
    private String kinPrice;//货品价格
    private String kucun;//库存
    private int kucunNum;//库存剩余
    
    
	private List<ErpInvedet> det;
    
    
    /**
     * 库存明细的集合
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
     * 库存
     * @return
     */
	public String getKucun() {
		return kucun;
	}
    /**
     * 库存
     * @param kucun
     */
	public void setKucun(String kucun) {
		this.kucun = kucun;
	}
    /**
     * 库存数量
     * @return
     */
	public int getKucunNum() {
		return kucunNum;
	}
    /**
     * 库存数量
     * @param kucunNum
     */
	public void setKucunNum(int kucunNum) {
		this.kucunNum = kucunNum;
	}
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
     * 原材料价格
     * @return
     */
	public String getRawPrice() {
		return rawPrice;
	}
    /**
     * 原材料价格
     * @param rawPrice
     */
	public void setRawPrice(String rawPrice) {
		this.rawPrice = rawPrice;
	}
    /**
     * 药品名字
     * @return
     */
	public String getKinName() {
		return kinName;
	}
    /**
     * 药品名字
     * @param kinName
     */
	public void setKinName(String kinName) {
		this.kinName = kinName;
	}
    /**
     * 药品价格
     * @return
     */
	public String getKinPrice() {
		return kinPrice;
	}
    /**
     * 药品价格
     * @param kinPrice
     */
	public void setKinPrice(String kinPrice) {
		this.kinPrice = kinPrice;
	}
    /**
     * 原材料id
     * @return
     */
	public String getRawId() {
		return rawId;
	}
    /**
     * 原材料id
     * @param rawId
     */
	public void setRawId(String rawId) {
		this.rawId = rawId;
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
     * 仓库数量
     * @return
     */
    public Integer getWareNum() {
        return wareNum;
    }
    /**
     * 仓库数量
     * @param wareNum
     */
    public void setWareNum(Integer wareNum) {
        this.wareNum = wareNum;
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