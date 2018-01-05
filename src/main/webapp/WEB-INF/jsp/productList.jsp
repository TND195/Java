<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Danh sách món ăn</title>

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
                                                        <li>Mã: ${dishInfo.id}</li>
                                                        <li>Tên: ${dishInfo.name}</li>
                                                        <li>Mô tả: ${dishInfo.description}</li>
                                                        <li>Giá: <fmt:formatNumber value="${dishInfo.price}" type = "number" 
         maxFractionDigits = "3"/> VND</li>
                                                        <li><a
                                                                href="${pageContext.request.contextPath}/buyProduct?id=${dishInfo.id}">
                                                                Mua ngay</a></li>
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
                                                    <c:choose>
                                                        <c:when test="${page == param.page || (empty param.page && page ==1)}">

                                                            <li class="page-item active">
                                                            </c:when>    
                                                            <c:otherwise>
                                                            <li class="page-item">
                                                            </c:otherwise>
                                                        </c:choose>
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