<%@ page import="java.util.List" %>
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
    <script src="../js/soundrecord.js" type="text/javascript"></script>
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
</head>
<body>
<%@include file="head.jsp" %>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>
        <div class="panel-body">
            <form id="numSearch" class="form-horizontal">
                <div class="form-group" style="margin-top:15px">
                    <label class="control-label col-sm-1" for="num">编号</label>
                    <div class="col-sm-3">
                        <select name="num" id="num" class="form-control">
                            <option value="0" selected>请选择：</option>
                            <%
                                for(int i=0;i<50;i++){
                            %>
                            <option  value="<%=i+1 %>"><%=i+1 %></option>
                            <%} %>
                        </select>
                    </div>
                    <div class="col-sm-4" style="text-align:left;">
                        <button type="button" style="margin-left:50px" id="num_query" class="btn btn-primary">查询</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <table class="table-striped" id="srtable"
           data-toggle="table"
           style="background-color: white;height:200px;overflow:auto;" >
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

