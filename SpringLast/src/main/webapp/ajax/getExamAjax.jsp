<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

  <script>    
    jQuery.ajaxSetup({cache:false});    
    $(document).ready(function(){
    	
        $('#replaySave').click(function(){
            // alert("replaySave 확인");
            $.ajax({
               url:'<%=path%>/ExamReplaySave.do',
               type:'post',
               dataType:'text',
               data:{ 
	            	   sno: $('#sno').val(),
	            	   reply: $('#reply').val(),
	            	   replayer: $('#replayer').val()

                    },
                success:function(data){  
                  if(data == "T") {	
                    // alert("data확인:" + data );	
               	    location.replace("<%=path %>/getAjax.do?sno="+$('#sno').val());
                  }
               }   
            }) // ajax 끝 

           });	// click 끝 !!
           
           
           $('#updateBtn').click(function(){
               // alert("replaySave 확인");
               $.ajax({
                  url:'<%=path%>/updateExamAjax.do',
                  type:'post',
                  dataType:'text',
                  data:{ 
   	            	   sno: $('#sno').val(),
   	            	   sname: $('#sname').val(),
   	            	   kor: $('#kor').val(),
   	            	   eng: $('#eng').val(),
   	            	   math: $('#math').val(),
   	            	   hist: $('#hist').val()

                       },
                   success:function(data){  
                     if(data == "T") {	
                        alert("data확인:" + data );	
                  	    location.replace("<%=path %>/getAjax.do?sno="+$('#sno').val());
                     }
                  }   
               }) // ajax 끝 

              });	// click 끝 !!
    	
    	
    })
    
    function delK(k1, k2) {
       // alert(k1 +" : " + k2)
       $.ajax({
           url:'<%=path%>/ExamReplayDelete.do',
           type:'post',
           dataType:'text',
           data:{ 
            	   idx: k1             	   
                },
            success:function(data){
             if(data == "T") {            	 
               // alert("data확인" + k2);	
               location.replace("<%=path %>/getAjax.do?sno="+k2);
             }
            }   
        }) // ajax 끝 
    }
    
  </script>  


<section>
<br>
<div align="center">
<h2> 학생성적 상세보기 </h2>

<form>
<table border=1 width=600>
<tr> <td > 번호 </td><td > <input type=text name="sno"  id="sno"  value="${m.sno}" >  </td> 
     <td> 이름 </td> <td > <input type=text name=sname  id="sname"  value="${m.sname}"  ></td> </tr>
<tr> <td> 국어 </td><td > <input type=text  name=kor    id="kor"  value="${m.kor}" >  </td> 
     <td> 영어 </td> <td > <input type=text name=eng    id="eng"  value="${m.eng}" >  </td> </tr>
<tr> <td> 수학 </td><td > <input type=text  name=math   id="math"  value="${m.math}" > </td> 
     <td> 역사 </td><td > <input type=text  name=hist   id="hist"  value="${m.hist}" > </td> </tr>
<tr> <td colspan=4  align="center"> <input type=button id="updateBtn"  value="수정하기"  > </td> </tr>

</table>
</form>
</div>

<div align="center">
<h2> 상담내용 작성하기  </h2>
<form>
<input  type=hidden  name=sno id=sno  value="${m.sno}" >
<table  border=1 width=600>
<tr><td>작성자</td><td> <input  type=text  name=replayer id=replayer ></td> </tr>
<tr><td>상담내용 </td><td> <textarea rows="4" cols="50" name=reply id=reply></textarea> </td> </tr>
<tr><td colspan=2  align="center"> <input  type=button id="replaySave"  value="상담저장" ></td> </tr>
</table>
</form>

<form>
<table border=1 width=600>
<tr> <td> idx <td> sno <td> reply <td> replayer <td> replyDate <td> 삭제  </tr>

<c:forEach  items="${li}"  var="m" >
<tr align="center"> 
 <td> ${m.idx} </td>
 <td> ${m.sno} </td>
 <td align="left"> &nbsp; ${m.reply} </td>
 <td> ${m.replayer}</td>
 <td><fmt:formatDate pattern="yyyy-MM-dd" value="${m.replyDate}"/> 
 </td>
  <td> <input type="button" onClick=delK(${m.idx},${m.sno})  value="삭제하기" /> </td> 
 </tr>
</c:forEach>
</table>
</form>
</div>

<br>
</section>
<%@ include file="../include/bottom.jsp" %>