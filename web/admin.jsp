<%-- 
    Document   : newjspadmin
    Created on : Apr 23, 2023, 7:42:57 AM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/mycss.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER.nhomtk !='GD'}">
            <%
                response.sendRedirect("GetAllController");
            %>
        </c:if>
<!--        <h1 class="font-italic text-center">Xin chào ${sessionScope.LOGIN_USER.tentk}</h1>

        <div class="bg-dark py-3 pl-4"><a href="GetAllController">HOME</a></div>

        <div class="col-md-2 text-justify font-weight-bold align-middle">
            <a href="MainController?action=Logout">LOGOUT</a>
        </div>-->

        <div class="row">
            <nav class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="position:fixed; width: 20%; height:100%" id="sidebar">
                <div class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                    Dashboard
                </div>
                <a class="mx-2 my-2" href="GetAllController">Return</a>
                <ul class="nav nav-pills flex-column mb-auto">
                    <li class="nav-item active">
                        <a id="user-manage" class="nav-link" href="GetAllController2">
                            <i class="fa fa-book" aria-hidden="true"></i> 
                            <span class="menu-title">Sản phẩm</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a id="user-manage" class="nav-link" href="GetDMController">
                            <i class="fa fa-sitemap" aria-hidden="true"></i>
                            <span class="menu-title">Danh mục</span>                          
                        </a>
                    </li>
                    <li class="nav-item">
                        <a id="book-manage" class="nav-link" href="GetTaiKhoan">
                            <i class="fa fa-user" aria-hidden="true"></i>
                            <span class="menu-title">Tài khoản</span>                          
                        </a>
                    </li>
                    <li class="nav-item">
                        <a id="category-manage" class="nav-link" href="GetNhomTK">
                            <i class="fa fa-users" aria-hidden="true"></i>
                            <span class="menu-title">Nhóm tài khoản</span>
                        </a>
                    </li>
                </ul>
            </nav>
            <div style="position: fixed; width: 75%; height: 100%; right:0;">
                <h1 class="font-italic text-center">Xin chào ${sessionScope.LOGIN_USER.tentk}</h1>
                
            </div>

        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                var url = window.location.href;
                var parts = url.split('/');
                var lastPart = parts.pop() || parts.pop();
                localStorage.setItem('activeTab', lastPart);
                $('ul.nav li a').click(function () {
                    $('ul.nav li a').removeClass('active');
                    $(this).addClass('active');
                    //$(this).attr('href')
                });
                var activeTab = localStorage.getItem('activeTab');
                if (activeTab) {
                    $('ul.nav li a').removeClass('active');
                    $('ul.nav li a[href="' + activeTab + '"]').addClass('active');
                }
            });
        </script>
    </body>
</html>
