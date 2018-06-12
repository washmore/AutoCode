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
public class B3SoloPlugin implements Serializable {
	private static final long serialVersionUID = -7960189274846597958L;
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