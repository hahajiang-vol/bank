<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="save.action" method="post">
		<s:textfield name="cno" label="卡号"></s:textfield>
		<s:textfield name="cname" label="持有人"></s:textfield>
		<s:textfield name="cmoney" label="初始资金"></s:textfield>
		
		<s:submit value="提交"></s:submit>
		
	</s:form>
</body>
</html>