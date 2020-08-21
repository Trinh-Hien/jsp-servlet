package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Schedule;

/**
 * ScheduleDao.java
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
public class ScheduleDao {
	private Connection conn;

	public List<Schedule> getList(int memberId) {
		conn = ConnectDB.getConnect();
		String sql = "select className, startTime, schedule \r\n"
				+ "from CLASS inner join REGISTER_CLASS on CLASS.classId= REGISTER_CLASS.classId \r\n"
				+ "where memberId=? and (status=N'Đang mở'or status=N'Đang diễn ra')";
		List<Schedule> list = new ArrayList<Schedule>();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, memberId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Schedule schedule = new Schedule();
				schedule.setNameClass(rs.getNString("className"));
				schedule.setStartTime(rs.getTime("startTime").toString());
				schedule.setDay(convert(rs.getString("schedule")));
				list.add(schedule);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}

	public int[] convert(String input) {
		String[] splits = input.split(",");
		int[] result = new int[splits.length];
		for (int i = 0; i < splits.length; i++) {
			int a = Integer.parseInt(splits[i]);
			result[i] = a;
		}
		return result;
	}

}
