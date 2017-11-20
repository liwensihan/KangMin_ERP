package com.yidu.model;

public class ErpImg {
    private String imgId;

    private String kinId;

    private String rawId;

    private String imgSerial;

    private String imgUrl;

    private Integer isva;

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId == null ? null : imgId.trim();
    }

    public String getKinId() {
        return kinId;
    }

    public void setKinId(String kinId) {
        this.kinId = kinId == null ? null : kinId.trim();
    }

    public String getRawId() {
        return rawId;
    }

    public void setRawId(String rawId) {
        this.rawId = rawId == null ? null : rawId.trim();
    }

    public String getImgSerial() {
        return imgSerial;
    }

    public void setImgSerial(String imgSerial) {
        this.imgSerial = imgSerial == null ? null : imgSerial.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Integer getIsva() {
        return isva;
    }

    public void setIsva(Integer isva) {
        this.isva = isva;
    }
}