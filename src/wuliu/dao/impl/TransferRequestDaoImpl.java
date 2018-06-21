package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.TransferRequestDao;
import wuliu.dto.TransferRequestDto;
import wuliu.entity.TransferRequest;

public class TransferRequestDaoImpl extends BaseDao implements
		TransferRequestDao {

	public void addTransferRequest(TransferRequest tfr) {
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_addTransferRequest(?,?,?,?)}");
			cstmt.setInt(1,tfr.getDispatchId());
			cstmt.setInt(2, tfr.getTransferToolId());
			cstmt.setInt(3, tfr.getRequestNum());
			cstmt.setInt(4, tfr.getState());
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	public List<TransferRequestDto> getTransferRequestByState(int state){
		List<TransferRequestDto> listTransferRequestDto = new ArrayList<TransferRequestDto>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferRequestByState(?)}");
			cstmt.setInt(1, state);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				TransferRequestDto transferRequestDto = new TransferRequestDto();
				transferRequestDto.setTransferRequestId(rs.getInt("transferrequest"));
				transferRequestDto.setDispatchId(rs.getInt("dispatch"));
				transferRequestDto.setTransferToolId(rs.getInt("transfertool"));
				transferRequestDto.setState(rs.getInt("state"));
				transferRequestDto.setTransferName(rs.getString("transfername"));
				transferRequestDto.setTransferModel(rs.getString("transfermodel"));
				transferRequestDto.setTransferTool(rs.getString("tranm"));
				transferRequestDto.setOrderDate(rs.getString("orderdate"));
				transferRequestDto.setRequestNum(rs.getInt("requestnum"));
				transferRequestDto.setTransferQuantity(rs.getInt("transferquantity"));
				transferRequestDto.setStateName(rs.getString("sname"));
				listTransferRequestDto.add(transferRequestDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listTransferRequestDto;
	}
	
	public List<TransferRequestDto> getTransferRequestByState(int state,int pageNum){
		List<TransferRequestDto> listTransferRequestDto = new ArrayList<TransferRequestDto>();
		int startIndex = 10 * (pageNum - 1);
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferRequestByStatePage(?,?)}");
			cstmt.setInt(1, state);
			cstmt.setInt(2, startIndex);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				TransferRequestDto transferRequestDto = new TransferRequestDto();
				transferRequestDto.setTransferRequestId(rs.getInt("transferrequest"));
				transferRequestDto.setDispatchId(rs.getInt("dispatch"));
				transferRequestDto.setTransferToolId(rs.getInt("transfertool"));
				transferRequestDto.setState(rs.getInt("state"));
				transferRequestDto.setTransferName(rs.getString("transfername"));
				transferRequestDto.setTransferModel(rs.getString("transfermodel"));
				transferRequestDto.setTransferTool(rs.getString("tranm"));
				transferRequestDto.setOrderDate(rs.getString("orderdate"));
				transferRequestDto.setRequestNum(rs.getInt("requestnum"));
				transferRequestDto.setTransferQuantity(rs.getInt("transferquantity"));
				transferRequestDto.setStateName(rs.getString("sname"));
				listTransferRequestDto.add(transferRequestDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listTransferRequestDto;
	}
	
	
	public int getTransferRequestByStateCount(int state){
		int count = 0;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferRequestByStateCount(?)}");
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
	
	public TransferRequestDto getTransferRequestById(int transferrequest){
		TransferRequestDto transferRequestDto = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferRequestById(?)}");
			cstmt.setInt(1, transferrequest);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				transferRequestDto = new TransferRequestDto();
				transferRequestDto.setTransferRequestId(rs.getInt("transferrequest"));
				transferRequestDto.setDispatchId(rs.getInt("dispatch"));
				transferRequestDto.setTransferToolId(rs.getInt("transfertool"));
				transferRequestDto.setState(rs.getInt("state"));
				transferRequestDto.setTransferName(rs.getString("transfername"));
				transferRequestDto.setTransferModel(rs.getString("transfermodel"));
				transferRequestDto.setTransferTool(rs.getString("tranm"));
				transferRequestDto.setOrderDate(rs.getString("orderdate"));
				transferRequestDto.setRequestNum(rs.getInt("requestnum"));
				transferRequestDto.setTransferQuantity(rs.getInt("transferquantity"));
				transferRequestDto.setStateName(rs.getString("sname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return transferRequestDto;
	}
	
	public void updateTransferRequestDto(int transferrequest,int state){
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_updateTransferRequestDto(?,?)}");
			cstmt.setInt(1, transferrequest);
			cstmt.setInt(2, state);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
}
