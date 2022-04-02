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
  
  <script>
  $(function(){
	  
	  //아이디 중복검사!
	 $('#idchk').on('click',function(){
		 event.preventDefault();
		idvalue = $('#uid').val().trim();
		
		//요청
		$.ajax({
			url : '/join-bootstrapMe/memberServlet.do',
			type : 'get',
			data : {"id" : idvalue},
			
			success : function(res){  //res는 json {flag : 머시기}
                   //idspan에 찍어주기
                 $('#idspan').text(res.flag).css('color','red');
		
			},
			error : function(xhr){
				alert("상태 : "+xhr.status);
			},
			dataType : 'json'
		
		})
 
	 })

	//우편번호 검색!!
	$('#zipsearch').on('click',function(){
	      event.preventDefault();
	      window.open("zipsearching.html", "우편검색", "width = 500 height = 300");
 
	})
	//번호검색 modal
	$('#btn1').on('click',function(){
	    dong = $('#dong').val().trim();
	      $.ajax({
	    	  url : '/join-bootstrapMe/zipServlet.do',
	    	  type : 'get',
	    	  data : {"dong" : dong},
	    	  
	    	  success : function(res){
	    		 str= "<table border ='1'>";
	    		 str+="<tr><td>우편번호</td>";
	    		 str +="<td>주소</td>";
	    		 str+="<td>번지</td></tr>";
	    		 
	    	$.each(res,function(i,v){
	          str+="<tr class = 'ziptr' ><td>"+v.zipcode+"</td>";
	          str+="<td>"+v.sido+" "+v.gugun+" "+v.dong+"</td>";
	          
	          if(v.bunji == null){ //번지가 없는 경우
	        	  str += "<td></td></tr>";
	          }else{
	        	  str += "<td>"+v.bunji+"</td></tr>";
	          } 
	    	})	 
	    	str+="</table>";
	    		$('#result1').html(str); 
	     
	    	  },
	    	  error : function(xhr){
	    		  alert("상태 : "+xhr.status);
	    		  
	    	  },
	    	  dataType : 'json'
    	  
	      })
	 
	})
	
	$('#result1').on('click','.ziptr',function(){
	 	
		zipcode= $("td:eq(0)",this).text(); //게터
		addr =   $("td:eq(1)" ,this).text(); //게터
	 		
		$('#upost').val(zipcode);
		$('#uaddr1').val(addr);
		
		$('#dong').val("");
		$('#result1').empty();
	 $('#myModal').modal('hide');
		
	 	
	})
	
	
	
	
	
 
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
      <button  id = "idchk" class = "btn btn-info mb-3 mr-sm-2"  >중복검사</button>  <!-- 전송기능이 있다! -->

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
      <input type="date" class="form-control col-sm-3" id="ubirth" placeholder="Enter userbirth" name="mem_birth" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    
    <div class="form-group">
      <label for="utel">휴대폰번호</label>
      <input type="text" class="form-control col-sm-3" id="utel" placeholder="Enter usertel" name="mem_tel" required>
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
       <button  id = "zipsearch" class = "btn btn-info mb-3 mr-sm-2" >번호검색</button> 
        <button type = "button" class = "btn btn-info mb-3 mr-sm-2"  data-toggle="modal" data-target="#myModal">번호검색modal</button> 
      <br>
      <input type="text" class="form-contro l" id="upost" placeholder="Enter userpost" name="mem_post" required>
      
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    <div class="form-group">
      <label for="uaddr1">주소</label>
      <input type="text" class="form-control col-sm-5" id="uaddr1" placeholder="Enter useraddr" name="mem_addr1" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
    <div class="form-group">
      <label for="uaddr2">상세주소</label>
      <input type="text" class="form-control col-sm-5" id="uaddr2" placeholder="Enter useraddr2" name="mem_addr2" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
  
    <button type="submit" class="btn btn-primary btn-lg" >Submit</button>
     <button type="reset" >초기화</button>
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