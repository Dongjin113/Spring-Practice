<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
// $(document).ready 문서읽을 준비
var  path='${pageContext.request.contextPath}';
$(document).ready(function(){
	

	// alert("경로확인:" +path);

	jQuery.ajaxSetup({cache:false});
	
	$("#insertK").click(function(){
		//alert("저장확인" + $('#cno').val());
		
		var dataStr ={
				cno : $('#cno').val(),
				replayer: $('#replayer').val(),
				reply : $('#reply').val()
		};
		
		$.ajax({
			type: "GET",
			url : path + "/CourseReplyInsert.do",
			data : dataStr,
			success  : function(data){
				//alert("저장성공 ~");
				location.replace(path+"/courseedit.do?cno="+$('#cno').val());
			} 
		})
		
	})
	
})

function deleteK( k1 , k2){
	//alert("저장확인" + k1 + "k2" + k2);
	
	var  dataStr={
			idx : k1, cno : k2
	  };
	
	$.ajax({
		  type: "GET",
		  url : path + "/CourseReplyDelete.do",
		  data : dataStr,
		  success: function (data){
			   alert("저장성공!!" + data );
			 location.replace(path+"/courseedit.do?cno="+k2) ;
		  }
		  
		  
	  })
	
}
</script>

<section>
<br>
<div align="center">
<h2> 학생등록하기  </h2>
<form action=""  method=get>
<table border=1>
<tr> <td>과목번호 </td> <td> <input  type=text  name=cno    value="${m.cno}" > </td> </tr>
<tr> <td>과목명 </td> <td> <input  type=text  name=cname  value="${m.cname}" > </td> </tr>
<tr> <td>학점 </td> <td> <input  type=text  name=credit   value="${m.credit}" > </td> </tr>
<tr> <td>개설학과 </td> <td> <input  type=text  name=dept   value="${m.dept}" > </td> </tr>
<tr> <td>담당교수 </td> <td> <input  type=text  name=prname   value="${m.prname}" > </td> </tr>
</table>
</form>
<hr>
<br>
<div align=center>
<table border=1 width=700>

<tr> <td>과목번호 </td> <td> <input  type=text  name=cno  id="cno"  value="${m.cno}" > </td> </tr>
<tr> <td>작성자 </td> <td> <input  type=text  name=replayer id="replayer"> </td> </tr>
<tr> <td>과목평가 </td> <td> <textarea  cols=40 rows=3  name=reply id="reply"></textarea> </td> </tr>
<tr> <td colspan=2 align="center"><button id="insertK">저장하기</button></td> </tr>
</table>
</div>


<div align=center>
<table border=1 width=700>
<tr align="center"> 
 <th > 순번 </th> <th > 과목번호 </th> <th> 답글 </th>
  <th> 작성자 </th> <th> 날짜 </th> <th> 삭제</th>
</tr>
<c:forEach  items="${li}"  var="li"  varStatus="status" >

<tr align="center"> 
 <td> ${li.idx} </td>
 <td> ${li.cno} </td>
 <td> ${li.reply}</td>
 <td> ${li.replayer} </td>
 <td> <fmt:formatDate pattern="yyyy-MM-dd" value="${li.replyDate}"/></td>
 <td><button onclick="deleteK('${li.idx}','${li.cno}')">삭제</button></td>
 </tr>
 <
</c:forEach>
</table>
</div>
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>