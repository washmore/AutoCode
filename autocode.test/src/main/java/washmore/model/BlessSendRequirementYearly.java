package washmore.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Washmore
 * @version V1
 * @summary 群发条件_年度事件发送
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public class BlessSendRequirementYearly implements Serializable {
	private static final long serialVersionUID = -5761388436479646813L;
	/**
	 * 主键 默认值:null
	 */
	private Long id;
	/**
	 * 群发规则id 默认值:0
	 */
	private Long ruleId;
	/**
	 * 事件类型0生日1入司纪念日2结婚纪念日 默认值:1
	 */
	private Integer eventType;
	/**
	 * 最小工龄 默认值:0
	 */
	private Integer seniorityMin;
	/**
	 * 最大工龄 默认值:9999
	 */
	private Integer seniorityMax;
	/**
	 * 发送时间-小时 默认值:0
	 */
	private Integer sendHour;
	/**
	 * 发送时间-分钟 默认值:0
	 */
	private Integer sendMinute;
	/**
	 * 0正常1已删除 默认值:0
	 */
	private Integer flagDelete;
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
		return "BlessSendRequirementYearly{" +
				"id=" + id +
				", ruleId=" + ruleId +
				", eventType=" + eventType +
				", seniorityMin=" + seniorityMin +
				", seniorityMax=" + seniorityMax +
				", sendHour=" + sendHour +
				", sendMinute=" + sendMinute +
				", flagDelete=" + flagDelete +
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
	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}
	public Integer getEventType() {
		return this.eventType;
	}
	public void setSeniorityMin(Integer seniorityMin) {
		this.seniorityMin = seniorityMin;
	}
	public Integer getSeniorityMin() {
		return this.seniorityMin;
	}
	public void setSeniorityMax(Integer seniorityMax) {
		this.seniorityMax = seniorityMax;
	}
	public Integer getSeniorityMax() {
		return this.seniorityMax;
	}
	public void setSendHour(Integer sendHour) {
		this.sendHour = sendHour;
	}
	public Integer getSendHour() {
		return this.sendHour;
	}
	public void setSendMinute(Integer sendMinute) {
		this.sendMinute = sendMinute;
	}
	public Integer getSendMinute() {
		return this.sendMinute;
	}
	public void setFlagDelete(Integer flagDelete) {
		this.flagDelete = flagDelete;
	}
	public Integer getFlagDelete() {
		return this.flagDelete;
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