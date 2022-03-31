package prodController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prodService.IProdService;
import prodService.prodServiceImpl;
import prodVo.prodVO;

/**
 * Servlet implementation class prodServlet
 */
@WebServlet("/prodServlet.do")
public class prodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.데이터 받기    
		String lgu = request.getParameter("lgu");
		//2.service객체 생성 
		IProdService service = prodServiceImpl.getInstance();
		  List<prodVO> list= service.selectByLgu(lgu);
		  
		  request.setAttribute("listvalue", list);
		  request.getRequestDispatcher("03302/prodList.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     //1.데이터 받기 --지금은 id
		         String id = request.getParameter("id");
		      //2.service 객체 생성
		   IProdService service = prodServiceImpl.getInstance();
		   prodVO vo = service.selectById(id);
		   request.setAttribute("vo", vo);
		   request.getRequestDispatcher("03302/prodDetail.jsp").forward(request, response);
		
		
		
		
		
	}

}
