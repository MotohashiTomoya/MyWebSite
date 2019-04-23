package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserDateBeans;
import dao.UserDao;


/**
 * Servlet implementation class UserDetailServlet
 */
@WebServlet("/UserDetailServlet")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインセッションがない場合、ログイン画面にリダイレクトさせる
//				HttpSession session = request.getSession();
//				UserDateBeans us=(UserDateBeans) session.getAttribute("userInfo");
//
//				if(us==null) {
//					response.sendRedirect("LoginServlet");
//					return;
//				}

				// TODO Auto-generated method stub
				request.setCharacterEncoding("UTF-8");
				// URLからGETパラメータとしてIDを受け取る
				String id = request.getParameter("id");

				// TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
				UserDao dao = new UserDao();
				UserDateBeans user = dao.findByUserDetail(id);



				// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード

				request.setAttribute("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userDetail.jsp");
				dispatcher.forward(request, response);
			}


	}




