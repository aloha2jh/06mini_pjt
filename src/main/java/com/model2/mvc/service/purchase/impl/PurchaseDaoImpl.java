package com.model2.mvc.service.purchase.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase; 
import com.model2.mvc.service.purchase.PurchaseDao;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {

	@Autowired
	@Qualifier("sqlSessionTemplate")  
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	/// sqlSessionTemplate <<< 이게 commonservice에 있는 빈들중..
	//org.mybatis.spring.SqlSessionTemplate 빈을 가져다 쓰는 ???????
	@Override
	public void addPurchase(Purchase purchase) throws Exception {
		sqlSession.insert("PurchaseMapper.addPurchase", purchase);
	}
	@Override
	public Purchase getPurchase(int purchaseNo) throws Exception {
		return sqlSession.selectOne("PurchaseMapper.getPurchase", purchaseNo);
	}
	@Override
	public List<Product> getPurchaseList(Map<String, Object> smap) throws Exception {
		return sqlSession.selectList("PurchaseMapper.getPurchaseList", smap );
	}
	@Override
	public void updatePurchase(Purchase purchase) throws Exception {
		sqlSession.update("PurchaseMapper.updatePurchase", purchase);
	}
	@Override
	public int getTotalCount(String userId) throws Exception {
		return sqlSession.selectOne("PurchaseMapper.getTotalCount", userId);
	}
	
	  
 
	 
}
