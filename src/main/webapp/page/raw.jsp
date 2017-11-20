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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>原材料</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<link rel="stylesheet" href="res/css/amazeui.min.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<script src="res/js/layui-mz-min.js" type="text/javascript" ></script>
		<script src="res/js/amazeui.min.js" type="text/javascript" ></script>
		
		<style type="text/css">
			body{
				margin: 2%;
			}
			.am-selected {
			    width: 100%;
			}
		
			
		</style>
</head>
<body>
<div class="demoTable">
  <div class="layui-inline" style="margin-left:40%;">
    <input class="layui-input" name="price" id="price" placeholder="编号/原材料名/供应商/药效" autocomplete="off">
  </div>
  <button class="layui-btn" data-type="reload" onclick="solo()">搜索</button>
   <a class="layui-btn" lay-event="edit" onclick="addtype()">增加</a>
</div>
<table class="layui-table" lay-data="{url:'ErpRawAction/showListRaw.action', page:true, id:'idTest'}" lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'rawId', width:80, sort: true, fixed: true, align:'center'}">序号</th>
      <th lay-data="{field:'rawSerial',width:200, sort: true}">编号</th>
      <th lay-data="{field:'rawName' ,width:100}">药品名</th>
      <th lay-data="{field:'rawPrice' ,width:100}">价格</th>
      <th lay-data="{field:'typer' ,width:150, sort: true ,templet: '#TypeName'}">类型</th>
      <th lay-data="{field:'app' ,width:150, sort: true ,templet: '#lyName'}">供货商</th>
      <th lay-data="{field:'res' ,width:150, sort: true ,templet: '#resr'}">药效</th>
      <th lay-data="{fixed: 'right',width:270, align:'center', toolbar: '#barDemo'}">操作</th>
    </tr>
  </thead>
</table>
<div id="from-div" style="display: none;">
		<form class="am-form" data-am-validator id="raw-from">
		  <fieldset>
		  	 <input type="hidden" id="rawId" name="rawId" width="200px;"/>
		    <div class="am-form-group" >
		      <input type="text" id="rawName" name="rawName" minlength="2" placeholder="材料名" />
		    </div>
		     <div class="am-form-group" >
		      <select data-am-selected="{searchBox: 1}" name="applyId" placeholder="供货商" id="applyId" required>
			  
			 </select>
			 </div>
			 <div class="am-form-group" >
		      <select data-am-selected="{searchBox: 1}" name="creater" placeholder="类型" id="creater" required>
			  
			 </select>
		    </div>
		    <div class="am-form-group" >
		    	<select multiple data-am-selected="{searchBox: 1}" name="resId" placeholder="药效" id="resId" required>
					 
				</select>
		    </div>
		     <div class="am-form-group" >
		    	<input name="rawPrice" id="rawPrice" placeholder="价格￥" type="text" pattern="\d{1,5}" required data-foolish-msg="请输入正确价格！" >
		    </div>
		  
			<div class="am-form-group" style="margin-left:20%;margin-top: 4%;">  
			<button class="am-btn am-btn-primary am-btn-xl" type="button" onclick="tijiao()">提交</button>
			<button class="am-btn am-btn-default am-btn-xl" type="button" style="margin-left: 10%;" onclick="qiongkong()">重置</button>
			</div>
		  </fieldset>
		</form>
	</div>
	<!-- 添加图片  -->
	<div id="img-div" style="display: none; margin: 2%;">
		<div class="layui-upload">
			<input type="hidden" value="" id="img-rawId"/>
		  <button type="button" class="layui-btn" id="testList">添加图片</button> 
		   <button type="button" class="layui-btn" id="testListAction">开始上传</button>
		  <div class="layui-upload-list">
		    <table class="layui-table">
		      <thead>
		        <tr><th>图片</th>
		        <th>状态</th>
		        <th>操作</th>
		      </tr></thead>
		      <tbody id="demoList"></tbody>
		      
		    </table>
		  </div>
		</div> 
