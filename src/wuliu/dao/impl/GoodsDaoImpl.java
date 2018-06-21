package wuliu.dao.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.GoodsDao;
import wuliu.dto.GoodsDto;
import wuliu.entity.Goods;

public class GoodsDaoImpl extends BaseDao implements GoodsDao{

	public GoodsDto getGoodByGoodId(int goodId) {
		GoodsDto goodDto = null;
		String sql = "select a.*,b.num num,b.store store,c.indate indate from tbl_goods a,tbl_storerefgoods b where a.goods = b.goods and  a.goods = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, goodId);
			rs = pst.executeQuery();
			if(rs.next()){
				goodDto = new GoodsDto();
				goodDto.setGoodId(rs.getInt("goods"));
				goodDto.setGoodName(rs.getString("goodsname"));
				goodDto.setGoodWeight(rs.getString("goodsweight"));
				goodDto.setGoodBulk(rs.getString("goodsbulk"));
				goodDto.setGoodUnit(rs.getString("goodsunit"));
				goodDto.setGoodPrice(rs.getString("goodsprice"));
				goodDto.setNum(rs.getInt("num"));
				goodDto.setStoreId(rs.getInt("store"));
				goodDto.setInDate(rs.getString("indate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodDto;
	}
	
	public List<GoodsDto> getGoodByGoodName(String goodName){
		List<GoodsDto> listGoodsDto = new ArrayList<GoodsDto>();
		String sql = "select a.*,b.num num,b.store store from tbl_goods a,tbl_storerefgoods b where a.goods = b.goods  and a.goodsname = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, goodName);
			rs = pst.executeQuery();
			while(rs.next()){
				GoodsDto goodDto = new GoodsDto();
				goodDto.setGoodId(rs.getInt("goods"));
				goodDto.setGoodName(rs.getString("goodsname"));
				goodDto.setGoodWeight(rs.getString("goodsweight"));
				goodDto.setGoodBulk(rs.getString("goodsbulk"));
				goodDto.setGoodUnit(rs.getString("goodsunit"));
				goodDto.setGoodPrice(rs.getString("goodsprice"));
				goodDto.setNum(rs.getInt("num"));
				goodDto.setStoreId(rs.getInt("store"));
				goodDto.setInDate(rs.getString("indate"));
				listGoodsDto.add(goodDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listGoodsDto;
	}

	public List<GoodsDto> getGoodsByStoreId(int storeId) {
		List<GoodsDto> listGoodsDto = new ArrayList<GoodsDto>();
		String sql = "select a.*,b.num num,b.store store from tbl_goods a,tbl_storerefgoods b where a.goods = b.goods  and b.store = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, storeId);
			rs = pst.executeQuery();
			while(rs.next()){
				GoodsDto goodDto = new GoodsDto();
				goodDto.setGoodId(rs.getInt("goods"));
				goodDto.setGoodName(rs.getString("goodsname"));
				goodDto.setGoodWeight(rs.getString("goodsweight"));
				goodDto.setGoodBulk(rs.getString("goodsbulk"));
				goodDto.setGoodUnit(rs.getString("goodsunit"));
				goodDto.setGoodPrice(rs.getString("goodsprice"));
				goodDto.setNum(rs.getInt("num"));
				goodDto.setStoreId(rs.getInt("store"));
				goodDto.setInDate(rs.getString("inDate"));
				listGoodsDto.add(goodDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listGoodsDto;
	}

	public List<GoodsDto> getGoodsByStoreId(int storeId,int pageNum){
		List<GoodsDto> listGoodsDto = new ArrayList<GoodsDto>();
		String sql = "select a.*,b.num num,b.store store from tbl_goods a,tbl_storerefgoods b where a.goods = b.goods  and b.store = ? order by a.indate desc limit ?,10";
		int startIndex = 10 * (pageNum - 1);
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, storeId);
			pst.setInt(2, startIndex);
			rs = pst.executeQuery();
			while(rs.next()){
				GoodsDto goodDto = new GoodsDto();
				goodDto.setGoodId(rs.getInt("goods"));
				goodDto.setGoodName(rs.getString("goodsname"));
				goodDto.setGoodWeight(rs.getString("goodsweight"));
				goodDto.setGoodBulk(rs.getString("goodsbulk"));
				goodDto.setGoodUnit(rs.getString("goodsunit"));
				goodDto.setGoodPrice(rs.getString("goodsprice"));
				goodDto.setNum(rs.getInt("num"));
				goodDto.setStoreId(rs.getInt("store"));
				goodDto.setInDate(rs.getString("inDate"));
				listGoodsDto.add(goodDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listGoodsDto;
	}
	
	public GoodsDto getGoods(int storeId,int goodId){
		GoodsDto goodDto = null;
		String sql = "select a.*,b.num num,b.store store from tbl_goods a,tbl_storerefgoods b where a.goods = b.goods  and b.store = ? and a.goods = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, storeId);
			pst.setInt(2, goodId);
			rs = pst.executeQuery();
			if(rs.next()){
				goodDto = new GoodsDto();
				goodDto.setGoodId(rs.getInt("goods"));
				goodDto.setGoodName(rs.getString("goodsname"));
				goodDto.setGoodWeight(rs.getString("goodsweight"));
				goodDto.setGoodBulk(rs.getString("goodsbulk"));
				goodDto.setGoodUnit(rs.getString("goodsunit"));
				goodDto.setGoodPrice(rs.getString("goodsprice"));
				goodDto.setNum(rs.getInt("num"));
				goodDto.setStoreId(rs.getInt("store"));
				goodDto.setInDate(rs.getString("indate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodDto;
	}
	
	public int getGoodsNumByStoreId(int storeId){
		int count = 0;
		String sql = "select count(*) num from tbl_goods a,tbl_storerefgoods b where a.goods = b.goods and  b.store = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, storeId);
			rs = pst.executeQuery();
			if(rs.next()){
				count = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int addGoods(Goods good){
		int id = -1;
		String sql = "insert into tbl_goods(goodsname,goodsweight,goodsbulk,goodsunit,goodsprice,indate)values(?,?,?,?,?,?)";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, good.getGoodName());
			pst.setString(2, good.getGoodWeight());
			pst.setString(3, good.getGoodBulk());
			pst.setString(4, good.getGoodUnit());
			pst.setString(5, good.getGoodPrice());
			pst.setString(6, good.getInDate());
			pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			if(rs.next()){
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return id;
	}
	public int getGoodsIdByGoodsName(String goodname) {
		int goodid = -1;
		String sql = "select goods from tbl_goods where goodsname = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, goodname);
			rs = pst.executeQuery();
			if (rs.next()) {
				goodid = rs.getInt("goods");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		
		return goodid;
	}
}
