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
    /**
     * 原材料净含量
     * @return
     */
    public BigDecimal getRawContent() {
		return rawContent;
	}
    /**
     * 净含量
     * @param rawContent
     */
	public void setRawContent(BigDecimal rawContent) {
		this.rawContent = rawContent;
	}
    /**
     * 单位
     * @return
     */
	public String getRawUnit() {
		return rawUnit;
	}
    /**
     * 单位
     * @param rawUnit
     */
	public void setRawUnit(String rawUnit) {
		this.rawUnit = rawUnit;
	}
   
	private ErpApply app;
    
    private List<ErpResuit> res;
    
    private List<ErpImg> img;
    
    private ErpKindsType typer;
    /**
     * 图片集合 
     * @return
     */
    public List<ErpImg> getImg() {
		return img;
	}
    /**
     * 图片集合
     * @param img
     */
	public void setImg(List<ErpImg> img) {
		this.img = img;
	}

	
    /**
     * 供货商
     * @return
     */
    public ErpApply getApp() {
		return app;
	}
    /**
     * 供货商对象
     * @param app
     */
	public void setApp(ErpApply app) {
		this.app = app;
	}
    /**
     * 药效集合
     * @return
     */
	public List<ErpResuit> getRes() {
		return res;
	}
    /**
     * 药效集合
     * @param res
     */
	public void setRes(List<ErpResuit> res) {
		this.res = res;
	}
    /**
     * 药效类型对象
     * @return
     */
	public ErpKindsType getTyper() {
		return typer;
	}
    /**
     * 药效类型对象
     * @param typer
     */
	public void setTyper(ErpKindsType typer) {
		this.typer = typer;
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
        this.rawId = rawId == null ? null : rawId.trim();
    }
    /**
     * 供货商id
     * @return
     */
    public String getApplyId() {
        return applyId;
    }
    /**
     * 供货商id
     * @param applyId
     */
    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }
    /**
     * 原材料编号
     * @return
     */
    public String getRawSerial() {
        return rawSerial;
    }
    /**
     * 原材料编号
     * @param rawSerial
     */
    public void setRawSerial(String rawSerial) {
        this.rawSerial = rawSerial == null ? null : rawSerial.trim();
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
        this.rawName = rawName == null ? null : rawName.trim();
    }

    /**
     * 原材料价格
     * @return
     */
	public BigDecimal getRawPrice() {
		return rawPrice;
	}
    /**
     * 原材料价格
     * @param rawPrice
     */
	public void setRawPrice(BigDecimal rawPrice) {
		this.rawPrice = rawPrice;
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
}