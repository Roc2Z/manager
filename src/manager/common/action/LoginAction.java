package manager.common.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import manager.common.bean.InfoValue;
import manager.common.bean.UserBean;
import manager.common.logic.BaseLogicIF;

@Controller
public class LoginAction {
	@Autowired
	private BaseLogicIF baseLogic;
	
	private InfoValue info = new InfoValue();
	
	private UserBean user = new UserBean();
	
	@Action(value="/login"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			,results={
				@Result(name="success",location="LOGIN",type="tiles")
				, @Result(name="failure",location="LOGIN", type="tiles")
			})
	public String login() {
		info = new InfoValue();
		return "success";
	}
	
	@Action(value="/logon"
			, interceptorRefs={
				@InterceptorRef(value="scope",params={"key","infoValue","session","info","autoCreateSession","true"})
				, @InterceptorRef("basicStack")
			}
			,results={
				@Result(name="success",location="ADV01_init",type="redirectAction")
				, @Result(name="failure",location="LOGIN", type="tiles")
			})
	public String logon(){
		UserBean userLogon = baseLogic.getUser(user);
		if (userLogon == null) {
			info.setMessage("User Id không đúng");
			return "failure";
		} else {
			info.setUser(user);
			return "success";
		}
	}

	public InfoValue getInfo() {
		return info;
	}

	public void setInfo(InfoValue info) {
		this.info = info;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	
	
}
