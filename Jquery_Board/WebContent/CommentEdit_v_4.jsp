<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		.over {cursor:pointer;}
	</style>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
		$(function(){
			GetBoardList();
			RowUpdateBoard();
			
			$(document).on("click", "#dataTable tr", function() {
			  var idx = $(this).attr("index");
			  var seq;
			  $.ajax({
	        url:"CommentDetail.jsp",
	        dataType:"JSON",
	        type : "POST",
	        data : {"idx" : idx},
	        success : function(data){
	        	 $.each(data, function (idx, data) {
	        		 $("input[name='seq']").val(data.seq);
	        		 $("input[name='title']").val(data.title);
	        		 $("input[name='content']").val(data.content);
	        		 $("input[name='regdate']").val(data.regdate);
	        		 $("input[name='hit']").val(data.hit);
	        		});
          }
		   
			  });
			  
			});
		});
	
		function RowUpdateBoard(){
			
			$('#updateForm').on("submit",function(){
				var param = $(this).serialize();
				//console.log(param);
				//alert("submit");
				$.ajax({
					url:"CommentEditUpdate.jsp",
					dataType:"JSON",
					type : "POST",
					data : param, //{"seq" :"1" ,"title" : "A" , "content":"A" , "regdate":"11" , "hit":"1"} ,
					success : function(returndata){
						//alert(returndata.result);
						 	if(returndata.result){
								alert("수정성공");
								GetBoardList(); //데이터 갱신하기
							}else{
								alert("수정실패");
							}  
						}
					
					});
				
			 	return false; //기본적인 submit 하지 말아라
			});
		}
		
		
		
		function GetBoardList(){
			//alert("호출");
			//데이터 만드는 작업 (비동기)
			$.ajax({
				url : "CommentEditList.jsp" ,
				dataType : "JSON",
				type : "POST" ,
				success : function(data){
					var str = "<thead>";
					str += "<tr>";
					str += "<th>번호</th>";
					str += "<th>글제목</th>";
					str += "<th>글내용</th>";
					str += "<th>등록일</th>";
					str += "<th>조회수</th>";
					str += "</tr>";
					str += "</thead>";
					str += "<tbody>";
					$.each(data, function(index, data) {
						str += "<tr index='"+ index +"'>";
						str +=    "<td>" + data.seq + "</td>";
						str +=    "<td>" + data.title + "</td>";
						str +=    "<td>" + data.content + "</td>";
						str +=    "<td>" + data.regdate + "</td>";
						str +=    "<td>" + data.hit + "</td>";
						str += "</tr>";
					});
					
					str += "</tbody>";
					
					$("#dataTable").html(str);
					
				
					
				/* 	//data -> json 형태의 ArrayObject
					for(var k=0 ; k < data.length ; k++){
						var tr="";
						tr += "<tr index='"+ (k) +"'>";
						tr += "<td>" + data[k].seq + "</td>";
						tr += "<td>" + data[k].title + "</td>";
						tr += "<td>" + data[k].content + "</td>";
						tr += "<td>" + data[k].regdate + "</td>";
						tr += "<td>" + data[k].hit + "</td>";
						tr += "</tr>";
						
						var trObj = $(tr); //trObj (json 객체로 만들기)
						console.log(trObj);
						
						trObj.addClass("over").on("click",function(){
							//tr > click 하면 상세  출력 
							
							var index = $(this).attr("index");
							//console.log(index);
							var data = $("#listView").data("data");
							//console.log(data);
							var rowdata = data[index];
							//console.log(data);
							
							
							$('#detailView').find(":input").each(function(){
								var name = $(this).prop("name"); //속성의 이름만 가져오기
								//console.log(name);
								var value =rowdata[name];
								//console.log(value);
								if(value != undefined){
									$(this).val(value);
								}
							});
							
						});
						
						$('#listView').append(trObj);
						
					} 
					*/
				}
			});
	
		}
		
		
	</script>
</head>
<body>
	<div>
		<table id="dataTable" border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>글제목</th>
					<th>글내용</th>
					<th>등록일</th>
					<th>조회수</th>				
				</tr>
			</thead>
			<tbody id="listView"></tbody>
		</table>
	</div>
	<div id="detailView">
		<form id="updateForm">
			<table border="1">
				<tr>
					<td>번호</td>
					<td><input type="text" name="seq" value=""></td>
				</tr>
				<tr>
					<td>글제목</td>
					<td><input type="text" name="title" value=""></td>
				</tr>
				<tr>
					<td>글내용</td>
					<td><input type="text" name="content" value=""></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type="text" name="regdate" value=""></td>
				</tr>
				<tr>
					<td>조회수</td>
					<td><input type="text" name="hit" value=""></td>
				</tr>
			</table>
			<input type="submit" id="btnUpdate" value="수정하기">
		</form>	
	</div>
</body>
</html>














