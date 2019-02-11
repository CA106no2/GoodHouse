package com.goodhouse.contract.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


public class ContractJDBCDAO implements ContractDAO_interface{
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "GOODHOUSE";
	String passwd = "123456";
	
	private static final String INSERT_STMT = 
			"INSERT INTO CONTRACT (CON_ID,CON_NAME,CON_CONTENT) VALUES (CONTRACT_SEQ.NEXTVAL,?,?)";
	private static final String GET_ALL_STMT = 
			"SELECT CON_ID,CON_NAME,CON_CONTENT FROM CONTRACT ORDER BY CON_ID";
	private static final String GET_ONE_STMT = 
			"SELECT CON_ID,CON_NAME,CON_CONTENT FROM CONTRACT WHERE CON_NAME=?";
	private static final String DELETE = 
			"DELETE FROM CONTRACT WHERE CON_ID = ? ";
	private static final String UPDATE = 
			"UPDATE CONTRACT SET CON_NAME=? , CON_CONTENT = ? WHERE CON_ID = ?";
	
	
	@Override//新增
	public void insert(ContractVO conVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1,conVO.getConName());
			pstmt.setString(2, conVO.getConContent());
			
			pstmt.executeUpdate();
			
		}catch (ClassNotFoundException e){
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		}catch (SQLException se) {
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

	@Override//更新
	public void update(ContractVO conVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1,conVO.getConName());
			pstmt.setString(2, conVO.getConContent());
			pstmt.setString(3, conVO.getConId());
			
			pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override//刪除資料
	public void delete(String conId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, conId);
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		}catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public ContractVO findByPrimaryKey(String conId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContractVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
		ContractJDBCDAO conDAO = new ContractJDBCDAO();
		
		ContractVO contractVO = new ContractVO();
		
		//新增
		contractVO.setConName("套房合約");
		contractVO.setConContent("");
		
		conDAO.insert(contractVO);
	}

}
