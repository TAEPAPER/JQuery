<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <!DOCTYPE html>
<html lang="kr">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  
  <script src = "../js/jquery.serializejson.min.js"></script>	

<script>


$(function(){
	//아이디 중복체크
 $('#idchk').on('click',function(){
//	event.preventDefault(); //원래하던 기능인 전송 기능을 없앤다!
     //입력한 값을 가져온다
     //서버로 전송한다
     idvalue = $('#uid').val().trim();
     $.ajax({
    	 //요청
    	url : '<%=request.getContextPath()%>/IdCheck.do',  
    	type : 'get',
    	data : {"id" : idvalue},
    	//응답
    	success : function(res){
    	//	alert(res.flag);
    		$('#idspan').html(res.flag)
    		.css('color','red');
    		
    	},
    	errror : function(xhr){
    		alert("상태 : "+xhr.status);
    	},
    	
    	dataType : 'json'
    	
    	 })
     
	})
	
        $('#zipsearch').on('click',function(){
        	//window.open(url, name, specs, replace);
		//    event.preventDefault();  //현재 기능을 없앰! 	
			window.open("zipsearch.html","우편번호","width=500 height =400");    
			 //"우편번호"  : 화면에 나타나지 않는 논리적인 이름
			 
        })
	
	//우편번호 찾기 --modal로 수행
	$('#btn1').on('click',function(){
		//입력한 값 가져온다
		dongvalue = $('#dong').val().trim();
		console.log(dongvalue);
		//서버로 전송
		$.ajax({
			//요청
			url : '/jqpro/ZipSearch.do',
			type : 'get',
			data : {"dong" :dongvalue},
			
			//응답
			success : function(res){
				str = "<table border = '1'>";
				str+="<tr><td>우편번호</td>";
				str+= "<td>주소</td>";
				str+="<td>번지</td></tr>"
				$.each(res,function(i,v){
				//	var bunji = v.bungi;
				//	if(typeof bunji == 'undefined'){
				//		bunji = "";
				//	}
					
					str+="<tr class ='ziptr'><td>"+v.zipcode+"</td>";
					str += "<td>"+v.sido+" "+v.gugun+" " +v.dong+"</td>";
					if(v.bunji == null){
						str +="<td></td></tr>"
					}else{
					str += "<td>"+v.bunji+"</td></tr>";
						}
					})
				str+="</table>"
				$('#result1').html(str);
				
			},
			error : function(xhr){
				alert("상태 : "+xhr.status);
			},
			dataType : 'json'
		})

	})
	
	//$('.ziptr').on('click',function(){})--***이거 안돼!!!!!*****나중에 만들어진거니까
	//검색결과에서 선택하여 값을 넘기기--modal
	$('#result1').on('click','.ziptr',function(){ //#result1은 modalbody에 있는 div이다!! 
	  zipcode = $("td:eq(0)",this).text();
	  addr = $("td:eq(1)",this).text();
	  $('#upost').val(zipcode); //세터
	  $('#uaddr1').val(addr);  //세터
	  
	  $('#dong').val("");  //세터
	  $('#result1').empty();
	  $('#myModal').modal('hide');
	  
	
	})

	$('form').on('submit',function(){
		
	   //입력한 모든 값을 가져온다      
	   //직렬화는  name을 활용한다 name 은 vo와 같아야한다
	   fdata1 = $('form').serialize();  
	   fdata2 = $('form').serializeArray();
	   fdata3 = $('form').serializeJSON();
	   
	   console.log(fdata1);
	   console.log(fdata2);
	   console.log(fdata3);
	   
	   $.ajax({
	    	url : '<%=request.getContextPath()%>/Insert.do' ,
	    	data : fdata3,
	    	type : 'post',
	    	
	    	success : function(res){
	    		//alert(res.flag);
	    		$('#joinspan').text(res.flag).css('color','red');
	    		
	    	},
	    	error : function(xhr){
	    		alert("상태 : "+xhr.status);
	    	},
	    	dataType : 'json'
	    	
	    })
	   
        	
	})

	return false;
	
})


</script>

<style>
 #dong{
  margin-left : 20px;
 
 }
 .ziptr:hover{
   background : lime;
 }
</style>
</head>
<body>

<div class="container">
  <h2>회원가입</h2>
  <form  class="needs-validation" novalidate>
    
    <div class="form-group">
      <label for="uid">아이디</label>
      <button type= "button" id = "idchk" class = "btn btn-info mb-3 mr-sm-2"  >중복검사</button>  <!-- 전송기능이 있다! -->

      <input type="text" class = "form-control col-sm-3"    id="uid" placeholder="Enter userid" name="mem_id" required>
       <span id = "idspan"></span>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
 
  
    <div class="form-group">
      <label for="uname">이름</label>
      <input type="text" class="form-control col-sm-3" id="uname" placeholder="Enter username" name="mem_name" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    <div class="form-group">
      <label for="pwd">비밀번호</label>
      <input type="password" class="form-control col-sm-3" id="pwd" placeholder="Enter password" name="mem_pass" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember" required> I agree on blabla.
        <div class="valid-feedback">Valid.</div>
        <div class="invalid-feedback">Check this checkbox to continue.</div>
      </label>
    </div>
    
    <div class="form-group">
      <label for="ubirth">생년월일</label>
      <input type="date" class="form-control col-sm-3" id="ubirth" placeholder="Enter userbirth" name="mem_bir" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    
    <div class="form-group">
      <label for="utel">휴대폰번호</label>
      <input type="text" class="form-control col-sm-3" id="utel" placeholder="Enter usertel" name="mem_hp" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    <div class="form-group">
      <label for="umail">이메일</label>
      <input type="text" class="form-control col-sm-3" id="umail" placeholder="Enter usermail" name="mem_mail" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
   	 <div class="form-group">
      <label for="upost">우편번호</label>
       <button  type = "button" id = "zipsearch" class = "btn btn-info mb-3 mr-sm-2" >번호검색</button> 
        <button type = "button" class = "btn btn-info mb-3 mr-sm-2"  data-toggle="modal" data-target="#myModal">번호검색modal</button> 
      <br>
      <input type="text" class="form-contro l" id="upost" placeholder="Enter userpost" name="mem_zip" required>
      
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    <div class="form-group">
      <label for="uaddr1">주소</label>
      <input type="text" class="form-control col-sm-5" id="uaddr1" placeholder="Enter useraddr" name="mem_add1" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    <div class="form-group">
      <label for="uaddr2">상세주소</label>
      <input type="text" class="form-control col-sm-5" id="uaddr2" placeholder="Enter useraddr2" name="mem_add2" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
  
    <button type="submit" class="btn btn-primary btn-lg" >Submit</button>
    <span id = "joinspan"></span>
  </form>
</div>


<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">우편번호 찾기</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        	<input type = "text" id = "dong">
			<input type="button" value="확인" id="btn1"> 
			<div id="result1"></div>
       
       
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>


<script>
// Disable form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Get the forms we want to add validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();           /*     (function(){})(); : 한번실행되고 끝난다!! */
</script>

</body>
</html>
    