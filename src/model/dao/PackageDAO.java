package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Package;

public class PackageDAO {
	private Connection conn;

	public List<Package> getAll() {
		conn = ConnectDB.getConnect();
		List<Package> packagesList = new ArrayList<Package>();
		String query = "SELECT * FROM PACKAGE";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Package package1 = new Package();
				package1.setPackageId(resultSet.getString("packageId"));
				package1.setPackageName(resultSet.getNString("packageName"));
				package1.setPackageType(resultSet.getNString("packageType"));
				package1.setPrice(resultSet.getFloat("price"));
				packagesList.add(package1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return packagesList;
	}

	public void insert(Package package1) {
		conn = ConnectDB.getConnect();
		String query = "INSERT INTO PACKAGE(packageId, packageName, packageType, price) VALUES (?, ? , ?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, package1.getPackageId());
			preparedStatement.setString(2, package1.getPackageName());
			preparedStatement.setString(3, package1.getPackageType());
			preparedStatement.setFloat(4, package1.getPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Package package1) {
		conn = ConnectDB.getConnect();
		String query = "UPDATE PACKAGE SET packageName = ?, packageType = ?, price = ? WHERE packageId = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, package1.getPackageName());
			preparedStatement.setString(2, package1.getPackageType());
			preparedStatement.setFloat(3, package1.getPrice());
			preparedStatement.setString(4, package1.getPackageId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void delete(String packageId) {
		conn = ConnectDB.getConnect();
		String query = "DELETE FROM PACKAGE WHERE packageId = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, packageId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param packageId
	 * @return
	 * @throws SQLException hiển thị thông tin lên form cập nhật
	 */
	public Package getAllById(String packageId) {
		conn = ConnectDB.getConnect();
		Package service = null;
		String query = "SELECT * FROM PACKAGE WHERE packageId = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, packageId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String packageName = resultSet.getNString("packageName");
				String packageType = resultSet.getNString("packageType");
				float price = resultSet.getFloat("price");
				service = new Package(packageId, packageName, packageType, price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return service;
	}

	public List<Package> getPagination(int start, int recordPerPage) {
		conn = ConnectDB.getConnect();
		List<Package> packagesList = new ArrayList<Package>();
		String query = "SELECT * FROM PACKAGE order by packageId offset ? rows fetch next ? rows only";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, start);
			preparedStatement.setInt(2, recordPerPage);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Package package1 = new Package();
				package1.setPackageId(resultSet.getString("packageId"));
				package1.setPackageName(resultSet.getNString("packageName"));
				package1.setPackageType(resultSet.getNString("packageType"));
				package1.setPrice(resultSet.getFloat("price"));
				packagesList.add(package1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return packagesList;
	}

	public int numberOfRecord() {
		conn = ConnectDB.getConnect();
		int result = 0;
		String query = "SELECT count(*) FROM PACKAGE";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
