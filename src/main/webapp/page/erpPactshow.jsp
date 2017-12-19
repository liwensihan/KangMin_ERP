<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同</title>
	<link rel="stylesheet" href="<%=basePath%>res/layui/css/layui.css" media="all">
	<script src="<%=basePath%>res/js/jquery-2.1.3.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>res/layui/layui.js" charset="utf-8"></script>
	<style type="text/css">
		#id{
			padding: 30px;
		}
	</style>
</head>
<body>
		<div id="content">
				
				
		</div>
		
</body>
<script type="text/javascript">
//取网址上的ID
function GetQueryString(id){
    var reg = new RegExp("(^|&)"+ id +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

//当页面加载时运行，给文本复职
$(function(){
		var id = GetQueryString("pactId");
		var data = {"pactId":id};
		var url = "pact/findByshowid.action";
		if(id!=null & id!=""){
			$.post(url, data, function(mes){
				$("#content").append("<br /><h1 align='center'><font size='5'>"+mes.PACT_TITLE+"</font></h1><p align='center'>(编码:"+mes.PACT_NUMBER	+")</p>"+
						"<br /><div align='center'>"+mes.PACT_TEXT+"</div><br /><br /><br /><br /><div align='left' id='id'>甲方:"+mes.PARTA_NAME+"<br /><br />乙方:"+mes.APPLY_NAME+"<br /><br />时间:"+mes.PACT_SIGNTIME+"</div>");
			});
		}
		
		
	});
</script>

</html>