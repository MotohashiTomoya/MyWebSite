package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDateBeans;
import beans.BuyDetailDateBeans;
import beans.CartDateBeans;
import beans.UserDateBeans;
import dao.CartDao;

/**
 * Servlet implementation class CartConfirmServlet
 */
@WebServlet("/BuyConfirmServlet")
public class BuyConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		UserDateBeans us=(UserDateBeans) session.getAttribute("userInfo");
		ArrayList<CartDateBeans> cart = CartDao.findcart(us.getId());
		int total= CartDao.totalPrice(us.getId());


		request.setAttribute("cart", cart);
		request.setAttribute("total", total);


		// 購入確認のjspにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/buyConfirm.jsp");
				dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		HttpSession session = request.getSession();
		UserDateBeans us=(UserDateBeans) session.getAttribute("userInfo");
//		buyにinsert
		BuyDateBeans bdb = new BuyDateBeans();
		bdb.setUserId((int) session.getAttribute("userId"));
		request.setAttribute("bdb", bdb);
//		buy_detailにinsert
		BuyDetailDateBeans bddb=new BuyDetailDateBeans();
		request.setAttribute("bddb", bddb);
//		カートを削除
		CartDao cartDao = new CartDao();
		cartDao.DeleteCart(us.getId());

		 response.sendRedirect("ItemServlet");

	}

}
