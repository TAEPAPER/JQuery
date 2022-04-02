package memberController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import memberService.IMemberService;
import memberService.MemberServiceImple;
import memberVO.ZipVO;

/**
 * Servlet implementation class zipServlet
 */
@WebServlet("/zipServlet.do")
public class zipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String dong = request.getParameter("dong");
		  IMemberService  service = MemberServiceImple.getInstance();
		  List<ZipVO> list =service.zipList(dong);
		     
		Gson gson = new Gson();
		String result = gson.toJson(list);
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		 out.print(result);
		 out.flush();  

	}


}
