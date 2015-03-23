package com.qcy.biz.mall.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.qcy.biz.mall.dao.CustomerDAO;


public class CustomerIbatisDAO  extends SqlMapClientDaoSupport  implements CustomerDAO{
	
	@Override
	public List queryCustomerInfo(Map<String, Object> para) {
		List result = this.getSqlMapClientTemplate().queryForList("queryByCustomerName",para);
		return result;
	}

}
