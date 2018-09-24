<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业信息展示</title>
<%
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>

<!-- web路径：
	不以/开始的相对路径，找资源，是以当前资源路径为基准，经常容易出现问题
	以/开始的相对路径，找资源，以服务器路径为标准（http://localhost:3306)
				需要加上项目名称（http://localhost:3306/ssm_curd)

 -->

<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-3.2.1.min.js"></script>

<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
	
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="${APP_PATH }/static/css/all.css" >

<script type="text/javascript" src="${APP_PATH }/static/easyui/jquery.min.js" ></script>
<script type="text/javascript" src="${APP_PATH }/static/easyui/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" src="${APP_PATH }/static/easyui/jquery.easyui.min.js" ></script>
<link rel="stylesheet" href="${APP_PATH }/static/easyui/themes/black/easyui.css" />
<link rel="stylesheet" href="${APP_PATH }/static/easyui/themes/icon.css">
</head>
<body onload="showLeftTime()">
	<div id="first">
			<div id="topfirst">
				<div id="topfirstleft">
					<h2>企业人员管理系统</h2>
				</div>
				<div id="topfirstright">
					<ol class="breadcrumb">
					  <li class="active"><a href="${APP_PATH}/index.jsp">切换账号</a></li>
					  <li><a href="#">修改密码</a></li>
					
					</ol>
				</div>
			</div>
			<div id="bottonfirst" >
					<ul class="nav nav-pills">
					 <li role="presentation" class="active"><a href="${APP_PATH}/sourceViews/all.jsp">主页</a></li>
					  <li role="presentation"><a href="#">财务管理</a></li>
					  <li role="presentation"><a href="#">生产管理</a></li>
					  <li role="presentation" class="dropdown">
					    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
					      系统管理 <span class="caret"></span>
					    </a>
					    <ul class="dropdown-menu">
					  	 <li><a href="#">系统维护</a></li>
				            <li><a href="#">系统信息</a></li>
				            <li><a href="#">系统创作人</a></li>
				            <li role="separator" class="divider"></li>
				            <li><a href="#">系统投资人</a></li>
				            <li role="separator" class="divider"></li>
				            <li><a href="#">系统</a></li>
					    </ul>
					  </li>
					</ul>
			</div>
			<div id="status" style="background-color: #985F0D;height: 25px;">
		    	<div style="height: 25px; line-height: 25px; float: left;">当前用户名称：<span id="root">admin</span></div>
		    	<div style="height: 25px; line-height: 25px; float: right;">当前时间：<span id="show">2017:12:30</span></div>
		    </div>
		</div>
		
	
		<div id="middle" >
		
		
			<div id="middleleft">
			
		<div class="container" style="margin-left: 0px;">
            <div class="col-xs-3 panel-group" id="accordion">
              <div class="panel panel-success">
                <div class="panel-heading">
                  <h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" >企业人员管理 </a></h4>
                  
                </div>
                <div id="collapseOne" class="panel-collapse collapse ">
                  <div class="panel-body">

                    <div class="list-group">
                       <a href="#" class="list-group-item " id="loadData">
                          <h4 class="list-group-item-heading" >
                             企业全部员工查询
                          </h4>
                       </a>
                       <a href="#" class="list-group-item"  id="loadData1">
                          <h4 class="list-group-item-heading">
                             部门员工信息查询
                          </h4>
                       </a>
                       <a href="#" class="list-group-item">
                          <h4 class="list-group-item-heading">
                            本人信息查询
                          </h4>
                       </a>
                        <a href="#" class="list-group-item">
                          <h4 class="list-group-item-heading">
                            个别员工查询
                          </h4>
                       </a>
                    </div>
                  </div>
                </div>
              </div>

              <div class="panel panel-success">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                      href="#collapseTwo">
                      公司简介 </a>
                  </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse ">
                  <div class="panel-body">

                    <div class="list-group">
                        <a href="#" class="list-group-item ">
                          <h4 class="list-group-item-heading">
                             公司行情
                          </h4>
                       </a>
                       <a href="#" class="list-group-item ">
                          <h4 class="list-group-item-heading">
                             公司主营业务
                          </h4>
                       </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
        </div>
			</div>
			<div id="middleright" style="border: 1px solid;background-color: white;height: 1000px;">
			

			
			</div>
		</div>
    

		<div id="third"></div>
		
		
</body>
<script type="text/javascript">

//获得当前时间,刻度为一千分一秒
	window.onload = function() {
	  var show = document.getElementById("show");
	  setInterval(function() {
	   var time = new Date();
	   // 程序计时的月从0开始取值后+1
	   var m = time.getMonth() + 1;
	   var t = time.getFullYear() + "-" + m + "-"
	     + time.getDate() + " " + time.getHours() + ":"
	     + time.getMinutes() + ":" + time.getSeconds();
	   show.innerHTML = t;
	  }, 1000);
 };


$("#loadData").click(function(){ 

	$("#middleright").load("${APP_PATH}/sourceViews/employee.jsp "); 
		return false;   
});
$("#loadData1").click(function(){ 
	 
      $("#middleright").load("${APP_PATH}/sourceViews/deparment.jsp "); 
	return false;   
});
$("#loadData2").click(function(){ 

	$("#middleright").load("${APP_PATH}/sourceViews/person.jsp "); 
	return false;   
});
	
</script>
</html>