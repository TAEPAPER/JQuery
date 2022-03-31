<%@page import="prodVo.prodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


  <%
  List<prodVO> list = (List<prodVO>)request.getAttribute("listvalue");
  %>
  
    [
    
    <%
    for(int i =0; i<list.size(); i++){
    	prodVO vo = list.get(i);
    	if(i>0) out.print(",");

    %>
		{
		"id" :   "<%= vo.getProd_id() %>",
		"name"  :"<%= vo.getProd_name() %>"	
		}
    
    <%
    }
    %>
    
    
    ]
    
    
  
  