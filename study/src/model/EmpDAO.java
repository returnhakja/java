package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import util.DBUtil;

public class EmpDAO {
	
	
	public static String getJob(int empno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement("select job from emp where empno = ?");
			pstmt.setInt(1, empno);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				return rset.getString(1);
			}
			
		}finally {
			DBUtil.close(rset, pstmt,conn);
		}
		
		return null;
		
		
	}
	
}
