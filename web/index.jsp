<%-- 
    Document   : index
    Created on : Apr 19, 2023, 2:20:47 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CMS Project</title>
        <link rel="stylesheet" href="css/mycss.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <style>
        .card{
            border: 2px solid black;
        }
    </style>
    <body class="container-fluid">
        <jsp:include page="header.jsp"/>
        
        <div class="row header bg-dark my-4">
            <div class="col-md-5 py-3 pl-5">
                <form action="MainController">
                    <input type="text" name="search" value="${param.search}" placeholder="Tên sản phẩm"/>
                    <input type="submit" name="action" value="Search"/>
                </form>
            </div>
            
            <div class="col-md-5 py-3 pl-5">
                <form action="MainController">
                    <span class="text-light">Filter </span>
                    <select class="danhmuc" name="danhmuc">
                        <option value="DM1" selected>DAIRY</option>
                        <option value="DM2" >LAUNDRY</option>
                        <option value="DM3" >VEGETABLE</option>
                        <option value="DM4" >MEAT</option>
                    </select>
                <input type="submit" name="action" value="SearchDM"/>
                </form>
            </div>
                    
            <div class="col-md-2 text-justify font-weight-bold align-middle">               
                <c:if test="${not empty sessionScope.LOGIN_USER.tentk}">
                    <p class="font-italic text-light">${sessionScope.LOGIN_USER.tentk}</p>
                    <c:if test="${sessionScope.LOGIN_USER.nhomtk =='GD'}">
                        <a href="admin.jsp">ADMIN PAGE </a> 
                    </c:if>
                    | <a href="MainController?action=Logout">LOGOUT</a>
                </c:if>
                 
                <c:if test="${empty sessionScope.LOGIN_USER.tentk}">
                    <a href="login.jsp">LOGIN </a> 
                </c:if>
            </div>
        </div>

        
       


        <c:if test="${not empty requestScope.LIST_PRODUCT}">
            <div class="row">
                <c:forEach var="dto" varStatus="counter" items="${requestScope.LIST_PRODUCT}">
                    <div class="col-md-3 col-sm-4" style="margin: auto;">
                        <div class="card my-3" style="width: 18rem;">
                            <img alt="Image not exist" class="card-img-top mg-responsive" style="width: 270px; max-height: 200px;" src="${dto.hinhanh}">
                            <div class="card-body">
                                <h5 class="card-title">${dto.tensp}</h5>
                                <p class="card-text">${dto.mota}</p>
                                <p class="card-text">${dto.trangthai ? "Còn hàng" : "Hết hàng"}</p>
                                <p class="card-text">VND: ${dto.dongia}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </c:if>

        <c:if test="${not empty param.search}">
            <c:if test="${empty requestScope.LIST_PRODUCT}">
                <h1> No Record </h1>
            </c:if>
        </c:if>
    <jsp:include page="footer.jsp"/>
    <script src="js/myscript.js"></script>
<!--    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-->
</body>
</html>
