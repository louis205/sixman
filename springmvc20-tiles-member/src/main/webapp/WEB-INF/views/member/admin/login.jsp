<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
<c:when test="${empty sessionScope.mvo }">
<form action="${pageContext.request.contextPath }/loginForm.do" method="post">
아이디 : <input type="text" name="id">
패스워드 : <input type="password" name="password">
<input type="submit" value="로그인">
</form>
</c:when>
<c:otherwise>
${sessionScope.mvo }
<form action ="${pageContext.request.contextPath }/logout.do">
<input type="submit" id ="logoutBtn" value="로그아웃">
</form>
</c:otherwise>
</c:choose>