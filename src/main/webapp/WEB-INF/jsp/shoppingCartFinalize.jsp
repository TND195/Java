<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Cảm ơn</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
   <jsp:include page="_header.jsp" />
        <div class="container">
            <div class="row">
                <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading">Kết thúc mua hàng</div>

                    <!-- Table -->
                    <table class="table">

                        <tbody>
                            <tr>
                                <td>Cảm ơn bạn đã mua hàng</td>
                            </tr>
                        </tbody></table>
                </div>
            </div>
              <jsp:include page="_footer.jsp" />
        </div>
</body>
</html>