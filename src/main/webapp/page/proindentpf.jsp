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
					      <th>配方净含量</th>
					      <th>配方名字</th>
					      <th>原材料净含量</th>
					      <th>该药品总数</th>
					    </tr>
					  </thead>
					  <tbody id="tbody">
					   
					  </tbody>
					</table>
					</div>
					</div>
					
					<div align="right">
					
					<button class="layui-btn layui-btn-small" onclick="getTableContent('kinList')" lay-submit="" lay-filter="demo1"><i class="layui-icon">&#xe609;</i>立即提交</button>
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
		var id = GetQueryString("indentId");//订单ID
		var num=GetQueryString("indentCount");//订单总数量
		
		//商品详情查询
		url = "dent/showpf.action?indentId="+id;
        $.post(url,null,function(mes){
        	
        	for(i=0;i<mes.length;i++){
        		var yi=mes[i].BUR_G*num/mes[i].RAW_CONTENT;
        		$("#tbody").append("<tr><td>"+mes[i].KIN_NAME+"</td><td>"+mes[i].BUR_G+"</td><td>"+mes[i].RAW_NAME+"</td><td>"+mes[i].RAW_CONTENT+"   "+mes[i].RAW_UNIT+"</td><td>"+yi+"</td><td style='display:none'>"+mes[i].RAW_ID+"</td>");
    		} 
        	
            
        },"json")
        
        
	});
	
	
	
	 function getTableContent(id){
		 var indentId = GetQueryString("indentId");//订单ID
		//注意：parent 是 JS 自带的全局对象，可用于操作父页面
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		 
		 url="<%=basePath%>/dent/showcp.action?indentId="+indentId;
    	 var mytable = document.getElementById(id);
         var data = "";
 	    for(var i=1,rows=mytable.rows.length; i<rows; i++){
 	        for(var j=1,cells=mytable.rows[i].cells.length; j<cells; j++){
 	            if(!data[i]){
 	                data[i] = new Array();
 	            }
 	            data += mytable.rows[i].cells[j].innerHTML+"_";
 	        }
 	        data+="&";
 	    }
 	    
 	   $.post(url,{str:data},function(m){
 		   if(m.state==1){
 			  parent.layer.msg("操作成功");
 			  parent.layer.close(index);
			  parent.table.reload('testReload');
 		   }else{
 			  parent.layer.msg("库存不足！！！");
 			  parent.layer.close(index);
			  parent.table.reload('testReload');
 		   }
 		   
   		
		});
 	    
    }
	
	</script>