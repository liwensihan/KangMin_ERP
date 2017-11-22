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
		<table class="layui-table">
		  <tbody>
		    <tr>
		      <td>采购单号:</td>
		      <td></td>
		      <td>采购标题:</td>
		      <td></td>
		    </tr>
		    <tr>
		      <td>采购人:</td>
		      <td></td>
		      <td>采购总价:</td>
		      <td></td>
		    </tr>
		    <tr>
		      <td>采购创建时间:</td>
		      <td></td>
		      <td>采购完成时间:</td>
		      <td></td>
		    </tr>
		    <tr>
		      <td>备注:</td>
		      <td colspan="3"></td>
		    </tr>
		  </tbody>
		</table>
		<table class="layui-table"  lay-skin="nob" id="proTab">
		  
		</table>
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
						   
						   table.render({
								elem : '#proTab',
								data: bri.det,
								method : 'POST',
								where: { //设定异步数据接口的额外参数，任意设
									'typePri': 1
									//'pricer':1
								},
								cols : [ [ /* {
									//checkbox : true,
									//fixed : true
								},  */{
									field : 'rawName',
									title : '原材料',
									width : 180,
									align : 'center'
								}, {
									field : 'purcTotalNumber',
									title : '数量',
									width : 110,
									sort : true,
									align : 'center'
								}
								] ]
								//id : 'purcId',
								//page : true,
								//height : 315
								
							});
					   });
					   layer.open({
					  		  type: 1,
					  		  title: ['查看'],
					  		  content: $('#from-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
					  		  btn: ['确定'], //可以无限个按钮
					  		  area: ['70%','80%'],
					  		  cancel:function(){
					  			 // qiongkong();//清空表单
					  		  },
					  		  btn1:function(index, layero){
					  			
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
  <a class="layui-btn layui-btn-mini" lay-event="edit" >查看详情</a>
</script>
</body>
</html>