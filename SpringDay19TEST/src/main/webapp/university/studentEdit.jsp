<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<script  src="http://code.jquery.com/jquery-1.10.2.js" ></script>
<script>
  var  path='${pageContext.request.contextPath}';
  
  // alert("경로확인:" +path);
  
  jQuery.ajaxSetup({cache:false});
  
  $(document).ready( function(){
	  $('#saveK').click( function(){
		 		 
		  // alert("확인2:" + $('#sno').val() + "," + $('#replayer').val()   +"," +  $('#reply').val()   );
		  var  dataStr={
				 sno : $('#sno').val(),
				 replayer : $('#replayer').val(),
				 reply : $('#reply').val()	
		  };
		  
		  $.ajax({
			  type: "GET",
			  url : path + "/ReplyInsert.do",
			  data : dataStr,
			  success: function (data){
			  // alert("저장성공!!" + $('#sno').val() );
			  location.replace(path+"/studentEdit.do?sno="+$('#sno').val()) ;
			  }
			  
			  
		  })
		  
	  } )
	  
	  
  })
  
  function delK(k1, k2){
	  
	  // alert(k1 + " : " +  k2);
	  
	  var  dataStr={ idx : k1 };
	  
	  $.ajax({
		  type: "GET",
		  url : path + "/ReplyDelete.do",
		  data : dataStr,
		  success: function (data){
			  // alert("저장성공!!" + $('#sno').val() );
			 location.replace(path+"/studentEdit.do?sno="+k2) ;
		  }
		  
		  
	  })
  }
  
  
</script>

<section>
<br>
<div align="center">
<h2> 학생정보수정하기  </h2>
<form action="<%=path%>/studentUpdate.do"  method=post>
<table border=1>
<tr> <td>학번 </td> <td> <input  type=text  name=sno    value="${m.sno}" > </td> </tr>
<tr> <td>이름 </td> <td> <input  type=text  name=sname  value="${m.sname}" > </td> </tr>
<tr> <td>학년 </td> <td> <input  type=text  name=year   value="${m.year}" > </td> </tr>
<tr> <td>학과 </td> <td> <input  type=text  name=dept   value="${m.dept}" > </td> </tr>
<tr>  <td colspan=2  align="center"> <input type=submit  value="학생정보수정"> </td> </tr>
</table>

</form>
 
</div>

<hr>

<div align="center">
  <form id=form >
  <input  type=hidden name=sno id=sno value="${m.sno}" >  
  <table border=1 width=700>  
  <tr><td> 작성자 </td> <td> <input  type=text name=replayer id=replayer >  </td>  </tr>
  <tr><td> 상담내용 </td> <td> <textarea name=reply id=reply cols=55  rows=3 > </textarea>  </td>  </tr>
  <tr><td colspan=2 align="center"> <button id="saveK"> 작성완료 </button>  </td>  </tr>
  </table>
  </form>
</div>

<div  align="center" >
<table border=1 width=700>
<tr align="center"> 
 <th > 순번 </th> <th > 학번 </th> <th> 글쓴이 </th>
  <th> 상담내용 </th> <th> 상담날짜 </th><th> 삭제 </th>
</tr>
<c:forEach  items="${li}"  var="m" >


<tr align="center"> 
 <td> ${m.idx} </td>
 <td> ${m.sno} </td>
 <td> ${m.replayer}</td>
 <td> ${m.reply} </td>
 <td><fmt:formatDate pattern="yyyy-MM-dd" value="${m.replyDate}"/> 
  </td>
  
  <td> <button onClick=delK(${m.idx},${m.sno})>삭제</button> </td> 
 </tr>
</c:forEach>
</table>


</div>


<br>
</section>
<%@ include file="../include/bottom.jsp" %>