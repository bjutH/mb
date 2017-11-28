<%@ page import="sun.org.mozilla.javascript.internal.Function" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>随工单管理</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!--引用路径-->
    <link href="https://fonts.googleapis.com/css?family=David+Libre|Hind:400,700" rel="stylesheet"/>
    <link rel="stylesheet" href="../css/css-order/reset.css"/> <!-- CSS reset -->
    <link rel="stylesheet" type="text/css" href="../css/css-order/htmleaf-demo.css"/>
    <link rel="stylesheet" href="../css/css-order/style.css"/> <!-- Resource style -->
    <link rel="stylesheet" href="../css/mycss.css"/>
    <link rel="stylesheet" type="text/css" href="../css/css-search/search-form.css"/>
    <script src="../js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="../js/js-order/main.js"></script> <!-- Resource jQuery -->
    <script type="text/javascript" src="../../pageoffice.js" id="po_js_main"></script>

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
                if (!$('#divdelet').is(":hidden")) {
                    $('#divdelet').toggle('slow');
                }
            })

            $('#add').click(function (event) {
                if (!$('#divupdata').is(":hidden")) {
                    $('#divupdata').toggle('slow');
                }
            })

            $('#add').click(function (event) {
                if (!$('#divsearch').is(":hidden")) {
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
                if (!$('#divadd').is(":hidden")) {
                    $('#divadd').toggle('slow');
                }
            })

            $('#delet').click(function (event) {
                if (!$('#divupdata').is(":hidden")) {
                    $('#divupdata').toggle('slow');
                }
            })

            $('#delet').click(function (event) {
                if (!$('#divsearch').is(":hidden")) {
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
            $('#btn1').attr('disabled', 'true');
            //使用post请求打开文档的action
            $.post(strUrl, {param2: "456"}, function (data) {
                $("#divDocView").html(data);
            });
        }

    </script>

    <%--form加iframe,避免更新，--%>
    <script type="text/javascript">
        function displayorder() {
            document.getElementById("test1").innerText = "当前类型：" + document.getElementById("order").innerText;
        };

        function displaymemo() {
            document.getElementById("test1").innerText = "当前类型：" + document.getElementById("memo").innerText;
        };

        function displayremade() {
            document.getElementById("test1").innerText = "当前类型：" + document.getElementById("remade").innerText;
        };

        function displayaging() {
            document.getElementById("test1").innerText = "当前类型：" + document.getElementById("aging").innerText;
        };

        function displaypack() {
            document.getElementById("test1").innerText = "当前类型：" + document.getElementById("pack").innerText;
        };

        function displaydebug() {
            document.getElementById("test1").innerText = "当前类型：" + document.getElementById("debug").innerText;
        };

        function displayprocessTest() {
            document.getElementById("test1").innerText = "当前类型：" + document.getElementById("processTest").innerText;
        };

        function displaymachineTest() {
            document.getElementById("test1").innerText = "当前类型：" + document.getElementById("machineTest").innerText;
        };

        function displayproductTest() {
            document.getElementById("test1").innerText = "当前类型：" + document.getElementById("productTest").innerText;
        };

        function displaysphygmomanometer() {
            document.getElementById("test1").innerText = "当前类型：" + document.getElementById("sphygmomanometer").innerText;
        };

        function displayperformTest() {
            document.getElementById("test1").innerText = "当前类型：" + document.getElementById("performTest").innerText;
        };

        function displayfinalTest() {
            document.getElementById("test1").innerText = "当前类型：" + document.getElementById("finalTest").innerText;
        };
    </script>

    <script type="text/javascript">
        function checkform(){
            if(document.getElementById('inp1').value.length==0){
                alert('路径为空！');
                document.getElementById('ipt1').focus();
                return false;
            }
            if(document.getElementById('inp1').value=="请输入搜索内容"){
                alert('输入为空！');
                document.getElementById('ipt1').focus();
                return false;
            }
        }
        function checkform(){
            if(document.getElementById('inp2').value.length==0){
                alert('输入为空！');
                document.getElementById('ipt2').focus();
                return false;
            }
            if(document.getElementById('inp2').value=="请输入搜索内容"){
                alert('输入为空！');
                document.getElementById('ipt2').focus();
                return false;
            }
        }
        function checkform(){
            if(document.getElementById('inp3').value.length==0){
                alert('输入为空！');
                document.getElementById('ipt3').focus();
                return false;
            }
            if(document.getElementById('inp3').value=="请输入搜索内容"){
                alert('输入为空！');
                document.getElementById('ipt3').focus();
                return false;
            }
        }
        function checkform(){
            if(document.getElementById('inp4').value.length==0){
                alert('输入为空！');
                document.getElementById('ipt4').focus();
                return false;
            }
            if(document.getElementById('inp4').value=="请输入搜索内容"){
                alert('输入为空！');
                document.getElementById('ipt4').focus();
                return false;
            }
        }
    </script>

</head>
<body>
<%@include file="header.jsp" %>
<section class="cd-hero">
    <img src="../img/img-order/cd-hero-background.jpg" alt="背景"
         style="height :100%; width :100%; margin-top: 0px;"/>
    <!--<img src="../img/img-order/cd-hero-background.jpg" alt="背景" style="height :100%; width :100%; margin-top: 0px;"/>-->

    <div class="cd-hero-content">
        <!-- your content here -->
    </div>
</section> <!-- .cd-hero -->

<nav class="cd-secondary-nav">
    <%--避免刷新，不能接收返回--%>
    <iframe name='hidden_frame' id="hidden_frame" style="display:none"></iframe>
    <!--左侧操作，增/删/改-->
    <div style="display: inline;width: 100px">
        <div>
            <ul>
                <%--<li style="float: left"><a href="#0" id="edit">修改</a></li>--%>
                <%--<li style="float: left"><a href="#0" id="save">保存</a></li>--%>
                <li style="float: left"><a href="#0" id="add">添加表</a></li>
                <li style="float: left"><a href="#0" id="delet">删除表</a></li>
                <%--<li style="float: left"><a href="#0" id="updata">上传表</a></li>--%>
                <li style="float: left"><a href="#0" id="search">搜索表</a></li>
            </ul>
        </div>
    </div>
        <%--<div style="position: relative; text-align: center ;max-height: 50px; min-width: 100px;top: -70px;">--%>
            <%--<a href="javascript:POBrowser.openWindow('/show','width=1200px;height=800px;');">打开当前选择的文件</a>--%>
        <%--</div>--%>

        <%--右侧下拉菜单，改上拉--%>
    <div class="dropdown" style="position: absolute; top: 0px; right: 0px">
        <a id="test1" class="dropbtn">选择表类型</a>
        <div class="dropdown-content" style="position: absolute;bottom: 100%">
            <form id="selectorder" action="selectordertype" method="post" target="hidden_frame">
                <input type="hidden" name="orderType" value="order"/>
                <a href="javascript:displayorder();" id="order"
                   onclick="document.getElementById('selectorder').submit();">随工单</a><%--order--%>
            </form>
            <form id="selectmemo" action="selectordertype" method="post" target="hidden_frame">
                <input type="hidden" name="orderType" value="memo"/>
                <a href="javascript:displaymemo();" id="memo" onclick="document.getElementById('selectmemo').submit();">仪器备忘录</a><%--memo--%>
            </form>
            <form id="selectremade" action="selectordertype" method="post" target="hidden_frame">
                <input type="hidden" name="orderType" value="remade"/>
                <a href="javascript:displayremade();" id="remade"
                   onclick="document.getElementById('selectremade').submit();">返工记录表</a><%--remade--%>
            </form>
            <form id="selectaging" action="selectordertype" method="post" target="hidden_frame">
                <input type="hidden" name="orderType" value="aging"/>
                <a href="javascript:displayaging();" id="aging"
                   onclick="document.getElementById('selectaging').submit();">老化观测表</a><%--aging--%>
            </form>
            <form id="selectpack" action="selectordertype" method="post" target="hidden_frame">
                <input type="hidden" name="orderType" value="pack"/>
                <a href="javascript:displaypack();" id="pack" onclick="document.getElementById('selectpack').submit();">装箱记录单</a><%--pack--%>
            </form>
            <form id="selectdebug" action="selectordertype" method="post" target="hidden_frame">
                <input type="hidden" name="orderType" value="debug"/>
                <a href="javascript:displaydebug();" id="debug"
                   onclick="document.getElementById('selectdebug').submit();">整机调试报告单</a><%--debug--%>
            </form>
            <form id="selectprocessTest" action="selectordertype" method="post" target="hidden_frame">
                <input type="hidden" name="orderType" value="processTest"/>
                <a href="javascript:displayprocessTest();" id="processTest"
                   onclick="document.getElementById('selectprocessTest').submit();">工序检验报告单</a><%--processTest--%>
            </form>
            <form id="selectmachineTest" action="selectordertype" method="post" target="hidden_frame">
                <input type="hidden" name="orderType" value="machineTest"/>
                <a href="javascript:displaymachineTest();" id="machineTest"
                   onclick="document.getElementById('selectmachineTest').submit();">整机检验报告单</a><%--machineTest--%>
            </form>
            <form id="selectproductTest" action="selectordertype" method="post" target="hidden_frame">
                <input type="hidden" name="orderType" value="progressTest"/>
                <a href="javascript:displayproductTest();" id="productTest"
                   onclick="document.getElementById('selectproductTest').submit();">成品检验报告单</a><%--productTest--%>
            </form>
            <form id="selectsphygmomanometer" action="selectordertype" method="post" target="hidden_frame">
                <input type="hidden" name="orderType" value="sphygmomanometer"/>
                <a href="javascript:displaysphygmomanometer();" id="sphygmomanometer"
                   onclick="document.getElementById('selectsphygmomanometer').submit();">血压计检定报告单</a><%--sphygmomanometer--%>
            </form>
            <form id="selectperformTest" action="selectordertype" method="post" target="hidden_frame">
                <input type="hidden" name="orderType" value="pergormTest"/>
                <a href="javascript:displayperformTest();" id="performTest"
                   onclick="document.getElementById('selectperformTest').submit();">性能要求检验单</a><%--performTest--%>
            </form>
            <form id="selectfinalTest" action="selectordertype" method="post" target="hidden_frame">
                <input type="hidden" name="orderType" value="finalTest"/>
                <a href="javascript:displayfinalTest();" id="finalTest"
                   onclick="document.getElementById('selectfinalTest').submit();">最终检验报告单</a><%--finalTest--%><%--上传到selectordertype--%>
            </form>
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
            <form action="addorder" method="post" enctype="multipart/form-data">
                <p style="color:#a8a9b1 ">选择路径: <input id="inp1" type="file" name="uploadfile"/></p>
                <p style="color:#a8a9b1 ">选择名称: <input id="inp2" type="text" name="number"/></p>
                <input type="submit" value="Submit" onclick="checkform()"/>
            </form>
        </div>
    </div>

    <!--删除块-->
    <%--map，弹出窗口--%>
    <div id="divdelet" style="width: 390px;
    height: 30px;
    background-color: #25283b;
    overflow: hidden;
    /*border-bottom-right-radius:10px;*/
    display: none;
    box-shadow: 5px 5px 10px #888888">
        <div style="text-align:center;">
            <form action="deleteorder" method="get">
                <!--输入删除的随单表号码-->
                <p style="color: #a8a9b1">
                    随工单编号：<input id="inp3" name="name" type="text"/>
                    <input type="submit" value="确定" onclick="checkform()" />
                </p>
            </form>
        </div>
    </div>

    <!--上传块-->
    <%--map，弹出窗口--%>
    <div id="divupdata" style="width: 390px;
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
    <div id="divsearch" style="width: 390px;
    height: 40px;
    background-color: #25283b;
    overflow: hidden;
    /*border-bottom-right-radius:10px;*/
    display: none;
    box-shadow: 5px 5px 10px #888888">
        <div style="text-align:right; width: 300px">
            <form action="searchorder" method="get">
                <input type="text" name="orderNum" class="search-input" placeholder="请输入单号" id="inp4"/>
                <input type="submit" class="search-icon" value="搜索" style="color: #25283b;font-size: 15px" onclick="checkform()"/>
            </form>
        </div>
    </div>
</nav> <!-- .cd-secondary-nav -->


<main class="cd-main-content sub-nav-hero">
    <div>
        <header class="htmleaf-header">
            <div id="ordertype" class="htmleaf-demo center">
                <a href="javascript:POBrowser.openWindow('/show','width=1200px;height=800px;');">打开当前选择的文件</a>
            </div>
            <h1>随工单管理</h1>
            <h1><span>页面说明：当前页面可对随工单进行增删改查操作</span></h1>
        </header>
    </div>
</main>
<!-- .cd-main-content -->
</body>
</html>
