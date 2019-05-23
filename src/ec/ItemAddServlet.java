package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CartDateBeans;
import beans.UserDateBeans;
import dao.CartDao;

/**
 * Servlet implementation class ItemAddServlet
 */
@WebServlet("/ItemAddServlet")
public class ItemAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String itemId=request.getParameter("itemId");
		HttpSession session = request.getSession();
		UserDateBeans us=(UserDateBeans) session.getAttribute("userInfo");



		CartDao cartDao =new CartDao();
		CartDateBeans cart = cartDao.InsertInfomation(itemId, us.getId());

		request.setAttribute("cart", cart);

		response.sendRedirect("ItemServlet");


	}

}
