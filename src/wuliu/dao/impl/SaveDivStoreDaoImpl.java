package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.SaveDivStoreDao;
import wuliu.entity.SaveDivStore;
import wuliu.entity.User;

public class SaveDivStoreDaoImpl extends BaseDao implements SaveDivStoreDao {

	public List<SaveDivStore> getSaveDivStoreBystate(int state) {
		List<SaveDivStore> listsaveDivStore = new ArrayList<SaveDivStore>();
		String sql = "select * from tbl_savedivstore where state = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, state);
			rs = pst.executeQuery();
			while(rs.next()){
				SaveDivStore saveDivStore = new SaveDivStore();
				saveDivStore.setId(rs.getInt("id"));
				saveDivStore.setDispatchId(rs.getString("dispatchid"));
				saveDivStore.setGoodsName(rs.getString("goodsname"));
				saveDivStore.setGoodsQuantity(rs.getInt("goodsquantity"));
				saveDivStore.setCreater(rs.getString("creater"));
				saveDivStore.setState(rs.getInt("state"));
				saveDivStore.setSendTime(rs.getString("sendtime"));
				listsaveDivStore.add(saveDivStore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
		return listsaveDivStore;
	}

	public String getDispatchIdById(int id) {
		String DispatchId = null;
		String sql = "select dispatchid from tbl_savedivstore where id = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				DispatchId = rs.getString("dispatchid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
		return DispatchId;
	}

	public void addSaveDivStore(String dispatchId,String goodsName,int goodsQuantity,String creater,int state,String sendTime) {
		String sql = "insert INTO tbl_savedivstore (dispatchid,goodsname,goodsquantity,creater,state,sendtime) VALUES (?, ?, ?,?,?,?)";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, dispatchId);
			pst.setString(2, goodsName);
			pst.setInt(3, goodsQuantity);
			pst.setString(4, creater);
			pst.setInt(5, state);
			pst.setString(6, sendTime);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
	}
	public void UpdateSaveDivStore(int id ,int state) {
		String sql = "update tbl_savedivstore set state = ? where id = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, state);
			pst.setInt(2, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
	}
	public int getDivStoreIdByOutStoreTask(int OutStoreTaskid) {
		int DivStoreId = 0;
		String sql = "select d.id " + 
				"from tbl_dispatch a,tbl_outstorerequest b,tbl_outstoretask c, tbl_savedivstore d " + 
				"where a.dispatch = b.dispatch and d.dispatchid = a.orderid and b.outstorerequest = c.outstorerequest " + 
				"and c.outstoretask = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, OutStoreTaskid);
			rs = pst.executeQuery();
			if (rs.next()) {
				DivStoreId = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs,st,con);
		}
		return DivStoreId;
		
	}
}

