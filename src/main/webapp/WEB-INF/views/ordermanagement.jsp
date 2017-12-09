<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>随工单管理</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <script type="text/javascript" src="../../pageoffice.js" id="po_js_main"></script>
    <script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>


    <script type="text/javascript">
        function checkform1() {
            var orderType = "${sessionScope.get("orderType")}";
            if (orderType == "选择表类型") {
                alert('请选择随工单类型！');
                return false;
            }
            if (document.getElementById('inp1').value.length == 0) {
                alert('路径为空！');
                document.getElementById('ipt1').focus();
                return false;
            }
            if (document.getElementById('inp1').value == "请输入搜索内容") {
                alert('路径为空！');
                document.getElementById('ipt1').focus();
                return false;
            }
            if (document.getElementById('inp2').value.length == 0) {
                alert('输入为空！');
                document.getElementById('ipt2').focus();
                return false;
            }
            if (document.getElementById('inp2').value == "请输入搜索内容") {
                alert('输入为空！');
                document.getElementById('ipt2').focus();
                return false;
            }
            return true;
        }

        //        function checkform1(){
        //            if(document.getElementById('inp2').value.length==0){
        //                alert('输入为空！');
        //                document.getElementById('ipt2').focus();
        //                return false;
        //            }
        //            if(document.getElementById('inp2').value=="请输入搜索内容"){
        //                alert('输入为空！');
        //                document.getElementById('ipt2').focus();
        //                return false;
        //            }
        //        }
        function checkform2() {
            var orderType = "${sessionScope.get("orderType")}";
            if (orderType == "选择表类型") {
                alert('请选择随工单类型！');
                return false;
            }
            if (document.getElementById('inp3').value.length == 0) {
                alert('输入为空！');
                document.getElementById('ipt3').focus();
                return false;
            }
            if (document.getElementById('inp3').value == "请输入搜索内容") {
                alert('输入为空！');
                document.getElementById('ipt3').focus();
                return false;
            }
            return true;
        }

        function checkform3() {
            var orderType = "${sessionScope.get("orderType")}";
            if (orderType == "选择表类型") {
                alert('请选择随工单类型！');
                return false;
            }
            if (document.getElementById('inp4').value.length == 0) {
                alert('输入为空！');
                document.getElementById('ipt4').focus();
                return false;
            }
            if (document.getElementById('inp4').value == "请输入搜索内容") {
                alert('输入为空！');
                document.getElementById('ipt4').focus();
                return false;
            }
            return true;
        }
    </script>
    <!--Page-office-->
    <script type="text/javascript">


        function Save() {
            document.getElementById("PageOfficeCtrl1").WebSave();
        }

        function AfterDocumentOpened() {

            $("#btn1").removeAttr("disabled");
        }


        function OpenDocument(strUrl) {
            //使打开按钮变灰
            $('#btn1').attr('disabled', 'true');
            //使用post请求打开文档的action
            $.post(strUrl, {param2: "456"}, function (data) {
                $("#divDocView").html(data);
            });
        }

    </script>

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
<%--避免刷新--%>
<iframe name='hidden_frame' id="hidden_frame">
    <p>返回信息</p></iframe>
