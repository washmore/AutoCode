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
public class B3SoloLink implements Serializable {
	private static final long serialVersionUID = 6723027456959697308L;
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