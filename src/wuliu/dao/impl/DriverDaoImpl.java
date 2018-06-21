package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.DriverDao;
import wuliu.entity.Driver;

public class DriverDaoImpl extends BaseDao implements DriverDao {

	public List<Driver> getDriverByState(int driverState) {
		List<Driver> listDriver = new ArrayList<Driver>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getDriverByState(?)}");
			cstmt.setInt(1, driverState);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				Driver d = new Driver();
				d.setDriverId(rs.getInt("driver"));
				d.setDriverName(rs.getString("name"));
				d.setDriverAge(rs.getInt("age"));
				d.setDriverSex(rs.getInt("sex"));
				d.setDriverPhoto(rs.getString("photo"));
				d.setDriverState(rs.getInt("driverstate"));
				listDriver.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listDriver;
	}
	
	
	public void updateDriverState(int driverId,int driverState){
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_updateDriverState(?,?)}");
			cstmt.setInt(1, driverId);
			cstmt.setInt(2,driverState);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	public Driver getDriverById(int driver){
		Driver d = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getDriverById(?)}");
			cstmt.setInt(1, driver);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				d = new Driver();
				d.setDriverId(rs.getInt("driver"));
				d.setDriverName(rs.getString("name"));
				d.setDriverAge(rs.getInt("age"));
				d.setDriverSex(rs.getInt("sex"));
				d.setDriverPhoto(rs.getString("photo"));
				d.setDriverState(rs.getInt("driverstate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		
		return d;
	}
}
