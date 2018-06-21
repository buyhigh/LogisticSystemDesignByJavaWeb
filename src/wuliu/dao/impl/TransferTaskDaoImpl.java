package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.TransferTaskDao;
import wuliu.dto.TransferTaskDto;
import wuliu.entity.TransferTask;

public class TransferTaskDaoImpl extends BaseDao implements TransferTaskDao {

	public void addTransferTask(TransferTask tt) {
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_addTransferTask(?,?,?)}");
			cstmt.setInt(1, tt.getTransferRequestId());
			cstmt.setInt(2, tt.getTransferToolId());
			cstmt.setInt(3, tt.getStateId());
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	public List<TransferTaskDto> getTransferTaskDtoByState(int state){
		List<TransferTaskDto> listTransferTaskDto = new ArrayList<TransferTaskDto>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferTaskDtoByState(?)}");
			cstmt.setInt(1, state);
			cstmt.execute();
			rs = cstmt.executeQuery();
			while(rs.next()){
				TransferTaskDto ttd = new TransferTaskDto();
				ttd.setTransferTaskId(rs.getInt("transfertask"));
				ttd.setTransferRequestId(rs.getInt("transferrequest"));
				ttd.setTransferToolId(rs.getInt("transfertool"));
				ttd.setStateId(rs.getInt("state"));
				ttd.setRequestNum(rs.getInt("requestnum"));
				ttd.setTransferName(rs.getString("transfername"));
				ttd.setTransferModel(rs.getString("transfermodel"));
				ttd.setTransferTool(rs.getString("tranm"));
				ttd.setTransferQuantity(rs.getInt("transferquantity"));
				ttd.setOrderDate(rs.getString("orderdate"));
				ttd.setStateName(rs.getString("sname"));
				listTransferTaskDto.add(ttd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listTransferTaskDto;
	}
	
	public List<TransferTaskDto> getTransferTaskDtoByState(int state,int pageNum){
		List<TransferTaskDto> listTransferTaskDto = new ArrayList<TransferTaskDto>();
		con = getConnection();
		int startIndex = 10 * (pageNum - 1);
		try {
			cstmt = con.prepareCall("{call proc_getTransferTaskDtoByStatePage(?,?)}");
			cstmt.setInt(1, state);
			cstmt.setInt(2, startIndex);
			cstmt.execute();
			rs = cstmt.executeQuery();
			while(rs.next()){
				TransferTaskDto ttd = new TransferTaskDto();
				ttd.setTransferTaskId(rs.getInt("transfertask"));
				ttd.setTransferRequestId(rs.getInt("transferrequest"));
				ttd.setTransferToolId(rs.getInt("transfertool"));
				ttd.setStateId(rs.getInt("state"));
				ttd.setRequestNum(rs.getInt("requestnum"));
				ttd.setTransferName(rs.getString("transfername"));
				ttd.setTransferModel(rs.getString("transfermodel"));
				ttd.setTransferTool(rs.getString("tranm"));
				ttd.setTransferQuantity(rs.getInt("transferquantity"));
				ttd.setOrderDate(rs.getString("orderdate"));
				ttd.setStateName(rs.getString("sname"));
				listTransferTaskDto.add(ttd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listTransferTaskDto;
	}
	
	public int getTransferTaskDtoByStateCount(int state){
		int count = 0;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferTaskDtoByStateCount(?)}");
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
	
	public TransferTaskDto getTransferTaskDtoById(int transferTask){
		TransferTaskDto ttd = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferTaskDtoById(?)}");
			cstmt.setInt(1, transferTask);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				ttd = new TransferTaskDto();
				ttd.setTransferTaskId(rs.getInt("transfertask"));
				ttd.setTransferRequestId(rs.getInt("transferrequest"));
				ttd.setTransferToolId(rs.getInt("transfertool"));
				ttd.setStateId(rs.getInt("state"));
				ttd.setRequestNum(rs.getInt("requestnum"));
				ttd.setTransferName(rs.getString("transfername"));
				ttd.setTransferModel(rs.getString("transfermodel"));
				ttd.setTransferTool(rs.getString("tranm"));
				ttd.setTransferQuantity(rs.getInt("transferquantity"));
				ttd.setOrderDate(rs.getString("orderdate"));
				ttd.setStateName(rs.getString("sname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return ttd;
	}
	
	
	public void updateTransferTaskState(int transferTask,int state){
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_updateTransferTaskState(?,?)}");
			cstmt.setInt(1, transferTask);
			cstmt.setInt(2, state);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		
	}
}
