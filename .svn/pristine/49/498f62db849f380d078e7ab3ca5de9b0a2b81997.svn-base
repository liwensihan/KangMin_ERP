<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员增加</title>
		<link rel="stylesheet" href="<%=basePath%>res/layui/css/layui.css" media="all">
	<script src="<%=basePath%>res/js/jquery-2.1.3.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>res/layui/layui.js" charset="utf-8"></script>
		
	<style type="text/css">
		.layui-input, .layui-textarea {
		    display: block;
		    width: 85%;
		    padding-left: 10px;
		}
		.layui-form-select .layui-edge {
		    position: absolute;
		    right: 200px;
		    top: 50%;
		    margin-top: -3px;
		    cursor: pointer;
		    border-width: 6px;
		    border-top-color: #c2c2c2;
		    border-top-style: solid;
		    transition: all .3s;
		    -webkit-transition: all .3s;
		}
		.layui-form-select dl {
			min-width: 85%;
		}
		.layui-table {
		    width: 107%;
		    margin: 10px -74px;
		    background-color: #fff;
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

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>增加生产订单日志</legend>
</fieldset>
 
 
 <form class="layui-form" id="express" method="post">
	<input type="hidden" id="memberId" name="memberId">
  
 
  
  <div class="layui-form-item">
    <label class="layui-form-label">单行选择框</label>
    <div class="layui-input-block">
      <select name="indentId" id="indentId" lay-filter="aihao">
        <option value=""></option>
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">单行输入框</label>
    <div class="layui-input-block">
      <input name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
    </div>
  </div>
  
  
  <div class="bigDiv">
			<div class="bodyDiv" style="width:1000px;margin: auto;">
				<div style="text-align: center;">
  <table id="kinList" class="layui-table" lay-size="sm">
					  <thead>
					    <tr>
					      <th>商品名称</th>
					      <th>商品总数量</th>
					      <th>以生产数量</th>
					       <th>今日生产数量</th>
					    </tr>
					  </thead>
					  <tbody id="tbody">
					  
					  </tbody>
					</table>
  </div>
  </div>
  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">普通文本域</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" class="layui-textarea"></textarea>
    </div>
  </div>
  
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <input type="button" class="layui-btn" lay-submit="" lay-filter="demo1" value="立即提交">
      <button type="reset" class="layui-btn layui-btn-primary" >重置</button>
    </div>
  </div>
</form>

<script type="text/javascript">

//判断是否超出生产总数量
function total(obj,id){
	tr = $(obj).parent().parent();
	var ttd=tr.children().eq(2).text(id);
	var price = tr.children().eq(1).text();
	var td = tr.children().eq(2).text();
	var y=Number(price) - Number(td);
	var ttd=tr.children().eq(2).text(Number(td) + Number(obj.value));
	if(obj.value>y){
		var ttd=tr.children().eq(2).text(id);
		layer.msg("已超出数量，请重新输入");
		var td = tr.children().eq(3).html(tr.children().eq(3).html());
	}
}
</script>

<!-- 表单验证 -->
<script>

//循环出站点复选框
$(function(){
	var url = 'dent/findByxl.action';
	$.post(url,null,function(m){
		for(i=0;i<m.length;i++){
			$("#indentId").append("<option value='"+m[i].indentId+"'>"+m[i].indentNumber+"</option>");
		}
		
	},"json"); 
	
	
});



layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  
  //下拉框监听
  form.on('select(aihao)', function(data){
	  
	  
	 
  
	 var url="dent/show.action?indentId="+data.value;
	  $.post(url,null,function(mes){
		 if(mes.indentState==1){
			 $("#tbody").html("");
			 alert("来了1");
			 var url="dent/findByshowId.action?indentId="+data.value;
			 $.post(url,null,function(mes){
				 for(i=0;i<mes.length;i++){	
						$("#tbody").append("<tr><td>"+mes[i].KIN_NAME+"</td><td>"+mes[i].ENTDE_NUM+"</td><td>"+0+"</td><td><input class='inputText num' type='text' onkeyup='total(this,0);'  value='0' maxlength='10'></td></tr>");
					}
			  },"json");
		 }else{
			 $("#tbody").html("");
			 var url="dent/findByshow.action?indentId="+data.value;
			 $.post(url,null,function(mes){
				 for(i=0;i<mes.length;i++){	
						$("#tbody").append("<tr><td>"+mes[i].KIN_NAME+"</td><td>"+mes[i].ENTDE_NUM+"</td><td>"+mes[i].num+"</td><td><input class='inputText num' type='text' onkeyup='total(this,"+mes[i].num+");'  value='0' maxlength='10'></td></tr>");
					}
			  },"json");
		 }
	  },"json");
	}); 
  
 
  
  

	
	
//监听提交
	form.on('submit(demo1)', function(data){
		  //注意：parent 是 JS 自带的全局对象，可用于操作父页面
		  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		  
		  var url="member/addOrUpdate.action";
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
    var reg = new RegExp("(^|&)"+ id +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

	//当页面加载时运行，给文本复职
	$(function(){
			var id = GetQueryString("memberId");
			var data = {"memberId":id};
			var url = "member/findById.action";
			if(id!=null & id!=""){
				$.post(url, data, function(mes){
					$("#memberId").val(mes.memberId);
					$("#memberName").val(mes.memberName);
					$("#memberPhone").val(mes.memberPhone);
					$("#memberEmail").val(mes.memberEmail);
					$("#express").find("input[type='radio'][name='memberSex'][value="+mes.memberSex+"]").prop("checked","checked");//单选框赋值
					form.render("radio");
				});
			}
			
			
		});
	
	
	           

</script>
</body>
</html>