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
public class B3SoloUser implements Serializable {
	private static final long serialVersionUID = 388686272787563095L;
	/**
	 *  默认值:null
	 */
	private String oid;
	/**
	 *  默认值:null
	 */
	private String useremail;
	/**
	 *  默认值:null
	 */
	private String username;
	/**
	 *  默认值:null
	 */
	private String userurl;
	/**
	 *  默认值:null
	 */
	private String userpassword;
	/**
	 *  默认值:null
	 */
	private String userrole;
	/**
	 *  默认值:null
	 */
	private Integer userarticlecount;
	/**
	 *  默认值:null
	 */
	private Integer userpublishedarticlecount;
	/**
	 *  默认值:null
	 */
	private String useravatar;

	@Override
	public String toString() {
		return "B3SoloUser{" +
				"oid=\'" + oid + "\'" +
				", useremail=\'" + useremail + "\'" +
				", username=\'" + username + "\'" +
				", userurl=\'" + userurl + "\'" +
				", userpassword=\'" + userpassword + "\'" +
				", userrole=\'" + userrole + "\'" +
				", userarticlecount=" + userarticlecount +
				", userpublishedarticlecount=" + userpublishedarticlecount +
				", useravatar=\'" + useravatar + "\'" +
			"}";
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOid() {
		return this.oid;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUseremail() {
		return this.useremail;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUserurl(String userurl) {
		this.userurl = userurl;
	}
	public String getUserurl() {
		return this.userurl;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUserpassword() {
		return this.userpassword;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	public String getUserrole() {
		return this.userrole;
	}
	public void setUserarticlecount(Integer userarticlecount) {
		this.userarticlecount = userarticlecount;
	}
	public Integer getUserarticlecount() {
		return this.userarticlecount;
	}
	public void setUserpublishedarticlecount(Integer userpublishedarticlecount) {
		this.userpublishedarticlecount = userpublishedarticlecount;
	}
	public Integer getUserpublishedarticlecount() {
		return this.userpublishedarticlecount;
	}
	public void setUseravatar(String useravatar) {
		this.useravatar = useravatar;
	}
	public String getUseravatar() {
		return this.useravatar;
	}
}