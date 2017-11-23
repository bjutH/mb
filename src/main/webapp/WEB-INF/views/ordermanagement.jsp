<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>随工单管理</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!--本地用引用路径-->
    <link href="https://fonts.googleapis.com/css?family=David+Libre|Hind:400,700" rel="stylesheet"/>
    <link rel="stylesheet" href="../css/css-order/reset.css"/> <!-- CSS reset -->
    <link rel="stylesheet" type="text/css" href="../css/css-order/htmleaf-demo.css"/>
    <link rel="stylesheet" href="../css/css-order/style.css"/> <!-- Resource style -->
    <link rel="stylesheet" href="../css/mycss.css"/>
    <link rel="stylesheet" type="text/css" href="../css/css-search/search-form.css"/>
    <script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="../js/js-order/main.js"></script> <!-- Resource jQuery -->
    <script type="text/javascript" src="../../pageoffice.js" id="po_js_main"></script>
    <!--没找到-->
    <%--<script type="text/javascript" src="../pageoffice.js" id="po_js_main"></script>--%>

    <!--myjs-->
    <!--divaddt伸缩-->
    <script type="text/javascript">
        $(function () {
            $('#add').click(function (event) {
                //取消事件冒泡
                event.stopPropagation();
                //设置弹出层的位置
                var offset = $(event.target).offset();
                $('#divadd').css({top: offset.top + $(event.target).height() + "px", left: offset.left});
                //按钮的toggle,如果div是可见的,点击按钮切换为隐藏的;如果是隐藏的,切换为可见的。
                $('#divadd').toggle('slow');
            });
            //点击空白处或者自身隐藏弹出层，下面分别为滑动和淡出效果。
            $(document).click(function (event) {
                $('#divadd').slideUp('slow')
            });
            $('#divadd').click(function (event) {
                //$(this).fadeOut(1000)
                event.stopPropagation();
            });
            //测试点击删除隐藏块
            $('#add').click(function (event) {
                if(!$('#divdelet').is(":hidden")){
                    $('#divdelet').toggle('slow');
                }
            })

            $('#add').click(function (event) {
                if(!$('#divupdata').is(":hidden")){
                    $('#divupdata').toggle('slow');
                }
            })

            $('#add').click(function (event) {
                if(!$('#divsearch').is(":hidden")){
                    $('#divsearch').toggle('slow');
                }
            })

        })
    </script>

    <!--divdelett伸缩-->
    <script type="text/javascript">
        $(function () {
            $('#delet').click(function (event) {
                //取消事件冒泡
                event.stopPropagation();
                //设置弹出层的位置
                var offset = $(event.target).offset();
                $('#divdelet').css({top: offset.top + $(event.target).height() + "px", left: offset.left});
                //按钮的toggle,如果div是可见的,点击按钮切换为隐藏的;如果是隐藏的,切换为可见的。
                $('#divdelet').toggle('slow');
            });
            //点击空白处或者自身隐藏弹出层，下面分别为滑动和淡出效果。
            $(document).click(function (event) {
                $('#divdelet').slideUp('slow')
            });
            $('#divdelet').click(function (event) {
                //$(this).fadeOut(1000)
                event.stopPropagation();
            });

            $('#delet').click(function (event) {
                if(!$('#divadd').is(":hidden")){
                    $('#divadd').toggle('slow');
                }
            })

            $('#delet').click(function (event) {
                if(!$('#divupdata').is(":hidden")){
                    $('#divupdata').toggle('slow');
                }
            })

            $('#delet').click(function (event) {
                if(!$('#divsearch').is(":hidden")){
                    $('#divsearch').toggle('slow');
                }
            })
        })
    </script>

    <!--divupdata伸缩-->
    <script type="text/javascript">
        $(function () {
            $('#updata').click(function (event) {
                //取消事件冒泡
                event.stopPropagation();
                //设置弹出层的位置
                var offset = $(event.target).offset();
                $('#divupdata').css({top: offset.top + $(event.target).height() + "px", left: offset.left});
                //按钮的toggle,如果div是可见的,点击按钮切换为隐藏的;如果是隐藏的,切换为可见的。
                $('#divupdata').toggle('slow');
            });
            //点击空白处或者自身隐藏弹出层，下面分别为滑动和淡出效果。
            $(document).click(function (event) {
                $('#divupdata').slideUp('slow')
            });
            $('#divupdata').click(function (event) {
                //$(this).fadeOut(1000)
                event.stopPropagation();
            });

            $('#updata').click(function (event) {
                if (!$('#divadd').is(":hidden")) {
                    $('#divadd').toggle('slow');
                }
            })

            $('#updata').click(function (event) {
                if (!$('#divdelet').is(":hidden")) {
                    $('#divdelet').toggle('slow')
                }
            })

            $('#updata').click(function (event) {
                if (!$('#divsearch').is(":hidden")) {
                    $('#divsearch').toggle('slow')
                }
            })
        })
    </script>

    <!--divsearch伸缩-->
    <script type="text/javascript">
        $(function () {
            $('#search').click(function (event) {
                //取消事件冒泡
                event.stopPropagation();
                //设置弹出层的位置
                var offset = $(event.target).offset();
                $('#divsearch').css({top: offset.top + $(event.target).height() + "px", left: offset.left});
                //按钮的toggle,如果div是可见的,点击按钮切换为隐藏的;如果是隐藏的,切换为可见的。
                $('#divsearch').toggle('slow');
            });
            //点击空白处或者自身隐藏弹出层，下面分别为滑动和淡出效果。
            $(document).click(function (event) {
                $('#divsearch').slideUp('slow')
            });
            $('#divsearch').click(function (event) {
                //$(this).fadeOut(1000)
                event.stopPropagation();
            });

            $('#search').click(function (event) {
                if (!$('#divadd').is(":hidden")) {
                    $('#divadd').toggle('slow');
                }
            })

            $('#search').click(function (event) {
                if (!$('#divdelet').is(":hidden")) {
                    $('#divdelet').toggle('slow')
                }
            })

            $('#search').click(function (event) {
                if (!$('#divupdata').is(":hidden")) {
                    $('#divupdata').toggle('slow')
                }
            })


        })
    </script>

    <!--打开/关闭编辑模式-->
    <script>
        function startEdit() {
            var editor = document.getElementById("pageEditor");
            Element.contenteditable = "ture"
            editor.contentWindow.document.designMode = "on";
        }

        function stopEdit() {
            var editor = document.getElementById("pageEditor");
            editor.contentWindow.document.designMode = "off";
            var editedHTML = document.getElementById("editedHTML");
            editedHTML.innerHTML = "<html>" + editor.contentWindow.document.head.innerHTML + editor.contentWindow.document.body.innerHTML + "</html>";
            // document.getElementById("edit edHTML").innerHTML(editedHTML.textContent);
        }

        <!--获取iframe中的内容-->

        function getIframeContent(frameId) {
            var frameObj = document.getElementById(frameId);
            var frameContent = frameObj.contentWindow.document.body.innerHTML;
            var fso = new ActiveXObject("Scripting.FileSystemObject");
            var file = fso.createTextFile("/Applications/ab/tempe2h.html", true);
            //   file.write(frameContent);
            // file.close();
            alert("frame content : " + frameContent);
            //	return frameContent;
        }
    </script>

    <!--选择不同的表-->
    <script type="text/javascript">
        function chosetable() {
            var content;
            content = $("#this").text();

        }
    </script>

    <!--搜索的action-->
    <script type="text/javascript">
        function searchToggle(obj, evt) {
            var container = $(obj).closest('.search-wrapper');

            if (!container.hasClass('active')) {
                container.addClass('active');
                evt.preventDefault();
            }
            else if (container.hasClass('active') && $(obj).closest('.input-holder').length == 0) {
                container.removeClass('active');
                // clear input
                container.find('.search-input').val('');
                // clear and hide result container when we press close
                container.find('.result-container').fadeOut(100, function () {
                    $(this).empty();
                });
            }
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
            $('#btn1').attr('disabled','true');
            //使用post请求打开文档的action
            $.post(strUrl,{ param2: "456"},function(data){
                $("#divDocView").html(data);
            });
        }

    </script>


