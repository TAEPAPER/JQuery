package kr.or.ddit.zipboard.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.member.vo.ZipVO;
import kr.or.ddit.zipboard.service.IZipService;
import kr.or.ddit.zipboard.service.ZipServiceImpl;

/**
 * Servlet implementation class zipboardServlet
 */
@WebServlet("/zipboardServlet.do")
public class zipboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zipboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                      String  gubun =request.getParameter("gubun");
                     if(gubun.equals("1")) {
                    	 proc1(request, response);
                     }
		             if(gubun.equals("2")) {
		            	 proc2(request, response);
		             }
		             if(gubun.equals("3")) {
		            	 proc3(request, response);	 
		             }
		
		             if(gubun.equals("4")) {
		            	 proc4(request, response);
		             }
	}
   private void proc4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //디테일 출력하기
	   String sido= request.getParameter("sido");        
		 String gugun = request.getParameter("gugun");
		String dong = request.getParameter("dong");
		
		 ZipVO zipVO = new ZipVO();
         zipVO.setSido(sido);
         zipVO.setGugun(gugun);
         zipVO.setDong(dong);
		 IZipService service = ZipServiceImpl.getInstance();
		 List<ZipVO> list = service.selectDetail(zipVO);
		 
		 Gson gson = new Gson();
		 String result =  gson.toJson(list);
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();  

	}

//동구하기
   private void proc3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	                       //map에 담아주기
		 String sido= request.getParameter("sido");        
		 String gugun = request.getParameter("gugun");
          ZipVO zipVO = new ZipVO();
          zipVO.setSido(sido);
          zipVO.setGugun(gugun);
		 IZipService service = ZipServiceImpl.getInstance();
	
		 List<String> list= service.selectDong(zipVO); 
		 Set<String> list2 = new HashSet<String>(); //set은 중복될 수 없다
		 
		 for(int i =0; i<list.size(); i++) {
			 String dv =list.get(i);
			 String[] arr = dv.split(" ");
			 list2.add(arr[0]);
		 }
		 
		 Gson gson = new Gson();
		 String result =  gson.toJson(list2);
		
		 response.setContentType("application/json; charset=utf-8");
	     PrintWriter out = response.getWriter();
		
	     out.print(result); 
		
	}

   private void proc2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //동구하기      
	   //데이터 얻기
		     String sido=   request.getParameter("sido");
		     IZipService service = ZipServiceImpl.getInstance();
		              List<String>  list =  service.selectGugun(sido);
		              Gson gson = new Gson();
		     		  String result =  gson.toJson(list);
		     		
		     		  response.setContentType("application/json; charset=utf-8");
		     	      PrintWriter out = response.getWriter();
		     		
		     	      out.print(result); 
		     		
	}

	private void proc1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		                  IZipService service = ZipServiceImpl.getInstance();
		                  List<String>list = service.selectSido();
		                  Gson gson = new Gson();
			     		  String result =  gson.toJson(list);
			     		
			     		  response.setContentType("application/json; charset=utf-8");
			     	      PrintWriter out = response.getWriter();
			     		
			     	      out.print(result); 
			     		
                 
	}

	
	
	
	
}
