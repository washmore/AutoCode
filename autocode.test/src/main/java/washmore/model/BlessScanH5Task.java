package washmore.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Washmore
 * @version V1
 * @summary H5浏览任务
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public class BlessScanH5Task implements Serializable {
	private static final long serialVersionUID = 5333815391611900267L;
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
	 * 文案内容 默认值:
	 */
	private String content;
	/**
	 * 背景图片链接 默认值:
	 */
	private String imageUrl;
	/**
	 * 开始时间 默认值:CURRENT_TIMESTAMP
	 */
	private Date startTime;
	/**
	 * 结束时间 默认值:CURRENT_TIMESTAMP
	 */
	private Date endTime;
	/**
	 * 生效状态0正常1未生效 默认值:0
	 */
	private Integer validStatus;
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
		return "BlessScanH5Task{" +
				"id=" + id +
				", ruleId=" + ruleId +
				", userCode=" + userCode +
				", userName=\'" + userName + "\'" +
				", content=\'" + content + "\'" +
				", imageUrl=\'" + imageUrl + "\'" +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", validStatus=" + validStatus +
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
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return this.content;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageUrl() {
		return this.imageUrl;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getStartTime() {
		return this.startTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getEndTime() {
		return this.endTime;
	}
	public void setValidStatus(Integer validStatus) {
		this.validStatus = validStatus;
	}
	public Integer getValidStatus() {
		return this.validStatus;
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