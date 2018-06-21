package wuliu.dao;

import java.util.List;

import wuliu.entity.SaveDivStore;

public interface SaveDivStoreDao {
	/**
	 * ����״̬�ҵ����з��ϵĵ�
	 * @param uId
	 * @return
	 */
	List<SaveDivStore> getSaveDivStoreBystate(int state);
	/**
	 * ����id��Ѱ�����͵�id
	 * @param 
	 * @return
	 */
	String getDispatchIdById(int id);
	/**
	 * ����˺�
	 * @param 
	 * @return
	 */
	void addSaveDivStore(String dispatchId,String goodsName,int goodsQuantity,String creater,int state,String sendTime);
	/**
	 * ����id���޸ĵ���״̬
	 * @param 
	 * @return
	 */
	void UpdateSaveDivStore(int id ,int state);
	/**
	 * �����������񵥺Ų鿴�Ƿ��ڶ����洢�л�
	 * @param 
	 * @return
	 */
	int getDivStoreIdByOutStoreTask(int OutStoreTaskid);
}
