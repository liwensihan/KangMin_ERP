<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>POS</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<style type="text/css">
			body{
				padding: 10px;
			}
			
			
			.bigDiv .bodyDiv{
				padding: 15px;
			}
			
			.bigDiv .bodyDiv table[lay-size="sm"] th {
			    text-align: center;
			}
			.bigDiv .inputText{
				border-left-width:0px;
				border-top-width:0px;
				border-right-width:0px;
				border-bottom-color:black;
			}
			.bigDiv > .bodyDiv .num{
				 width: 77px;
				margin-right: 0px;
			}
			
		</style>
	</head>
<body>
	<div class="bigDiv">
    <div style="text-align: center;">
     	<table id="kinList" class="layui-table" lay-size="sm">
					  <thead>
					    <tr>
					      <th style="display:none">ID</th>
					      <th>商品名称</th>
					      <th>千克</th>
					      <th>配方</th>
					    </tr>
					  </thead>
					  <tbody id="tbody">
					   
					  </tbody>
					</table>
					</div>
					</div>
</body>
</html>


<script type="text/javascript">
	//取网址上的ID
	function GetQueryString(id){
	    var reg = new RegExp("(^|&)"+ id +"=([^&]*)(&|$)");
	    var r = window.location.search.substr(1).match(reg);
	    if(r!=null)return  unescape(r[2]); return null;
	}
	
	$(function(){
		var id = GetQueryString("indentId");
		
		//商品详情查询
		url = "dent/showpf.action?indentId="+id;
        $.post(url,null,function(mes){
        	for(i=0;i<mes.length;i++){
        		$("#tbody").append("<tr><td style='display:none'>"+mes[i].RAW_ID+"</td><td>"+mes[i].KIN_NAME+"</td><td>"+mes[i].BUR_G+"</td><td>"+mes[i].RAW_NAME+"</td>");
    		} 
        	
            
        },"json")
	});
	</script>