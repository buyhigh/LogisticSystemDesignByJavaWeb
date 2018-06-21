package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.OutStoreTaskDao;
import wuliu.dto.OutStoreTaskDto;
import wuliu.entity.OutStoreTask;

public class OutStoreTaskDaoImpl extends BaseDao implements OutStoreTaskDao {

	public void addOutStoreTask(OutStoreTask ost) {
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_addOutStoreTask(?,?,?)}");
			cstmt.setInt(1, ost.getOutStoreRequestId());
			cstmt.setInt(2, ost.getStoreId());
			cstmt.setInt(3, ost.getStateId());
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	public List<OutStoreTaskDto> getOutStoreTaskDtoByState(int state){
		List<OutStoreTaskDto> listOutStoreTaskDto = new ArrayList<OutStoreTaskDto>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getOutStoreTaskDtoByState(?)}");
			cstmt.setInt(1, state);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				OutStoreTaskDto ost = new OutStoreTaskDto();
				ost.setOutStoreTaskId(rs.getInt("outstoretask"));
				ost.setOutStoreRequestId(rs.getInt("outstorerequest"));
				ost.setStoreId(rs.getInt("store"));
				ost.setStateId(rs.getInt("state"));
				ost.setStoreStr(rs.getString("storename"));
				ost.setGoodName(rs.getString("goodname"));
				ost.setGoodQuantity(rs.getInt("goodquantity"));
				ost.setStateStr(rs.getString("sname"));
				ost.setOrderDate(rs.getString("orderdate"));
				listOutStoreTaskDto.add(ost);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listOutStoreTaskDto;
	}
	
	public List<OutStoreTaskDto> getOutStoreTaskDtoByState(int state,int pageNum){
		List<OutStoreTaskDto> listOutStoreTaskDto = new ArrayList<OutStoreTaskDto>();
		con = getConnection();
		int startIndex = 10 * (pageNum - 1);
		try {
			cstmt = con.prepareCall("{call proc_getOutStoreTaskDtoByStatePage(?,?)}");
			cstmt.setInt(1, state);
			cstmt.setInt(2, startIndex);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				OutStoreTaskDto ost = new OutStoreTaskDto();
				ost.setOutStoreTaskId(rs.getInt("outstoretask"));
				ost.setOutStoreRequestId(rs.getInt("outstorerequest"));
				ost.setStoreId(rs.getInt("store"));
				ost.setStateId(rs.getInt("state"));
				ost.setStoreStr(rs.getString("storename"));
				ost.setGoodName(rs.getString("goodname"));
				ost.setGoodQuantity(rs.getInt("goodquantity"));
				ost.setStateStr(rs.getString("sname"));
				ost.setOrderDate(rs.getString("orderdate"));
				listOutStoreTaskDto.add(ost);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listOutStoreTaskDto;
	}
	
	public int getOutStoreTaskDtoByStateCount(int state){
		int count = 0;
		con = getConnection();
		try {
			cstmt = con.prepareCall("call proc_getOutStoreTaskDtoByStateCount(?)");
			cstmt.setInt(1, state);
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
	
	public void updateOutStoreTaskState(int outstoretask,int state){
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_updateOutStoreTaskState(?,?)}");
			cstmt.setInt(1, outstoretask);
			cstmt.setInt(2, state);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		
	}
	
	public OutStoreTaskDto getOutStoreTaskDtoById(int outstoretask){
		OutStoreTaskDto ost = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getOutStoreTaskDtoById(?)}");
			cstmt.setInt(1, outstoretask);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				ost = new OutStoreTaskDto();
				ost.setOutStoreTaskId(rs.getInt("outstoretask"));
				ost.setOutStoreRequestId(rs.getInt("outstorerequest"));
				ost.setStoreId(rs.getInt("store"));
				ost.setStateId(rs.getInt("state"));
				ost.setStoreStr(rs.getString("storename"));
				ost.setGoodName(rs.getString("goodname"));
				ost.setGoodQuantity(rs.getInt("goodquantity"));
				ost.setStateStr(rs.getString("sname"));
				ost.setOrderDate(rs.getString("orderdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return ost;
	}
	
	public int getDispatchIdByOutStoreTaskId(int outstoretask){
		int DispatchId = 0;
		String sql = "select a.dispatch from tbl_outstorerequest a,tbl_outstoretask b where a.outstorerequest = b.outstorerequest and b.outstoretask = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, outstoretask);
			rs = pst.executeQuery();
			if(rs.next()){
				DispatchId=rs.getInt("dispatch");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return DispatchId;
	}
}
