<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#first").click(function(){
		var currPage=$("#se1").val();
		
		if(currPage<=1||currPage==null){
			alert("已经是第一页了");
			return;
		}else{
			$("#first").attr("href", "ShowPage?pageNum=1");
		}
	});
	
	$("#pre").click(function(){
		
		var currPage=$("#se1").val();
	
		if(currPage<=1||currPage==null){
			alert("已经是首页了");
			return;
		}else{
			currPage--;
			$("#pre").attr("href", "ShowPage?pageNum="+currPage);
		}
	});
	
  $("#next").click(function(){
		
		var currPage=$("#se1").val();
		
		var sumPage=$("#sumPage").val();
		
		if(currPage<sumPage){
			currPage++;
			$("#next").attr("href", "ShowPage?pageNum="+currPage);
		}else{
			alert("已经是最后一页了");
		}
	});
  $("#last").click(function(){
		
		var currPage=$("#se1").val();
		
		var sumPage=$("#sumPage").val();
		
		if(currPage!=sumPage&&currPage!=null){
			//currPage=sumPage;
			$("#last").attr("href", "ShowPage?pageNum="+sumPage);
		}else{
			alert("已经是尾页了");
		}
	});
  

  $("select").change(function(){
	  
	 var pageNum=$("select").val();
	 
	 $("#jvForm").attr("method","get");
	 $("#jvForm").attr("actoin","ShowPage?pageNum="+pageNum);
	 $("#jvForm").submit();
  });
	
});
</script>
<style>
    .pageSum{
    height:15px;
    width:45px;
    }
    .pageNum{
    height:15px;
    width:45px;
    }
</style>
</head>
<body>
<table align="center" border="1" width="80%"  cellspacing="0">
    <tr>
    <td colspan="6" align="center"><b>学生信息表</b></br><a href="Insert.jsp?pageNum=${pageNum }">添加信息</a></td>
    </tr>
    <tr>
       <th>id</th>
       <th>name</th>
       <th>birthday</th>
       <th>description</th>
       <th>avgscore</th>
       <th>operation</th>
    </tr>
    
    <c:forEach items="${list }" var="stu">
    <tr>
       <td align="center">${stu.id }</td>
       <td align="center">${stu.name}</td>
       <td align="center">${stu.birthday}</td>
       <td align="center">${stu.description}</td>
       <td align="center">${stu.avgscore }</td>
       <td align="center"><a href="ShowPage?pageNum=${pageNum }&type=delete&id=${stu.id }&name=${stu.name}&birthday=${stu.birthday }&description=${stu.description}">删除</a>|
       <a href="Update.jsp?id=${stu.id }&name=${stu.name}&birthday=${stu.birthday}&description=${stu.description}&score=${stu.avgscore }&pageNum=${pageNum}">修改</a></td>
    </tr>
    </c:forEach>
    <tr>
    
    <td colspan="6" align="center">
    <c:if test="${empty list }">
         <c:out value="暂无学生信息"></c:out>  
    </c:if>
    <c:if test="${!empty list}">
 <form id="jvForm">
    <a id="first" href="#">首页</a>&nbsp;
    <a id="pre" href="#">上一页</a>&nbsp;
    <a id="next" href="#">下一页</a>&nbsp;
    <a id="last" href="#">尾页</a>&nbsp;
   
 

    共<input type="text" class="pageSum" id="sumPage"  value="${pageSum }" disabled="disabled">页&nbsp;

    当前位置：<select name="pageNum" id="se1">
        <c:forEach  begin="1" step="1" end="${pageSum }" var="i">
       
       
        <option value="${i }" <c:if test="${i eq pageNum}">selected="selected"</c:if>>第${i}页</option>
        
        </c:forEach>
     </select>
</form>
    </c:if>

    </td>
    </tr>
</table>
</body>
</html>