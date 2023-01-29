package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import model.UserDAO;
import model.UserVO;

/**
 * Servlet implementation class AddUser
 */
//@WebServlet("/AddUser")
public class FindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC_KR");
		response.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
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
		out.println("<html>\r\n" + "    <head></head>\r\n" + "    <body>\r\n" + "        <h2>ȸ�� ��ȸ ȭ��</h2>");

		if (findUserResult) {
			out.println(userVO);
		} else {
			out.println("<br/>ȸ���� �ƴմϴ�.");
		}

		out.println("<p><p><a href = './findUser.html'>�ڷ�</a></p>\r\n");
		out.println("</body></html>");

		userName = "";
		// TODO Auto-generated method stub
	}

}
