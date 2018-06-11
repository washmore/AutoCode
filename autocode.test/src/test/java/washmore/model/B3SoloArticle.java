package washmore.model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Washmore
 * @version V1
 * @summary 
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018-06-11
 */
public class B3SoloArticle implements Serializable {
	private static final long serialVersionUID = -1549075335489223227L;
	/**
	 *  默认值:null
	 */
	private String oid;
	/**
	 *  默认值:null
	 */
	private String articletitle;
	/**
	 *  默认值:null
	 */
	private String articleabstract;
	/**
	 *  默认值:null
	 */
	private String articletags;
	/**
	 *  默认值:null
	 */
	private String articleauthoremail;
	/**
	 *  默认值:null
	 */
	private Integer articlecommentcount;
	/**
	 *  默认值:null
	 */
	private Integer articleviewcount;
	/**
	 *  默认值:null
	 */
	private String articlecontent;
	/**
	 *  默认值:null
	 */
	private String articlepermalink;
	/**
	 *  默认值:null
	 */
	private String articlehadbeenpublished;
	/**
	 *  默认值:null
	 */
	private String articleispublished;
	/**
	 *  默认值:null
	 */
	private String articleputtop;
	/**
	 *  默认值:null
	 */
	private Date articlecreatedate;
	/**
	 *  默认值:null
	 */
	private Date articleupdatedate;
	/**
	 *  默认值:null
	 */
	private Double articlerandomdouble;
	/**
	 *  默认值:null
	 */
	private String articlesignid;
	/**
	 *  默认值:null
	 */
	private String articlecommentable;
	/**
	 *  默认值:null
	 */
	private String articleviewpwd;
	/**
	 *  默认值:null
	 */
	private String articleeditortype;

	@Override
	public String toString() {
		return "B3SoloArticle{" +
				"oid=\'" + oid + "\'" +
				", articletitle=\'" + articletitle + "\'" +
				", articleabstract=\'" + articleabstract + "\'" +
				", articletags=\'" + articletags + "\'" +
				", articleauthoremail=\'" + articleauthoremail + "\'" +
				", articlecommentcount=" + articlecommentcount +
				", articleviewcount=" + articleviewcount +
				", articlecontent=\'" + articlecontent + "\'" +
				", articlepermalink=\'" + articlepermalink + "\'" +
				", articlehadbeenpublished=\'" + articlehadbeenpublished + "\'" +
				", articleispublished=\'" + articleispublished + "\'" +
				", articleputtop=\'" + articleputtop + "\'" +
				", articlecreatedate=" + articlecreatedate +
				", articleupdatedate=" + articleupdatedate +
				", articlerandomdouble=" + articlerandomdouble +
				", articlesignid=\'" + articlesignid + "\'" +
				", articlecommentable=\'" + articlecommentable + "\'" +
				", articleviewpwd=\'" + articleviewpwd + "\'" +
				", articleeditortype=\'" + articleeditortype + "\'" +
			"}";
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOid() {
		return this.oid;
	}
	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}
	public String getArticletitle() {
		return this.articletitle;
	}
	public void setArticleabstract(String articleabstract) {
		this.articleabstract = articleabstract;
	}
	public String getArticleabstract() {
		return this.articleabstract;
	}
	public void setArticletags(String articletags) {
		this.articletags = articletags;
	}
	public String getArticletags() {
		return this.articletags;
	}
	public void setArticleauthoremail(String articleauthoremail) {
		this.articleauthoremail = articleauthoremail;
	}
	public String getArticleauthoremail() {
		return this.articleauthoremail;
	}
	public void setArticlecommentcount(Integer articlecommentcount) {
		this.articlecommentcount = articlecommentcount;
	}
	public Integer getArticlecommentcount() {
		return this.articlecommentcount;
	}
	public void setArticleviewcount(Integer articleviewcount) {
		this.articleviewcount = articleviewcount;
	}
	public Integer getArticleviewcount() {
		return this.articleviewcount;
	}
	public void setArticlecontent(String articlecontent) {
		this.articlecontent = articlecontent;
	}
	public String getArticlecontent() {
		return this.articlecontent;
	}
	public void setArticlepermalink(String articlepermalink) {
		this.articlepermalink = articlepermalink;
	}
	public String getArticlepermalink() {
		return this.articlepermalink;
	}
	public void setArticlehadbeenpublished(String articlehadbeenpublished) {
		this.articlehadbeenpublished = articlehadbeenpublished;
	}
	public String getArticlehadbeenpublished() {
		return this.articlehadbeenpublished;
	}
	public void setArticleispublished(String articleispublished) {
		this.articleispublished = articleispublished;
	}
	public String getArticleispublished() {
		return this.articleispublished;
	}
	public void setArticleputtop(String articleputtop) {
		this.articleputtop = articleputtop;
	}
	public String getArticleputtop() {
		return this.articleputtop;
	}
	public void setArticlecreatedate(Date articlecreatedate) {
		this.articlecreatedate = articlecreatedate;
	}
	public Date getArticlecreatedate() {
		return this.articlecreatedate;
	}
	public void setArticleupdatedate(Date articleupdatedate) {
		this.articleupdatedate = articleupdatedate;
	}
	public Date getArticleupdatedate() {
		return this.articleupdatedate;
	}
	public void setArticlerandomdouble(Double articlerandomdouble) {
		this.articlerandomdouble = articlerandomdouble;
	}
	public Double getArticlerandomdouble() {
		return this.articlerandomdouble;
	}
	public void setArticlesignid(String articlesignid) {
		this.articlesignid = articlesignid;
	}
	public String getArticlesignid() {
		return this.articlesignid;
	}
	public void setArticlecommentable(String articlecommentable) {
		this.articlecommentable = articlecommentable;
	}
	public String getArticlecommentable() {
		return this.articlecommentable;
	}
	public void setArticleviewpwd(String articleviewpwd) {
		this.articleviewpwd = articleviewpwd;
	}
	public String getArticleviewpwd() {
		return this.articleviewpwd;
	}
	public void setArticleeditortype(String articleeditortype) {
		this.articleeditortype = articleeditortype;
	}
	public String getArticleeditortype() {
		return this.articleeditortype;
	}
}