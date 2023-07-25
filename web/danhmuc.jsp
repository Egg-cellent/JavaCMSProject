<%-- 
    Document   : danhmuc
    Created on : Apr 23, 2023, 10:32:45 AM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh Muc Page</title>
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
        <div class="row">

            <div class="col-md-12">
                <c:if test="${not empty requestScope.LIST_DM}">
                    <div class="tabble-responsive">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Mã danh mục</th>
                                    <th>Tên danh mục</th>
                                    <th>Trạng thái</th>
                                    <th>Xoá</th>
                                    <th>Update</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="dto" varStatus="counter" items="${requestScope.LIST_DM}">
                                    <c:set var="url" value="MainController?action=Delete&madm=${dto.madm}&type=danhmuc"/>

                                <form action="MainController">
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>
                                            ${dto.madm}
                                            <input type="hidden" value="${dto.madm}" name="madm"/>
                                        </td>
                                        <td>Edit:  <input type="text" value="${dto.tendm}" name="tendm"/></td>
                                        <td>
                                            ${dto.trangthai}
                                        </td>
                                        <td>
                                            <a href="${url}">
                                            <button class="btn-danger">Delete</button>
                                        </a>
                                        </td>
                                        <td>
                                            <input type="submit" name="action" value="Update"/>
                                            <input type="hidden" name="type" value="danhmuc"/>
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                            </tbody>
                        </table>
                        <a href="createDm.jsp">Create new Danh muc</a>
                        <hr>
                        <a href="admin.jsp">Back</a>
                    </div>
                </c:if>
            </div>
            <c:if test="${empty requestScope.LIST_DM}">
                <h1> No Record </h1>
            </c:if>   
        </div>
        <div style="flex-grow:1"></div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
