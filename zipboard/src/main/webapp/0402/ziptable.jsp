<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<!-- <script src="../js/jquery-3.6.0.min.js"></script> -->

<script>
var vsido;
var vgugun;
var vdong;

$(function(){
	//시도 찾기 
	
	$.ajax({
		
		url : '/zipboard/ZipController.do',
		type : 'post',
		data : { 'gb' : 1},
		success : function(res){
			str = "";
			$.each(res, function(i,v){
				str += "<option>" + v + "</option>"
			})
			$('#sido').append(str);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : 'json'
	})
	
	$('#sido').on('change', function(){  //구군 구하기
		//alert($(this).val()) 
		sido = $(this).val();
		vsido = sido;
		
		$.ajax({
			url : '/zipboard/ZipController.do',
			type : 'post',
			data : { 'gb' : 2,
				      'sido' : sido     //전역변수라서 또 구할 필요 없어!!
			        },
			success : function(res){
				str = "";
				$.each(res, function(i,v){
					str += "<option>" + v + "</option>"
				})
				$('#gugun').html(str);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : 'json'
		})
	})
	
	
	//gugun을 change해서 dong 을 검색
	$('#gugun').on('change', function(){
		gugun = $(this).val();
		
		$.ajax({
			url : '/zipboard/ZipController.do',
			type : 'post',
			data : { 'gb' : 3,
				      'sido' : sido,
				      'gugun' :gugun
			        },
			success : function(res){
				str = "";
				$.each(res, function(i,v){
					str += "<option>" + v + "</option>"
				})
				$('#dong').html(str);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : 'json'
		})
	})
	
	$('#dong').on('change', function(){
		dong = $(this).val();
		
		$.ajax({
			url : '/zipboard/ZipController.do',
			type : 'post',
			data : { 'gb' : 4,
				      'sido' : sido,
				      'gugun' :gugun,
				      'dong' : dong
			        },
			success : function(res){
				
				
				str = "<table border ='1'>";
				str +="<tr><td>우편번호</td>";
				str += "<td>주소</td>";
				str += "<td>번지</td></tr>";
				
				$.each(res, function(i, v){
					
					var bunji = v.bunji;
					if(typeof bunji == "undefined")
						   bunji = "";
		
						str +="<tr class='ziptr'><td>" + v.zipcode + "</td>";
						str += "<td>" +v.sido + v.gugun + v.dong + "</td>";
						str += "<td>" + bunji + "</td></tr>";
					})
				
					str += "</table>";
					
					$('#result').html(str);	
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : 'json'
		})
	})
	
})
</script>
</head>
<body>
 <select id="sido">
 </select>
 
 <select id="gugun">
 </select>
 
 <select id="dong">
 </select>
 
 <br><br>
 <div id="result"></div>
 
</body>
</html>