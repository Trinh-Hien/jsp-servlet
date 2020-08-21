package model.bo;

import java.util.List;

import model.bean.RegisterClass;
import model.dao.RegisterClassDao;

/**
 * RegisterClassBo.java
 * 
 * Version
 * 
 * Date: 03-05-2020
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE               AUTHOR          DESCRIPTION				
 * ------------------------------------------------------			
 * 03-05-2020            HienTT20          Create				
 */
public class RegisterClassBO {
	private RegisterClassDao dao= new RegisterClassDao();
	
	public int getNumberOfRegisted(String classId) {
		return dao.getnumberRegisted(classId);
	}
	
	public List<RegisterClass> getAll(){
		return dao.getAll();
	}
	public boolean checkPrimarykey(int memberId, String classId) {
		List<RegisterClass> registers= getAll();
		for(RegisterClass registerClass: registers) {
			if(memberId==registerClass.getMemberId()&& classId.equals(registerClass.getClassId())) {
				return true;
			}
		}
		return false;
		
	}
	public void insert(RegisterClass registerClass) {
		dao.insert(registerClass);
	}
	
	public List<List<String>> getDetail(int memberId){
		return dao.getDetail(memberId);
	}

	public void delete(String classId, int memberId) {
		dao.delete(classId, memberId);
		
	}

	public void update(RegisterClass registerClass) {
		dao.update(registerClass);
		
	}

	public RegisterClass getRegisterClass(int memberId, String classId) {
		// TODO Auto-generated method stub
		return dao.getRegisterClass(memberId, classId);
	}
}


