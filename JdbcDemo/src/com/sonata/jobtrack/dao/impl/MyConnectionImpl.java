package com.sonata.jobtrack.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sonata.jobtrack.dao.MyConnection;

/**
 * connection to MySQL database
 * @author CHAKRADHAR_KINTADA
 * 20-08-2021
 *
 */
public class MyConnectionImpl implements MyConnection {

	@Override
	public Connection connectToMySql() {
		Connection con=null;
		try {
//			Class.forName("com.mysql.cj.jdbc.driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JobTracking","root","CHAKRADHAr612");
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
