package com.goodhouse.house_track.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class HouseTrackJDBCDAO implements HouseTrackDAO_interface{

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "GOODHOUSE";
	String passwd = "123456";
	
	private static final String INSERT_STMT=
			"INSERT INTO HOUSETRACK (HOU_TRA_ID,MEM_ID,HOU_ID,HOU_TRA_STATUS) VALUES (HOU_TRA_SEQ.NEXTVAL,?,?)";
	
	@Override
	public void insert(HouseTrackVO houTraVO) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, houTraVO.getMemId());
			pstmt.setString(2, houTraVO.getHouId());
			pstmt.setString(3, houTraVO.getHouTraStatus());
			
			pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
		
		
	}

	@Override
	public void update(HouseTrackVO houTraVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(HouseTrackVO houTraVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HouseTrackVO findByPrimaryKey(String conId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HouseTrackVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		
		HouseTrackJDBCDAO houTraDAO = new HouseTrackJDBCDAO();
		
		HouseTrackVO houTraVO = new HouseTrackVO();
		
		
		
	}
}
