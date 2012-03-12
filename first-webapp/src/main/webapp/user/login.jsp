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
<title>Login</title>
</head>
<body>
	<form action="<c:url value="/user/login"></c:url>" method="post">
		<fieldset>
			<legend>Login</legend>
			<label for="username">User Name : </label><input type="text" name="username"/>
			<br/>
			<label for="password">Password : </label><input type="password" name="password"/>
			<br/>
			<input type="checkbox" name="remember"/><label for="remember">remember me for next 2 weeks</label>
			<br/>	
			<input type="hidden" name="method" value="login"/>
			<input type="submit" value="Sign In"/>
			<input type="button" value="Register" onclick="document.forms[1].submit();"/>
		</fieldset>
	</form>
	<form action="<c:url value="/user/register"></c:url>" method="get">
	</form>
</body>
</html>