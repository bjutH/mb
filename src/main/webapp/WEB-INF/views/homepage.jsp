<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人主页</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link rel="stylesheet" type="text/css"  href="../css/css-order/style.css"/>
    <script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
</head>
<body>
<header class="cd-auto-hide-header">
    <div class="logo"><a href="#0"><img src="../img/img-order/cd-logo.svg" alt="Logo"/></a></div>
    <!--<div class="logo"><a href="#0"><img src="../static/img/img-order/cd-logo.svg"  alt="Logo"/></a></div>-->

    <nav class="cd-primary-nav">
        <a href="#cd-navigation" class="nav-trigger">
				<span>
					<em aria-hidden="true"></em>
					Menu
				</span>
        </a> <!-- .nav-trigger -->

        <ul id="cd-navigation">
            <li><a href="#0" onclick="javascript:window.location.href='homepage.jsp'">主页</a></li>
            <li><a href="#0" onclick="javascript:window.location.href='ordermanagement.jsp'">随工单管理</a></li>
            <li><a href="#0" onclick="javascript:window.location.href='staffmanagement.jsp'">人员管理</a></li>
            <li><a href="#0" onclick="javascript:window.location.href='recordmanagement.jsp'">录音管理</a></li>
            <li><a href="#0" onclick="javascript:window.location.href='systemmanagement.jsp'">系统管理</a></li>
        </ul>
    </nav> <!-- .cd-primary-nav -->
</header> <!-- .cd-auto-hide-header -->
</body>
</html>
