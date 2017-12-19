<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="res/layui/css/layui.css">
<script src="res/js/jquery-2.1.3.min.js" type="text/javascript"></script>
<script src="res/layui/layui.js"></script>
<style type="text/css">
.layui-table-view {
	margin: 10px 18px;
	overflow: hidden;
}

body {
	padding: 10px;
}

#sousuo td {
	padding-right: 5px;
	padding-top: 5px;
}

#sousuo .layui-input {
	height: 40px;
	width: 150px;
}

#tbe tfoot td{

	border:0px solid red;
	text-align: right;
}
</style>
<script type="text/javascript">
	//Demo
	layui.use('form', function() {
		var form = layui.form;

		//监听提交
		form.on('submit(formDemo)', function(data) {
			console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
			console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
			console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
			var tabLen = document.getElementById("body");
            var kinName ="";
            var kinPrice ="";
            var fdprolistmxCount ="";
            var fdprolistmxMoney ="";
            var fdproId = $("#fdproId").val();
            var zong = $("#jia").html();
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            for (var i = 0; i < tabLen.rows.length; i++) {
            	kinName +=  tabLen.rows[i].cells[0].innerHTML +","
            	kinPrice +=  tabLen.rows[i].cells[1].innerHTML +","
            	fdprolistmxCount +=  tabLen.rows[i].cells[2].innerHTML+"," 
            	fdprolistmxMoney +=  tabLen.rows[i].cells[3].innerHTML+","
            }
            
            url="mall/add.action";
            var data={};
            var kinId = new Array();
            $("#oneForm input[name='kinId']").each(function(i,element){
            	kinId[i]=$(this).val();
            });
            data.kinPrice=kinPrice;
            data.fdprolistmxCount=fdprolistmxCount;
            data.fdprolistmxMoney=fdprolistmxMoney;
            data.kinId=kinId;
            data.fdproId=fdproId;
            data.zong = zong;
            $.post(url,data,function(m){
            	if(m.mes=="add"){
            		parent.layer.close(index);
    				parent.table.reload('testReload');
    				parent.layer.msg('采购订单提交成功');
            	}else{
            		parent.layer.close(index);
    				parent.table.reload('testReload');
    				parent.layer.msg('采购订单修改成功');
            	}
            },"json");
			
			
			return false;
		});
	});
	
	url="Warehouse/findAll.action";
	$.post(url,null,function(m){
		for(i=0;i<m.length;i++){
			$("#kinId").append("<option value='"+m[i].kinId+"'>"+m[i].kinName+"</option>");
		}
	})
	
	$(function(){
		getPrice();
		$("#add").click(function(){
			var kinId = $("#kinId").val();
			var fdprolistmxCount = $("#fdprolistmxCount").val();
			if(kinId!='' && fdprolistmxCount!=''){
				url="Warehouse/findById.action";
				data={kinId:kinId};
				$.post(url,data,function(m){
					if(fdprolistmxCount<=Number(m.WARE_NUM)){
						if($("#"+m.KIN_ID+"").val()==null){
							var money = returnFloat(fdprolistmxCount * Number(m.KIN_PRICE));
							$("#tbe").append("<tr><input id='"+m.KIN_ID+"' type='hidden' value='"+m.KIN_ID+"' name='kinId'><td>"+m.KIN_NAME+"</td><td>"+m.KIN_PRICE+"</td><td ondblclick='dblclickThis(this)'>"+fdprolistmxCount+"</td><td class='price'>"+money+"</td><td><button class='layui-btn layui-btn-danger' onclick='deleteThis(this)'>删除</button></td></tr>");
							getPrice();
						}else{
							var m1 = Number(fdprolistmxCount)+Number($("#"+m.KIN_ID+"").parent().children("td").eq(2).text());
							if(m1<=Number(m.WARE_NUM)){
								$("#"+m.KIN_ID+"").parent().children("td").eq(2).text(m1);
								var z = m1*Number($("#"+m.KIN_ID+"").parent().children("td").eq(1).text());
								var d = returnFloat(z);
								$("#"+m.KIN_ID+"").parent().children("td").eq(3).text(d);
								getPrice();
							}else{
								layer.msg("库存不足");
								
							}
						}
					}else{
						layer.msg("库存不足");
					}
				})
			}else{
				layer.msg("请选择的采购商品");
			}
		})
		
		
	})
	
	
	function deleteThis(obj,id){
		if(id==null){
			$(obj).parent().parent().remove();
			getPrice();
		}else{
			url="mall/updateIsva.action";
			data={fdprolistmxId:id};
			$.post(url,data,function(m){
				if(m.mes=="ok"){
					$(obj).parent().parent().remove();
					getPrice();
				}
			})
		}
		
	}
	
	
	function dblclickThis(obj){
		var value = $(obj).html()
		layer.confirm("<input type='text' value="+value+" id='change'>", function(index){
			  var price = $(obj).parent().children("td").eq(1).text();
			  var change = $("#change").val();
			  $(obj).html(change);
			  var money = change * price;
			  var money2 = returnFloat(money);
			  $(obj).parent().children("td").eq(3).text(money2);
			  getPrice();
			  layer.close(index);
		});       
	}
	
	
	function returnFloat(value){
		 var value=Math.round(parseFloat(value)*100)/100;
		 var xsd=value.toString().split(".");
		 if(xsd.length==1){
		 value=value.toString()+".00";
		 return value;
		 }
		 if(xsd.length>1){
		 if(xsd[1].length<2){
		  value=value.toString()+"0";
		 }
		 return value;
		 }
	}
	
	
	function getPrice(){
		var priceList = document.getElementsByClassName("price");
		var price=0;
		for(var i=0;i<priceList.length;i++){
			price+=Number(priceList[i].innerHTML);
		}
		value = returnFloat(price);
		if(price==0){
			$("#zong").html("总价格：<span style='color:red;font-size:25px;'>0</span>");
		}else{
			$("#zong").html("总价格：<span style='color:red;font-size:25px;' id='jia'>"+value+"</span>");
		}
	}
	
	
	
