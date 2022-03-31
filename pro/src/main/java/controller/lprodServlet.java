package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ILprodService;
import service.LprodServiceImpl;
import vo.LprodVO;

/**
 * Servlet implementation class lprodServlet
 */
@WebServlet("/lprodServlet.do")
public class lprodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lprodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   //1.데이타 받기 but지금은 받은게 없어!
		   //2.service객체 만들기
		  ILprodService service = LprodServiceImpl.getInstance();
		    List<LprodVO> list = service.selectAll();
		    //3.request에 담아서 보내주기
		    request.setAttribute("listvalue",list);
		    //4.어디로 보내줄까?-jsp로 보내주기!!
		    request.getRequestDispatcher("03302/lprodList.jsp").forward(request, response);
		
	}

}
