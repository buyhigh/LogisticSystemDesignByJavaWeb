package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.SendTraTaskDao;
import wuliu.dto.SendTraTaskDto;
import wuliu.entity.SendTraTask;

public class SendTraTaskDaoImpl extends BaseDao implements SendTraTaskDao {

	public void addSendTraTask(SendTraTask stt) {
		con = getConnection();
		try {
			cstmt = con.prepareCall("call proc_addSendTraTask(?,?,?,?,?,?)");
			cstmt.setInt(1, stt.getTransferRequestId());
			cstmt.setInt(2, stt.getTransferPlaceId());
			cstmt.setInt(3, stt.getTransferModelId());
			cstmt.setInt(4, stt.getTransferToolId());
			cstmt.setInt(5, stt.getRequestNum());
			cstmt.setInt(6, stt.getState());
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}

	public List<SendTraTaskDto> getSendTraTaskDtoByState(int state) {
		List<SendTraTaskDto> listSendTraTaskDto = new ArrayList<SendTraTaskDto>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getSendTraTaskDtoByState(?)}");
			cstmt.setInt(1, state);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				SendTraTaskDto stt = new SendTraTaskDto();
				stt.setSendTraTaskId(rs.getInt("sendTraId"));
				stt.setTransferRequestId(rs.getInt("transferrequest"));
				stt.setTransferPlaceId(rs.getInt("transferplace"));
				stt.setTransferModelId(rs.getInt("transfermodel"));
				stt.setTransferToolId(rs.getInt("transfertool"));
				stt.setRequestNum(rs.getInt("requestnum"));
				stt.setState(rs.getInt("state"));
				stt.setTransferPlaceStr(rs.getString("transferplacename"));
				stt.setTransferModelStr(rs.getString("transfermodelname"));
				stt.setTransferToolStr(rs.getString("transfertoolname"));
				stt.setStateStr(rs.getString("sname"));
				listSendTraTaskDto.add(stt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listSendTraTaskDto;
	}

	public List<SendTraTaskDto> getSendTraTaskDtoByState(int state, int pageNum) {
		List<SendTraTaskDto> listSendTraTaskDto = new ArrayList<SendTraTaskDto>();
		int startIndex = 10 * (pageNum - 1);
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getSendTraTaskDtoByStatePage(?,?)}");
			cstmt.setInt(1, state);
			cstmt.setInt(2, startIndex);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				SendTraTaskDto stt = new SendTraTaskDto();
				stt.setSendTraTaskId(rs.getInt("sendTraId"));
				stt.setTransferRequestId(rs.getInt("transferrequest"));
				stt.setTransferPlaceId(rs.getInt("transferplace"));
				stt.setTransferModelId(rs.getInt("transfermodel"));
				stt.setTransferToolId(rs.getInt("transfertool"));
				stt.setRequestNum(rs.getInt("requestnum"));
				stt.setState(rs.getInt("state"));
				stt.setTransferPlaceStr(rs.getString("transferplacename"));
				stt.setTransferModelStr(rs.getString("transfermodelname"));
				stt.setTransferToolStr(rs.getString("transfertoolname"));
				stt.setStateStr(rs.getString("sname"));
				listSendTraTaskDto.add(stt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listSendTraTaskDto;
	}

	public int getSendTraTaskCountByState(int state) {
		int count = 0;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getSendTraTaskCountByState(?)}");
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

	public void updateSendTraTaskState(int sendTraId, int state) {
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_updateSendTraTaskState(?,?)}");
			cstmt.setInt(1, sendTraId);
			cstmt.setInt(2, state);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}

	}
	
	public SendTraTaskDto getSendTraTaskDtoById(int sendTraId){
		SendTraTaskDto stt = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getSendTraTaskDtoById(?)}");
			cstmt.setInt(1, sendTraId);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				stt = new SendTraTaskDto();
				stt.setSendTraTaskId(rs.getInt("sendTraId"));
				stt.setTransferRequestId(rs.getInt("transferrequest"));
				stt.setTransferPlaceId(rs.getInt("transferplace"));
				stt.setTransferModelId(rs.getInt("transfermodel"));
				stt.setTransferToolId(rs.getInt("transfertool"));
				stt.setRequestNum(rs.getInt("requestnum"));
				stt.setState(rs.getInt("state"));
				stt.setTransferPlaceStr(rs.getString("transferplacename"));
				stt.setTransferModelStr(rs.getString("transfermodelname"));
				stt.setTransferToolStr(rs.getString("transfertoolname"));
				stt.setStateStr(rs.getString("sname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return stt;
	}
	
	public SendTraTaskDto getSendTraTaskByTfq(int transferrequest){
		SendTraTaskDto stt = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getSendTraTaskByTfq(?)}");
			cstmt.setInt(1, transferrequest);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				stt = new SendTraTaskDto();
				stt.setSendTraTaskId(rs.getInt("sendTraId"));
				stt.setTransferRequestId(rs.getInt("transferrequest"));
				stt.setTransferPlaceId(rs.getInt("transferplace"));
				stt.setTransferModelId(rs.getInt("transfermodel"));
				stt.setTransferToolId(rs.getInt("transfertool"));
				stt.setRequestNum(rs.getInt("requestnum"));
				stt.setState(rs.getInt("state"));
				stt.setTransferPlaceStr(rs.getString("transferplacename"));
				stt.setTransferModelStr(rs.getString("transfermodelname"));
				stt.setTransferToolStr(rs.getString("transfertoolname"));
				stt.setStateStr(rs.getString("sname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return stt;
	}

}
