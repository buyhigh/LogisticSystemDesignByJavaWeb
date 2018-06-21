package wuliu.dao;

import java.util.List;

import wuliu.dto.TransferRequestDto;
import wuliu.entity.TransferRequest;

public interface TransferRequestDao {
	/**
	 * ������������
	 * @param tfr
	 */
	void addTransferRequest(TransferRequest tfr);
	
	/**
	 * ��ȡָ��״̬����������
	 * @param state
	 * @return
	 */
	List<TransferRequestDto> getTransferRequestByState(int state);
	/**
	 * ��ȡ��pageNumҳ�ĸ���״̬��ȡ����������
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<TransferRequestDto> getTransferRequestByState(int state,int pageNum);
	
	/**
	 * ��ȡָ��״̬���������󵥵�����
	 * @param state
	 * @return
	 */
	int getTransferRequestByStateCount(int state);
	
	/**
	 * ����ID��ȡ��������
	 * @param transferrequest
	 * @return
	 */
	TransferRequestDto getTransferRequestById(int transferrequest);
	
	/**
	 * �޸�ָ���������󵥵�״̬Ϊָ��״̬
	 * @param transferrequest
	 * @param state
	 */
	void updateTransferRequestDto(int transferrequest,int state);
	
	
}
