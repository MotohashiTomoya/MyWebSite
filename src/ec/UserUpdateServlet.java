package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDateBeans;
import dao.UserDao;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		ログインセッションがない場合、ログイン画面にリダイレクトする
		HttpSession session = request.getSession();
		UserDateBeans us=(UserDateBeans) session.getAttribute("userInfo");

		if(us==null) {
			response.sendRedirect("LoginServlet");
			return;
		}
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		// URLからGETパラメータとしてIDを受け取る
		String id = request.getParameter("id");

		// 確認用：idをコンソールに出力
		System.out.println(id);

		// TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
		UserDao dao = new UserDao();
		UserDateBeans user = dao.findByUserDetail(id);

		// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード

		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String passwordP = request.getParameter("passwordP");
		String name = request.getParameter("name");


		UserDao dao = new UserDao();

		if (!password.equals(passwordP) || name.isEmpty()) {

			UserDateBeans u = new UserDateBeans();
			// IDセット（エラー時共通）
			u.setId(Integer.parseInt(id));
			// ログインIDセット（エラー時共通）
			u.setLoginId(loginId);

			// 名前が空でない場合、名前セット
			if (!name.isEmpty()) {
				u.setName(name);
			}
			// 元画面の表示用情報を格納
			request.setAttribute("user", u);
			// エラーメッセージセット
			request.setAttribute("errMsg", "入力された内容は正しくありません");
			// 元画面に画面遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
			dispatcher.forward(request, response);
			return;

		} if (password.isEmpty() || passwordP.isEmpty()) {
			dao.UpdateUser2(id, name);
			response.sendRedirect("ItemServlet");
		}else {
			// success
			// 登録処理
			dao.UpdateUser(id, password, name);

			// 一覧画面に遷移（doGet実行）
			response.sendRedirect("ItemServlet");
		}



	}

	}


