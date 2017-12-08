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
		<title>生产审核</title>
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
<table class="layui-table" lay-data="{url:'dent/showPro.action', page:true, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'indentId', width:80, sort: true, fixed: true, align:'center'},hidden:'true'"></th>
      <th lay-data="{field:'indentNumber', width:200, sort: true, fixed: true, align:'center'}">编号</th>
      <th lay-data="{field:'indentCount' ,width:100}">数量</th>
      <th lay-data="{field:'indentEmetime' ,width:200, sort: true}">开始时间</th>
      <th lay-data="{field:'indentEndtime' ,width:200, sort: true}">完成时间</th>
      <th lay-data="{fixed: 'right',width:150, align:'center', toolbar: '#barDemo'}">操作</th>
    </tr>
  </thead>
</table>
<<<<<<< HEAD
	<div id="from-div" style="display: none; margin: 2%;">
		<table class="layui-table"  lay-skin="nob" >
		  <tbody id="purSkin">
		    
		  </tbody>
		</table>
		<table class="layui-table"  lay-skin="nob" id="proTab">
		  
		</table>   
		<table class="layui-table">
		  <thead>
		    <tr>
		      <th>药品名</th>
		      <th>生产总数量</th>
		      <th>完成数量</th>
		      <th>备注</th>
		    </tr> 
		  </thead>
		  <tbody>
		    <tr>
		      <td>贤心</td>
		      <td>2016-11-29</td>
		      <td>人生就像是一场修行</td>
		      <td>人生就像是一场修行</td>
		    </tr>
=======
	<div id="from-div" style="display: none; margin: 2%;">
		<table class="layui-table"  lay-skin="nob" >
		  <tbody id="purSkin">
		    
>>>>>>> branch 'master' of https://gitee.com/cs_ouyang/KangMin_ERP.git
		  </tbody>
		</table>
<<<<<<< HEAD
=======
		<table class="layui-table"  lay-skin="nob" id="proTab">
		  
		</table>
>>>>>>> branch 'master' of https://gitee.com/cs_ouyang/KangMin_ERP.git
		
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
<<<<<<< HEAD
<script>
	layui.use('table', function(){
 	 var table = layui.table;
	//监听表格复选框选择
 	 table.on('checkbox(demo)', function(obj){
   		 console.log(obj)
 	 });
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;//得到当前行的数据
    if(obj.event === 'edit'){
    	layer.open({
    		  type: 1,
    		  title: ['编辑', '<i class="layui-icon" style="color: #5FB878;">&#xe642;</i>'],
    		  content: $('#from-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
    		 // btn: ['提交', '取消'],	
    		  area: ['80%', '75%'],
    		  btn1:function(index, layero){
    			 
    		  },
    		  btn2:function(index, layero){
    			  $("#chong").click();
    		  },
    		  cancel:function(){
    			  $("#chong").click();//清空表单
    		  }
    	});
    	var da = {"indentId":data.indentId}
    	 $.post("dent/selectByPrimaryProid.action",da,function(dent){
    		 	var den = dent[0];
			 	$("#proTab").val("<tbody> <tr> <td width='100px'>订单编号:</td> <td colspan='5'>"+den.KIN_SERIAL+"</td></tr>"+
					    "<tr> <td  width='100px'> 创建时间:</td> <td>1234567</td><td  width='100px'>结束时间:</td>"+
					      "<td colspan='3'>1234567</td></tr><tr><td  width='100px'>订单总数量:</td><td>123456</td>"+
					      " <td  width='100px'>订单总价格:</td><td>123456</td><td  width='100px'>订单创建人:</td>"+
					      "<td>1234</td></tr><tr><td  width='100px'>订单备注:</td><td colspan='5'>1234567890</td></tr> </tbody>");
		  });
    }
  });
});
function addtype(){
	layui.use('table', function(){
		  var table = layui.table;
		  layer.open({
			  type: 1,
			  title: ['添加', '<i class="layui-icon" style="color: #5FB878;">&#xe63c;</i>'],
			  content: $('#from-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
			  btn: ['提交', '取消'],
			  btn1:function(index, layero){
				    //按钮【按钮1】的回调
				  var data =$("#type-from").serialize();//表单序列化 
				  $.post("ErpResuitAction/insertSelective.action",data,function(mes){
					 	if(mes.state==1){//真确的样式
					 		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #5FB878;">&#xe618;</i>'+mes.mes);
					 	}else{
					 		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
					 	}
					 	layer.close(index);
					 	$("#chong").click();
				  });
				  ajxaTable();//刷新表格
			  },
			  btn2:function(index, layero){
				  $("#chong").click();
			  },
    		  cancel:function(){
    			  $("#chong").click();//清空表单
    		  }
			  
		});
=======
<script>
>>>>>>> branch 'master' of https://gitee.com/cs_ouyang/KangMin_ERP.git
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
	
}
//刷新表单
function ajxaTable(){
	layui.use('table', function(){ //layui表格操作的基本方法
		  var table = layui.table;
		  table.reload('idTest', {//表格的id
			  url: 'ErpResuitAction/findErpResuitsow.action'//url
			  ,where: {//表格的字段
				  resId:"resId",
				  resSerial:"resSerial",
				  resName:"resName",
				  remark:"remark"
			  }
		  	
		});
	});
}
function solo(){
	var pricer = $("#price").val();
	layui.use('table', function(){ //layui表格操作的基本方法s
		  var table = layui.table;
		  table.reload('idTest', {//表格的id
			  url: 'ErpResuitAction/findDimRew.action'
			  ,where: {//表格的字段
				  resId:"resId",
				  resSerial:"resSerial",
				  resName:"resName",
				  remark:"remark",
				  price:pricer
			  }
		  	, method: 'post'
		});
	});
}

</script>
<!-- 设置工具栏 -->
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="edit" >审批</a>
</script>
</body>
</html>