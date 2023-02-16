<%@page import="kh.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>

<h2>내정보보기</h2>
<br>
<h4>EL request attribute</h4>
<c:if test="${empty myinfo }">
	<div>
	<h4>로그인 되지 않았습니다. 정보가 없습니다.</h4>
	<a href="<%=request.getContextPath()%>/Login">로그인 페이지로 이동</a>
	</div>
</c:if>
<c:if test="${not empty myinfo }">
	<h4>EL request attribute</h4>
	<div>
	ID: ${myinfo.id }
	<br>
	NAME:  ${myinfo.name }
	<br>
	EMAIL:  ${myinfo.email }
	</div>
</c:if>

<h4>EL session attribute</h4>
ID: ${lgnss.id }
<br>
NAME: ${lgnss.name }
<br>
EMAIL: ${lgnss.email }

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