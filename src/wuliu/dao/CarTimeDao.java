package wuliu.dao;

import wuliu.entity.CarTime;

public interface CarTimeDao {
	/**
	 * ���ӳ�����Ϣ
	 * @param ct
	 */
	void addCarTime(CarTime ct);
	
	
	/**
	 * ɾ��������Ϣ
	 * @param driver
	 * @param transfertool
	 */
	void deleteCarTime(int driver,int transfertool);
}
