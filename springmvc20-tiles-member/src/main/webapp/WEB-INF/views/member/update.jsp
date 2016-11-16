<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
회원수정
<form method="post" action="${pageContext.request.contextPath}/updateMemberAction.do">
<input type="hidden" name="command" value="update">
아이디 : <input type="text" name="id" value="${sessionScope.mvo.id}" readonly><br>
비밀번호 : <input type="password" name="password"><br>
이름 : <input type="text" name="name"><br>
주소 : <input type="text" name="address"><br>
<input type="submit" value="수정">
</form>


