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
			.bigDiv{
				width:100%;
				height:600px;
				border: solid 1px #ddd;
				border-radius: 4px;
			}
			.bigDiv > .headDiv{
				background-color: #f5f5f5;
				padding: 10px 15px;
				border-radius: 4px 4px 0 0;
				border-bottom: solid 5px #ddd;
				font-weight: bold;
				text-align: center;
				color: #009688;
			}
			.bigDiv .bodyDiv{
				padding: 15px;
			}
			input[type="text"]{
				margin-right:20px; 
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
				width:25px;
				margin-right: 0px;
			}
				
				
				.layui-input-block1 {
				    margin-left: -4px;
				    min-height: 36px;
				}
		</style>
		
	</head>
	<body>
	
		<div class="bigDiv">
			<div class="headDiv">生产订单</div>
			<div class="bodyDiv" style="width:1000px;margin: auto;">
			
				<div style="text-align: center;">
			<form class="layui-form" action="">
				<div class="demoTable">
				
			

				
				<div class="layui-inline">
					<select id="kinName" name="kinName" lay-verify="required" lay-search="" width="50px">
							  <option value="">商品</option>
							</select>
				</div>
				<div class="layui-inline">
				<input name="username" id="username" lay-verify="required" placeholder="数量" autocomplete="off" class="layui-input" type="text">
				</div>

				

			
		</div>
