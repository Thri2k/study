package com.sun.curd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.curd.bean.Department;
import com.sun.curd.dao.DepartmentMapper;

@Service
public class deptService {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public List<Department> getDepts() {
			List<Department> selectByExample = departmentMapper.selectByExample(null);
		return selectByExample;
	}

	public String selectDept(int deptId) {
		// TODO Auto-generated method stub
		System.out.println(deptId+"*****");
		Department selectByPrimaryKey = departmentMapper.selectByPrimaryKey(deptId);
		System.out.println("----------");
		System.out.println(selectByPrimaryKey.getDeptName());
		return selectByPrimaryKey.getDeptName();
	}
	
}
