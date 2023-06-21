package nb.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nb.controller.dbConnectTest5.NbDetailController;
import nb.controller.dbConnectTest5.NbEditController;

public class MyDispatcher extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(".do 신호 확인");
		
		String uri = request.getRequestURI(); // /ContextPath(=Context root)명/폴더명/파일명.do
		String conPath = request.getContextPath(); // /ContextPath(=Context root) 명
		String com = uri.substring(conPath.length());// /ContextPath(=Context root) 명 제외한 /폴더명/파일명.do
//		System.out.println("uri : "+uri);
//		System.out.println("conPath : "+conPath);
		System.out.println("com : "+com);
//		System.out.println(conPath.length());
		
		NbDetailController controller1 = new NbDetailController();
		NbEditController controller2 = new NbEditController();
		
		try {
			if(com.equals("/dbConnectTest5_notices/noticeboardsDetail.do")) {
				controller1.execute(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
