<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kh 회원가입</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<section>
		<h1> 회원가입 </h1>
		<form action="<%=request.getContextPath()%>/enroll" method="post">
		   id:<input type ="text" name="id">
		   <br>
		   pw:<input type="password" name ="passwd">
		   <br>
		   name:<input type="text" name ="name">
		   <br>
		   email:<input type="text" name ="email">
		   <br>
		   <button type="sumbit">회원가입</button>
  	 	</form>
	</section>
	
<script>
 <!-- 이벤트를 처리하는 부분이 필요 -->
    $("#dupId").click(checkDupId);
    function checkDupId(){
       $.ajax({
          url:"<%=request.getContextPath()%>/dupid.lo" 
            , type:"post"
            , async:false
            , data:{id: $("input[type=text]").first().val()} 
          , success: function(result){
             console.log(result);
             if(result == 1){
                $("#dupId").next().html("중복아이디가 있습니다. 다시 입력해주세요.");
                $("#dupId").next().css("color","red");   
             }else{
                $("#dupId").next().html("사용가능 아이디입니다. ");
                $("#dupId").next().css("color","blue");
             }
          }
          , error : function(request, status, error){
             alert(request.status);
          }
       , });
    }
<!--$.ajax();에서 달러가 객체이름이 되는거..달러=제이쿼리..?-->
<!--오브젝트에는 정해진 key를 써야 함 url같은거-->
</script>
</body>
</html>