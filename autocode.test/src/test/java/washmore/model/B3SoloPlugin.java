package washmore.model;

import java.io.Serializable;
/**
 * @author Washmore
 * @version V1
 * @summary 
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018-06-11
 */
public class B3SoloPlugin implements Serializable {
	private static final long serialVersionUID = -2583684989656190680L;
	/**
	 *  默认值:null
	 */
	private String oid;
	/**
	 *  默认值:null
	 */
	private String author;
	/**
	 *  默认值:null
	 */
	private String name;
	/**
	 *  默认值:null
	 */
	private String status;
	/**
	 *  默认值:null
	 */
	private String version;
	/**
	 *  默认值:null
	 */
	private String setting;

	@Override
	public String toString() {
		return "B3SoloPlugin{" +
				"oid=\'" + oid + "\'" +
				", author=\'" + author + "\'" +
				", name=\'" + name + "\'" +
				", status=\'" + status + "\'" +
				", version=\'" + version + "\'" +
				", setting=\'" + setting + "\'" +
			"}";
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOid() {
		return this.oid;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return this.status;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVersion() {
		return this.version;
	}
	public void setSetting(String setting) {
		this.setting = setting;
	}
	public String getSetting() {
		return this.setting;
	}
}