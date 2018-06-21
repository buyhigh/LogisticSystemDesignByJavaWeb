package wuliu.dao.impl;

import java.sql.SQLException;


import wuliu.dao.StoreRefGoodDao;
import wuliu.entity.StoreRefGood;

public class StoreRefGoodDaoImpl extends BaseDao implements StoreRefGoodDao {

	public StoreRefGood examineDispatch(String goodName, int goodQuantity) {
		StoreRefGood storeRefGood = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_examineDispatch(?,?)}");
			cstmt.setString(1, goodName);
			cstmt.setInt(2, goodQuantity);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				storeRefGood = new StoreRefGood();
				storeRefGood.setStoreId(rs.getInt("store"));
				storeRefGood.setGoodsId(rs.getInt("goods"));
				storeRefGood.setNum(rs.getInt("num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return storeRefGood;
	}
	
	public StoreRefGood examineOutStoreRequest(int store,String goodName,int goodQuantity){
		StoreRefGood storeRefGood = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_examineOutStoreRequest(?,?,?)}");
			cstmt.setInt(1, store);
			cstmt.setString(2, goodName);
			cstmt.setInt(3, goodQuantity);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				storeRefGood = new StoreRefGood();
				storeRefGood.setStoreId(rs.getInt("store"));
				storeRefGood.setGoodsId(rs.getInt("goods"));
				storeRefGood.setNum(rs.getInt("num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return storeRefGood;
	}
	
	public void updateStoreGood(int store,String goodName,int goodQuantity){
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_updateStoreGood(?,?,?)}");
			cstmt.setInt(1, store);
			cstmt.setString(2,goodName);
			cstmt.setInt(3, goodQuantity);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	public void addStoreGood(StoreRefGood srf){
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_addStoreGood(?,?,?)}");
			cstmt.setInt(1, srf.getStoreId());
			cstmt.setInt(2, srf.getGoodsId());
			cstmt.setInt(3, srf.getNum());
			cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
}
