<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <meta charset="UTF-8"/>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <title>录音管理</title>
    <script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <!-- bootstrap-table -->
    <link href="../css/bootstrap-table.css" rel="stylesheet">
    <script src="../js/bootstrap-table.js" type="text/javascript"></script>
    <script src="../js/bootstrap-table-zh-CN.js" type="text/javascript"></script>
    <style>
        body {
            width: 100%;
            height: 100%;
            background: url("../img/img-order/cd-hero-background.jpg") no-repeat;
            background-size: cover;
        }
    </style>
    <script>
        $.extend($.fn.bootstrapTable.defaults, {
//            method: 'post',
            pagination: true,
            sidePagination: 'server',
//            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            showRefresh: true
        });
        $.extend($.fn.bootstrapTable.columnDefaults, {
            align: 'center',
            valign: 'middle'
        });
    </script>
</head>
<body>
<%@include file="head.jsp" %>
<div class="container">
    <table class="table-striped" id="table"
           data-toggle="table"
           data-url="../json/data2.json" style="background-color: white;height:200px;overflow:auto;" >
        <thead>
        <tr>
            <th data-field="id">录音编号</th>
            <th data-field="comment">备注</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>