</div>
<!-- 查看图片 -->
<div style="display:none;" id="dioImg">
	<div class="layui-carousel" id="test1">
	
  	<div carousel-item="" id="Imgf">
    
  	</div>
</div>
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

<!-- 设置工具栏 -->
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-mini" lay-event="edit" >编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
  <a class="layui-btn layui-btn-mini" lay-event="img">上传图片</a>
<a class="layui-btn layui-btn-mini" lay-event="rawImg">查看图片</a>
</script>
	
	<script>
	
	
	//同步
	 $.ajaxSetup({
		  async:false
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
        var da = {"rawId":data.rawId}//把得到的id放进json
        $.post("ErpRawAction/deleteRaw.action",da,function(mes){
        	tishi(mes)
        	 ajxaTable();//刷新表格
        });
      });
    } else if(obj.event === 'edit'){
    	layer.open({
    		  type: 1,
    		  title: ['编辑', '<i class="layui-icon" style="color: #5FB878;">&#xe642;</i>'],
    		  content: $('#from-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
    		  area: ['75%'],
			  cancel:function(){
				  qiongkong();//清空表单
			  }
    	});
	    var da = {"rawId":data.rawId};//把得到的id放进json
    	$.post("ErpRawAction/selectByPrimaryKey.action",da,function(list){
    		pagexia();
    		//赋值
    	   $("#rawId").val(list[0].rawId);
			$("#rawName").val(list[0].rawName);
			$("#rawPrice").val(list[0].rawPrice);
			var option = $('#creater option');
			//给下拉框赋值
			$(option).each(function(i,ele){
				if(obj.value==list[0].typer.typeId){
					$(this).attr("selected","selected");
				}
			});
			var applyId=$('#applyId option');
			$(applyId).each(function(i,ele){
				if(obj.value==list[0].app.applyId){
					$(this).attr("selected","selected");
				}
			});
			//给多选下拉框赋值
			var resId=$('#resId option');
			$.each(list[0].res,function(index,re){
				$(resId).each(function(i,ele){
					if(ele.value==re.resId){
						$(this).attr("selected","selected");
					}
				});
			});
	  });	
    } else if(obj.event === 'img'){
    	layui.use('upload', function(){
    		  var $ = layui.jquery
    		  ,upload = layui.upload;
    		  //多文件列表示例
    		  var demoListView = $('#demoList')
    		  ,uploadListIns = upload.render({
    		    elem: '#testList'
    		    ,url: 'ErpImgAction/insertSelective.action'
    		    ,data:{"rawId":data.rawId}
    		    ,accept: 'file'
    		    ,multiple: true
    		    ,auto: false
    		    ,bindAction: '#testListAction'
    		    ,choose: function(obj){   
    		      var files = obj.pushFile(); //将每次选择的文件追加到文件队列
    		      //读取本地文件
    		      obj.preview(function(index, file, result){
    		        var tr = $(['<tr id="upload-'+ index +'">'
    		          ,'<td>'+ file.name +'</td>'
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
    		        tds.eq(1).html('<span style="color: #5FB878;">上传成功</span>');
    		        tds.eq(2).html(''); //清空操作
    		        //delete files[index]; //删除文件队列已经上传成功的文件
    		        return;
    		      }
    		      this.error(index, upload);
    		    }
    		    ,error: function(index, upload){
    		      var tr = demoListView.find('tr#upload-'+ index)
    		      ,tds = tr.children();
    		      tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
    		      tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
    		    }
    		  });
    		});
    	layer.open({
			  type: 1,
			  title: ['添加图片', '<i class="layui-icon" style="color: #5FB878;">&#xe63c;</i>'],
			  content: $('#img-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
			  area: ['75%','50%'],
			  cancel:function(){
				 $("#demoList").html("");
			  }
    	});
    }else if(obj.event ==='rawImg'){
    	 var da = {"pricer":data.rawId};//把得到的id放进json
    	layer.open({
			  type: 1,
			  title: ['图片', '<i class="layui-icon" style="color: #5FB878;">&#xe63c;</i>'],
			  content: $('#dioImg'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
			  area: ['47%','70%'],
			  cancel:function(){
				$("#Imgf").html("");
			  }
    		});
		  $.post("ErpImgAction/findImg.action",da,function(list){
			$.each(list,function(index,obj){
				$("#Imgf").append("<div><img src="+obj.imgUrl+" /></div>");
			});
		 }); 
		 $("#ImgRawId").val(data.rawId);
		 layui.use('carousel', function(){
			  var carousel = layui.carousel;
			  //建造实例
			  carousel.render({
				    elem: '#test1'
				    ,width: '100%'
				    ,height: '360px'
				    ,interval: 3000
				    
				  });
			});
    }
  });
});

//点击添加按钮的方法	 
function addtype(){
	pagexia();//调用下拉框赋值方法
	layui.use('table', function(){
		  var table = layui.table;
		  layer.open({
			  type: 1,
			  title: ['添加', '<i class="layui-icon" style="color: #5FB878;">&#xe63c;</i>'],
			  content: $('#from-div'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
			  area: ['75%'],
			  cancel:function(){
				  qiongkong();//清空表单
			  }
		});
	});
}
function tishi(mes){
	if(mes.state==1){//真确的样式
 		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #5FB878;">&#xe618;</i>'+mes.mes);
 		ajxaTable();
 	}else{
 		layer.msg('<i class="layui-icon" style="font-size: 40px; color: #FF5722;">&#x1006;</i>'+mes.mes);
 	}
}
//添加提交
function tijiao(){
	 var data =$("#raw-from").serialize();//表单序列化 
	 var array = data.split('&');
	 if(array.length>5){
		 if($("#rawId").val()!=''){
			 $.post("ErpRawAction/updateByPrimaryKeySelective.action",data,function(mes){
				 tishi(mes);
			  });
		 }else{
			 $.post("ErpRawAction/insertSelectiveRaw.action",data,function(mes){
				 tishi(mes);
			  });
		 }
	 }else{
		 layer.msg('<i class="layui-icon" style="font-size: 20px; color: #FF5722;">&#x1006;</i>请填写正确');
	 }
	 layer.close();
}

//下拉框赋值方法
function pagexia(){
	$.post("EepApplyAction/findErpApply.action",function(app){
		$.each(app ,function(index,obj){
			$('#applyId').append('<option value="' + obj.applyId +'">' + obj.applyName + '</option>');
			
		});
	});
	//多选下拉框赋值方法
	$.post("ErpResuitAction/findErpResuit.action",function(res){
		$.each(res ,function(index,obj){
			$('#resId').append('<option value="' + obj.resId +'">' + obj.resName + '</option>');
		});
	});
	$.post("ErpKindsType/showListTypetuo.action",function(type){
		$.each(type ,function(index,obj){
			$('#creater').append('<option value="' + obj.typeId +'">' + obj.typeName + '</option>');
		});
	});
}
//刷新表单
function ajxaTable(){
	layui.use('table', function(){ //layui表格操作的基本方法
		  var table = layui.table;
		  table.reload('idTest', {//表格的id
			  url: 'ErpRawAction/showListRaw.action'//url
			  ,where: {//表格的字段
				  resId:"rawId",
				  rawSerial:"rawSerial",
				  rawName:"rawName",
				  typer:"typer",
				  app:"app",
				  res:"res"
			  }
		  	
		});
	});
	layer.closeAll();
}
function solo(){
	var pricer = $("#price").val();
	layui.use('table', function(){ //layui表格操作的基本方法s
		  var table = layui.table;
		  table.reload('idTest', {//表格的id
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

//清空表单
function qiongkong(){
	$("#rawId").val("");
	$('#raw-from')[0].reset();
	$("#applyId").empty(); 
	$("#resId").empty(); 
	$("#creater").empty(); 
}
</script>

</body>
</html>