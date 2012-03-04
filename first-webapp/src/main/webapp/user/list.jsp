<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Users</title>
</head>
<body>
<p>
<jsp:include page="/common/_session_control.jsp" ></jsp:include>
</p>
	<table>
		<thead>
			<tr>
				<th>UserName</th>
				<th>Password</th>
				<th>Email</th>
				<th>Date of Birth</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="user">
				<tr>
					<th>${user.username}</th>
					<th>${user.password}</th>
					<th>${user.email}</th>
					<th><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" /> </th>
					<th><a href="#">show</a> | <a href="#">edit</a> | <a href="#">delete</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>