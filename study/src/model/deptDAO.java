package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.DeptDTO;
import util.DBUtil;

public class deptDAO {

	public static ArrayList<DeptDTO> getAllDept() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from dept");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new DeptDTO(rset.getInt(1), rset.getString(2),rset.getString(3)));
				
			}
		}finally{
			DBUtil.close(rset, pstmt, conn);
		}
		
		return list;
	
	}
	public static boolean getupdate(String loc, int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBUtil.getConnection();	
		pstmt = conn.prepareStatement("update dept set loc = ? where deptno= ?");
		
		pstmt.setString(1, loc);
		pstmt.setInt(2, deptno);
		 pstmt.executeUpdate();
		
		return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static boolean delete(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("delete from dept where deptno = ?");
			pstmt.setInt(1, deptno);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static boolean add(DeptDTO deptTable) {
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into dept values(?, ?, ?)");
			pstmt.setInt(1, deptTable.getDeptno());
			pstmt.setString(2, deptTable.getDname());
			pstmt.setString(3, deptTable.getLoc());
		int rset = pstmt.executeUpdate();
		if(rset == 1) {
			return true;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	public static DeptDTO searchAllList(int deptno) throws SQLException  {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		DeptDTO printDept = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from dept where deptno= ?");
			pstmt.setInt(1, deptno);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				printDept = new DeptDTO(rset.getInt(1), rset.getString(2), rset.getString(3)); 
			};
		} finally {
			DBUtil.close(rset, pstmt, conn);
		}
		
		return printDept;
	}
	
}
