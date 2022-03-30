package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class ProdServlet
 */
@WebServlet("/ProdServlet.do")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		               
		//lprod를 선택시 prod id와 name을 select
          
		   //1.전송 시 데이터 받기 --지금은 없어~
		      String lgu =    request.getParameter("lgu");
		      
		   //2.service객체 얻기
		    IProdService service = ProdServiceImpl.getInstance();
		   //3.service메소드 호출 - 결과값 return 받기
		    List<ProdVO> list = service.selectByLgu(lgu);
		    
		    
		    Gson gson = new Gson();
		    String result =  gson.toJson(list);
		    
		    response.setContentType("application/json; charset=utf-8");
		    PrintWriter out = response.getWriter();
		    out.print(result);
		    out.flush();      //out을 청소해주기
		    
		    
		    
		    
		    /*
		    //4.request에 결과값을 저장
		     request.setAttribute("listvalue", list);
		   //5.jsp로 위임(forward)하여 응답데이터 생성하기(출력하기 json데이터)
		     request.getRequestDispatcher("0330/prodList.jsp").forward(request, response);
		     */
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	          
			   String id    = request.getParameter("id");
	           IProdService service = ProdServiceImpl.getInstance();
	           ProdVO vo = service.selectById(id);
	           Gson gson = new Gson();
	           String result = gson.toJson(vo);
	           response.setContentType("application/json; charset=utf-8");
			   PrintWriter out = response.getWriter();
			   out.print(result);
			   out.flush();      //out을 청소해주기
			    
	           
	           
	          /* 
	           request.setAttribute("vo", vo);
	           request.getRequestDispatcher("0330/prodDetail.jsp").forward(request, response);
	           */
	
	
	
	}

}
