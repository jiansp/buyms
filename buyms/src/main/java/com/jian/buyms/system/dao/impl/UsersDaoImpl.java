package com.jian.buyms.system.dao.impl;

import com.jian.buyms.system.dao.UsersDao;
import com.jian.buyms.system.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoImpl extends BaseDaoImpl implements UsersDao {
	public Users getUserInfo(String username) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("from Users where username=:username");
		List<Users> users = this.findByNamedParam(sql.toString(), new String[]{"username"}, new Object[]{username});
		
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		
		return null;
	}

	
}
