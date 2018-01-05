<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">

        <title>Xác nhận đơn hàng</title>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">

    </head>
    <body>
        <jsp:include page="_header.jsp" />


        <div class="container">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">Thông tin khách hàng</div>

                    <table class="table">
                        <tbody>

                            <tr>


                                <td>
                                    <ul>
                                        <li>Tên: ${myCart.customerInfo.name}</li>

                                        <li>Điện thoại: ${myCart.customerInfo.phone}</li>
                                        <li>Địa chỉ: ${myCart.customerInfo.address}</li>

                                    </ul></td>
</tr>

<tr>
                                <td>
                                   <div class="panel-heading">Hóa đơn</div>
                                    <ul>
                                        <li>Quantity: ${myCart.quantityTotal}</li>
                                        <li>Total:
                                           
                                                <fmt:formatNumber value="${myCart.amountTotal}" type = "number" maxFractionDigits = "3"/> VND
                                            </li>
                                    </ul>
                                </td>
</tr>
                        </tbody>
                    </table>
                </div>

               

                 <div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Giỏ hàng</div>
<table class="table">
		<thead>
		</thead>
		<tbody>
                    <c:forEach items="${myCart.cartLines}" var="cartLineInfo">
                        <tr>
               <td>
                        <div class="product-preview-container">
                             <img class="product-image" style="width:170px;height:170px;margin-right:20px; float: left;"
                             src="${cartLineInfo.dishInfo.img_url}" />
                        <ul>
                                <li>Code: ${cartLineInfo.dishInfo.id} <input
                                        type="hidden" name="code" value="${cartLineInfo.dishInfo.id}" />
                                </li>
                                <li>Name: ${cartLineInfo.dishInfo.name}</li>
                                <li>Price: <span class="price">
                                        <fmt:formatNumber value="${cartLineInfo.dishInfo.price}" type="currency"/>
                                    </span>
                                </li>
                                <li>Quantity: ${cartLineInfo.quantity}</li>
                                <li>Subtotal:
                                    <span class="subtotal">
                                        <fmt:formatNumber value="${cartLineInfo.amount}" type="currency"/>
                                    </span>
                                </li>
                            </ul>
                        </div>
               </td>
                        </tr>
                    </c:forEach>
                </tbody>
</table>
                 </div>
                                            
                                             <form method="POST"
                      action="${pageContext.request.contextPath}/shoppingCartConfirmation">

                    <!-- Edit Cart -->
                    <a class="navi-item"
                       href="${pageContext.request.contextPath}/shoppingCart">Chỉnh sửa giỏ hàng</a>

                    <!-- Edit Customer Info -->
                    <a class="navi-item"
                       href="${pageContext.request.contextPath}/shoppingCartCustomer">Chỉnh sửa thông tin</a>

                    <!-- Send/Save -->
                    <input type="submit" value="Gửi" class="btn btn-primary" />
                </form>
                           <jsp:include page="_footer.jsp" />
            </div>

         


    </body>
</html>