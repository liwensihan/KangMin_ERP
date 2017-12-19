<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>公告列表</title>
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
		<style type="text/css">
			body{
				padding: 10px;
			}
			#sousuo input{
				width:200px;
			}
		</style>
	</head>
	<body>
		<div class="layui-inline" id="demoTable">
			<form class="layui-form" id="sousuo" style="float: left;">
				<table style="width:420px;">
					<tr>
						<td>
							<input class="layui-input" name="noticeData" maxlength="50" id="noticeData" placeholder="公告标题/发布人" autocomplete="off">
						</td>
						<td>
						    <div class="layui-input-inline" style="margin-left: 5px;">
						      <input type="text" id="noticeTime" name="noticeTime" placeholder="发布时间" class="layui-input" readonly="readonly">
						    </div>
						</td>
					</tr>
				</table>
			</form>
			<button style="margin-top: 5px;margin-left: 5px;" class="layui-btn layui-btn-small" data-type="reload"><i class="layui-icon">&#xe615;</i> 搜索</button>
		</div>
		<table class="layui-table" lay-data="{height:400,size:'sm',skin:'row ', url:'notice/findAll.action',method:'post',page:true,limit:10, id:'tb'}" lay-filter="tb">
		  <thead>
		    <tr>
		      <th lay-data="{field:'noticeId',hidden}">公告ID</th>
		      <th lay-data="{field:'noticeTitle', sort: true,width:250, fixed: 'left',templet:'#noticeTitleTpl'}">标题</th>
		      <th lay-data="{field:'noticeContent', sort: true,width:450}">内容</th>
		      <th lay-data="{field:'staId', sort: true,width:170,align:'center',templet:'#annexAddTpl'}">发布人</th>
		      <th lay-data="{field:'noticeTime', sort: true,width:150,align:'center'}">发布时间</th>
		    </tr>
		  </thead>
		</table>
		
		<div id="showNotice" style="display: none;padding: 10px;">
			<p style="font-size: 29px;text-align: center;">XXX</p>
			<br />
			<span>XXXXXXXXXXXX</span>
			<hr />
			<p style="text-align: right;color: #2F4056;">XX</p>
			<p style="text-align: right;color: #2F4056;">XXX</p>
		</div>
		
		<script type="text/html" id="noticeTitleTpl">
  			<a href="javascript:show('{{d.noticeId}}');" class="layui-table-link">{{ d.noticeTitle }}</a>
		</script>
		
		<script type="text/javascript">
			var table;//数据表格
			var loadIndex;//加载层
			var ts;//弹出层
			//初始化数据表格
			layui.use('table', function(){
			  table = layui.table;
			  
				//搜索
			  var $ = layui.$, active = {
			    reload: function(){
			    	loadIndex = layer.load();//出现加载层
			    	tableReload();//重载表格的方法
			    	layer.close(loadIndex);//加载层关闭  
			    }
			  };
			  
			  $('#demoTable .layui-btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });
			});
			
			//数据表格重载
			function tableReload(){
				table.reload('tb', {
			        where: {
			        	noticeData: $('#noticeData').val(),
			        	noticeTime:$("#noticeTime").val()
			        }
			      });
			}
			
			//日期框
			layui.use('laydate', function(){
			  var laydate = layui.laydate;
			  laydate.render({
			    elem: '#noticeTime' //指定元素
			    ,theme: 'molv'//样式
			    ,max: 0//最大日期为今天
			    ,range: true//日期范围
			    ,calendar: true//显示节日
			  });
			});
			function show(id){
				var url = "notice/findById.action";
				var data = {"noticeId":id};
				$.post(url, data, function(info){
					$("#showNotice").children("p").eq(0).text(info.noticeTitle);
					$("#showNotice").children("span").html(info.noticeContent);
					$("#showNotice").children("p").eq(1).text(info.staId);
					$("#showNotice").children("p").eq(2).text(info.noticeTime);
				});
				ts =layer.open({
			        type: 1//样式
			        ,area: ['80%', '80%']
			        ,title:'公告详情'//标题
			        ,content: $("#showNotice")
			        ,shade: [0.8, '#393D49'] //显示遮罩
			        ,shadeClose:true//点击也能遮罩层关闭
			        ,anim:2//弹出动画
			      });
			}
		</script>
	</body>
</html>