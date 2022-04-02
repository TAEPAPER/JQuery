<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../js/jquery-3.6.0.min.js"></script>

<style>

</style>
<script>
    $(function(){
     
    	//시도 
        	 $.ajax({
        		url : '<%=request.getContextPath() %>/zipboardServlet.do',
        		type : 'get',
        		data : {
        		 "gubun" : "1"
        		} ,
        		
        		success : function(res){   //sido가 담긴 리스트
        			str="";
        		
        		$.each(res,function(i, v){
        			
        			str += "<option value='"+v.sido+"'>" +v.sido+ "</option>"
        		})
        			$('#sido').html(str);
        		
        		},
        		error : function(xhr){
        			alert("상태 : "+xhr.status);
        		},
        		 dataType : 'json'
        		 
        	 })
      
	
   
    //구군
    $('#sido').on('change',function(){
           sido = $('option:selected',this).val();
           
           $.ajax({
        	   url : '<%=request.getContextPath() %>/zipboardServlet.do',
        	   type : 'get',
        	   
        	  data : {
        		  "sido" : sido,
        		  "gubun" : "2"
        	  },
        	   success : function(res){
        		   str="";
	           		$.each(res,function(i,v){
	           			
	           			str += "<option value='"+v.gugun+"'>" +v.gugun+ "</option>"
	           		})
	           			$('#gugun').html(str);
	           	   
        	   },
        	   error : function(xhr){
        		 alert("상태 : "+ xhr.status);  
        	   },
        	   dataType : 'json'
           })
   
    })
    //동구하기
    $('#gugun').on('change',function(){
         gugun = $('option:selected',this).val();
        
         $.ajax({
      	   url : '<%=request.getContextPath() %>/zipboardServlet.do',
      	   type : 'get',
      	    data : {
      	    	"sido" : sido,
      	    	"gugun" : gugun,
      	    	"gubun" :"3"
      	    },
      	   success : function(res){
      		   str="";
         		$.each(res,function(i,v){ // v = res[i] 와 같다!!
         			
         			str += "<option value='"+v.dong+"'>" +v.dong+ "</option>"
         		})
         			$('#dong').html(str);
      	   },
      	   error : function(xhr){
      		 alert("상태 : "+ xhr.status);  
      	   },
      	   dataType : 'json'
         })
    	
    })
    
    //디테일 구하기
    $('#dong').on('change',function(){
    	
         dong  = $('option:selected',this).val();
         
         $.ajax({
        	   url : '<%=request.getContextPath() %>/zipboardServlet.do',
        	   type : 'get',
        	   data : {
        		   "sido"   : sido ,
        		   "gugun"  : gugun ,
        		   "dong"   : dong ,
        		   "gubun" :   "4"  
        	   },
        	   success : function(res){
        		   str="<table border ='1'>";
        		   str += "<tr><td>우편번호</td>";
        		   str += "<td>주소</td>";
        		   str += "<td>번지</td></tr>";
        		
        		  $.each(res,function(i,v){
        			str+= "<tr><td>"+v.zipcode+"</td>";
        			str+= "<td>"+v.sido+" "+v.gugun+" "+v.dong+"</td>";
        			if(v.bunji ==null){
        				str+= "<td></td></tr>";
        			}else{
        				str +="<td>"+v.bunji+"</td></tr>";
        			}
        		})
        	     str += "</table>";
        		$('#result1').html(str);
        	   },
        	   error : function(xhr){
        		 alert("상태 : "+ xhr.status);  
        	   },
        	   dataType : 'json'
           })
	
    })
    
    })
</script>


</head>

<body>
  <select id = "sido"></select>
  <select id = "gugun"></select>
  <select id = "dong"></select>
  
  <div id = "result1" ></div>


</body>

</html>