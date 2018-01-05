<%-- 
    Document   : _footer
    Created on : Dec 29, 2017, 11:39:57 AM
    Author     : Admin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>






<div class="panel panel-default">
    <div class="panel-footer">

        <%
            Integer hitsCount = (Integer) application.getAttribute("hitCounter");
            if (hitsCount == null || hitsCount == 0) {
                hitsCount = 1;
            } else {
                hitsCount += 1;
            }
            application.setAttribute("hitCounter", hitsCount);
        %>

        <center>
            <p> Hotline: 01629214093</p>
            <p>Số lượng truy cập: <%= hitsCount%></p>
            <div  style="float: right">
               
            </div> 
        </center>
    </div>
</div>