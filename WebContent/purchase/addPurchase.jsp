<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--      
<%
	Purchase psvo = (Purchase)request.getAttribute("psvo"); 
	User uvo = (User)psvo.getBuyer();
	Product pvo = (Product)psvo.getPurchaseProd(); 
%>	 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>구매 성공</title>
</head>
<body>
  
<c:set var="uvo" value="${ psvo.buyer }"/>
<c:set var="pvo" value="${ psvo.purchaseProd }"/>
	<table width="600" border="0" cellspacing="0" cellpadding="0"	align="center" style="margin-top: 13px;">
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
		<tr>
			<td width="300" class="ct_write">
				상품번호 <img src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"/>
			</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01" width="299">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="105">${ pvo.prodNo }</td>
						 
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
	 
		<tr>
			<td width="104" class="ct_write">
				구매자아이디 <img 	src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"/>
			</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01">${ uvo.userId }</td>
			<input type="hidden" name="buyerId" value="${ uvo.userId }" />
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
		<tr>
			<td width="104" class="ct_write">구매방법</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01">${ psvo.paymentOption }</td>
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
		<tr>
			<td width="104" class="ct_write">구매자이름</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01">
				${ psvo.receiverName }
			</td>
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
		<tr>
			<td width="104" class="ct_write">구매자연락처</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01">
				${ psvo.receiverPhone }
			</td>
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
		<tr>
			<td width="104" class="ct_write">구매자주소</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01">
				${ psvo.divyAddr }
			</td>
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
		<tr>
			<td width="104" class="ct_write">구매요청사항</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td class="ct_write01">
				${ psvo.divyRequest }
			</td>
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
		<tr>
			<td width="104" class="ct_write">배송희망일자</td>
			<td bgcolor="D6D6D6" width="1"></td>
			<td width="200" class="ct_write01">
				${ psvo.divyDate }
				
			</td>
		</tr>
		<tr>
			<td height="1" colspan="3" bgcolor="D6D6D6"></td>
		</tr>
	</table>
			

</body>
</html>