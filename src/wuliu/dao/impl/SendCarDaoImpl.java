package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.SendCarDao;
import wuliu.dto.SendCarDto;
import wuliu.entity.SendCar;

public class SendCarDaoImpl extends BaseDao implements SendCarDao {

	public void addSendCar(SendCar sc) {
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_addSendCar(?,?,?,?,?)}");
			cstmt.setInt(1, sc.getDriverId());
			cstmt.setString(2, sc.getDriverName());
			cstmt.setString(3, sc.getTransferName());
			cstmt.setInt(4, sc.getSendTraTaskId());
			cstmt.setInt(5, sc.getState());
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	
	public List<SendCarDto> getSendCar(int pageNum){
		List<SendCarDto> listSendCarDto = new ArrayList<SendCarDto>();
		con = getConnection();
		int startIndex = 10 * (pageNum - 1);
		try {
			cstmt = con.prepareCall("{call proc_getSendCar(?)}");
			cstmt.setInt(1, startIndex);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				SendCarDto sc = new SendCarDto();
				sc.setDriverId(rs.getInt("driverId"));
				sc.setSendCarId(rs.getInt("sendCarId"));
				sc.setDriverName(rs.getString("driverName"));
				sc.setTransferName(rs.getString("transferName"));
				sc.setSendTraTaskId(rs.getInt("sendTraId"));
				sc.setState(rs.getInt("state"));
				sc.setStateStr(rs.getString("sname"));
				listSendCarDto.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listSendCarDto;
	}
	
	public SendCarDto getSendCarByDriverId(int driverId){
		SendCarDto sendCarDto = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getSendCarByDriverId(?)}");
			cstmt.setInt(1, driverId);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				sendCarDto = new SendCarDto();
				sendCarDto.setDriverId(rs.getInt("driverId"));
				sendCarDto.setSendCarId(rs.getInt("sendCarId"));
				sendCarDto.setDriverName(rs.getString("driverName"));
				sendCarDto.setTransferName(rs.getString("transferName"));
				sendCarDto.setSendTraTaskId(rs.getInt("sendTraId"));
				sendCarDto.setState(rs.getInt("state"));
				sendCarDto.setStateStr(rs.getString("sname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		
		return sendCarDto;
	}
	
	
	
	public int getSendCarCount(){
		int count = 0;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getSendCarCount()}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return count;
	}
	
	public void updateSendCarState(int driverId,int state){
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_updateSendCarState(?,?)}");
			cstmt.setInt(1, driverId);
			cstmt.setInt(2, state);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		
	}
	
	public List<SendCarDto> getSendCarBySendTraId(int sendTraId){
		List<SendCarDto> listSendCarDto = new ArrayList<SendCarDto>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getSendCarBySendTraId(?)}");
			cstmt.setInt(1, sendTraId);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				SendCarDto sendCarDto = new SendCarDto();
				sendCarDto.setDriverId(rs.getInt("driverId"));
				sendCarDto.setSendCarId(rs.getInt("sendCarId"));
				sendCarDto.setDriverName(rs.getString("driverName"));
				sendCarDto.setTransferName(rs.getString("transferName"));
				sendCarDto.setSendTraTaskId(rs.getInt("sendTraId"));
				sendCarDto.setState(rs.getInt("state"));
				sendCarDto.setStateStr(rs.getString("sname"));
				listSendCarDto.add(sendCarDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		
		return listSendCarDto;
	}
}
