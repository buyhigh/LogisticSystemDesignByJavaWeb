package wuliu.dao;

import java.util.List;

import wuliu.entity.FinConfirm;

public interface FinConfirmDao {
	/**
	 * 根据客户查找已经完成的订单
	 * @param uName
	 * @return
	 */
	List<FinConfirm> getFinConfirmByConsumer(String Consumer) ;
	/**
	 * 根据客户查找已经完成的订单
	 * @param uName
	 * @return
	 */
	List<FinConfirm> getFinConfirmByConsumerState2(String Consumer) ;
	/**
	 * 更新的单的状态
	 * @param uName
	 * @return
	 */
	void updateFinConfirmState(int confirmid,int state);
	/**
	 * 添加最终确认到货单
	 * @param uName
	 * @return
	 */
	void addFinConfirm(int dispatchId,int trataskid,int state,String Consumer,String Staff);
	/**
	 * 通过运输任务id获取配送单创建人
	 * @param uName
	 * @return
	 */
	String getConsumerByTrataskid(int traTaskId);
	/**
	 * 通过运输任务id获取配送单id
	 * @param uName
	 * @return
	 */
	int getDispatchIdByTrataskid(int traTaskId);
}
