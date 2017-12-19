package com.yidu.model;

public class ErpImg {
    private String imgId;

    private String kinId;

    private String rawId;

    private String imgSerial;

    private String imgUrl;

    private Integer isva;
    /**
     * 图片id
     * @return
     */
    public String getImgId() {
        return imgId;
    }
    /**
     * 图片id
     * @param imgId
     */
    public void setImgId(String imgId) {
        this.imgId = imgId == null ? null : imgId.trim();
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
     * 图片编号
     * @return
     */
    public String getImgSerial() {
        return imgSerial;
    }
    /**
     * 图片编号
     * @param imgSerial
     */
    public void setImgSerial(String imgSerial) {
        this.imgSerial = imgSerial == null ? null : imgSerial.trim();
    }
    /**
     * 图片网址
     * @return
     */
    public String getImgUrl() {
        return imgUrl;
    }
    /**
     * 图片网址
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
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