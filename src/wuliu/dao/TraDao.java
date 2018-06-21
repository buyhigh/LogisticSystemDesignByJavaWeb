package wuliu.dao;

import java.util.List;

import wuliu.dto.TraDto;
import wuliu.entity.Tra;

public interface TraDao {
	/**
	 * �������䵥
	 * @param t
	 */
	void addTra(Tra t);
	
	/**
	 * ��������Ա��ȡ���䵥
	 * @param dispuser
	 * @return
	 */
	List<TraDto> getTraByDispUserId(int dispuser);
	
	
	/**
	 * ��ȡ��pageNum�����䵥
	 * @param pageNum
	 * @return
	 */
	List<TraDto> getTraPage(int pageNum);
	
	
	/**
	 * ��ȡ���䵥������
	 * @return
	 */
	int getTraCount();
	
	
	/**
	 * ����ID��ȡ���䵥
	 * @param traId
	 * @return
	 */
	TraDto getTraById(int traId);
	
	
	/**
	 * �����������񵥻�ȡ���䵥
	 * @param transfertask
	 * @return
	 */
	TraDto getTraByTransferTaskId(int transfertask);
}
