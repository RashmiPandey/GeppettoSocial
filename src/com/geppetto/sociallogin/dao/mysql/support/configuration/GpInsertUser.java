package com.geppetto.sociallogin.dao.mysql.support.configuration;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
/**
 * 
 * @author Rashmi
 *
 */
public class GpInsertUser extends SqlUpdate{
	
	public static String SQL_INSERT_USER = "";
	public GpInsertUser(DataSource dataSource) {
		super(dataSource, SQL_INSERT_USER);

		super.declareParameter(new SqlParameter("username", Types.VARCHAR));
		super.declareParameter(new SqlParameter("password", Types.VARCHAR));
		
		super.setGeneratedKeysColumnNames(new String[] { "id" });
		super.setReturnGeneratedKeys(true);
	}


}
