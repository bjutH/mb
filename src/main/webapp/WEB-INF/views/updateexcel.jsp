<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<form action="updateorder" method="get">
		<p>随工单编号: <input type="text" name="orderNum" /></p>
		<p>工序: <input type="text" name="process" /></p>
		<p>操作者: <input type="text" name="operater" /></p>
		<p>其他: <input type="text" name="other" /></p>
		<p>备注: <input type="text" name="ps" /></p>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>