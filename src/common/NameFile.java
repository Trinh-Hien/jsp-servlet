package common;

import javax.servlet.http.Part;

/**
 * NameFile.java
 * 
 * Version
 * 
 * Date: 09-05-2020
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE               AUTHOR          DESCRIPTION				
 * ------------------------------------------------------			
 * 09-05-2020            HienTT20          Create				
 */
public class NameFile {
	public static String getSubmittedFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE
																													// fix.
			}
		}
		return null;
	}


}


