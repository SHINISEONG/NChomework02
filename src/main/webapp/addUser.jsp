<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="model.*" %>
<%
request.setCharacterEncoding("EUC_KR");


boolean addUserResult = false;

UserVO userVO = new UserVO();

userVO.setUserName(request.getParameter("userName"));
userVO.setSex(request.getParameter("sex"));
userVO.setBirthDay(request.getParameter("birthYear"),request.getParameter("birthMonth"),request.getParameter("birthDate"));
userVO.setJobs(request.getParameter("jobs"));
userVO.setCellNum(request.getParameter("cellCountryCode"),request.getParameter("cellMidNum"),request.getParameter("cellLastNum"));
userVO.setAddr(request.getParameter("addr"));

System.out.println(userVO);


UserDAO userDAO = new UserDAO();
addUserResult = userDAO.addUser(userVO);

if(addUserResult) {
	session.setAttribute("userVO", userVO);
}
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h2>Login화면</h2>
		
		<% if(addUserResult) { %>
			가입 성공<br>
			<p><p><a href = './addUser.html'>뒤로</a></p>
			<p><p><a href = './findUser.html'>내 정보 보기</a></p>
			<p><p><a href = 'findUser.jsp'>내 정보 보기2</a></p>
		<%} else { %>
			가입실패
		<%} %>

</body>
</html>