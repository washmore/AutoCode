package washmore.model;

import java.io.Serializable;
/**
 * @author Washmore
 * @version V1
 * @summary 
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018-06-11
 */
public class B3SoloArchivedateArticle implements Serializable {
	private static final long serialVersionUID = 6514599603344568002L;
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