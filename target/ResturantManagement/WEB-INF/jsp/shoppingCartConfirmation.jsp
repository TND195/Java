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

<form method="POST"
                      action="${pageContext.request.contextPath}/shoppingCartConfirmation">
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
<tr class="active">   <td>   Hóa đơn   </td>                          
</tr>
<tr>
                                <td>
                                    <ul>
                                        <li>Số lượng: ${myCart.quantityTotal}</li>
                                        <li>Tổng:
                                           
                                                <fmt:formatNumber value="${myCart.amountTotal}" type = "number" maxFractionDigits = "3"/> VND
                                            </li>
                                    </ul>
                                </td>
</tr>
                        </tbody>
                    </table>
                </div>

                <input style="margin-bottom: 20px;" type="submit" value="Gửi" class="btn btn-primary" />

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
                                <li>Mã: ${cartLineInfo.dishInfo.id} <input
                                        type="hidden" name="code" value="${cartLineInfo.dishInfo.id}" />
                                </li>
                                <li>Tên: ${cartLineInfo.dishInfo.name}</li>
                                <li>Giá: <span class="price">
                                         <fmt:formatNumber value="${cartLineInfo.dishInfo.price}" type = "number" maxFractionDigits = "3"/> VND
                                        
                                    </span>
                                </li>
                                <li>số lượng: ${cartLineInfo.quantity}</li>
                                <li>Tổng:
                                    <span class="subtotal">
                                          <fmt:formatNumber value="${cartLineInfo.amount}" type = "number" maxFractionDigits = "3"/> VND
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
                                            
                                             

                    <!-- Edit Cart -->
                    <a class="navi-item"
                       href="${pageContext.request.contextPath}/shoppingCart">Chỉnh sửa giỏ hàng</a> |

                    <!-- Edit Customer Info -->
                    <a class="navi-item"
                       href="${pageContext.request.contextPath}/shoppingCartCustomer">Chỉnh sửa thông tin</a> | 

                    <!-- Send/Save -->
                   
                </form>
                           <jsp:include page="_footer.jsp" />
            </div>

         


    </body>
</html>