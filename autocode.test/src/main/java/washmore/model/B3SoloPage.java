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
public class B3SoloPage implements Serializable {
	private static final long serialVersionUID = -2106798057654674111L;
	/**
	 *  默认值:null
	 */
	private String oid;
	/**
	 *  默认值:null
	 */
	private Integer pagecommentcount;
	/**
	 *  默认值:null
	 */
	private java.lang.String pagecontent;
	/**
	 *  默认值:null
	 */
	private Integer pageorder;
	/**
	 *  默认值:null
	 */
	private String pagepermalink;
	/**
	 *  默认值:null
	 */
	private String pagetitle;
	/**
	 *  默认值:null
	 */
	private String pagecommentable;
	/**
	 *  默认值:null
	 */
	private String pagetype;
	/**
	 *  默认值:null
	 */
	private String pageopentarget;
	/**
	 *  默认值:null
	 */
	private String pageeditortype;
	/**
	 *  默认值:null
	 */
	private String pageicon;

	@Override
	public String toString() {
		return "B3SoloPage{" +
				"oid=\'" + oid + "\'" +
				", pagecommentcount=" + pagecommentcount +
				", pagecontent=" + pagecontent +
				", pageorder=" + pageorder +
				", pagepermalink=\'" + pagepermalink + "\'" +
				", pagetitle=\'" + pagetitle + "\'" +
				", pagecommentable=\'" + pagecommentable + "\'" +
				", pagetype=\'" + pagetype + "\'" +
				", pageopentarget=\'" + pageopentarget + "\'" +
				", pageeditortype=\'" + pageeditortype + "\'" +
				", pageicon=\'" + pageicon + "\'" +
			"}";
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOid() {
		return this.oid;
	}
	public void setPagecommentcount(Integer pagecommentcount) {
		this.pagecommentcount = pagecommentcount;
	}
	public Integer getPagecommentcount() {
		return this.pagecommentcount;
	}
	public void setPagecontent(java.lang.String pagecontent) {
		this.pagecontent = pagecontent;
	}
	public java.lang.String getPagecontent() {
		return this.pagecontent;
	}
	public void setPageorder(Integer pageorder) {
		this.pageorder = pageorder;
	}
	public Integer getPageorder() {
		return this.pageorder;
	}
	public void setPagepermalink(String pagepermalink) {
		this.pagepermalink = pagepermalink;
	}
	public String getPagepermalink() {
		return this.pagepermalink;
	}
	public void setPagetitle(String pagetitle) {
		this.pagetitle = pagetitle;
	}
	public String getPagetitle() {
		return this.pagetitle;
	}
	public void setPagecommentable(String pagecommentable) {
		this.pagecommentable = pagecommentable;
	}
	public String getPagecommentable() {
		return this.pagecommentable;
	}
	public void setPagetype(String pagetype) {
		this.pagetype = pagetype;
	}
	public String getPagetype() {
		return this.pagetype;
	}
	public void setPageopentarget(String pageopentarget) {
		this.pageopentarget = pageopentarget;
	}
	public String getPageopentarget() {
		return this.pageopentarget;
	}
	public void setPageeditortype(String pageeditortype) {
		this.pageeditortype = pageeditortype;
	}
	public String getPageeditortype() {
		return this.pageeditortype;
	}
	public void setPageicon(String pageicon) {
		this.pageicon = pageicon;
	}
	public String getPageicon() {
		return this.pageicon;
	}
}