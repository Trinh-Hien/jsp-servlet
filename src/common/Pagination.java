package common;

/**
 * Pagination.java
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
public class Pagination {

	public static int startPosition(int currentPage, int recordPerPage) {
		return currentPage * recordPerPage - recordPerPage;
	}

	public static int noOfPage(int rows, int recordPerPage) {
		int nOfPage = rows / recordPerPage;
		if (rows % recordPerPage > 0) {
			nOfPage++;
		}
		return nOfPage;
	}

	public static int endPosition(int rows, int start, int recordPerPage) {
		int end = start + recordPerPage;
		if (end > rows) {
			end = rows;
		}
		return end;
	}

}


