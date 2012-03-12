<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<c:choose>
	<c:when test="${sessionScope['CURRENT_USER'] != null}">
${CURRENT_USER.username}, <a href="#" onclick="document.forms[0].submit();">Sign Out</a>
<!-- this submit is not good, consider change -->
	</c:when>
	<c:otherwise>
		<a href="<c:url value="/user/login"></c:url>">Sign In</a>
	</c:otherwise>
</c:choose>
<form action="<c:url value="/user/logout"></c:url>" method="post">
	<input type="hidden" name="method" value="logout">
</form>