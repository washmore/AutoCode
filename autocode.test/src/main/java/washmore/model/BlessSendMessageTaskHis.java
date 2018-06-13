package washmore.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Washmore
 * @version V1
 * @summary 文案发送任务历史表
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public class BlessSendMessageTaskHis implements Serializable {
	private static final long serialVersionUID = 2763410434331207643L;
	/**
	 * 主键 默认值:null
	 */
	private Long id;
	/**
	 * 群发规则id 默认值:0
	 */
	private Long ruleId;
	/**
	 * 系统号 默认值:0
	 */
	private Long userCode;
	/**
	 * 员工姓名 默认值:
	 */
	private String userName;
	/**
	 * 发送手机号码(加密) 默认值:
	 */
	private String phone;
	/**
	 * 最终呈现给用户的短信文本内容 默认值:
	 */
	private String message;
	/**
	 * 发送时间 默认值:CURRENT_TIMESTAMP
	 */
	private Date sendTime;
	/**
	 * 投送状态0待发送1已发送2发送成功3发送失败 默认值:0
	 */
	private Integer sendStatus;
	/**
	 * 用于去短信中心查询本条短信送达状况的服务码 默认值:
	 */
	private String requestId;
	/**
	 * 创建人系统号 默认值:0
	 */
	private Long creator;
	/**
	 * 创建人姓名 默认值:
	 */
	private String creatorName;
	/**
	 * 创建时间 默认值:CURRENT_TIMESTAMP
	 */
	private Date createTime;
	/**
	 * 最后更新人系统号 默认值:0
	 */
	private Long updater;
	/**
	 * 最后更新人姓名 默认值:
	 */
	private String updaterName;
	/**
	 * 最后更新时间 默认值:CURRENT_TIMESTAMP
	 */
	private Date updateTime;

	@Override
	public String toString() {
		return "BlessSendMessageTaskHis{" +
				"id=" + id +
				", ruleId=" + ruleId +
				", userCode=" + userCode +
				", userName=\'" + userName + "\'" +
				", phone=\'" + phone + "\'" +
				", message=\'" + message + "\'" +
				", sendTime=" + sendTime +
				", sendStatus=" + sendStatus +
				", requestId=\'" + requestId + "\'" +
				", creator=" + creator +
				", creatorName=\'" + creatorName + "\'" +
				", createTime=" + createTime +
				", updater=" + updater +
				", updaterName=\'" + updaterName + "\'" +
				", updateTime=" + updateTime +
			"}";
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return this.id;
	}
	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}
	public Long getRuleId() {
		return this.ruleId;
	}
	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}
	public Long getUserCode() {
		return this.userCode;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getSendTime() {
		return this.sendTime;
	}
	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
	}
	public Integer getSendStatus() {
		return this.sendStatus;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getRequestId() {
		return this.requestId;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	public Long getCreator() {
		return this.creator;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getCreatorName() {
		return this.creatorName;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdater(Long updater) {
		this.updater = updater;
	}
	public Long getUpdater() {
		return this.updater;
	}
	public void setUpdaterName(String updaterName) {
		this.updaterName = updaterName;
	}
	public String getUpdaterName() {
		return this.updaterName;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getUpdateTime() {
		return this.updateTime;
	}
}