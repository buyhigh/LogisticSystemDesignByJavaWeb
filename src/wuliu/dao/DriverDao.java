package wuliu.dao;

import java.util.List;

import wuliu.entity.Driver;

public interface DriverDao {
	/**
	 * ����˾��״̬��ȡ˾��
	 * @param driverState
	 * @return
	 */
	List<Driver> getDriverByState(int driverState);
	
	/**
	 * ����ָ��˾����״̬
	 * @param driverId
	 * @param driverState
	 */
	void updateDriverState(int driverId,int driverState);
	
	/**
	 * ����ID��ȡ˾��
	 * @param driver
	 * @return
	 */
	Driver getDriverById(int driver);
}
