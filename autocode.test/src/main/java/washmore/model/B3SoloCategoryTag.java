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
public class B3SoloCategoryTag implements Serializable {
	private static final long serialVersionUID = 8856258568683475277L;
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