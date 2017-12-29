<%-- 
    Document   : index
    Created on : Dec 29, 2017, 11:49:41 AM
    Author     : Admin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Books Shop Online</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
 
 
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
 
   <div class="page-title">Shopping Cart Demo</div>
  
   <div class="demo-container">
   <h3>Demo content</h3>
  
   </div>
  <c:forEach items="${listBranch}" var="branchInfo">
       <div class="product-preview-container">
           <ul>
               
            
               <li>Name: ${branchInfo.name}</li>  
               <li>Code: ${branchInfo.address}</li>
               
 
           </ul>
       </div>
 
   </c:forEach>
  
   <jsp:include page="_footer.jsp" />
 
</body>
</html>
