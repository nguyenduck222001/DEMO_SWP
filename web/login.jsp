<%-- 
    Document   : adminlogin
    Created on : Jan 12, 2025, 10:21:52 PM
    Author     : ADMIN
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">


    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Custom Style Sheet  -->
        <link rel="stylesheet"  href="css/style.css">
        <title>Login</title>
    </head>

    <body>
        <jsp:include page="header.jsp" />
        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form action="#">
                    <h1> Create Account</h1>
                    <div class="social-container">
                        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>

                    </div>
                    <span>Or use your email for registration </span>
                    <input type="text" placeholder="Name">
                    <input type="email" placeholder="Email">
                    <input type="password" placeholder="Password">
                    <button>Sign  Up</button>




                </form>

            </div>
            <div class="form-container sign-in-container">
                <form action="login" method="post">
                    <h1> Login</h1>
                    <div class="social-container">
                        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <span>Or use your Account </span>
                    <input type="email" placeholder="Email">
                    <input type="password" placeholder="Password">
                    <a href="#">Forget Password ?</a>
                    <button>Login</button>
                </form>

            </div>
            <div class="overlay-container">
                <div class="overly">
                    <div class="overly-panel overlay-left">
                        <h1>Welcome back !</h1>
                        <p>To keep connected with us please login with your personal info</p>
                        <buttonc class="ghost" id="signUp">Sign in</buttonc>
                    </div>  
                    <div class="overly-panel overlay-right">
                        <h1>CBD Cinema</h1>
                        <p>Enter you personal details and start your journey with us</p>
                        <button class="ghost" id="signUp">Sign In</button>
                    </div>
                </div>
            </div>

        </div>
        <!-- Add Javascrip file -->
        <script src="LoginForm.js"></script>
    </body>
    <jsp:include page="footer.jsp" />
</html>
