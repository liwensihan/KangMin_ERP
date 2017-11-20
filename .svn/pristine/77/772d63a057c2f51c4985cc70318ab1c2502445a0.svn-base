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
		<title>药品管理</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<link rel="stylesheet" href="res/css/amazeui.min.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<script src="res/js/amazeui.min.js" type="text/javascript" ></script>
		<style type="text/css">
			body{
				margin: 2%;
			}
			.am-selected {
			    width:90%;
			}
		</style>
</head>
<body>
<div class="demoTable">
  <div class="layui-inline" style="margin-left:40%;">
    <input class="layui-input" name="price" id="price" placeholder="编号/名字/备注" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" onclick="ajxaTable()">搜索</button>
   <a class="layui-btn" lay-event="edit" onclick="addtype()">增加</a>
</div>
<table class="layui-table" lay-data="{url:'ErpKindsAction/findListKind.action', page:true, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'kinId', width:80, sort: true, fixed: true, align:'center'},hidden:'true'"></th>
      <th lay-data="{field:'kinSerial',width:200, sort: true}">编号</th>
      <th lay-data="{field:'kinName' ,width:100}">药品名</th>
       <th lay-data="{field:'typer' ,width:100,templet: '#TypeName'}">类型</th>
      <th lay-data="{field:'resName' ,width:200}">药效</th>
      <th lay-data="{field:'kinBarcode' ,width:150}">条形码号</th>
      <th lay-data="{field:'kinContent' ,width:100}">净含量/g</th>
      <th lay-data="{field:'kinExpiration' ,width:100}">保质期</th>
      <th lay-data="{field:'kinPrice' ,width:100}">本金/元</th>
      <th lay-data="{field:'kinStost' ,width:150, sort: true}">出售价/元</th>
       <th lay-data="{field:'kinSellinf' ,width:150, sort: true}">批发价/元</th>
      <th lay-data="{field:'remark' ,width:150, sort: true}">备注</th>
      <th lay-data="{fixed: 'right',width:150, align:'center', toolbar: '#barDemo'}">操作</th>
    </tr>
  </thead>
