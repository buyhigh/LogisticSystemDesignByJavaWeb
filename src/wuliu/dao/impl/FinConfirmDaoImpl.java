package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.FinConfirmDao;
import wuliu.entity.FinConfirm;

public class FinConfirmDaoImpl extends BaseDao implements FinConfirmDao {

	public List<FinConfirm> getFinConfirmByConsumer(String Consumer) {
		List<FinConfirm> listFinconfirm = new ArrayList<FinConfirm>();
		String sql = "select * from tbl_finconfirm where consumer = ? and state = 1";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, Consumer);
			rs = pst.executeQuery();
			while(rs.next()){
				FinConfirm finconfirm = new FinConfirm();
				finconfirm.setFinConfirmId(rs.getInt("id"));
				finconfirm.setDispatchId(rs.getInt("dispatchid"));
				finconfirm.setTraTaskId(rs.getInt("trataskid"));
				finconfirm.setTraState(rs.getInt("state"));
				finconfirm.setConsumer(rs.getString("consumer"));
				finconfirm.setStaff(rs.getString("staff"));
				listFinconfirm.add(finconfirm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
		return listFinconfirm;
	}
	public List<FinConfirm> getFinConfirmByConsumerState2(String Consumer) {
		List<FinConfirm> listFinconfirm = new ArrayList<FinConfirm>();
		String sql = "select * from tbl_finconfirm where consumer = ? and state = 2";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, Consumer);
			rs = pst.executeQuery();
			while(rs.next()){
				FinConfirm finconfirm = new FinConfirm();
				finconfirm.setFinConfirmId(rs.getInt("id"));
				finconfirm.setDispatchId(rs.getInt("dispatchid"));
				finconfirm.setTraTaskId(rs.getInt("trataskid"));
				finconfirm.setTraState(rs.getInt("state"));
				finconfirm.setConsumer(rs.getString("consumer"));
				finconfirm.setStaff(rs.getString("staff"));
				listFinconfirm.add(finconfirm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
		return listFinconfirm;
	}
	public void updateFinConfirmState(int confirmid,int state) {
		String sql = "update tbl_finconfirm set state = ? where dispatchid = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, state);
			pst.setInt(2, confirmid);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
	}
	public void addFinConfirm(int dispatchId,int trataskid,int state,String Consumer,String Staff) {
		String sql = "insert INTO tbl_finconfirm (dispatchid,trataskid,state,consumer,staff) VALUES (?, ?, ?,?,?)";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, dispatchId);
			pst.setInt(2, trataskid);
			pst.setInt(3, state);
			pst.setString(4, Consumer);
			pst.setString(5, Staff);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
	}
	
	public String getConsumerByTrataskid(int traTaskId) {
		String Consumer = null;
		String sql = "select a.creater from tbl_dispatch a,tbl_transferrequest b,tbl_transfertask c where "
				+ "a.dispatch = b.dispatch  and b.transferrequest = c.transferrequest and c.transfertask = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, traTaskId);
			rs = pst.executeQuery();
			if (rs.next()) {
				Consumer = rs.getString("creater");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
		return Consumer;
		
	}
	
	public int getDispatchIdByTrataskid(int traTaskId) {
		int DispatchId = 0;
		String sql = "select a.dispatch from tbl_dispatch a,tbl_transferrequest b,tbl_transfertask c where "
				+ "a.dispatch = b.dispatch  and b.transferrequest = c.transferrequest and c.transfertask = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, traTaskId);
			rs = pst.executeQuery();
			if (rs.next()) {
				DispatchId = rs.getInt("dispatch");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
		return DispatchId;
	}
}