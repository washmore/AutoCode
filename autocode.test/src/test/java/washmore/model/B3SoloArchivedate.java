package washmore.model;

import java.io.Serializable;
/**
 * @author Washmore
 * @version V1
 * @summary 
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018-06-11
 */
public class B3SoloArchivedate implements Serializable {
	private static final long serialVersionUID = -2564536289026192075L;
	/**
	 *  默认值:null
	 */
	private String oid;
	/**
	 *  默认值:null
	 */
	private Integer archivedatearticlecount;
	/**
	 *  默认值:null
	 */
	private Integer archivedatepublishedarticlecount;
	/**
	 *  默认值:null
	 */
	private Long archivetime;

	@Override
	public String toString() {
		return "B3SoloArchivedate{" +
				"oid=\'" + oid + "\'" +
				", archivedatearticlecount=" + archivedatearticlecount +
				", archivedatepublishedarticlecount=" + archivedatepublishedarticlecount +
				", archivetime=" + archivetime +
			"}";
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOid() {
		return this.oid;
	}
	public void setArchivedatearticlecount(Integer archivedatearticlecount) {
		this.archivedatearticlecount = archivedatearticlecount;
	}
	public Integer getArchivedatearticlecount() {
		return this.archivedatearticlecount;
	}
	public void setArchivedatepublishedarticlecount(Integer archivedatepublishedarticlecount) {
		this.archivedatepublishedarticlecount = archivedatepublishedarticlecount;
	}
	public Integer getArchivedatepublishedarticlecount() {
		return this.archivedatepublishedarticlecount;
	}
	public void setArchivetime(Long archivetime) {
		this.archivetime = archivetime;
	}
	public Long getArchivetime() {
		return this.archivetime;
	}
}