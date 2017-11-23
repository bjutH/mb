<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>登陆界面</title>
    <link rel="stylesheet" href="../css/css-login/reset.css"/> <!-- CSS reset -->
    <link rel="stylesheet" href="../css/css-login/style.css"/> <!-- Gem style -->
    <%--<script src="../js/js-login/modernizr.js"></script> <!-- Modernizr -->--%>
    <script src="../js/jquery-3.2.1.min.js"></script>
    <%--<script src="../js/js-login/main.js"></script> <!-- Gem jQuery -->--%>
    <style type="text/css">
        .form-bg{
            padding: 2em 0;
        }
        .form-horizontal{
            background: #fff;
            padding-bottom: 40px;
            border-radius: 15px;
            text-align: center;
        }
        .form-horizontal .heading{
            display: block;
            font-size: 35px;
            font-weight: 700;
            padding: 35px 0;
            border-bottom: 1px solid #f0f0f0;
            margin-bottom: 30px;
        }
        .form-horizontal .form-group{
            padding: 0 40px;
            margin: 0 0 25px 0;
            position: relative;
        }
        .form-horizontal .form-control{
            background: #f0f0f0;
            border: none;
            border-radius: 20px;
            box-shadow: none;
            padding: 0 20px 0 45px;
            height: 40px;
            transition: all 0.3s ease 0s;
        }
        .form-horizontal .form-control:focus{
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }
        .form-horizontal .form-group i{
            position: absolute;
            top: 12px;
            left: 60px;
            font-size: 17px;
            color: #c8c8c8;
            transition : all 0.5s ease 0s;
        }
        .form-horizontal .form-control:focus + i{
            color: #00b4ef;
        }
        .form-horizontal .fa-question-circle{
            display: inline-block;
            position: absolute;
            top: 12px;
            right: 60px;
            font-size: 20px;
            color: #808080;
            transition: all 0.5s ease 0s;
        }
        .form-horizontal .fa-question-circle:hover{
            color: #000;
        }
        .form-horizontal .main-checkbox{
            float: left;
            width: 20px;
            height: 20px;
            background: #11a3fc;
            border-radius: 50%;
            position: relative;
            margin: 5px 0 0 5px;
            border: 1px solid #11a3fc;
        }
        .form-horizontal .main-checkbox label{
            width: 20px;
            height: 20px;
            position: absolute;
            top: 0;
            left: 0;
            cursor: pointer;
        }
        .form-horizontal .main-checkbox label:after{
            content: "";
            width: 10px;
            height: 5px;
            position: absolute;
            top: 5px;
            left: 4px;
            border: 3px solid #fff;
            border-top: none;
            border-right: none;
            background: transparent;
            opacity: 0;
            -webkit-transform: rotate(-45deg);
            transform: rotate(-45deg);
        }
        .form-horizontal .main-checkbox input[type=checkbox]{
            visibility: hidden;
        }
        .form-horizontal .main-checkbox input[type=checkbox]:checked + label:after{
            opacity: 1;
        }
        .form-horizontal .text{
            float: left;
            margin-left: 7px;
            line-height: 20px;
            padding-top: 5px;
            text-transform: capitalize;
        }
        .form-horizontal .btn{
            float: right;
            font-size: 14px;
            color: #fff;
            background: #00b4ef;
            border-radius: 30px;
            padding: 10px 25px;
            border: none;
            text-transform: capitalize;
            transition: all 0.5s ease 0s;
        }
        @media only screen and (max-width: 479px){
            .form-horizontal .form-group{
                padding: 0 25px;
            }
            .form-horizontal .form-group i{
                left: 45px;
            }
            .form-horizontal .btn{
                padding: 10px 20px;
            }
        }
    </style></head>
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

<%--<div class="cd-user-modal"> <!-- this is the entire modal form, including the background -->--%>
    <%--<div class="cd-user-modal-container"> <!-- this is the container wrapper -->--%>
        <%--<ul class="cd-switcher">--%>
            <%--<li><a href="#0">登录</a></li>--%>
            <%--<li><a href="#0">添加用户</a></li>--%>
        <%--</ul>--%>
<%--登录form--%>
        <%--<div id="cd-login" style="display: block"> <!-- log in form -->--%>

            <div class="demo form-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-md-offset-3 col-md-6">
                            <form action="homepage.action" method="get" class="form-horizontal">
                                <span class="heading">登录</span>
                                <div class="form-group">
                                    <input name="name" type="text" class="form-control" id="inputEmail3" placeholder="账户">
                                    <i class="fa fa-user"></i>
                                </div>
                                <div class="form-group help">
                                    <input name="password" type="password" class="form-control" id="inputPassword3" placeholder="密码">
                                    <i class="fa fa-lock"></i>
                                    <a href="#" class="fa fa-question-circle"></a>
                                </div>
                                <div class="form-group">
                                    <input type="submit" class="btn btn-default" value="登录"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>





            <%--<form class="cd-form" action="login" method="get">--%>
                <%--<p class="fieldset">--%>
                    <%--<label class="image-replace cd-email" for="signin-email">帐号</label>--%>
                    <%--<input name="name" class="full-width has-padding has-border" id="signin-email" type="text" placeholder="帐号">--%>
                    <%--<span class="cd-error-message">Error message here!</span>--%>
                <%--</p>--%>

                <%--<p class="fieldset">--%>
                    <%--<label class="image-replace cd-password" for="signin-password">密码</label>--%>
                    <%--<input name="password" class="full-width has-padding has-border" id="signin-password" type="text"  placeholder="密码">--%>
                    <%--<a href="#0" class="hide-password">隐藏</a>--%>
                    <%--<span class="cd-error-message">Error message here!</span>--%>
                <%--</p>--%>


                <%--<p class="fieldset">--%>
                    <%--<input class="full-width" type="submit" value="登录" hrf="homepage">--%>
                <%--</p>--%>
            <%--</form>--%>

            <%--<p class="cd-form-bottom-message"><a href="#0">忘记密码?</a></p>--%>
            <!-- <a href="#0" class="cd-close-form">Close</a> -->

 <!-- cd-signup -->

 <!-- cd-reset-password -->
        <a href="#0" class="cd-close-form">Close</a>
    <%--</div> <!-- cd-user-modal-container -->--%>
<%--</div> <!-- cd-user-modal -->--%>
<div align="center">
    <!--<img src="../static/img/img-order/cd-hero-background.jpg" alt="登陆" style="height :100%; width :100%; margin-top: 0px;">-->
    <img src="../img/img-order/cd-hero-background.jpg" alt="登陆" style="height :100%; width :100%; margin-top: 0px;">
</div>
</body>
</html>
