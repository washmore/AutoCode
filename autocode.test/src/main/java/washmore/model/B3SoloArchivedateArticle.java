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
public class B3SoloArchivedateArticle implements Serializable {
	private static final long serialVersionUID = -351249534838663433L;
	/**
	 *  默认值:null
	 */
	private String oid;
	/**
	 *  默认值:null
	 */
	private String archivedateOid;
	/**
	 *  默认值:null
	 */
	private String articleOid;

	@Override
	public String toString() {
		return "B3SoloArchivedateArticle{" +
				"oid=\'" + oid + "\'" +
				", archivedateOid=\'" + archivedateOid + "\'" +
				", articleOid=\'" + articleOid + "\'" +
			"}";
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOid() {
		return this.oid;
	}
	public void setArchivedateOid(String archivedateOid) {
		this.archivedateOid = archivedateOid;
	}
	public String getArchivedateOid() {
		return this.archivedateOid;
	}
	public void setArticleOid(String articleOid) {
		this.articleOid = articleOid;
	}
	public String getArticleOid() {
		return this.articleOid;
	}
}