package wuliu.dao;

import java.util.List;

import wuliu.entity.Driver;

public interface DriverDao {
	/**
	 * 根据司机状态获取司机
	 * @param driverState
	 * @return
	 */
	List<Driver> getDriverByState(int driverState);
	
	/**
	 * 更新指定司机的状态
	 * @param driverId
	 * @param driverState
	 */
	void updateDriverState(int driverId,int driverState);
	
	/**
	 * 根据ID获取司机
	 * @param driver
	 * @return
	 */
	Driver getDriverById(int driver);
}
