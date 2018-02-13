package com.corporate.service;

import com.corporate.model.OrgRest;




import com.corporate.pojo.BaseObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestOrg extends BaseObject {
	@Expose
	@SerializedName("action")
	private String action;
	@Expose
	@SerializedName("org")
	private OrgRest orgr;
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public OrgRest getOrgr() {
		return orgr;
	}
	public void setOrgr(OrgRest orgr) {
		this.orgr = orgr;
	}
	
	
}
