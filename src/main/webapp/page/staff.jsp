<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
  <style>
  	.layui-table-view {
	    margin: 10px 18px;
	    overflow: hidden;
	}
	body{
		padding: 10px;
	}

	#sousuo td{
		padding-right: 5px;
		padding-top: 5px;
	}
	#sousuo .layui-input {
 		height: 40px;
 		width:150px;
	}
	#div{
		z-index: 19891015; 
		top:10%;
		left:25%;
		display: none;
		position: fixed;
		background-color: #fff;
		width:670px;
	}
	#div1{
		display: none;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		position: fixed;
		z-index: 19891012; 
		background-color: rgb(0, 0, 0); 
		opacity: 0.3;
	}
	
	#div2{
		z-index: 19891013; 
		top:15%;
		left:32%;
		display: none;
		position: fixed;
		background-color: #fff;
		width:300px;
	}
	
	/*a  upload */
.a-upload {
    padding: 4px 10px;
    height: 20px;
    line-height: 20px;
    position: relative;
    cursor: pointer;
    color: #888;
    background: #fafafa;
    border: 1px solid #ddd;
    border-radius: 4px;
    overflow: hidden;
    display: inline-block;
    *display: inline;
    *zoom: 1
}

.a-upload  input {
    position: absolute;
    font-size: 100px;
    right: 0;
    top: 0;
    opacity: 0;
    filter: alpha(opacity=0);
    cursor: pointer
}

.a-upload:hover {
    color: #444;
    background: #eee;
    border-color: #ccc;
    text-decoration: none
}
  </style>
</head>
<body> 
<div class="demoTable">
		 &nbsp;&nbsp;&nbsp;&nbsp;
		 <div class="layui-inline">
		  	<form class="layui-form" id="sousuo" style="float: left;">
		  		<table>
		  			<tr>
		  				<td>
		  				    <select id="depaName1" name="depaName" lay-verify="required" lay-search="" width="50px">
							  <option value="">部门名称</option>
							</select>
		  				</td>
		  				<td>
			  				<select id="staSex1" name="staSex" lay-verify="required" lay-search="" width="50px" >
							  <option value="">性别</option>
							  <option value="男">男</option>
							  <option value="女">女</option>
							</select>
		  				</td>
		  				<td>
			  				<select id="staName1" name="staName" lay-verify="required" lay-search="" width="50px">
							  <option value="">员工姓名</option>
							</select>
		  				</td>
		  				<td>
			  				<select id="roleName1" name="roleName" lay-verify="required" lay-search="" width="50px">
							  <option value="">权限</option>
							</select>
		  				</td>
		  				<td>
			  				<select id="annexName1" name="annexName" lay-verify="required" lay-search="" width="50px">
							  <option value="">分店</option>
							</select>
		  				</td>
		  			</tr>
		  		</table>
			</form>
			<button class="layui-btn" style="margin-top: 5px;" data-type="reload">搜索</button>
			<button class="layui-btn layui-btn-normal" style="margin-top: 5px;" data-type="reload" id="add">增加</button>
		  </div>
		</div>

<table class="layui-table" lay-data="{ height:472, url:'staff/findAll.action', page:true, limit: 10,id:'testReload',method:'post'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'staName', width:110, fixed: true, align:'center'}">员工姓名</th>
      <th lay-data="{field:'staImg', width:110, align:'center',templet:'#staImgs'}">员工照片</th>
      <th lay-data="{field:'depaName', width:110, align:'center'}">部门</th>
      <th lay-data="{field:'annexName', width:110, align:'center'}">分店</th>
      <th lay-data="{field:'roleName', width:110, align:'center'}">权限</th>
      <th lay-data="{field:'staSerial', width:110, align:'center'}">编号</th>
      <th lay-data="{field:'staEmail', width:110, align:'center'}">电话号码</th>
   	  <th lay-data="{field:'staAge', width:110, align:'center'}">年龄</th>
   	  <th lay-data="{field:'staSex', width:110, align:'center'}">性别</th>
   	  <th lay-data="{field:'staEntrytime', width:110, align:'center'}">入职时间</th>
   	  <th lay-data="{field:'staDimissiontime', width:110, align:'center'}">离职时间</th>
      <th lay-data="{fixed: 'right', width:220, align:'center', toolbar: '#barDemo'}"></th>
    </tr>
  </thead>
