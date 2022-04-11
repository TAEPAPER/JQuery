<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>Bootstrap Example</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src = "../js/board.js" ></script> <!-- 외부스크립트 -->
<style type="text/css">
 p{
 
 margin : 2px;
 padding :2px;
}
.p1{
	width : 70%;
   float : left;
}
.p2{
  text-align : right;
   width :25%;
   float :right;
}
hr{
clear : both;
}
input[name=reply]{
  height :55px;
  vertical-align :top;
}
.container{
	margin-top : 20px;
}
h1{
 margin-left : 100px;
}
#stype{
  width : 100px;
  
}
.navbar{
  margin : 5px 25px;
}
#pagelist{
 margin-left : 20%;
 height : 50px;
}
.pagination{
   float :left;
   width : 100px;
}
</style>
<script>
currentPage = 1; //초기값

  $(function(){
	typevalue = "";
	wordvalue = "";
    listServer();
    
 	//search검색 이벤트
 	$('#search').on('click',function(){
 		typevalue = $('#stype option:selected').val().trim();
 		wordvalue = $('#sword').val().trim();
 		listServer();
 	})
    //page번호 클릭하는 이벤트 //
    $('#pagelist').on('click','.pnum',function(){
    	//alert($(this).text());
    	currentPage = $(this).text();
    	listServer();
    	
    })
    
    //이전버튼 클릭하는 이벤트
     $('#pagelist').on('click','.prev',function(){
    	 currentPage = parseInt($('.pager a').first().text()) -1;
    	listServer();
    	
    })
    //다음버튼 클릭하는 이벤트
    $('#pagelist').on('click','.next',function(){
    	currentPage = parseInt($('.pager a').last().text()) +1;
    	listServer();
    	
    })
    
    
    
  })
  
  </script>

</head>
<body>

<h1>accordian 게시판</h1>
<br>
<br>

<nav class="navbar navbar-expand-sm bg-info navbar-info">
    
  <select class = "form-control" id = "stype">
      <option value ="">전체</option>  <!-- stype, sword가 없는것!~! -->
      <option value ="subject">제목</option>
      <option value ="writer">작성자</option>
      <option value ="content">내용</option>
  </select>
  
  <form class="form-inline" >
    <input id = "sword" class="form-control mr-sm-2" type="text" placeholder="Search">
    <button id = "search" class="btn btn-primary" type="button">Search</button>
  </form>
</nav>
<br><br>

<!--list출력 부분 -->
<div class="container"></div>
<br><br>
<div id = "pagelist"></div>
  

</body>
</html>