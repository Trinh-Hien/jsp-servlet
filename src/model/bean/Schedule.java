package model.bean;

/**
 * Schedule.java
 * 
 * Version
 * 
 * Date: 10-05-2020
 *
 * Copyright
 * 
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * ------------------------------------------------------ 10-05-2020 HienTT20
 * Create
 */
public class Schedule {
	private String nameClass;
	private String startTime;
	private int[] day;

	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	public Schedule(String startTime, int[] day, String nameClass) {
		super();
		this.nameClass= nameClass;
		this.startTime = startTime;
		this.day = day;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int[] getDay() {
		return day;
	}

	public void setDay(int[] day) {
		this.day = day;
	}

	public String getNameClass() {
		return nameClass;
	}

	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}
	

}
