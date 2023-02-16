package kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.tags.shaded.org.apache.xpath.operations.String;

import kh.member.model.service.MemberService;
import kh.member.model.vo.MemberVo;

/**
 * Servlet implementation class MyInfoController
 */
@WebServlet("/myinfo")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 은 없음 / 단 session 으로부터 가져오는 작업 진행 
		String id = null;
		if(request.getSession().getAttribute("lgnss") != null) {
			id = ((MemberVo)(request.getSession().getAttribute("lgnss"))).getId();
		}else {
			
		}
		
		// 2. 나의 id 에 해당하는 정볼르 db 에서 읽어오기 ㅅ
		if(id !=null) {
			request.setAttribute("myinfo", new MemberService().myInfo(id));
		} else {
			
		}
		
		// 수정 
		request.getRequestDispatcher("/WEB-INF/view/member/myinfo.jsp").forward(request, response);
	
	}


}
