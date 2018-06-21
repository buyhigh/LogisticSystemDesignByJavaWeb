package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.DispatchDao;
import wuliu.dto.DispatchDto;
import wuliu.entity.Dispatch;

public class DispatchDaoImpl extends BaseDao implements DispatchDao {

	public void addDispatch(Dispatch dispatch) {
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_addDispatch(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, dispatch.getOrderId());
			cstmt.setString(2, dispatch.getGoodName());
			cstmt.setInt(3, dispatch.getGoodQuantity());
			cstmt.setInt(4, dispatch.getTransferTool());
			cstmt.setString(5, dispatch.getOrderDate());
			cstmt.setString(6, dispatch.getSendName());
			cstmt.setString(7, dispatch.getSendTel());
			cstmt.setString(8, dispatch.getReceiverName());
			cstmt.setString(9, dispatch.getReceiverTel());
			cstmt.setString(10, dispatch.getReceiverProvince());
			cstmt.setString(11,dispatch.getReceiverCity());
			cstmt.setString(12,dispatch.getReceiverStreet());
			cstmt.setInt(13,dispatch.getState());
			cstmt.setString(14,dispatch.getCreater());
			System.out.println("增加配送单");
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}

	public List<DispatchDto> getDispatchByState(int state) {
		List<DispatchDto> listDispatchDto = new ArrayList<DispatchDto>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getDispatchByState(?)}");
			cstmt.setInt(1, state);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				DispatchDto dispatchDto = new DispatchDto();
				dispatchDto.setDispatchId(rs.getInt("dispatch"));
				dispatchDto.setOrderId(rs.getString("orderid"));
				dispatchDto.setGoodName(rs.getString("goodname"));
				dispatchDto.setGoodQuantity(rs.getInt("goodquantity"));
				dispatchDto.setTransferTool(rs.getInt("transfertool"));
				dispatchDto.setOrderDate(rs.getString("orderdate"));
				dispatchDto.setSendName(rs.getString("sendname"));
				dispatchDto.setSendTel(rs.getString("sendtel"));
				dispatchDto.setReceiverName(rs.getString("receivername"));
				dispatchDto.setReceiverTel(rs.getString("receivertel"));
				dispatchDto.setReceiverProvince(rs.getString("receiverprovince"));
				dispatchDto.setReceiverCity(rs.getString("receivercity"));
				dispatchDto.setReceiverStreet(rs.getString("receiverstreet"));
				dispatchDto.setState(rs.getInt("state"));
				dispatchDto.setStateName(rs.getString("statename"));
				listDispatchDto.add(dispatchDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listDispatchDto;
	}
	
	
	
	public List<DispatchDto> getDispatchByState(int state,int pageNum){
		List<DispatchDto> listDispatchDto = new ArrayList<DispatchDto>();
		int startIndex = 10 * (pageNum - 1);
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getDispatchByStatePage(?,?)}");
			cstmt.setInt(1, state);
			cstmt.setInt(2, startIndex);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				DispatchDto dispatchDto = new DispatchDto();
				dispatchDto.setDispatchId(rs.getInt("dispatch"));
				dispatchDto.setOrderId(rs.getString("orderid"));
				dispatchDto.setGoodName(rs.getString("goodname"));
				dispatchDto.setGoodQuantity(rs.getInt("goodquantity"));
				dispatchDto.setTransferTool(rs.getInt("transfertool"));
				dispatchDto.setOrderDate(rs.getString("orderdate"));
				dispatchDto.setSendName(rs.getString("sendname"));
				dispatchDto.setSendTel(rs.getString("sendtel"));
				dispatchDto.setReceiverName(rs.getString("receivername"));
				dispatchDto.setReceiverTel(rs.getString("receivertel"));
				dispatchDto.setReceiverProvince(rs.getString("receiverprovince"));
				dispatchDto.setReceiverCity(rs.getString("receivercity"));
				dispatchDto.setReceiverStreet(rs.getString("receiverstreet"));
				dispatchDto.setState(rs.getInt("state"));
				dispatchDto.setStateName(rs.getString("statename"));
				listDispatchDto.add(dispatchDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listDispatchDto;
	}
	
	
	
