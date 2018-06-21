package wuliu.dao;

import java.util.List;

import wuliu.dto.OutStoreRequestDto;
import wuliu.entity.OutStoreRequest;

public interface OutStoreRequestDao {
	/**
	 * ���ӳ�������
	 * @param osr
	 */
	void addOutStoreRequest(OutStoreRequest osr);
	
	
	/**
	 * ����״̬��ȡ��������
	 * @param state
	 * @return
	 */
	List<OutStoreRequestDto> getOutStoreRequestByState(int state);
	/**
	 * ��ȡ��pageNumҳ�ĸ���״̬��ȡ�ĳ�������
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<OutStoreRequestDto> getOutStoreRequestByState(int state,int pageNum);
	/**
	 * ����״̬��ȡ�ĳ������󵥵�����
	 * @param state
	 * @return
	 */
	int getOutStoreRequestByStateCount(int state);
	
	/**
	 * ��������״̬Ϊָ��״̬
	 * @param outstorerequest
	 * @param newState
	 */
	void updateOutStoreRequestState(int outstorerequest,int newState);
	
	
	/**
	 * ����ID��ȡָ���ĳ�������
	 * @param outstorerequest
	 * @return
	 */
	OutStoreRequestDto getgetOutStoreRequestById(int outstorerequest);
	
}