</script>
</head>
<body>
	<div class="demoTable">
		&nbsp;&nbsp;&nbsp;&nbsp;
		<div class="layui-inline">
			<form class="layui-form" id="sousuo" style="float: left;">
				<table>
					<tr>
						<td>商品名称：</td>
						<td><select id="kinId" lay-search=""
							width="50px">
								<option value="">商品名称</option>
						</select></td>
						<td style="width: 30px;"></td>
						<td>数量：</td>
						<td><input id="fdprolistmxCount"
							autocomplete="off" class="layui-input" type="number" min="1" max="999"></td>
					</tr>

				</table>
			</form>
			<button class="layui-btn layui-btn-normal" style="margin-top: 5px;" data-type="reload" id="add">增加</button>
		</div>
	</div>
	<form id="oneForm" class="layui-form">
	<div class="layui-form">
		<table class="layui-table" id="tbe">
			<colgroup>
				<col width="150">
				<col width="150">
				<col width="200">
				<col>
			</colgroup>
			<thead>
				<tr>
					<td>货品名称</td>
					<td>单价</td>
					<td>数量</td>
					<td>总价</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody id="body">
			<input type="hidden" value="${fdproId }" id="fdproId" name="fdproId">
			<c:forEach items="${mall }" var="mall">
			<tr>
				<input type="hidden" value="${mall.kinId }" id="${mall.kinId }" name="kinId">
				<td>${mall.kinName }</td>
				<td>${mall.kinPrice }</td>
				<td ondblclick='dblclickThis(this)'>${mall.fdprolistmxCount }</td>
				<td class="price">${mall.fdprolistmxMoney }</td>
				<td><a class='layui-btn layui-btn-danger' onclick="deleteThis(this,'${mall.fdprolistmxId }')">删除</a></td>
			</tr>
			</c:forEach>
			</tbody>
			<tfoot>
			<tr>
				<td colspan="5" id="zong" ></td>
			</tr>
			</tfoot>
		</table>
		<div class="layui-layer-btn layui-layer-btn-">
			<button class="layui-btn" lay-submit lay-filter="formDemo" id="submit">立即提交</button>
		</div>
	</div>
	</form>
</body>
</html>