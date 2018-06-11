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
public class B3SoloComment implements Serializable {
	private static final long serialVersionUID = -2892933982739174520L;
	/**
	 *  默认值:null
	 */
	private String oid;
	/**
	 *  默认值:null
	 */
	private String commentcontent;
	/**
	 *  默认值:null
	 */
	private Date commentdate;
	/**
	 *  默认值:null
	 */
	private String commentemail;
	/**
	 *  默认值:null
	 */
	private String commentname;
	/**
	 *  默认值:null
	 */
	private String commentonid;
	/**
	 *  默认值:null
	 */
	private String commentontype;
	/**
	 *  默认值:null
	 */
	private String commentsharpurl;
	/**
	 *  默认值:null
	 */
	private String commentthumbnailurl;
	/**
	 *  默认值:null
	 */
	private String commenturl;
	/**
	 *  默认值:null
	 */
	private String commentoriginalcommentid;
	/**
	 *  默认值:null
	 */
	private String commentoriginalcommentname;

	@Override
	public String toString() {
		return "B3SoloComment{" +
				"oid=\'" + oid + "\'" +
				", commentcontent=\'" + commentcontent + "\'" +
				", commentdate=" + commentdate +
				", commentemail=\'" + commentemail + "\'" +
				", commentname=\'" + commentname + "\'" +
				", commentonid=\'" + commentonid + "\'" +
				", commentontype=\'" + commentontype + "\'" +
				", commentsharpurl=\'" + commentsharpurl + "\'" +
				", commentthumbnailurl=\'" + commentthumbnailurl + "\'" +
				", commenturl=\'" + commenturl + "\'" +
				", commentoriginalcommentid=\'" + commentoriginalcommentid + "\'" +
				", commentoriginalcommentname=\'" + commentoriginalcommentname + "\'" +
			"}";
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOid() {
		return this.oid;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public String getCommentcontent() {
		return this.commentcontent;
	}
	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}
	public Date getCommentdate() {
		return this.commentdate;
	}
	public void setCommentemail(String commentemail) {
		this.commentemail = commentemail;
	}
	public String getCommentemail() {
		return this.commentemail;
	}
	public void setCommentname(String commentname) {
		this.commentname = commentname;
	}
	public String getCommentname() {
		return this.commentname;
	}
	public void setCommentonid(String commentonid) {
		this.commentonid = commentonid;
	}
	public String getCommentonid() {
		return this.commentonid;
	}
	public void setCommentontype(String commentontype) {
		this.commentontype = commentontype;
	}
	public String getCommentontype() {
		return this.commentontype;
	}
	public void setCommentsharpurl(String commentsharpurl) {
		this.commentsharpurl = commentsharpurl;
	}
	public String getCommentsharpurl() {
		return this.commentsharpurl;
	}
	public void setCommentthumbnailurl(String commentthumbnailurl) {
		this.commentthumbnailurl = commentthumbnailurl;
	}
	public String getCommentthumbnailurl() {
		return this.commentthumbnailurl;
	}
	public void setCommenturl(String commenturl) {
		this.commenturl = commenturl;
	}
	public String getCommenturl() {
		return this.commenturl;
	}
	public void setCommentoriginalcommentid(String commentoriginalcommentid) {
		this.commentoriginalcommentid = commentoriginalcommentid;
	}
	public String getCommentoriginalcommentid() {
		return this.commentoriginalcommentid;
	}
	public void setCommentoriginalcommentname(String commentoriginalcommentname) {
		this.commentoriginalcommentname = commentoriginalcommentname;
	}
	public String getCommentoriginalcommentname() {
		return this.commentoriginalcommentname;
	}
}