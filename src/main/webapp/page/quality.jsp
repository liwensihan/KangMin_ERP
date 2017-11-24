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
		<title>质检</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<style type="text/css">
			body{
				margin: 2%;
			}
			.bode{
				border-bottom: 1px solid #5FB878;
				width: 20%;
				float: left; 
			}
			.forzi{
				width: 8%;
				float: left;
			}
		</style>
</head>
<body>
<div class="demoTable">
  <div class="layui-inline" style="margin-left:40%;">
    <input class="layui-input" name="price" id="price" placeholder="编号/名字/备注" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" onclick="solo()">搜索</button>
   <a class="layui-btn" lay-event="edit" onclick="addtype()">增加</a>
</div>
<table class="layui-table" id="idTest" lay-filter="demo">
  
</table>
	<div id="from-div" style="display: none; margin: 2%;">
		<table class="layui-table"  lay-skin="nob" >
		  <tbody id="purSkin">
		    
		  </tbody>
		</table>
		<table class="layui-table"  lay-skin="nob" id="proTab">
		  
		</table>
		
		<div id="but-shen"  style=" position:fixed; bottom:6%;width:53.5%; padding-left: 22%;background-color: #f3f5f399;">
				<button class="layui-btn" style="margin-right: 23%;" onclick="yes()">
				  <i class="layui-icon">&#xe6af;</i>通过
				</button>
				<button class="layui-btn layui-btn-danger" onclick="no()">
				  <i class="layui-icon">&#xe69c;</i>打回
				</button>
		</div>
		<div id="add" style="position: fixed;bottom: 17%;width: 55px;height: 55px;background-color: #41406e33;margin-left: 67%;">
		 
				 <i class="layui-icon" style="font-size:55px; color: #fbf3f3e6" >&#xe654;</i>
		</div>
	</div>
	<div id="shengpi"style="padding:2%; display:none;">
			<!-- 质检表单开始 -->
			<form id="qualit-form">
				<div id="qualit-form-det">
				
				</div>
				<input type="hidden" id="qualityId" name="quaId">
				<div class="layui-form-item">
				    <div class="layui-inline">
				      <label class="layui-form-label">产品合格率</label>
				      <div class="layui-input-inline" style="width: 100px;">
				        <input name="quaGood" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'') "placeholder="良品" autocomplete="off" class="layui-input" id= type="text">
				      </div>
				      <div class="layui-form-mid">-</div>
				      <div class="layui-input-inline" style="width: 100px;">
				        <input name="quaBab" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'') "placeholder="不良品" autocomplete="off" class="layui-input" id="bab" type="text">
				      </div>
				    </div>
				 </div>
				<div class="layui-form-item layui-form-text">
				    <label class="layui-form-label">备注</label>
				    <div class="layui-input-block">
				      <textarea name="remark" placeholder="请输入内容" class="layui-textarea"></textarea>
				    </div>
				 </div>
				 <input type="reset" style="display:none;" /> 
			 </form>
			 <!-- 质检表单结束 -->
		</div>
