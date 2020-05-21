package com.model2.mvc.web.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.user.UserService;
 
@Controller
public class ProductController {
	 
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
 		
	public ProductController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit; 
	@Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	
	
	// 상품추가페이지 보여달라
	@RequestMapping("/addProductView.do")
	public String addUProductView() throws Exception {
  
		return "redirect:/product/addProductView.jsp";
	}
	
	
	//상품추가해달라
	@RequestMapping("/addProduct.do")
	public String addProduct( @ModelAttribute("product") Product product ) throws Exception {
  
		productService.addProduct(product); 
		return "redirect:/product/addedView.jsp";
	}
	
	@RequestMapping("/getProduct.do")
	public String getProduct( @RequestParam("prodNo") int prodNo , Model model ) throws Exception {
		  
		Product prod = productService.getProduct(prodNo); 
		
		model.addAttribute("pvo", prod); // Model 과 View 연결
		
		return "forward:/product/getProduct.jsp";
	}
	
//	@RequestMapping("/updateProductView.do")
//	public String updateUserView( @RequestParam("prodNo") int prodNo , Model model ) throws Exception{ 
//		Product prod = productService.getProduct(prodNo); 
//		model.addAttribute("pvo", prod);   
//		return "forward:/user/updateUser.jsp";
//	}
	
//	@RequestMapping("/updateProduc.do")
//	public String updateUser( @ModelAttribute("pvo") Product product , Model model ) throws Exception{
//
//		System.out.println("/updateUser.do");
//		//Business Logic
//		productService.updateProduct(user);
//		
//		String sessionId=((User)session.getAttribute("user")).getUserId();
//		if(sessionId.equals(user.getUserId())){
//			session.setAttribute("user", user);
//		}
//		
//		return "redirect:/getUser.do?userId="+user.getUserId();
//	}
// 
// 
//	
	@RequestMapping("/listProduct.do")
	public String listUser( @ModelAttribute("search") Search search , Model model , HttpServletRequest request) throws Exception{
		  
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		 
		Map<String , Object> map=productService.getProductList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model 과 View 연결
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		return "forward:/search/listProduct.jsp";
	}
}