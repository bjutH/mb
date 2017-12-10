<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <meta charset="UTF-8"/>
    <title>主页</title>
    <script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>

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
<%@include file="head.jsp" %>
<div class="panel panel-default" style="height: 40%;width: 97%;margin: 0 auto;">
    <div class="panel-heading">
        <h3 class="panel-title">
            当前用户信息
        </h3>
    </div>
    <div class="panel-body">
        内容
    </div>
</div>
<div style="position: relative;left: 1.5%;top: 1.5%">
    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">修改密码</button>
    <form action="homepage/logout" method="get">
    <button type="submit" class="btn btn-warning btn-lg">退出登录</button>
    </form>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="/homepage/logout" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改密码
                </h4>
            </div>
            <form class="form-inline" role="form" action="/homepage/updatepassword" method="post">
                <div class="modal-body">
                    原始密码：<input type="text" name="oldPassword" class="form-control" placeholder="请输入原密码">
                    <br/>
                    修改密码：<input type="text" name="newPassword" class="form-control" placeholder="请输入新密码">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">提交更改</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
