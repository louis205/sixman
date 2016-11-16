<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){		
		$("#address").change(function(){				
			$("#memberListView").empty();
			if($("#address").val()==""){
				return;
			}
			$.ajax({
				type:"post",
				url:"findMemberListByAddress.do",
				data:"address="+$("#address").val(),
				dataType:"json",
				success:function(json){					
						var data="<table border='1' cellpadding='5'>";
						for(var i=0;i<json.length;i++){
							data+="<tr>";
							data+="<td>"+json[i].id+"</td>";
							data+="<td>"+json[i].name+"</td>";
							data+="</tr>";
						}
						data+="</table>";
						$("#memberListView").html(data);				
				}//function
			});//ajax
		});//click
	});//jquery
</script>
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/home.do">홈</a>
<hr>
<select id="address">
	<option value="">--주소--</option>
	<c:forEach items="${list}" var="addr">
	<option value="${addr}">${addr}</option>
	</c:forEach>
</select>  
<br><br><br><br>
<div id="memberListView"></div>
</body>
</html>