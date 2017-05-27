/**
 * 
 */
package com.siri.crm.patientCare.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

import com.sun.jersey.core.util.Base64;


/**
 * @author Veera Arun Kumar
 *
 */
@Component
public class TokenGenerator {

	
	public static String generateTokenHah(String username, 
			String passsword){
		String tokenPhrase = username+passsword;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(tokenPhrase.getBytes());
			byte[] tokenBytes = md.digest();
			System.out.println("generated Hash Bytes are:\t"+tokenBytes.length);
			
	       tokenBytes = Base64.encode(tokenBytes);
			
			String tokenHash = new String(tokenBytes, "UTF-8");
			System.out.println("generated Toke Hash Is:\t"+tokenHash);
			return tokenHash;
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String generateAccessToken(String hashToken){
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(hashToken.getBytes());
			byte[] tokenBytes = md.digest();
			System.out.println("generated Hash Bytes are:\t"+tokenBytes.length);
			
	       tokenBytes = Base64.encode(tokenBytes);
			
			hashToken = new String(tokenBytes, "UTF-8");
			System.out.println("generated Toke Hash Is:\t"+hashToken);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hashToken;
	
	}
	
	public static String getTokenFromHeader(String headerValue){
		if(headerValue != null && !headerValue.isEmpty()){
			String[] parts = headerValue.split(" ");
			if(parts != null && parts.length !=2){
				return null;
			}
			String bearerKey = parts[0];
			System.out.println("bearer is "+bearerKey);
			if(bearerKey == null || bearerKey.isEmpty() || bearerKey.equals(" ")){
				return null;
			}
			
			String token = parts[1];
			System.out.println("token from header is:\t"+token);
			return token;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		/*String hash = "teQvSas6z49sLM+Z9gShfw==";
		
		hash= generateAccessToken(hash);
		System.out.println(hash);*/
		
	}
}
