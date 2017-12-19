<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
<script src="res/layui/layui.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="layui-form" style="margin: 2%">
<table class="layui-table" >
 	<colgroup>
      <col width="150">
      <col width="150">
      <col width="200">
      <col>
    </colgroup>
    <thead>
		<tr>
			<td>货品名称</td>
			<td>明细编号</td>
			<td>单价</td>
			<td>数量</td>
			<td>总价格</td>
		</tr>
	</thead>
	<c:forEach items="${mall }" var="mall">
	<tr>
		<td>${mall.kinName }</td>
		<td>${mall.fdprolistmxNumber }</td>
		<td>${mall.kinPrice }</td>
		<td>${mall.fdprolistmxCount }</td>
		<td>${mall.fdprolistmxMoney }</td>
	</tr>
	</c:forEach>
</table>
</div>
</body>

<script type="text/javascript">
 function yesa(){
	 
 }

</script>
</html>