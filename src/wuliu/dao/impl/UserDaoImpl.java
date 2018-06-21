package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.UserDao;
import wuliu.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	public User getUserByName(String userName) {
		User user = null;
		String sql = "select * from tbl_users where name = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getInt("users"));
				user.setUserName(rs.getString("name"));
				user.setUserPass(rs.getString("password"));
				user.setUserType(rs.getInt("usertype"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
		return user;
	}

	public User getUserByUId(int userId) {
		User user = null;
		String sql = "select * from tbl_users where users = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId);
			rs = pst.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getInt("users"));
				user.setUserName(rs.getString("name"));
				user.setUserPass(rs.getString("password"));
				user.setUserType(rs.getInt("usertype"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
		return user;
	}
	public List<User> getUserByType(int uType) {
		List<User> listUser = new ArrayList<User>();
		String sql = "select * from tbl_users where usertype like ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, uType);
			rs = pst.executeQuery();
			while(rs.next()){
				User user = new User();
				System.out.println("loop");
				user.setUserId(rs.getInt("users"));
				user.setUserName(rs.getString("name"));
				user.setUserType(rs.getInt("usertype"));
				listUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listUser;
	}
	public void addUser(String username,String password,int uType) {
		String sql = "insert INTO tbl_users (name,password,usertype) VALUES (?, ?, ?)";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setInt(3, uType);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
	}
	public void delUser(int  uId) {
		String sql = "DELETE FROM  tbl_users where users = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, uId);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
	}
}

