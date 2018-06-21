package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.OutStoreRequestDao;
import wuliu.dto.OutStoreRequestDto;
import wuliu.entity.OutStoreRequest;

public class OutStoreRequestDaoImpl extends BaseDao implements
		OutStoreRequestDao {

	public void addOutStoreRequest(OutStoreRequest osr) {
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_addOutStoreRequest(?,?,?)}");
			cstmt.setInt(1, osr.getDispatchId());
			cstmt.setInt(2, osr.getStoreId());
			cstmt.setInt(3, osr.getState());
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	public List<OutStoreRequestDto> getOutStoreRequestByState(int state){
		List<OutStoreRequestDto> listOutStoreRequestDto = new ArrayList<OutStoreRequestDto>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getOutStoreRequestByState(?)}");
			cstmt.setInt(1, state);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				OutStoreRequestDto ors = new OutStoreRequestDto();
				ors.setOutStoreRequestId(rs.getInt("outstorerequest"));
				ors.setDispatchId(rs.getInt("dispatch"));
				ors.setStoreId(rs.getInt("store"));
				ors.setState(rs.getInt("state"));
				ors.setStoreStr(rs.getString("storename"));
				ors.setGoodName(rs.getString("goodname"));
				ors.setGoodQuantity(rs.getInt("goodQuantity"));
				ors.setStateStr(rs.getString("sname"));
				ors.setOrderDate(rs.getString("orderdate"));
				listOutStoreRequestDto.add(ors);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listOutStoreRequestDto;
	}
	
	public List<OutStoreRequestDto> getOutStoreRequestByState(int state,int pageNum){
		List<OutStoreRequestDto> listOutStoreRequestDto = new ArrayList<OutStoreRequestDto>();
		int startIndex = 10 * (pageNum - 1);
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getOutStoreRequestByStatePage(?,?)}");
			cstmt.setInt(1, state);
			cstmt.setInt(2,startIndex);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				OutStoreRequestDto ors = new OutStoreRequestDto();
				ors.setOutStoreRequestId(rs.getInt("outstorerequest"));
				ors.setDispatchId(rs.getInt("dispatch"));
				ors.setStoreId(rs.getInt("store"));
				ors.setState(rs.getInt("state"));
				ors.setStoreStr(rs.getString("storename"));
				ors.setGoodName(rs.getString("goodname"));
				ors.setGoodQuantity(rs.getInt("goodQuantity"));
				ors.setStateStr(rs.getString("sname"));
				ors.setOrderDate(rs.getString("orderdate"));
				listOutStoreRequestDto.add(ors);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listOutStoreRequestDto;
	}
	
	public int getOutStoreRequestByStateCount(int state){
		int count = 0;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getOutStoreRequestByStateCount(?)}");
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
	
	public void updateOutStoreRequestState(int outstorerequest,int newState){
		String sql = "update tbl_outstorerequest set state = ? where outstorerequest = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, newState);
			pst.setInt(2, outstorerequest);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	public OutStoreRequestDto getgetOutStoreRequestById(int outstorerequest){
		OutStoreRequestDto outStoreRequestDto = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getgetOutStoreRequestById(?)}");
			cstmt.setInt(1, outstorerequest);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				outStoreRequestDto = new OutStoreRequestDto();
				outStoreRequestDto.setOutStoreRequestId(rs.getInt("outstorerequest"));
				outStoreRequestDto.setDispatchId(rs.getInt("dispatch"));
				outStoreRequestDto.setStoreId(rs.getInt("store"));
				outStoreRequestDto.setState(rs.getInt("state"));
				outStoreRequestDto.setStoreStr(rs.getString("storename"));
				outStoreRequestDto.setGoodName(rs.getString("goodname"));
				outStoreRequestDto.setGoodQuantity(rs.getInt("goodQuantity"));
				outStoreRequestDto.setStateStr(rs.getString("sname"));
				outStoreRequestDto.setOrderDate(rs.getString("orderdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return outStoreRequestDto;
	}

}
