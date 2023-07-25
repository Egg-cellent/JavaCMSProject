<%-- 
    Document   : createSp
    Created on : Apr 23, 2023, 4:15:19 PM
    Author     : user
--%>

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
       <jsp:include page="header.jsp"/>
        <div class="text-center pt-5 form">
            <h1>Create Form</h1>
            <form action="MainController">
                Ma San Pham: <input type="text" name="masp" required=""/> <br>
                Ten San Pham: <input type="text" name="tensp" required=""/> <br>
                Mo ta: <input type="text" name="mota" required=""/> <br>
                So luong: <input type="text" name="soluong" required=""/> <br>
                Don gia: <input type="text" name="dongia" required=""/> <br>
                Hinh anh: <input type="text" name="hinhanh" required=""/> <br>
                Trang thai: <input type="text" name="trangthai" required=""/> <br>
                Ma danh muc: <input type="text" name="madm" required=""/> <br>
                
                <input type="hidden" name="type" value="sanpham"/>
                <input type="submit" name="action" value="Create San Pham" />
            </form>
        </div>
        <div style="flex-grow:1"></div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
