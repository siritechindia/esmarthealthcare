


/**
 * 
 */
package com.siri.crm.patientCare.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siri.crm.patientCare.beans.PatientBean;
import com.siri.crm.patientCare.service.PatientService;
import com.siri.crm.patientCare.util.TokenGenerator;

/**
 * @author Veera Arun Kumar
 *
 */
@Component
@Path("/patientService")
public class PatientServicesCntrl {

	@Autowired
	private PatientService ps;
	
	@GET
	@Path("/getPatientById/{pid}")
	//@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientById(
			@HeaderParam("X-Authorization") String headerParam,
			@PathParam("pid")int patientId){
		System.out.println("Patient Id Is:\t"+patientId);
	     System.out.println("header param is:\t"+headerParam);
		if(headerParam == null || headerParam.isEmpty()){
			JSONObject json = new JSONObject();
			try {
				json.put("authorizationFailed", "Unable to acccess the resoure");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Response.status(Status.UNAUTHORIZED).
					entity(json.toString()).
					build();
		}
		
		String tokenHash = TokenGenerator.getTokenFromHeader(headerParam);
		if(tokenHash == null || tokenHash.isEmpty()){
			JSONObject json = new JSONObject();
			try {
				json.put("authorizationFailed", "Unable to acccess the resoure");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Response.status(Status.UNAUTHORIZED).
					entity(json.toString()).
					build();
		}
		
		PatientBean patientBean=ps.getPatientById(patientId);
		return Response.status(200).entity(patientBean).build();
	}
	
	@POST
	@Path("/addPatient")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPatient(PatientBean pbn){
		System.out.println(pbn.toString());
		pbn=ps.addPatient(pbn);
		
		return Response.status(200).entity(pbn).build();
	}
	
	
	@GET
	@Path("/getPatientByName/{userName}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getPatientByName(@PathParam("userName")String userName){
	PatientBean patientBean=ps.getPatientByName(userName);
			return Response.status(200).entity(patientBean).build();
	}
	
	@GET
	@Path("/getAllPatientNames")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPatientNames(){
		Response resp = null;
		
		List<String> pnames = ps.getAllPatientNames();
		if(pnames == null || pnames.isEmpty()){
			resp = Response.status(204).build();
		}
		resp = Response.status(200).entity(pnames).build();
		
		return resp;
	}
	
	
	
	@GET
	@Path("/getAllPatients")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPatients(@HeaderParam("X-Authorization")String headerParam){
			Response resp = null;
		System.out.println("header param value"+headerParam);
		JSONObject json = new JSONObject();
		final String PATINET_KEY = "patinetMessage";
		try{
			String token = TokenGenerator.getTokenFromHeader(headerParam);
			if(token == null){
				String message = "A Valid Token should be provided.";
				json.put(PATINET_KEY, message);
				
				return Response
						.status(Status.UNAUTHORIZED)
						.entity(json.toString())
						.build();
			}
			List<PatientBean> pnames = ps.getPatientList();
			if(pnames == null || pnames.isEmpty()){
				json.put(PATINET_KEY, "No Patinets found");
				resp = Response.
						status(Status.NOT_FOUND)
						.entity(json.toString())
						.build();
			}
			resp = Response
					.status(Status.OK)
					.entity(pnames)
					.build();
			
			return resp;
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
	
	@POST
	@Path("/assignDoctor/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAssignDoctorByPatientUserName(@PathParam("userName")String userName)
	{
		Response resp = null;
		System.out.println(userName);
		String doctorName=ps.getAssignDoctor(userName);
		
		resp = Response.status(200).entity(doctorName).build();
	
	return resp;
		
	}

	
}
