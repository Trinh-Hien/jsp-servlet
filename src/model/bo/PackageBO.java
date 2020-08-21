package model.bo;

import java.util.List;

import model.dao.PackageDAO;
import model.bean.Package;

/**
 * @author DAO
 *
 */
public class PackageBO {
	PackageDAO packageDAO = new PackageDAO();

	public List<Package> getAll() {
		return packageDAO.getAll();
	}

	public void insert(Package package1) {
		packageDAO.insert(package1);
	}

	public void delete(String packageId) {
		packageDAO.delete(packageId);
	}

	public void update(Package package1) {
		packageDAO.update(package1);
	}

	public Package getAllById(String object) {
		// TODO Auto-generated method stub
		return packageDAO.getAllById(object);
	}
	
	public boolean checkPrimary(String packageId) {
		for(Package package1: getAll()) {
			if(package1.getPackageId().equals(packageId)) {
				return true;
			}
		}
		return false;
	}
	
	public List<Package> getPagination(int start, int recordPerPage){
		return packageDAO.getPagination(start, recordPerPage);
	}
	
	public int numberOfRecord() {
		return packageDAO.numberOfRecord();
	}

}
