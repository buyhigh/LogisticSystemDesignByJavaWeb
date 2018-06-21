package wuliu.dao;

import wuliu.entity.CarTime;

public interface CarTimeDao {
	/**
	 * 增加车次信息
	 * @param ct
	 */
	void addCarTime(CarTime ct);
	
	
	/**
	 * 删除车次信息
	 * @param driver
	 * @param transfertool
	 */
	void deleteCarTime(int driver,int transfertool);
}
