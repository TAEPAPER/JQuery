package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.IZipService;
import service.ZipServiceImpl;
import vo.ZipVO;

/**
 * Servlet implementation class ZipController
 */
@WebServlet("/ZipController.do")
public class ZipController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private IZipService  service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZipController() {
        super();
        // TODO Auto-generated constructor stub
          service = ZipServiceImpl.getInstance();
 	    System.out.println(service);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int gb = Integer.parseInt(request.getParameter("gb"));
		switch(gb) {
		case 1:
			sidoPro(request, response);
			break;
		case 2:
			gugunPro(request, response);
			break;
		case 3:
			dongPro(request, response);
			break;
		case 4:
			addrPro(request, response);
			break;
		}
	}
	
	protected void sidoPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   IZipService  service = ZipServiceImpl.getInstance();
	   
	   List<String> list = service.selectSido();
	   
	   Gson  gson = new Gson();
	   String result = gson.toJson(list);
	   
	   response.setContentType("application/json; charset=utf-8");
	   PrintWriter  out = response.getWriter();
	   
	   out.print(result);
	   out.flush();
	}
	protected void gugunPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String sido = request.getParameter("sido");
	    
	   List<String> list =  service.selectGugun(sido);
	   
	   Gson  gson = new Gson();
	   String result = gson.toJson(list);
	   
	   response.setContentType("application/json; charset=utf-8");
	   PrintWriter  out = response.getWriter();
	   
	   out.print(result);
	   out.flush();
	}
	protected void dongPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	    String sido = request.getParameter("sido");
	    String gugun =request.getParameter("gugun");
	   
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("sido", sido);
	    map.put("gugun", gugun);
	    
	    List<String> list = service.selectDong(map);
	   
	    Set<String> list2 = new HashSet<String>();
	    
	    for(int i=0; i<list.size(); i++) {
	    	
	    	String  dv = list.get(i);
	    	
	        String[] arr = dv.split(" ");
	        list2.add(arr[0]);
	    }
		
		  Gson gson = new Gson();
		  String result = gson.toJson(list2);
		 
		  response.setContentType("application/json; charset=utf-8"); PrintWriter out =
		  response.getWriter();
		  
		  out.print(result);
		 
		  out.flush();
	  
	
	}
	protected void addrPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sido = request.getParameter("sido");
	    String gugun =request.getParameter("gugun");
	    String dong =request.getParameter("dong");
		   
	    ZipVO  vo = new ZipVO();
	    vo.setSido(sido);
	    vo.setGugun(gugun);
	    vo.setDong(dong);
	    
	    List<ZipVO> list = service.selectAddr(vo);
	    
	    Gson gson = new Gson();
		String result = gson.toJson(list);
		 
		  
		response.setContentType("application/json; charset=utf-8"); PrintWriter out =
		response.getWriter();
		  
		out.print(result);
		out.flush();
	    
	}	
		
		
		

}
