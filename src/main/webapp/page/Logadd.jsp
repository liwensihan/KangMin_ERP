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
<title>生产日志增加</title>
		<link rel="stylesheet" href="<%=basePath%>res/layui/css/layui.css" media="all">
	<script src="<%=basePath%>res/js/jquery-2.1.3.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>res/layui/layui.js" charset="utf-8"></script>
		
	<style type="text/css">
		.layui-input, .layui-textarea {
		    display: block;
		    width: 97%;
		    padding-left: 10px;
		}
		.layui-form-select .layui-edge {
		    position: absolute;
		    right: 30px;
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
    <label class="layui-form-label">订单编号</label>
    <div class="layui-input-block">
      <select name="indentId" id="indentId" lay-filter="aihao">
        <option value=""></option>
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">日志标题</label>
    <div class="layui-input-block">
      <input name="logTitle" id="logTitle" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input" type="text">
    </div>
  </div>
  
  
  <div class="bigDiv">
			<div class="bodyDiv" style="width:904px;margin: auto;">
				<div style="text-align: center;">
  <table id="kinList" class="layui-table" lay-size="sm">
					  <thead>
					    <tr>
					      <th>商品名称</th>
					      <th>商品总数量</th>
					      <th>已生产数量</th>
					       <th>今日生产数量</th>
					       <th style="display:none">ID</th>
					    </tr>
					  </thead>
					  <tbody id="tbody">
					  
					  </tbody>
					</table>
  </div>
  </div>
  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">内容</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" name="logContent" id="logContent" class="layui-textarea"></textarea>
    </div>
  </div>
  
  
   
</form>

<div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn layui-btn-small" onclick="getTableContent('kinList')" lay-submit="" lay-filter="demo1"><i class="layui-icon">&#xe609;</i>立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary" >重置</button>
    </div>
  </div>

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

//循环出商品复选框
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
	
			 $("#tbody").html("");
			 var url="dent/findByshowId.action?indentId="+data.value;
			 $.post(url,null,function(mes){
				 for(i=0;i<mes.length;i++){	
						$("#tbody").append("<tr><td>"+mes[i].KIN_NAME+"</td><td>"+mes[i].ENTDE_NUM+"</td><td>"+mes[i].NUM+"</td><td><input class='inputText num' type='text' onkeyup='total(this,"+mes[i].NUM+");'  value='0' maxlength='10'></td><td style='display:none'>"+mes[i].KIN_ID+"</td></tr>");
					}
			  },"json");
		 
	}); 
  
 
  
  

	

});



//提交
function getTableContent(id){
	//注意：parent 是 JS 自带的全局对象，可用于操作父页面
	  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	  var indentId=$("#indentId").val();
	var logTitle=$("#logTitle").val();
	 var logContent=$("#logContent").val();
	 var url="<%=basePath%>/log/add.action?logTitle="+logTitle+"&logContent="+logContent+"&indentId="+indentId;
     var mytable = document.getElementById(id);
    var data = "";
    for(var i=1,rows=mytable.rows.length; i<rows; i++){
        for(var j=1,cells=mytable.rows[i].cells.length; j<cells; j++){
            if(!data[i]){
                data[i] = new Array();
            }
            if(j==3){
            	data += mytable.rows[i].cells[j].childNodes[0].value+"_";
            }else{
            	data += mytable.rows[i].cells[j].innerHTML+"_";
            }
        }
        data+="&";
    }
  if(data==null || data==""){
	  layer.msg("请认真输入");
  }else{
	  $.post(url,{str:data},function(m){
	    	
  		if(m.state==1){
  			parent.layer.msg("操作成功");
				parent.layer.close(index);
				parent.table.reload('testReload');
			}
		});  
  }
   
   

}
	
	
	           

</script>
</body>
</html>