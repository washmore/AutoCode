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
public class B3SoloCategory implements Serializable {
	private static final long serialVersionUID = -1733798978704140589L;
	/**
	 *  默认值:null
	 */
	private String oid;
	/**
	 *  默认值:null
	 */
	private String categorytitle;
	/**
	 *  默认值:null
	 */
	private String categoryuri;
	/**
	 *  默认值:null
	 */
	private String categorydescription;
	/**
	 *  默认值:null
	 */
	private Integer categoryorder;
	/**
	 *  默认值:null
	 */
	private Integer categorytagcnt;

	@Override
	public String toString() {
		return "B3SoloCategory{" +
				"oid=\'" + oid + "\'" +
				", categorytitle=\'" + categorytitle + "\'" +
				", categoryuri=\'" + categoryuri + "\'" +
				", categorydescription=\'" + categorydescription + "\'" +
				", categoryorder=" + categoryorder +
				", categorytagcnt=" + categorytagcnt +
			"}";
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOid() {
		return this.oid;
	}
	public void setCategorytitle(String categorytitle) {
		this.categorytitle = categorytitle;
	}
	public String getCategorytitle() {
		return this.categorytitle;
	}
	public void setCategoryuri(String categoryuri) {
		this.categoryuri = categoryuri;
	}
	public String getCategoryuri() {
		return this.categoryuri;
	}
	public void setCategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}
	public String getCategorydescription() {
		return this.categorydescription;
	}
	public void setCategoryorder(Integer categoryorder) {
		this.categoryorder = categoryorder;
	}
	public Integer getCategoryorder() {
		return this.categoryorder;
	}
	public void setCategorytagcnt(Integer categorytagcnt) {
		this.categorytagcnt = categorytagcnt;
	}
	public Integer getCategorytagcnt() {
		return this.categorytagcnt;
	}
}