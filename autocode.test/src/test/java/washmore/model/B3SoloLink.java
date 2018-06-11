package washmore.model;

import java.io.Serializable;
/**
 * @author Washmore
 * @version V1
 * @summary 
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018-06-11
 */
public class B3SoloLink implements Serializable {
	private static final long serialVersionUID = 3200775306748808781L;
	/**
	 *  默认值:null
	 */
	private String oid;
	/**
	 *  默认值:null
	 */
	private String linkaddress;
	/**
	 *  默认值:null
	 */
	private String linkdescription;
	/**
	 *  默认值:null
	 */
	private Integer linkorder;
	/**
	 *  默认值:null
	 */
	private String linktitle;

	@Override
	public String toString() {
		return "B3SoloLink{" +
				"oid=\'" + oid + "\'" +
				", linkaddress=\'" + linkaddress + "\'" +
				", linkdescription=\'" + linkdescription + "\'" +
				", linkorder=" + linkorder +
				", linktitle=\'" + linktitle + "\'" +
			"}";
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOid() {
		return this.oid;
	}
	public void setLinkaddress(String linkaddress) {
		this.linkaddress = linkaddress;
	}
	public String getLinkaddress() {
		return this.linkaddress;
	}
	public void setLinkdescription(String linkdescription) {
		this.linkdescription = linkdescription;
	}
	public String getLinkdescription() {
		return this.linkdescription;
	}
	public void setLinkorder(Integer linkorder) {
		this.linkorder = linkorder;
	}
	public Integer getLinkorder() {
		return this.linkorder;
	}
	public void setLinktitle(String linktitle) {
		this.linktitle = linktitle;
	}
	public String getLinktitle() {
		return this.linktitle;
	}
}