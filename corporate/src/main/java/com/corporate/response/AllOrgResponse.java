package com.corporate.response;

import java.util.List;





import com.corporate.model.OrgRest;
import com.corporate.pojo.BaseObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllOrgResponse extends BaseObject {
	
	@Expose
	@SerializedName("org")
	private List<OrgRest> org;
	
	public List<OrgRest> getOrg() {
		return org;
	}
	public void setOrg(List<OrgRest> org) {
		this.org = org;
	}
	
	
}
