﻿package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	static DataSource source = null;
	
	static{		 
		try {
			Context initContext = new InitialContext();		
			Context envContext			
			= (Context)initContext.lookup("java:/comp/env");
			source = (DataSource)envContext.lookup("jdbc/mysql");
		} catch (NamingException e) {			
			e.printStackTrace();
		}	
	}
	public static Connection getConnection() throws SQLException{
		return source.getConnection();
	}
	public  static void close(Statement stmt, Connection con){
		try{
			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(con != null){
				con.close();
				con = null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public  static void close(ResultSet rset, Statement stmt, Connection con){
		try{
			if(rset != null){
				rset.close();	
				rset = null;
			}
			if(stmt != null){
				stmt.close();	
				stmt = null;
			}
			if(con != null){
				con.close();		
				con = null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}


