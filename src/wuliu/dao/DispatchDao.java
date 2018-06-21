package wuliu.dao;

import java.util.List;

import wuliu.dto.DispatchDto;
import wuliu.entity.Dispatch;

public interface DispatchDao {
	/**
	 * 增加配送通知单
	 */
	void addDispatch(Dispatch dispatch);
	
	/**
	 * 根据状态查询配送通知单
	 * @param state
	 * @return
	 */
	List<DispatchDto> getDispatchByState(int state);
	
	/**
	 * 对根据状态查询的结果分页
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<DispatchDto> getDispatchByState(int state,int pageNum);
	
	/**
	 * 得到所有的配送通知单
	 * @return
	 */
	List<DispatchDto> getAllDispatch();
	
	/**
	 * 获取第PageNum页配送单
	 * @param pageNum
	 * @return
	 */
	List<DispatchDto> getAllDispatch(int pageNum);
	
	/**
	 * 删除指定ID列表的所有配送通知单
	 * @param idList
	 */
	void deleteDispatchByIdList(String[] idList);
	
	/**
	 * 根据ID获取配送通知单
	 * @param dispatch
	 * @return
	 */
	DispatchDto getDispatchById(int dispatch);
	
	/**
	 * 修改配送通知单
	 * @param dispatch
	 */
	void updateDispatch(Dispatch dispatch);
	
	/**
	 * 获取所有配送通知单数量
	 * @return
	 */
	int getDispatchCount();
	
	/**
	 * 获取指定状态的配送通知单数量
	 * @param state
	 * @return
	 */
	int getDispatchCount(int state);
	
	/**
	 * 修改指定配送通知单的状态
	 * @param dispatch
	 * @param state
	 */
	void updateDispatchState(int dispatch,int state);
	
	/**
	 * 作废指定配送通知单列表
	 * @param dispatch
	 */
	void cancelDispatch(String[] dispatch);
		
	
	/**
	 * 通过配送单号，获取dispatch号
	 * @return
	 */
	int getDispatchidByOrderid(String Orderid);
	
	
	/**
	 * 客户用，获取第PageNum页配送单
	 * @param pageNum
	 * @return
	 */
	List<DispatchDto> getAllDispatch(String Creater,int pageNum);
	/**
	 * 客户用，获取所有配送通知单数量
	 * @return
	 */
	int getDispatchCount(String Creater);
	/**
	 * 客户用，根据状态查询配送通知单
	 * @param state
	 * @return
	 */
	List<DispatchDto> getDispatchByState(String Creater,int state);
	/**
	 * 客户用，对根据状态查询的结果分页
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<DispatchDto> getDispatchByState(String Creater,int state,int pageNum);
	/**
	 * 客户用，获取指定状态的配送通知单数量
	 * @param state
	 * @return
	 */
	int getDispatchCount(String Creater,int state);
	
	/**
	 * 客户用，得到所有的配送通知单
	 * @return
	 */
	List<DispatchDto> getAllDispatch(String Creater);
	
	
	
}
