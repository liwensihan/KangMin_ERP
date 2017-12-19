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
<title>分店库存修改</title>
	<link rel="stylesheet" href="<%=basePath%>res/layui/css/layui.css" media="all">
	<script src="<%=basePath%>res/js/jquery-2.1.3.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>res/layui/layui.js" charset="utf-8"></script>
	
	
	<style type="text/css">
		body{
		padding: 30px;
	}
		
	</style>
</head>
<body>

	<form class="layui-form layui-form-pane" id="express" method="post">
  
  <input type="hidden" id="stockId" name="stockId">
 
 
  <div class="layui-form-item">
    <label class="layui-form-label">库存数量</label>
    <div class="layui-input-block">
      <input name="stockSuount" id="stockSuount" autocomplete="off" lay-verify="required" placeholder="请输入标题" class="layui-input" type="text">
    </div>
  </div>

  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
               
          
          

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
	  var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;
	  
	//监听提交
		form.on('submit(demo1)', function(data){
			  //注意：parent 是 JS 自带的全局对象，可用于操作父页面
			  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			  
			  var url="sumstock/update.action";
			  var date =$("#express").serialize();
			  $.post(url,date,function(mes){
				  if(mes.state==1){
					  parent.layer.close(index);
					  parent.layer.msg(mes.mes);
					  parent.table.reload('testReload');
					}else{
						 parent.layer.close(index);
						 parent.layer.msg(mes.mes);
						parent.table.reload('testReload');
					}
			  },"json");
		});
	});

//取网址上的ID
function GetQueryString(id){
    var reg = new RegExp("(^|&)"+ id+ "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

	//当页面加载时运行，给文本复职
	$(function(){
			var id = GetQueryString("STOCK_ID");
			var data = {"stockId":id};
			var url = "sumstock/findByID.action";
			if(id!=null & id!=""){
				$.post(url, data, function(mes){
					$("#stockId").val(mes.stockId);
					$("#stockSuount").val(mes.stockSuount);
					form.render("radio");
				});
			}
			
			
		});
</script>
</body>
</html>