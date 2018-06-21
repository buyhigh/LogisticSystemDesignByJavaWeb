package wuliu.dao;

import java.util.List;

import wuliu.entity.Profile;
import wuliu.entity.User;

public interface ProfileDao {
	/**
	 * 根据用户名查找用户个人信息
	 * @param uName
	 * @return
	 */
	Profile getProfileByName(String userName) ;
	/**
	 * 客户注册时需要填充相应信息
	 * @param uName
	 * @return
	 */
	public void addProfile(String username,String realname,String telphone,String address);
}
