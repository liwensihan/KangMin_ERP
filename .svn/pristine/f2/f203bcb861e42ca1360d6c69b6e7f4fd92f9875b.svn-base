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
		<title>POS</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<style type="text/css">
			body{
				padding: 10px;
			}
			.bigDiv{
				width:100%;
				border: solid 1px #ddd;
				border-radius: 4px;
			}
			.bigDiv > .headDiv{
				background-color: #f5f5f5;
				padding: 10px 15px;
				border-radius: 4px 4px 0 0;
				border-bottom: solid 5px #ddd;
				font-weight: bold;
				text-align: center;
				color: #009688;
			}
			.bigDiv .bodyDiv{
				padding: 15px;
			}
			input[type="text"]{
				margin-right:20px; 
			}
			.bigDiv .bodyDiv table[lay-size="sm"] th {
			    text-align: center;
			}
			.bigDiv .inputText{
				border-left-width:0px;
				border-top-width:0px;
				border-right-width:0px;
				border-bottom-color:black;
				width:160px;
			}
			.bigDiv > .bodyDiv .num{
				width:25px;
				margin-right: 0px;
			}
			.footDiv .layui-form-switch{
				margin: 0px;
				float: left;
			}
		</style>
	</head>
	<body>
		<div class="bigDiv">
			<div class="headDiv">前端POS销售</div>
			<div class="bodyDiv" style="width:1000px;margin: auto;">
				
				<div style="text-align: center;">
					日期：<input class="inputText" type="text" value="${times}">
					订单编号：<input class="inputText" type="text" value="${kinordSerial}" readonly>
					分店：<input class="inputText" type="text">
					经办人：<input class="inputText" type="text" value="${staName}">
					<hr>
					会员编号：<input class="inputText" type="text">
					<span class="layui-badge-dot layui-bg-green"></span>
					产品条形码：<input id="kinBarcode" class="inputText" type="text">
					<form class="layui-form" action="">
					<table id="kinList" class="layui-table" lay-size="sm">
					  <thead>
					    <tr>
					      <th rowspan="2"><button class="layui-btn layui-btn-radius layui-btn-primary layui-btn-mini " lay-submit lay-filter="deleteKin"><i class="layui-icon">&#xe640;</i></button></th>
					      <th colspan="4">商品信息</th>
					      <th colspan="3">价格</th>
					      <th rowspan="2">备注</th>
					    </tr>
					    <tr>
					      <th>商品编码</th>
					      <th>商品名称</th>
					      <th>净含量</th>
					      <th>保质期</th>
					      <th>价格</th>
					      <th>数量</th>
					      <th>总金额</th>
					    </tr>
					  </thead>
					  <tbody>
					    
					  </tbody>
					  <tfoot>
					  	<tr>
					  		<td colspan="10" align="left">记录数：<span id="showNum">0</span></td>
					  	</tr>
					  </tfoot>
					</table>
					
					<hr>
					<div class="footDiv" align="right">
						<input type="checkbox" name="on-off" lay-filter="on-off" lay-skin="switch" lay-text="批发|零售">
						应付金额(元)：<input id="sumPrice" name="kinordNum" class="inputText" type="text">
						实付金额(元)：<input id="sumPrice1" class="inputText" type="text">
						找零(元)：<input id="sumPrice2" class="inputText" >
						<hr>
						<button class="layui-btn layui-btn-small" lay-submit lay-filter="submit"><i class="layui-icon">&#xe609;</i>保存</button>
						<button class="layui-btn layui-btn-primary layui-btn-small" lay-submit lay-filter="reset"><i class="layui-icon">&#x1007;</i>清空</button>
					</div>
					</form>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$('.x-slide_left',window.parent.document).click();
		document.getElementById("kinBarcode").focus();//自动聚焦
		showNum();//更改显示记录数
		showPrice();//更改总金额
		var layer;
		var form;
		layui.use('layer', function(){
		  layer = layui.layer;
		  
		});
		
		layui.use('form', function(){
		  form = layui.form;
		  //监听提交
		  form.on('submit(submit)', function(data){
			var kindsIndex = $("#kinList tbody tr");
			if(kindsIndex.length==0){
				layer.msg('请录入商品！');
			}else{
				var price2 = $("#sumPrice2").val();//找零金额
				if(price2<0 || price2==""){
					layer.msg('实付金额应大于应付金额！');
					return false;
				}
				alert("通过");
			}
		    return false;
		  });
		  //监听重置
		  form.on('submit(reset)', function(data){
		    //layer.msg(JSON.stringify(data.field));
		    layer.msg("点击重置");
		    return false;
		  });
		  //监听删除
		  form.on('submit(deleteKin)', function(data){
			var checkbox = $("#kinList input[type='checkbox'][name='kin']:checked");
			if(checkbox.length==0){
				layer.msg('请选择商品再进行删除');
			}else{
				layer.confirm('是否删除选中商品?', {icon: 3, title:'提示'}, function(index){
					$(checkbox).each(function(i,ele){
						var tr = $(this).parent().parent();
						var kinId = tr.children().eq(1).children().eq(0).val();//商品ID
						var kinNum = tr.children().eq(6).children().eq(0).val();//数量
						var remark = tr.children().eq(8).html();//备注
						tr.remove();
						layer.msg('删除成功！');
						showNum();//更改显示记录数
						showPrice1();//更改总金额
					});
					layer.close(index);
				});
			}
		    return false;
		  });
		  //复选框监听
		  form.on('switch(on-off)', function(data){
		  	if(data.elem.checked==true){
		  		layer.msg("批发模式");
		  	}else{
		  		layer.msg("零售模式");
		  	}
		  });
		});
		//更改商品数量
		function updateNum(obj){
			var value = obj.value;
			var reg=/^[1-9]\d*$|^0$/;
			if(reg.test(value)==false){
				if(obj.value!=""){
					obj.value=1;
				}
			}
			showPrice();
		}
		//更改应付金额
		$("#sumPrice1").keyup(function(){
			var price = $("#sumPrice").val();
		 	var price1 = $(this).val();
		 	clearNoNum(this);
		 	var subtractPrice = price1-price;
		 	$("#sumPrice2").val(subtractPrice);
			if($(this).val()==""){
				$("#sumPrice2").val("");
			}
		});
		//更改记录数
		function showNum(){
			$("#showNum").html($("#kinList tr").length-3);
		}
		//更改显示金额
		function showPrice(){
			var tr = $("#kinList tbody tr");
			if(tr.length>0){
				var sumPrice =0;
				$.each(tr,function(i,element){
					var price = $(this).children().eq(5).text();
					var num = $(this).children().eq(6).children().val();
					$(this).children().eq(7).text(price*num);
					sumPrice = sumPrice+price*num;
				});
				$("#sumPrice").val(sumPrice);
			}
			if($("#sumPrice1").val()!=""){
				$("#sumPrice2").val($("#sumPrice1").val()-$("#sumPrice").val());
			}
		}
		//增加
		$("#kinBarcode").change(function(){
	  		var url = "ErpKindsAction/findByKinBarcode.action";
	  		var data = {"kinBarcode":$(this).val()}
			$.post(url, data, function(info){
				if(info==""){
					layer.msg("找不到该商品！");
					return ;
				}
				var falg = true;
				var tr = $("#kinList tbody tr");
				if(info!="" && tr.length>0){
					$(tr).each(function(i,element){
						var text = $(this).children().eq(1).children("input").val();
						if(info.kinId==text){
							falg=false;
							var num = parseInt($(this).children().eq(6).children().val());
							$(this).children().eq(6).children().val(num+1);
						}
					});
					$("#sumPrice").val(sumPrice);
				}
				if(info!="" && falg==true){
					$("#kinList tbody").append('<tr>'+
						      '<td><input type="checkbox" name="kin" lay-skin="primary" ></td>'+
						      '<td><input type="hidden" name="kinId" value="'+info.kinId+'"/>'+info.kinSerial+'</td>'+
						      '<td>'+info.kinName+'</td>'+
						      '<td>'+info.kinContent+'</td>'+
						      '<td>'+info.kinExpiration+'</td>'+
						      '<td>'+info.kinPrice+'</td>'+
						      '<td><input class="inputText num" type="text" value="1" maxlength="4" onkeyup="updateNum(this)"></td>'+
						      '<td>0</td>'+
						      '<td><input class="inputText" type="text" maxlength="40" style="margin:0px;"/></td>'+
						    '</tr>');
					form.render('checkbox');
				}
				showPrice();
				showNum();
			});
	  		$("#kinBarcode").val("");
		});
		
		//限制数字的输入
		function clearNoNum(obj){ 
		    obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符  
		    obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的  
		    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); 
		    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数  
		    if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额 
		        obj.value= parseFloat(obj.value); 
		    } 
		    if(obj.value.indexOf(".")==0){//第一个字符不能为.
		    	 obj.value="";
		    }
		}  
	</script>
	
	
</html>