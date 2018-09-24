<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>



<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-3.2.1.min.js"></script>

<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


</head>
<body>
<!-- ${APP_PATH }/getDepartment -->
		
		
		<div id="all" style="width: 75%; height: 1000px; margin: 0 auto;">
		<!-- 员工增加初始值 -->
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<h1><span id="dtext"></span>部门所有员工信息展示</h1>
				</div>
			</div>

			 <div class="row">
				<div class="col-md-5 col-md-offset-7">
					<button type="button" class="btn btn-primary"><a href="#" class="dname">开发部</a></button>
					<button type="button" class="btn btn-success"><a href="#" class="dname">测试部</a></button>
					<button type="button" class="btn btn-info"><a href="#" class="dname">财务部</a></button>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<table class="table table-hover" id="table_emp">
						<thead>
							<!-- <th><input type="checkbox" id="check_all"></th> -->
							
							<th>姓名</th>
							<th>性别</th>
							<th>身份证号</th>
							<th>职位</th>
							<th>地址</th>
							<th>电话</th>
							<th>入职时间</th>
							<th>工资/月</th>
							
						</thead>
						<tbody></tbody>
					</table>
				</div>
			</div>
			<div class="row">

				<div class="col-md-6" id="page_record_area"></div>
				<div class="col-md-6" id="page_nav_area"></div>

			</div> 


		</div>
</body>
<script type="text/javascript">
$(function(){
	$(".dname").click(function(){
		var text=$(this).text();
		
		console.log(text);
		$.ajax({
			url:"${APP_PATH}/getDname",
			data:"text="+text,
			type:"GET",
			success:function(result){
				console.log(result);
				$("#dtext").text(text);
				 to_page(1); 
			}
		});
	})
	 to_page(1); 
});

function to_page(page,text){
	$.ajax({
		url:"${APP_PATH}/getDepartmentEmps",
		data:"page="+page,
		type:"GET",
		success:function(result){
			console.log(result);
			build_emps_table(result);
			build_page_record(result);
			build_page_nav(result)
		}
	});
} 
/**
*显示表格数据
*/
function build_emps_table(result){
		//每次请求之前都要先进行清空
		$("#table_emp tbody").empty();
		var emps=result.extend.page.list;
		$.each(emps,function(index,item){
			/* var checkBoxTd=$("<td><input type='checkbox'  class='check_item'/></td>"); */
			var empIdTd=$("<td></td>").append(item.empId);
			var empNameTd=$("<td></td>").append(item.empName);
			var genderId=$("<td></td>").append(item.empSex==1?"男":"女");
			/* var deptNameTd=$("<td></td>").append(item.deptName); */
			var empCardTd=$("<td></td>").append(item.empCard);
			var empJobTd=$("<td></td>").append(item.empJob);
			var empAddressTd=$("<td></td>").append(item.empAddress);
			var empTelnumberTd=$("<td></td>").append(item.empTelnumber);
			var empDateTd=$("<td></td>").append(item.empDate);
			var empMoneyTd=$("<td></td>").append(item.empMoney);
		
			
			
			$("<tr></tr>").append(empNameTd)
			.append(genderId)
			.append(empCardTd)
			.append(empJobTd)
			.append(empAddressTd)
			.append(empTelnumberTd)
			.append(empDateTd)
			.append(empMoneyTd)
			.appendTo("#table_emp tbody");
		});
	}
	/**
	*页面记录的基本信息
	*/
	function build_page_record(result){
		 $("#page_record_area").empty();
		 $("#page_record_area").append("当前是第"+result.extend.page.pageNum+"页"+" "+
				 "总共有"+result.extend.page.pages+"页"+" "+
				 "总共有"+result.extend.page.total+"记录");
		 
		 totalRecords=result.extend.page.total;
		 currentNum=result.extend.page.pageNum;
	}
	/**
	*	分页区域
	**/
	function  build_page_nav(result){
		 $("#page_nav_area").empty();
		 var ul=$("<ul></ul>").addClass("pagination");
		 var firstPageLi=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
		 var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;"));
		 if(result.extend.page.hasPreviousPage==false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				firstPageLi.click(function(){
					to_page(1);
				});
				
				prePageLi.click(function(){
					to_page(result.extend.page.pageNum-1);
				});
		 }
		 
		 var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;"));
		 var lastPageLi=$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
		 
		 if(result.extend.page.hasNextPage==false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else{
				 nextPageLi.click(function(){
					to_page(result.extend.page.pageNum+1);
				}); 
				
				 lastPageLi.click(function(){
					to_page(result.extend.page.pages);
				});
			}
		  
		 ul.append(firstPageLi).append(prePageLi);
		 $.each(result.extend.page.navigatepageNums,function(index,item){
				var numLi=$("<li></li>").append($("<a></a>").append(item));
				if(result.extend.page.pageNum == item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					to_page(item);
				});
				ul.append(numLi);
			});
		 
		 ul.append(nextPageLi).append(lastPageLi);
		 
		 var navEle=$("<nav></nav>").append(ul);
		 navEle.appendTo("#page_nav_area");
	}
</script>
</html>