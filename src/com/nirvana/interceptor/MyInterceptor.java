package com.nirvana.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.nirvana.action.InterceptorAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {

	@Override
	public void destroy() {
		System.out.println("MyInterceptor destory()...");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("MyInterceptor init()...");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		InterceptorAction action = (InterceptorAction) invocation.getAction();
		ActionContext context = invocation.getInvocationContext();
		Map<String, Object> params = context.getContext().getParameters();
		String[] ids = (String[]) params.get("id");
		
		if("1".equals(ids[0])) {
			action.execute();
		}
		
		System.out.println("MyInterceptor intercept()...");
		return "success";
	}

}
