package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.InStoreRequestDao;
import wuliu.dto.InStoreRequestDto;
import wuliu.entity.InStoreRequest;

public class InStoreRequestDaoImpl extends BaseDao implements InStoreRequestDao {

	public InStoreRequestDto getInStoreRequestById(int instorerequest) {
		InStoreRequestDto isr = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getInStoreRequestById(?)}");
			cstmt.setInt(1, instorerequest);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				isr = new InStoreRequestDto();
				isr.setInStoreRequestId(rs.getInt("instorerequest"));
				isr.setGoodsId(rs.getInt("goods"));
				isr.setInDate(rs.getString("indate"));
				isr.setGoodQuantity(rs.getInt("quantity"));
				isr.setStoreId(rs.getInt("store"));
				isr.setStateId(rs.getInt("state"));
				isr.setStateStr(rs.getString("sname"));
				isr.setStoreStr(rs.getString("storename"));
				isr.setGoodName(rs.getString("goodsname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return isr;
	}

	public List<InStoreRequestDto> getInStoreRequestByState(int state) {
		List<InStoreRequestDto> listInStoreRequestDto = new ArrayList<InStoreRequestDto>();
		con = getConnection();
		try {
			
			cstmt = con.prepareCall("{call proc_getInStoreRequestByState(?)}");
			cstmt.setInt(1, state);
			cstmt.execute();
			rs = cstmt.executeQuery();
			while(rs.next()){
				InStoreRequestDto isr = new InStoreRequestDto();
				isr.setInStoreRequestId(rs.getInt("instorerequest"));
				isr.setGoodsId(rs.getInt("goods"));
				isr.setInDate(rs.getString("indate"));
				isr.setGoodQuantity(rs.getInt("quantity"));
				isr.setStoreId(rs.getInt("store"));
				isr.setStateId(rs.getInt("state"));
				isr.setStateStr(rs.getString("sname"));
				isr.setStoreStr(rs.getString("storename"));
				isr.setGoodName(rs.getString("goodsname"));
				listInStoreRequestDto.add(isr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listInStoreRequestDto;
	}

	public List<InStoreRequestDto> getInStoreRequestByState(int state,int pageNum) {
		List<InStoreRequestDto> listInStoreRequestDto = new ArrayList<InStoreRequestDto>();
		con = getConnection();
		int startIndex = 10 * (pageNum - 1);
		try {
			cstmt = con.prepareCall("{call proc_getInStoreRequestByStatePage(?,?)}");
			cstmt.setInt(1, state);
			cstmt.setInt(2, startIndex);
			cstmt.execute();
			rs = cstmt.executeQuery();
			while(rs.next()){
				InStoreRequestDto isr = new InStoreRequestDto();
				isr.setInStoreRequestId(rs.getInt("instorerequest"));
				isr.setGoodsId(rs.getInt("goods"));
				isr.setInDate(rs.getString("indate"));
				isr.setGoodQuantity(rs.getInt("quantity"));
				isr.setStoreId(rs.getInt("store"));
				isr.setStateId(rs.getInt("state"));
				isr.setStateStr(rs.getString("sname"));
				isr.setStoreStr(rs.getString("storename"));
				isr.setGoodName(rs.getString("goodsname"));
				listInStoreRequestDto.add(isr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listInStoreRequestDto;
	}

	public int getInStoreRequestByStateCount(int state) {
		int count = 0;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getInStoreRequestByStateCount(?)}");
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
	
	public void updateInStoreRequestState(String[] idList,int state){
		con = getConnection();
		String sql = "update tbl_instorerequest set state = ? where instorerequest in(";
		for(int i = 0 ; i < idList.length - 1 ; i++){
			sql += "?,";
		}
		sql += "?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, state);
			for(int i = 1 ; i <= idList.length ; i++){
				pst.setInt(i + 1, Integer.parseInt(idList[i - 1]));
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	public void addInStoreRequest(InStoreRequest isr){
		con = getConnection();
		try {
			cstmt = con.prepareCall("call proc_addInStoreRequest(?,?,?,?,?)");
			cstmt.setInt(1, isr.getGoodsId());
			cstmt.setString(2, isr.getInDate());
			cstmt.setInt(3, isr.getGoodQuantity());
			cstmt.setInt(4, isr.getStoreId());
			cstmt.setInt(5, isr.getStateId());
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
}
