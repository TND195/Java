<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
 
   <jsp:include page="_header.jsp" />
 
 
           <div class="container">
    <div class="row">
        <div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Danh sách món ăn</div>

	<!-- Table -->
	<table class="table">
		<thead>
		</thead>
		<tbody>
           <tr>
               <td>
         <c:forEach items="${paginationDish.list}" var="dishInfo">
       <div class="product-preview-container">
            <tr>
               <td>
             
                    <img class="product-image" style="width:170px;height:170px;margin-right:20px; float: left;"
                             src="${dishInfo.img_url}" />
                       <ul>
                    <li>Code: ${dishInfo.id}</li>
                    <li>Name: ${dishInfo.name}</li>
                    <li>Description: ${dishInfo.description}</li>
                    <li>Price: <fmt:formatNumber value="${dishInfo.price}" type="currency"/></li>
                    <li><a
                            href="${pageContext.request.contextPath}/buyProduct?id=${dishInfo.id}">
                            Buy Now</a></li>
                </ul>
               </td>
             
                </tr>
       </div>
 
   </c:forEach>
           <tr>
               <td>
                   <div>
  <ul class="pagination">
    
   
       <c:if test="${paginationDish.totalPages > 1}">
           
          <c:forEach items="${paginationDish.navigationPages}" var = "page">
               <li class="page-item">
              <c:if test="${page != -1 }">
                <a href="productList?page=${page}" class="nav-item">${page}</a>
              </c:if>
              <c:if test="${page == -1 }">
                <span class="nav-item"> ... </span>
              </c:if>
                 </li>
          </c:forEach>
   
    
  </ul>
</div>

                   
                   
                   
                   
                 
          
       </div>
   </c:if></td>
           </tr>
   		</tbody>
	</table>
</div>
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>