package com.model2.mvc.service.purchase;

import java.util.List;
import java.util.Map; 
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;

public interface PurchaseDao {
	
	public void addPurchase(Purchase purchase) throws Exception;

	public Purchase getPurchase(int purchaseNo) throws Exception;
	
	public List<Product> getPurchaseList(Map<String, Object> smap) throws Exception;
		 
	public void updatePurchase(Purchase purchase ) throws Exception;
	
	public int getTotalCount(String userId ) throws Exception ;
}
