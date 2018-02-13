package com.corporate.pojo;

import javax.ws.rs.core.Response;



import javax.ws.rs.core.Response.Status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseObject extends BaseObject{
	@Expose
	@SerializedName("object")
	private Object object;
	@Expose
	@SerializedName("message")
	private String message;
	@Expose
	@SerializedName("status_code")
	private int statusCode;
	public ResponseObject(BaseObject object, String message, int statusCode) {
		super();
		this.object = object;
		this.message = message;
		this.statusCode = statusCode;
	}
	public ResponseObject(BaseObject object, String message, Status status) {
		super();
		this.object = object;
		this.message = message;
		this.statusCode = status.getStatusCode();
	}
	public Object getObject() {
		return object;
	}
	public void setObject(BaseObject object) {
		this.object = object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Status stat) {
		this.statusCode = stat.getStatusCode();
	}
	public Response getResponse() {
		return Response.status(getStatusCode()).entity(this).build();
	}
}
