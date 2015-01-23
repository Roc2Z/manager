package manager.common.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import manager.common.bean.UserBean;

@Repository
public class GenericDao {
	private static final String LIST_USER = "listUser";
	
	private static final String GET_USER = "getUser";
	
	private  String namespace;
	
	@Autowired
	private SqlSessionTemplate managerAppsSqlSession;
	
	public GenericDao() {
		setNamespace("manager.common.dao.GenericDao");
	}
	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	public List<UserBean> listUser() {
		String query = namespace + "." + LIST_USER;
		return managerAppsSqlSession.selectList(query, null);
	}
	
	public UserBean getUser(UserBean user) {
		String query = namespace +"."+GET_USER;
		return managerAppsSqlSession.selectOne(query, user);
	}
}