</form>
					<hr>
					<button class="layui-btn" onclick="add();"><i class="layui-icon">&#xe61f;</i>增加商品</button>
					<button class="layui-btn layui-btn-danger" onclick="deleteKin();"><i class="layui-icon">&#xe640;</i>删除商品</button>
					
					<table id="kinList" class="layui-table" lay-size="sm">
					  <thead>
					    <tr>
					      <th rowspan="2"><input id="quanxuan" type="checkbox" name="quanxuan"></th>
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
					      <th style="display:none">ID</th>
					    </tr>
					  </thead>
					  <tbody id="tbody">
					   
					  </tbody>
					</table>
				</div>
				<hr>
				
				
		<form class="layui-form" action="">			  
				  <div class="layui-form-item">
				    <div class="layui-inline">
					   <label class="layui-form-label">是否紧急</label>
					    <div class="layui-input-block" >
					      <input  name="indentUrgency" value="1" title="是" checked="" type="radio">
					      <input  name="indentUrgency" value="0" title="否" type="radio">
					    </div>
				  </div>
				    <div class="layui-inline">
					      <label class="layui-form-label">需要时间</label>
					      	<div class="layui-input-block">
					        <input id="indentWorktime" name="indentWorktime" lay-verify="required" placeholder="例如：1天，1月，1年" autocomplete="off" class="layui-input" type="text">
					      </div>
				    </div>
				    <div class="layui-inline">
				    
					     <label class="layui-form-label">完成时间</label>
					     <div class="layui-input-inline">
					     <input name="indentEndtime" id="indentEndtime" lay-verify="date" placeholder="预计完成时间" autocomplete="off" class="layui-input" type="text">
					      </div>
					  
				    </div>
				    
				    </div>
					    <div class="layui-input-block1">
					      <textarea placeholder="请输入备注" id="remark" name="remark" class="layui-textarea"></textarea>
					    </div>
			</form>	
				   <div align="right">
					<hr>
					<button class="layui-btn layui-btn-small" onclick="getTableContent('kinList')" lay-submit="" lay-filter="demo1"><i class="layui-icon">&#xe609;</i>立即提交</button>
					
				</div>
				
			</div>
		</div>
	</body>
	<script type="text/javascript">
	$.ajaxSetup({
		  async:false
		});
	
	$(function(){
		var url = 'ErpKindsAction/showListAjax.action';
		$.post(url,null,function(m){
			for(i=0;i<m.length;i++){	
				$("#kinName").append("<option value='"+m[i].kinId+"'>"+m[i].kinName+"</option>");
			}
		},"json")
		
	})
	</script>
	
	<script type="text/javascript">
		showNum();//更改显示记录数
		var layer;
		
		
		layui.use('layer', function(){
		  layer = layui.layer;
		  
		  //全选提示
		  $('#quanxuan').mouseover(function(){
		  	  var that = this;
		  	  layer.tips('点击全选',"#quanxuan",{
		  		tips:1,
		  		time :700
		  	  }); //在元素的事件回调体中，follow直接赋予this即可
		  	});
		});
		//全选
		$('#quanxuan').click(function(){
			$("#kinList input[type='checkbox'][name='kin']").prop("checked",$(this).prop("checked"));
		});
		//删除货品
		function deleteKin(){
			var checkbox = $("#kinList input[type='checkbox'][name='kin']:checked");
			if(checkbox.length==0){
				layer.msg('请选择商品再进行删除');
			}else{
				layer.confirm('是否删除选中商品?', {icon: 3, title:'提示'}, function(index){
					$(checkbox).each(function(i,ele){
						var tr = $(this).parent().parent();
						var kinId = tr.children().eq(1).children().eq(0).val();//商品ID
						var kinNum = tr.children().eq(7).children().eq(0).val();//数量
						var remark = tr.children().eq(9).html();//备注
						tr.remove();
						layer.msg('删除成功！');
						showNum();//更改显示记录数
					});
					layer.close(index);
				});
			}
		}
		//更改记录数
		function showNum(){
			$("#showNum").html($("#kinList tr").length-3);
		}
		
		function getTableContent(id){
						var yi = $("input[name='indentUrgency']:checked").val();
						var er=$("#indentWorktime").val();
						var san=$("#indentEndtime").val();
						var si=$("#remark").val();
						var url="<%=basePath%>/detail/add.action?indentUrgency="+yi+"&indentWorktime="+er+"&indentEndtime="+san+"&remark="+si;
					    var mytable = document.getElementById(id);
					    var data = "";
					    for(var i=2,rows=mytable.rows.length; i<rows; i++){
					        for(var j=1,cells=mytable.rows[i].cells.length; j<cells; j++){
					            if(!data[i]){
					                data[i] = new Array();
					            }
					            data += mytable.rows[i].cells[j].innerHTML+"_";
					        }
					        data+="&";
					    }
					    if(er!=null & er!="" & san!=null & san!="" & data!=null & data!=""){
					    	$.post(url,{str:data},function(m){
					    		if(m.state==1){
					    			$("#indentWorktime").val("");
									$("#indentEndtime").val("");
									$("#tbody").html("");
									$("#remark").val("");
									layer.msg("操作成功");
									
								}
							});
					    }else{
					    	 layer.msg("请认真输入");
					    }
				
			}
		
	</script>
	
	
	<script>
	var form;
	layui.use(['form', 'layedit', 'laydate'], function(){
	 form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;
	  
	 //前后若干天可选，这里以7天为例
	  laydate.render({
	    elem: '#indentEndtime'
	    ,min: -0
	    ,max: 10000
	  });
	  laydate.render({
		    elem: '#indentEndtime'
	});
	  laydate.render({
	    elem: '#date1'
	  });
	  

	  
	
	  
	  
	});


function add(){
	 var kinName=$("#kinName").val();//下拉框的值
	 var username=$("#username").val();//数量
	 var url="<%=basePath%>/ErpKindsAction/findById.action";
	  var date={"kinId":kinName};
	  if(kinName!=null & kinName!="" & username!=null & username!="" & username>0){
	  $.post(url,date,function(mes){
		  var money=username*mes.kinPrice;
				$("#tbody").append("<tr><td><input type='checkbox' name='kin'></td><td>"+mes.kinSerial+"</td><td>"+mes.kinName+"</td><td>"+mes.kinContent+"</td><td>"+mes.kinExpiration+"</td><td>"+mes.kinPrice+"</td><td>"+username+"</td><td>"+money+"</td><td style='display:none'>"+mes.kinId+"</td></tr>");
		
	  },"json");
	  $("#kinName").next().children("div").children("input").val("");//选择kinName的值中下一节点div，在去下一节点input在给input复职为空
	  $("#kinName").val("");
	  $("#username").val("");
	  }else{
		  layer.msg("请认真输入，请选择商品或输入数量");
	  }
}
</script>
</html>