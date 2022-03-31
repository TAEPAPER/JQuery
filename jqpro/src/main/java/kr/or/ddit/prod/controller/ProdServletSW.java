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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class ProdServletSW
 */
@WebServlet("/ProdServletSW.do")
public class ProdServletSW extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProdServletSW() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// lprod를 선택시 prod id와 name을 select

		// 1.전송 시 데이터 받기 --지금은 없어~
		String lgu = request.getParameter("lgu");

		// 2.service객체 얻기
		IProdService service = ProdServiceImpl.getInstance();
		// 3.service메소드 호출 - 결과값 return 받기

		List<ProdVO> list = service.selectByLgu(lgu);
		// lprod에서 신발,장난감에 해당하는 prod항목이 없다~

		JsonObject obj = new JsonObject(); // []형태
		if (list != null && list.size() > 0) { // 데이터가 있을 때
			obj.addProperty("sw", "ok");
			Gson gson = new Gson();
			JsonElement jele = gson.toJsonTree(list); // 계층구조니까 Tree로 줘야해
			obj.add("datas", jele);

		} else { // 데이터가 없는 경우
			obj.addProperty("sw", "no");

		}

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(obj);
		out.flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		IProdService service = ProdServiceImpl.getInstance();
		ProdVO vo = service.selectById(id);
		
		Gson gson = new Gson();
		String result = gson.toJson(vo);
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush(); // out을 청소해주기
		

	}

}
