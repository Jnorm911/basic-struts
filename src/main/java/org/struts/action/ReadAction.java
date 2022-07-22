package org.struts.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.struts.model.User;
import org.struts.dao.AdminDB;

import com.opensymphony.xwork2.ActionSupport;

public class ReadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	ResultSet rs = null;
	User bean = null;
	List<User> beanList = null;
	AdminDB admin = new AdminDB();
	private boolean noData = false;

	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<User>();
			rs = admin.readUser();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new User();
					bean.setUserName(rs.getString("username"));
					bean.setEmail(rs.getString("email"));
					bean.setAge(rs.getInt("age"));
					bean.setPassword(rs.getString("password").replaceAll("(?s).", "*"));
					beanList.add(bean);
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "READUSER";
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<User> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<User> beanList) {
		this.beanList = beanList;
	}
}