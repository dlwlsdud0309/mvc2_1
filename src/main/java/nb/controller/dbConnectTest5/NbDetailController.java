package nb.controller.dbConnectTest5;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.dao.NoticeBoardsDao;
import nb.vo.NoticeBoards;

public class NbDetailController {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NbDetailController 확인");
		
		String num = request.getParameter("no");
		
		if(num==null){
			System.out.println("null");
			response.sendRedirect("noticeboards.jsp");
			return;
			//참조사이트 : https://findmypiece.tistory.com/55
		}

		NoticeBoardsDao dao = new NoticeBoardsDao();
		NoticeBoards nb = dao.getNBD(num);
		String loginId = nb.getWriter();
		
		request.setAttribute("nb", nb);
		request.setAttribute("loginId", loginId);
		
		System.out.println("loginId : "+loginId);
	
		request.getRequestDispatcher("noticeboardsDetail.jsp").forward(request, response);
	}
}
