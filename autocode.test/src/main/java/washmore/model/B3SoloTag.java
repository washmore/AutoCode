package washmore.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Washmore
 * @version V1
 * @summary 
 * @Copyright (c) 2018, Washmore All Rights Reserved.
 * @since 2018年06月12日
 */
public class B3SoloTag implements Serializable {
	private static final long serialVersionUID = 3989755487720563281L;
	/**
	 *  默认值:null
	 */
	private String oid;
	/**
	 *  默认值:null
	 */
	private Integer tagpublishedrefcount;
	/**
	 *  默认值:null
	 */
	private Integer tagreferencecount;
	/**
	 *  默认值:null
	 */
	private String tagtitle;

	@Override
	public String toString() {
		return "B3SoloTag{" +
				"oid=\'" + oid + "\'" +
				", tagpublishedrefcount=" + tagpublishedrefcount +
				", tagreferencecount=" + tagreferencecount +
				", tagtitle=\'" + tagtitle + "\'" +
			"}";
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOid() {
		return this.oid;
	}
	public void setTagpublishedrefcount(Integer tagpublishedrefcount) {
		this.tagpublishedrefcount = tagpublishedrefcount;
	}
	public Integer getTagpublishedrefcount() {
		return this.tagpublishedrefcount;
	}
	public void setTagreferencecount(Integer tagreferencecount) {
		this.tagreferencecount = tagreferencecount;
	}
	public Integer getTagreferencecount() {
		return this.tagreferencecount;
	}
	public void setTagtitle(String tagtitle) {
		this.tagtitle = tagtitle;
	}
	public String getTagtitle() {
		return this.tagtitle;
	}
}