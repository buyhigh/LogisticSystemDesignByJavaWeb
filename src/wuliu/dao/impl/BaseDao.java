package wuliu.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class BaseDao {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/wl_db";
	public static final String NAME = "root";
	public static final String PASS = "jiangyangjun";
	
	public Connection con = null;
	public Statement st = null;
	public PreparedStatement pst = null;
	public ResultSet rs = null;
	public CallableStatement cstmt = null;
	
	
	/**
	 * 获取数据连接对象
	 * @return
	 */
	public Connection getConnection(){
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,NAME,PASS);
			/*Context ic = new InitialContext();
			DataSource source = (DataSource)ic.lookup("java:comp/env/jdbc/wl");
			con = source.getConnection();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * 释放数据库资源
	 * @param rs
	 * @param st
	 * @param con
	 */
	public void closeAll(ResultSet rs,Statement st,Connection con){
		try{
			if(rs != null){
				rs.close();
			}
			if(pst != null){
				pst.close();
			}
			if(st != null){
				st.close();
			}
			if(con != null && !con.isClosed()){
				con.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	public void closeAll(){
		try{
			if(cstmt != null){
				cstmt.close();
			}
			if(rs != null){
				rs.close();
			}
			if(pst != null){
				pst.close();
			}
			if(st != null){
				st.close();
			}
			if(con != null && !con.isClosed()){
				con.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
}
