package washmore.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Washmore
 * @version V1
 * @summary Link主题包
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public class BlessLinkTheme implements Serializable {
	private static final long serialVersionUID = -7253278881207494395L;
	/**
	 * 自增主键 默认值:null
	 */
	private Long id;
	/**
	 * 主题名称 默认值:
	 */
	private String name;
	/**
	 * 安卓资源包地址 默认值:
	 */
	private String resourceUrlAndroid;
	/**
	 * IOS资源包地址 默认值:
	 */
	private String resourceUrlIos;
	/**
	 * 扩展字段json 默认值:
	 */
	private String config;
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
	/**
	 * 0有效1未生效 默认值:0
	 */
	private Integer validStatus;
	/**
	 * 0正常1已删除 默认值:0
	 */
	private Integer flagDelete;

	@Override
	public String toString() {
		return "BlessLinkTheme{" +
				"id=" + id +
				", name=\'" + name + "\'" +
				", resourceUrlAndroid=\'" + resourceUrlAndroid + "\'" +
				", resourceUrlIos=\'" + resourceUrlIos + "\'" +
				", config=\'" + config + "\'" +
				", creator=" + creator +
				", creatorName=\'" + creatorName + "\'" +
				", createTime=" + createTime +
				", updater=" + updater +
				", updaterName=\'" + updaterName + "\'" +
				", updateTime=" + updateTime +
				", validStatus=" + validStatus +
				", flagDelete=" + flagDelete +
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
	public void setResourceUrlAndroid(String resourceUrlAndroid) {
		this.resourceUrlAndroid = resourceUrlAndroid;
	}
	public String getResourceUrlAndroid() {
		return this.resourceUrlAndroid;
	}
	public void setResourceUrlIos(String resourceUrlIos) {
		this.resourceUrlIos = resourceUrlIos;
	}
	public String getResourceUrlIos() {
		return this.resourceUrlIos;
	}
	public void setConfig(String config) {
		this.config = config;
	}
	public String getConfig() {
		return this.config;
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
}