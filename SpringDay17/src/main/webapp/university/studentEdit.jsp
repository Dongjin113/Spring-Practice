<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
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

function delK(k1,k2){
	alert("k1:"+k1+" k2:"+k2);
	
	var  dataStr={
			 idx : k1, sno : k2
	  };
	
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
<h2> 학생등록하기  </h2>
<form action="<%=path%>/studentUpdate.do"  method=post>
<table border=1>
<tr> <td>학번 </td> <td> <input  type=text  name=sno    value="${m.sno}" > </td> </tr>
<tr> <td>이름 </td> <td> <input  type=text  name=sname  value="${m.sname}" > </td> </tr>
<tr> <td>학년 </td> <td> <input  type=text  name=year   value="${m.year}" > </td> </tr>
<tr> <td>학과 </td> <td> <input  type=text  name=dept   value="${m.dept}" > </td> </tr>
<tr>  <td colspan=2  align="center"> <input type=submit  value="학생정보수정"> </td> </tr>
</table>
</form>

<hr>
<div align=center>
<input type=hidden name=sno id=sno value="${m.sno}">

<table border=1>
<tr><td>작성자</td><td><input type=text name=replayer id=replayer></td></tr>
<tr>
<td>상담내용</td><td><textarea name=reply id=reply cols=35 rows=4></textarea></td></tr>
<tr><td colspan=2 align=center><button id="saveK" >작성완료</button></td></tr>

</table>

</div>


<br>
<div align=center>
<table border=1 width=700>
<tr align="center"> 
 <th > 순번 </th> <th > 학번 </th> <th> 답글 </th>
  <th> 작성자 </th> <th> 날짜 </th> <th> 삭제 </th>
</tr>
<c:forEach  items="${li}"  var="li"  varStatus="status" >

<tr align="center"> 
 <td> ${li.idx} </td>
 <td> ${li.sno} </td>
 <td> ${li.reply}</td>
 <td> ${li.replayer} </td>
 <td> <fmt:formatDate pattern="yyyy-MM-dd" value="${li.replyDate}"/></td>
 <td><button onClick=delK(${li.idx},${li.sno})>삭제</button></td>
 </tr>
</c:forEach>
</table>
</div>
  
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>