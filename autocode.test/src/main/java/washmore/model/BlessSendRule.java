package washmore.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Washmore
 * @version V1
 * @summary 群发规则
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public class BlessSendRule implements Serializable {
	private static final long serialVersionUID = -1742508402054513532L;
	/**
	 * 主键 默认值:null
	 */
	private Long id;
	/**
	 * 群发规则名称 默认值:
	 */
	private String name;
	/**
	 * 组织类型0集团1公司 默认值:0
	 */
	private Integer orgType;
	/**
	 * 组织Id 默认值:1
	 */
	private Long orgId;
	/**
	 * 1文案模板 默认值:1
	 */
	private Integer templateType;
	/**
	 * 被引用的模板id 默认值:0
	 */
	private Long templateId;
	/**
	 * 主题包id 默认值:0
	 */
	private Long linkThemeId;
	/**
	 * 是否抄送上级0抄送1不抄送 默认值:0
	 */
	private Integer ccSuperior;
	/**
	 * 如果选择抄送上级的话,此处选择发送给上级的模板 默认值:0
	 */
	private Long ccTemplateId;
	/**
	 * 群发对象1按组织架构2按工号 默认值:1
	 */
	private Integer sendTargetType;
	/**
	 * 群发条件1年度事件触发2固定时间发送 默认值:1
	 */
	private Integer sendRequirementType;
	/**
	 * 0正常1未生效 默认值:0
	 */
	private Integer validStatus;
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
		return "BlessSendRule{" +
				"id=" + id +
				", name=\'" + name + "\'" +
				", orgType=" + orgType +
				", orgId=" + orgId +
				", templateType=" + templateType +
				", templateId=" + templateId +
				", linkThemeId=" + linkThemeId +
				", ccSuperior=" + ccSuperior +
				", ccTemplateId=" + ccTemplateId +
				", sendTargetType=" + sendTargetType +
				", sendRequirementType=" + sendRequirementType +
				", validStatus=" + validStatus +
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
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}
	public Integer getOrgType() {
		return this.orgType;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Long getOrgId() {
		return this.orgId;
	}
	public void setTemplateType(Integer templateType) {
		this.templateType = templateType;
	}
	public Integer getTemplateType() {
		return this.templateType;
	}
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
	public Long getTemplateId() {
		return this.templateId;
	}
	public void setLinkThemeId(Long linkThemeId) {
		this.linkThemeId = linkThemeId;
	}
	public Long getLinkThemeId() {
		return this.linkThemeId;
	}
	public void setCcSuperior(Integer ccSuperior) {
		this.ccSuperior = ccSuperior;
	}
	public Integer getCcSuperior() {
		return this.ccSuperior;
	}
	public void setCcTemplateId(Long ccTemplateId) {
		this.ccTemplateId = ccTemplateId;
	}
	public Long getCcTemplateId() {
		return this.ccTemplateId;
	}
	public void setSendTargetType(Integer sendTargetType) {
		this.sendTargetType = sendTargetType;
	}
	public Integer getSendTargetType() {
		return this.sendTargetType;
	}
	public void setSendRequirementType(Integer sendRequirementType) {
		this.sendRequirementType = sendRequirementType;
	}
	public Integer getSendRequirementType() {
		return this.sendRequirementType;
	}
	public void setValidStatus(Integer validStatus) {
		this.validStatus = validStatus;
	}
	public Integer getValidStatus() {
		return this.validStatus;
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