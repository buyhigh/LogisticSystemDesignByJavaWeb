package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.TransferPlaceDao;
import wuliu.entity.TransferPlace;

public class TransferPlaceDaoImpl extends BaseDao implements TransferPlaceDao {
	
	public List<TransferPlace> getAllTransferPlace(){
		List<TransferPlace> listTransferPlace = new ArrayList<TransferPlace>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getAllTransferPlace()}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				TransferPlace tp = new TransferPlace();
				tp.setTransferPlaceId(rs.getInt("transferplace"));
				tp.setTransferPlaceName(rs.getString("transfername"));
				listTransferPlace.add(tp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listTransferPlace;
	}
}
