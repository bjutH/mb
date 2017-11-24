<%@ page language="java"
         import="java.util.*,com.zhuozhengsoft.pageoffice.*"
         pageEncoding="utf-8"%>
<%
    PageOfficeCtrl poCtrl=new PageOfficeCtrl(request);
//设置服务器页面
    poCtrl.setServerPage(request.getContextPath()+"/poserver.zz");
    poCtrl.addCustomToolButton("保存", "Save()", 1);
    poCtrl.addCustomToolButton("打印", "PrintFile()", 6);
    poCtrl.addCustomToolButton("全屏/还原", "IsFullScreen()", 4);
    poCtrl.addCustomToolButton("关闭", "CloseFile()", 21);
//设置保存页面
    poCtrl.setSaveFilePage("savefile");
//打开Word文档
    if(session.getAttribute("OpenModeType").equals("OpenModeType.xlsNormalEdit")) {
        poCtrl.webOpen(session.getAttribute("path").toString(), OpenModeType.xlsNormalEdit, "麦邦光电");
    }
    else {
        poCtrl.webOpen(session.getAttribute("path").toString(), OpenModeType.xlsReadOnly, "麦邦光电");
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>最简单的打开保存Word文件</title>
</head>
<body>
<!-- PageOffice.js文件一定要引用 -->
<script type="text/javascript" src="../../jquery.min.js"></script>
<script type="text/javascript" src="../../pageoffice.js"  id="po_js_main"></script>
<script type="text/javascript">
    function Save() {
        document.getElementById("PageOfficeCtrl1").WebSave();

    }
    function PrintFile(){
        document.getElementById("PageOfficeCtrl1").ShowDialog(4);

    }
    function IsFullScreen(){
        document.getElementById("PageOfficeCtrl1").FullScreen = !document.getElementById("PageOfficeCtrl1").FullScreen;

    }
    function CloseFile(){
        POBrowser.closeWindow();

    }
</script>
<%--<div style="position:absolute;left:5px;top:10px; width:1100px; height:100px;"><img src="../images/oa1.png" /></div>--%>
<div style="position:absolute;left:5px;top:5px;width:1175px; height:670px;">
    <%=poCtrl.getHtmlCode("PageOfficeCtrl1")%>
</div>

</body>
</html>
