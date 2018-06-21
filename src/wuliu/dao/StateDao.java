package wuliu.dao;

import java.util.List;

import wuliu.entity.State;

public interface StateDao {
	/**
	 * ��ȡ����״̬��Ϣ
	 * @return
	 */
	List<State> getAllState();
	
	/**
	 * ����ID��ȡState
	 * @param state
	 * @return
	 */
	State getStateById(int state);
	
	/**
	 * ����״̬���ƻ�ȡ״̬
	 * @param sname
	 * @return
	 */
	State getStateByName(String sname);
}
