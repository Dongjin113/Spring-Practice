<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

  <script>
  
    //캐시를 생성하지 않는다.
    jQuery.ajaxSetup({cache:false});
    
    $(document).ready(function(){
    	
        $('#submitBtn').click(function(){
        	
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
                   
                  /*
                  새로고침이 진행 되기때문에 필요 하지 않다.!!
                  $('#sno').val('');
                  $('#sname').val('');
                  $('#kor').val('');
                  $('#eng').val('');
                  $('#math').val('');
                  $('#hist').val('');
                  */
                  
                  /* 
                   	1) 히스토리에 정보가 남는다. 
                	location.href(path + "/board_list.do")

                	2)히스토리에 정보가 남지 않는다. 
                	location.replace(path + "/board_list.do") 

                	3)캐시를 생성하지 않는다. 
                	jQuery.ajaxSetup({cache:false});
                  
                  */
                  
                  location.replace("<%=path %>/getAjaxList.do");
                  
                }    

            }) // ajax 끝


           });	// click 의 끝 

    }) //  $(document).ready 의 끝

    function delK(strk){
    	
    	       $.ajax({
               url:'<%=path%>/deleteExamAjax.do',
               type:'GET',
               data:{ 
	            	   sno: strk	            	
                    },
                success:function(data){                   
              
                  location.replace("<%=path %>/getAjaxList.do");
                  
                }    

            }) // ajax 끝
    }
    
  </script>  

<section>
<br>
<div align="center">
<h2> 학생성적 목록보기 <a href="<%=path%>/ajax/form.jsp">(저장하기)</a> </h2>

<table border=1 width=700>
<tr align="center"> <td>번호 </td> <td>이름 </td> <td>국어 </td> <td>영어 </td> <td>수학 </td>
    <td>역사 </td> <td>저장하기 </td> </tr>
<tr align="center"> <td><input type="text" id="sno" size=7> </td>
     <td><input type="text" id="sname" size=10>      </td> 
     <td><input type="text" id="kor" size=3>      </td>  
     <td><input type="text" id="eng" size=3>      </td>  
     <td><input type="text" id="math" size=3>      </td>  
     <td><input type="text" id="hist" size=3>      </td>  
     <td><input type="button" id="submitBtn" value="저장하기" >      </td>       
     </tr>
</table>
<table border=1 width=700>
<tr align="center"> 
 <th > 순번 </th> <th > 번호 </th> <th> 이름 </th> <th> 국어 </th>
 <th> 영어 </th> <th> 수학 </th> <th> 역사 </th>
 <th> 합계 </th><th> 평균 </th><th> 삭제 </th>

</tr>
<c:forEach  items="${li}"  var="m"  varStatus="status" >

<c:set var="sum"  value="${m.kor + m.eng + m.math + m.hist}" />
<c:set var="avg"  value="${sum / 4}" />
<c:set var="ksum"  value="${ksum + m.kor}" />
<c:set var="esum"  value="${esum + m.eng}" />
<c:set var="msum"  value="${msum + m.math}" />
<c:set var="hsum"  value="${hsum + m.hist}" />
<c:set var="ssum"  value="${ssum + sum}" />
<c:set var="asum"  value="${asum + avg}" />

<tr align="center"> 
 <td> ${status.count} </td>
 <td><a href="<%=path %>/getAjax.do?sno=${m.sno}" > ${m.sno} </a> </td>
 <td> ${m.sname} </td>
 <td> ${m.kor} </td>
 <td> ${m.eng} </td>
 <td> ${m.math} </td>
 <td> ${m.hist} </td>
 <td> ${sum} </td>
 <td> ${avg} </td>
 <td> <input type="button"  onClick="delK(${m.sno})"  value="삭제"  />  </td>

 </tr>
</c:forEach>

<tr align="center"> 
 <td colspan=3 > 누적합 </td>

 <td> ${ksum} </td>
 <td> ${esum}  </td>
 <td> ${msum}  </td>
 <td> ${hsum}  </td>
 <td> ${ssum} </td>
 <td> ${asum} </td>
 <td> ${asum} </td>

 </tr>

</table>

</div>
<br>
</section>
<%@ include file="../include/bottom.jsp" %>