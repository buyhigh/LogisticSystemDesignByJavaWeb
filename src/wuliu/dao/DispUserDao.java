package wuliu.dao;

import java.util.List;

import wuliu.entity.DispUser;

public interface DispUserDao {
	
	/**
	 * ����ID��ȡ����Ա
	 * @param dispUser
	 * @return
	 */
	DispUser getDispUserById(int dispUser);
	
	/**
	 * ��ȡ�������Ͷ������Ա��ÿ������ԱĬ��ֻ��10�����Ͷ
	 * @return
	 */
	List<DispUser> getDispUserByCon();
	
	
	/**
	 * �޸�ָ������Ա�����Ͷ�
	 * @param dispUser
	 * @param dispNum
	 */
	void updateDispUserNum(int dispUser,int dispNum);
}
