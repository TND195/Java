<%-- 
    Document   : shoppingCart
    Created on : Dec 29, 2017, 11:44:27 AM
    Author     : Admin
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Shopping Cart</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
   <jsp:include page="_header.jsp" />
  
   <jsp:include page="_menu.jsp" />
  
   <fmt:setLocale value="en_US" scope="session"/>
 
   <div class="page-title">History</div>

 
 
 
           <c:forEach items="${listHistory.orderDetailInfos}" var="historyInfo" varStatus="index">
               <div class="product-preview-container">
                   <ul>
                       <li>dish -id :${historyInfo.dish_id}
                       </li>
                       <li>dish -qua :${historyInfo.quantity}
                       </li>
                       
                        <li>dish -pri :${historyInfo.price}
                       </li>
                   </ul>
               </div>
           </c:forEach>
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>
