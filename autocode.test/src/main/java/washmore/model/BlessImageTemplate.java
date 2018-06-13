package washmore.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Washmore
 * @version V1
 * @summary 图片模板
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public class BlessImageTemplate implements Serializable {
	private static final long serialVersionUID = -5652678033892850082L;
	/**
	 * 自增主键 默认值:null
	 */
	private Long id;
	/**
	 * 素材名称 默认值:
	 */
	private String name;
	/**
	 * 图片素材文件名 默认值:
	 */
	private String fileName;
	/**
	 * 分组id 默认值:0
	 */
	private Long groupId;
	/**
	 * 素材组织类型0集团1分公司 默认值:0
	 */
	private Integer orgType;
	/**
	 * 组织id 默认值:1
	 */
	private Long orgId;
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
		return "BlessImageTemplate{" +
				"id=" + id +
				", name=\'" + name + "\'" +
				", fileName=\'" + fileName + "\'" +
				", groupId=" + groupId +
				", orgType=" + orgType +
				", orgId=" + orgId +
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
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileName() {
		return this.fileName;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getGroupId() {
		return this.groupId;
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