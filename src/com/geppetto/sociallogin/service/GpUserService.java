package com.geppetto.sociallogin.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.geppetto.sociallogin.dao.mysql.GpUserDao;
import com.geppetto.sociallogin.domain.core.GpUser;
import com.geppetto.sociallogin.interfaces.service.IGpUserService;

/**
 * 
 * @author Rashmi
 *
 */

@Service("GpUserService")
public class GpUserService implements IGpUserService {

	private GpUserDao gpuser_Dao;

	public GpUserDao getGpuser_Dao() {
		return gpuser_Dao;
	}

	@Resource(name = "GpUserDao")
	public void setGpuser_Dao(GpUserDao gpuser_Dao) {
		this.gpuser_Dao = gpuser_Dao;
	}

	@Override
	public GpUser find_user(String username) throws Exception {
		System.out.println("UserService - find user");

		return this.gpuser_Dao.findUser(username);
	}

	@Override
	public GpUser create_user(GpUser gpuser_Dao) throws Exception {
		System.out.println("UserService - create user");

		return this.gpuser_Dao.insert(gpuser_Dao);
	}

}
