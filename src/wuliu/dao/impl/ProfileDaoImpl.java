package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.ProfileDao;
import wuliu.entity.Profile;

public class ProfileDaoImpl extends BaseDao implements ProfileDao {

	public Profile getProfileByName(String userName) {
		Profile profile = null;
		String sql = "select * from tbl_profile where username = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			if(rs.next()){
				profile = new Profile();
				profile.setProfileId(rs.getInt("id"));
				profile.setUserName(rs.getString("username"));
				profile.setAddress(rs.getString("address"));
				profile.setRealName(rs.getString("realname"));
				profile.setTelphone(rs.getString("telphone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
		return profile;
	}
	
	public void addProfile(String username,String realname,String telphone,String address) {
		String sql = "insert INTO tbl_profile (username,realname,telphone,address) VALUES (?, ?, ?, ?)";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, realname);
			pst.setString(3, telphone);
			pst.setString(4, address);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
		
	}

}