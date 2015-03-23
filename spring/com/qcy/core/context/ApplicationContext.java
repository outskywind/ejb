package com.qcy.core.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContext {
	
	private static ClassPathXmlApplicationContext coreContext ;
	
	
	static{
		coreContext = new ClassPathXmlApplicationContext("core-context.xml");
		
		
	}

}
