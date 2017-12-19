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
	
	
	<div class="layui-tab">
  <ul class="layui-tab-title">
    <li class="layui-this">商品详情</li>
    <li>订单日志详情</li>
    <li>订单详情</li>
  </ul>
  <div class="layui-tab-content">
  <!-- 第一层 -->
    <div class="layui-tab-item layui-show">
    <div class="bigDiv">
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
    
    <!-- 第二层 -->
    <div class="layui-tab-item">

		
		<ul class="layui-timeline" id="rz">
		  
		</ul>  

	</div>
	
	<!-- 第三层 -->
    <div class="layui-tab-item">

		<blockquote class="layui-elem-quote layui-quote-nm" id="dd">
		
		</blockquote>
		
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
			
			
			//商品详情查询
			url = "dent/findByshowId.action?indentId="+id;
	        $.post(url,null,function(mes){
	        	for(i=0;i<mes.length;i++){
	        		$("#tbody").append("<tr><td>"+mes[i].KIN_SERIAL+"</td><td>"+mes[i].KIN_NAME+"</td><td>"+mes[i].KIN_CONTENT+"</td><td>"+mes[i].KIN_EXPIRATION+"</td><td>"+mes[i].KIN_PRICE+"</td>"+
	        				"<td>"+mes[i].ENTDE_NUM+"</td><td>"+mes[i].ENTDE_PRICE+"</td><td style='display:none'>"+mes[i].ENTDE_ID+"</td></tr>");
	    		} 
	        	
	            
	        },"json")
			
	        
	        //日志详情查询
	        url="dent/findByrz.action?indentId="+id;
	        $.post(url,null,function(mes){
	        	for(i=0;i<mes.length;i++){
	        		$("#rz").append("<li class='layui-timeline-item'><i class='layui-icon layui-timeline-axis'></i><div class='layui-timeline-content layui-text'><h3 class='layui-timeline-title'>"+mes[i].CREATETIME+"</h3><p>药品名称:"+mes[i].kin_name+"<br>生产数量:"+mes[i].DETAIL_NUM+"<br>完成度:<font color='red'>"+mes[i].LOG_COMPLET+"%</font></p></div></i>");
	    		} 
	        	
	            
	        },"json")
	        
	        
	        //订单详情查询
	        url="dent/show.action?indentId="+id;
	        $.post(url,null,function(mes){
	        		$("#dd").append("生产订单编号:&nbsp;&nbsp;&nbsp;&nbsp;"+mes.indentNumber+"<br ><br >生产订单金额:&nbsp;&nbsp;&nbsp;&nbsp;"+mes.indentMoney+"元<br ><br >生产订单数量:&nbsp;&nbsp;&nbsp;&nbsp;"+mes.indentCount+"件<br ><br >生产订单生成时间:&nbsp;&nbsp;&nbsp;&nbsp;"+mes.indentEmetime+"<br ><br >本次订单需要花费的时间:&nbsp;&nbsp;&nbsp;&nbsp;"+mes.indentWorktime+"<br ><br >预计完成时间:&nbsp;&nbsp;&nbsp;&nbsp;"+mes.indentEndtime+"");      
	        },"json")
	        
	       
		})
		
		
		
		
		 //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
        layui.use('element',
        function() {
          var element = layui.element;

        });
      
		
		
	</script>
</html>