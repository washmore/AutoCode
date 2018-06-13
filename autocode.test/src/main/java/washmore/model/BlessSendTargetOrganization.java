package washmore.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Washmore
 * @version V1
 * @summary 群发对象_按组织
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public class BlessSendTargetOrganization implements Serializable {
	private static final long serialVersionUID = 6975548390487953049L;
	/**
	 * 主键 默认值:null
	 */
	private Long id;
	/**
	 * 群发规则id 默认值:0
	 */
	private Long ruleId;
	/**
	 * 性别2全部1男0女 默认值:0
	 */
	private Integer sex;
	/**
	 * 年龄限制0全部1大于2等于3小于 默认值:0
	 */
	private Integer ageCondition;
	/**
	 * 标准年龄值 默认值:0
	 */
	private Integer ageValue;
	/**
	 * 组织id 默认值:0
	 */
	private Long orgId;
	/**
	 * 组织名称 默认值:
	 */
	private String orgName;
	/**
	 * 是否包含离职员工0不包含1包含 默认值:0
	 */
	private Integer includeLeave;
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
		return "BlessSendTargetOrganization{" +
				"id=" + id +
				", ruleId=" + ruleId +
				", sex=" + sex +
				", ageCondition=" + ageCondition +
				", ageValue=" + ageValue +
				", orgId=" + orgId +
				", orgName=\'" + orgName + "\'" +
				", includeLeave=" + includeLeave +
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
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getSex() {
		return this.sex;
	}
	public void setAgeCondition(Integer ageCondition) {
		this.ageCondition = ageCondition;
	}
	public Integer getAgeCondition() {
		return this.ageCondition;
	}
	public void setAgeValue(Integer ageValue) {
		this.ageValue = ageValue;
	}
	public Integer getAgeValue() {
		return this.ageValue;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Long getOrgId() {
		return this.orgId;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgName() {
		return this.orgName;
	}
	public void setIncludeLeave(Integer includeLeave) {
		this.includeLeave = includeLeave;
	}
	public Integer getIncludeLeave() {
		return this.includeLeave;
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