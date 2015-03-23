package com.qcy.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.qcy.remote.HelloService;

/**
 * Session Bean implementation class HelloService
 */
@Stateless(mappedName = "HelloService")
@Remote(HelloService.class)
public class HelloServiceBean implements HelloService {

    /**
     * Default constructor. 
     */
    public HelloServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "hello world ";
	}

}
