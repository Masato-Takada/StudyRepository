<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メニュー画面</title>
</head>
<body>
	<h1>メニュー画面です</h1>
	<p><input type="button" value="登録処理" onClick="location.href='${pageContext.request.contextPath}/Entry'"></p>
	<p><input type="button" value="ログイン画面に戻る" onClick="location.href='./LoginAction.jsp'"></p>
</body>
</html>