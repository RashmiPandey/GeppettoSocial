package com.geppetto.sociallogin.interfaces.service;

import com.geppetto.sociallogin.domain.core.GpUser;

/**
 * 
 * @author Rashmi
 *
 */
public interface IGpUserService {


	public GpUser create_user(GpUser user)
			throws Exception;
	
	public GpUser find_user(String username) throws Exception;
}
