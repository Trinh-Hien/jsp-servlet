package model.bo;

import java.util.List;

import model.bean.RegisterService;
import model.dao.RegisterServiceDao;

/**
 * RegisterServiceBO.java
 * 
 * Version
 * 
 * Date: 02-05-2020
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE               AUTHOR          DESCRIPTION				
 * ------------------------------------------------------			
 * 02-05-2020            HienTT20          Create				
 */
public class RegisterServiceBO {
	private RegisterServiceDao dao= new RegisterServiceDao();
	
	public List<List<String>> getRegisterService(int accountId){
		return dao.getService(accountId);
	}
	public void insertRegisterService(RegisterService service) {
		dao.insertRegisterService(service);
	}
	public List<RegisterService> getAll(){
		return dao.getAll();
	}
	public void delete(int id) {
		dao.delete(id);
		
	}
	public RegisterService getRegisterServiceById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}
	public void update(RegisterService rs) {
		dao.update(rs);
		
	}

}


