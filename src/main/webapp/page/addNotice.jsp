<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>发布公告</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<style type="text/css">
			body{
				padding: 10px;
			}
		</style>
	</head>
	<body>
		<fieldset class="layui-elem-field layui-field-title">
		  <legend><i class="layui-icon" style="font-size: 25px;">&#xe609;</i>   发布公告</legend>
		</fieldset>

		<form class="layui-form layui-form-pane" action="">
		  <div class="layui-form-item">
		    <label class="layui-form-label">公告标题</label>
		    <div class="layui-input-block">
		      <input type="text" id="noticeTitle" name="noticeTitle" maxlength="50" required  lay-verify="required" placeholder="请输入公告标题" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label layui-form-text">公告内容</label>
		    <div class="layui-input-block">
		      <textarea id="noticeContent" maxlength="500" style="display: none;"></textarea>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-submit lay-filter="formDemo">立即发布</button>
		      <button type="reset" class="layui-btn layui-btn-primary" onclick="resetForm()">重置</button>
		    </div>
		  </div>
		</form>
		
		
		<script type="text/javascript">
			var layedit;//富文本编辑器
			var layeditIndex;//富文本编辑器索引
			var loadIndex;//加载层
			
			//富文本编辑器
			layui.use('layedit', function(){
				layedit = layui.layedit;
				layeditIndex = layedit.build('noticeContent'); //建立编辑器
			});
			
			layui.use('form', function(){
				var form = layui.form;
				//提交表单
				form.on('submit(formDemo)', function(formData){
					var noticeTitle = $("#noticeTitle").val();
				  var noticeContent = layedit.getContent(layeditIndex);
				  if(noticeContent==null || noticeContent=="" || noticeContent=="<br>"){
					  layer.msg('请输入正文内容！');
					  return false;
				  }
				 loadIndex = layer.load();//出现加载层
			  		var url = "notice/insert.action";
				 	var data ={"noticeTitle":noticeTitle,"noticeContent":noticeContent};
					$.post(url, data, function(info){
						layer.close(loadIndex);//加载层关闭  
						if(info>0){
							layer.msg('发布成功！');
							resetForm();
						}else{
							layer.msg('操作失败！');
						}
					});
				  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
				});
			});
			
			//重置表单
			function resetForm(){
				$("#noticeTitle").val("");
				layedit.setContent(layeditIndex,"");
			}
			
		</script>
	</body>
</html>