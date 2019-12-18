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
	<form action="update.action?cid=<s:property value='card.cid'/>" method="post">
		帐号<input type="text" name="cno" value="<s:property value='card.cno'/>"></input><br/>
		持卡人<input type="text"  name="cname" value="<s:property value='card.cname'/>"></input><br/>
		金额<input type="text"  name="cmoney" value="<s:property value='card.cmoney'/>"></input><br/>
		
		<input type="submit" value="提交"></input>
		
	</form>
</body>
</html>