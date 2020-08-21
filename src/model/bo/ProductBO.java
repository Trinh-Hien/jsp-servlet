package model.bo;

import java.util.List;

import model.bean.Product;
import model.dao.ProductDao;

public class ProductBO {
	private ProductDao productDao = new ProductDao();

	public List<Product> getProducts(int start, int recordPerPage) {
		return productDao.getProducts(start, recordPerPage);
	}

	public void insertProduct(Product product) {
		productDao.insertProduct(product);
	}

	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	public void deleteProduct(String productId) {
		productDao.deleteProduct(productId);
	}

	public int numberOfRecord() {
		return productDao.numberOfRecord();
	}
	public Product getProduct(String productId) {
		return productDao.getProduct(productId);
	}
	public boolean checkPrimary(String productId) {
		for(Product product: productDao.getAll()) {
			if(productId.equals(product.getProductId())) {
				return true;
			}
		}
		return false;
	}

}
