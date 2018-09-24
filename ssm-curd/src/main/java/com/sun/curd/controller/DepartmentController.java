package com.sun.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.curd.bean.Department;
import com.sun.curd.bean.Msg;
import com.sun.curd.service.deptService;

/**
 * 处理和部门有关的请求
 * @author sz
 *
 */
@Controller
public class DepartmentController {
	
	@Autowired
	private deptService deptService;
	
	@RequestMapping("/getDepts")
	@ResponseBody
	public Msg getDepts(){
		
		List<Department> list = deptService.getDepts();
		//System.out.println("111");
		return Msg.success().add("depts", list);
	}
	
	
}