</table>
	<div id="from-div" style="display: none; margin: 2%;">
		<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
		  <ul class="layui-tab-title">
		    <li class="layui-this">药品添加</li>
		    <li id="tab-2">药效添加</li>
		    <li id="tab-3">配方添加</li>
		    <li id="tab-4">图片添加</li>
		  </ul>
		  <div class="layui-tab-content" style="height: 100px;">
		    <div class="layui-tab-item layui-show">
		    	<form class="layui-form layui-form-pane" id="kind-from">
		    		<div class="layui-inline">
					    <label class="layui-form-label">药品名</label>
						    <div class="layui-input-inline">
						      <input name="kinName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" type="text" id="kinName">
						    </div>
				  	</div>
				  	<div class="layui-inline" style="width:27%;">
					    <label class="layui-form-label">类型</label>
					    <div class="layui-input-block">
					      <select name="typeId" lay-filter="aihao" id="typeSele" lay-search>
					        
					      </select>
					    </div>
				  </div>
				  <div class="layui-inline">
				      <label class="layui-form-label">条形码号</label>
				       <div class="layui-input-inline">
				        <input name="kinBarcode" placeholder="请输入" autocomplete="off" class="layui-input" type="text" id="kinBarcode">
				      </div>
				    </div>  
				  	<div class="layui-inline" >
				      <label class="layui-form-label">净含量</label>
				      <div class="layui-input-inline" style="width: 100px;">
				        <input name="kinContent" placeholder="/g" autocomplete="off" class="layui-input" type="text" id="kinContent">
				      </div>
				    </div>
				    <div class="layui-inline">
				      <label class="layui-form-label">保质期</label>
				      <div class="layui-input-inline" style="width: 100px;">
				        <input name="kinExpiration" placeholder="自行输入/年月日" autocomplete="off" class="layui-input" type="text" id="kinExpiration">
				      </div>
				    </div>
				    <div class="layui-inline">
				      <label class="layui-form-label">成本价</label>
				      <div class="layui-input-inline" style="width: 134px;">
				        <input name="kinPrice" placeholder="￥" autocomplete="off" class="layui-input" type="text" id="kinPrice">
				      </div>
				    </div>
				    <div class="layui-inline">
				      <label class="layui-form-label">出售价</label>
				      <div class="layui-input-inline" style="width: 134px;">
				        <input name="kinStost" placeholder="￥" autocomplete="off" class="layui-input" type="text" id="kinStost">
				      </div>
				    </div>
				     <div class="layui-inline">
				      <label class="layui-form-label">批发价</label>
				      <div class="layui-input-inline" style="width: 134px;">
				        <input name="kinSellinf" placeholder="请输入" autocomplete="off" class="layui-input" type="text" id="kinSellinf">
				      </div>
				    </div>
				    
				   
				  	 <div class="layui-form-item layui-form-text" style="margin-top: 1.5%;">
					    <label class="layui-form-label">介绍</label>
					    <div class="layui-input-block">
					      <textarea name="remark" placeholder="请输入内容" class="layui-textarea" id="remark"></textarea>
					    </div>
					  </div>
					  <input type="hidden" id="kinId" name="kinId">
					  <input type="reset" style="display:none;" /> 
		    	</form>
		    	<button class="layui-btn" id="addkind-btu" data-type="reload" style="margin-left: 2%;" onclick="addKind()">完成</button>
		    	</div>
		    	 <div class="layui-tab-item" >
		    	 		<div class="am-form-group">
		    	 		<form id="res-from"  style="float: left; width: 89%;">
		    	 			<input type="hidden" id="kindsId" name="kinId">
					    	<select multiple data-am-selected="{searchBox: 1}" name="resId" placeholder="药效" id="resId" required >
								 
							</select>
							<input type="reset" style="display:none;" /> 
						</form>
				    	</div>
				    	<div>
				    		<button class="layui-btn" style="margin-left: 2%;" onclick="addRes()">添加</button>
				    	</div>
						<table class="layui-table" lay-data="{id:'idTestRes'}" lay-filter="resdemo">
						  <thead>
						    <tr>
						      <th lay-data="{field:'resId', width:80}">id</th>
						      <th lay-data="{field:'resSerial',width:200, sort: true}">编号</th>
						      <th lay-data="{field:'resName' ,width:100}">名字</th>
						      <th lay-data="{field:'remark' ,width:150, sort: true}">备注</th>
						      <th lay-data="{fixed: 'right',width:150, align:'center', toolbar: '#resDemo'}">操作</th>
						    </tr>
						  </thead>
						</table>
					 </div>
			    <div class="layui-tab-item">
			    		<form class="layui-form layui-form-pane" id="Burd-from" style="width: 91%;float: left;">
			    			<input type="hidden" id="kinsId" name="kinId">
		    				<div class="layui-inline" style="width: 65%;">
							    <label class="layui-form-label">原材料</label>
							    <div class="layui-input-block">
							      <select name="rawId" lay-filter="aihao" id="rawIda" lay-search>
							        
							      </select>
							    </div>
							  </div>          
						  	<div class="layui-inline">
						      <label class="layui-form-label">用量</label>
						      <div class="layui-input-inline" style="width: 100px;">
						        <input name="burG" placeholder="/g" autocomplete="off" class="layui-input" type="text">
						      </div>
						    </div>
						    <input type="reset" style="display:none;" /> 
		    			</form>
			    		 <button class="layui-btn" data-type="reload" onclick="burdAdd()">添加</button>
					   <table class="layui-table" lay-data="{id:'idTestBurd'}" lay-filter="Burdemo">
						  <thead>
						    <tr>
						      <th lay-data="{field:'burId', width:80}">id</th>
						      <th lay-data="{field:'burSerial',width:200, sort: true}">编号</th>
						      <th lay-data="{field:'rawName' ,width:100}">药品名</th>
						      <th lay-data="{field:'burG' ,width:100}">用量</th>
						       <th lay-data="{fixed: 'right',width:150, align:'center', toolbar: '#BurDemo'}">操作</th>
						    </tr>
						  </thead>
						</table>
		    	</div>
			    <div class="layui-tab-item">
			    	<div class="layui-upload">
						<input type="hidden" value="" id="kindImg"/>
					  <button type="button" class="layui-btn" id="testList">添加图片</button> 
					   <button type="button" class="layui-btn" id="testListAction">开始上传</button>
					  <div class="layui-upload-list">
					    <table class="layui-table">
					      <thead>
					        <tr><th>文件名</th>
					        <th>大小</th>
					        <th>状态</th>
					        <th>操作</th>
					      </tr></thead>
					      <tbody id="demoList"></tbody>
					      
					    </table>
					  </div>
					</div> 
			    </div>
		    
		    </div>
		</div>
	</div>
	<div id="burdenUpdate" style="display:none;">
		<form class="layui-form layui-form-pane" id="burdenUpdate-from" style="width: 93%;float: left; margin-left: 7%;margin-top: 2%;">
   			<input type="hidden" id="burId" name="burId">      
		  	<div class="layui-inline">
		      <label class="layui-form-label">用量</label>
		      <div class="layui-input-inline">
		        <input name="burG" placeholder="/g" autocomplete="off" id="burqg" class="layui-input" type="text">
		      </div>
		    </div>
  		</form>
	</div>
