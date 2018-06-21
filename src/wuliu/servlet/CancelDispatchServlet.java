package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.DispatchDao;
import wuliu.dao.StateDao;
import wuliu.dao.impl.DispatchDaoImpl;
import wuliu.dao.impl.StateDaoImpl;
import wuliu.dto.DispatchDto;
import wuliu.entity.State;

public class CancelDispatchServlet extends HttpServlet {

	private static final long serialVersionUID = -2230818933210365607L;
	private DispatchDao dispatchDao = new DispatchDaoImpl();
	private StateDao stateDao = new StateDaoImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		int pageNum = 1;// ��ǰҳ��
		int maxPage = 1;// ���ҳ��
		int rowCount = 0;

		String curStateStr = request.getParameter("curState");
		int curState = -1;
		if (curStateStr != null && !curStateStr.equals("")) {
			curState = Integer.parseInt(curStateStr);
		}
		String pageNumStr = request.getParameter("pageNum");
		if (pageNumStr != null && !pageNumStr.equals("")) {
			pageNum = Integer.parseInt(pageNumStr);
		}

		State curStateObj = stateDao.getStateById(curState);
		List<DispatchDto> listDispatchDto = null;
		if (curStateObj == null) {
			rowCount = dispatchDao.getDispatchCount();
			listDispatchDto = dispatchDao.getAllDispatch(pageNum);
		} else {
			rowCount = dispatchDao.getDispatchCount(curState);
			listDispatchDto = dispatchDao.getDispatchByState(curState, pageNum);
		}

		if (rowCount % 10 == 0) {
			maxPage = rowCount / 10;
		} else {
			maxPage = rowCount / 10 + 1;
		}

		List<State> listState = stateDao.getAllState();

		request.setAttribute("curState", curStateObj);
		request.setAttribute("curPage", pageNum);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("listState", listState);
		request.setAttribute("listDispatchDto", listDispatchDto);
		request.getRequestDispatcher("/jd/jd_zuofeipeisongdan.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String operateStr = request.getParameter("operate");// ��ʶ�������� 1����ѯ  2������
		String stateStr = request.getParameter("stateList");// ��ǰѡ�е�״̬
		int operate = -1;
		int state = -1;
		if (operateStr != null && !operateStr.equals("")) {
			operate = Integer.parseInt(operateStr);
		}
		if (stateStr != null && !stateStr.equals("")) {
			state = Integer.parseInt(stateStr);
		}
		State curState = stateDao.getStateById(state);// ��ȡ��ǰѡ���State
		List<State> listState = stateDao.getAllState();// ��ȡ���е�State
		List<DispatchDto> listDispatchDto = null;
		switch (operate) {
		case 1:
			// ��ѯ����
			int pageNum = 1;// ��ǰҳ��
			int maxPage = 1;// ���ҳ��
			int rowCount = dispatchDao.getDispatchCount(state);// �ܵļ�¼��
			if (rowCount % 10 == 0) {
				maxPage = rowCount / 10;
			} else {
				maxPage = rowCount / 10 + 1;
			}
			listDispatchDto = dispatchDao.getDispatchByState(state, pageNum);
			request.setAttribute("curPage", pageNum);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("rowCount", rowCount);
			break;
		case 2:
			// ���ϲ���
			String[] dispatchIdList = request.getParameterValues("chkItem");
			dispatchDao.cancelDispatch(dispatchIdList);
			String curStateStr = request.getParameter("curState");
			if (curStateStr != null) {
				if (curStateStr.equals("")) {
					listDispatchDto = dispatchDao.getAllDispatch();
				} else {
					listDispatchDto = dispatchDao.getDispatchByState(Integer
							.parseInt(curStateStr));
				}
			}
			break;
		}
		request.setAttribute("listDispatchDto", listDispatchDto);
		request.setAttribute("curState", curState);
		request.setAttribute("listState", listState);
		request.getRequestDispatcher("/jd/jd_chaxunpeisongdan.jsp").forward(request, response);
	}
}
