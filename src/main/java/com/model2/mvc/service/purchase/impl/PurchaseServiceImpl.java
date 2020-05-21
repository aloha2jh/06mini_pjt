package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase; 
import com.model2.mvc.service.purchase.PurchaseDao;
import com.model2.mvc.service.purchase.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	//F
	@Autowired 
	@Qualifier("purchaseDaoImpl")  //productDao 를 의존성주입받아야되는데, 걔를 implement하는애들중 productDaoImpl 객체를 주입해서 ProductDao타입으로 받겠다는건가?
	private PurchaseDao purchaseDao; 
	public void setProdDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	@Override
	public void addPurchase(Purchase purchase) throws Exception {
		purchaseDao.addPurchase(purchase);
	}
	@Override
	public Purchase getPurchase(int purchaseNo) throws Exception {
		return purchaseDao.getPurchase(purchaseNo);
	}
	@Override
	public Map<String, Object> getPurchaseList(Map<String, Object> smap) throws Exception {
		
		// 주문목록을 받아온다.
		List<Product> list = purchaseDao.getPurchaseList(smap);
		System.out.println( "[]주문목록결과"+list ); 
		
		String buyerId = (String) smap.get("buyerId");
		
		// 총갯수목록을 받아온다.
		int totalCount = purchaseDao.getTotalCount(buyerId);
		System.out.println("[]총갯수결과:"+totalCount);
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount) );
		return map;
	}
	@Override
	public void updatePurchase(Purchase purchase) throws Exception {
		purchaseDao.updatePurchase(purchase);
	}
	 
 
}
