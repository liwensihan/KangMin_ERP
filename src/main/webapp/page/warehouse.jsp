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
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=basePath%>res/layui/css/layui.css"
	media="all">
<script src="<%=basePath%>res/js/jquery-2.1.3.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>res/layui/layui.js" charset="utf-8"></script>

<title>仓库表</title>
</head>
<body>
	<div class="layui-tab">
	  <ul class="layui-tab-title">
	    <li class="layui-this">药品仓库</li>
	    <li>原材料仓库</li>
	  </ul>
	  <div class="layui-tab-content" style="height: 100px;">
	    <div class="layui-tab-item layui-show">
		    <div class="demoTable">
				<div class="layui-inline">
					<input class="layui-input" name="prie" id="prie"
						autocomplete="off">
				</div>
				<button class="layui-btn" data-type="reload" onclick="priesol()">搜索</button>
				
			</div>
			
			<table class="layui-hide" id="LAY_table_user" lay-filter="kindswar">
		
		
			</table>
	    </div>
	    <div class="layui-tab-item">
	    	<div class="layui-inline">
			<input class="layui-input" name="priea" id="priea"
				autocomplete="off">
			</div>
			<button class="layui-btn" data-type="reload" onclick="rawsousuo()">搜索</button>
		    <table class="layui-hide"  lay-filter="rawdswar" id="LAY_table_raw">
				
			</table>
	    	
	    </div>
	    
	  </div>
	</div> 
	<div id="xq-div" style="display: none; margin: 2%;">
		<table class="layui-table"  lay-skin="nob" >
		  <tbody id="xq-purSkin">
		  </tbody>
		</table>
		<div class="layui-elem-quote">
		  <p>库存记录</p>
		</div>
		<div id="xq-div-sjx">
		
		</div>
	</div>
	<script>
	layui.use('element', function(){
		  var $ = layui.jquery
		  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
		  
		  //触发事件
		  var active = {
		   tabChange: function(){
		      //切换到指定Tab项
		      element.tabChange('demo', '22'); //切换到：用户管理
		    }
		  };
		  
		  
		});
		var table;

		layui.use('table', function() {
			table = layui.table;
			//工具条
			//监听工具条
			  table.on('tool(kindswar)', function(obj){
			    var data = obj.data;//得到当前行的数据
			   if(obj.event === 'buredit'){//判断点击的是那个按钮
				   var da = {"wareId":data.wareId};
				   $.post("Warehouse/selectNewKey.action",da,function(bri){
					   var a = bri.remark;
					   if(a==null){//备注为空就等于“”
						   a="";
					   }
					   $("#xq-purSkin").html("<tr><td>商品:</td>"
								+"<td>"+data.kinName+"</td><td>库存总数:</td><td>"+data.wareNum+"</td></tr><tr><td>创建时间:</td><td>"+data.createtime+"</td>"
								
								+"</tr><tr><td>备注:</td><td>"+a+"</td></tr>"
						);
					   $.each(bri.det,function(i,b){
						   var a ="";
						   if(b.bankId!=null){
							   a="入库";
						   }else{
							   a="出库";
						   }
						   $("#xq-div-sjx").append("<ul class='layui-timeline'>"+
					  	      		 " <li class='layui-timeline-item'>"+
					  	      "<i class='layui-icon layui-timeline-axis'>&#xe63f;</i>"+
					  	      "<div class='layui-timeline-content layui-text'>"+
					  	        "<h3 class='layui-timeline-title'>"+b.cre+"</h3>"+
					  	        "<span>入库人:"+b.staName+"<br>入库数量:"+b.invedetNum+"<br>操作:<span class='layui-badge layui-bg-blue'>"+a+"</span> "+
					  	        " </span></div></li> </ul>");
					   });
					   layer.open({
					  		  type: 1,
					  		  title: ['详情'],
					  		  content: $('#xq-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
					  		 // btn: ['确定'], //可以无限个按钮
					  		  area: ['80%','90%'],
					  		  cancel:function(){
					  			$("#xq-div-sjx").html("");
					  		  }
						 
					    });
			  	      	
				   });
			    }
			  });
			  table.on('tool(rawdswar)', function(obj){
				    var data = obj.data;//得到当前行的数据
				   if(obj.event === 'buredit'){//判断点击的是那个按钮
					   var da = {"wareId":data.wareId};
					   $.post("Warehouse/selectNewKey.action",da,function(bri){
						   var a = bri.remark;
						   if(a==null){//备注为空就等于“”
							   a="";
						   }
						   $("#xq-purSkin").html("<tr><td>原材料:</td>"
									+"<td>"+data.rawName+"</td><td>库存总数:</td><td>"+data.wareNum+"</td></tr><tr><td>创建时间:</td><td>"+data.createtime+"</td>"
									
									+"</tr><tr><td>备注:</td><td>"+a+"</td></tr>"
							);
						   $.each(bri.det,function(i,b){
							   var a ="";
							   if(b.bankId!=null){
								   a="入库";
							   }else{
								   a="出库";
							   }
							   $("#xq-div-sjx").append("<ul class='layui-timeline'>"+
						  	      		 " <li class='layui-timeline-item'>"+
						  	      "<i class='layui-icon layui-timeline-axis'>&#xe63f;</i>"+
						  	      "<div class='layui-timeline-content layui-text'>"+
						  	        "<h3 class='layui-timeline-title'>"+b.cre+"</h3>"+
						  	        "<span>入库人:"+b.staName+"<br>入库数量:"+b.invedetNum+"<br>操作:<span class='layui-badge layui-bg-blue'>"+a+"</span> "+
						  	        " </span></div></li> </ul>");
						   });
						   layer.open({
						  		  type: 1,
						  		  title: ['详情'],
						  		  content: $('#xq-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
						  		 // btn: ['确定'], //可以无限个按钮
						  		  area: ['80%','90%'],
						  		  cancel:function(){
						  			$("#xq-div-sjx").html("");
						  		  }
							 
						    });
				  	      	
					   });
				    }
				  });
			//方法级渲染
			table.render({
				elem : '#LAY_table_user',
				url : 'Warehouse/showListKin.action',
				method : 'POST',
				cols : [ [ {
					field : 'kinName',
					title : '药品名',
					width : 180,
					align : 'center'
				}, {
					field : 'wareNum',
					title : '库存量',
					width : 100,
					sort : true,
					align : 'center'
				}
				,{
					field : 'kinPrice',
					title : '单价',
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
					width : 180,
					align : 'center'
				}
				,{
					toolbar: '#barDemo',
					title : '操作',
					width : 120,
					//align : 'center',
					sort: true, 
					fixed: 'right'
				}
				
				] ],
				id:"kindswa",
				page : true
				
			});
			//方法级渲染
			table.render({
				elem : '#LAY_table_raw',
				url : 'Warehouse/selectAllRaw.action',
				method : 'POST',
				cols : [ [ {
					field : 'rawName',
					title : '原材料名',
					width : 100,
					align : 'center'
				}, {
					field : 'wareNum',
					title : '库存量',
					width : 100,
					sort : true,
					align : 'center'
				}
				,{
					field : 'rawPrice',
					title : '单价',
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
					width : 180,
					align : 'center'
				}
				,{
					toolbar: '#rawDemo',
					title : '操作',
					width : 120,
					align : 'center',
					sort: true, 
					fixed: 'right'
				}
				
				] ],
				id:"rawdswa",
				page : true
				
			});
			
		});
		function rawsousuo(){
			table.reload('rawdswa', {
  		 		where: { //设定异步数据接口的额外参数，任意设
  	  				'priea':$("#priea").val()
     			}
			});
		}
		function priesol(){
			table.reload('kindswa', {
  		 		where: { //设定异步数据接口的额外参数，任意设
  	  				'prie':$("#prie").val()
     			}
			}); 
		}
	</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="buredit" >查看详情</a>
</script>
<script type="text/html" id="rawDemo">
  <a class="layui-btn layui-btn-mini" lay-event="buredit" >查看详情</a>
</script>
</body>
</html>