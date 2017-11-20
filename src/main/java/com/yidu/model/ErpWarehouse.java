package com.yidu.model;
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
    
    
    public String getKucun() {
		return kucun;
	}

	public void setKucun(String kucun) {
		this.kucun = kucun;
	}

	public int getKucunNum() {
		return kucunNum;
	}

	public void setKucunNum(int kucunNum) {
		this.kucunNum = kucunNum;
	}

	public String getRawName() {
		return rawName;
	}

	public void setRawName(String rawName) {
		this.rawName = rawName;
	}

	public String getRawPrice() {
		return rawPrice;
	}

	public void setRawPrice(String rawPrice) {
		this.rawPrice = rawPrice;
	}

	public String getKinName() {
		return kinName;
	}

	public void setKinName(String kinName) {
		this.kinName = kinName;
	}

	public String getKinPrice() {
		return kinPrice;
	}

	public void setKinPrice(String kinPrice) {
		this.kinPrice = kinPrice;
	}

	public String getRawId() {
		return rawId;
	}

	public void setRawId(String rawId) {
		this.rawId = rawId;
	}

	public String getWareId() {
        return wareId;
    }

    public void setWareId(String wareId) {
        this.wareId = wareId == null ? null : wareId.trim();
    }

    public String getKinId() {
        return kinId;
    }

    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }

    public Integer getWareNum() {
        return wareNum;
    }

    public void setWareNum(Integer wareNum) {
        this.wareNum = wareNum;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}