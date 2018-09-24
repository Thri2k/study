//总记录数，和当前页数
	var totalRecords;
	var currentNum;

	$(function(){
		
		 to_page(1); 
	});

	 function to_page(page){
		$.ajax({
			url:"${APP_PATH}/getAllEmps",
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
				var checkBoxTd=$("<td><input type='checkbox'  class='check_item'/></td>");
				var empIdTd=$("<td></td>").append(item.empId);
				var empNameTd=$("<td></td>").append(item.empName);
				var genderId=$("<td></td>").append(item.empSex==1?"男":"女");
				var deptNameTd=$("<td></td>").append(item.deptName);
				var empCardTd=$("<td></td>").append(item.empCard);
				var empJobTd=$("<td></td>").append(item.empJob);
				var empAddressTd=$("<td></td>").append(item.empAddress);
				var empTelnumberTd=$("<td></td>").append(item.empTelnumber);
				var empDateTd=$("<td></td>").append(item.empDate);
				var empMoneyTd=$("<td></td>").append(item.empMoney);
			
				var editbtn=$("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
				.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
				//同时给员工的id付给编辑按钮	
				editbtn.attr("edit_id",item.empId);
							
				var delbtn=$("<button></button>").addClass("btn btn-success btn-sm delete_btn")
				.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				//同事给员工的id付给删除按钮
				delbtn.attr("del-id",item.empId);
				
				var bubtn=$("<td></td>")
				.append(editbtn).append(" ").append(delbtn);
				
				$("<tr></tr>").append(checkBoxTd)
				.append(empIdTd)
				.append(empNameTd)
				.append(genderId)
				.append(deptNameTd)
				.append(empCardTd)
				.append(empJobTd)
				.append(empAddressTd)
				.append(empTelnumberTd)
				.append(empDateTd)
				.append(empMoneyTd)
				.append(bubtn)
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
	 
	  /**
	  **点击新增按钮弹出模态框
	  **/
	  function reset_form(ele){
			//只是清空了表单样式
			$(ele)[0].reset();
			//清空表单上次留下来的格式，提示信息
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
	  
	  $("#emp_and_modal_btn").click(function(){
			//清除表单数据（表单重置)
			//reset()是dom中的方法
			//$("#empAddModal form")[0].reset();
			reset_form("#empAddModal form");
			//发送ajax请求查出部门信息,显示在下拉列表中
			getDepts("#dept_add_select"); 
			
			
			$("#empAddModal").modal({
				backdrop:"static"
			});
		});
		/**
		*	获取部门信息
		*/
		function getDepts(ele){
			//每次查询之前先清空一次select
			$(ele).empty();
			
			$.ajax({
				url:"${APP_PATH}/getDepts",
				type:"GET",
				
				success:function(result){
				console.log(result);
				
				//遍历
				 $.each(result.extend.depts,function(index,item){
					 
					 var optionEle=$("<option></option>").append(item.deptName).attr("value",item.deptId);
						
					 optionEle.appendTo(ele);
					
				});
			  }
			});
		}
	  
		/*  URI
			1./emp/{id} GET 查询员工
			2./emp 		POST 保存员工
			3./emp/{id} put 修改员工
			4./emp/{id} delete 删除员工 
		*/
		
		
		function validate_add_form(){
				var empName=$("#empName_add_input").val();
				//var empName=$("#empName_add_input").val();
				
				var regName=/(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
				if(!regName.test(empName)){
					show_validate_msg("#empName_add_input","error","用户名可以使2-5位中文或者6-16位英文或者数字组合");
					return false;
				}else{
					show_validate_msg("#empName_add_input","success","");
					return true;
				}
			
			}
		//每次校验之前都要先进性清空 class
		function show_validate_msg(ele,status,msg){
				//清除当前元素的校验状态
				$(ele).parent().removeClass("has-success has-error");
				$(ele).next("span").text("");
				if("success"==status){
					$(ele).parent().addClass("has-success");
					$(ele).next("span").text(msg);
				}else if("error"==status){
					$(ele).parent().addClass("has-error");
					$(ele).next("span").text(msg);
				}
			}
		//点击保存事件
		 $("#emp_save_btn").click(function(){
			
			 // js检验
			 if(!validate_add_form()){
				 return false;
			 }
			$.ajax({
				url:"${APP_PATH}/addEmp",
				type:"POST",
				data:$("#empAddModal form").serialize(),
				success:function(result){
					//console.log(result);
					 if(result.code==100){
						$("#empAddModal").modal('hide');
						 to_page(totalRecords);  
					}  
				}
			});
		}); 
		
		
		/*
		**员工编译界面
		**弹出
		**/
		/**
			empId将你要编写的页码给更新按钮
		**/
		var empId;
		
		$(document).on("click",".edit_btn",function(){
			//alert("edit");
			
			getDepts("#dept_update_select");
			empId=$(this).attr("edit_id");
			getEmp($(this).attr("edit_id"));
			
			//把员工id传给模态框的更新按钮
			//$("#emp_update_btn").attr("edit-id",$(this).attr("edit_id"));
			//弹出模态框
			$("#empUpdateModal").modal({
				backdrop:"static"
			});
		}); 
		
		/* 
		** 将模态框中的值还原为默认的
		**还原默认值
		*/
		function getEmp(id){
			$.ajax({
				url:"${APP_PATH}/getEmp/"+id,
				type:"GET",
				success:function(result){
					console.log(result);
					 var empData=result.extend.emp;
					$("#empName_update_static").val(empData.empName);
					$("#empSex_update_input").val(empData.empSex);
					$("#empUpdateModal input[name=empSex]").val([empData.empSex]);
					$("#empCard_update_input").val(empData.empCard);
					$("#empAddress_update_input").val(empData.empAddress);
					$("#empDate_update_input").val(empData.empDate);
					$("#deptId_update_input").val(empData.deptId);
					$("#empJob_update_input").val(empData.empJob);
					$("#empMoney_update_input").val(empData.empMoney);
					$("#empTelnumber_update_input").val(empData.empTelnumber);
					$("#empUpdateModal select").val([empData.deptId]);
				}
			});
		}
		/*
		**点击更新按钮
		*/
		$("#emp_update_btn").click(function(){
			$.ajax({
				url:"${APP_PATH}/alterEmp/"+empId,
				type:"PUT",
				data:$("#empUpdateModal form").serialize(),
				success:function(result){
					console.log(result);
					
					$("#empUpdateModal").modal("hide");
					//回到本页面
					to_page(currentNum);
				}
			});
		});
		
		//员工单个删除 因为在每一列的delete按钮都添加了一个 delete_btn clss属性
		//所以请求方法和put差不多 empById
		$(document).on("click",".delete_btn",function(){
			//alert("asss");
			var empName=$(this).parents("tr").find("td:eq(2)").text();
			var empId=$(this).attr("del-id");
			console.log(empId);
			if(confirm("确认删除【"+empName+"】码？")){
				$.ajax({
					url:"${APP_PATH}/empById/"+empId,
					type:"DELETE",
					success:function(result){
						console.log(result.msg);
						to_page(currentNum);
					}
				});
			}
			
		});
		
		//批量删除的功能
		$("#check_all").click(function(){
			//attr获取check是dundefined
			//原生的dom原生的属性，用prop自定义属性的值
			//attr用来选取自定义的属性值
			//alert($(this).prop("checked"));
			$(this).prop("checked");
			$(".check_item").prop("checked",$(this).prop("checked"));
		});
		//check_item批量选择
		$(document).on("click",".check_item",function(){
			//
			var flag=$(".check_item:checked").length==$(".check_item").length;
			$("#check_all").prop("checked",flag);
		});
		
		$("#emp_delete_modal_btn").click(function(){
			//$(".check_item:checked")数组
			var empNames="";
			var del_idstr="";
			//eq索引从0开始
			$.each($(".check_item:checked"),function(){
				var empname=$(this).parents("tr").find("td:eq(2)").text();
				empNames+=empname+",";
				//组装一下id的字符串
				del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
			});
			//出去多余的逗号 ，
			empNames=empNames.substring(0, empNames.length-1);
			//出去多于短横线
			del_idstr=del_idstr.substring(0, del_idstr.length-1);
			if(confirm("确认删除"+empNames+"吗？")){
			
			$.ajax({
				url:"${APP_PATH}/empBatchById/"+del_idstr,
				type:"DELETE",
				success:function(result){
					alert(result.msg);
					to_page(currentNum);
				}
				});
			}
		});