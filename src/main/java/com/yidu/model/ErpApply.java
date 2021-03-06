package com.yidu.model;
/**
 * 供货商Model
 * @author Gjwen
 * 2017年10月30日-下午2:49:01
 */
public class ErpApply {
    private String applyId;

    private String applyNumber;

    private String applyName;

    private String applyBoss;

    private String applyAdr;

    private String applyPhone;

    private String applyEmail;

    private Short applyIsvo;

    private Integer isva;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getApplyNumber() {
        return applyNumber;
    }

    public void setApplyNumber(String applyNumber) {
        this.applyNumber = applyNumber == null ? null : applyNumber.trim();
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName == null ? null : applyName.trim();
    }

    public String getApplyBoss() {
        return applyBoss;
    }

    public void setApplyBoss(String applyBoss) {
        this.applyBoss = applyBoss == null ? null : applyBoss.trim();
    }

    public String getApplyAdr() {
        return applyAdr;
    }

    public void setApplyAdr(String applyAdr) {
        this.applyAdr = applyAdr == null ? null : applyAdr.trim();
    }

    public String getApplyPhone() {
        return applyPhone;
    }

    public void setApplyPhone(String applyPhone) {
        this.applyPhone = applyPhone == null ? null : applyPhone.trim();
    }

    public String getApplyEmail() {
        return applyEmail;
    }

    public void setApplyEmail(String applyEmail) {
        this.applyEmail = applyEmail == null ? null : applyEmail.trim();
    }

    public Short getApplyIsvo() {
        return applyIsvo;
    }

    public void setApplyIsvo(Short applyIsvo) {
        this.applyIsvo = applyIsvo;
    }

    public Integer getIsva() {
        return isva;
    }

    public void setIsva(Integer isva) {
        this.isva = isva;
    }
}