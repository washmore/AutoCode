package washmore.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Washmore
 * @version V1
 * @summary 群发条件_固定时间发送
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public class BlessSendRequirementRegular implements Serializable {
	private static final long serialVersionUID = 5412427559778601396L;
	/**
	 * 主键 默认值:null
	 */
	private Long id;
	/**
	 * 群发规则id 默认值:0
	 */
	private Long ruleId;
	/**
	 * 发送时间 默认值:CURRENT_TIMESTAMP
	 */
	private Date sendDate;
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
		return "BlessSendRequirementRegular{" +
				"id=" + id +
				", ruleId=" + ruleId +
				", sendDate=" + sendDate +
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
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public Date getSendDate() {
		return this.sendDate;
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