<!-- 自定义模板  药效-->
<script type="text/html" id="resr">
  {{#  layui.each(d.res, function(index, item){ }}
		{{ item.resName || '' }},
  {{#  }); }}
</script>

<!-- 自定义模板  供应商-->
<script type="text/html" id="lyName">
  {{d.app.applyName}}
</script>
<script type="text/html" id="TypeName">
  {{d.typer.typeName}}
</script>	
<script>
	//通过的方法
	function yes(){
		$("input[type$='text']").each(function(n){  
	          if($(this).val()=="")  
	          {  
	               layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>填入正确的参数');
	          }else{
	        	  var data =$("#qualit-form").serialize();//表单序列化
	        	  data+="&quaIsva=1";
	        	  $.post("Purchase/updateByPrimaryKeySelective.action",data,function(mes){
	        		  if(mes.state==1){//真确的样式
					 		
				 		}else{
				 			layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
				 		}
	        	  });
	          }
	     });
	}
	//不通过的方法
	function no(){
		$("input[type$='text']").each(function(n){  
	          if($(this).val()==""){  
	               layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>填入正确的参数');
	          }else{
	        	  var data =$("#qualit-form").serialize();//表单序列化
	        	  
	          }
	     });
	}
	$("#good").blur(function(){
		var a = $("#good").val();
		var b = $("#qNum").html();
		if(a>b){
			$("#good").val(0);
			layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>良品不能大于总数量,请重新输入。。。');
		}
	});
	function babv(obj){
		var ps=obj.prev() ;
		//alert(ps.);
	}
	$("#bab").blur(function(){
		var a = $("#good").val();
		var c = $("#bab").val();
		var b = $("#qNum").html();
		if(c>b-a){
			var c = $("#bab").val(0);
			layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>不良品不能大于总数量-良品的数量,请重新输入。。。');
		}
	});
	//点击添加质检信息的时候打开表单隐藏点击按钮
	$("#add").click(function(){
		layer.open({
	  		  type: 1,
	  		  title: ['质检单'],
	  		  content: $('#shengpi'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
	  		 // btn: ['确定'], //可以无限个按钮
	  		  area: ['40%','90%'],
	  		  cancel:function(){
	  		  }
	  		  
	    });
		$("#add").hide();
	});
	//点击×的时候关闭质检表单打开点击按钮
	$("#qx").click(function(){
		$("#shengpi").hide();
		$("#add").show();
		$("#qualit-form input[type=reset]").trigger("click");//触发reset按钮 } 
	});
 	var table;
	layui.use('table', function() {
		table = layui.table;
		//工具条
		//方法级渲染
			table.render({
				elem : '#idTest',
				url : 'ErpQualityAction/selectByPrimaryNew.action',
				method : 'POST',
				where: { //设定异步数据接口的额外参数，任意设
					'typePri': 1
					//'pricer':1
				},
				cols : [ [ /* {
					//checkbox : true,
					//fixed : true
				},  */{
					field : 'quaSreial',
					title : '质检编号',
					width : 180,
					align : 'center'
				}, {
					field : 'quaIsva',
					title : '质检状态',
					width : 110,
					sort : true,
					align : 'center',
					templet: '#IvsaName'
				},{
					field : 'creater',
					title : '创建人',
					width : 100,
					align : 'center'
				}
				,{
					field : 'quaQc',
					title : '质检人',
					width : 100,
					align : 'center'
				}
				,{
					field : 'quaBab',
					title : '不良品',
					width : 100,
					align : 'center'
				}
				
				,{
					field : 'createtime',
					title : '创建时间',
					width : 180,
					align : 'center'
				}
				,{
					field : 'remark',
					title : '备注',
					width : 300,
					align : 'center'
				}
				,{
					toolbar: '#barDemo',
					title : '操作',
					width : 100,
					//align : 'center',
					sort: true, 
					fixed: 'right'
				}
				
				] ],
				id : 'purcId',
				page : true,
				height : 315
				
			});
			 //监听工具条
			table.on('tool(demo)', function(obj){
			     var data = obj.data;//得到当前行的数据
				 if(obj.event === 'edit'){//判断点击的是那个按钮
					   var da = {"purcId":data.purcId};
					   $.post("Purchase/selectByPrimaryKey.action",da,function(bri){
						 $("#qualityId").val(data.quaId);
						   table.render({
								elem : '#proTab',
								data: bri.det,
								cols : [ [ {
									field : 'rawName',
									title : '原材料',
									width : 180,
									align : 'center'
								}, {
									field : 'purcTotalNumber',
									title : '数量',
									width : 200,
									sort : true,
									align : 'center'
								}
								] ],
								width : 383
								
							});
						   var q = 0;
						   //计算采购总数
						   $.each(bri.det,function(o,b){
							  q+=b.purcTotalNumber;
							  $("#qualit-form-det").append("<div class='layui-form-item'>"+
									   " <div class='layui-inline'><label class='layui-form-label'>"+b.rawName+"</label><div class='layui-input-inline' style='width: 100px;'>"+
							       " <input name='quaGood' onkeyup='this.value=this.value.replace(/\D/g,'')' onafterpaste='this.value=this.value.replace(/\D/g,'')' autocomplete='off' class='layui-input'  type='text' value='"+b.purcTotalNumber+"' disabled>"+
							      "</div><div class='layui-form-mid'>-</div> <div class='layui-input-inline' style='width: 100px;'>"+
							       " <input name='quaBab' onkeyup='this.value=this.value.replace(/\D/g,'')' onafterpaste='this.value=this.value.replace(/\D/g,'') ' autocomplete='off' class='layui-input' onblur='babv(this)' type='text'>"+
							      "</div></div></div>");
						   });
						   var a = bri.remark;
						   if(a==null){//备注为空就等于“”
							   a="";
						   }
						  
						   //采购详情
						   $("#purSkin").html("<tr><td>采购单号:</td>"
									+"<td>"+bri.purcSerial+"</td><td>采购标题:</td><td>"+bri.purcTitle+"</td></tr><tr><td>采购人:</td><td>"+bri.purcName+"</td><td>采购总价:</td> <td>"+bri.purcTotalPrice+"</td> </tr><tr>"
									+"<td>创建时间:</td><td>"+bri.createtime+"</td><td>完成时间:</td>"
									+"<td>"+bri.purcTime+"</td></tr><tr><td>采购总数:</td><td id='qNum'>"+q+"</td><td>备注:</td><td>"+a+"</td></tr>"
								);
					   });
					   layer.open({
					  		  type: 1,
					  		  title: ['审批'],
					  		  content: $('#from-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
					  		 // btn: ['确定'], //可以无限个按钮
					  		  area: ['80%','90%'],
					  		  cancel:function(){
					  		  }
					  		  
					    });
				  }
			}); 
	});
</script>
<!-- 设置工具栏 -->

<script type="text/html" id="IvsaName">
	{{#  if(d.quaIsva === 1){ }}
     	 <span class="layui-badge layui-bg-gray">等待</span>
	{{#  } }} 
	{{#   if(d.quaIsva === 2){ }}
    	 <span class="layui-badge layui-bg-green">通过</span>
	{{#  } }} 
	{{#   if(d.quaIsva === 3){ }}
		 <span class="layui-badge">打回</span>
	{{#  } }} 
	
	          
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="edit" >审批</a>
</script>
</body>
</html>