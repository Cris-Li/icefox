<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="searchcompany" method="get" name=myform>
		<div align="center">
			<strong><font size="6">企业信息查询</font></strong>
		</div>
		<table width="300" align="center">
			<tr>
				<td align="center">企业名称</td>
				<td align="center"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td align="center">邮箱地址:</td>
				<td align="center"><input type="text" name="email"></td>
			</tr>
			<tr>
				<td align="center">QQ:</td>
				<td align="center"><input type="text" name="qq"></td>
			</tr>
		</table>
		<div align="center">
			<input type="submit" name="bu1" value="查询" onclick="check()">
			&nbsp;&nbsp;&nbsp; <input type="reset" name="bu2" value="取消">
		</div>
	</form>

</body>
</html>