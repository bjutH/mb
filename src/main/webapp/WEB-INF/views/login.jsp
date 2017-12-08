<%@ page language="java" contentType="text/html; charset=utf-8"
		 import="java.util.*,com.zhuozhengsoft.pageoffice.*"
    pageEncoding="utf-8"%>
<%
	//获取客户端传递的参数
	out.println("param1:" + request.getParameter("param1"));
	out.println("<br>");
	out.println("param2:" + request.getParameter("param2"));

	PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
	//设置服务器页面
//	poCtrl.setServerPage(request.getContextPath() + "/poserver.zz");
//	poCtrl.setJsFunction_AfterDocumentOpened("AfterDocumentOpened");
//	poCtrl.addCustomToolButton("保存","Save",1);
//	poCtrl.setSaveFilePage("SaveFile.jsp");
//	poCtrl.webOpen("F:\\MB\\src\\main\\resources\\EXCEL\\随工单.xlsx", OpenModeType.xlsNormalEdit, "张佚名");
//	out.println();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<script type="text/javascript" src="../../jquery.min.js"></script>
	<script type="text/javascript" src="../../pageoffice.js" id="po_js_main"></script>
</head>
<body>
	<form action="login.action" method="get">
		名称：<input type="text"	name="name"><br>
		密码：<input type="text"	name="passWord"><br>  	
		<input type="submit" value="ok">
	</form>
	<a href="javascript:POBrowser.openWindow('/word?user=<% session.getAttribute("name");%>','width=1200px;height=800px;');" style="">open</a>
	<%--<div style=" width:auto; height:700px;" id="divDocView">--%>
		<%--<%= poCtrl.getHtmlCode("PageOfficeCtrl1")%>--%>
	<%--</div>--%>

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
</body>
</html>