package com.model2.mvc.service.product;

import java.util.List;
import java.util.Map; 
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;

public interface ProductDao {
	
	public void addProduct(Product Prod) throws Exception;

	public Product getProduct(int prodNo) throws Exception;
	
	public List<Product> getProductList(Search svo) throws Exception;
		 
	public void updateProduct(Product prod) throws Exception;
	public int getTotalCount(Search search) throws Exception ;
}
