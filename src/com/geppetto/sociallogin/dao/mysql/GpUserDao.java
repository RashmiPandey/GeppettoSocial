package com.geppetto.sociallogin.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.geppetto.sociallogin.dao.mysql.support.configuration.GpInsertUser;
import com.geppetto.sociallogin.dao.mysql.support.configuration.GpUserRowMapper;
import com.geppetto.sociallogin.domain.core.GpUser;
import com.geppetto.sociallogin.interfaces.dao.IGpUserDao;
/**
 * 
 * @author Rashmi
 * 
 */


@Repository("GpUserDao")
public class GpUserDao implements IGpUserDao {

	private Log log = LogFactory.getLog(getClass());

	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private GpInsertUser insert_user;
	
	@Value("${findUser.sql}")
	private String findUser;

	@Value("${insert.user.sql}")
	private String insertUser;

	
	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}
	
	/**
	 * finds user in DB
	 */
	@Override
	public GpUser findUser(String userName) {
		GpUser gpuser =null;
		
		System.out.println("UserName is" + userName);
		MapSqlParameterSource sqlParameter = new MapSqlParameterSource();
		sqlParameter.addValue("userName", userName);
		GpUserRowMapper user_row_Mapper = new GpUserRowMapper();
		List<GpUser> user = this.namedParameterJdbcTemplate.query(findUser,
				sqlParameter, user_row_Mapper);
		System.out.println("Size of user" + user.size());
		if (user.size() != 0) {
			System.out.println("User found" + user.get(0).getUsername());
			gpuser = user.get(0);
		} else {
			log.debug("No user found" + user);
		}
		return gpuser;
	}
	
	/**
	 * This method creates a new user
	 */
	@Override
	public GpUser insert(GpUser user) throws Exception {
		
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("username", user.getUsername());
		paramMap.put("password", "geppetto");

		KeyHolder keyHolder = new GeneratedKeyHolder();
		GpInsertUser.SQL_INSERT_USER = insertUser;
		this.insert_user = new GpInsertUser(dataSource);
		this.insert_user.updateByNamedParam(paramMap, keyHolder);
		user.setId(keyHolder.getKey().longValue());

		return user;

	}
}