</table>
<script type="text/html" id="staImgs">
	<img alt="暂无图片" src="{{ d.staImg }}" style="height:30px;"/>
</script>


<script type="text/javascript">
	//同步
	$.ajaxSetup({
	  async:false
	});
	$(function(){
		url="staff/getStaff.action";
		$.post(url,null,function(m){
			for(i=0;i<m.length;i++){
				$("#staName1").append("<option value='"+m[i].staName+"'>"+m[i].staName+"</option>");
			}
		},"json")


		url="staff/getDepa.action";
		$.post(url,null,function(m){
			for(i=0;i<m.length;i++){
				$("#depaName1").append("<option value='"+m[i].depaName+"'>"+m[i].depaName+"</option>");
			}
		},"json")
		
		
		url="staff/getAnnex.action";
		$.post(url,null,function(m){
			for(i=0;i<m.length;i++){
				$("#annexName1").append("<option value='"+m[i].annexName+"'>"+m[i].annexName+"</option>");
			}
		},"json")
		
		 url="staff/getRole.action";
	 	 $.post(url,null,function(m){
	 	 for(i=0;i<m.length;i++){
	  			$("#roleName1").append("<option value='"+m[i].roleName+"'>"+m[i].roleName+"</option>");
	 		}
	     },"json")
		
		
		$("#add").click(function(){
			
			
			layer.open({
		  		  type: 1,
		  		  title: ['增加'],
		  		  content: $('#divwe'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
		  		 // btn: ['确定'], //可以无限个按钮
		  		  area: ['55%','90%'],
		  		  cancel:function(){
		  			  
		  		  }
		  		  
		    });
			
			$("#depaId").html("<option value=''>部门名称</option>");
			var form = layui.form;
   			url="staff/getDepa.action";
			 $.post(url,null,function(m){
				for(i=0;i<m.length;i++){
					$("#depaId").append("<option value='"+m[i].depaId+"'>"+m[i].depaName+"</option>");
				}
			},"json");
			 
			 $("#annexName").html("<option value=''>分店名称</option>");
			 url="staff/getAnnex.action";
				$.post(url,null,function(m){
					for(i=0;i<m.length;i++){
						$("#annexName").append("<option value='"+m[i].annexId+"'>"+m[i].annexName+"</option>");
					}
				},"json")
			 
			 $("#roleName").html("<option value=''>权限名称</option>");	
			 url="staff/getRole.action";
	 		 $.post(url,null,function(m){
	 			 for(i=0;i<m.length;i++){
	 				$("#roleName").append("<option value='"+m[i].roleId+"'>"+m[i].roleName+"</option>");
	 			 }
	 		 },"json")
			    $(':input','#oneFrom')    
     		    .not(':button, :submit, :reset, :hidden')    
    			.val('')    
    			.removeAttr('checked')    
    			.removeAttr('selected');   
	 		    $("#staId").val("");
	 		 	$("#staAge").val("");
	 		 	$("#perRoleId").val("");
			    form.render('select');
		})
		
		
		
		
		
	})
</script>
 
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">上传照片</a>
  <a class="layui-btn layui-btn-mini" lay-event="edit" >编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>
               
          
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
var table;
var laydate;
var upEndData;
layui.use(['table','form','laydate'], function(){
table = layui.table;
  var form = layui.form;
  laydate = layui.laydate;
  
  
  //常规用法
  laydate.render({
    elem: '#staEntrytime'
  	
  });
 	
  var myDate = new Date();
  
  laydate.render({
	    elem: '#staDimissiontime'
	    ,min:  myDate.toLocaleDateString()
	    ,max: '2080-10-14'
	    
	  });  
  
  form.verify({
	  staName: function(value, item){ //value：表单的值、item：表单的DOM对象
		    if(!new RegExp("^[\u4e00-\u9fa5]*$").test(value)){
		      return '请输入正确的员工姓名';
		    }
		  }
	  
	  	  ,staPwd: function(value, item){ //value：表单的值、item：表单的DOM对象
		    if(!/^[\S]{6,12}$/.test(value)){
		      return '密码必须6到12位，且不能出现空格';
		    }
	  	  	if(value!=$("#QRpwd").val()){
	  	  	  return '两次密码输入不相同';
	  	  	}
		  }
	  	  ,staEmail:function(value, item){
	  		  if(value!=phone){
	  			url="staff/getPhone.action";
	    		  data={staEmail:value};
	    		  var isv ;
	    		  $.post(url,data,function(m){
	    			 if(m.mes == 'no'){
	    				 isv = 1;
	    			 }
	    		  })
	    		  if(isv==1){
	    			  return "该用户名已存在。";
	    		  }
	  		  }
	  	  }
  
	});      
  
  form.on('submit(formDemo)', function(data){
	  //注意：parent 是 JS 自带的全局对象，可用于操作父页面
	  console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
	  console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
	  console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
		    	  layer.confirm('确定提交吗！', function(){ 
					url="staff/add.action";
					data=$("#oneFrom").serialize();
					$.post(url,data,function(m){
						if(m.mes=="update"){
					      var demoReload = $('#depaName1');
					      var demoReload2 = $('#staSex1');
					      var demoReload4 = $('#staName1');
					      var demoReload5 = $('#roleName1');
					      var demoReload6 = $('#annexName1');
					      table.reload('testReload', {
					        where: {
					         
					        	depaName: demoReload.val(),
					         	staSex: demoReload2.val(),
					         	staName: demoReload4.val(),
					         	roleName: demoReload5.val(),
					         	annexName: demoReload6.val()
					        }
					      }); 
							layer.msg("修改成功");
							layer.close(index);
							table.reload('testReload');
						}else{
							  var demoReload = $('#depaName1');
						      var demoReload2 = $('#staSex1');
						      var demoReload4 = $('#staName1');
						      var demoReload5 = $('#roleName1');
						      var demoReload6 = $('#annexName1');
						      table.reload('testReload', {
						        where: {
						         
						        	depaName: demoReload.val(),
						         	staSex: demoReload2.val(),
						         	staName: demoReload4.val(),
						         	roleName: demoReload5.val(),
						         	annexName: demoReload6.val()
						        }
						      });
						    
							layer.msg("增加成功");
						}
					},"json")
		})
	  
	  
	  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	});
  
  //监听表格复选框选择
  table.on('checkbox(demo)', function(obj){
    console.log(obj)
  });
  //监听工具条
  var index ;
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    $("#data").val(data.depaId);
    if(obj.event === 'detail'){
    	$("#pian").html("");
    	$("#pian").append("<a class='layui-layer-btn0' href=\"javascript:uploadFile('"+data.staId+"')\">确定</a><a href='javascript:quxiao2();'>取消</a>");
    	$("#div1").fadeIn(200);
   		 $("#div2").fadeIn(200);
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        url="staff/updateById.action";
    	date={id:data.staId};
    	$.post(url,date,function(m){
    		
    	},"json")
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
    	 url="staff/getDepa.action";
 		 $.post(url,null,function(m){
 			$("#depaId").html("<option value=''>部门名称</option>");
 			for(i=0;i<m.length;i++){
 				if(data.depaId==m[i].depaId){
 					$("#depaId").append("<option value='"+m[i].depaId+"' selected = 'selected'>"+m[i].depaName+"</option>");
 				}else{
 					$("#depaId").append("<option value='"+m[i].depaId+"'>"+m[i].depaName+"</option>");
 				}
 			}
 		},"json");
 		
 		 url="staff/getRole.action";
 		 $.post(url,null,function(m){
 			$("#roleName").html("<option value=''>权限名称</option>");
 			 for(i=0;i<m.length;i++){
 				if(data.roleId==m[i].roleId){
 					$("#roleName").append("<option value='"+m[i].roleId+"' selected = 'selected'>"+m[i].roleName+"</option>");
 				}else{
 					$("#roleName").append("<option value='"+m[i].roleId+"'>"+m[i].roleName+"</option>");
 				}
 			 }
 		 },"json")
 		 
 		 
 		 url="staff/getAnnex.action";
 		 $.post(url,null,function(m){
 			$("#annexName").html("<option value=''>分店名称</option>");
 			 for(i=0;i<m.length;i++){
 				if(data.annexId==m[i].annexId){
 					$("#annexName").append("<option value='"+m[i].annexId+"' selected = 'selected'>"+m[i].annexName+"</option>");
 				}else{
 					$("#annexName").append("<option value='"+m[i].annexId+"'>"+m[i].annexName+"</option>");
 				}
 			 }
 		 },"json")
 		 
 		index = layer.open({
		  		  type: 1,
		  		  title: ['编辑'],
		  		  content: $('#divwe'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
		  		 // btn: ['确定'], //可以无限个按钮
		  		  area: ['55%','90%'],
		  		  cancel:function(){
		  			  
		  		  }
		  		  
		    });
 		 
 		 $("#staName").val(data.staName);
 		 $("#staSerial").val(data.staSerial);
 		 $("#staEmail").val(data.staEmail);
 		 $("#staPwd").val(data.staPwd);
 		 $("#QRpwd").val(data.staPwd);
 		 $("#staAge").val(data.staAge);
 		 $("#staEntrytime").val(data.staEntrytime);
 		 $("#staDimissiontime").val(data.staDimissiontime);
 		 $("#staId").val(data.staId);
 		 $("#perRoleId").val(data.perRoleId);
 		 form.render('select');
    	 $("#bian").html("编辑");
    	 
    	 
    }
  });
  	
 
  var $ = layui.$, active = {
		    reload: function(){
		      var demoReload = $('#depaName1');
		      var demoReload2 = $('#staSex1');
		      var demoReload4 = $('#staName1');
		      var demoReload5 = $('#roleName1');
		      var demoReload6 = $('#annexName1');
		      table.reload('testReload', {
		        where: {
		         
		        	depaName: demoReload.val(),
		         	staSex: demoReload2.val(),
		         	staName: demoReload4.val(),
		         	roleName: demoReload5.val(),
		         	annexName: demoReload6.val()
		        }
		      });
		    }
		  };
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});

	function quxiao(){
		$("#div1").fadeOut(200);
		$("#div").fadeOut(200);
	}
	
	function quxiao2(){
		$("#div1").fadeOut(200);
		$("#div2").fadeOut(200);
	}
	
	
	function uploadFile(id){
	    	  layer.confirm('确定提交吗！', function(){
				var form = new FormData(document.getElementById("oneForm"));
				if($("#file").val()!=""){
					$.ajax({
				        url:"staff/updateEmpPhoto.action?id="+id,
				        type:"post",
				        data:form,
				        processData:false,
				        contentType:false,
				        success:function(data){
				        	  var demoReload = $('#depaName1');
						      var demoReload2 = $('#staSex1');
						      var demoReload4 = $('#staName1');
						      var demoReload5 = $('#roleName1');
						      table.reload('testReload', {
						        where: {
						         
						        	depaName: demoReload.val(),
						         	staSex: demoReload2.val(),
						         	staName: demoReload4.val(),
						         	roleName: demoReload5.val()
						        }
						      });
						    $("#div1").fadeOut(200);
						   	$("#div2").fadeOut(200);
				           	layer.msg("上传成功");
				           	$("#file").val("");
				           	$(".showFileName").html("");
				        },
				        error:function(e){
				        	layer.msg("上传失败");
				        }
				    });
				}else{
					layer.msg("请选择文件上传");
				}
		
	    	  });
		
	}
	
	
