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

        <title>Lịch sử mua hàng</title>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">

    </head>
    <body>
        <jsp:include page="_header.jsp" />


        <fmt:setLocale value="en_US" scope="session"/>


        <div class="container">
            <div class="row">
                <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading">Lịch sử mua hàng</div>
                    
                       <c:if test="${empty listHistory}">
       <h2 style="text-align: center">Không có lịch sử mua hàng</h2>
   </c:if>
                     <c:if test="${not empty listHistory}">
                    <table class="table">
                        <c:forEach items="${listHistory}" var="listHistoryInfo" >


                            <tbody>
                                <c:if test="${listHistoryInfo.status == 0}" >
                                <tr class="warning">
                                    <td>
                                Ngày: ${listHistoryInfo.create_at} , Id:
                                ${listHistoryInfo.id},Tổng cộng:<fmt:formatNumber value="${listHistoryInfo.amount}" type = "number" 
         maxFractionDigits = "3"/>VND, Trạng thái: Chưa thanh toán
                                
                                    </td>
                                    </c:if> 
                                     <c:if test="${listHistoryInfo.status != 0}" >
                                <tr class="active">
                                    <td>
                                Ngày: ${listHistoryInfo.create_at} , Id:
                                ${listHistoryInfo.id},,Tổng cộng:<fmt:formatNumber value="${listHistoryInfo.amount}" type = "number" 
         maxFractionDigits = "3"/>VND, Trạng thái: Đã thanh toán
                                
                                    </td>
                                    </c:if> 
                                </tr>
                                <c:forEach items="${listHistoryInfo.orderDetailInfos}" var="orderDetailInfo" >
                                    <tr>
                                        <td>
                                            <img class="product-image" style="width:170px;height:170px;margin-right:20px; float: left;"
                                                 src="${orderDetailInfo.dish_img_url}" />
                                            <ul>
                                                <li>Mã: ${orderDetailInfo.dish_id}</li>
                                                <li>Tên: ${orderDetailInfo.dish_name}</li>
                                                <li>Mô tả: ${orderDetailInfo.dish_description}</li>
                                                <li>Số lượng: ${orderDetailInfo.quantity}</li>
                                                <li>Giá:<fmt:formatNumber value="${orderDetailInfo.dish_price}" type = "number" 
         maxFractionDigits = "3"/>VND</li>
                                                <li>Tổng cộng: <fmt:formatNumber value="${orderDetailInfo.price}" type = "number" 
         maxFractionDigits = "3"/> VND</li>


                                            </ul>
                                        </td>
                                    </tr>

                                </c:forEach>
                            </tbody>
                        </c:forEach>
                    </table>
                     </c:if>
                </div>
            </div>
            <jsp:include page="_footer.jsp" />
        </div>


    </body>
</html>