<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/login.css">
        <title>Đăng nhập</title>
    </head>

    <body>
        <!-- Header -->
        <jsp:include page="header.jsp" />

        <!-- Nội dung đăng nhập -->
        <div class="container">
            <div class="form-container sign-in-container">
                <!-- Form đăng nhập -->
                <form action="login" method="post">
                    <h1>Đăng nhập</h1>
                    <input type="email" name="email" placeholder="Email" required />
                    <input type="password" name="password" placeholder="Mật khẩu" required />

                    <c:if test="${not empty message}">
                        <div class="error-message">${message}</div>
                    </c:if>

                    <button type="submit">Đăng nhập</button> <br>  <%-- Thêm <br> để xuống dòng --%>
                    <a href="#" class="forgot-password">Quên mật khẩu?</a> <%-- Thêm class "forgot-password" --%>
                </form>

                <!-- Nút Sign In nếu người dùng chưa có tài khoản -->
                <div class="text-center">
                    <p>Chưa có tài khoản? <a href="register.jsp" class="sign-in-button">Đăng ký</a></p>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <jsp:include page="footer.jsp" />

        <!-- Script JS (nếu có) -->
        <script src="LoginForm.js"></script>
    </body>

</html>
