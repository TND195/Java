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

        <title>Quán ăn</title>


    </head>
    <body>


        <jsp:include page="_header.jsp" />

        <div class="container">
            <div class="row">
                <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading">Danh sách chi nhánh</div>

                    <!-- Table -->
                    <table class="table">
                        <thead>
                        </thead>
                        <tbody>

                            <c:forEach items="${listBranch}" var="branchInfo">
                                <tr>
                                    <td>

                                        <ul>


                                            <li>Name: ${branchInfo.name}</li>  
                                            <li>Code: ${branchInfo.address}</li>


                                        </ul>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>

        <jsp:include page="_footer.jsp" />
        </div>
    </body>
</html>
