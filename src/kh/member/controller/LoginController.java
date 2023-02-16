package kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.dao.MemberDao;
import kh.member.model.service.MemberService;
import kh.member.model.vo.MemberVo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login Post");
		
		//1.
		MemberVo vo = new MemberVo();
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
//		String id = request.getParameter("id");
//		String passwd = request.getParameter("passwd");
		
		//2. DB
		MemberVo result = new MemberService().login(vo);
		if(result != null) {
			request.getSession().setAttribute("lgnss", result);
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
		// 3. 페이지 이동 및 데이터 전달 
		// 3.1 response.sendRedirect(request.getContextPath()+"url");
		// 3.2 request.setAttribute("name1", "값")
		// 3.2 request.getReqeuestDispatcher().forward() jsp 로 이동 후
		// 3.3 out.println(값); out.flush(); out.close();
		response.sendRedirect(request.getContextPath()+"/");

	}
}
