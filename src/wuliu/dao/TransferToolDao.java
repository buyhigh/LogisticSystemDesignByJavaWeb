package wuliu.dao;

import java.util.List;

import wuliu.dto.TransferToolDto;

public interface TransferToolDao {
	/**
	 * ���ݳ��ͻ�ȡ�����б�
	 * @param transfermodel
	 * @return
	 */
	List<TransferToolDto> getTransferToolByModel(int transferModel);
	/**
	 * ��ȡ��pageNumҳ�ĸ��ݳ��ͻ�ȡ�ĳ����б�
	 * @param transferModel
	 * @param pageNum
	 * @return
	 */
	List<TransferToolDto> getTransferToolByModel(int transferModel,int pageNum);
	/**
	 * ����������ȡ�����б�
	 * @param transferPlace
	 * @return
	 */
	List<TransferToolDto> getTransferToolByPlace(int transferPlace);
	/**
	 * ��ȡ��pageNumҳ�ĸ���������ȡ�ĳ����б�
	 * @param transferPlace
	 * @param pageNum
	 * @return
	 */
	List<TransferToolDto> getTransferToolByPlace(int transferPlace,int pageNum);
	/**
	 * ����������ȡ�����б������
	 * @param transferPlace
	 * @return
	 */
	int getgetTransferToolByPlaceCount(int transferPlace);
	/**
	 * ��ȡָ�������ָ�����͵ĳ����б�
	 * @param transferPlace
	 * @param transferModel
	 * @return
	 */
	List<TransferToolDto> getTransferTool(int transferPlace,int transferModel);
	/**
	 * ��ȡ��pageNumҳ�Ļ�ȡָ�������ָ�����͵ĳ����б�
	 * @param transferPlace
	 * @param transferModel
	 * @param pageNum
	 * @return
	 */
	List<TransferToolDto> getTransferTool(int transferPlace,int transferModel,int pageNum);
	/**
	 * ��ȡָ�������ָ�����͵ĳ����б������
	 * @param transferPlace
	 * @param transferModel
	 * @return
	 */
	int getTransferToolCount(int transferPlace,int transferModel);
	
	
	
	
	/**
	 * ���ݳ���ID��ȡ������Ϣ
	 * @param transferTool
	 * @return
	 */
	TransferToolDto getTransferToolById(int transferTool);
	
	/**
	 * �޸��������ߵ�����
	 * @param transfertool
	 * @param quantity
	 */
	void updateTransferToolQuantity(int transfertool,int quantity);
	
	/**
	 * �޸��������ߵ�״̬
	 * @param transfertool
	 * @param transferstate
	 */
	void updateTransferToolState(int transfertool,int transferstate);
}