</head>
<body>
<%@include file="header.jsp"%>
<section class="cd-hero">
    <img src="../img/img-order/cd-hero-background.jpg" alt="背景"
         style="height :100%; width :100%; margin-top: 0px;"/>
    <!--<img src="../img/img-order/cd-hero-background.jpg" alt="背景" style="height :100%; width :100%; margin-top: 0px;"/>-->

    <div class="cd-hero-content">
        <!-- your content here -->
    </div>
</section> <!-- .cd-hero -->

<nav class="cd-secondary-nav">

    <!--左侧操作，增/删/改-->
    <div style="display: inline;width: 100px">
        <div>
            <ul>
                <li style="float: left"><a href="#0" id="edit">修改</a></li>
                <li style="float: left"><a href="#0" id="save">保存</a></li>
                <li style="float: left"><a href="#0" id="add">添加表</a></li>
                <li style="float: left"><a href="#0" id="delet">删除表</a></li>
                <li style="float: left"><a href="#0" id="updata">上传表</a></li>
                <li style="float: left"><a href="#0" id="search">搜索表</a></li>
            </ul>
        </div>
    </div>

    <!--中间搜索-->
    <%--<div style="display: inline;width: 300px">--%>
        <%--<div class="search-wrapper">--%>
            <%--<div class="input-holder">--%>
                <%--<form action="searchorder" method="get">--%>
                    <%--<input type="text" name="orderNum" class="search-input" placeholder="请输入单号"/>--%>
                    <%--<input type="submit" class="search-icon" onclick="searchToggle(this,event)" value="搜索"--%>
                           <%--style="color: #25283b;font-size: 15px"/>--%>
                <%--</form>--%>
            <%--</div>--%>
            <%--<span class="close" onclick="searchToggle(this, event);"></span>--%>
        <%--</div>--%>
    <%--</div>--%>
    <!--搜索-->
    <!--右侧操作，选择表-->
    <div class="dropdown" style="position: absolute; top: 0px;left: 80%">
        <a class="dropbtn">选择随工单类型</a>
        <div class="dropdown-content">
            <a id="ct1" href="#" onclick="chosetable()">老化观测表</a>
            <a href="#">整机调试报告单</a>
            <a href="#">最终检验报告单</a>
            <a href="#">整机检验报告单</a>
            <a href="#">仪器备忘录</a>
            <a href="#">随工单表</a>
            <a href="#">装箱记录单</a>
            <a href="#">性能要求检验单</a>
            <a href="#">工序检验报告单</a>
            <a href="#">成品检验报告单</a>
            <a href="#">返工记录表</a>
            <a href="#">血压计检定报告单</a>
            <a href="#">+添加新的表+</a>
        </div>
    </div>
    <!--添加块-->
    <%--添加文件夹--%>
    <%--Json，弹出窗口--%>
    <div id="divadd" style="width: 390px;
    height: 80px;
    background-color: #25283b;
    overflow: hidden;
    /*border-bottom-right-radius:10px;*/
    display: none;
    box-shadow: 5px 5px 10px #888888">
        <div style="text-align:left;">
            <form action="addorder" method="get">
                <p style="color:#a8a9b1 ">选择路径: <input type="file" name="path"/></p>
                <p style="color:#a8a9b1 ">选择名称: <input type="text" name="number"/></p>
                <input type="submit" value="Submit"/>
            </form>
        </div>
    </div>

    <!--删除块-->
    <%--Json，弹出窗口--%>
    <div id="divdelet" style="width: 390px;
    height: 30px;
    background-color: #25283b;
    overflow: hidden;
    /*border-bottom-right-radius:10px;*/
    display: none;
    box-shadow: 5px 5px 10px #888888">
        <div style="text-align:center;">
            <form action="deletorder" method="get">
                <!--输入删除的随单表号码-->
                <p style="color: #a8a9b1">
                    随工单编号：<input name="name" type="text"/>
                    <input type="submit" value="确定"/>
                </p>
            </form>
        </div>
    </div>

    <!--上传块-->
    <%--Json，弹出窗口--%>
    <div id="divupdata" style="width: 450px;
    height: 140px;
    background-color: #25283b;
    overflow: hidden;
    /*border-bottom-right-radius:10px;*/
    display: none;
    box-shadow: 5px 5px 10px #888888">
        <div style="text-align:right; width: 300px">
            <form action="updateorder" method="get">
                <p style="color: #a8a9b1">随工单编号: <input type="text" name="orderNum"/></p>
                <p style="color: #a8a9b1">工序: <input type="text" name="process"/></p>
                <p style="color: #a8a9b1">操作者: <input type="text" name="operater"/></p>
                <p style="color: #a8a9b1">其他: <input type="text" name="other"/></p>
                <p style="color: #a8a9b1">备注: <input type="text" name="ps"/></p>
                <input type="submit" value="更新"/>
            </form>
        </div>
    </div>

    <!--搜索-->
    <%--Json，弹出窗口--%>
    <div id="divsearch" style="width: 530px;
    height: 40px;
    background-color: #25283b;
    overflow: hidden;
    /*border-bottom-right-radius:10px;*/
    display: none;
    box-shadow: 5px 5px 10px #888888">
        <div style="text-align:right; width: 300px">
            <form action="searchorder" method="get">
                <input type="text" name="orderNum" class="search-input" placeholder="请输入单号"/>
                <a href="javascript:POBrowser.openWindow('/selectorder','width=1200px;height=800px;');">open</a>
                <%--<input type="submit" class="search-icon"  value="搜索" style="color: #25283b;font-size: 15px"/>--%>
            </form>
        </div>
    </div>
</nav> <!-- .cd-secondary-nav -->


<main class="cd-main-content sub-nav-hero">
    <div>
        <header class="htmleaf-header">
            <h1>随工单管理 <span>something in here</span></h1>
            <div class="htmleaf-demo center">
                <a href="ordermanagement.html" class="current">显示当前类名</a>
            </div>
        </header>
        <div align="center" style="height: 600px;position: relative">
            插件操作：
            <a href="javascript:POBrowser.openWindow('/selectorder','width=1200px;height=800px;');">open</a>
            <!--<iframe id="pageEditor" src="files/tempe2h.html" width=80% height=100% scrolling="yes"-->
            <!--frameborder="0"></iframe>-->
        </div>
    </div>
</main> <!-- .cd-main-content -->
</body>
</html>