<div class="container" style="position: absolute;left: 15%;top: 15%">
    <div class="list-group" style="width: 230px;float: left">
        <a class="list-group-item active" id="test1">当前选择:${sessionScope.get("orderType")}</a>
        <div>
            <form id="selectorder" action="selectordertype" method="post" target="hidden_frame" style="height: 27px">
                <input type="hidden" name="orderType" value="随工单"/>
                <a class="list-group-item" href="selectordertype?orderType=随工单;" id="order"
                   onclick="document.getElementById('selectorder').submit();">随工单</a><%--order--%>
            </form>
            <form id="selectmemo" action="selectordertype" method="post" target="hidden_frame" style="height: 27px">
                <input type="hidden" name="orderType" value="仪器备忘录"/>
                <a class="list-group-item" href="selectordertype?orderType=仪器备忘录;" id="memo"
                   onclick="document.getElementById('selectmemo').submit();">仪器备忘录</a><%--memo--%>
            </form>
            <form id="selectremade" action="selectordertype" method="post" target="hidden_frame" style="height: 27px">
                <input type="hidden" name="orderType" value="返工记录表"/>
                <a class="list-group-item" href="selectordertype?orderType=返工记录表;" id="remade"
                   onclick="document.getElementById('selectremade').submit();">返工记录表</a><%--remade--%>
            </form>
            <form id="selectaging" action="selectordertype" method="post" target="hidden_frame" style="height: 27px">
                <input type="hidden" name="orderType" value="老化观测表"/>
                <a class="list-group-item" href="selectordertype?orderType=老化观测表;" id="aging"
                   onclick="document.getElementById('selectaging').submit();">老化观测表</a><%--aging--%>
            </form>
            <form id="selectpack" action="selectordertype" method="post" target="hidden_frame" style="height: 27px">
                <input type="hidden" name="orderType" value="装箱记录单"/>
                <a class="list-group-item" href="selectordertype?orderType=装箱记录单;" id="pack"
                   onclick="document.getElementById('selectpack').submit();">装箱记录单</a><%--pack--%>
            </form>
            <form id="selectdebug" action="selectordertype" method="post" target="hidden_frame" style="height: 27px">
                <input type="hidden" name="orderType" value="整机调试报告单"/>
                <a class="list-group-item" href="selectordertype?orderType=整机调试报告单;" id="debug"
                   onclick="document.getElementById('selectdebug').submit();">整机调试报告单</a><%--debug--%>
            </form>
            <form id="selectprocessTest" action="selectordertype" method="post" target="hidden_frame"
                  style="height: 27px">
                <input type="hidden" name="orderType" value="工序检验报告单"/>
                <a class="list-group-item" href="selectordertype?orderType=工序检验报告单;" id="processTest"
                   onclick="document.getElementById('selectprocessTest').submit();">工序检验报告单</a><%--processTest--%>
            </form>
            <form id="selectmachineTest" action="selectordertype" method="post" target="hidden_frame"
                  style="height: 27px">
                <input type="hidden" name="orderType" value="整机检验报告单"/>
                <a class="list-group-item" href="selectordertype?orderType=整机检验报告单;" id="machineTest"
                   onclick="document.getElementById('selectmachineTest').submit();">整机检验报告单</a><%--machineTest--%>
            </form>
            <form id="selectproductTest" action="selectordertype" method="post" target="hidden_frame"
                  style="height: 27px">
                <input type="hidden" name="orderType" value="成品检验报告单"/>
                <a class="list-group-item" href="selectordertype?orderType=成品检验报告单;" id="productTest"
                   onclick="document.getElementById('selectproductTest').submit();">成品检验报告单</a><%--productTest--%>
            </form>
            <form id="selectsphygmomanometer" action="selectordertype" method="post" target="hidden_frame"
                  style="height: 27px">
                <input type="hidden" name="orderType" value="血压计检定报告单"/>
                <a class="list-group-item" href="selectordertype?orderType=血压计检定报告单;" id="sphygmomanometer"
                   onclick="document.getElementById('selectsphygmomanometer').submit();">血压计检定报告单</a><%--sphygmomanometer--%>
            </form>
            <form id="selectperformTest" action="selectordertype" method="post" target="hidden_frame"
                  style="height: 27px">
                <input type="hidden" name="orderType" value="性能要求检验单"/>
                <a class="list-group-item" href="selectordertype?orderType=性能要求检验单;" id="performTest"
                   onclick="document.getElementById('selectperformTest').submit();">性能要求检验单</a><%--performTest--%>
            </form>
            <form id="selectfinalTest" action="selectordertype" method="post" target="hidden_frame"
                  style="height: 27px">
                <input type="hidden" name="orderType" value="最终检验报告单"/>
                <a class="list-group-item" href="selectordertype?orderType=最终检验报告单;" id="finalTest"
                   onclick="document.getElementById('selectfinalTest').submit();">最终检验报告单</a><%--finalTest--%><%--上传到selectordertype--%>
            </form>
        </div>
    </div>
    <div style="position: relative;float: left;width: 60%;left: 4%;height: inherit">
        <ul id="myTab" class="nav nav-tabs">
            <li class="active"><a href="#home" data-toggle="tab" style="background-color: white">添加</a></li>
            <li><a href="#ios" data-toggle="tab" style="background-color: white">删除</a></li>
            <li><a href="#java" data-toggle="tab" style="background-color: white">上传</a></li>
        </ul>
        <div id="myTabContent" class="tab-content"
             style="width: 100%;background-color: #437ab2;border-radius: 0 5px 5px 5px">
            <div class="tab-pane fade in active" id="home"
                 style="position: relative;width: 100%;height: 160px;background-color: #437ab2;color: white;border-radius: 0 5px 5px 5px">
                <div class="container" style="width: 60%">
                    <form action="addorder" method="post" enctype="multipart/form-data" target="hidden_frame">
                        选择路径:<input class="form-control" id="inp1" type="file" name="uploadfile"/>
                        选择名称:<input class="form-control" id="inp2" type="text" name="number" placeholder="请输入名称"/>
                        <input id="updt" class="btn btn-default" type="submit" value="添加" onclick="checkform1()"
                               style="float: right" data-toggle="modal" data-target="#myModal"/>
                    </form>
                </div>
            </div>
            <div class="tab-pane fade" id="ios"
                 style="position: relative;background-color: #437ab2;height: 100px;color: white;border-radius: 0 5px 5px 5px">
                <div class="container" style="width: 60%">
                    <form action="deleteorderone" method="get" target="hidden_frame">
                        <!--输入删除的随单表号码-->
                        随工单编号：<input class="form-control" id="inp3" name="name" type="text" placeholder="请输入单号"/>
                        <input id="deletest" class="btn btn-default" type="submit" value="确定" onclick="checkform2()"
                               style="float: right"/>
                    </form>
                </div>
            </div>
            <div class="tab-pane fade" id="java"
                 style="position: relative;background-color: #437ab2;height: 320px;color: white;border-radius: 0 5px 5px 5px">
                <div class="container" style="width: 60%">
                    <form action="updateorder" method="get" target="hidden_frame">
                        随工单编号: <input class="form-control" type="text" name="orderNum" placeholder="请输入单号"/>
                        工序: <input class="form-control" type="text" name="process" placeholder="请输入工序"/>
                        操作者: <input class="form-control" type="text" name="operater" placeholder="请输入操作者"/>
                        其他: <input class="form-control" type="text" name="other" placeholder="请输入其他"/>
                        备注: <input class="form-control" type="text" name="ps" placeholder="请输入备注"/>
                        <input class="btn btn-default" type="submit" value="更新" style="float: right"/>
                    </form>
                </div>
            </div>
        </div>
        <div class="panel panel-default" style="position: relative;top: 20px">
            <div class="panel-heading">
                搜索
            </div>
            <div class="panel-body" style="background-color: #437ab2;">
                <div class="container" style="width: 62%">
                    <form action="searchorder" method="get">
                        <input class="form-control" type="text" name="orderNum" class="search-input" placeholder="请输入单号"
                               id="inp4"/>
                        <input class="btn btn-default" type="submit" class="search-icon" value="搜索"
                               onclick="checkform3()" style="float: right"/>
                    </form>
                    <a href="javascript:POBrowser.openWindow('/show','width=1200px;height=800px;');"
                       style="color: white;float: right">打开</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    提示
                </h4>
            </div>
            <div class="modal-body">
                <h1>session返回信息+${sessionScope.get("msg")}</h1>
                <h1>model返回信息+${msg}</h1>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
<script>
    $(function () {
        $("[data-toggle='popover']").popover();
    });
</script>