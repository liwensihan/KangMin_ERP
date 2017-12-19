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
<script src="res/js/jquery-2.1.3.min.js"></script>
<script src="res/layui/layui.js" charset="utf-8"></script>
</head>
<style>
	.mypanel{
		height: 62px;
		width: 98%;
	}
	.mysection{
		margin-bottom: 20px;
		background-color: #fff;
		border: 1px solid transparent;
		border-radius: 4px;
		background: #f2f2f2;
	}
	.mysection-logo{
		height: 45px;
		width: 40%;
		border-radius: 4px 0px 0px 4px;
		display: inline-block;
		text-align: center;
		padding-top: 14px;
	}
	.mysection-value{
		width: 58%;
		text-align: center;
		float: right;
		margin-top: 1px;
		font-size: 21px;
	}
	#noticeTb tbody tr td{
		overflow: hidden; 
		white-space: nowrap; 
		text-overflow: ellipsis;
	}
	#noticeTb tbody a{
		cursor: pointer;
		color:#01AAED;
	}
	#noticeTb tbody a:hover{
		text-decoration:underline;
	}
	.more{
		cursor: pointer;
	}
	.more:hover{
		color: #009688;
	}
</style>
<body>
	<div class="layui-container" style="width: 100%;">  
		<div class="layui-row">
			<div class="layui-col-xs3">
				<div class="mypanel">
					<section class="mysection">
				        <div class="mysection-logo" style="background: #5FB878;">
				        	<i class="layui-icon" style="font-size: 30px;color:white;">&#xe613;</i>
				        </div>
				       	<div class="mysection-value">
				       		<p id="toDay-staff" style="color: #5FB878;">0</p>
							<p style="color: #5FB878;">人员总量</p>
				      	</div>
			    	</section>
		    	</div>
	    	</div>
    		<div class="layui-col-xs3">
      			<div class="mypanel">
					<section class="mysection">
						<div class="mysection-logo" style="background: #FF5722;">
			        		<i class="layui-icon" style="font-size: 30px;color:white;">&#xe68e;</i>
			        	</div>
				       	<div class="mysection-value">
				       		<p id="toDay-annex" style="color: #FF5722;">23</p>
							<p style="color: #FF5722;">分店总量</p>
				      	</div>
		    		</section>
    			</div>
    		</div>
	    	<div class="layui-col-xs3">
	      		<div class="mypanel">
					<section class="mysection">
				        <div class="mysection-logo" style="background: #FFB800;">
				        	<i class="layui-icon" style="font-size: 30px;color:white;">&#xe629;</i>
				        </div>
				       	<div class="mysection-value">
				       		<p id="toDay-sctockmp" style="color: #FFB800;">0</p>
							<p style="color: #FFB800;">今日销售</p>
				      	</div>
				    </section>
	    		</div>
	    	</div>
	    	<div class="layui-col-xs3">
	      		<div class="mypanel">
				<section class="mysection">
			        <div class="mysection-logo" style="background: #01AAED;">
			        	<i class="layui-icon" style="font-size: 30px;color:white;">&#xe63a;</i>
			        </div>
			       	<div class="mysection-value">
			       		<p id="toDay-notice" style="color: #01AAED;">0</p>
						<p style="color: #01AAED;">今日公告</p>
			      	</div>
			    </section>
	    	</div>
	    	</div>
	  	</div>
	</div>
    
    
    <fieldset class="layui-elem-field layui-field-title">
	  <legend><i class="layui-icon" style="font-size: 25px;">&#xe62e;</i>   最新公告</legend>
	</fieldset>
    <table id="noticeTb" class="layui-table" lay-skin="line"  lay-size="sm" style="table-layout: fixed;">
	  <colgroup>
	    <col width="30%">
	    <col width="70%">
	    <col width="60">
	    <col width="130">
	  </colgroup>
	  <thead>
	    <tr>
	      <th>公告标题</th>
	      <th>公告正文</th>
	      <th>发布人</th>
	      <th>发布时间</th>
	    </tr> 
	  </thead>
	  <tbody>
	    
	  </tbody>
	  <tfoot>
	  	<tr>
	  		<td colspan="4">
	  			<i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop">&#xe63d;</i> 
	  			<span class="more">更多</span>
	  		</td>
	  	</tr>
	  </tfoot>
	</table>
    
    <div id="showNotice" style="display: none;padding: 10px;">
		<p style="font-size: 29px;text-align: center;">XXX</p>
		<br />
		<span>XXXXXXXXXXXX</span>
		<hr />
		<p style="text-align: right;color: #2F4056;">XX</p>
		<p style="text-align: right;color: #2F4056;">XXX</p>
	</div>
</body>
<script>
	var layer;
	layui.use('layer', function(){
	  layer = layui.layer;
	});
	$(function(){
		//查询今日公告数量
		var url = "notice/findToDay.action";
		$("#toDay-notice").load(url,null);
		//查询今日订单数量
		url = "sctockmp/findToDay.action";
		$("#toDay-sctockmp").load(url,null);
		//查询所有分店总数量
		url = "annex/findAllSize.action";
		$("#toDay-annex").load(url,null);
		//查询所有人员总数量
		url = "staff/findAllSize.action";
		$("#toDay-staff").load(url,null);
		
		
		//查询公告
		url = "notice/findAll.action";
		var data ={"page":1,"limit":10};
		$.post(url, data, function(info){
			$(info.data).each(function(i,element){
				if(i==0){
					$("#noticeTb tbody").append('<tr><td><span class="layui-badge">最新</span> <a href="javascript:show(&apos;'+element.noticeId+'&apos;);">'+element.noticeTitle+'</a></td><td>'+element.noticeContent+'</td><td>'+element.staId+'</td><td>'+element.noticeTime+'</td></tr>');
				}else{
					$("#noticeTb tbody").append('<tr><td><a href="javascript:show(&apos;'+element.noticeId+'&apos;);">'+element.noticeTitle+'</a></td><td>'+element.noticeContent+'</td><td>'+element.staId+'</td><td>'+element.noticeTime+'</td></tr>');
				}
			});
		});
		
	})
	
	
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
</html>