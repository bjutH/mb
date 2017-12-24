<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <meta charset="UTF-8"/>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <title>录音管理</title>

    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/bootstrap-editable.css"/>
    <link href="../css/bootstrap-table.css" rel="stylesheet">
    <link href="../css/index.css" rel="stylesheet">


    <!-- bootstrap-table -->
    <script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap-editable.js" type="text/javascript"></script>
    <script src="../js/bootstrap-table.js" type="text/javascript"></script>
    <script src="../js/bootstrap-table-zh-CN.js" type="text/javascript"></script>
    <script src="../js/bootstrap-table-editable.js" type="text/javascript"></script>
    <script type="text/javascript" src="../js/soundedit.js"></script>

    <%--<script type="text/javascript" language="javascript">--%>
        <%--function checkform1(){--%>
            <%--document.getElementById("num1").value  = document.getElementById('num').value ;--%>
            <%--return true;--%>
        <%--}--%>
    <%--</script>--%>

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
<div>
    <table id="tb_departments" style="background-color: white"></table>
</div>
<%--<div class="container">--%>
    <%--<div class="panel panel-default">--%>
        <%--<div class="panel-heading">查询条件</div>--%>
        <%--<div class="panel-body">--%>
            <%--<form id="numSearch" class="form-horizontal" action="/homepage/recordmanagement/selectsound" method="get">--%>
                <%--<div class="form-group" style="margin-top:15px">--%>
                    <%--<label class="control-label col-sm-1" for="num">编号</label>--%>
                    <%--<div class="col-sm-3">--%>
                        <%--<select name="num" id="num" class="form-control">--%>
                            <%--<option value=${soundNum} selected>${soundNum}</option>--%>
                            <%--<%--%>
                                <%--for(int i=0;i<50;i++){--%>
                            <%--%>--%>
                            <%--<option  value="<%=i+1 %>"><%=i+1 %></option>--%>
                            <%--<%} %>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="col-sm-4" style="text-align:left;">--%>
                        <%--<input type="submit" class="btn btn-default" value="查询" style="background-color: #2e6da4;color: white"/>--%>
                        <%--&lt;%&ndash;${msg}&ndash;%&gt;--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</form>--%>
            <%--<form id="numUpdate" class="form-horizontal" action="/homepage/recordmanagement/updatesound" method="get">--%>
                <%--<div class="form-group" style="margin-top:15px">--%>
                    <%--<div class="col-sm-1">--%>
                        <%--<input id="num1" name="num" class="form-control" style="display: none" type="text" >--%>
                    <%--</div>--%>
                    <%--<div class="col-sm-3">--%>
                        <%--<input id="sound" name="sound" class="form-control" type="text" placeholder=${msg1} >--%>
                    <%--</div>--%>
                    <%--<div class="col-sm-4" style="text-align:left;">--%>
                        <%--<input id="update" type="submit" class="btn btn-default" value="修改"  style="background-color: #2e6da4;color: white" onclick="checkform1()"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--&lt;%&ndash;<table class="table-striped" id="srtable"&ndash;%&gt;--%>
           <%--&lt;%&ndash;data-toggle="table"&ndash;%&gt;--%>
           <%--&lt;%&ndash;style="background-color: white;height:200px;overflow:auto;" >&ndash;%&gt;--%>
        <%--&lt;%&ndash;<thead>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<th data-field="id">录音编号</th>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<th data-field="comment">备注</th>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</thead>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</table>&ndash;%&gt;--%>
<%--</div>--%>
</body>
</html>

