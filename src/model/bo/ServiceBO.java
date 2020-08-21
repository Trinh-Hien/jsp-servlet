package model.bo;

import java.util.List;

import model.bean.Service;
import model.dao.ServiceDAO;

public class ServiceBO {
	private ServiceDAO serviceDAO = new ServiceDAO();

	public List<Service> getAll() {
		return serviceDAO.getAll();
	}

	public void insert(Service service) {
		serviceDAO.insert(service);
	}

	public void update(Service service) {
		serviceDAO.update(service);
	}

	public void delete(String serviceId) {
		serviceDAO.delete(serviceId);
	}

	public Service searchById(String serviceId) {
		return serviceDAO.searchById(serviceId);
	}
	
	public String getServiceId(String serviceName) {
		List<Service> services= getAll();
		String serviceId = null;
		for(Service service: services) {
			if(service.getServiceName().equals(serviceName)) {
				serviceId= service.getServiceId();
			}
		}
		return serviceId;
	}
	
	public int numberOfRecord() {
		return serviceDAO.numberOfRecord();
	}
	public boolean checkPrimary(String serviceId) {
		for(Service service: getAll()) {
			if(serviceId.equals(service.getServiceId())) {
				return true;
			}
		}
		return false;
	}
	
	public List<Service> getPagination(int start, int recordPerPage){
		return serviceDAO.getPagination(start, recordPerPage);
	}

}
