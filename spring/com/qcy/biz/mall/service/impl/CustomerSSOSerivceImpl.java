package com.qcy.biz.mall.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qcy.biz.mall.dao.CustomerDAO;
import com.qcy.biz.mall.service.CustomerSSOService;


public class CustomerSSOSerivceImpl implements CustomerSSOService   {
	
	private CustomerDAO customerDAO;
	private Log logger = LogFactory.getLog(getClass());
	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}


	@Override
	public Map<String, String> validateCustomer(Map<String, Object> para) {
		
		logger.info("查询参数为："+para);
		List<Map> result =this.customerDAO.queryCustomerInfo(para);
		logger.info("数据库返回结果："+result);
		Map<String,String> m_result = new HashMap();
		if(result!=null && !result.isEmpty()){
			m_result = result.get(0);
		}
		return m_result;
	}

}
