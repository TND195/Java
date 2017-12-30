<%-- 
    Document   : _footer
    Created on : Dec 29, 2017, 11:39:57 AM
    Author     : Admin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
<div class="footer-container">
 
<a>demo</a>
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
</div>
