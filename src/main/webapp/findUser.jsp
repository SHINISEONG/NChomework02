<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="model.*" %>
<%
request.setCharacterEncoding("EUC_KR");
UserVO userVO = null;
String userName = request.getParameter("userName");
boolean findUserResult = false;

if (!(userName == null || userName == "")) {
	userVO = new UserVO();
	UserDAO userDAO = new UserDAO();
	findUserResult = userDAO.findUser(userName, userVO);
	
} else {
	userVO = (UserVO) session.getAttribute("userVO");
	UserDAO userDAO = new UserDAO();
	findUserResult = userDAO.findUser(userVO.getUserName(), userVO);
}
System.out.println(userVO);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <h2>회원 조회 화면</h2>
	
	
		<% if (findUserResult) {%>
			<%=userVO %>
		<%} else {%>
			<br/>회원이 아닙니다.
		<%}%>

		<p><p><a href = 'findUser.html'>뒤로</a></p>
</body>
</html>