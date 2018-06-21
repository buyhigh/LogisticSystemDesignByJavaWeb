package wuliu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wuliu.dao.StateDao;
import wuliu.entity.State;

public class StateDaoImpl extends BaseDao implements StateDao {

	public List<State> getAllState() {
		List<State> listState = new ArrayList<State>();
		String sql = "select * from tbl_state";
		con = getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				State state = new State();
				state.setStateId(rs.getInt("state"));
				state.setStateName(rs.getString("sname"));
				state.setStateDesc(rs.getString("descp"));
				listState.add(state);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listState;
	}
	
	public State getStateById(int state){
		State s = null;
		String sql = "select * from tbl_state where state = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, state);
			rs = pst.executeQuery();
			if(rs.next()){
				s = new State();
				s.setStateId(rs.getInt("state"));
				s.setStateName(rs.getString("sname"));
				s.setStateDesc(rs.getString("descp"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public State getStateByName(String sname){
		State state = null;
		String sql = "select * from tbl_state where sname = ?";
		con = getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, sname);
			rs = pst.executeQuery();
			if(rs.next()){
				state = new State();
				state.setStateId(rs.getInt("state"));
				state.setStateName(rs.getString("sname"));
				state.setStateDesc(rs.getString("descp"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
}
