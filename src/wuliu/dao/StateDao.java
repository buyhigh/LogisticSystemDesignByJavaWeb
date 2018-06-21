package wuliu.dao;

import java.util.List;

import wuliu.entity.State;

public interface StateDao {
	/**
	 * 获取所有状态信息
	 * @return
	 */
	List<State> getAllState();
	
	/**
	 * 根据ID获取State
	 * @param state
	 * @return
	 */
	State getStateById(int state);
	
	/**
	 * 根据状态名称获取状态
	 * @param sname
	 * @return
	 */
	State getStateByName(String sname);
}
