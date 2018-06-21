package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.TransferModelDao;
import wuliu.entity.TransferModel;

public class TransferModelDaoImpl extends BaseDao implements TransferModelDao {

	public List<TransferModel> getAllTransferModel() {
		List<TransferModel> listTransferModel = new ArrayList<TransferModel>();
		String sql = "select * from tbl_transfermodel";
		con = getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				TransferModel trmo = new TransferModel();
				trmo.setTrmoId(rs.getInt("transfermodel"));
				trmo.setTrmoName(rs.getString("name"));
				trmo.setTrmoWeight(rs.getString("weight"));
				trmo.setTrmoMulk(rs.getString("mulk"));
				listTransferModel.add(trmo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTransferModel;
	}

	public TransferModel getTransferModelById(int transferModel) {
		TransferModel trmo = null;
		String sql = "select * from tbl_transfermodel where transfermodel = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, transferModel);
			rs = pst.executeQuery();
			if(rs.next()){
				trmo = new TransferModel();
				trmo.setTrmoId(rs.getInt("transfermodel"));
				trmo.setTrmoName(rs.getString("name"));
				trmo.setTrmoWeight(rs.getString("weight"));
				trmo.setTrmoMulk(rs.getString("mulk"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trmo;
	}

}
