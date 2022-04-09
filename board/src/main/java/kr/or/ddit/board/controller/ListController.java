package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class List
 */
@WebServlet("/List.do")
public class ListController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");
		
		
		//1. 요청시 전송데이터 받기 -- page번호 , stype, sword
		int rqpage = Integer.parseInt(request.getParameter("page"));
		String rqtype = request.getParameter("stype");
		String rqword = request.getParameter("sword");
		
		//2. service객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();

		//page관련 작업-전체 글 갯수를 알아야해,총 페이지수 알아야해
		//한페이지당 출력할 글 갯수 정해야해 , 한 화면에 출력할 페이지 갯수 
		
		Map<String,Object> pmap = service.getPageInfo(rqpage);  //몇 페이지 볼거냐~  //  

		/*
		 * parameter Map 생성 int startval = 1; int endval = 5;
		 */
		
		Map<String, Integer> map = new HashMap<String,Integer>();
	
		map.put("start",(int)pmap.get("start"));  //startval
		map.put("end",(int)pmap.get("end"));    //endval
		//3. service메소드 호출하기 - 결과값 받기
		  List<BoardVO> list = service.selectList(map);   
		
		//4. 결과값으로 응답데이터 생성 - html, text, xml, json데이터
		Gson gson = new Gson();
		String result = gson.toJson(list);
		response.setContentType("application/json; charset = utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
		
		
				
		
		
	}

}
