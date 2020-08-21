package common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Validate.java
 * 
 * Version
 * 
 * Date: 30-04-2020
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE               AUTHOR          DESCRIPTION				
 * ------------------------------------------------------			
 * 30-04-2020            HienTT20          Create				
 */
public class Validate {

	//kiem tra trung ten
	public static boolean isExitName(String name, List<String> accountNames) {
		for(String string: accountNames) {
			if(name.equals(string)) {
				return true;
			}
		}
		return false;
	}
	
	 public static String getMd5(String input) 
	    { 
	        try { 
	  
	            // Static getInstance method is called with hashing MD5 
	            MessageDigest md = MessageDigest.getInstance("MD5"); 
	  
	            // digest() method is called to calculate message digest 
	            //  of an input digest() return array of byte 
	            byte[] messageDigest = md.digest(input.getBytes()); 
	  
	            // Convert byte array into signum representation 
	            BigInteger no = new BigInteger(1, messageDigest); 
	  
	            // Convert message digest into hex value 
	            String hashtext = no.toString(16); 
	            while (hashtext.length() < 32) { 
	                hashtext = "0" + hashtext; 
	            } 
	            return hashtext; 
	        }  
	  
	        // For specifying wrong message digest algorithms 
	        catch (NoSuchAlgorithmException e) { 
	            throw new RuntimeException(e); 
	        } 
	    }
	 
	 public static boolean checkExit(int a, int[] array) {
		 for(int i: array){
			 if(a==i) {
				 return true;
			 }
		 }
		 return false;
	 }
}


