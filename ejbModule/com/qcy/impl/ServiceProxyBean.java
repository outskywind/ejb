package com.qcy.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.qcy.remote.ServiceProxy;

@Stateless
@Remote(ServiceProxy.class)
public class ServiceProxyBean implements ServiceProxy{
	
	//非单例提升性能,EJB 静态变量应该是final <ejb 规范>
	private final static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("biz-context.xml");
	@Override
	public Map handleRequest(Map mi) {
		//the spring service bean name ,use the fined bean definition class to invoke the true method.
		// this is the reflection method to solve the problem
		String serviceName = (String) mi.get("serviceName");
		String methodName = (String)mi.get("methodName");
		Class[] parameterTypes = (Class[])mi.get("parameterTypes");
		Object[] parameterValues=(Object[])mi.get("parameterValues");
		Object object = context.getBean(serviceName);
		Map result = new HashMap();
		try {
			Method m = object.getClass().getMethod(methodName, parameterTypes);
			Object _result = m.invoke(object, parameterValues);
			result.put("resultCode", "0");
			result.put("result", _result);
			return result;
			
		} catch (SecurityException e) {
			result.put("resultCode", "-1");
			e.printStackTrace();
			return result;
		} catch (NoSuchMethodException e) {
			result.put("resultCode", "-1");
			e.printStackTrace();
			return result;
		} catch (IllegalArgumentException e) {
			result.put("resultCode", "-1");
			e.printStackTrace();
			return result;
		} catch (IllegalAccessException e) {
			result.put("resultCode", "-1");
			e.printStackTrace();
			return result;
		} catch (InvocationTargetException e) {
			result.put("resultCode", "-1");
			e.printStackTrace();
			return result;
		}
		
		
	}
	
	//ejb 是池化的，非单例的

}
