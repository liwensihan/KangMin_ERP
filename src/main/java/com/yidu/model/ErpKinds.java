package com.yidu.model;

import java.math.BigDecimal;
import java.util.List;
/**
 * 货品表
 * @author Gjwen
 * 2017年11月13日-上午10:38:01
 */
public class ErpKinds {
	private String kinId;

	private String typeId;

    private String kinSerial;

    private String kinBarcode;

    private String kinName;

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

	private BigDecimal kinPrice;

    private BigDecimal kinStost;

    private Integer isva;

    private String createtime;

    private String creater;
    private String resName;
    private String remark;
    
    private ErpKindsType typer;
	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public ErpKindsType getTyper() {
		return typer;
	}

	public void setTyper(ErpKindsType typer) {
		this.typer = typer;
	}

	public String getKinId() {
        return kinId;
    }

    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }

  

    public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getKinSerial() {
        return kinSerial;
    }

    public void setKinSerial(String kinSerial) {
        this.kinSerial = kinSerial == null ? null : kinSerial.trim();
    }

    public String getKinName() {
        return kinName;
    }

    public void setKinName(String kinName) {
        this.kinName = kinName == null ? null : kinName.trim();
    }

  

    public BigDecimal getKinContent() {
		return kinContent;
	}

	public void setKinContent(BigDecimal kinContent) {
		this.kinContent = kinContent;
	}

	public String getKinExpiration() {
        return kinExpiration;
    }

    public void setKinExpiration(String kinExpiration) {
        this.kinExpiration = kinExpiration == null ? null : kinExpiration.trim();
    }

    public BigDecimal getKinPrice() {
        return kinPrice;
    }

    public void setKinPrice(BigDecimal kinPrice) {
        this.kinPrice = kinPrice;
    }

    public BigDecimal getKinStost() {
        return kinStost;
    }

    public void setKinStost(BigDecimal kinStost) {
        this.kinStost = kinStost;
    }

    public Integer getIsva() {
        return isva;
    }

    public void setIsva(Integer isva) {
        this.isva = isva;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
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