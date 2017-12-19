package com.yidu.model;
/**
 * 部门类
 * @author 胡鑫
 * @date 2017年10月27日
 */
public class ErpDepa {
    private String depaId;//部门id

    private String depaName;//部门名称

    private String depaSerial;//部门编号

    private String depaPhone;//部门电话

    private String depaRemark;//备注

    private String isva;//是否有效

    private String createtime;//修改时间

    private String creater;//修改人

    public String getDepaId() {
        return depaId;
    }

    public void setDepaId(String depaId) {
        this.depaId = depaId == null ? null : depaId.trim();
    }

    public String getDepaName() {
        return depaName;
    }

    public void setDepaName(String depaName) {
        this.depaName = depaName == null ? null : depaName.trim();
    }

    public String getDepaSerial() {
        return depaSerial;
    }

    public void setDepaSerial(String depaSerial) {
        this.depaSerial = depaSerial == null ? null : depaSerial.trim();
    }

    public String getDepaPhone() {
        return depaPhone;
    }

    public void setDepaPhone(String depaPhone) {
        this.depaPhone = depaPhone == null ? null : depaPhone.trim();
    }

    public String getDepaRemark() {
        return depaRemark;
    }

    public void setDepaRemark(String depaRemark) {
        this.depaRemark = depaRemark == null ? null : depaRemark.trim();
    }

    public String getIsva() {
        return isva;
    }

    public void setIsva(String isva) {
        this.isva = isva == null ? null : isva.trim();
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
}