package ec;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDateBeans;
import beans.UserDateBeans;
import dao.ItemDao;

/**
 * Servlet implementation class MasterItemServlet
 */
@WebServlet("/MasterItemServlet")
public class MasterItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDateBeans us=(UserDateBeans) session.getAttribute("userInfo");

		if(us.getLoginId().equals("admin")) {

		ItemDao itemDao=new ItemDao();
		List<ItemDateBeans> item = itemDao.findAll();

		// リクエストスコープに商品一覧をセット
		request.setAttribute("Item", item);

		// 商品一覧のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/masterItem.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");

		ItemDao itemDao = new ItemDao();
		List<ItemDateBeans> item = itemDao.findSearch(name);

		request.setAttribute("Item", item);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/masterItem.jsp");
		dispatcher.forward(request, response);
	}



}
