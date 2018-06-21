package wuliu.dao;

import java.util.List;

import wuliu.dto.InStoreRequestDto;
import wuliu.entity.InStoreRequest;

public interface InStoreRequestDao {
	
	/**
	 * ����ID��ȡ�������
	 * @param instorerequest
	 * @return
	 */
	InStoreRequestDto getInStoreRequestById(int instorerequest);
	
	
	/**
	 * ����״̬��ȡ�������
	 * @param state
	 * @return
	 */
	List<InStoreRequestDto> getInStoreRequestByState(int state);
	
	/**
	 * ��ȡ��pageNumҳ�ĸ���״̬��ȡ���������
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<InStoreRequestDto> getInStoreRequestByState(int state,int pageNum);
	
	/**
	 * ��ȡָ��״̬��������󵥵���Ŀ
	 * @param state
	 * @return
	 */
	int getInStoreRequestByStateCount(int state);
	
	
	/**
	 * �޸�������󵥵�״̬Ϊָ��״̬
	 * @param instorerequest
	 * @param state
	 */
	void updateInStoreRequestState(String[] idList,int state);
	
	
	/**
	 * �����������
	 * @param isr
	 */
	void addInStoreRequest(InStoreRequest isr);
	
}
