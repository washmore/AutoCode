package washmore.model;

import java.io.Serializable;
/**
 * @author Washmore
 * @version V1
 * @summary 
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018-06-11
 */
public class B3SoloCategoryTag implements Serializable {
	private static final long serialVersionUID = -206308891398841026L;
	/**
	 *  默认值:null
	 */
	private String oid;
	/**
	 *  默认值:null
	 */
	private String categoryOid;
	/**
	 *  默认值:null
	 */
	private String tagOid;

	@Override
	public String toString() {
		return "B3SoloCategoryTag{" +
				"oid=\'" + oid + "\'" +
				", categoryOid=\'" + categoryOid + "\'" +
				", tagOid=\'" + tagOid + "\'" +
			"}";
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOid() {
		return this.oid;
	}
	public void setCategoryOid(String categoryOid) {
		this.categoryOid = categoryOid;
	}
	public String getCategoryOid() {
		return this.categoryOid;
	}
	public void setTagOid(String tagOid) {
		this.tagOid = tagOid;
	}
	public String getTagOid() {
		return this.tagOid;
	}
}