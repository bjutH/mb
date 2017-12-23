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
    <style>

        table tr:nth-child(odd){
            background: #ccc;
        }
    </style>
    <%--<script type="text/javascript" language="javascript">--%>
        <%--function checkform2(){--%>
            <%--document.getElementById("orderNumber1").value  = document.getElementById('orderNumber').value ;--%>
            <%--return true;--%>
        <%--}--%>
    <%--</script>--%>
    <script type="text/javascript" language="javascript">
        function checkform2(){
            var oderno=document.getElementById("odernum").value;
            var reg = /^[0-9]{3,16}$/;
           if(!reg.test(oderno))
            {
                alert("请输入正确编号");
                return false;
            }
        }
    </script>
    <script type="text/javascript" language="javascript">
        function checkform3(){
            document.getElementById("orderNumber1").value  = document.getElementById('odernum').value ;
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
            <form id="numSearch" class="form-horizontal" action="/homepage/progresscontrollerall" onsubmit="checkform2()">
                <div class="form-group" style="margin-top:15px">
                    <label class="control-label col-sm-1" >编号</label>
                    <div class="col-sm-3">

                        <input id=odernum type="text" name="orderNum"id="orderNumber">
                    </div>

                        <div class="col-sm-4" style="text-align:left;">
                            <input type="submit" class="btn btn-default" value="查询" style="background-color: #2e6da4;color: white"onsubmit="checkform2()"/>
                            <%--${msg}--%>
                        </div>
                    </div>
            </form>
            <div class="panel-body" >

                    <label type="text" name="orderNum" >
                       <table border="1"style="width:300px  ;height:300px"  >
                           <tr>
                               <th>名称</th><th>&nbsp;&nbsp;&nbsp;进度&nbsp;&nbsp;&nbsp;</th>
                           </tr>
                            <tr>
                                <td>随工单：</td>
                                <c:if test='${empty 随工单}'>
                                    <td ></td>
                                </c:if>
                                <c:if test='${随工单=="未完成"}'>
                                    <td style="color: red">${随工单}</td>
                                </c:if>
                                <c:if test='${随工单=="已完成"}'>
                                    <td style="color:green">${仪器备忘录}</td>
                                </c:if>
                                <c:if test='${随工单=="无"}'>
                                    <td style="color:gray">${随工单}</td>
                                </c:if>
                            </tr>
                            <tr>
                                <td>仪器备忘录：</td>
                                <c:if test='${empty 仪器备忘录}'>
                                    <td ></td>
                                </c:if>
                                <c:if test='${仪器备忘录=="未完成"}'>
                                    <td style="color: red">${仪器备忘录}</td>
                                </c:if>
                                <c:if test='${仪器备忘录=="已完成"}'>
                                    <td style="color:green">${仪器备忘录}</td>
                                </c:if>
                                <c:if test='${仪器备忘录=="无"}'>
                                    <td style="color:gray">${仪器备忘录}</td>
                                </c:if>
                            </tr>
                           <tr>
                               <td>老化观测表：</td>
                               <c:if test='${empty 老化观测表}'>
                                   <td ></td>
                               </c:if>
                               <c:if test='${老化观测表=="未完成"}'>
                                   <td style="color: red">${老化观测表}</td>
                               </c:if>
                               <c:if test='${老化观测表=="已完成"}'>
                                   <td style="color:green">${老化观测表}</td>
                               </c:if>
                               <c:if test='${老化观测表=="无"}'>
                                   <td style="color:gray">${老化观测表}</td>
                               </c:if>

                           </tr>
                           <tr>
                               <td>装箱记录单：</td>
                               <c:if test='${empty 装箱记录单}'>
                               <td ></td>
                              </c:if>
                               <c:if test='${装箱记录单=="未完成"}'>
                                   <td style="color: red">${装箱记录单}</td>
                               </c:if>
                               <c:if test='${装箱记录单=="已完成"}'>
                                   <td style="color:green">${装箱记录单}</td>
                               </c:if>
                               <c:if test='${装箱记录单=="无"}'>
                                   <td style="color:gray">${装箱记录单}</td>
                               </c:if>
                           </tr>
                           <tr>
                               <td>整机调试报告单：</td>
                               <c:if test='${empty 整机调试报告单}'>
                                   <td ></td>
                               </c:if>
                               <c:if test='${整机调试报告单=="未完成"}'>
                                   <td style="color: red">${整机调试报告单}</td>
                               </c:if>
                               <c:if test='${整机调试报告单=="已完成"}'>
                                   <td style="color:green">${整机调试报告单}</td>
                               </c:if>
                               <c:if test='${整机调试报告单=="无"}'>
                                   <td style="color:gray">${整机调试报告单}</td>
                               </c:if>
                           </tr>
                           <tr>
                               <td>工序检验报告单：</td>
                               <c:if test='${empty 工序检验报告单}'>
                               <td ></td>
                                 </c:if>
                               <c:if test='${工序检验报告单=="未完成"}'>
                                   <td style="color: red">${工序检验报告单}</td>
                               </c:if>
                               <c:if test='${工序检验报告单=="已完成"}'>
                                   <td style="color:green">${工序检验报告单}</td>
                               </c:if>
                               <c:if test='${工序检验报告单=="无"}'>
                                   <td style="color:gray">${工序检验报告单}</td>
                               </c:if>
                           </tr>
                           <tr>
                               <td>整机检验报告单：</td><c:if test='${empty 整机检验报告单}'>
                               <td ></td>
                           </c:if>
                               <c:if test='${整机检验报告单=="未完成"}'>
                                   <td style="color: red">${整机检验报告单}</td>
                               </c:if>
                               <c:if test='${整机检验报告单=="已完成"}'>
                                   <td style="color:green">${整机检验报告单}</td>
                               </c:if>
                               <c:if test='${整机检验报告单=="无"}'>
                                   <td style="color:gray">${整机检验报告单}</td>
                               </c:if>
                           </tr>
                           <tr>
                               <td>成品检验报告单：</td>
                               <c:if test='${empty 成品检验报告单}'>
                               <td ></td>
                           </c:if>
                               <c:if test='${成品检验报告单=="未完成"}'>
                                   <td style="color: red">${成品检验报告单}</td>
                               </c:if>
                               <c:if test='${成品检验报告单=="已完成"}'>
                                   <td style="color:green">${成品检验报告单}</td>
                               </c:if>
                               <c:if test='${成品检验报告单=="无"}'>
                                   <td style="color:gray">${成品检验报告单}</td>
                               </c:if>
                           </tr>
                           <tr>
                               <td>血压计检定报告单：</td>
                               <c:if test='${empty 血压计检定报告单}'>
                                   <td ></td>
                               </c:if>
                               <c:if test='${血压计检定报告单=="未完成"}'>
                                   <td style="color: red">${血压计检定报告单}</td>
                               </c:if>
                               <c:if test='${血压计检定报告单=="已完成"}'>
                                   <td style="color:green">${血压计检定报告单}</td>
                               </c:if>
                               <c:if test='${血压计检定报告单=="无"}'>
                                   <td style="color:gray">${血压计检定报告单}</td>
                               </c:if>
                           </tr>
                           <tr>
                               <td>性能要求检验单：</td>
                               <c:if test='${empty 性能要求检验单}'>
                                   <td ></td>
                               </c:if>
                               <c:if test='${性能要求检验单=="未完成"}'>
                                   <td style="color: red">${性能要求检验单}</td>
                               </c:if>
                               <c:if test='${性能要求检验单=="已完成"}'>
                                   <td style="color:green">${性能要求检验单}</td>
                               </c:if>
                               <c:if test='${性能要求检验单=="无"}'>
                                   <td style="color:gray">${性能要求检验单}</td>
                               </c:if>
                           </tr>
                           <tr>
                               <td>最终检验报告单：</td>
                               <c:if test='${empty 最终检验报告单}'>
                                   <td ></td>
                               </c:if>
                               <c:if test='${最终检验报告单=="未完成"}'>
                                   <td style="color: red">${最终检验报告单}</td>
                               </c:if>
                               <c:if test='${最终检验报告单=="已完成"}'>
                                   <td style="color:green">${最终检验报告单}</td>
                               </c:if>
                               <c:if test='${最终检验报告单=="无"}'>
                                   <td style="color:gray">${最终检验报告单}</td>
                               </c:if>
                           </tr>




                    </table>
                        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;随工单：${随工单}</br>--%>
                        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;仪器备忘录：${仪器备忘录}</br>--%>
                        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;老化观测表：${老化观测表}</br>--%>
                        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;装箱记录单：${装箱记录单}</br>--%>
                        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;整机调试报告单：${整机调试报告单}</br>--%>
                        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工序检验报告单：${工序检验报告单}</br>--%>
                        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;整机检验报告单：${整机检验报告单}</br>--%>
                        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;成品检验报告单：${成品检验报告单}</br>--%>
                        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;血压计检定报告单：${血压计检定报告单}</br>--%>
                        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性能要求检验单：${性能要求检验单}</br>--%>
                        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;最终检验报告单：${最终检验报告单}</label>--%>
            </div>


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


                    <div class="col-sm-4" style="text-align:left;">

                        <input type="submit" class="btn btn-default" value="具体进度" style="background-color: #2e6da4;color: white "onclick="checkform3()"/>
                        <%--${msg}--%>

                    <%--</div>--%>
                    <%--<div class="col-sm-3">--%>
                        <%--<input id="sound" name="sound" class="form-control" type="text" style= placeholder=${msg1} >--%>
                    <%--</div>--%>
                </div>
                <div class="col-sm-1">
                    <input id="orderNumber1" name="orderNum" class="form-control" style="display: none" type="text" >
                </div>

            </form>
            </div>
            <label class="container">
                <table>
                <c:forEach items="${map}" var="item">
                    <tr>
                        <td><c:out value="${item.key}" /></td>
                        <c:if test='${item.value=="未完成"}'>
                            <td style="color:red"><c:out value="${item.value}" /></td>
                        </c:if>
                        <c:if test='${item.value=="已完成"}'>
                            <td style="color:green"><c:out value="${item.value}" /></td>
                        </c:if>

                    </tr>
                </c:forEach>
                </table>
            </label>
        </div>
    </div>


</div>
</body>
</html>

