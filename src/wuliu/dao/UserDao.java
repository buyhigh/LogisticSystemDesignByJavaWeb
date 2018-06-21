package wuliu.dao;

import java.util.List;

import wuliu.entity.User;

public interface UserDao {
	/**
	 * �����û��������û�
	 * @param uName
	 * @return
	 */
	User getUserByName(String uName);
	
	/**
	 * �����û�ID�����û�
	 * @param uId
	 * @return
	 */
	User getUserByUId(int uId);
	/**
	 * �г����е��û���Ϣ
	 * @param 
	 * @return
	 */
	List<User> getUserByType(int uType);
	/**
	 * ����˺�
	 * @param 
	 * @return
	 */
	void addUser(String username,String password,int uType);
	/**
	 * �����û���id��ɾ���˺�
	 * @param 
	 * @return
	 */
	void delUser(int uId);
}
