package washmore.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Washmore
 * @version V1
 * @summary 个人配置信息
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月13日
 */
public class BlessExtUserinfo implements Serializable {
	private static final long serialVersionUID = -8471416013434386875L;
	/**
	 * 自增主键 默认值:null
	 */
	private Long id;
	/**
	 * 系统号 默认值:0
	 */
	private Long userCode;
	/**
	 * 所在部门id 默认值:1
	 */
	private Long orgId;
	/**
	 * 所在组织(公司)id 默认值:1
	 */
	private Long companyId;
	/**
	 * 生日历法-1未选择0公历1农历 默认值:-1
	 */
	private Integer birthdayCalender;
	/**
	 * 生日 默认值:CURRENT_TIMESTAMP
	 */
	private Date birthday;
	/**
	 * 婚姻状况0未婚1已婚 默认值:0
	 */
	private Integer married;
	/**
	 * 结婚纪念日历法-1未选择0公历1农历 默认值:-1
	 */
	private Integer weddingDayCalender;
	/**
	 * 结婚纪念日 默认值:CURRENT_TIMESTAMP
	 */
	private Date weddingDay;
	/**
	 * 配偶是否链家人0不是1是 默认值:0
	 */
	private Integer spouseIsLianer;
	/**
	 * 配偶系统号 默认值:0
	 */
	private Long spouseUserCode;
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
		return "BlessExtUserinfo{" +
				"id=" + id +
				", userCode=" + userCode +
				", orgId=" + orgId +
				", companyId=" + companyId +
				", birthdayCalender=" + birthdayCalender +
				", birthday=" + birthday +
				", married=" + married +
				", weddingDayCalender=" + weddingDayCalender +
				", weddingDay=" + weddingDay +
				", spouseIsLianer=" + spouseIsLianer +
				", spouseUserCode=" + spouseUserCode +
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
	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}
	public Long getUserCode() {
		return this.userCode;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Long getOrgId() {
		return this.orgId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getCompanyId() {
		return this.companyId;
	}
	public void setBirthdayCalender(Integer birthdayCalender) {
		this.birthdayCalender = birthdayCalender;
	}
	public Integer getBirthdayCalender() {
		return this.birthdayCalender;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getBirthday() {
		return this.birthday;
	}
	public void setMarried(Integer married) {
		this.married = married;
	}
	public Integer getMarried() {
		return this.married;
	}
	public void setWeddingDayCalender(Integer weddingDayCalender) {
		this.weddingDayCalender = weddingDayCalender;
	}
	public Integer getWeddingDayCalender() {
		return this.weddingDayCalender;
	}
	public void setWeddingDay(Date weddingDay) {
		this.weddingDay = weddingDay;
	}
	public Date getWeddingDay() {
		return this.weddingDay;
	}
	public void setSpouseIsLianer(Integer spouseIsLianer) {
		this.spouseIsLianer = spouseIsLianer;
	}
	public Integer getSpouseIsLianer() {
		return this.spouseIsLianer;
	}
	public void setSpouseUserCode(Long spouseUserCode) {
		this.spouseUserCode = spouseUserCode;
	}
	public Long getSpouseUserCode() {
		return this.spouseUserCode;
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