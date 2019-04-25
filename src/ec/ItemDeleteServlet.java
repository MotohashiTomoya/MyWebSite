package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDateBeans;
import dao.ItemDao;

/**
 * Servlet implementation class ItemDeleteServlet
 */
@WebServlet("/ItemDeleteServlet")
public class ItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// URLからGETパラメータとしてIDを受け取る
		String id = request.getParameter("id");

		// TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
		ItemDao dao = new ItemDao();
		ItemDateBeans item = dao.findByItemDetail(id);



		// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード

		request.setAttribute("item", item);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemDelete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		ItemDao dao = new ItemDao();
		dao.DeleteItem(id);




		 response.sendRedirect("MasterItemServlet");
	}

}
