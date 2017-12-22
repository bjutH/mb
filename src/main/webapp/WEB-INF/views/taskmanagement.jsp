<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <meta charset="UTF-8"/>
    <title>任务管理</title>


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
    <script type="text/javascript" src="../js/task.js"></script>

    <style>
        body {
            width: 100%;
            height: 100%;
            background: url("../img/img-order/cd-hero-background.jpg") no-repeat;
            background-size: cover;
        }

        .addwhite {
            background-color: #f9f9f9;
            border-radius: 0px 0px 5px 5px;
        }
    </style>
</head>
<body>
<%@include file="head.jsp" %>

<div style="position: absolute;top: 80px;width: 100%">
    <%--<div class="panel-body" style="padding-bottom:0px;">--%>
    <%--<div class="panel panel-default">--%>
    <%--<div class="panel-heading">查询条件</div>--%>
    <%--<div class="panel-body">--%>
    <%--<form id="formSearch" class="form-horizontal">--%>
    <%--<div class="form-group" style="margin-top:15px">--%>
    <%--<label class="control-label col-sm-1" for="txt_search_name">姓名</label>--%>
    <%--<div class="col-sm-3">--%>
    <%--<input type="text" class="form-control" id="txt_search_name">--%>
    <%--</div>--%>
    <%--<label class="control-label col-sm-1" for="txt_search_statu">状态</label>--%>
    <%--<div class="col-sm-3">--%>
    <%--<input type="text" class="form-control" id="txt_search_statu">--%>
    <%--</div>--%>
    <%--<div class="col-sm-4" style="text-align:left;">--%>
    <%--<button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</form>--%>
    <%--</div>--%>
    <%--</div>--%>
<div style="width: 80%;margin: 0 auto">
    <div id="toolbar" class="btn-group">
        <button id="btn_edit" type="button" class="btn btn-default" data-toggle="modal" data-target="#modalTablev">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>分配任务
        </button>
        <button id="btn_delete" type="button" class="btn btn-default" data-toggle="modal" data-target="#modalTabled">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
        </button>
    </div>
    <div>
        <table id="tb_departments" style="background-color: white"></table>
    </div>
</div>
</div>
</div>

<%--<!-- 修改密码模态框（Modal） -->--%>
<%--<div class="modal fade" id="modalTable" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">--%>
    <%--<div class="modal-dialog">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                    <%--<span aria-hidden="true">&times;</span></button>--%>
                <%--<h4 class="modal-title">修改密码</h4>--%>
            <%--</div>--%>
            <%--<div class="modal-body">--%>
                <%--<form action="/homepage/staffmanagement/updatepassword" method="get">--%>
                    <%--<p>姓名:<input class="form-control" name="name" type="text" placeholder="请输入姓名"></p>--%>
                    <%--<p>新密码:<input class="form-control" name="pass" type="text" placeholder="请输入新密码"></p>--%>
                    <%--<input class="btn btn-default" type="submit" value="提交" style="background-color: #437ab2;color: white">--%>
                <%--</form>--%>
            <%--</div>--%>
            <%--<div class="modal-footer">--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
            <%--</div>--%>
        <%--</div><!-- /.modal-content -->--%>
    <%--</div><!-- /.modal-dialog -->--%>
<%--</div><!-- /.modal -->--%>

<!-- 分配任务模态框（Modal） -->
<div class="modal fade" id="modalTablev" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">分配任务</h4>
            </div>
            <div class="modal-body">
                <form action="/???????" method="get">
                    <p>姓名:<input class="form-control" name="name" type="text" placeholder="请输入姓名"></p>
                    <p>任务:
                    <div class="form-group">
                        <select class="form-control" name="task">
                            <option selected="selected">未选择</option>
                            <option value="任务1">任务1</option>
                            <option value="任务2">任务2</option>
                            <option value="任务3">任务3</option>
                            <option value="任务4">任务4</option>
                        </select>
                    </div>
                    </p>
                    <p><input class="btn btn-default" type="submit" value="提交" style="background-color: #437ab2;color: white"></p>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 删除模态框（Modal） -->
<div class="modal fade" id="modalTabled" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">删除</h4>
            </div>
            <div class="modal-body">
                <form action="/????????" method="get">
                    <p>姓名:<input class="form-control" name="name" type="text" placeholder="请输入姓名"></p>
                    <input class="btn btn-default" type="submit" value="提交" style="background-color: #437ab2;color: white">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
    var $table = $('#table');
    $(function () {
        $('#modalTable').on('shown.bs.modal', function () {
            $table.bootstrapTable('resetView');
        });
    });
    var $table = $('#table');
    $(function () {
        $('#modalTablev').on('shown.bs.modal', function () {
            $table.bootstrapTable('resetView');
        });
    });
    var $table = $('#table');
    $(function () {
        $('#modalTabled').on('shown.bs.modal', function () {
            $table.bootstrapTable('resetView');
        });
    });
</script>
<script>
    $().ready(function () {
            $(".fixed-table-pagination").addClass("addwhite");
        }
    );
</script>

<script>
    var $table = $('#table'),
        $button = $('#button');

    $(function () {
        $button.click(function () {
            alert('getSelections: ' + JSON.stringify($table.bootstrapTable('getAllSelections')));
        });
    });
</script>
</body>
</html>