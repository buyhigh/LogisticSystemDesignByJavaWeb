package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.InStoreRequestDao;
import wuliu.dao.OutStoreTaskDao;
import wuliu.dao.impl.InStoreRequestDaoImpl;
import wuliu.dao.impl.OutStoreTaskDaoImpl;
import wuliu.dto.InStoreRequestDto;
import wuliu.dto.OutStoreTaskDto;

public class ExecPageServlet extends HttpServlet {

	private static final long serialVersionUID = 8258301850296715445L;
	private OutStoreTaskDao outStoreTaskDao = new OutStoreTaskDaoImpl();
	private InStoreRequestDao inStoreRequestDao = new InStoreRequestDaoImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		String actionStr = request.getParameter("action");
		if (actionStr != null && !actionStr.equals("")) {
			int action = Integer.parseInt(actionStr);
			int pageNum = 1;// 当前页码
			int maxPageNum = 1;// 总页数
			int totalCount = 0;// 总的记录数

			String pageNumStr = request.getParameter("pageNum");
			if (pageNumStr != null && !pageNumStr.equals("")) {
				pageNum = Integer.parseInt(pageNumStr);
			}
			if (action == 1) {
				// 执行出库分页

				List<OutStoreTaskDto> listOutStoreTaskDto = outStoreTaskDao
						.getOutStoreTaskDtoByState(5, pageNum);
				totalCount = outStoreTaskDao.getOutStoreTaskDtoByStateCount(5);
				if (totalCount % 10 == 0) {
					maxPageNum = totalCount / 10;
				} else {
					maxPageNum = totalCount / 10 + 1;
				}

				request.setAttribute("curPage", pageNum);
				request.setAttribute("maxPage", maxPageNum);
				request.setAttribute("count", totalCount);
				request.setAttribute("listOutStoreTaskDto", listOutStoreTaskDto);
				request.getRequestDispatcher("/kc/kc_execchuku.jsp").forward(
						request, response);
			} else if (action == 2) {
				// 执行入库分页
				List<InStoreRequestDto> listInStoreRequestDto = inStoreRequestDao
						.getInStoreRequestByState(5, pageNum);
				totalCount = inStoreRequestDao.getInStoreRequestByStateCount(5);
				if (totalCount % 10 == 0) {
					maxPageNum = totalCount / 10;
				} else {
					maxPageNum = totalCount / 10 + 1;
				}
				request.setAttribute("curPage", pageNum);
				request.setAttribute("maxPage", maxPageNum);
				request.setAttribute("count", totalCount);
				request.setAttribute("listInStoreRequestDto",
						listInStoreRequestDto);
				request.getRequestDispatcher("/kc/kc_execruku.jsp").forward(
						request, response);

			}

		}

	}
}
