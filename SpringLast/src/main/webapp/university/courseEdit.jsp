<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<script  src="http://code.jquery.com/jquery-1.10.2.js" ></script>

<script>

var  path='${pageContext.request.contextPath}';
jQuery.ajaxSetup({cache:false});

$(document).ready( function(){
	$("#insertK").click( function(){		
		// alert("저장확인:" + $('#cno').val());
		var dataStr ={ 
		  cno : $('#cno').val(),
		  replayer:  $('#replayer').val(),
		  reply : $('#reply').val()
		};
		
		$.ajax({
			type: "GET",
			url : path + "/CourseReplyInsert.do",
			data : dataStr,
			success: function(data) {
			  alert(" 저장성공 ~~ " + data) ;
			  location.replace(path+"/courseEdit.do?cno="+$('#cno').val()) ;	
			}			
		    
		})		
	})	
})

function deleteK(k1, k2){
	//  alert("삭제확인1 ~~ : " + k1 + "," +k2)
	var dataStr ={ idx : k1 ,  cno : k2 };
			
	$.ajax({
		type: "GET",
		url : path + "/CourseReplyDelete.do",
		data : dataStr,
		success: function(data) {
			  // alert(" 삭제확인1 ~~ " + data ) ;
			  location.replace(path+"/courseEdit.do?cno="+k2) ;	
		}			
	})
	
}


</script>

<section>
<br>
<div align="center">
<h2> 과목 상세보기  </h2>

<table border=1  width=400>
<tr> <td>과목코드 </td> <td>${m.cno} </td> </tr>
<tr> <td>과목명 </td>   <td> ${m.cname} </td> </tr>
<tr> <td>학점 </td> <td> ${m.credit} </td> </tr>
<tr> <td>개설학과 </td> <td> ${m.dept} </td> </tr>
<tr> <td>담당교수 </td> <td>${m.prname}</td> </tr>
</table>

<hr>

<div  id=fom1>
<table border=1  width=700>
<tr> <td>과목코드 </td> <td><input  type="text"  name="cno" id="cno" value="${m.cno}" > </td> </tr>
<tr> <td>작성자  </td>   <td><input  type="text"  name="replayer" id="replayer"  >   </td> </tr>
<tr> <td>과목평가 </td>   <td><textarea cols=40 rows=3 name="reply" id="reply" ></textarea> </td> </tr>
<tr> <td colspan=2  align="center" > <button id="insertK"> 강의평등록 </button> </td> </tr>
</table>
</div>
<br>

<div  align="center" >
<table border=1 width=700>
<tr align="center"> 
 <th > 순번 </th> <th > 과목코드 </th> <th> 작성자 </th>
  <th> 과목평가 </th> <th> 상담날짜 </th><th> 삭제 </th>
</tr>
<c:forEach  items="${li}"  var="m" >


<tr align="center"> 
 <td> ${m.idx} </td>
 <td> ${m.cno} </td>
 <td> ${m.replayer}</td>
 <td> ${m.reply} </td>
 <td><fmt:formatDate pattern="yyyy-MM-dd" value="${m.replyDate}"/> 
  </td>
  
 <td><button onClick="deleteK('${m.idx}','${m.cno}')" >삭제</button>  </td> 
</tr>
</c:forEach>
</table>


</div>


  
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>