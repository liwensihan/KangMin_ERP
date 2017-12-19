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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="res/layui/css/layui.css" media="all">
<script src="<%=basePath%>res/js/jquery-2.1.3.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>res/layui/layui.js"></script>

<title>采购成品</title>
<style type="text/css">
body {
	padding: 2%;
}
#ss {
	color: #780000;
	font-size: 18px;
	text-align: center;
}
</style>
</head>
<body>
	<div>
		<form class="layui-form" id="formSubmit">
			<input type="hidden" id="purcId" name="purcId"></input>
			<input type="hidden" name="state" id="state"/>
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>采购订单表</legend>
			</fieldset>
			
			<!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
			<div class="layui-form-item">
				<label class="layui-form-label">采购标题</label>
				<div class="layui-input-block">
					<input type="text" name="purcTitle" id="purcTitle" placeholder="请输入" autocomplete="off" class="layui-input">
				</div>
			</div>
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
				<legend>采购货品表</legend>
			</fieldset>

			<div id="specifications-number">
				<div class="layui-form-item">
					<label class="layui-form-label">成品项</label>
					<div class="layui-input-inline">
						<select name="kinId" id="kinId" lay-verify="" lay-search>
							<option value="" >请选择成品</option>
						</select>

					</div>
					<div class="layui-input-inline">
						<input name="number" lay-verify="required" placeholder="请输入数量" autocomplete="off" class="layui-input" type="text">
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-input-block">
					<a href="javascript:void(0)" class="layui-btn layui-bg-gray" style="width: 62.5%;" onclick="addRaw()">添加成品</a>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="sbt">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	<script>
		var form1;
		layui.use('form', function() {
			form1 = layui.form;
			//监听提交
			form1.on('submit(sbt)', function(data) {
				
				var url = "Purchase/pact.action";
				var data = "";
				$.post(url, data, function(returnData) {
					var tabVal = '<div id="ss">条	例	须	知</div>';
					tabVal += '' + '<tr>' + '<td>' + returnData[0].pactText
							+ '</td>' + '</tr>' + '';
					layer.open({
						type : 1,
						title : false, //不显示标题栏
						closeBtn : true,
						area : '550px',//调节宽度，高度自适应
						shade : 0.8,
						id : 'LAY_layuipro', //设定一个id，防止重复弹出
						btnAlign : 'c',
						moveType : 1, //拖拽模式，0或者1
						content : '<table class="layui-table" id="sa">'
								+ '<thead>' + '</thead>' + '<tbody>' + tabVal
								+ '</tbody>' + '</table>',
						btn : [ '同意', '不同意' ],
						yes : function(index, layero) {
							$.ajax({
								url : 'Purchase/addKinds.action',
								type : 'POST',
								data : new FormData($("#formSubmit")[0]),
								async : false,
								cache : false,
								contentType : false,
								processData : false,
								success : function(returndata) {
									var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
									parent.layer.close(index);
									parent.table.reload('testReload2');
									parent.layer.msg('成功', {
										icon : 1
									});
								},
								error : function(returndata) {
									layer.msg('提交失败', {
										icon : 2
									});
								}
							});
						},
						btn2 : function(index, layero) {

						}
					});
				})
				return false;
			});
		});
		function removeRaw() {
			$("#div").remove();
		}
		var spidData = 1;
		function addRaw() {
			spidData += 1;
			$("#specifications-number")
					.append(
							''
									+ '<div class="layui-form-item" id="div">'
									+ '<label class="layui-form-label"><a href="javascript:void(0)" style="color:red;" onclick="removeRaw(&quot;&quot;)">(X)</a>&nbsp;&nbsp;原材料</label>'
									+ '<div class="layui-input-inline">'
									+ '<select name="kinId" id="kinId'+spidData+'" lay-verify="" lay-search>'
									+ '<option value="">请选择</option>'
									+ '</select>'
									+ '</div>'
									+ '<div class="layui-input-inline">'
									+ '<input name="number" lay-verify="required" placeholder="请输入数量"'+
									'autocomplete="off" class="layui-input" type="text" value="">'
									+ '</div>' + '</div>');
			showRawAll(spidData);
		}
		//查询货品表数据
		function showRawAll(dat) {
			var url = "Purchase/showKindsAll.action";
			$.post(url, null, function(info) {
				for (i = 0; i < info.length; i++) {
					var obj = info[i];
					$("#kinId" + dat).append(
							'<option value="'+obj.kinId+'~'+obj.kinPrice+'">'
									+ obj.kinName + '￥:' + obj.kinPrice
									+ '</option>');
				}
				form1.render(); //更新全部
			});
		}

		//初始化加载信息
		$(function() {
			var id = GetQueryString("id");
			var url = "Purchase/showKind.action";
			var data = {
				"purcId" : id
			}
			if (id != null && id != "") {
				$.post(url, data, function(mes) {
					$("#purcId").val(mes.purcId);
					$("#state").val("1");
					$("#purcTitle").val(mes.purcTitle);
				});
			}
			showRawAll('');
			function GetQueryString(id) {
				var reg = new RegExp("(^|&)" + id + "=([^&]*)(&|$)");
				var r = window.location.search.substr(1).match(reg);
				if (r != null)
					return unescape(r[2]);
				return null;
			}
		})
	</script>
</body>
</body>
</html>