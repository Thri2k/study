package com.sun.curd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.SynthesizingMethodParameter;
import org.springframework.stereotype.Service;

import com.sun.curd.bean.Employee;
import com.sun.curd.dao.EmployeeMapper;

@Service
public class EmpService {

	@Autowired EmployeeMapper employeeMapper;
	/**
	 * 1.查询所有的员工
	 * @return
	 */
	public List<Employee> getAllEmpsMassage() {
		List<Employee> selectByExample = employeeMapper.selectByExample(null);
		
		return selectByExample;
		// TODO Auto-generated method stub
		
	}
	/**
	 * 获取主键对应的信息
	 * @param id
	 * @return
	 */
	public Employee getEmp(Integer id) {
		Employee selectByPrimaryKey = employeeMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}
	/**
	 * 员工更新
	 * @param employee
	 */
	public void alter(Employee employee) {
		// TODO Auto-generated method stub
		
		employeeMapper.updateByPrimaryKey(employee);
		}
	/**
	 * 单独员工删除
	 * @param id
	 */
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		employeeMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 员工批量删除
	 * @param list
	 */
	public void deleteBatch(List<Integer> list) {
		// TODO Auto-generated method stub
		System.out.println("开始删除");
		boolean b = employeeMapper.deleteBatch(list);
		System.out.println(b);
	}
	/**
	 * 增加员工
	 * @param employee
	 */
	public void addEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.insert(employee);
	}
	
	//获取这个部门的所有员工
	public List<Employee> getDepartmentEmpsMassage(String Dname) {
		
		List<Employee> selectDepartEmps = employeeMapper.selectDepartEmps(Dname);
		for (Employee employee : selectDepartEmps) {
			System.out.println(employee);
		}
		return selectDepartEmps;
	}

}
