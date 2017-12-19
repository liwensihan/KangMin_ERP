<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.contextPath }/">
		<link rel="stylesheet" href="res/layui/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/layui/layui.js"></script>
<title>Insert title here</title>
	

</head>
<body>
	<form class="layui-form" action="">
  <div class="layui-form-item">
    <label class="layui-form-label">单选框</label>
    <div class="layui-input-block">
      <input name="sex" value="男" title="男" checked="" type="radio">
      <input name="sex" value="女" title="女" type="radio">
      <input name="sex" value="禁" title="禁用" disabled="" type="radio">
    </div>
  </div>
  </form>
  <script type="text/javascript">
  layui.use('form', function(){
	  var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
	  
	  //……
	  
	  //但是，如果你的HTML是动态生成的，自动渲染就会失效
	  //因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
	  form.render();
	});      
  </script>
</body>
</html>