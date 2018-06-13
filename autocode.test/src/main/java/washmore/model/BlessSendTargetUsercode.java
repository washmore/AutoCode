package washmore.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Washmore
 * @version V1
 * @summary 群发对象_按工号
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public class BlessSendTargetUsercode implements Serializable {
	private static final long serialVersionUID = -1292765079016134974L;
	/**
	 * 主键 默认值:null
	 */
	private Long id;
	/**
	 * 群发规则id 默认值:0
	 */
	private Long ruleId;
	/**
	 * 组织id 默认值:0
	 */
	private Long orgId;
	/**
	 * 系统号 默认值:0
	 */
	private Long userCode;
	/**
	 * 员工姓名 默认值:
	 */
	private String userName;
	/**
	 * 自定义占位符以及值列表,用三个逗号,,,分割 如  #活动名称#,,,宇宙第一帅比赛,,,#奖品#,,,mac pro一台 默认值:
	 */
	private String replaceParams;
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
		return "BlessSendTargetUsercode{" +
				"id=" + id +
				", ruleId=" + ruleId +
				", orgId=" + orgId +
				", userCode=" + userCode +
				", userName=\'" + userName + "\'" +
				", replaceParams=\'" + replaceParams + "\'" +
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
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Long getOrgId() {
		return this.orgId;
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
	public void setReplaceParams(String replaceParams) {
		this.replaceParams = replaceParams;
	}
	public String getReplaceParams() {
		return this.replaceParams;
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