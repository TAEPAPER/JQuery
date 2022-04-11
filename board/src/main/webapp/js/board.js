var listServer = function(){
	
	$.ajax({
		 url : '/board/List.do',
		 type: 'post',
		 data : {
			'page' : currentPage,
			'stype' : typevalue,
			'sword' :  wordvalue
		 },
		 success :function(res){
			 code = '<div id="accordion">';
			  
			 $.each(res.datas,function(i,v){
			
			code += '	 <div class="card">';
		    code += '  <div class="card-header">';
		    code += '    <a class="card-link" data-toggle="collapse" href="#collapse'+v.num+ '">';
		    code += v.subject;+'</a>';
		    code += '  </div>';
		    code += '  <div id="collapse'+v.num+'" class="collapse" data-parent="#accordion">';
		    code += '    <div class="card-body">';
		    code += '     <p class ="p1">';
		    code += '     작성자 :'+ v.writer+ '&nbsp;&nbsp;&nbsp;';
		    code += '     이메일 :'+ v.mail + '&nbsp;&nbsp;&nbsp;';
		    code += '     날짜  : '+v.wdate+'&nbsp;&nbsp;&nbsp;';
		    code += '     조회수 : '+v.hit+ '&nbsp;&nbsp;&nbsp;';
		  
		    code += '     </p>';
		    code += '     <p class ="p2">';
		    code += '        <input type ="button" class="action" name= "modify" value = "수정">';
		    code += '        <input type ="button" class="action" name= "delete"value = "삭제">';
		   
		    code += '     </p>';
		    code += '     <hr>';
		    code += '     <p class ="p3">';
		    code +=      v.content;
	
	
		    code += '     </p>';
		    code += '     <p class ="p4">';
		    code += '     	<textarea rows="" cols = "80"></textarea>';
		    code += '     	<input type ="button" class="action" name="reply" value="등록">';
		    
		    code += '     </p>';
		    
		    code += '    </div>';
		    code += '  </div>';
		    code += '</div>';
		 
			 }) //반복문 끝나는 곳	 
			 code += '</div>';
		   
			 $('.container').html(code);
			 //이전버튼 출력
		pcode="";
		pcode = '<ul class="pagination">';
		if(res.startp > 1){ //1보다 클 때만 이전버튼 만들어라
		pcode +='<li class="page-item"><a class="page-link prev" href="#">Previous</a></li>';
		pcode += '</li>'; 
		pcode += '</ul>';  
		       
		} 
			//페이지 목록 출력 $$$%%
		    pcode += '<ul  class="pagination pager">';
			for(i= res.startp ; i<=res.endp; i++){
			    if(currentPage==i){
				pcode+='<li class="page-item active "><a class="page-link pnum" href="#">'+i+'</a></li>';
				
			}else{
			pcode+=	 '<li class="page-item "><a class="page-link pnum" href="#">'+i+'</a></li>';
			  }
			}
             pcode +='</ul>'
             //다음 버튼 출력			 
            if(res.endp <res.totalp) {
        pcode += '<ul class="pagination">';
		pcode +='<li class="page-item"><a class="page-link next" href="#">Next</a></li>';
		pcode += '</li>'; 
		pcode += '</ul>';	
    }

	     $('#pagelist').html(pcode);

			 
		 },
		 error : function(xhr){
			 alert("상태 : "+xhr.status)
		 },
		 dataType:'json'
		 
	 })
}