<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
       BuyerVO vo = (BuyerVO)request.getAttribute("buyvalue");
    %>
    
    
   
     {
     
     "id" : "<%=vo.getBuyer_id() %>",
     "name" :"<%=vo.getBuyer_name() %>",
     "lgu" : "<%=vo.getBuyer_lgu() %>",
     "comtel" : "<%=vo.getBuyer_comtel() %>",
     "bank" : "<%= vo.getBuyer_bank() %>",
     "bankNo" : "<%=vo.getBuyer_bankno() %>",
     "bankName" : "<%=vo.getBuyer_bankname() %>",
     "mail" : "<%=vo.getBuyer_mail() %>",
     "zip" : "<%= vo.getBuyer_zip()%>",
     "add1" : "<%=vo.getBuyer_add1() %>",
     "add2" : "<%=vo.getBuyer_add2() %>",
     "fax"  : "<%=vo.getBuyer_fax() %>"
        
     
     
     }
     
     
     
     
     
     
     
     