</script>
<div id="div1" times="1"></div>
<div  id="divwe" type="dialog" times="4" showtime="0" contype="string" style="display: none;">
<div style="height:20px;"></div>
	<form class="layui-form" action="" id="oneFrom">
	<input type="hidden" id="staId" name="staId">
	<input type="hidden" id="perRoleId" name="perRoleId">
	  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label"><span style="color:red;">*</span>员工姓名</label>
      <div class="layui-input-inline">
        <input name="staName" id="staName" autocomplete="off" lay-verify="required" class="layui-input" type="tel" lay-verify="staName">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label"><span style="color:red;">*</span>分店</label>
      <div class="layui-input-inline">
         <select id="annexName" name="annexId" lay-verify="required" lay-search="" width="50px">
			<option value="">分店名称</option>
	 	</select>
      </div>
    </div>
  </div>
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label"><span style="color:red;">*</span>手机(账号)</label>
      <div class="layui-input-inline">
        <input name="staEmail" id="staEmail" lay-verify="staEmail" autocomplete="off" class="layui-input" type="tel">
      </div>
    </div>
    <div class="layui-inline">
    <label class="layui-form-label"><span style="color:red;">*</span>部门</label>
    <div class="layui-inline">
      <select id="depaId" name="depaId" lay-verify="required" lay-search="" width="50px">
		<option value="">部门名称</option>
	 </select>
    </div>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label"><span style="color:red;">*</span>密码</label>
    <div class="layui-input-inline">
      <input name="staPwd" id="staPwd" lay-verify="staPwd" placeholder="请输入密码" autocomplete="off" class="layui-input" type="password">
    </div>
    <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
  </div>
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">确认密码</label>
      <div class="layui-input-inline">
        <input  id="QRpwd" autocomplete="off" class="layui-input" type="password">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label"><span style="color:red;">*</span>权限</label>
      <div class="layui-inline">
      <select id="roleName" name="roleId" lay-verify="required" lay-search="" width="50px">
		<option value="">权限名称</option>
	 </select>
	 </div>
    </div>
  </div>
  <div class="layui-form-item">
  <div class="layui-inline">
      <label class="layui-form-label">年龄</label>
      <div class="layui-input-inline">
        <select name="staAge" id="staAge" lay-search="">
          <option value="">直接选择或搜索选择</option>
          <option value="18">18</option>
          <option value="19">19</option>
          <option value="20">20</option>
          <option value="21">21</option>
          <option value="22">22</option>
          <option value="23">23</option>
          <option value="24">24</option>
          <option value="25">25</option>
          <option value="26">26</option>
          <option value="27">27</option>
          <option value="28">28</option>
          <option value="29">29</option>
          <option value="30">30</option>
          <option value="31">31</option>
          <option value="32">32</option>
          <option value="33">33</option>
          <option value="34">34</option>
          <option value="35">35</option>
          <option value="36">36</option>
          <option value="37">37</option>
          <option value="38">38</option>
          <option value="39">39</option>
          <option value="40">40</option>
        </select>
      </div>
    </div>
    <div class="layui-inline">
    <label class="layui-form-label">单选框</label>
    <div class="layui-inline">
      <input name="staSex" value="男" title="男" checked="" type="radio">
      <input name="staSex" value="女" title="女" type="radio">
    </div> 
    </div>
    </div>
    <div class="layui-form">
  <div class="layui-form-item">
  	<div class="layui-inline">
      <label class="layui-form-label"><span style="color:red;">*</span>入职日期</label>
      <div class="layui-input-inline">
        <input class="layui-input" lay-verify="required" name="staEntrytime" id="staEntrytime" placeholder="yyyy-MM-dd" type="text">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">离职日期</label>
      <div class="layui-input-inline">
        <input class="layui-input" id="staDimissiontime" name="staDimissiontime" placeholder="yyyy-MM-dd" type="text">
      </div>
    </div>
  </div>
