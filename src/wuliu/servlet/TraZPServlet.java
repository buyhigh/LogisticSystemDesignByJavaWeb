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
		//��ȡ����"�����δִ��"����������
		List<TransferTaskDto> listTransferTaskDto = transferTaskDao.getTransferTaskDtoByState(2);
		
		//��ȡ���л������Ͷ������Ա
		List<DispUser> listDispUser = dispUserDao.getDispUserByCon();
		int index = 0;
		for(int i = 0 ; i < listTransferTaskDto.size() ; i++){
			//��ȡ��������
			TransferTaskDto transferTaskDto = listTransferTaskDto.get(i);
			//��ȡ�������񵥶�Ӧ����������
			TransferRequestDto transferRequestDto = transferRequestDao.getTransferRequestById(transferTaskDto.getTransferRequestId());
			//��ȡ�������󵥶�Ӧ������֪ͨ��
			DispatchDto dispatchDto = dispatchDao.getDispatchById(transferRequestDto.getDispatchId());
			//ָ������Ա��ĸ�����Ա�Ķ��
			int newNum = 0;
			
			
			//�������䵥
			Tra td = new Tra();
			td.setGoodName(dispatchDto.getGoodName());
			td.setGoodQuantity(dispatchDto.getGoodQuantity());
			td.setReceName(dispatchDto.getReceiverName());
			td.setReceTel(dispatchDto.getReceiverTel());
			td.setReceProvince(dispatchDto.getReceiverProvince());
			td.setReceCity(dispatchDto.getReceiverCity());
			td.setReceStreet(dispatchDto.getReceiverStreet());
			td.setTransferTaskId(transferTaskDto.getTransferTaskId());
			//�ж��Ƿ��п��õ�����Ա����ָ��
			if(index >= listDispUser.size()){
				//��ʾû�п��õ�����Ա����ָ��,������ԱID��Ϊ��1,���Ҳ��ı���Ӧ�������񵥵�״̬
				td.setDispUserId(-1);
			}else{
				//��ʾ���п��õ�����Ա��ָ��,���Ҹı��������񵥵�״̬Ϊ"��ִ�У���5"
				//ָ�������䵥������Ա
				DispUser dispUser = listDispUser.get(index);
				//���ø����䵥������Ա���
				td.setDispUserId(dispUser.getDispUserId());
				//���ٸ�����Ա�Ķ��һ��
				newNum = dispUser.getDispNum() + 1;
				//���¸�����Ա�Ķ��
				dispUserDao.updateDispUserNum(dispUser.getDispUserId(),newNum);
				//���ö�Ӧ���������񵥵�״̬Ϊ"��ִ�У���5"
				transferTaskDao.updateTransferTaskState(transferTaskDto.getTransferTaskId(), 5);
				//�жϸ�����Ա�����Ͷ��Ƿ�ﵽ����
				if(newNum == 10){
					//����������Ա�����Ͷ��Ѿ��ﵽ����,��Ҫ����һ������Ա
					index++;
				}
			}
			//�������䵥�����ݿ�
			traDao.addTra(td);
		}
		int pageNum = 1;//��ǰҳ��
		int maxPageNum = 1;//��ҳ��
		int totalCount = 0;//�ܵļ�¼��
		
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
