package washmore.model;

import java.io.Serializable;
/**
 * @author Washmore
 * @version V1
 * @summary 
 * @Copyright (c) 2018, Lianjia Group All Rights Reserved.
 * @since 2018-06-11
 */
public class B3SoloOption implements Serializable {
	private static final long serialVersionUID = -7791897846254031668L;
	/**
	 *  默认值:null
	 */
	private String oid;
	/**
	 *  默认值:null
	 */
	private String optionvalue;
	/**
	 *  默认值:null
	 */
	private String optioncategory;

	@Override
	public String toString() {
		return "B3SoloOption{" +
				"oid=\'" + oid + "\'" +
				", optionvalue=\'" + optionvalue + "\'" +
				", optioncategory=\'" + optioncategory + "\'" +
			"}";
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOid() {
		return this.oid;
	}
	public void setOptionvalue(String optionvalue) {
		this.optionvalue = optionvalue;
	}
	public String getOptionvalue() {
		return this.optionvalue;
	}
	public void setOptioncategory(String optioncategory) {
		this.optioncategory = optioncategory;
	}
	public String getOptioncategory() {
		return this.optioncategory;
	}
}