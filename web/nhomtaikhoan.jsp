<%-- 
    Document   : nhomtaikhoan
    Created on : Apr 23, 2023, 10:01:43 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/mycss.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body style="min-height: 100vh; display: flex; flex-direction: column;">
        <c:if test="${sessionScope.LOGIN_USER.nhomtk !='GD'}">
            <%
                response.sendRedirect("GetAllController");
            %>
        </c:if>
        <jsp:include page="header.jsp"/>
        <a href="admin.jsp">Back</a>

        <c:if test="${not empty requestScope.LIST_NTK}">
            <div class="tabble-responsive">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Nhom Tai Khoan</th>
                            <th>Mo ta</th>
                            <th>Trạng thái</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" varStatus="counter" items="${requestScope.LIST_NTK}">
                            <c:set var="url" value="MainController?action=Delete&madm=${dto.nhomtk}&type=nhomtaikhoan"/>

                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    ${dto.nhomtk}
                                    <input type="hidden" value="${dto.nhomtk}" name="madm"/>
                                </td>
                                <td>${dto.mota}</td>
                                <td>
                                    ${dto.trangthai}
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>

        <c:if test="${empty requestScope.LIST_NTK}">
            <h1> No Record </h1>
        </c:if>   

        <div style="flex-grow:1"></div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
