/*package com.sun.curd.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.curd.bean.Department;
import com.sun.curd.bean.Employee;
import com.sun.curd.dao.DepartmentMapper;
import com.sun.curd.dao.EmployeeMapper;


 * ����dao��Ĺ���
 * ʹ��Spring����Ŀ�Ϳ���ʹ��Spring�ĵ�Ԫ���ԣ������Զ�ע��������Ҫ�����
 * 1.����SpringTestģ��
 * 2.@ContextConfigurationָ��Spring�����ļ���λ��
 * 3.@RunWith(SpringJUnit4ClassRunner.class)ָ����Ԫ����
 * 4.autowired ֱ�Ӵ�������
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private SqlSession sqlSession;
	@Test
	public void testCRUD(){
		System.out.println(departmentMapper);
		//departmentMapper.insertSelective(new Department(null,"������"));
		//departmentMapper.insertSelective(new Department(null,"���Բ�"));
		//int insertSelective = employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@atguigu.com",1));
		//employeeMapper.insertSelective(new Employee(null,"Tom","M","Tom@atguigu.com",1));
		//��������
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++){
			String uid=UUID.randomUUID().toString().substring(0, 5);
			mapper.insertSelective(new Employee(null, uid, "M", uid+"atguigu.com", 1));
		}
		System.out.println("��������");
	}
}
*/