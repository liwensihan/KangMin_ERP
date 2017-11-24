package com.yidu.model;

import java.math.BigDecimal;
import java.util.List;
/**
 * 原材料表
 * @author Gjwen
 * 2017年11月13日-上午10:38:32
 */
public class ErpRaw {
    private String rawId;

    private String applyId;

    private String rawSerial;

    private String rawName;

    private BigDecimal rawPrice;

    private String creater;

    private String createtime;
    
    private Integer isva;
    
    private BigDecimal rawContent;

    private String rawUnit;
    
    public BigDecimal getRawContent() {
		return rawContent;
	}

	public void setRawContent(BigDecimal rawContent) {
		this.rawContent = rawContent;
	}

	public String getRawUnit() {
		return rawUnit;
	}

	public void setRawUnit(String rawUnit) {
		this.rawUnit = rawUnit;
	}

	private ErpApply app;
    
    private List<ErpResuit> res;
    
    private List<ErpImg> img;
    
    private ErpKindsType typer;
    
    public List<ErpImg> getImg() {
		return img;
	}

	public void setImg(List<ErpImg> img) {
		this.img = img;
	}

	
    
    public ErpApply getApp() {
		return app;
	}

	public void setApp(ErpApply app) {
		this.app = app;
	}

	public List<ErpResuit> getRes() {
		return res;
	}

	public void setRes(List<ErpResuit> res) {
		this.res = res;
	}

	public ErpKindsType getTyper() {
		return typer;
	}

	public void setTyper(ErpKindsType typer) {
		this.typer = typer;
	}

	public String getRawId() {
        return rawId;
    }

    public void setRawId(String rawId) {
        this.rawId = rawId == null ? null : rawId.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getRawSerial() {
        return rawSerial;
    }

    public void setRawSerial(String rawSerial) {
        this.rawSerial = rawSerial == null ? null : rawSerial.trim();
    }

    public String getRawName() {
        return rawName;
    }

    public void setRawName(String rawName) {
        this.rawName = rawName == null ? null : rawName.trim();
    }

   
	public BigDecimal getRawPrice() {
		return rawPrice;
	}

	public void setRawPrice(BigDecimal rawPrice) {
		this.rawPrice = rawPrice;
	}

	public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
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
}