package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.TraDao;
import wuliu.dto.TraDto;
import wuliu.entity.Tra;

public class TraDaoImpl extends BaseDao implements TraDao {

	public void addTra(Tra t) {
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_addTra(?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,t.getGoodName());
			cstmt.setInt(2,t.getGoodQuantity());
			cstmt.setString(3, t.getReceName());
			cstmt.setString(4, t.getReceTel());
			cstmt.setString(5,t.getReceProvince());
			cstmt.setString(6, t.getReceCity());
			cstmt.setString(7, t.getReceStreet());
			cstmt.setInt(8, t.getTransferTaskId());
			cstmt.setInt(9, t.getDispUserId());
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}

	public List<TraDto> getTraByDispUserId(int dispuser) {
		List<TraDto> listTraDto = new ArrayList<TraDto>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTraByDispUserId(?)}");
			cstmt.setInt(1, dispuser);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				TraDto td = new TraDto();
				td.setTraId(rs.getInt("traId"));
				td.setGoodName(rs.getString("goodName"));
				td.setGoodQuantity(rs.getInt("goodQuantity"));
				td.setReceName(rs.getString("receName"));
				td.setReceTel(rs.getString("receTel"));
				td.setReceProvince(rs.getString("receProvince"));
				td.setReceCity(rs.getString("receCity"));
				td.setReceStreet(rs.getString("receStreet"));
				td.setTransferTaskId(rs.getInt("transfertask"));
				td.setDispUserId(rs.getInt("dispuser"));
				td.setDispUserName(rs.getString("dispname"));
				td.setDispNum(rs.getInt("dispnum"));
				listTraDto.add(td);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listTraDto;
	}
	
	public List<TraDto> getTraPage(int pageNum){
		List<TraDto> listTraDto = new ArrayList<TraDto>();
		con = getConnection();
		int startIndex = 10 * (pageNum - 1);
		try {
			cstmt = con.prepareCall("{call proc_getTraByDispUserIdPage(?)}");
			cstmt.setInt(1, startIndex);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				TraDto td = new TraDto();
				td.setTraId(rs.getInt("traId"));
				td.setGoodName(rs.getString("goodName"));
				td.setGoodQuantity(rs.getInt("goodQuantity"));
				td.setReceName(rs.getString("receName"));
				td.setReceTel(rs.getString("receTel"));
				td.setReceProvince(rs.getString("receProvince"));
				td.setReceCity(rs.getString("receCity"));
				td.setReceStreet(rs.getString("receStreet"));
				td.setTransferTaskId(rs.getInt("transfertask"));
				td.setDispUserId(rs.getInt("dispuser"));
				td.setDispUserName(rs.getString("dispname"));
				td.setDispNum(rs.getInt("dispnum"));
				listTraDto.add(td);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listTraDto;
	}
	
	public int getTraCount(){
		int count = 0;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTraByDispUserCount()}");
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
	
	public TraDto getTraById(int traId){
		TraDto td = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTraById(?)}");
			cstmt.setInt(1, traId);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				td = new TraDto();
				td.setTraId(rs.getInt("traId"));
				td.setGoodName(rs.getString("goodName"));
				td.setGoodQuantity(rs.getInt("goodQuantity"));
				td.setReceName(rs.getString("receName"));
				td.setReceTel(rs.getString("receTel"));
				td.setReceProvince(rs.getString("receProvince"));
				td.setReceCity(rs.getString("receCity"));
				td.setReceStreet(rs.getString("receStreet"));
				td.setTransferTaskId(rs.getInt("transfertask"));
				td.setDispUserId(rs.getInt("dispuser"));
				td.setDispUserName(rs.getString("dispname"));
				td.setDispNum(rs.getInt("dispnum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return td;
	}
	
	public TraDto getTraByTransferTaskId(int transfertask){
		TraDto td = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTraByTransferTaskId(?)}");
			cstmt.setInt(1, transfertask);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				td = new TraDto();
				td.setTraId(rs.getInt("traId"));
				td.setGoodName(rs.getString("goodName"));
				td.setGoodQuantity(rs.getInt("goodQuantity"));
				td.setReceName(rs.getString("receName"));
				td.setReceTel(rs.getString("receTel"));
				td.setReceProvince(rs.getString("receProvince"));
				td.setReceCity(rs.getString("receCity"));
				td.setReceStreet(rs.getString("receStreet"));
				td.setTransferTaskId(rs.getInt("transfertask"));
				td.setDispUserId(rs.getInt("dispuser"));
				td.setDispUserName(rs.getString("dispname"));
				td.setDispNum(rs.getInt("dispnum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		
		return td;
	}

}
