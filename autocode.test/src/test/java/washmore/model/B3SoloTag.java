package washmore.model;

import java.io.Serializable;
/**
 * @author Washmore
 * @version V1
 * @summary 
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018-06-11
 */
public class B3SoloTag implements Serializable {
	private static final long serialVersionUID = -3668071743500178908L;
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