package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDao;
import com.model2.mvc.service.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	//F
	@Autowired 
	@Qualifier("productDaoImpl")  //productDao 를 의존성주입받아야되는데, 걔를 implement하는애들중 productDaoImpl 객체를 주입해서 ProductDao타입으로 받겠다는건가?
	private ProductDao productDao; 
	public void setProdDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	//C
	public ProductServiceImpl() { 
		System.out.println(this.getClass() );
		System.out.println("------");
	}
	
	//M
	@Override
	public void addProduct(Product product) throws Exception {
		productDao.addProduct(product);
	}

	@Override
	public Product getProduct(int prodNo) throws Exception {
		  return productDao.getProduct(prodNo);
	}

	@Override
	public Map<String, Object> getProductList(Search svo) throws Exception {
		List<Product> list = productDao.getProductList(svo);
		int totalCount = productDao.getTotalCount(svo);
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount) );
		return map;
	}

	@Override
	public void updateProduct(Product prod) throws Exception {
		productDao.updateProduct(prod);
	}

}
