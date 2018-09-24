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
	 * 1.��ѯ���е�Ա��
	 * @return
	 */
	public List<Employee> getAllEmpsMassage() {
		List<Employee> selectByExample = employeeMapper.selectByExample(null);
		
		return selectByExample;
		// TODO Auto-generated method stub
		
	}
	/**
	 * ��ȡ������Ӧ����Ϣ
	 * @param id
	 * @return
	 */
	public Employee getEmp(Integer id) {
		Employee selectByPrimaryKey = employeeMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}
	/**
	 * Ա������
	 * @param employee
	 */
	public void alter(Employee employee) {
		// TODO Auto-generated method stub
		
		employeeMapper.updateByPrimaryKey(employee);
		}
	/**
	 * ����Ա��ɾ��
	 * @param id
	 */
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		employeeMapper.deleteByPrimaryKey(id);
	}
	/**
	 * Ա������ɾ��
	 * @param list
	 */
	public void deleteBatch(List<Integer> list) {
		// TODO Auto-generated method stub
		System.out.println("��ʼɾ��");
		boolean b = employeeMapper.deleteBatch(list);
		System.out.println(b);
	}
	/**
	 * ����Ա��
	 * @param employee
	 */
	public void addEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.insert(employee);
	}
	
	//��ȡ������ŵ�����Ա��
	public List<Employee> getDepartmentEmpsMassage(String Dname) {
		
		List<Employee> selectDepartEmps = employeeMapper.selectDepartEmps(Dname);
		for (Employee employee : selectDepartEmps) {
			System.out.println(employee);
		}
		return selectDepartEmps;
	}

}
