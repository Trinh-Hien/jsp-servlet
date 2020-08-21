package model.bo;

import java.util.List;

import model.bean.Schedule;
import model.dao.ScheduleDao;

/**
 * ScheduleBO.java
 * 
 * Version
 * 
 * Date: 10-05-2020
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE               AUTHOR          DESCRIPTION				
 * ------------------------------------------------------			
 * 10-05-2020            HienTT20          Create				
 */
public class ScheduleBO {

	private ScheduleDao dao= new ScheduleDao();
	
	public List<Schedule> getList(int memberId){
		return dao.getList(memberId);
	}
}


