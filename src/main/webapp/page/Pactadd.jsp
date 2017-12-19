<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同增加</title>
	<link rel="stylesheet" href="http://127.0.0.1:8090/medicine/res/layui/css/layui.css" media="all">
	<script src="http://127.0.0.1:8090/medicine/res/js/jquery-2.1.3.min.js" type="text/javascript"></script>
	<script src="http://127.0.0.1:8090/medicine/res/layui/layui.js" charset="utf-8"></script>
	
	
	<style type="text/css">
		body{
		padding: 30px;
	}
		
	</style>
</head>
<body>

	<form class="layui-form layui-form-pane" id="express" method="post">
  
  <input type="hidden" id="pactId" name="pactId">
  
  <div class="layui-form-item">
    <label class="layui-form-label">类型</label>
    <div class="layui-input-block">
      <select name="patypeId" id="patypeId" lay-verify="required" lay-search="">
          <option value="">请选择类型</option>
       
        </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">采购编号</label>
    <div class="layui-input-block">
      <select name="purId" id="purId" lay-verify="required" lay-search="">
          <option value="">请选择采购编号</option>
         
        </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">供货商名称</label>
    <div class="layui-input-block">
      <select name="applyId" id="applyId" lay-verify="required" lay-search="">
          <option value="">请选择供货商名称</option>
          
        </select>
    </div>
  </div>
	
	
  <div class="layui-form-item">
    <label class="layui-form-label">标题</label>
    <div class="layui-input-block">
      <input name="pactTitle" id="pactTitle" autocomplete="off" lay-verify="required" placeholder="请输入标题" class="layui-input" type="text">
    </div>
  </div>
 
 
 <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">内容</label>
    <div class="layui-input-block">
      <textarea class="layui-textarea layui-hide" id="pactText" name="pactText"></textarea>
    </div>
  </div>
  
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
          
  <script type="text/javascript">
	$.ajaxSetup({
		  async:false
		});
	
	$(function(){
		
		var purId = GetQueryString("purId");
		var applyId = GetQueryString("applyId");
		var patypeId = GetQueryString("patypeId");
		
		//供货商下拉框查询
		var url = 'pact/findByxl.action';
		$.post(url,null,function(m){
			for(i=0;i<m.length;i++){
				if(applyId==m[i].applyId){
					$("#applyId").append("<option value='"+m[i].applyId+"' selected>"+m[i].applyName+"</option>");
				}else{
					$("#applyId").append("<option value='"+m[i].applyId+"'>"+m[i].applyName+"</option>");
				}
			}
		},"json")
		
		//合同类型下拉框查询
		var url = 'pact/findBylx.action';
		$.post(url,null,function(m){
			for(i=0;i<m.length;i++){
				if(patypeId==m[i].patypeId){
					$("#patypeId").append("<option value='"+m[i].patypeId+"' selected>"+m[i].patypeName+"</option>");
				}else{
					$("#patypeId").append("<option value='"+m[i].patypeId+"'>"+m[i].patypeName+"</option>");
				}
				
			}
		},"json")
		
		//采购下拉框查询
		var url = 'pact/findBycg.action';
		$.post(url,null,function(m){
			for(i=0;i<m.length;i++){
				if(purId==m[i].purcId){
					$("#purId").append("<option value='"+m[i].purcId+"' selected>"+m[i].purcSerial+"</option>");
				}else{
					$("#purId").append("<option value='"+m[i].purcId+"'>"+m[i].purcSerial+"</option>");
				}
				
			}
		},"json")
		
		
	})
	</script>        
          
          

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
var index;
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
 
  //构建一个默认的编辑器
  index = layedit.build('pactText');
 
  
  //监听提交
  form.on('submit(demo1)', function(data){
	  //注意：parent 是 JS 自带的全局对象，可用于操作父页面
	  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	 
	  var formData = data.field;//表单所有数据
	  
	  var textarea = layedit.getContent(index);//富文本编辑器取值
	  
	  
	  formData.pactText=textarea;//把富文本编辑器中的值放到表单中
	  
	  var url="pact/insertSelectivePact.action";
	 
	  $.post(url,formData,function(mes){
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
    var reg = new RegExp("(^|&)"+ id +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

	//当页面加载时运行，给文本复职
	$(function(){
			var id = GetQueryString("pactId");
			var data = {"pactId":id};
			var url = "pact/findByID.action";
			if(id!=null & id!=""){
				$.post(url, data, function(mes){
					$("#pactId").val(mes.pactId);
					$("#pactTitle").val(mes.pactTitle);
					$("#pactText").text(mes.pactText);
					form.render("radio");
				});
			}
			
			
		});
</script>
</body>
</html>