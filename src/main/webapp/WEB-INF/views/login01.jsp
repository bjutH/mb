<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>登陆界面</title>
    <link rel="stylesheet" href="../css/css-login/reset.css"/> <!-- CSS reset -->
    <link rel="stylesheet" href="../css/css-login/style.css"/> <!-- Gem style -->
    <script src="../js/js-login/modernizr.js"></script> <!-- Modernizr -->
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/js-login/main.js"></script> <!-- Gem jQuery -->
</head>
<body>
<header role="banner">
    <!--logo位置-->
    <div id="cd-logo">
        <div>
            <div style="position:absolute; z-index:2; left:53px; top:12px ;color:#d2d8d8 ">生产管理系统</div>
            <!--<img src="../static/img/img-login/cd-logo.svg" alt="Logo"></a></div>-->
            <img src="../img/img-login/cd-logo.svg" alt="Logo"></div>
    </div>
    <nav class="main-nav">
        <ul>
            <!-- inser more links here -->
            <li><a class="cd-signin" href="#0">登录</a></li>
            <li><a class="cd-signup" href="#0">注册</a></li>
        </ul>
    </nav>
</header>

<div class="cd-user-modal"> <!-- this is the entire modal form, including the background -->
    <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
        <ul class="cd-switcher">
            <li><a href="#0">登录</a></li>
            <li><a href="#0">添加用户</a></li>
        </ul>
<%--登录form--%>
        <div id="cd-login"> <!-- log in form -->
            <form class="cd-form" action="login" method="get">
                <p class="fieldset">
                    <label class="image-replace cd-email" for="signin-email">帐号</label>
                    <input name="name" class="full-width has-padding has-border" id="signin-email" type="text" placeholder="帐号">
                    <span class="cd-error-message">Error message here!</span>
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-password" for="signin-password">密码</label>
                    <input name="passward" class="full-width has-padding has-border" id="signin-password" type="text"  placeholder="密码">
                    <a href="#0" class="hide-password">隐藏</a>
                    <span class="cd-error-message">Error message here!</span>
                </p>


                <p class="fieldset">
                    <input class="full-width" type="submit" value="登录" hrf="homepage.jsp">
                </p>
            </form>

            <p class="cd-form-bottom-message"><a href="#0">忘记密码?</a></p>
            <!-- <a href="#0" class="cd-close-form">Close</a> -->
        </div> <!-- cd-login -->

        <div id="cd-signup"> <!-- sign up form -->
            <%--注册form--%>
            <form class="cd-form" action="" method="get">
                <p class="fieldset">
                    <label class="image-replace cd-username" for="signup-username">帐号</label>
                    <input class="full-width has-padding has-border" id="signup-username" type="text" placeholder="帐号">
                    <span class="cd-error-message">Error message here!</span>
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-email" for="signup-email">E-mail</label>
                    <input class="full-width has-padding has-border" id="signup-email" type="email" placeholder="E-mail">
                    <span class="cd-error-message">Error message here!</span>
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-password" for="signup-password">密码</label>
                    <input class="full-width has-padding has-border" id="signup-password" type="text"  placeholder="密码">
                    <a href="#0" class="hide-password">隐藏</a>
                    <span class="cd-error-message">Error message here!</span>
                </p>

                <p class="fieldset">
                    <input class="full-width has-padding" type="submit" value="添加用户">
                </p>
            </form>

            <!-- <a href="#0" class="cd-close-form">Close</a> -->
        </div> <!-- cd-signup -->

        <div id="cd-reset-password"> <!-- reset password form -->
            <p class="cd-form-message">Lost your password? Please enter your email address. You will receive a link to create a new password.</p>

            <form class="cd-form">
                <p class="fieldset">
                    <label class="image-replace cd-email" for="reset-email">E-mail</label>
                    <input class="full-width has-padding has-border" id="reset-email" type="email" placeholder="E-mail">
                    <span class="cd-error-message">Error message here!</span>
                </p>

                <p class="fieldset">
                    <input class="full-width has-padding" type="submit" value="Reset password">
                </p>
            </form>

            <p class="cd-form-bottom-message"><a href="#0">Back to log-in</a></p>
        </div> <!-- cd-reset-password -->
        <a href="#0" class="cd-close-form">Close</a>
    </div> <!-- cd-user-modal-container -->
</div> <!-- cd-user-modal -->
<div align="center">
    <!--<img src="../static/img/img-order/cd-hero-background.jpg" alt="登陆" style="height :100%; width :100%; margin-top: 0px;">-->
    <img src="../img/img-order/cd-hero-background.jpg" alt="登陆" style="height :100%; width :100%; margin-top: 0px;">
</div>
</body>
</html>
