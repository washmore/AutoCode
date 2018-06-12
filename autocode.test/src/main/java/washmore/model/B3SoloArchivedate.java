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
public class B3SoloArchivedate implements Serializable {
	private static final long serialVersionUID = -9095236847824317414L;
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