package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.DispUserDao;
import wuliu.entity.DispUser;

public class DispUserDaoImpl extends BaseDao implements DispUserDao {

	public DispUser getDispUserById(int dispUser) {
		DispUser du = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getDispUserById(?)}");
			cstmt.setInt(1, dispUser);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				du = new DispUser();
				du.setDispUserId(rs.getInt("dispuser"));
				du.setDispUserName(rs.getString("dispname"));
				du.setDispNum(rs.getInt("dispnum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return du;
	}

	public List<DispUser> getDispUserByCon() {
		List<DispUser> listDispUser = new ArrayList<DispUser>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getDispUserByCon()}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				DispUser du = new DispUser();
				du.setDispUserId(rs.getInt("dispuser"));
				du.setDispUserName(rs.getString("dispname"));
				du.setDispNum(rs.getInt("dispnum"));
				listDispUser.add(du);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listDispUser;
	}

	public void updateDispUserNum(int dispUser, int dispNum) {
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_updateDispUserNum(?,?)}");
			cstmt.setInt(1, dispUser);
			cstmt.setInt(2, dispNum);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		
	}

}
