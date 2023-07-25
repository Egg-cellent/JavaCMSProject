<%-- 
    Document   : sanpham
    Created on : Apr 23, 2023, 10:32:58 AM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/mycss.css">
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
                <c:if test="${not empty requestScope.LIST_PRODUCT}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Mã sản phẩm</th>
                                <th>Tên sản phẩm</th>
                                <th>Mô tả</th>
                                <th>Số lượng</th>
                                <th>Đơn giá</th>
                                <th>Hình ảnh</th>
                                <th>Trạng thái</th>
                                <th>Mã danh mục</th>
                                <th>Xoá</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dto" varStatus="counter" items="${requestScope.LIST_PRODUCT}">
                                <c:set var="url" value="MainController?action=Delete&masp=${dto.masp}&type=sanpham"/>
                                <form action="MainController">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>
                                        ${dto.masp}
                                        <input type="hidden" value="${dto.masp}" name="masp"/>
                                    </td>
                                    <td>Edit:  <input type="text" value="${dto.tensp}" name="tensp"/></td>
                                    <td>Edit:  <input type="text" value="${dto.mota}" name="mota"/></td>
                                    <td>Edit:  <input type="text" value="${dto.soluong}" name="soluong"/></td>
                                    <td>Edit:  <input type="text" value="${dto.dongia}" name="dongia"/></td>
                                    <td> 
                                        <input type="text" value="${dto.hinhanh}" name="hinhanh"/>
                                    </td>
                                    <td>${dto.trangthai ? "Còn hàng" : "Hết hàng"}</td>
                                    <td>
                                        ${dto.madm}
                                        <input type="hidden" value="${dto.madm}" name="madm"/>
                                    </td>
                                    <td>
                                        <a href="${url}">
                                            <button class="btn-danger">Delete</button>
                                        </a>
                                    </td>
                                    <td>
                                        <input type="submit" name="action" value="Update San Pham"/>
                                        <input type="hidden" name="type" value="sanpham"/>
                                    </td>
                                </tr>
                                </form>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a href="createSp.jsp">Create new San Pham</a>
                    <hr>
                    <a href="admin.jsp">Back</a>
                </c:if>
            </div>
    <c:if test="${empty requestScope.LIST_PRODUCT}">
        <h1> No Record </h1>
    </c:if>   
    
    </div>
        <div style="flex-grow:1"></div>
        <jsp:include page="footer.jsp"/>
</body>
</html>
