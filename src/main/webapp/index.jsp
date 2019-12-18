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
	<a href="save.jsp">增加</a>
	<table>
		<caption>储蓄卡表</caption>
		<thead>
			<tr>
				<th>序号</th>
				<th>卡号</th>
				<th>持卡人</th>
				<th>资金</th>
				<th>修改</th>
			</tr>
		</thead>
		
		<tbody>
			<s:iterator value="list" status="i">
				<tr>
					<td><s:property value="#i.count"/></td>
					<td><s:property value="cno"/></td>
					<td><s:property value="cname"/></td>
					<td><s:property value="cmoney"/></td>
					<td><a href="updateForm.action?cid=<s:property value="cid"/>" >修改</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>