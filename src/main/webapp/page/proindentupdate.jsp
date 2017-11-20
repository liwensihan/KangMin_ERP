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
		<script type="text/javascript">
		//合计方法
		function total(obj){
			tr = $(obj).parent().parent();
			price = tr.children().eq(1).text();
			td=tr.children().eq(3).text(price*obj.value);
		}
		</script>
	</head>
	<body>
		<div class="bigDiv">
			<div class="bodyDiv" style="width:1000px;margin: auto;">
				<div style="text-align: center;">
					<table id="kinList" class="layui-table" lay-size="sm">
					  <thead>
					    <tr>
					      <th>商品名称</th>
					      <th>价格</th>
					      <th>数量</th>
					      <th>总金额</th>
					    </tr>
					  </thead>
					  <tbody id="tbody">
					  
					  </tbody>
					</table>
				</div>
				<hr>
				<div align="right">
					
					<button class="layui-btn layui-btn-small" onclick="getTableContent('kinList')" lay-submit="" lay-filter="demo1"><i class="layui-icon">&#xe609;</i>立即提交</button>
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
			url = "dent/findById.action?indentId="+id;
	        $.post(url,null,function(mes){
	        	for(i=0;i<mes.length;i++){
	        		$("#tbody").append("<tr><td>"+mes[i].KIN_NAME+"</td><td>"+mes[i].KIN_PRICE+"</td>"+
	        				"<td><input class='inputText num' type='text' onkeyup='total(this);' value="+mes[i].ENTDE_NUM+" maxlength='10'></td><td>"+mes[i].ENTDE_PRICE+"</td><td style='display:none'>"+mes[i].ENTDE_ID+"</td></tr>");
	    		}
	        	
	            
	        },"json")
			
		})
		
		
		
		
		
		
		function getTableContent(id){
						//注意：parent 是 JS 自带的全局对象，可用于操作父页面
						  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
						
						var iid = GetQueryString("indentId");
						var url="<%=basePath%>/dent/update.action?indentId="+iid;
					     var mytable = document.getElementById(id);
					    var data = "";
					    for(var i=1,rows=mytable.rows.length; i<rows; i++){
					        for(var j=1,cells=mytable.rows[i].cells.length; j<cells; j++){
					            if(!data[i]){
					                data[i] = new Array();
					            }
					            if(j==2){
					            	data += mytable.rows[i].cells[j].childNodes[0].value+"_";
					            }else{
					            	data += mytable.rows[i].cells[j].innerHTML+"_";
					            }
					        }
					        data+="&";
					    }
					  
					    $.post(url,{str:data},function(m){
					    	
					    		if(m.state==1){
					    			parent.layer.msg("操作成功");
									parent.layer.close(index);
									parent.table.reload('testReload');
								}
							}); 
					   
				
			}
	</script>
</html>