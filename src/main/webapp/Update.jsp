<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生信息</title>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var v1=$("#t1").val();
	var v2=$("#t2").val();
	var v3=$("#t3").val();
	var v4=$("#t4").val();
	var member=""+v1+"~-"+v2+"~-"+v3+"~-"+v4;
	$("#m1").attr("value",member);
	
	$("#btn1").click(function(){
		var reg_birthday = /^(\d{4})-(\d{2})-(\d{2})$/;
		var reg_score=/^\d+$/g;
		var name=$("#t2").val();
		var birthday=$("#t3").val();
	
		var description=$("#t4").val();
		var score=$("#t5").val();
		//验证name
		if(name==null||name.trim()==""||name.length>40){
			alert("name不能为空且长度不能大于40");
			return;
		}
		if(name.indexOf("~-")!=-1){
			alert("name不能为空且不能包含~-");
			return;
		}
		//验证birthday是否合法
		if(birthday==null||birthday.trim()==""){
			alert("birthday不能为空");
			return;
		}
		if(!reg_birthday.test(birthday)){
			alert("日期格式不正确");
			return;
		}
		if(birthday!=null){
			var dd=new Date(birthday);
			if(dd=="Invalid Date"){
				alert("不合法的日期");
				return;
			}
		}
		//验证description的长度和是否含有~-
		if(description==null||description.trim()==""||description.length>255){
			alert("description不能为空且长度不能超过255个字符");
			return;
		}
		if(description.indexOf("~-")!=-1){
			alert("description不能含有~-");
			return;
		}
		//验证score
		if(score==null||score.trim()==""){
			alert("score不能为空");
			return;
		}
		if(!reg_score.test(score)){
			alert("您输入的score不是整数");
			return;
		}
		
		$("#jvForm").attr("action","UpdateServlet");
		$("#jvFrom").attr("method","post");
		$("#jvForm").submit();
		
	});
	
	
});
</script>
</head>
<body>
<form actoin="" id="jvForm">
<table align="center">
	 <tr>
	    <td>
	    id:
	    </td>
	    <td>
	    <input type="text" name="sid" id="t1" readonly="readonly" value="${param.id }"/>
	    </td>
	</tr> 
	<tr>
	    <td>
	    name:
	    </td>
	    <td>
	    <input type="text" name="name" id="t2" value="${param.name }"/>
	    </td>
	</tr>
	<tr>
	    <td>
	    birthday:
	    </td>
	    <td>
	    <input type="text" name="birthday" id="t3" value="${param.birthday }"/><font color="red">格式：1995-12-12</font>
	    </td>
	</tr>
	<tr>
	    <td>
	    descriptoin:
	    </td>
	    <td>
	    <input type="text" name="descriptoin" value="${param.description }" id="t4"/>
	    </td>
	</tr>
	<tr>
	    <td>
	    score:
	    </td>
	    <td>
	    <input type="text" name="score" id="t5" value="${param.score }"/>
	    </td>
	</tr>
	<tr>
	   
	    <td>
	    <input type="hidden" name="pageNum" value="${param.pageNum }" id="p1"/>
	    </td>
	<tr>
	<tr>
	   
	    <td>
	    <input type="hidden" name="member"  id="m1"/>
	    </td>
	<tr>
	    <td>
	   <input type="button" value="提交" id="btn1"/>
	    </td>
	    <td>
	     <input type="reset" value="重置" id="btn2"/>
	    </td>
	</tr>
	
</table>
</form>
</body>
</html>