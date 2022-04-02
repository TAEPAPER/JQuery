<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
 <%
            String id =   (String) request.getAttribute("check");
 %>   
 
 
 <% 
  if(id ==null){ //사용가능한 경우
	  
 %>
 
 {
       "flag" : "사용가능한 아이디입니다"
 
 
 
 }
 
 <%
  }else{
 %>
 	{
       "flag" : "이미 있는 아이디입니다"
 
 	}
 
 <%
  }
  %>
 
 