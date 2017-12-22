<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <meta charset="UTF-8"/>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <title>实时生产</title>

    <script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>

    <!-- bootstrap-table -->
    <link href="../css/bootstrap-table.css" rel="stylesheet">
    <script src="../js/bootstrap-table.js" type="text/javascript"></script>
    <script src="../js/bootstrap-table-zh-CN.js" type="text/javascript"></script>
    <script type="text/javascript" language="javascript">
        function checkform2(){
            document.getElementById("orderNumber1").value  = document.getElementById('orderNumber').value ;
            return true;
        }
    </script>

    <style>
        body {
            width: 100%;
            height: 100%;
            /*background: url("../img/img-order/cd-hero-background.jpg") no-repeat;*/
            /*background-size: cover;*/
        }
    </style>
</head>
<body>
<%@include file="head.jsp" %>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>
        <div class="panel-body">
            <form id="numSearch" class="form-horizontal" action="/homepage/progresscontrollerall">
                <div class="form-group" style="margin-top:15px">
                    <label class="control-label col-sm-1" >编号</label>
                    <div class="col-sm-3">

                        <input type="text" name="orderNum"id="orderNumber">
                    </div>

                        <div class="col-sm-4" style="text-align:left;">
                            <input type="submit" class="btn btn-default" value="查询" style="background-color: #2e6da4;color: white"/>
                            <%--${msg}--%>

                    </div>
                </div>
                <div class="col-sm-3">

                    <label type="text" name="orderNum">
                        随工单： ${随工单}
                        仪器备忘录：${仪器备忘录}
                        老化观测表：${老化观测表}
                        装箱记录单：${装箱记录单}
                        整机调试报告单：${整机调试报告单}
                        工序检验报告单：${工序检验报告单}
                        整机检验报告单：${整机检验报告单}
                        成品检验报告单：${成品检验报告单}
                        血压计检定报告单：${血压计检定报告单}
                        性能要求检验单：${性能要求检验单}
                        最终检验报告单：${最终检验报告单}</label>
                </div>

            </form>
        </div>
            <div>
            <form id="orderInfo" class="form-horizontal" action="/homepage/progresscontrollerone">
                <div class="form-group" style="margin-top:15px">
                    <label class="control-label col-sm-1" >类型</label>
                    <div class="col-sm-3">
                    <select name="orderType" id="num" class="form-control">
                        <option value="0" selected>请选择随工单类型</option>
                            <c:forEach items="${list}" var="item">
                                <option value=${item} >${item}</option>
                            </c:forEach>
                    </select>
                    </div>

                    <%--<div class="col-sm-3">--%>
                        <%--<input type="text" name="orderType"id="orderType">--%>
                    <%--</div>--%>

                    <div class="col-sm-1">
                        <input id="orderNumber1" name="orderNum" class="form-control" style="display: none" type="text" >
                    </div>
                    <div class="col-sm-4" style="text-align:left;">

                        <input type="submit" class="btn btn-default" value="具体进度" style="background-color: #2e6da4;color: white"onclick="checkform2()"/>
                        <%--${msg}--%>

                    </div>
                </div>

            </form>
            </div>
            <label class="container">
                <c:forEach items="${map}" var="item">
                    <c:out value="${item.key}" />
                    <c:out value="${item.value}" />
                </c:forEach>
            </label>
        </div>
    </div>

    <%--<table class="table-striped"--%>
           <%--id="srtable"--%>
           <%--data-toggle="table"--%>
           <%--style="background-color: white;height:200px;overflow:auto;" >--%>
        <%--<thead>--%>
        <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<th data-field="id">录音编号</th>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<th data-field="comment">备注</th>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
        <%--</thead>--%>
    <%--</table>--%>
</div>
</body>
</html>

