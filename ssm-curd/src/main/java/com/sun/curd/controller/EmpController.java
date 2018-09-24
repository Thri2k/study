package com.sun.curd.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.curd.bean.Department;
import com.sun.curd.bean.Employee;
import com.sun.curd.bean.Msg;
import com.sun.curd.service.EmpService;
import com.sun.curd.service.deptService;

/**
 * 
 * @author sz
 *
 */
@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	@Autowired
	private deptService depts;
	
	private String Dname="������";
	/**
	 * ���ĳ�����Ž����л�������Ϣ
	 * @param text
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="/getDname")
	@ResponseBody
	public Msg getDname(@RequestParam(value="text",defaultValue="������") String text,Model model) throws UnsupportedEncodingException{
		
		text=new String(new String(text.getBytes("iso-8859-1"),"UTF-8"));
		System.out.println(text);
		Dname=text;
		return Msg.success();
		
	}
	
	/**
	 * ��ò��ŵĳ�Ա
	 * @param page
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value="/getDepartmentEmps")
	@ResponseBody
	public Msg getDepartmentEmps(@RequestParam(value="page",defaultValue="1") Integer page,Model model){
		
		
		
		PageHelper.startPage(page, 5);
		
		List<Employee> list = empService.getDepartmentEmpsMassage(Dname);
		
		PageInfo<Employee> pageInfo=new PageInfo<>(list,5);
		
		
		return Msg.success().add("page", pageInfo);
	}
	
	
	/**
	 * ��ȡԱ���ܼ�¼��
	 * ׼����ҳ��
	 * @param page
	 * @param model
	 * @return
	 */
	
	
	
	@RequestMapping("/getAllEmps")
	@ResponseBody
	public Msg AllEmps(@RequestParam(value="page",defaultValue="1") Integer page,Model model){
		
		PageHelper.startPage(page, 5);
		
		List<Employee> list = empService.getAllEmpsMassage();
		
		PageInfo<Employee> pageInfo=new PageInfo<>(list,5);
		
		
		return Msg.success().add("page", pageInfo);
		
	}
	/*@RequestMapping(value="/addEmp",method=RequestMethod.POST)
	@ResponseBody
	public Msg addEmp(HttpServletRequest request,HttpServletResponse response){
		String empName=request.getParameter("empName");
		Integer empSex=Integer.parseInt(request.getParameter("empSex"));
		String deptName=request.getParameter("deptName");
		Integer deptId=Integer.parseInt(request.getParameter("deptId"));
		String empCard=request.getParameter("empCard");
		String empJob=request.getParameter("empJob");
		String empAddress=request.getParameter("empAddress");
		String empTelnumber=request.getParameter("empTelnumber");
		String empDate=request.getParameter("empDate");
		Integer empMoney=Integer.parseInt(request.getParameter("empMoney"));
		Employee employee=new Employee(empName, empSex, deptName, deptId, empCard, empJob, empAddress, empMoney, empDate, empTelnumber);
		System.out.println(employee);
		return Msg.success();}*/
	/**
	 * ���Ա��׼��
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/addEmp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(Employee employee){
		String deptName;
		deptName = depts.selectDept(employee.getDeptId());
		employee.setDeptName(deptName);
		empService.addEmp(employee);
		
		return Msg.success();
	}
	/**
	 * ��ȡԱ����Ϣ��׼����ԭ
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getEmp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id") Integer id){
		Employee employee = empService.getEmp(id);
		return Msg.success().add("emp", employee);
	}
	
	/**
	 * ������°�ť��׼������
	 */
	@RequestMapping(value="/alterEmp/{empId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg alterEmp(Employee employee){
		
		String deptName;

		deptName = depts.selectDept(employee.getDeptId());
		
		employee.setDeptName(deptName);
		
		empService.alter(employee);
		return Msg.success();
	}
	
	/**
	 * ����ɾ��һ��Ա��id�ģ�ÿ�к����ɾ����
	 * delete
	 */
	@RequestMapping(value="/empById/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteEmById(@PathVariable("id")Integer id){
		empService.delete(id);
		return Msg.success();
	}
	/**
	 * ����ɾ�����Id��
	 * �Ǹ���ɾ���ܶ�ĵ�һ�е�ɾ����
	 */
	@RequestMapping(value="/empBatchById/{ids}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteEmBatchById(@PathVariable("ids")String ids){
		//id����һ����ʱ��
		if(ids.contains("-")){
			List<Integer> list=new ArrayList<>();
			String[] str_ids = ids.split("-");
			for (String id : str_ids) {
				int parse = Integer.parseInt(id);
				list.add(parse);
			}
			empService.deleteBatch(list);
		}else{
			int id = Integer.parseInt(ids);
			empService.delete(id);
		}
		
		return Msg.success();
	}
}
