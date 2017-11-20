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
			<div class="bodyDiv" style="width:1000px;margin: auto;">
				<div style="text-align: center;">
					<table id="kinList" class="layui-table" lay-size="sm">
					  <thead>
					    <tr>
					      <th colspan="5">商品信息</th>
					      <th colspan="3">价格</th>
					    </tr>
					    <tr>
					      <th>商品编码</th>
					      <th>商品名称</th>
					      <th>净含量</th>
					      <th>保质期</th>
					      <th>价格</th>
					      <th>数量</th>
					      <th>总金额</th>
					    </tr>
					  </thead>
					  <tbody id="tbody">
					   
					  </tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
	//取网址上的ID
	function GetQueryString(id){
	    var reg = new RegExp("(^|&)"+ id +"=([^&]*)(&|$)");
	    var r = window.location.search.substr(1).match(reg);
	    if(r!=null)return  unescape(r[2]); return null;
	}
	
		$(function(){
			var id = GetQueryString("indentId");
			url = "dent/findByshowId.action?indentId="+id;
	        $.post(url,null,function(mes){
	        	for(i=0;i<mes.length;i++){
	        		$("#tbody").append("<tr><td>"+mes[i].KIN_SERIAL+"</td><td>"+mes[i].KIN_NAME+"</td><td>"+mes[i].KIN_CONTENT+"</td><td>"+mes[i].KIN_EXPIRATION+"</td><td>"+mes[i].KIN_PRICE+"</td>"+
	        				"<td>"+mes[i].ENTDE_NUM+"</td><td>"+mes[i].ENTDE_PRICE+"</td><td style='display:none'>"+mes[i].ENTDE_ID+"</td></tr>");
	    		} 
	        	
	            
	        },"json")
			
		})
		
		
	</script>
</html>