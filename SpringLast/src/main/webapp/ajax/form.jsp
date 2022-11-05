<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

  <script>
    
    jQuery.ajaxSetup({cache:false});
    
    $(document).ready(function(){
    	
        $('#submitBtn').click(function(){
            alert("submitBtn 확인");
            $.ajax({
               url:'<%=path%>/insertExamAjax.do',
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
                	
                  alert("#post 성공" + data );
                  
                  $('#sno').val('');
                  $('#sname').val('');
                  $('#kor').val('');
                  $('#eng').val('');
                  $('#math').val('');
                  $('#hist').val('');
                  
                  //$('#get').trigger('click'); 
                }    

            })


           });	
    	
    	
    })
    
  </script>  

<section>
<br>
<div align="center">
<h2> 학생성적 목록보기(ajax) </h2>

<form >
<table border=1 >
<tr> <td > 번호 </td><td > <input type=text name="sno" id="sno" >  </td> </tr>
<tr> <td> 이름 </td> <td > <input type=text name=sname  id="sname"></td> </tr>
<tr> <td> 국어 </td><td > <input type=text  name=kor  id="kor">  </td> </tr>
<tr> <td> 영어 </td> <td > <input type=text name=eng  id="eng">  </td> </tr>
<tr> <td> 수학 </td><td > <input type=text  name=math  id="math"> </td> </tr>
<tr> <td> 역사 </td><td > <input type=text  name=hist  id="hist"> </td> </tr>
<tr> <td colspan=2  align="center"> <input type=button value="저장하기" id="submitBtn"  > </td> </tr>

</table>
</form>
</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>