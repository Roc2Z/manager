package manager.common.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manager.common.bean.UserBean;
import manager.common.dao.GenericDao;
import manager.common.logic.BaseLogicIF;

@Service
public class BaseLogicImpl implements BaseLogicIF{
	@Autowired
	private GenericDao genericDao;
	
	@Override
	public String getMessage() {
		return "Hello world";
	}
	
	@Override
	public UserBean getUser(UserBean userLogin) {
		return genericDao.getUser(userLogin);
	}
}
