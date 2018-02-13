package com.corporate.controller;
import java.util.List;




import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.corporate.controller.ResourceBase;
import com.corporate.response.AllOrgResponse;
import com.corporate.utils.*;
import com.corporate.utils.ServiceConstants;
import com.corporate.model.OrgRest;
import com.corporate.pojo.ResponseObject;
import com.corporate.service.RequestOrg;
import com.google.gson.Gson;
@Path("/Jsonposts")
public class ExtractData {
	@GET
	@Path("/getJsonPosts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJsonPosts() {
		ResponseObject response = new ResponseObject(null, "", Status.OK);
		try {
			EntityManager entityManager = ResourceBase.INSTANCE.getEntityManager();
			Query query = entityManager.createNativeQuery(ServiceConstants.SQL_GET_ACTIVE_ORG_NAMES,
					OrgRest.class);
			List<OrgRest> or = query.getResultList();
			AllOrgResponse responseObj = new AllOrgResponse();
			responseObj.setOrg(or);
			response.setObject(responseObj);
			response.setStatusCode(Status.OK);
		} catch (NamingException e) {
			System.out.println("Could not find jpa object");
		} catch (PersistenceException e) {
			System.out.println("Transaction failed");
		}
		return Response.status(Status.OK.getStatusCode()).entity(response.toString()).build();
	}
	
	

}
