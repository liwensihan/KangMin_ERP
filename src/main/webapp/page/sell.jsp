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
				border-bottom: solid 2px #ddd;
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
			<div class="headDiv">康源医药分店销售</div>
			<div class="bodyDiv" style="width:1000px;margin: auto;">
				
				<div style="text-align: center;width: 957px;">
					日期：<input class="inputText" type="text" value="${times}" readonly>
					订单编号：<input id="saleId" class="inputText" type="text" value="${saleId}" readonly>
					分店：<input class="inputText" type="text" value="${annexName}" readonly>
						<input type="hidden" id="annexId" value="${annexId}"/>
					经办人：<input class="inputText" type="text" value="${staName}" readonly>
					<hr>
					会员编号：<input id="memberId" class="inputText" type="text">
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
					      <th>零售价</th>
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
						原金额：<span style="margin-right:20px;text-decoration:line-through;">
							<span id="sumPrice0" style="font-size: 22px;">0</span>元</span>
						会员折扣：<span id="memberZheko" style="margin-right:20px;color:red;">非会员</span>
						应付金额：<span style="margin-right:20px;color:red;">
						<span style="font-size: 22px;" id="sumPrice1">0</span>元</span>
						实付金额：<input id="sumPrice2" class="inputText" maxlength="8" type="text" style="width:80px">
						找零：<span style="margin-right:20px;color:red;">
						<span style="font-size: 22px;" id="sumPrice3">0</span>元</span>
						<hr>
						<button class="layui-btn layui-btn-small" lay-submit lay-filter="submit"><i class="layui-icon">&#xe609;</i>提交</button>
						<button class="layui-btn layui-btn-primary layui-btn-small" lay-submit lay-filter="reset"><i class="layui-icon">&#x1007;</i>清空</button>
					</div>
					</form>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$('.x-slide_left',window.parent.document).click();//关闭左边菜单栏
		document.getElementById("kinBarcode").focus();//自动聚焦
		var noOff = false;//是否批发
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
				var price2 = $("#sumPrice2").val();//实付金额
				var price3 = $("#sumPrice3").text();//找零金额
				if(price3<0 || price2==""){
					layer.msg('实付金额应大于或等于应付金额！');
					return false;
				}
				//获取数据
				var memberId = $("#memberId").val();//会员编号
				var kind = new Array();
				$(kindsIndex).each(function(i,element){
					var kindId = $(this).children().eq(1).children().val();
					var price = $(this).children().eq(5).text();
					var kindNum = $(this).children().eq(6).children().val();
					var remark = $(this).children().eq(8).children().val();
					var str = kindId+"@"+price+"@"+kindNum+"@"+remark;
					kind[i]=str;
				});
				var sumPrice0 = $("#sumPrice0").text();//原金额
				var sumPrice1 = $("#sumPrice1").text();//应付金额
				var sumPrice2 = $("#sumPrice2").val();//实付金额
				var sumPrice3 = $("#sumPrice3").text();//找零
				var memberZheko =1;//折扣
				if($("#memberZheko").text()!="非会员" && $("#memberZheko").text()!="批发不打折"){
					var memberZheko = $("#memberZheko").text().replace("折","");
				}
				var data ={};
				data.saleId=$("#saleId").val();
				data.annexId=$("#annexId").val();
				data.memberId=memberId;
				data.kind=kind;
				data.sumPrice0=sumPrice0;
				data.sumPrice1=sumPrice1;
				data.sumPrice2=sumPrice2;
				data.sumPrice3=sumPrice3;
				data.memberZheko=memberZheko;
				data.noOff=noOff;
				console.info(data);
				//增加订单
				var url = "sctockmp/addSctockmp.action";
				$.post(url, data, function(info){
					if(info==1){
						if(noOff){
							layer.msg('订单生成，等待审核！');
						}else{
							layer.msg('订单完成！');
						}
						$("#memberId").val("");
						$("#kinList tbody tr").remove();
						showPrice();//更改总金额
					}else{
						layer.msg('操作失败！');
					}
				});
			}
		    return false;
		  });
		  
		  var saleId = $("#saleId").val();
			if(saleId!=""){//如果订单编号不为空，则查找订单明细
				//点击批发按钮
				$("input[name='on-off']").click();
				layer.msg("批发模式");
		  		noOff=true;
		  		$("#memberZheko").text("批发不打折");
		  		$("#kinList thead tr").eq(1).children().eq(4).text("批发价");
				//显示订单明细
				var url = "sctovkmpDetail/findBySaleId.action";
				var data = {"saleId":saleId}
				$.post(url, data, function(info){
					$(info).each(function(i,element){
						$("#kinList tbody").append('<tr>'+
							      '<td><input type="checkbox" name="kin" lay-skin="primary" ></td>'+
							      '<td><input type="hidden" name="kinId" value="'+element.KIN_ID+'"/>'+element.KIN_SERIAL+'</td>'+
							      '<td>'+element.KIN_NAME+'</td>'+
							      '<td>'+element.KIN_CONTENT+'</td>'+
							      '<td>'+element.KIN_EXPIRATION+'</td>'+
							      '<td>'+element.KIN_SELLINF+'</td>'+
							      '<td><input class="inputText num" type="text" value="1" maxlength="4" onkeyup="updateNum(this)"></td>'+
							      '<td>0</td>'+
							      '<td><input class="inputText" type="text" maxlength="40" style="margin:0px;"/></td>'+
							    '</tr>');
					});
					form.render('checkbox');
					showPrice();
					showNum();
				});
			}
			
		  //监听重置
		  form.on('submit(reset)', function(data){
			$("#memberId").val("");
			$("#kinList tbody tr").remove();
			showPrice();//更改总金额
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
						showPrice();//更改总金额
					});
					layer.close(index);
				});
			}
		    return false;
		  });
		  //复选框监听
		  form.on('switch(on-off)', function(data){
			$("#kinList tbody tr").remove();
			showPrice();//更改总金额
		  	if(data.elem.checked==true){
		  		layer.msg("批发模式");
		  		noOff=true;
		  		$("#memberZheko").text("批发不打折");
		  		$("#kinList thead tr").eq(1).children().eq(4).text("批发价");
		  	}else{
		  		layer.msg("零售模式");
		  		noOff=false;
		  		$("#memberZheko").text("非会员");
		  		$("#kinList thead tr").eq(1).children().eq(4).text("零售价");
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
		$("#sumPrice2").keyup(function(){
			clearNoNum(this);
			var price = $("#sumPrice1").text();
		 	var price1 = $(this).val();
		 	var subtractPrice = decimal(price1-price,2);
		 	$("#sumPrice3").text(subtractPrice);
			if($(this).val()==""){
				$("#sumPrice3").text(0);
			}
		});
		//更改记录数
		function showNum(){
			$("#showNum").html($("#kinList tr").length-3);
		}
		//更改显示金额
		function showPrice(){
			showNum();
			var tr = $("#kinList tbody tr");
			if(tr.length>0){
				var sumPrice0 =0;
				$.each(tr,function(i,element){
					var price = $(this).children().eq(5).text();
					var num = $(this).children().eq(6).children().val();
					$(this).children().eq(7).text(decimal(price*num,2));
					sumPrice0 = decimal(sumPrice0+price*num,2);
				});
				$("#sumPrice0").text(sumPrice0);//更改原金额
			}else{//如果没有商品
				$("#sumPrice0").text(0);
				$("#sumPrice1").text(0);
				$("#sumPrice2").val("");
				$("#sumPrice3").text(0);
				return false;
			}
			//更改应付金额
			if($("#memberZheko").text()=="非会员" || $("#memberZheko").text()=="批发不打折"){
				$("#sumPrice1").text($("#sumPrice0").text());
			}else{
				var memberZheko = $("#memberZheko").text().replace("折","");
				$("#sumPrice1").text(decimal(memberZheko/10*$("#sumPrice0").text(),2));
			}
			//更改找零金额
			if($("#sumPrice2").val()!=""){
				$("#sumPrice3").text(decimal($("#sumPrice2").val()-$("#sumPrice1").text(),2));
			}
		}
		//增加
		$("#kinBarcode").change(function(){
	  		var url = "sumstock/findByKinBarcode.action";
	  		var data = {"kinBarcode":$(this).val(),"annexId":$("#annexId").val()}
			$.post(url, data, function(info){
				if(info==""){
					layer.msg("找不到该商品！");
					return ;
				}
				if(info.STOCK_SUOUNT<1){
					layer.msg("抱歉，该商品库存不足！");
					return ;
				}
				var falg = true;
				var tr = $("#kinList tbody tr");
				if(info!="" && tr.length>0){//给相同的商品加数量
					$(tr).each(function(i,element){
						var text = $(this).children().eq(1).children("input").val();
						if(info.KIN_ID==text){
							falg=false;
							var num = parseInt($(this).children().eq(6).children().val());
							$(this).children().eq(6).children().val(num+1);
						}
					});
				}
				if(info!="" && falg==true){
					if(!noOff){
						$("#kinList tbody").append('<tr>'+
							      '<td><input type="checkbox" name="kin" lay-skin="primary" ></td>'+
							      '<td><input type="hidden" name="kinId" value="'+info.KIN_ID+'"/>'+info.KIN_SERIAL+'</td>'+
							      '<td>'+info.KIN_NAME+'</td>'+
							      '<td>'+info.KIN_CONTENT+'</td>'+
							      '<td>'+info.KIN_EXPIRATION+'</td>'+
							      '<td>'+info.KIN_STOST+'</td>'+
							      '<td><input class="inputText num" type="text" value="1" maxlength="4" onkeyup="updateNum(this)"></td>'+
							      '<td>0</td>'+
							      '<td><input class="inputText" type="text" maxlength="40" style="margin:0px;"/></td>'+
							    '</tr>');
					}else{
						$("#kinList tbody").append('<tr>'+
							      '<td><input type="checkbox" name="kin" lay-skin="primary" ></td>'+
							      '<td><input type="hidden" name="kinId" value="'+info.KIN_ID+'"/>'+info.KIN_SERIAL+'</td>'+
							      '<td>'+info.KIN_NAME+'</td>'+
							      '<td>'+info.KIN_CONTENT+'</td>'+
							      '<td>'+info.KIN_EXPIRATION+'</td>'+
							      '<td>'+info.KIN_SELLINF+'</td>'+
							      '<td><input class="inputText num" type="text" value="1" maxlength="4" onkeyup="updateNum(this)"></td>'+
							      '<td>0</td>'+
							      '<td><input class="inputText" type="text" maxlength="40" style="margin:0px;"/></td>'+
							    '</tr>');
					}
					
					form.render('checkbox');
				}
				showPrice();
				showNum();
			});
	  		$("#kinBarcode").val("");
		});
		
		//更改会员号
		$("#memberId").change(function(){
			if(noOff){
				layer.msg("温馨提示：批发模式，不允许折扣");
				return false;
			}
			var url = "member/findById.action";
	  		var data = {"memberId":$(this).val()}
			$.post(url, data, function(member){
				var sumPrice0 = $("#sumPrice0").text();//原价
				if(member==""){
					layer.msg("该会员不存在！");
					$("#memberZheko").html("非会员");
					$("#sumPrice1").text(sumPrice0);
				}else{
					$("#memberZheko").html(member.memberZheko+"折");
				}
				showPrice();
			});
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
		//计算金钱四舍五入
		function decimal(num,v){
			var vv = Math.pow(10,v);
			return Math.round(num*vv)/vv;
		}
	</script>
	
	
</html>