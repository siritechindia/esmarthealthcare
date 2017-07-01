/**
 * 
 */
package com.siri.crm.patientCare.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siri.crm.patientCare.service.PatientService;
import com.siri.crm.patientCare.util.TokenGenerator;

/**
 * @author new  author is swetha
 *
 */
@Component
@Path("/authenticationService")
public class AuthenticationController {
	
	private static final String AUTHENTICATION_SERVICE_MESSAGE="authenticationFailed";
	
	@Autowired
	private PatientService ps;
	
	@POST
	@Path("/authenticateUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response autthenicateUser(
			@FormParam("userName")String uname,
			@FormParam("password")String passsword){
		
		System.out.println("User name is:\t"+uname);
		System.out.println("password is:\t"+passsword);
		JSONObject json = new JSONObject();
		try{
			if((uname ==  null || uname.isEmpty()) ||
					(passsword == null || passsword.isEmpty())){
				String message = "User Name and Password "
						+ "should not be empty or null";
				json.put("authMessage", message);
				return Response
						.status(Status.BAD_REQUEST)
						.entity(json.toString())
						.build();
			}	
			boolean isAuthenticated = ps.isAuthentiocated(uname, passsword);
			System.out.println("is authenticated:\t"+isAuthenticated);
			if(isAuthenticated){
				String token = TokenGenerator.generateTokenHah(uname, passsword);
				System.out.println("Hash token is "+token);
				
				String accessToken = TokenGenerator.generateAccessToken(token);
				System.out.println("accessToken is "+accessToken);
				json.put("authMessage", accessToken);
				return Response
						.status(Status.OK)
						.entity(json.toString())
						.build();
			}else{
				json.put("authMessage", "authenticationFailed");
				return Response
						.status(Status.FORBIDDEN)
						.entity(json.toString())
						.build();
			}
			
					
		}catch(Exception e){
			try {
				json.put("authMessage", "Oops! Some thing went wrong! Please try after some time");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return Response
					.status(Status.INTERNAL_SERVER_ERROR)
					.entity(json.toString())
					.build();
		}
	
	}

}
