package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.TransferToolDao;
import wuliu.dto.TransferToolDto;

public class TransferToolDaoImpl extends BaseDao implements TransferToolDao {

	public List<TransferToolDto> getTransferToolByModel(int transferModel) {
		List<TransferToolDto> listTransferToolDto = new ArrayList<TransferToolDto>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferToolByModel(?)}");
			cstmt.setInt(1,transferModel);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				TransferToolDto ttd = new TransferToolDto();
				ttd.setTransferId(rs.getInt("transfertool"));
				ttd.setTransferNum(rs.getString("transfernum"));
				ttd.setTransferName(rs.getString("transfername"));
				ttd.setTransferState(rs.getInt("transferstate"));
				ttd.setTransferModel(rs.getInt("transfermodel"));
				ttd.setTransferPlace(rs.getInt("transferplace"));
				ttd.setStateStr(rs.getString("sname"));
				ttd.setModelStr(rs.getString("name"));
				ttd.setPlaceStr(rs.getString("placename"));
				ttd.setQuantity(rs.getInt("transferqueantity"));
				listTransferToolDto.add(ttd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listTransferToolDto;
	}
	public List<TransferToolDto> getTransferToolByModel(int transferModel,int pageNum) {
		List<TransferToolDto> listTransferToolDto = new ArrayList<TransferToolDto>();
		int startIndex = 10 * (pageNum - 1);
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferToolByModelPage(?,?)}");
			cstmt.setInt(1,transferModel);
			cstmt.setInt(2,startIndex);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				TransferToolDto ttd = new TransferToolDto();
				ttd.setTransferId(rs.getInt("transfertool"));
				ttd.setTransferNum(rs.getString("transfernum"));
				ttd.setTransferName(rs.getString("transfername"));
				ttd.setTransferState(rs.getInt("transferstate"));
				ttd.setTransferModel(rs.getInt("transfermodel"));
				ttd.setTransferPlace(rs.getInt("transferplace"));
				ttd.setStateStr(rs.getString("sname"));
				ttd.setModelStr(rs.getString("name"));
				ttd.setPlaceStr(rs.getString("placename"));
				ttd.setQuantity(rs.getInt("transferqueantity"));
				listTransferToolDto.add(ttd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listTransferToolDto;
	}
	

	
	
	public List<TransferToolDto> getTransferToolByPlace(int transferPlace) {
		List<TransferToolDto> listTransferToolDto = new ArrayList<TransferToolDto>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferToolByPlace(?)}");
			cstmt.setInt(1, transferPlace);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				TransferToolDto ttd = new TransferToolDto();
				ttd.setTransferId(rs.getInt("transfertool"));
				ttd.setTransferNum(rs.getString("transfernum"));
				ttd.setTransferName(rs.getString("transfername"));
				ttd.setTransferState(rs.getInt("transferstate"));
				ttd.setTransferModel(rs.getInt("transfermodel"));
				ttd.setTransferPlace(rs.getInt("transferplace"));
				ttd.setStateStr(rs.getString("sname"));
				ttd.setModelStr(rs.getString("name"));
				ttd.setPlaceStr(rs.getString("placename"));
				ttd.setQuantity(rs.getInt("transferqueantity"));
				listTransferToolDto.add(ttd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listTransferToolDto;
	}
	public List<TransferToolDto> getTransferToolByPlace(int transferPlace,int pageNum) {
		List<TransferToolDto> listTransferToolDto = new ArrayList<TransferToolDto>();
		int startIndex = 10 * (pageNum - 1);
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferToolByPlacePage(?,?)}");
			cstmt.setInt(1, transferPlace);
			cstmt.setInt(2, startIndex);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				TransferToolDto ttd = new TransferToolDto();
				ttd.setTransferId(rs.getInt("transfertool"));
				ttd.setTransferNum(rs.getString("transfernum"));
				ttd.setTransferName(rs.getString("transfername"));
				ttd.setTransferState(rs.getInt("transferstate"));
				ttd.setTransferModel(rs.getInt("transfermodel"));
				ttd.setTransferPlace(rs.getInt("transferplace"));
				ttd.setStateStr(rs.getString("sname"));
				ttd.setModelStr(rs.getString("name"));
				ttd.setPlaceStr(rs.getString("placename"));
				ttd.setQuantity(rs.getInt("transferqueantity"));
				listTransferToolDto.add(ttd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listTransferToolDto;
	}
	public int getgetTransferToolByPlaceCount(int transferPlace){
		int count = 0;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getgetTransferToolByPlaceCount(?)}");
			cstmt.setInt(1, transferPlace);
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

	
	
