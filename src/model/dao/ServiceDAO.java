package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Service;

public class ServiceDAO {
	private Connection conn;

	public List<Service> getAll() {
		conn = ConnectDB.getConnect();
		List<Service> serviceList = new ArrayList<Service>();
		String query = "SELECT * FROM SERVICE";
		PreparedStatement preparedStatement= null;
		try {
			preparedStatement = conn.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Service service = new Service();
				service.setServiceId(resultSet.getString("serviceId"));
				service.setServiceName(resultSet.getNString("serviceName"));
				service.setServiceType(resultSet.getNString("serviceType"));
				service.setImageUrl(resultSet.getString("imgUrl"));
				service.setPrice(resultSet.getFloat("price"));
				serviceList.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return serviceList;
	}

	public void insert(Service service) {
		conn = ConnectDB.getConnect();
		String query = "INSERT INTO SERVICE(serviceId, serviceName, serviceType, imgUrl, price) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, service.getServiceId());
			preparedStatement.setNString(2, service.getServiceName());
			preparedStatement.setNString(3, service.getServiceType());
			preparedStatement.setString(4, service.getImageUrl());
			preparedStatement.setFloat(5, service.getPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Service service) {
		conn = ConnectDB.getConnect();
		String query = "update SERVICE set serviceName = ?, serviceType = ?, price = ? where serviceId = ?";

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setNString(1, service.getServiceName());
			preparedStatement.setNString(2, service.getServiceType());
			preparedStatement.setFloat(3, service.getPrice());
			preparedStatement.setString(4, service.getServiceId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delete(String serviceId) {
		conn = ConnectDB.getConnect();
		String query = "DELETE FROM SERVICE WHERE serviceId = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, serviceId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Service searchById(String serviceId) {
		conn = ConnectDB.getConnect();
		String query = "SELECT * FROM SERVICE WHERE serviceId = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, serviceId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String serviceName = resultSet.getNString("serviceName");
				String serviceType = resultSet.getNString("serviceType");
				String imageUrl = resultSet.getString("imgUrl");
				float price = resultSet.getFloat("price");
				Service service = new Service(serviceId, serviceName, serviceType, imageUrl, price);
				return service;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	public int numberOfRecord() {
		conn = ConnectDB.getConnect();
		int result =0;
		String query = "SELECT count(*) FROM SERVICE";
		PreparedStatement preparedStatement= null;
		try {
			preparedStatement = conn.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result= resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<Service> getPagination(int start, int recordPerPage) {
		conn = ConnectDB.getConnect();
		List<Service> serviceList = new ArrayList<Service>();
		String query = "SELECT * FROM SERVICE order by serviceId offset ? rows fetch next ? rows only";
		PreparedStatement preparedStatement= null;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, start);
			preparedStatement.setInt(2, recordPerPage);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Service service = new Service();
				service.setServiceId(resultSet.getString("serviceId"));
				service.setServiceName(resultSet.getNString("serviceName"));
				service.setServiceType(resultSet.getNString("serviceType"));
				service.setImageUrl(resultSet.getString("imgUrl"));
				service.setPrice(resultSet.getFloat("price"));
				serviceList.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return serviceList;
	}

}
