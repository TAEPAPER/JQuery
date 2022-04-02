<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
     //서블릿에서 공유데이터
	String res = (String) request.getAttribute("res");
	
     //String inputId = (String) request.getAttribute("inputId");
    //if(res.equals(inputId))도 이용할 수 있어!
    
	if (res !=null) {
 %>       
	{    
	    "flag" : "<%=res%>님 가입성공!!!"	
	}	
	<%  	
} else {
	%>
	{
	     "flag" : "Sorry~~가입실패!!!"
	}
<% 
}	
%>


