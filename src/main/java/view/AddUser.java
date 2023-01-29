package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDAO;
import model.UserVO;

/**
 * Servlet implementation class AddUser
 */
//@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC_KR");
		response.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(true);
		
		boolean addUserResult = false;
		
		UserVO userVO = new UserVO();
		
		userVO.setUserName(request.getParameter("userName"));
		userVO.setSex(request.getParameter("sex"));
		userVO.setBirthDay(request.getParameter("birthYear"),request.getParameter("birthMonth"),request.getParameter("birthDate"));
		userVO.setJobs(request.getParameter("jobs"));
		userVO.setCellNum(request.getParameter("cellCountryCode"),request.getParameter("cellMidNum"),request.getParameter("cellLastNum"));
		userVO.setAddr(request.getParameter("addr"));
		
		
		
		UserDAO userDAO = new UserDAO();
		addUserResult = userDAO.addUser(userVO);
		
		if(addUserResult) {
			session.setAttribute("userVO", userVO);
		}
		
		out.println("<html>\r\n"
				+ "    <head></head>\r\n"
				+ "    <body>\r\n"
				+ "        <h2>Login화면</h2>");
		
		if(addUserResult) {
			out.println("가입 성공");
			out.println("<p><p><a href = './addUser.html'>뒤로</a></p>\r\n");
			out.println("<p><p><a href = './findUser.html'>내 정보 보기</a></p>\r\n");
			out.println("<p><p><a href = './FindUser'>내 정보 보기2</a></p>\r\n");
		} else {
			out.println("가입실패");
		}
		
		
		out.println("</body></html>");
		// TODO Auto-generated method stub
	}

}