	public List<DispatchDto> getAllDispatch(){
		List<DispatchDto> listDispatchDto = new ArrayList<DispatchDto>();
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getAllDispatch()}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				DispatchDto dispatchDto = new DispatchDto();
				dispatchDto.setDispatchId(rs.getInt("dispatch"));
				dispatchDto.setOrderId(rs.getString("orderid"));
				dispatchDto.setGoodName(rs.getString("goodname"));
				dispatchDto.setGoodQuantity(rs.getInt("goodquantity"));
				dispatchDto.setTransferTool(rs.getInt("transfertool"));
				dispatchDto.setOrderDate(rs.getString("orderdate"));
				dispatchDto.setSendName(rs.getString("sendname"));
				dispatchDto.setSendTel(rs.getString("sendtel"));
				dispatchDto.setReceiverName(rs.getString("receivername"));
				dispatchDto.setReceiverTel(rs.getString("receivertel"));
				dispatchDto.setReceiverProvince(rs.getString("receiverprovince"));
				dispatchDto.setReceiverCity(rs.getString("receivercity"));
				dispatchDto.setReceiverStreet(rs.getString("receiverstreet"));
				dispatchDto.setState(rs.getInt("state"));
				dispatchDto.setStateName(rs.getString("statename"));
				listDispatchDto.add(dispatchDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listDispatchDto;
	}
	