</div>
	<div class="layui-layer-btn layui-layer-btn-">
	<button class="layui-btn" lay-submit lay-filter="formDemo" id="submit">立即提交</button>
	<button type="reset" class="layui-btn layui-btn-primary">重置</button>
	</div>
	<span class="layui-layer-resize"></span>
</form>
</div>

<div id="div2">
	<form id="oneForm">
		<div class="layui-layer-title" style="cursor: move;margin-bottom: 10px;" >上传图片</div>
    	<div>&nbsp;</div>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;" class="a-upload">选择文件<input type="file" name="file" id="file"></a>&nbsp;&nbsp;<div class="showFileName"></div>
    	<span class="layui-layer-setwin"><a class="layui-layer-ico layui-layer-close layui-layer-close1" href="javascript:quxiao2();"></a></span>
		<div style="height:10px;"></div>
		<div class="layui-layer-btn layui-layer-btn-" id="pian"></div>
		<span class="layui-layer-resize"></span>
    </form>
</div>                 
<script type="text/javascript">
$(".a-upload").on("change","input[type='file']",function(){
    var filePath=$(this).val();
    if(filePath.indexOf("jpg")!=-1 || filePath.indexOf("png")!=-1){
        $(".fileerrorTip").html("").hide();
        var arr=filePath.split('\\');
        var fileName=arr[arr.length-1];
        $(".showFileName").html(fileName);
    }else{
        $(".showFileName").html("");
        $(".fileerrorTip").html("您未上传文件，或者您上传文件类型有误！").show();
        return false 
    }
})
</script>
</body>
	
</html>