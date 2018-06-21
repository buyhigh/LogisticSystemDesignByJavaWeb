package wuliu.dao;

import java.util.List;

import wuliu.entity.SaveDivStore;

public interface SaveDivStoreDao {
	/**
	 * 根据状态找到所有符合的单
	 * @param uId
	 * @return
	 */
	List<SaveDivStore> getSaveDivStoreBystate(int state);
	/**
	 * 根据id号寻找配送单id
	 * @param 
	 * @return
	 */
	String getDispatchIdById(int id);
	/**
	 * 添加账号
	 * @param 
	 * @return
	 */
	void addSaveDivStore(String dispatchId,String goodsName,int goodsQuantity,String creater,int state,String sendTime);
	/**
	 * 根据id号修改单的状态
	 * @param 
	 * @return
	 */
	void UpdateSaveDivStore(int id ,int state);
	/**
	 * 根据配送任务单号查看是否在独立存储有货
	 * @param 
	 * @return
	 */
	int getDivStoreIdByOutStoreTask(int OutStoreTaskid);
}
