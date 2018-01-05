<%-- 
    Document   : _header
    Created on : Dec 29, 2017, 12:04:48 PM
    Author     : Admin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <style type="text/css">
        .example{
            margin: 5px;
        }
    </style>
</head>


<body>
    
    
    
    
    
    <div class="example">
        <div id="header">
            <nav class="navbar navbar-inverse">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" >
                        <span class="sr-only">Shop bán đồ ăn</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="${pageContext.request.contextPath}" class="navbar-brand">Shop bán đồ ăn</a>
                </div>

                <div class="navbar-collapse collapse" id="menu">
                    <ul class="nav navbar-nav">
                        <li><a href="${pageContext.request.contextPath}/productList">
                                Danh sách món ăn
                            </a></li>
                        <li> <a href="${pageContext.request.contextPath}/shoppingCart">
                                Giỏ hàng 
                            </a></li>
                        <li><a href="${pageContext.request.contextPath}/branch">
                                Chi Nhánh
                            </a></li>
                            <li><a href="${pageContext.request.contextPath}/info">
                                Giới thiệu
                            </a></li>
                            <li><a href="${pageContext.request.contextPath}/history">
                                Lịch sử
                            </a></li>
                    </ul>
                                   <form class="form-inline">
      <input id="search" class="form-control" type="text" placeholder="Search">
      <input type="button" onclick="myFunction()"  class="btn btn-secondary" value="Search">
    </form>
                </div>
            </nav>
        </div>
    </div>
</body>
<div id="fb-root"></div>
<script>(function (d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id))
            return;
        js = d.createElement(s);
        js.id = id;
        js.src = 'https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.11&appId=1293367300706393';
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
    
    function myFunction() {
       var search = document.getElementById("search").value;
        window.location.href = '${pageContext.request.contextPath}/productList?name=' + search;

 
}
    </script>