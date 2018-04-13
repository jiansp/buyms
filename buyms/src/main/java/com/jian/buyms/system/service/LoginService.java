package com.jian.buyms.system.service;

import com.jian.buyms.system.model.Users;

public interface LoginService {
	public Users login(String username, String password) throws Exception;
}