	public List<DispatchDto> getAllDispatch(int pageNum){
		List<DispatchDto> listDispatchDto = new ArrayList<DispatchDto>();
		int startIndex = 10 * (pageNum - 1);
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getAllDispatchPage(?)}");
			cstmt.setInt(1, startIndex);
			cstmt.execute();
			rs = cstmt.getResultSet();
			while(rs.next()){
				DispatchDto dispatchDto = new DispatchDto();
				dispatchDto.setDispatchId(rs.getInt("dispatch"));
				dispatchDto.setOrderId(rs.getString("orderid"));
				dispatchDto.setGoodName(rs.getString("goodname"));
				dispatchDto.setGoodQuantity(rs.getInt("goodquantity"));
				dispatchDto.setTransferTool(rs.getInt("transfertool"));
				dispatchDto.setOrderDate(rs.getString("orderdate"));
				dispatchDto.setSendName(rs.getString("sendname"));
				dispatchDto.setSendTel(rs.getString("sendtel"));
				dispatchDto.setReceiverName(rs.getString("receivername"));
				dispatchDto.setReceiverTel(rs.getString("receivertel"));
				dispatchDto.setReceiverProvince(rs.getString("receiverprovince"));
				dispatchDto.setReceiverCity(rs.getString("receivercity"));
				dispatchDto.setReceiverStreet(rs.getString("receiverstreet"));
				dispatchDto.setState(rs.getInt("state"));
				dispatchDto.setStateName(rs.getString("statename"));
				listDispatchDto.add(dispatchDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listDispatchDto;
	}
	
	public DispatchDto getDispatchById(int dispatch){
		DispatchDto dispatchDto = null;
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_getDispatchById(?)}");
			cstmt.setInt(1, dispatch);
			cstmt.execute();
			rs = cstmt.getResultSet();
			if(rs.next()){
				dispatchDto = new DispatchDto();
				dispatchDto.setDispatchId(rs.getInt("dispatch"));
				dispatchDto.setOrderId(rs.getString("orderid"));
				dispatchDto.setGoodName(rs.getString("goodname"));
				dispatchDto.setGoodQuantity(rs.getInt("goodquantity"));
				dispatchDto.setTransferTool(rs.getInt("transfertool"));
				dispatchDto.setOrderDate(rs.getString("orderdate"));
				dispatchDto.setSendName(rs.getString("sendname"));
				dispatchDto.setSendTel(rs.getString("sendtel"));
				dispatchDto.setReceiverName(rs.getString("receivername"));
				dispatchDto.setReceiverTel(rs.getString("receivertel"));
				dispatchDto.setReceiverProvince(rs.getString("receiverprovince"));
				dispatchDto.setReceiverCity(rs.getString("receivercity"));
				dispatchDto.setReceiverStreet(rs.getString("receiverstreet"));
				dispatchDto.setState(rs.getInt("state"));
				dispatchDto.setStateName(rs.getString("statename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return dispatchDto;
	}
	
	public void updateDispatch(Dispatch dispatch){
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_updateDispatch(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,dispatch.getOrderId());
			cstmt.setString(2, dispatch.getGoodName());
			cstmt.setInt(3, dispatch.getGoodQuantity());
			cstmt.setInt(4, dispatch.getTransferTool());
			cstmt.setString(5, dispatch.getSendName());
			cstmt.setString(6, dispatch.getSendTel());
			cstmt.setString(7, dispatch.getReceiverName());
			cstmt.setString(8, dispatch.getReceiverTel());
			cstmt.setString(9, dispatch.getReceiverProvince());
			cstmt.setString(10,dispatch.getReceiverCity());
			cstmt.setString(11,dispatch.getReceiverStreet());
			cstmt.setInt(12, dispatch.getDispatchId());
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	
	public void deleteDispatchByIdList(String[] idList){
		String sql = "delete from tbl_dispatch where dispatch in(";
		for(int i = 0 ; i < idList.length - 1 ; i++){
			sql += "?,";
		}
		sql += "?)";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			for(int i = 0 ; i < idList.length ; i++){
				pst.setInt(i + 1, Integer.parseInt(idList[i]));
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	public int getDispatchCount(){
		int count = 0;
		String sql = "select count(*) count from tbl_dispatch";
		con = getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
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
	
	public int getDispatchCount(int state){
		int count = 0;
		String sql = "select count(*) count from tbl_dispatch where state = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, state);
			rs = pst.executeQuery();
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
	
	public void updateDispatchState(int dispatch,int state){
		con = getConnection();
		try {
			cstmt = con.prepareCall("{call proc_updateDispatchState(?,?)}");
			cstmt.setInt(1, dispatch);
			cstmt.setInt(2, state);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
	}
	
	public void cancelDispatch(String[] dispatch){
		String sql = "update tbl_dispatch set state = 4 where dispatch in(";
		for(int i = 0 ; i < dispatch.length - 1 ; i++){
			sql += "?,";
		}
		sql += "?)";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			for(int i = 0 ; i < dispatch.length ; i++){
				pst.setInt(i + 1, Integer.parseInt(dispatch[i]));
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		
	}
	//下面是客户用的
	
	public List<DispatchDto> getAllDispatch(String Creater,int pageNum){
		List<DispatchDto> listDispatchDto = new ArrayList<DispatchDto>();
		int startIndex = 10 * (pageNum - 1);
		con = getConnection();
		try {
			String sql = "select a.*,b.sname statename from tbl_dispatch a,tbl_state b where a.state = b.state and a.Creater = ? order by orderdate desc limit ?,10";
			pst = con.prepareStatement(sql);
			pst.setString(1, Creater);
			pst.setInt(2, startIndex);
			rs = pst.executeQuery();
			while(rs.next()){
				DispatchDto dispatchDto = new DispatchDto();
				dispatchDto.setDispatchId(rs.getInt("dispatch"));
				dispatchDto.setOrderId(rs.getString("orderid"));
				dispatchDto.setGoodName(rs.getString("goodname"));
				dispatchDto.setGoodQuantity(rs.getInt("goodquantity"));
				dispatchDto.setTransferTool(rs.getInt("transfertool"));
				dispatchDto.setOrderDate(rs.getString("orderdate"));
				dispatchDto.setSendName(rs.getString("sendname"));
				dispatchDto.setSendTel(rs.getString("sendtel"));
				dispatchDto.setReceiverName(rs.getString("receivername"));
				dispatchDto.setReceiverTel(rs.getString("receivertel"));
				dispatchDto.setReceiverProvince(rs.getString("receiverprovince"));
				dispatchDto.setReceiverCity(rs.getString("receivercity"));
				dispatchDto.setReceiverStreet(rs.getString("receiverstreet"));
				dispatchDto.setState(rs.getInt("state"));
				dispatchDto.setStateName(rs.getString("statename"));
				listDispatchDto.add(dispatchDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listDispatchDto;
	}
	
	public int getDispatchCount(String Creater){
		int count = 0;
		String sql = "select count(*) count from tbl_dispatch where Creater = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, Creater);
			rs = pst.executeQuery();
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
	
	public List<DispatchDto> getDispatchByState(String Creater,int state,int pageNum){
		List<DispatchDto> listDispatchDto = new ArrayList<DispatchDto>();
		String sql = "select a.*,b.sname statename from tbl_dispatch a,tbl_state b where a.state = b.state and b.state = ? and a.creater = ? order by orderdate desc limit ?,10";
		int startIndex = 10 * (pageNum - 1);
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, state);
			pst.setString(2, Creater);
			pst.setInt(3, startIndex);
			
			rs = pst.executeQuery();
			while(rs.next()){
				DispatchDto dispatchDto = new DispatchDto();
				dispatchDto.setDispatchId(rs.getInt("dispatch"));
				dispatchDto.setOrderId(rs.getString("orderid"));
				dispatchDto.setGoodName(rs.getString("goodname"));
				dispatchDto.setGoodQuantity(rs.getInt("goodquantity"));
				dispatchDto.setTransferTool(rs.getInt("transfertool"));
				dispatchDto.setOrderDate(rs.getString("orderdate"));
				dispatchDto.setSendName(rs.getString("sendname"));
				dispatchDto.setSendTel(rs.getString("sendtel"));
				dispatchDto.setReceiverName(rs.getString("receivername"));
				dispatchDto.setReceiverTel(rs.getString("receivertel"));
				dispatchDto.setReceiverProvince(rs.getString("receiverprovince"));
				dispatchDto.setReceiverCity(rs.getString("receivercity"));
				dispatchDto.setReceiverStreet(rs.getString("receiverstreet"));
				dispatchDto.setState(rs.getInt("state"));
				dispatchDto.setStateName(rs.getString("statename"));
				listDispatchDto.add(dispatchDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listDispatchDto;
	}
	public int getDispatchCount(String Creater,int state){
		int count = 0;
		String sql = "select count(*) count from tbl_dispatch where state = ? and Creater = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, state);
			pst.setString(2, Creater);
			rs = pst.executeQuery();
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
	public List<DispatchDto> getAllDispatch(String Creater){
		List<DispatchDto> listDispatchDto = new ArrayList<DispatchDto>();
		String sql = "select a.*,b.sname statename from tbl_dispatch a,tbl_state b where a.state = b.state and Creater = ? order by orderdate desc";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, Creater);
			rs = pst.executeQuery();
			while(rs.next()){
				DispatchDto dispatchDto = new DispatchDto();
				dispatchDto.setDispatchId(rs.getInt("dispatch"));
				dispatchDto.setOrderId(rs.getString("orderid"));
				dispatchDto.setGoodName(rs.getString("goodname"));
				dispatchDto.setGoodQuantity(rs.getInt("goodquantity"));
				dispatchDto.setTransferTool(rs.getInt("transfertool"));
				dispatchDto.setOrderDate(rs.getString("orderdate"));
				dispatchDto.setSendName(rs.getString("sendname"));
				dispatchDto.setSendTel(rs.getString("sendtel"));
				dispatchDto.setReceiverName(rs.getString("receivername"));
				dispatchDto.setReceiverTel(rs.getString("receivertel"));
				dispatchDto.setReceiverProvince(rs.getString("receiverprovince"));
				dispatchDto.setReceiverCity(rs.getString("receivercity"));
				dispatchDto.setReceiverStreet(rs.getString("receiverstreet"));
				dispatchDto.setState(rs.getInt("state"));
				dispatchDto.setStateName(rs.getString("statename"));
				listDispatchDto.add(dispatchDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listDispatchDto;
	}
	public List<DispatchDto> getDispatchByState(String Creater,int state) {
		List<DispatchDto> listDispatchDto = new ArrayList<DispatchDto>();
		String sql = "select a.*,b.sname statename from tbl_dispatch a,tbl_state b where a.state = b.state and b.state = ? and Creater = ? order by orderdate desc";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, state);
			pst.setString(2, Creater);
			rs = pst.executeQuery();
			while(rs.next()){
				DispatchDto dispatchDto = new DispatchDto();
				dispatchDto.setDispatchId(rs.getInt("dispatch"));
				dispatchDto.setOrderId(rs.getString("orderid"));
				dispatchDto.setGoodName(rs.getString("goodname"));
				dispatchDto.setGoodQuantity(rs.getInt("goodquantity"));
				dispatchDto.setTransferTool(rs.getInt("transfertool"));
				dispatchDto.setOrderDate(rs.getString("orderdate"));
				dispatchDto.setSendName(rs.getString("sendname"));
				dispatchDto.setSendTel(rs.getString("sendtel"));
				dispatchDto.setReceiverName(rs.getString("receivername"));
				dispatchDto.setReceiverTel(rs.getString("receivertel"));
				dispatchDto.setReceiverProvince(rs.getString("receiverprovince"));
				dispatchDto.setReceiverCity(rs.getString("receivercity"));
				dispatchDto.setReceiverStreet(rs.getString("receiverstreet"));
				dispatchDto.setState(rs.getInt("state"));
				dispatchDto.setStateName(rs.getString("statename"));
				listDispatchDto.add(dispatchDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return listDispatchDto;
	}
	
	public int getDispatchidByOrderid(String Orderid) {
		int Dispatchid = 0;
		String sql = "select dispatch from tbl_dispatch where orderid = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, Orderid);
			rs = pst.executeQuery();
			if (rs.next()) {
				Dispatchid = rs.getInt("dispatch");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return Dispatchid;
	}
	
}
