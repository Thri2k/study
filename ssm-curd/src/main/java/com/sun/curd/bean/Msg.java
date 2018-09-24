package com.sun.curd.bean;

import java.util.HashMap;
import java.util.Map;

/*
 * 返回通用的json数据的类，应为json返回的都是字符
 */
public class Msg {
	
	//状态码 100 成功 200 失败
	private int code;
	//提示信息
	private String msg;
	
	//用户要返回给浏览器的信息，装配在一个map集合中
	private Map<String,Object> extend=new HashMap<>();
	
	//
	public static Msg success(){
		Msg result=new Msg();
		result.setCode(100);
		result.setMsg("处理成功!");
		return result;
	}
	
	public static Msg fail(){
		Msg result=new Msg();
		result.setCode(200);
		result.setMsg("处理失败!");
		return result;
	}
	
	//实现一个可以add的链式操作，添加一个map，将数据放在请求域中
	public Msg add(String key,Object value){
		 this.getExtend().put(key, value);
		 return this;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	
}
