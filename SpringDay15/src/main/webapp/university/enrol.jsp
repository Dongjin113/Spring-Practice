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
	  $('#insertK').click( function(){
		  
		  alert("sno:"+$('#sno').val()+" cno:"+$('#cno').val()+" grade:"+$('#grade').val()+" midterm:"+$('#midterm').val()+" finalstr:"+$('#finalstr').val());
		 		 
		  var  dataStr={
					 sno : $('#sno').val(),
					 cno : $('#cno').val(),
					 grade : $('#grade').val()	,
					 midterm : $('#midterm').val(),
					 finalstr : $('#finalstr').val()	
			  };
			  
			  $.ajax({
				  type: "GET",
				  url : path + "/ReplyEnrolInsert.do",
				  data : dataStr,
				  success: function (data){
					  // alert("저장성공!!" + $('#sno').val() );
					 location.replace(path+"/enrol.do") ;
				  }
				  
				  
			  })
		  
		  
	  } )
		  
	  
})

function delK( k1,k2){
	
	alert("k1"+k1 + " k2"+k2);
	var  dataStr={
			sno : k1, cno : k2
	  };
	
	$.ajax({
		  type: "GET",
		  url : path + "/ReplyEnrolDelete.do",
		  data : dataStr,
		  success: function (data){
			  // alert("저장성공!!" + $('#sno').val() );
			 location.replace(path+"/enrol.do") ;
		  }
		  
		  
	  })
}

</script>



<section>

<br>
<div align="center">
<h2> 학생성적목록  </h2>
<div>
<table border=1>
<tr>
<td>
<select name=sno id=sno> 
        <c:forEach items="${li}"  var="a"  >
        <option value="${a.sno}" > ${a.sno}  </option>
        </c:forEach> 
</select>
</td>
<td>
<select name=cno id=cno> 
        <c:forEach items="${li}"  var="b"  >
        <option value="${b.cno}" > ${b.cno}  </option>
        </c:forEach> 
</select>
</td>
<td><input type=text  name=grade id=grade></td>
<td><input type=text name=midterm id=midterm></td>
<td><input type=text name=finalstr id=finalstr></td>
<td><button id="insertK" >저장하기</button></td>

</tr>
</table>
</div>

<div>
<table border=1 width=700>
<tr align="center"> 
 <th > 순번 </th> <th > 학번 </th> <th> 과목코드 </th>
  <th> 학점 </th> <th> 중간성적 </th><th> 기말성적 </th><th> 삭제</th>
</tr>

<c:forEach  items="${li}"  var="m"  varStatus="status" >
<tr align="center"> 
 <td> ${status.count} </td>
 <td> <a href=enrolEdit.do?sno=${m.sno}&cno=${m.cno}>${m.sno}</a> </td>
 <td> ${m.cno}</td>
 <td> ${m.grade} </td>
 <td> ${m.midterm} </td>
 <td> ${m.finalstr} </td>
 <td><button onClick=delK(${m.sno},"${m.cno}")></button></td>
 </tr>
</c:forEach>
</table>
</div>
</div>
<br>




</section>
<%@ include file="../include/bottom.jsp" %>