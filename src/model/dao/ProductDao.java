package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Product;

public class ProductDao {
	private Connection conn;

	public List<Product> getProducts(int start, int recordPerPage) {
		conn = ConnectDB.getConnect();
		List<Product> products = new ArrayList<Product>();
		String query = "select * from PRODUCT order by productId offset ? rows fetch next ? rows only";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, start);
			pst.setInt(2, recordPerPage);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getString("productId"));
				product.setProductName(rs.getNString("productName"));
				product.setProductType(rs.getNString("productType"));
				product.setImportDate(rs.getDate("importDate").toLocalDate());
				product.setWarrantyDate(rs.getDate("warrantyDate").toLocalDate());
				product.setImageUrl(rs.getString("imgUrl"));
				product.setQuantity(rs.getInt("quantity"));
				product.setStatus(rs.getNString("status"));
				product.setCost(rs.getFloat("cost"));
				products.add(product);
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
		return products;
	}

	public void insertProduct(Product product) {
		conn = ConnectDB.getConnect();
		PreparedStatement pst = null;
		String query = "insert into PRODUCT values(?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, product.getProductId());
			pst.setNString(2, product.getProductName());
			pst.setNString(3, product.getProductType());
			pst.setDate(4, Date.valueOf(product.getImportDate()));
			pst.setDate(5, Date.valueOf(product.getWarrantyDate()));
			pst.setString(6, product.getImageUrl());
			pst.setInt(7, product.getQuantity());
			pst.setNString(8, product.getStatus());
			pst.setFloat(9, product.getCost());
			pst.executeUpdate();
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
	}

	public void updateProduct(Product product){
		conn = ConnectDB.getConnect();
		PreparedStatement pst = null;
		String query = "update PRODUCT "
				+ "set productName=?, productType=?,importDate=?,warrantyDate=?,status=?,cost=?,quantity=? "
				+ "where productId=? ";
		try {
			pst = conn.prepareStatement(query);

			pst.setNString(1, product.getProductName());
			pst.setNString(2, product.getProductType());
			pst.setDate(3, Date.valueOf(product.getImportDate()));
			pst.setDate(4, Date.valueOf(product.getWarrantyDate()));
			pst.setNString(5, product.getStatus());
			pst.setFloat(6, product.getCost());
			pst.setInt(7, product.getQuantity());
			pst.setString(8, product.getProductId());
			pst.executeUpdate();
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
	}

	public void deleteProduct(String productId) {
		conn = ConnectDB.getConnect();
		PreparedStatement pst = null;
		String query = "delete from PRODUCT where productId=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, productId);
			pst.executeUpdate();
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
	}

	public int numberOfRecord() {
		// TODO Auto-generated method stub
		conn = ConnectDB.getConnect();
		int rows = 0;
		String query = "select count(*) from PRODUCT";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(query);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				rows = rs.getInt(1);
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
		return rows;
	}

	public Product getProduct(String productmentId) {
		conn = ConnectDB.getConnect();
		String query = "select * from PRODUCT where productId = ?";
		PreparedStatement pst = null;
		Product product = new Product();
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, productmentId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				product.setProductId(rs.getString("productId"));
				product.setProductName(rs.getNString("productName"));
				product.setProductType(rs.getNString("productType"));
				product.setImportDate(rs.getDate("importDate").toLocalDate());
				product.setWarrantyDate(rs.getDate("warrantyDate").toLocalDate());
				product.setImageUrl(rs.getString("imgUrl"));
				product.setStatus(rs.getNString("status"));
				product.setCost(rs.getFloat("cost"));
				product.setQuantity(rs.getInt("quantity"));
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
		return product;
	}
	
	public List<Product> getAll() {
		conn = ConnectDB.getConnect();
		List<Product> products = new ArrayList<Product>();
		String query = "select * from PRODUCT";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getString("productId"));
				product.setProductName(rs.getNString("productName"));
				product.setProductType(rs.getNString("productType"));
				product.setImportDate(rs.getDate("importDate").toLocalDate());
				product.setWarrantyDate(rs.getDate("warrantyDate").toLocalDate());
				product.setImageUrl(rs.getString("imgUrl"));
				product.setQuantity(rs.getInt("quantity"));
				product.setStatus(rs.getNString("status"));
				product.setCost(rs.getFloat("cost"));
				products.add(product);
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
		return products;
	}

}
