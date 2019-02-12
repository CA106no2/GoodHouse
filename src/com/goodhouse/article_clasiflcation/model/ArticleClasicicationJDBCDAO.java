package com.goodhouse.article_clasiflcation.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleClasicicationJDBCDAO implements ArticleClasicicationDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "TEST";
	String passwd = "123456";

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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, articleClasicicationVO.getArticle_cla_name());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
	public void update(ArticleClasicicationVO articleClasicicationVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, articleClasicicationVO.getArticle_cla_name());
			pstmt.setString(2, articleClasicicationVO.getArticle_cla_id());
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
			// Clean up JDBC resource
		} finally {
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);

			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, article_cla_id);
			pstmt.execute();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
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
		ArticleClasicicationVO articleClasicicationVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, article_cla_id);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				articleClasicicationVO = new ArticleClasicicationVO();
				articleClasicicationVO.setArticle_cla_id(rs.getString("article_cla_id"));
				articleClasicicationVO.setArticle_cla_name(rs.getString("article_cla_name"));

			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load datavase driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A datavase error occured." + se.getMessage());

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return articleClasicicationVO;
	}

	@Override
	public List<ArticleClasicicationVO> getAll() {
		List<ArticleClasicicationVO> list = new ArrayList<ArticleClasicicationVO>();
		ArticleClasicicationVO articleClasicicationVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				articleClasicicationVO = new ArticleClasicicationVO();
				articleClasicicationVO.setArticle_cla_id(rs.getString("article_cla_id"));
				articleClasicicationVO.setArticle_cla_name(rs.getString("article_cla_name"));
				list.add(articleClasicicationVO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(System.err);
				}
			}
		}

		return list;
	}
	
	public static void main(String[] args) {
		ArticleClasicicationJDBCDAO dao = new ArticleClasicicationJDBCDAO();
		// 新增
		ArticleClasicicationVO artC = new ArticleClasicicationVO();
		ArticleClasicicationVO artC3 = new ArticleClasicicationVO();
		ArticleClasicicationVO artC4 = new ArticleClasicicationVO();
		artC.setArticle_cla_name("租屋文444444");
		artC3.setArticle_cla_name("租屋文555555");
		artC4.setArticle_cla_name("租屋文666666");
		dao.insert(artC);
		dao.insert(artC3);
		dao.insert(artC4);
		
		//修改
		ArticleClasicicationVO artC2 = new ArticleClasicicationVO();
		artC2.setArticle_cla_id("M000000002");
		artC2.setArticle_cla_name("白");
		dao.update(artC2);
		
		// 刪除
		dao.delete("M000000007");
		
		
		// 查詢
		
		List<ArticleClasicicationVO> list = dao.getAll();
		for(ArticleClasicicationVO aArt : list) {
			System.out.print(aArt.getArticle_cla_id()+",");
			System.out.print(aArt.getArticle_cla_name());
			System.out.println();
		}
		
		
		
	}

}
