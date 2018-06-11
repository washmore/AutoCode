package washmore.model;

import java.io.Serializable;
/**
 * @author Washmore
 * @version V1
 * @summary 
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018-06-11
 */
public class B3SoloTagArticle implements Serializable {
	private static final long serialVersionUID = 3596393197211817395L;
	/**
	 *  默认值:null
	 */
	private String oid;
	/**
	 *  默认值:null
	 */
	private String articleOid;
	/**
	 *  默认值:null
	 */
	private String tagOid;

	@Override
	public String toString() {
		return "B3SoloTagArticle{" +
				"oid=\'" + oid + "\'" +
				", articleOid=\'" + articleOid + "\'" +
				", tagOid=\'" + tagOid + "\'" +
			"}";
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOid() {
		return this.oid;
	}
	public void setArticleOid(String articleOid) {
		this.articleOid = articleOid;
	}
	public String getArticleOid() {
		return this.articleOid;
	}
	public void setTagOid(String tagOid) {
		this.tagOid = tagOid;
	}
	public String getTagOid() {
		return this.tagOid;
	}
}