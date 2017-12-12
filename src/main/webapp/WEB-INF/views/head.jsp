<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-default navbar-static-top" role="navigation" style="height: 60px;">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-user"></span>欢迎您，<c:if test="${not empty name}">
                ${name}
            </c:if>
                <c:if test="${empty name}">
                    游客
                </c:if>!</a>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right" >
                <li style="border-right: 1px dashed #cccccc"><a href="#0" onclick="javascript:window.location.href='/homepage'"><span class="glyphicon glyphicon-sort"></span>实时生产</a></li>
                <li style="border-right: 1px dashed #cccccc"><a href="#0" onclick="javascript:window.location.href='/homepage/ordermanagement'"><span class="glyphicon glyphicon-folder-open"></span>随工单管理</a></li>
                <li style="border-right: 1px dashed #cccccc"><a href="#0" onclick="javascript:window.location.href='/homepage/staffmanagement'"><span class="glyphicon glyphicon-user"></span>人员管理</a></li>
                <li style="border-right: 1px dashed #cccccc"><a href="#0" onclick="javascript:window.location.href='/homepage/recordmanagement'"><span class="glyphicon glyphicon-headphones"></span>录音管理</a></li>
                <li><a href="#0" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-edit"></span>修改密码</a></li>
                <li><a href="#0" onclick="javascript:window.location.href='/index'"><span class="glyphicon glyphicon-remove-circle"></span>注销</a></li>
            </ul>
        </div>
    </div>
</nav>
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
                    <p>原始密码：<input type="text" name="oldPassword" class="form-control" placeholder="请输入原密码"></p>
                    <p>修改密码：<input type="text" name="newPassword" class="form-control" placeholder="请输入新密码"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">提交更改</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>