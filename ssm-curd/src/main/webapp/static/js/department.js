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