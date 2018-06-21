package wuliu.dao.impl;

import java.sql.SQLException;

import wuliu.dao.CarTimeDao;
import wuliu.entity.CarTime;

public class CarTimeDaoImpl extends BaseDao implements CarTimeDao {

	public void addCarTime(CarTime ct) {
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_addCarTime(?,?)}");
			cstmt.setInt(1, ct.getDriverId());
			cstmt.setInt(2, ct.getTransferToolId());
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	public void deleteCarTime(int driver,int transfertool){
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_deleteCarTime(?,?)}");
			cstmt.setInt(1, driver);
			cstmt.setInt(2, transfertool);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		
	}

}
