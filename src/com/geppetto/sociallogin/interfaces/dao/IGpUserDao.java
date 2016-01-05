package com.geppetto.sociallogin.interfaces.dao;

import com.geppetto.sociallogin.domain.core.GpUser;

/**
 * 
 * @author Rashmi
 *
 */
public interface IGpUserDao {
	public abstract GpUser insert(GpUser user) throws Exception;
	public abstract GpUser findUser(String username) throws Exception;
}
