package model.bo;

import java.util.List;

import model.bean.ClassGym;
import model.dao.ClassDao;

/**
 * ClassBO.java
 * 
 * Version
 * 
 * Date: 01-05-2020
 *
 * Copyright
 * 
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * ------------------------------------------------------ 01-05-2020 HienTT20
 * Create
 */
public class ClassBO {
	private ClassDao dao = new ClassDao();

	public List<ClassGym> getClassOpen() {
		return dao.getClassOpen();
	}
	public ClassGym getClassById(String classId) {
		return dao.searchById(classId);
	}
	
	public int getMaxMaember(String classId) {
		return dao.getMaxMember(classId);
	}
	public String getClassId(String className) {
		return dao.getClassId(className);
	}
	public int numberOfRecord() {
		return dao.numberOfRecords();
	}
	public boolean checkPrimaryKey(String classId) {
		List<ClassGym> list= dao.getAll();
		for(ClassGym gym: list) {
			if(classId.equals(gym.getClassId())) {
				return true;
			}
		}
		return false;
	}
	
	public void insert(ClassGym classGym) {
		dao.insert(classGym);
	}
	public List<ClassGym> getPagination(int start, int recordPerPage){
		return dao.getClassList(start, recordPerPage);
	}
	
	public void update(ClassGym gym) {
		dao.update(gym);
	}
	public void delete(String classId) {
		dao.deleteById(classId);
	}

}