<script type="text/html" id="TypeName">
  {{#  if(d.typer.typeName === null){ }}
  <span class="layui-badge-rim">未知类型</span>
  {{#  } else { }}
    	<span class="layui-badge layui-bg-green">{{d.typer.typeName}}</span>
  {{#  } }}
 
</script>
<script>
	$.ajaxSetup({
	  async:false
	});
	 
	//下拉框赋值的方法
	function selectKint(){
		//多选下拉框赋值方法
		$.post("ErpResuitAction/findErpResuit.action",function(res){
			$.each(res ,function(index,obj){
				$('#resId').append('<option value="' + obj.resId +'">' + obj.resName + '</option>');
			});
		});
		var form;
		layui.use('form', function(){
			  form = layui.form;
			//原材料
				$.post("ErpRawAction/showListRaw.action",function(raw){
					$.each(raw.data,function(index,obj){
						$('#rawIda').append('<option value="' + obj.rawId +'">' + obj.rawName + '</option>');
					});
					form.render('select');
				});
			//类型
				$.post("ErpKindsType/showListTypetuo.action",function(type){
					$.each(type ,function(index,obj){
						$('#typeSele').append('<option value="' + obj.typeId +'">' + obj.typeName + '</option>');
					});
					form.render('select');
				});
		});
	}
	layui.use('element', function(){
	  var $ = layui.jquery
	  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
	  
	  //触发事件
	  var active = {
	    tabAdd: function(){
	      //新增一个Tab项
	      element.tabAdd('demo', {
	        title: '新选项'+ (Math.random()*1000|0) //用于演示
	        ,content: '内容'+ (Math.random()*1000|0)
	        ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
	      })
	    }
	    ,tabChange: function(){
	      //切换到指定Tab项
	      element.tabChange('demo', '22'); //切换到：用户管理
	    }
	  };
	  
	  
	});
	layui.use('table', function(){
 	 var table = layui.table;
	//监听表格复选框选择
 	 table.on('checkbox(demo)', function(obj){
   		 console.log(obj)
 	 });
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;//得到当前行的数据
   if(obj.event === 'del'){//判断点击的是那个按钮
	   layer.confirm('确定要删除吗？', {icon: 3, title:'提示'}, function(index){//弹出框
        var da = {"kinId":data.kinId}//把得到的id放进json
        $.post("ErpKindsAction/deleteKind.action",da,function(mes){
        	if(mes.state==1){//真确的样式
         		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #5FB878;">&#xe618;</i>'+mes.mes);
         	}else{
         		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
         	}
        	 ajxaTable();//刷新表格
        });
      });
    } else if(obj.event === 'edit'){//药品的编辑
    	//放入对象数据
    	$("#kinName").val(data.kinName);
    	//$("#typeSele").val(data.typeSele);
    	$("#kinBarcode").val(data.kinBarcode);
    	$("#kinContent").val(data.kinContent);
    	$("#kinPrice").val(data.kinPrice);
    	$("#kinStost").val(data.kinStost);
    	$("#kinExpiration").val(data.kinExpiration);
    	$("#remark").val(data.remark);
    	$("#kinId").val(data.kinId);
    	$("#kindsId").val(data.kinId);
		$("#kinsId").val(data.kinId);
		$("#kindImg").val(data.kinId);
		$("#kinSellinf").val(data.kinSellinf);
		resSolo();//查询原材料
		burdSolo();//查询配方
		selectKint();//下拉框赋值
		var form;
		layui.use('form', function(){
			  form = layui.form;
			  $("#typeSele option").each(function(){
		            if($(this).val() == data.typer.typeId) {//等于选中的id就选中
		                $(this).attr("selected",true)
		            }else{
		                    $(this).attr("selected",false)
		            }
		      });
			  form.render();//重新渲染样式
		});
		//打开编辑弹出层
    	layer.open({
    		  type: 1,
    		  title: ['编辑', '<i class="layui-icon" style="color: #5FB878;">&#xe642;</i>'],
    		  content: $('#from-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
    		  area: ['75%','70%'],
    		  cancel:function(){
    			  qiongkong();//清空表单
    			  ajxaTable();//刷新表格
    		  }
    	});
    	
    }
  });
});
//打开添加的面
function addtype(){
	layui.use('table', function(){
		  var table = layui.table;
		  layer.open({
			  type: 1,
			  title: ['添加', '<i class="layui-icon" style="color: #5FB878;">&#xe63c;</i>'],
			  content: $('#from-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
			  area: ['75%','70%'],
    		  cancel:function(){
    			  qiongkong();//清空表单
    			  ajxaTable();//刷新表格
    		  }
		});
	});
	
	selectKint();//下拉框赋值
}

//下拉框赋值的方法
function selectKint(){
	//多选下拉框赋值方法
	$.post("ErpResuitAction/findErpResuit.action",function(res){
		$.each(res ,function(index,obj){
			$('#resId').append('<option value="' + obj.resId +'">' + obj.resName + '</option>');
		});
	});
	 var form;
	layui.use('form', function(){
		  form = layui.form;
		//原材料
			$.post("ErpRawAction/showListRaw.action",function(raw){
				$.each(raw.data,function(index,obj){
					$('#rawIda').append('<option value="' + obj.rawId +'">' + obj.rawName + '</option>');
				});
				form.render('select');
			});
		//类型
			$.post("ErpKindsType/showListTypetuo.action",function(type){
				$.each(type ,function(index,obj){
					$('#typeSele').append('<option value="' + obj.typeId +'">' + obj.typeName + '</option>');
				});
				form.render('select');
			});
	});
}
//药品的添加和修改
function addKind(){
	   //按钮【按钮1】的回调
	  var data =$("#kind-from").serialize();//表单序列化 
	  var array = data.split('&');
		 if(array.length>7){//判断是否填入了对应的值
			 var i =$("#kinId").val();
			 if(i==""){
				 $.post("ErpKindsAction/insertSelectiveKind.action",data,function(mes){
					 	if(mes.state==1){//真确的样式
					 		$("input[type=reset]").trigger("click");//触发reset按钮  
							 //提示跳转层
							 layer.confirm('添加成功,继续添加药效吗?', function(index){
							  //do something
							  $("#tab-2").click();
							  layer.close(index);
							 });
					 		 $.post("ErpKindsAction/selectId.action",data,function(id){
					 		 	$("#kindsId").val(id);
					 		 	$("#kinsId").val(id);
					 		 	$("#kindImg").val(id);
					 	 	 });
				 		}else{
				 			layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
				 		}
					});
			 	}else{
			 		$.post("ErpKindsAction/updateKind.action",data,function(mes){
					 	if(mes.state==1){//真确的样式
					 		//$("input[type=reset]").trigger("click");//触发reset按钮 } 
							 //提示跳转层
							 layer.confirm('修改成功,继续修改药效吗?', function(index){
							  //do something
							  $("#tab-2").click();
							  layer.close(index);
							 });
				 		}else{
				 			layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
				 		}
					});
			 	}	
			//上传图片
		 		layui.use('upload', function(){
		 			  var $ = layui.jquery
		 			  var id = $("#kindImg").val();
		 			  if(id!=null){
		 				  upload = layui.upload;
		 				  //多文件列表示例
		 				  var demoListView = $('#demoList')
		 				  ,uploadListIns = upload.render({
		 				    elem: '#testList'
		 				    ,url: 'ErpImgAction/insertSelectiveKin.action'
		 				    ,data: {"kinId":id}
		 				    ,accept: 'file'
		 				    ,multiple: true
		 				    ,auto: false
		 				    ,bindAction: '#testListAction'
		 				    ,choose: function(obj){   
		 				      var files = obj.pushFile(); //将每次选择的文件追加到文件队列
		 				      //读取本地文件
		 				      obj.preview(function(index, file, result){
		 				        var tr = $(['<tr id="upload-'+ index +'">'
		 				          ,'<td><img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img" width="50px;"></td>'
		 				          ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
		 				          ,'<td>等待上传</td>'
		 				          ,'<td>'
		 				            ,'<button class="layui-btn layui-btn-mini demo-reload layui-hide">重传</button>'
		 				            ,'<button class="layui-btn layui-btn-mini layui-btn-danger demo-delete">删除</button>'
		 				          ,'</td>'
		 				        ,'</tr>'].join(''));
		 				        
		 				        //单个重传
		 				        tr.find('.demo-reload').on('click', function(){
		 				          obj.upload(index, file);
		 				        });
		 				        
		 				        //删除
		 				        tr.find('.demo-delete').on('click', function(){
		 				          delete files[index]; //删除对应的文件
		 				          tr.remove();
		 				        });
		 				        
		 				        demoListView.append(tr);
		 				      });
		 				    }
		 				    ,done: function(res, index, upload){
		 				      if(res.state == 1){ //上传成功
		 				        var tr = demoListView.find('tr#upload-'+ index)
		 				        ,tds = tr.children();
		 				        tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
		 				        tds.eq(3).html(''); //清空操作
		 				        delete files[index]; //删除文件队列已经上传成功的文件
		 				        return;
		 				      }else{
		 				    	  this.error(index, upload);
		 				      }
		 				    }
		 				    ,error: function(index, upload){
		 				    	 var tr = demoListView.find('tr#upload-'+ index)
		 		 			      ,tds = tr.children();
		 		 			      tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
		 		 			      tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
		 				    }
		 				  });
		 
				 	}else{
				 		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>上传失败,上传对象不明');
				 	}
				  });
			 //$("#addkind-btu").addClass("layui-btn-disabled");//禁用提交按钮效果
		 }else{
			 layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>请填入正确的值');
		 }
		
	}
//添加药效

function addRes(){
	var data =$("#res-from").serialize();//表单序列化 
	 $.post("ErpDrugResultAction/insertSelective.action",data,function(mes){
		 	if(mes.state==1){//真确的样式
		 		$("input[type=reset]").trigger("click");//触发reset按钮 } 
				 //提示跳转层
				 layer.confirm('添加成功,继续添加配方吗?', function(index){
				  //do something
				  $("#tab-3").click();
				  layer.close(index);
				 });
		 	}else{
		 		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
		 	}
		 	resSolo();
	  });
	
	
}

//刷新药品
//药品的模糊查询
function ajxaTable(){
	var pricer = $("#price").val();
	layui.use('table', function(){ //layui表格操作的基本方法s
		  var table = layui.table;
		  table.reload('idTest', {//表格的id
			  url: 'ErpKindsAction/findListKind.action'
			  ,where: {//表格的字段
				  kinId:"kinId",
				  kinSerial:"kinSerial",
				  kinName:"kinName",
				  kinContent:"kinContent",
				  kinExpiration:"kinExpiration",
				  kinPrice:"kinPrice",
				  typer:"typer",
				  resName:"resName",
				  kinStost:"kinStost",
				  remark:"remark",
				  right:"right",
				  price:pricer
			  }
		  	, method: 'post'
		});
	});
}
/**
 * 药效搜索的方法
 */
function resSolo(){
	var pricer = $("#kindsId").val();
	layui.use('table', function(){ //layui表格操作的基本方法s
		  var table = layui.table;
		  table.reload('idTestRes', {//表格的id
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
//原材料的模糊查询
function soloRaw(){
	var pricer = $("#price").val();
	layui.use('table', function(){ //layui表格操作的基本方法s
		  var table = layui.table;
		  table.reload('idTestRaw', {//表格的id
			  url: 'ErpRawAction/findDimRew.action'
			  ,where: {//表格的字段
				  resId:"rawId",
				  rawSerial:"rawSerial",
				  rawName:"rawName",
				  typer:"typer",
				  app:"app",
				  res:"res",
				  price:pricer
			  }
		  	, method: 'post'
		});
	});
}
//配方的模糊查询
function burdSolo(){
	var pricer = $("#kinsId").val();
	layui.use('table', function(){ //layui表格操作的基本方法s
		  var table = layui.table;
		  table.reload('idTestBurd', {//表格的id
			  url: 'ErpBurdenAction/findDimBurd.action'
			  ,where: {//表格的字段
				  burId:"burId",
				  burSerial:"burSerial",
				  rawName:"rawName",
				  burG:"burG",
				  price:pricer
			  }
		  	, method: 'post'
		});
	});
}
//添加和查询配方
function burdAdd(){
	var data =$("#Burd-from").serialize();//表单序列化 
	 $.post("ErpBurdenAction/insertSelective.action",data,function(mes){
		 	if(mes.state==1){//真确的样式
		 		$("input[type=reset]").trigger("click");//触发reset按钮 } 
				 //提示跳转层
				 layer.confirm('添加成功,继续添加图片吗?', function(index){
				  //do something
				  $("#tab-4").click();
				  layer.close(index);
				 });
		 	}else{
		 		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
		 	}
		 	burdSolo();
	  });
}
//清空表单
function qiongkong(){
	$("#resId ").empty();
	$("#rawIda ").empty();
	$("#typeSele ").empty();
	$("#Burd-from input[type=reset]").trigger("click");//触发reset按钮 } 
	$("#res-from input[type=reset]").trigger("click");//触发reset按钮 } 
	$("#kind-from input[type=reset]").trigger("click");//触发reset按钮 } 
}

//药效表的工具条
layui.use('table', function(){
	var table = layui.table;
	//监听工具条药效表
	  table.on('tool(resdemo)', function(obj){
	    var data = obj.data;//得到当前行的数据
	   if(obj.event === 'resdel'){//判断点击的是那个按钮
	  	   layer.confirm('确定要删除吗？', {icon: 3, title:'提示'}, function(index){//弹出框
	  		  var kindsId = $("#kindsId").val();
	       	 var da = {"resId":data.resId,"kindsId":kindsId}//把得到的id放进json
	        	$.post("ErpDrugResultAction/deleteByPrimaryKeySelective.action",da,function(mes){
	  	      	if(mes.state==1){//真确的样式
	  	       		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #5FB878;">&#xe618;</i>'+mes.mes);
	  	       	}else{
	  	       		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
	  	       	}
	  	      	resSolo();//刷新表格
	        });
	      });
	    }
	  });
});
//配料表的工具条
layui.use('table', function(){
	var table = layui.table;
	//配料的工具条
	table.on('tool(Burdemo)', function(obj){
	    var data = obj.data;//得到当前行的数据
	   if(obj.event === 'burdel'){//判断点击的是那个按钮
	  	   layer.confirm('确定要删除吗？', {icon: 3, title:'提示'}, function(index){//弹出框
	       	 var da = {"burId":data.burId}//把得到的id放进json
	        	$.post("ErpBurdenAction/deleteByPrimaryKey.action",da,function(mes){
	  	      	if(mes.state==1){//真确的样式
	  	       		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #5FB878;">&#xe618;</i>'+mes.mes);
	  	       	}else{
	  	       		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
	  	       	}
	  	        burdSolo();//刷新表格
	        });
	      });
	    }else if(obj.event === 'buredit'){
	    	//给文本框赋值
	    	$("#burId").val(data.burId);
	    	$("#burqg").val(data.burG);
	    	layer.open({
	  		  type: 1,
	  		  title: ['编辑药效', '<i class="layui-icon" style="color: #5FB878;">&#xe642;</i>'],
	  		  content: $('#burdenUpdate'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
	  		  btn: ['确定'], //可以无限个按钮
	  		  area: ['40%'],
	  		  cancel:function(){
	  			  qiongkong();//清空表单
	  		  },
	  		  btn1:function(index, layero){
	  			var data =$("#burdenUpdate-from").serialize();//表单序列化 
	  			//回调
	  			$.post("ErpBurdenAction/updateBurden.action",data,function(mes){
		  	      	if(mes.state==1){//真确的样式
		  	       		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #5FB878;">&#xe618;</i>'+mes.mes);
		  	       	}else{
		  	       		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
		  	       	}
		  	        burdSolo();//刷新表格
		  	        layer.close(index);//关闭层
	  			});
	  		  }
	    	});
	    }
	  });

});



</script>
<!-- 设置工具栏 -->
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="edit" >编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>
<script type="text/html" id="resDemo">
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="resdel">删除</a>
</script>
<script type="text/html" id="BurDemo">
  <a class="layui-btn layui-btn-mini" lay-event="buredit" >编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="burdel">删除</a>
</script>
</body>
</html>