<%-- 
    Document   : shoppingCart
    Created on : Dec 29, 2017, 11:44:27 AM
    Author     : Admin
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Shopping Cart</title>
 
</head>
<body>
   <jsp:include page="_header.jsp" />
 
 

 <div class="container">
    <div class="row">
        <div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Giỏ hàng</div>

	<!-- Table -->
	<table class="table">
		<thead>
		</thead>
		<tbody>
                  
   <c:if test="${empty cartForm or empty cartForm.cartLines}">
       <h2>There is no items in Cart</h2>
       <a href="${pageContext.request.contextPath}/productList">Show
           Product List</a>
   </c:if>
 
   <c:if test="${not empty cartForm and not empty cartForm.cartLines   }">
       <form:form method="POST" modelAttribute="cartForm"
           action="${pageContext.request.contextPath}/shoppingCart">
 
           <c:forEach items="${cartForm.cartLines}" var="cartLineInfo"
               varStatus="varStatus">
                <tr>
               <td>
                
                       <img class="product-image" style="width:170px;height:170px;margin-right:20px; float: left;"
                             src="${cartLineInfo.dishInfo.img_url}" />
   <ul>
                       <li>Id: ${cartLineInfo.dishInfo.id} <form:hidden
                               path="cartLines[${varStatus.index}].dishInfo.id" />
 
                       </li>
                       <li>Name: ${cartLineInfo.dishInfo.name}</li>
                       <li>Price: <span class="price">
                      
                         <fmt:formatNumber value="${cartLineInfo.dishInfo.price}" type="currency"/>
                        
                       </span></li
                       <li>Quantity: <form:input 
                               path="cartLines[${varStatus.index}].quantity" /></li>
                       <li>Subtotal:
                         <span class="subtotal">
                        
                            <fmt:formatNumber value="${cartLineInfo.amount}" type="currency"/>
                      
                         </span>
                       </li>
                       <li><a
                           href="${pageContext.request.contextPath}/shoppingCartRemoveProduct?id=${cartLineInfo.dishInfo.id}">
                               Delete </a></li>
                   </ul>
                                </tr>
               </td>  
           </c:forEach>
                  
                    <td>
           <input class="btn btn-primary" type="submit" value="Cập nhật" />
           <a class="navi-item"
               href="${pageContext.request.contextPath}/shoppingCartCustomer">Điền thông tin</a>
               | 
           <a class="navi-item"
               href="${pageContext.request.contextPath}/productList">Tiếp tục mua hàng</a>
                    </td>
               </tr>
       </form:form>
 
 
   </c:if>
 </tbody>
	</table>
</div>
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>
