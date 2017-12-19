package com.yidu.model;
/**
 * 公告模型
 * @author ouyang
 * @dataTime 2017年12月7日18:16:25
 */
public class ErpNotice {
    private String noticeId;		//公告ID
    private String staId;			//发送人
    private String noticeTitle;		//公告标题
    private String noticeContent;	//公告内容
    private String noticeTime;		//公告时间
    private Integer isva;			//是否有效
    private String oper;			//操作人
    private String optime;			//操作时间
    
    /**
     * 公告ID
     * @return 公告ID
     */
    public String getNoticeId() {
        return noticeId;
    }
    /**
     * 公告ID
     * @param noticeId
     */
    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId == null ? null : noticeId.trim();
    }
    /**
     * 发送人
     * @return
     */
    public String getStaId() {
        return staId;
    }
    /**
     * 发送人
     * @param staId
     */
    public void setStaId(String staId) {
        this.staId = staId == null ? null : staId.trim();
    }
    /**
     * 公告标题
     * @return 公告标题
     */
    public String getNoticeTitle() {
        return noticeTitle;
    }
    /**
     * 公告标题
     * @param noticeTitle
     */
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }
    /**
     * 公告内容
     * @return公告内容
     */
    public String getNoticeContent() {
        return noticeContent;
    }
    /**
     * 公告内容
     * @param noticeContent
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }
    /**
     * 公告时间
     * @return 公告时间
     */
    public String getNoticeTime() {
        return noticeTime;
    }
    /**
     * 公告时间
     * @param noticeTime
     */
    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime == null ? null : noticeTime.trim();
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
     * 操作人
     * @return
     */
    public String getOper() {
        return oper;
    }
    /**
     * 操作人
     * @param oper
     */
    public void setOper(String oper) {
        this.oper = oper == null ? null : oper.trim();
    }
    /**
     * 操作时间
     * @return
     */
    public String getOptime() {
        return optime;
    }
    /**
     * 操作时间
     * @param optime
     */
    public void setOptime(String optime) {
        this.optime = optime == null ? null : optime.trim();
    }
}