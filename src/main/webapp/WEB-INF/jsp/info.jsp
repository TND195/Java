<%-- 
    Document   : info
    Created on : Jan 4, 2018, 11:03:43 PM
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

        <title>Thông tin Quán ăn</title>


    </head>
    <body>


        <jsp:include page="_header.jsp" />
        <div class="container">
            <div class="row">
                <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading">Danh sách bán chạy</div>

                    <!-- Table -->
                    <table class="table">
                        <tbody>
                            <tr>
                                <td style="text-align: center">Trang web bán đồ ăn online</td>
                            </tr>
                        </tbody></table>
                </div>
            </div>
              <jsp:include page="_footer.jsp" />
        </div>
    </body>