package com.geppetto.sociallogin.dao.mysql.support.configuration;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.geppetto.sociallogin.domain.core.GpUser;
/**
 * 
 * @author Rashmi
 *
 */
public class GpUserRowMapper implements RowMapper<GpUser> {

	@Override
	public GpUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		GpUser user = new GpUser();
		user.setId(rs.getLong("ID"));
		user.setUsername(rs.getString("USER_NAME"));
		user.setPassword(rs.getString("PASSWORD"));
		return user;
	}

}
