package wuliu.dao;

import java.util.List;

import wuliu.dto.SendTraTaskDto;
import wuliu.entity.SendTraTask;

public interface SendTraTaskDao {
	/**
	 * �����ɳ�����
	 * @param stt
	 */
	void addSendTraTask(SendTraTask stt);
	
	
	/**
	 * ����״̬��ȡ�ɳ�����
	 * @param state
	 * @return
	 */
	List<SendTraTaskDto> getSendTraTaskDtoByState(int state);
	
	
	/**
	 * ��ȡ��PageNumҳ���ɳ�����
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<SendTraTaskDto> getSendTraTaskDtoByState(int state,int pageNum);
	
	/**
	 * ��ȡָ��״̬���ɳ����񵥵�����
	 * @param state
	 * @return
	 */
	int getSendTraTaskCountByState(int state);
	
	/**
	 * �޸�ָ���ɳ�����Ϊָ��״̬
	 * @param sendTraId
	 * @param state
	 */
	void updateSendTraTaskState(int sendTraId,int state);
	
	/**
	 * ����ID��ȡ�ɳ�����
	 * @param sendTraId
	 * @return
	 */
	SendTraTaskDto getSendTraTaskDtoById(int sendTraId);
	
	/**
	 * ��ȡ��Ӧ�������󵥵��ɳ�����
	 * @param transferrequest
	 * @return
	 */
	SendTraTaskDto getSendTraTaskByTfq(int transferrequest);
	
}
