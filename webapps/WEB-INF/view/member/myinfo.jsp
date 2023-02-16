<%@page import="kh.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>

내정보보기 
<br>

ID: ${lgnss.id }
				<br>
NAME:  ${lgnss.name }
				<br>
EMAIL:  ${lgnss.email }



<hr>


<%
	Object obj = request.getAttribute("myinfo");
	MemberVo vo = null;
	if(obj == null){
%>
		<h4>로그인 되지 않았습니다. 정보가 없습니다.</h4>
		<a href="<%=request.getContextPath()%>/Login">로그인 페이지로 이동</a>
<%
		} else {
			if(obj instanceof MemberVo) {
				vo = (MemberVo)obj;
			}
			if(vo == null){
%>
				<h4>로그인 되지 않았습니다. 정보가 없습니다.</h4>
				<a href="<%=request.getContextPath()%>/Login">로그인 페이지로 이동</a>
<%								
			} else {
%>
				ID: <%=vo.getId() %>
				<br>
				NAME: <%=vo.getName() %>
				<br>
				EMAIL: <%=vo.getEmail() %>
<% 
			}
		}
%>


</body>
</html>