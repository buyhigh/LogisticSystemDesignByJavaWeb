package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.StoreDao;
import wuliu.entity.Store;

public class StoreDaoImpl extends BaseDao implements StoreDao {

	public Store getStoreByStoreId(int storeId) {
		Store store = null;
		String sql = "select * from tbl_store where store = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, storeId);
			rs = pst.executeQuery();
			if(rs.next()){
				store = new Store();
				store.setStoreId(rs.getInt("store"));
				store.setStoreName(rs.getString("storename"));
				store.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return store;
	}

	public List<Store> getAllStore() {
		List<Store> listStore = new ArrayList<Store>();
		String sql = "select * from tbl_store";
		con = getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				Store store = new Store();
				store.setStoreId(rs.getInt("store"));
				store.setStoreName(rs.getString("storename"));
				store.setAddress(rs.getString("address"));
				listStore.add(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listStore;
	}
	
	public Store getStoreByName(String storeName){
		Store store = null;
		String sql = "select * from tbl_store where storename = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, storeName);
			rs = pst.executeQuery();
			if(rs.next()){
				store = new Store();
				store.setStoreId(rs.getInt("store"));
				store.setStoreName(rs.getString("storename"));
				store.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return store;
	}

}
