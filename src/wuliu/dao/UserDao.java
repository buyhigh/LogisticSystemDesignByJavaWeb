package wuliu.dao;

import java.util.List;

import wuliu.entity.User;

public interface UserDao {
	/**
	 * 根据用户名查找用户
	 * @param uName
	 * @return
	 */
	User getUserByName(String uName);
	
	/**
	 * 根据用户ID查找用户
	 * @param uId
	 * @return
	 */
	User getUserByUId(int uId);
	/**
	 * 列出所有的用户信息
	 * @param 
	 * @return
	 */
	List<User> getUserByType(int uType);
	/**
	 * 添加账号
	 * @param 
	 * @return
	 */
	void addUser(String username,String password,int uType);
	/**
	 * 根据用户的id，删除账号
	 * @param 
	 * @return
	 */
	void delUser(int uId);
}
