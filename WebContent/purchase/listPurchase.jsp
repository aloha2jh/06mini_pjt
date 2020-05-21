<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
  
<html>
	<head>
		<title>구매 목록조회</title> 
		<link rel="stylesheet" href="/css/admin.css" type="text/css"> 
		<script type="text/javascript">
			function fncGetList (  cPage   ){
				document.getElementById("currentPage").value = cPage;
				document.detailForm.submit();
			}
		</script>
	</head>
	
	<body bgcolor="#ffffff" text="#000000"> 
	<c:set var="resultPage" value="${ resultPage }"/>
	 
	
	
	
		<div style="width: 98%; margin-left: 10px;"> 
		
			<form name="detailForm" action="/listPurchase.do" method="post"> 
				<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
					<tr>
						<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"width="15" height="37"></td>
						<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left: 10px;">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="93%" class="ct_ttl01">구매 목록조회</td>
								</tr>
							</table>
						</td>
						<td width="12" height="37"><img src="/images/ct_ttl_img03.gif"	width="12" height="37"></td>
					</tr>
				</table>
				
				<table width="100%" border="0" cellspacing="0" cellpadding="0"	style="margin-top: 10px;">
					<tr>
						<td colspan="11" >전체  ${ resultPage.totalCount } 건수, 현재 ${ resultPage.currentPage } 페이지</td>
					</tr>
					<tr>
						<td class="ct_list_b" width="100">No</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b" width="150">회원ID</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b" width="150">회원명</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b">전화번호</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b">배송현황</td>
						<td class="ct_line02"></td>
						<td class="ct_list_b">정보수정</td>
					</tr>
					<tr>
						<td colspan="11" bgcolor="808285" height="1"></td>
					</tr>
				
					<c:set var="i" value="0"/> <!--  -->
					<c:forEach var="psvo" items="${map}">
					<c:set var="i" value="${ i+1 }" /> <!--  -->
					
					<c:set var="uvo" value="${ psvo.buyer }"/>
					<c:set var="pvo" value="${ psvo.purchaseProd }"/>
					
					<tr class="ct_list_pop">
						<td align="center">
							<a href="/getPurchase.do?tranNo=${ psvo.tranNo }">
								${ psvo.tranNo }
							</a>
						</td>
						<td></td>
						<td align="left">
							<a href="/getUser.do?userId=${ uvo.userId }">
								${ uvo.userId }
							</a>
						</td>
						<td></td>
						<td align="left">${ psvo.receiverName }</td>
						<td></td>
						<td align="left">${ psvo.receiverPhone }</td>
						<td></td>
						<td align="left">현재 
						 
						<c:choose>
							<c:when test="${ psvo.tranCode=='001' }">
										구매완료
							</c:when>
							<c:when test="${psvo.tranCode=='002' }">
										배송중
								  <a href="/updateTranCode.do?prodNo=${ pvo.prodNo }&tranCode=003">(물건도착)</a> 
							</c:when>
							<c:when test="${psvo.tranCode=='003' }">
										배송완료
							</c:when> 
						</c:choose>	
							
								상태 입니다.</td>
						<td></td>
						<td align="left">
							
						</td>
					</tr>
					


					</c:forEach>





					<tr>
						<td colspan="11" bgcolor="D6D7D6" height="1"></td>
					</tr>
					 
					
				</table>
				
				<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 10px;">
					<tr>
						<td align="center">
						 	
						
		   					<input type="hidden" id="currentPage" name="currentPage" value="${resultPage.currentPage}"/> <!-- 애가 현재누른값을 담아서 같이보낼때 씀 --> 
							<jsp:include page="../common/pageNavigator.jsp"/>
							
						</td>
					</tr>
				</table>
				
			<!--  페이지 Navigator 끝 -->
			</form>
			
		</div>
		
	</body>
</html>












