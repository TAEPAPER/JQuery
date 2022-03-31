<%@page import="prodVo.prodVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%
    prodVO vo = (prodVO)request.getAttribute("vo");
   %>
   
   {
  			  "id":	"<%=vo.getProd_id()%>", 
   			 "buyer":   "<%=vo.getProd_buyer()%>",
   			 "cost":     "<%=vo.getProd_cost()%>",
   			 "lgu":    "<%=vo.getProd_lgu()%>", 
   			 "name": "<%=vo.getProd_name()%>",
   			 "price" :   "<%=vo.getProd_price()%>",
   			  "sale" :  "<%=vo.getProd_sale()%>"
   			  
   
   }
  
   
   