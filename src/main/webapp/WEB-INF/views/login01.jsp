<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>登陆界面</title>

    <script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>

    <script type="text/javascript">
                function checkform1(){
                    if(document.getElementById('inpt1').value.length==0){
                        alert('用户名不能为空！');
                        document.getElementById('ipt2').focus();
                        return false;
                    }
                    if(document.getElementById('inpt1').value=="请输入用户名"){
                        alert('用户名不能为空！');
                        document.getElementById('ipt2').focus();
                        return false;
                    }
                    if(document.getElementById('inpt2').value.length==0){
                        alert('密码不能为空！');
                        document.getElementById('ipt2').focus();
                        return false;
                    }
                    if(document.getElementById('inpt2').value=="请输入密码"){
                        alert('密码不能为空！');
                        document.getElementById('ipt2').focus();
                        return false;
                    }
                    return true;
                }
                    function checkform2(){
                        if(document.getElementById('inpt3').value.length==0){
                            alert('用户名不能为空！');
                            document.getElementById('ipt2').focus();
                            return false;
                        }
                        if(document.getElementById('inpt3').value=="请输入用户名"){
                            alert('用户名不能为空！');
                            document.getElementById('ipt2').focus();
                            return false;
                        }
                        if(document.getElementById('inpt4').value.length==0){
                            alert('密码不能为空！');
                            document.getElementById('ipt2').focus();
                            return false;
                        }
                        if(document.getElementById('inpt4').value=="请输入密码"){
                            alert('密码不能为空！');
                            document.getElementById('ipt2').focus();
                            return false;
                        }
                        return true;
                    }
    </script>

    <style>
        body{
            width: 100%;
            height:100%;
            background:url("../img/img-order/cd-hero-background.jpg") no-repeat;
            background-size: cover;
        }
    </style>

</head>
<body>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="height: 60px;">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user"></span>生产管理系统</a>
        </div>
    </div>
</nav>
<div class="container" style="width: 100%">
    <%--<img src="../img/img-order/cd-hero-background.jpg" alt="登陆"--%>
         <%--style="height :100%; width :100%; margin: 0px;padding: 0px">--%>
    <div style="position: absolute;left: 30%;top: 30%;width: 500px">
        <div class="panel-group" id="accordion">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#collapseOne">
                            <span class="glyphicon glyphicon-user"></span>登录
                        </a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <form action="login" method="post">
                            用户名：<span style="color: #cccccc">${msg}</span>
                            <input id="inpt1" name="name" class="form-control" type="text" placeholder="请输入用户名">
                            <br/>
                            密码：<span style="color: #cccccc">${msg}</span>
                            <input id="inpt2" name="password" class="form-control" type="password" placeholder="请输入密码">
                            <br/>
                            <div style="float: right">
                            <input name="rememberme" type="checkbox" ><span>记住我&nbsp;&nbsp;&nbsp;</span>
                            <input type="submit" class="btn btn-default" value="登录" style="background-color: #2e6da4;color: white" onclick="checkform1()"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#collapseTwo">
                            <span class="glyphicon glyphicon-edit"></span>注册
                        </a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse">
                    <div class="panel-body">
                        <form action="reg.action" method="post">
                            用户名：<span style="color: #cccccc">${msg}</span>
                            <input id="inpt3" name="name" class="form-control" type="text" placeholder="请输入用户名">
                            <br/>
                            密码：<span style="color: #cccccc">${msg}</span>
                            <input id="inpt4" name="password" class="form-control" type="password" placeholder="请输入密码">
                            <br/>
                            <div style="float: right">
                            <input type="submit" class="btn btn-default" value="注册" style="background-color: #2e6da4;color: white" onclick="checkform2()"/>
                    </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
