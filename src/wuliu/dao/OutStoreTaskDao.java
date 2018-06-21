package wuliu.dao;

import java.util.List;

import wuliu.dto.OutStoreTaskDto;
import wuliu.entity.OutStoreTask;

public interface OutStoreTaskDao {
	/**
	 * ���ӳ�������
	 * @param ost
	 */
	void addOutStoreTask(OutStoreTask ost);
	
	
	/**
	 * ����״̬��ȡ��������
	 * @param state
	 * @return
	 */
	List<OutStoreTaskDto> getOutStoreTaskDtoByState(int state);
	
	
	/**
	 * ��ȡ��pageNum�ĳ�������
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<OutStoreTaskDto> getOutStoreTaskDtoByState(int state,int pageNum);
	
	
	/**
	 * ��ȡָ��״̬�ĳ������񵥵�����
	 * @param state
	 * @return
	 */
	int getOutStoreTaskDtoByStateCount(int state);
	
	/**
	 * �޸�ָ������֪ͨ����״̬
	 * @param outstoretask
	 * @param state
	 */
	void updateOutStoreTaskState(int outstoretask,int state);
	
	
	/**
	 * ����ID��ȡ��������
	 * @param outstoretask
	 * @return
	 */
	OutStoreTaskDto getOutStoreTaskDtoById(int outstoretask);
	/**
	 * ����ID��ȡ��������
	 * @param outstoretask
	 * @return
	 */
	int getDispatchIdByOutStoreTaskId(int outstoretask);
}
