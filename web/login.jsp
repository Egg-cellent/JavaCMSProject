<%-- 
    Document   : login
    Created on : Apr 19, 2023, 2:21:11 PM
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
    <style>
        .login-container{
            background-color: lightblue;
            color: green;
            padding: 2em;
            border-radius: 5%;
        }
    </style>
    <body style="min-height: 100vh; display: flex; flex-direction: column;">
        <jsp:include page="header.jsp"/>
        <h1 class="text-center">Login Form</h1>
        <div class="row">
            <div class="col-md-6" style="margin: auto;">
                <div class="login-container">
                    <form action="MainController" method="POST" class="col-md-12">
                        <div class="form-group">
                            <label for="formGroupExampleInput">Username</label>
                            <input type="text" class="form-control" name="tentk" id="formGroupExampleInput" placeholder="username" required=""/></br>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput2">Password</label>
                            <input type="password" class="form-control" name="matkhau" id="formGroupExampleInput2" placeholder="password" required=""/></br>
                        </div>
                        <div class="text-center">
                            <input type="submit" name="action" class="btn btn-lg btn-primary" value="Login"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        
        <div class="text-center text-danger">${requestScope.LOGIN_MESS}</div>
        <div style="flex-grow:1"></div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
