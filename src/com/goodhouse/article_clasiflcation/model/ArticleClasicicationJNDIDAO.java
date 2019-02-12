package com.goodhouse.article_clasiflcation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ArticleClasicicationJNDIDAO implements ArticleClasicicationDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB3");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT_STMT = "INSERT INTO ARTICLE_CLASIFICATION (ARTICLE_CLA_ID,ARTICLE_CLA_NAME) VALUES ('M'||LPAD (to_char(ARTICLE_CLASIFICATION_SEQ.NEXTVAL),9,'0') , ? )";
	private static final String GET_ALL_STMT = "SELECT ARTICLE_CLA_ID,ARTICLE_CLA_NAME FROM ARTICLE_CLASIFICATION order by ARTICLE_CLA_ID";
	private static final String GET_ONE_STMT = "SELECT ARTICLE_CLA_ID,ARTICLE_CLA_NAME FROM ARTICLE_CLASIFICATION where ARTICLE_CLA_ID = ?";
	private static final String DELETE = "DELETE FROM ARTICLE_CLASIFICATION where ARTICLE_CLA_ID = ?";
	private static final String UPDATE = "UPDATE ARTICLE_CLASIFICATION set ARTICLE_CLA_NAME=? where ARTICLE_CLA_ID = ?";

	@Override
	public void insert(ArticleClasicicationVO articleClasicicationVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, articleClasicicationVO.getArticle_cla_name());

			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured."+se.getMessage());
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
	public void update(ArticleClasicicationVO articleClasicicationVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con =  ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, articleClasicicationVO.getArticle_cla_name());
			pstmt.setString(2, articleClasicicationVO.getArticle_cla_id());
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured."+ se.getMessage());
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public void delete(String article_cla_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, article_cla_id);
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured."+se.getMessage());
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public ArticleClasicicationVO findByPrimaryKey(String article_cla_id) {
		ArticleClasicicationVO artC=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setString(1, article_cla_id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				artC = new ArticleClasicicationVO();
				artC.setArticle_cla_id(rs.getString("article_cla_id"));
				artC.setArticle_cla_name(rs.getString("article_cla_name"));
				
			}
			
		} catch (SQLException se) {
		throw new RuntimeException("A database error occured."+se.getMessage());
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
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
		
		return artC;
	}

	@Override
	public List<ArticleClasicicationVO> getAll() {
		List<ArticleClasicicationVO> list = new ArrayList<ArticleClasicicationVO>();
		ArticleClasicicationVO artC = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				artC = new ArticleClasicicationVO();
				artC.setArticle_cla_id(rs.getString("article_cla_id"));
				artC.setArticle_cla_name(rs.getString("article_cla_name"));
				list.add(artC);
			}
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured."+e.getMessage());
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
		}
		
		
		
		return list;
	}
}
