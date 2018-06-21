package wuliu.dao;

import java.util.List;

import wuliu.entity.DispUser;

public interface DispUserDao {
	
	/**
	 * 根据ID获取配送员
	 * @param dispUser
	 * @return
	 */
	DispUser getDispUserById(int dispUser);
	
	/**
	 * 获取还有配送额的配送员（每个配送员默认只有10个配送额）
	 * @return
	 */
	List<DispUser> getDispUserByCon();
	
	
	/**
	 * 修改指定配送员的配送额
	 * @param dispUser
	 * @param dispNum
	 */
	void updateDispUserNum(int dispUser,int dispNum);
}
