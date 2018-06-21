package wuliu.dao;

import java.util.List;

import wuliu.dto.DispatchDto;
import wuliu.entity.Dispatch;

public interface DispatchDao {
	/**
	 * ��������֪ͨ��
	 */
	void addDispatch(Dispatch dispatch);
	
	/**
	 * ����״̬��ѯ����֪ͨ��
	 * @param state
	 * @return
	 */
	List<DispatchDto> getDispatchByState(int state);
	
	/**
	 * �Ը���״̬��ѯ�Ľ����ҳ
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<DispatchDto> getDispatchByState(int state,int pageNum);
	
	/**
	 * �õ����е�����֪ͨ��
	 * @return
	 */
	List<DispatchDto> getAllDispatch();
	
	/**
	 * ��ȡ��PageNumҳ���͵�
	 * @param pageNum
	 * @return
	 */
	List<DispatchDto> getAllDispatch(int pageNum);
	
	/**
	 * ɾ��ָ��ID�б����������֪ͨ��
	 * @param idList
	 */
	void deleteDispatchByIdList(String[] idList);
	
	/**
	 * ����ID��ȡ����֪ͨ��
	 * @param dispatch
	 * @return
	 */
	DispatchDto getDispatchById(int dispatch);
	
	/**
	 * �޸�����֪ͨ��
	 * @param dispatch
	 */
	void updateDispatch(Dispatch dispatch);
	
	/**
	 * ��ȡ��������֪ͨ������
	 * @return
	 */
	int getDispatchCount();
	
	/**
	 * ��ȡָ��״̬������֪ͨ������
	 * @param state
	 * @return
	 */
	int getDispatchCount(int state);
	
	/**
	 * �޸�ָ������֪ͨ����״̬
	 * @param dispatch
	 * @param state
	 */
	void updateDispatchState(int dispatch,int state);
	
	/**
	 * ����ָ������֪ͨ���б�
	 * @param dispatch
	 */
	void cancelDispatch(String[] dispatch);
		
	
	/**
	 * ͨ�����͵��ţ���ȡdispatch��
	 * @return
	 */
	int getDispatchidByOrderid(String Orderid);
	
	
	/**
	 * �ͻ��ã���ȡ��PageNumҳ���͵�
	 * @param pageNum
	 * @return
	 */
	List<DispatchDto> getAllDispatch(String Creater,int pageNum);
	/**
	 * �ͻ��ã���ȡ��������֪ͨ������
	 * @return
	 */
	int getDispatchCount(String Creater);
	/**
	 * �ͻ��ã�����״̬��ѯ����֪ͨ��
	 * @param state
	 * @return
	 */
	List<DispatchDto> getDispatchByState(String Creater,int state);
	/**
	 * �ͻ��ã��Ը���״̬��ѯ�Ľ����ҳ
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<DispatchDto> getDispatchByState(String Creater,int state,int pageNum);
	/**
	 * �ͻ��ã���ȡָ��״̬������֪ͨ������
	 * @param state
	 * @return
	 */
	int getDispatchCount(String Creater,int state);
	
	/**
	 * �ͻ��ã��õ����е�����֪ͨ��
	 * @return
	 */
	List<DispatchDto> getAllDispatch(String Creater);
	
	
	
}
