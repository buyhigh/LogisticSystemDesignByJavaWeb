package wuliu.dao;

import java.util.List;

import wuliu.entity.FinConfirm;

public interface FinConfirmDao {
	/**
	 * ���ݿͻ������Ѿ���ɵĶ���
	 * @param uName
	 * @return
	 */
	List<FinConfirm> getFinConfirmByConsumer(String Consumer) ;
	/**
	 * ���ݿͻ������Ѿ���ɵĶ���
	 * @param uName
	 * @return
	 */
	List<FinConfirm> getFinConfirmByConsumerState2(String Consumer) ;
	/**
	 * ���µĵ���״̬
	 * @param uName
	 * @return
	 */
	void updateFinConfirmState(int confirmid,int state);
	/**
	 * �������ȷ�ϵ�����
	 * @param uName
	 * @return
	 */
	void addFinConfirm(int dispatchId,int trataskid,int state,String Consumer,String Staff);
	/**
	 * ͨ����������id��ȡ���͵�������
	 * @param uName
	 * @return
	 */
	String getConsumerByTrataskid(int traTaskId);
	/**
	 * ͨ����������id��ȡ���͵�id
	 * @param uName
	 * @return
	 */
	int getDispatchIdByTrataskid(int traTaskId);
}