	public List<TransferToolDto> getTransferTool(int transferPlace,int transferModel) {
		List<TransferToolDto> listTransferToolDto = new ArrayList<TransferToolDto>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferTool(?,?)}");
			cstmt.setInt(1, transferPlace);
			cstmt.setInt(2, transferModel);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				TransferToolDto ttd = new TransferToolDto();
				ttd.setTransferId(rs.getInt("transfertool"));
				ttd.setTransferNum(rs.getString("transfernum"));
				ttd.setTransferName(rs.getString("transfername"));
				ttd.setTransferState(rs.getInt("transferstate"));
				ttd.setTransferModel(rs.getInt("transfermodel"));
				ttd.setTransferPlace(rs.getInt("transferplace"));
				ttd.setStateStr(rs.getString("sname"));
				ttd.setModelStr(rs.getString("name"));
				ttd.setPlaceStr(rs.getString("placename"));
				ttd.setQuantity(rs.getInt("transferqueantity"));
				listTransferToolDto.add(ttd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listTransferToolDto;
	}
	public List<TransferToolDto> getTransferTool(int transferPlace,int transferModel,int pageNum) {
		List<TransferToolDto> listTransferToolDto = new ArrayList<TransferToolDto>();
		int startIndex = 10 * (pageNum - 1);
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferToolPage(?,?,?)}");
			cstmt.setInt(1, transferPlace);
			cstmt.setInt(2, transferModel);
			cstmt.setInt(3, startIndex);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				TransferToolDto ttd = new TransferToolDto();
				ttd.setTransferId(rs.getInt("transfertool"));
				ttd.setTransferNum(rs.getString("transfernum"));
				ttd.setTransferName(rs.getString("transfername"));
				ttd.setTransferState(rs.getInt("transferstate"));
				ttd.setTransferModel(rs.getInt("transfermodel"));
				ttd.setTransferPlace(rs.getInt("transferplace"));
				ttd.setStateStr(rs.getString("sname"));
				ttd.setModelStr(rs.getString("name"));
				ttd.setPlaceStr(rs.getString("placename"));
				ttd.setQuantity(rs.getInt("transferqueantity"));
				listTransferToolDto.add(ttd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listTransferToolDto;
	}
	public int getTransferToolCount(int transferPlace,int transferModel){
		int count = 0;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferToolCount(?,?)}");
			cstmt.setInt(1, transferPlace);
			cstmt.setInt(2, transferModel);
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
	
	
	

	public TransferToolDto getTransferToolById(int transferTool) {
		TransferToolDto ttd = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getTransferToolById(?)}");
			cstmt.setInt(1, transferTool);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				ttd = new TransferToolDto();
				ttd.setTransferId(rs.getInt("transfertool"));
				ttd.setTransferNum(rs.getString("transfernum"));
				ttd.setTransferName(rs.getString("transfername"));
				ttd.setTransferState(rs.getInt("transferstate"));
				ttd.setTransferModel(rs.getInt("transfermodel"));
				ttd.setTransferPlace(rs.getInt("transferplace"));
				ttd.setStateStr(rs.getString("sname"));
				ttd.setModelStr(rs.getString("name"));
				ttd.setPlaceStr(rs.getString("placename"));
				ttd.setQuantity(rs.getInt("transferqueantity"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return ttd;
	}

	public void updateTransferToolQuantity(int transfertool,int quantity){
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_updateTransferToolQuantity(?,?)}");
			cstmt.setInt(1, transfertool);
			cstmt.setInt(2, quantity);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	public void updateTransferToolState(int transfertool,int transferstate){
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_updateTransferToolState(?,?)}");
			cstmt.setInt(1, transfertool);
			cstmt.setInt(2, transferstate);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
}
