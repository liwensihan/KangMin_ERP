package com.yidu.model;

import java.math.BigDecimal;
/**
 * 货品表
 * @author Gjwen
 * 2017年11月13日-上午10:38:01
 */
public class ErpKinds {
	private String kinId; //商品id

	private String typeId;//药品类型id

    private String kinSerial;//药品类型边海

    private String kinBarcode;//药品单位

    private String kinName;//药品名

    private BigDecimal kinContent;

    private String kinExpiration;
    private BigDecimal kinSellinf;
    private String bure;
    
    public String getBure() {
		return bure;
	}

	public void setBure(String bure) {
		this.bure = bure;
	}

	public BigDecimal getKinSellinf() {
		return kinSellinf;
	}

	public void setKinSellinf(BigDecimal kinSellinf) {
		this.kinSellinf = kinSellinf;
	}

	public String getKinBarcode() {
		return kinBarcode;
	}

	public void setKinBarcode(String kinBarcode) {
		this.kinBarcode = kinBarcode;
	}

	private BigDecimal kinPrice;//药品出售价格

    private BigDecimal kinStost;//药品出售价

    private Integer isva;//是否有效

    private String createtime;//创建时间

    private String creater;//创建人
    private String resName;//药品名字
    private String remark;//备注
    
    private ErpKindsType typer; //药品类型
    /**
     * 药效名字
     * @return 药效名字
     */
	public String getResName() {
		return resName;
	}
    /**
     * 药效名字
     * @param resName
     */
	public void setResName(String resName) {
		this.resName = resName;
	}
    /**
     * 药效类型的类
     * @return
     */
	public ErpKindsType getTyper() {
		return typer;
	}
    /**
     * 药效类型的类
     * @param typer
     */
	public void setTyper(ErpKindsType typer) {
		this.typer = typer;
	}
    /**
     * 药品id
     * @return
     */
	public String getKinId() {
        return kinId;
    }
    /**
     * 药品类型id
     * @param kinId
     */
    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }

  
    /**
     * 药品类型id
     * @return
     */
    public String getTypeId() {
		return typeId;
	}
    /**
     * 药品类型
     * @param typeId
     */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
    /**
     * 药品编号
     * @return
     */
	public String getKinSerial() {
        return kinSerial;
    }
    /**
     * 药品编号
     * @param kinSerial
     */
    public void setKinSerial(String kinSerial) {
        this.kinSerial = kinSerial == null ? null : kinSerial.trim();
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
        this.kinName = kinName == null ? null : kinName.trim();
    }

  
    /**
     * 药品净含量
     * @return
     */
    public BigDecimal getKinContent() {
		return kinContent;
	}
    /**
     * 药品净含量
     * @param kinContent
     */
	public void setKinContent(BigDecimal kinContent) {
		this.kinContent = kinContent;
	}
   
	public String getKinExpiration() {
        return kinExpiration;
    }

    public void setKinExpiration(String kinExpiration) {
        this.kinExpiration = kinExpiration == null ? null : kinExpiration.trim();
    }
/**
 * 药品原价
 * @return
 */
    public BigDecimal getKinPrice() {
        return kinPrice;
    }
    /**
     * 药品原价
     * @param kinPrice
     */
    public void setKinPrice(BigDecimal kinPrice) {
        this.kinPrice = kinPrice;
    }
    /**
     * 药品出售价
     * @return
     */
    public BigDecimal getKinStost() {
        return kinStost;
    }
    /**
     * 药品出售价
     * @param kinStost
     */
    public void setKinStost(BigDecimal kinStost) {
        this.kinStost = kinStost;
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