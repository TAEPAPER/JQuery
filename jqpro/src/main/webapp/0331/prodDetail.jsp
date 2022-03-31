<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%
 ProdVO vo = (ProdVO)request.getAttribute("vo");
%>

{

	"id" : "<%= vo.getProd_id()%>",
	"name": "<%=vo.getProd_name()%>",
	"color": "<%=vo.getProd_color()%>",
	"buyer": "<%=vo.getProd_buyer()%>",
	"cost" : "<%=vo.getProd_cost()%>",
	"lgu":	"<%=vo.getProd_lgu()%>",
	"price": "<%=vo.getProd_price()%>",
	"sale":	 "<%=vo.getProd_sale()%>",
	"size":	"<%=vo.getProd_size()%>"
			
	
}


