<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="res/js/css/layui.css">
		<script src="res/js/jquery-2.1.3.min.js" type="text/javascript" ></script>
		<script src="res/js/layui.js"></script>
  		<link rel="stylesheet" href="res/layui/css/global.css">

</head>
<body>

<div class="header">
  <div class="main">
     <div class="nav">
        <a href="staff/findAllModel.action;"><i class="iconfont icon-tuichu" style="top: 0; font-size: 22px;"></i>返回</a>
      </div>
    <div class="nav">
      
    </div>
    
    <div class="nav-user">      
      <!-- 登入后的状态 -->
      
      <a class="avatar">
        <img src="${staff.staImg }">
        <cite>${staff.staName }</cite>
      </a>
      <div class="nav">
        <a href="javascript:logout();"><i class="iconfont icon-tuichu" style="top: 0; font-size: 22px;"></i>退了</a>
      </div>
      
    </div>
  </div>
</div>

<div class="main fly-user-main layui-clear">
  <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
    
    <li class="layui-nav-item layui-this">
      <a href="set.html">
        <i class="layui-icon">&#xe620;</i>
        基本设置
      </a>
    </li>
   
  </ul>
  
  <div class="site-tree-mobile layui-hide">
    <i class="layui-icon">&#xe602;</i>
  </div>
  <div class="site-mobile-shade"></div>
  
  <div class="fly-panel fly-panel-user" pad20>
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title" id="LAY_mine">
        <li class="layui-this" lay-id="info">我的资料</li>
        <li lay-id="avatar">头像</li>
        <li lay-id="pass">密码</li>
      </ul>
      <div class="layui-tab-content" style="padding: 20px 0;">
        <div class="layui-form layui-form-pane layui-tab-item layui-show">
          <form method="post" class="layui-form" id="oneFrom">
          	<input type="hidden" value="${staff.staId }" name="staId">
            <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">账号</label>
              <div class="layui-input-inline">
                <input type="text" id="L_email" name="staEmail" required lay-verify="staEmail|phone" autocomplete="off" value="${staff.staEmail }" class="layui-input">
              </div>
            </div>
            <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">姓名</label>
              <div class="layui-input-inline">
                <input type="text" id="L_username" name="staName" required lay-verify="required" autocomplete="off" value="${staff.staName }" class="layui-input">
              </div>
              <div class="layui-inline">
                <div class="layui-input-inline">
                  <input type="radio" name="staSex" value="男" ${staff.staSex == "男"?'checked':''} title="男">
                  <input type="radio" name="staSex" value="女" ${staff.staSex == "女"?'checked':''} title="女">
                </div>
              </div>
            </div>
            <div class="layui-form-item">
              <label class="layui-form-label">年龄</label>
			    <div class="layui-input-inline">
			      <select name="staAge" id="staAge" lay-search="">
			          <option value="">选择您的年龄</option>
			          <option value="18" ${staff.staAge == "18"?'selected':''}>18</option>
			          <option value="19" ${staff.staAge == "19"?'selected':''}>19</option>
			          <option value="20" ${staff.staAge == "20"?'selected':''}>20</option>
			          <option value="21" ${staff.staAge == "21"?'selected':''}>21</option>
			          <option value="22" ${staff.staAge == "22"?'selected':''}>22</option>
			          <option value="23" ${staff.staAge == "23"?'selected':''}>23</option>
			          <option value="24" ${staff.staAge == "24"?'selected':''}>24</option>
			          <option value="25" ${staff.staAge == "25"?'selected':''}>25</option>
			          <option value="26" ${staff.staAge == "26"?'selected':''}>26</option>
			          <option value="27" ${staff.staAge == "27"?'selected':''}>27</option>
			          <option value="28" ${staff.staAge == "28"?'selected':''}>28</option>
			          <option value="29" ${staff.staAge == "29"?'selected':''}>29</option>
			          <option value="30" ${staff.staAge == "30"?'selected':''}>30</option>
			          <option value="31" ${staff.staAge == "31"?'selected':''}>31</option>
			          <option value="32" ${staff.staAge == "32"?'selected':''}>32</option>
			          <option value="33" ${staff.staAge == "33"?'selected':''}>33</option>
			          <option value="34" ${staff.staAge == "34"?'selected':''}>34</option>
			          <option value="35" ${staff.staAge == "35"?'selected':''}>35</option>
			          <option value="36" ${staff.staAge == "36"?'selected':''}>36</option>
			          <option value="37" ${staff.staAge == "37"?'selected':''}>37</option>
			          <option value="38" ${staff.staAge == "38"?'selected':''}>38</option>
			          <option value="39" ${staff.staAge == "39"?'selected':''}>39</option> 
			          <option value="40" ${staff.staAge == "40"?'selected':''}>40</option>
			      </select>
			    </div>
            </div>
            <div>
              <button class="layui-btn" key="set-mine" lay-filter="oneFrom" lay-submit>确认修改</button>
            </div>
            </form>
          </div>
          
          
          <div class="layui-form layui-form-pane layui-tab-item">
            <div class="layui-form-item">
              <div class="avatar-add">
                <p>建议尺寸168*168，支持jpg、png、gif，最大不能超过30KB</p>
                <div class="upload-img">
                  <input type="file" name="file" id="LAY-file" lay-title="上传头像">
                </div>
                <img src="${staff.staImg }">
                <span class="loading"></span>
              </div>
            </div>
          </div>
          
          <div class="layui-form layui-form-pane layui-tab-item">
            <form method="post" id="twoFrom">
            <input type="hidden" value="${staff.staId }" name="staId">
              <div class="layui-form-item">
                <label for="L_nowpass" class="layui-form-label">当前密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_nowpass" name="nowpass" required lay-verify="nowpass|required" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">新密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="staPwd" name="staPwd" required lay-verify="required|staPwd" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
              </div>
              <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">确认密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="QRpwd" name="QRpwd" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <button class="layui-btn" key="set-mine" lay-filter="twoFrom" lay-submit>确认修改</button>
              </div>
            </form>
          </div>
          
          
        </div>

      </div>
    </div>
  </div>

<div class="footer">
  <p><a href="http://fly.layui.com/">Fly社区</a> 2017 &copy; <a href="http://www.layui.com/">layui.com</a></p>
  <p>
    <a href="http://fly.layui.com/auth/get" target="_blank">产品授权</a>
    <a href="http://fly.layui.com/jie/8157.html" target="_blank">获取Fly社区模版</a>
    <a href="http://fly.layui.com/jie/2461.html" target="_blank">微信公众号</a>
  </p>
</div>
<script>



layui.cache.page = 'user';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '../../res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "2.0.0"
  ,base: 'res/mods/'
}).extend({
  fly: 'index'
}).use('fly');


function logout(){
	layer.confirm('是否立即注销?', {icon: 3, title:'注销'}, function(index){
		layer.close(index);
		url="staff/deleteSession.action";
		$.post(url,null,function(m){
			location.href="page/login.jsp";
		});
	});
}
</script>

</body>
</html>