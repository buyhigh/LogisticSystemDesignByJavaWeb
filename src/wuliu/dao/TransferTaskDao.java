package wuliu.dao;

import java.util.List;

import wuliu.dto.TransferTaskDto;
import wuliu.entity.TransferTask;

public interface TransferTaskDao {
	/**
	 * ������������
	 * @param tt
	 */
	void addTransferTask(TransferTask tt);
	
	/**
	 * ����״̬��ȡ��������
	 * @param state
	 * @return
	 */
	List<TransferTaskDto> getTransferTaskDtoByState(int state);
	
	
	/**
	 * ��ȡ��pageNumҳ����������
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<TransferTaskDto> getTransferTaskDtoByState(int state,int pageNum);
	
	
	/**
	 * ��ȡָ��״̬���������񵥵�����
	 * @param state
	 * @return
	 */
	int getTransferTaskDtoByStateCount(int state);
	
	/**
	 * ����ID��ȡ��������
	 * @param transferTask
	 * @return
	 */
	TransferTaskDto getTransferTaskDtoById(int transferTask);
	
	/**
	 * �޸��������񵥵�״̬
	 * @param state
	 */
	void updateTransferTaskState(int transferTask,int state);
}
