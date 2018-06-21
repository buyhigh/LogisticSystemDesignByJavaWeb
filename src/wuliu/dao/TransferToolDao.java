package wuliu.dao;

import java.util.List;

import wuliu.dto.TransferToolDto;

public interface TransferToolDao {
	/**
	 * 根据车型获取车辆列表
	 * @param transfermodel
	 * @return
	 */
	List<TransferToolDto> getTransferToolByModel(int transferModel);
	/**
	 * 获取第pageNum页的根据车型获取的车辆列表
	 * @param transferModel
	 * @param pageNum
	 * @return
	 */
	List<TransferToolDto> getTransferToolByModel(int transferModel,int pageNum);
	/**
	 * 根据运输点获取车辆列表
	 * @param transferPlace
	 * @return
	 */
	List<TransferToolDto> getTransferToolByPlace(int transferPlace);
	/**
	 * 获取第pageNum页的根据运输点获取的车辆列表
	 * @param transferPlace
	 * @param pageNum
	 * @return
	 */
	List<TransferToolDto> getTransferToolByPlace(int transferPlace,int pageNum);
	/**
	 * 根据运输点获取车辆列表的数量
	 * @param transferPlace
	 * @return
	 */
	int getgetTransferToolByPlaceCount(int transferPlace);
	/**
	 * 获取指定运输点指定车型的车辆列表
	 * @param transferPlace
	 * @param transferModel
	 * @return
	 */
	List<TransferToolDto> getTransferTool(int transferPlace,int transferModel);
	/**
	 * 获取第pageNum页的获取指定运输点指定车型的车辆列表
	 * @param transferPlace
	 * @param transferModel
	 * @param pageNum
	 * @return
	 */
	List<TransferToolDto> getTransferTool(int transferPlace,int transferModel,int pageNum);
	/**
	 * 获取指定运输点指定车型的车辆列表的数量
	 * @param transferPlace
	 * @param transferModel
	 * @return
	 */
	int getTransferToolCount(int transferPlace,int transferModel);
	
	
	
	
	/**
	 * 根据车辆ID获取车辆信息
	 * @param transferTool
	 * @return
	 */
	TransferToolDto getTransferToolById(int transferTool);
	
	/**
	 * 修改运力工具的数量
	 * @param transfertool
	 * @param quantity
	 */
	void updateTransferToolQuantity(int transfertool,int quantity);
	
	/**
	 * 修改运力工具的状态
	 * @param transfertool
	 * @param transferstate
	 */
	void updateTransferToolState(int transfertool,int transferstate);
}
