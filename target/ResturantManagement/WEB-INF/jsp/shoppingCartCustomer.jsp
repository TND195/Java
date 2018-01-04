<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Enter Customer Information</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
<jsp:include page="_header.jsp" />
 

 

<div class="container">
    <div class="row">

 <form:form method="POST" modelAttribute="customerForm"
       action="${pageContext.request.contextPath}/shoppingCartCustomer">
  <fieldset>
    <legend>Thông tin khách hàng</legend>
 
    <div class="form-group">
      <label for="exampleInputEmail1">Tên *</label>
      <form:input path="name" class="form-control" />
      <form:errors path="name" class="error-message" />
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Số điện thoại *</label>
      <form:input path="phone" class="form-control" />
               <form:errors path="phone" class="error-message" />
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Địa chỉ *</label>
       <form:input path="address" class="form-control" />
      <form:errors path="address" class="error-message" />
    </div>
    <button type="submit" class="btn btn-primary" style="margin-bottom: 15px">Submit</button>
  </fieldset>
  </form:form>
        </div>
     <jsp:include page="_footer.jsp" />
         </div>




  
 
 
  
 
 
</body>
</html>