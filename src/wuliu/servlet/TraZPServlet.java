package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.DispUserDao;
import wuliu.dao.DispatchDao;
import wuliu.dao.TraDao;
import wuliu.dao.TransferRequestDao;
import wuliu.dao.TransferTaskDao;
import wuliu.dao.impl.DispUserDaoImpl;
import wuliu.dao.impl.DispatchDaoImpl;
import wuliu.dao.impl.TraDaoImpl;
import wuliu.dao.impl.TransferRequestDaoImpl;
import wuliu.dao.impl.TransferTaskDaoImpl;
import wuliu.dto.DispatchDto;
import wuliu.dto.TraDto;
import wuliu.dto.TransferRequestDto;
import wuliu.dto.TransferTaskDto;
import wuliu.entity.DispUser;
import wuliu.entity.Tra;

public class TraZPServlet extends HttpServlet {

	private static final long serialVersionUID = 4135164524541160351L;
	private TransferTaskDao transferTaskDao = new TransferTaskDaoImpl();
	private DispUserDao dispUserDao = new DispUserDaoImpl();
	private TraDao traDao = new TraDaoImpl();
	private TransferRequestDao transferRequestDao = new TransferRequestDaoImpl();
	private DispatchDao dispatchDao = new DispatchDaoImpl();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		//获取所有"已审核未执行"的运输任务单
		List<TransferTaskDto> listTransferTaskDto = transferTaskDao.getTransferTaskDtoByState(2);
		
		//获取所有还有配送额的配送员
		List<DispUser> listDispUser = dispUserDao.getDispUserByCon();
		int index = 0;
		for(int i = 0 ; i < listTransferTaskDto.size() ; i++){
			//获取运输任务单
			TransferTaskDto transferTaskDto = listTransferTaskDto.get(i);
			//获取运输任务单对应的运输请求单
			TransferRequestDto transferRequestDto = transferRequestDao.getTransferRequestById(transferTaskDto.getTransferRequestId());
			//获取运输请求单对应的配送通知单
			DispatchDto dispatchDto = dispatchDao.getDispatchById(transferRequestDto.getDispatchId());
			//指派配送员后的该配送员的额度
			int newNum = 0;
			
			
			//生成运输单
			Tra td = new Tra();
			td.setGoodName(dispatchDto.getGoodName());
			td.setGoodQuantity(dispatchDto.getGoodQuantity());
			td.setReceName(dispatchDto.getReceiverName());
			td.setReceTel(dispatchDto.getReceiverTel());
			td.setReceProvince(dispatchDto.getReceiverProvince());
			td.setReceCity(dispatchDto.getReceiverCity());
			td.setReceStreet(dispatchDto.getReceiverStreet());
			td.setTransferTaskId(transferTaskDto.getTransferTaskId());
			//判断是否还有可用的配送员进行指派
			if(index >= listDispUser.size()){
				//表示没有可用的配送员进行指派,将配送员ID设为－1,并且不改变相应运输任务单的状态
				td.setDispUserId(-1);
			}else{
				//表示还有可用的配送员来指派,并且改变运输任务单的状态为"已执行－－5"
				//指定该运输单的配送员
				DispUser dispUser = listDispUser.get(index);
				//设置该运输单的配送员编号
				td.setDispUserId(dispUser.getDispUserId());
				//减少该配送员的额度一次
				newNum = dispUser.getDispNum() + 1;
				//更新该配送员的额度
				dispUserDao.updateDispUserNum(dispUser.getDispUserId(),newNum);
				//设置对应的运输任务单的状态为"已执行－－5"
				transferTaskDao.updateTransferTaskState(transferTaskDto.getTransferTaskId(), 5);
				//判断该配送员的配送额是否达到上限
				if(newNum == 10){
					//表明该配送员的配送额已经达到上限,需要换下一个配送员
					index++;
				}
			}
			//增加运输单到数据库
			traDao.addTra(td);
		}
		int pageNum = 1;//当前页码
		int maxPageNum = 1;//总页数
		int totalCount = 0;//总的记录数
		
		List<TraDto> listTraDto = traDao.getTraPage(pageNum);
		totalCount = traDao.getTraCount();
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		
		
		request.setAttribute("curPage",pageNum);
		request.setAttribute("maxPage", maxPageNum);
		request.setAttribute("count", totalCount);
		request.setAttribute("listTraDto", listTraDto);
		request.getRequestDispatcher("/tra/tra_trazp.jsp").forward(request,response);
	}

}
