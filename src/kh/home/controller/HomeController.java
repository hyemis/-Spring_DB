package kh.home.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.board.model.service.BoardService;
import kh.board.model.vo.BoardVo;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({"/", "/main", "/index", "/home"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aaa = request.getParameter("aaa");
		
		//2. DB 다녀오기 
		//dto, vo, service, controller, view
		
		
		
		// Paging 처리 
		// 1 - 총 글의 개수 알아오기 (DB)
		int cnt = 0;
		cnt = service.getCountBoard();
		// 2 - 한 페이지에 나타날 글의 수 정하기 
		int pageSize = 2; // 보통은 10개 
		
		// 3 - 하단에 몇 개의 페이지 번호 나타낼 것인지 정하기
		int pageBlock = 3;
		
		// 4 - 현재 페이지 default 1, 사용자가 페이지 번호 클릭 시에는 변경 
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(aaa);
		} catch(Exception e) {e.printStackTrace();}
		
		// 5 - row num 범위 정하기 
		int startRnum = 0;
		int endRnum = 0;
		startRnum = ((currentPage-1) * pageSize)+1;  // 1-1, 2-4
		endRnum = (startRnum+pageSize-1 > cnt) ?  cnt : startRnum+pageSize-1 ;
		System.out.println(startRnum);
		System.out.println(endRnum);
		request.setAttribute("boardlist", service.getBoardList(startRnum,endRnum));
		
		// 6-페이지 범위정하기
		int startPageNum = 0;
		int endPageNum = 0;
		startPageNum = (currentPage % pageBlock == 0) 
				? (( currentPage/pageBlock - 1) * pageBlock + 1) 
				: (( currentPage/pageBlock ) * pageBlock + 1);
		int pageCnt = (cnt/pageSize) + (cnt % pageSize == 0 ? 0 : 1);
//		if(cnt % pageSize != 0 ) {
//			pageCnt++;
//		}
		endPageNum = (startPageNum + pageBlock - 1 > pageCnt) ? pageCnt : startPageNum + pageBlock - 1;
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCnt", pageCnt);

		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	
	}


}
