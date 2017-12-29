<%-- 
    Document   : index
    Created on : Dec 29, 2017, 11:49:41 AM
    Author     : Admin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import = "java.io.*,java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <div class="page-title">Demo</div>

        <div class="demo-container">
            <h3>Demo content</h3>
        </div>
        <c:forEach items="${listDish}" var="dishInfo">
            <div class="product-preview-container">
                <ul>
                    <li><img class="product-image"
                             src="${dishInfo.img_url}" /></li>
                    <li>Code: ${dishInfo.id}</li>
                    <li>Name: ${dishInfo.name}</li>
                    <li>Description: ${dishInfo.description}</li>
                    <li>Price: <fmt:formatNumber value="${dishInfo.price}" type="currency"/></li>
                    <li><a
                            href="${pageContext.request.contextPath}/buyProduct?id=${dishInfo.id}">
                            Buy Now</a></li>
                </ul>
            </div>

        </c:forEach>
         <%
         Integer hitsCount = (Integer)application.getAttribute("hitCounter");
         if( hitsCount ==null || hitsCount == 0 ) {
            hitsCount = 1;
         } else {
            hitsCount += 1;
         }
         application.setAttribute("hitCounter", hitsCount);
      %>
      <center>
         <p>Total number of visits: <%= hitsCount%></p>
      </center>
        <div class="fb-like" data-href="https://www.facebook.com/&#x110;&#x1ed3;-&#x103;n-137279583619818/" data-width="12" data-layout="box_count" data-action="like" data-size="large" data-show-faces="true" data-share="true"></div>
        <jsp:include page="_footer.jsp" />

    </body>
</html>
