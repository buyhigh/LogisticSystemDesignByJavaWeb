package wuliu.dao;

import java.util.List;

import wuliu.entity.Profile;
import wuliu.entity.User;

public interface ProfileDao {
	/**
	 * �����û��������û�������Ϣ
	 * @param uName
	 * @return
	 */
	Profile getProfileByName(String userName) ;
	/**
	 * �ͻ�ע��ʱ��Ҫ�����Ӧ��Ϣ
	 * @param uName
	 * @return
	 */
	public void addProfile(String username,String realname,String telphone,String address);
}
