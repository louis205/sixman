<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="//code.jquery.com/jquery.min.js"></script>
<c:if test="${requestScope.memberVO==null }">

<script type="text/javascript">
alert("찾는 회원이없습니다!");
location.href="member/find.do";
</script>
</c:if>
${param.id} 아이디에 대한 검색결과화면입니다. <br>
${requestScope.memberVO}
