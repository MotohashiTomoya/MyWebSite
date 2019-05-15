package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.ItemDateBeans;
import dao.ItemDao;

/**
 * Servlet implementation class ItemUpdateServlet
 */
@WebServlet("/ItemUpdateServlet")
@MultipartConfig(location="C:\\Users\\User\\Documents\\GitHub\\MyWebSite\\WebContent\\img", maxFileSize=1048576)
public class ItemUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemUpdateServlet() {
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

		// 確認用：idをコンソールに出力
		System.out.println(id);

		// TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
		ItemDao dao = new ItemDao();
		ItemDateBeans item = dao.findByItemDetail(id);

		// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード

		request.setAttribute("item", item);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemUpdate.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String itemId=request.getParameter("itemId");
		String itemName=request.getParameter("itemName");
		String itemDetail=request.getParameter("itemDetail");
		String itemPrice=request.getParameter("itemPrice");
		Part part = request.getPart("image");

//		if文を追加してfileに値が入っているときと入っていない時を分岐させうまくやる
//


        ItemDao dao=new ItemDao();

//		空欄になっている場合
		if(itemName.isEmpty()||itemDetail.isEmpty()||itemPrice.isEmpty() || part.getSubmittedFileName().isEmpty()) {
			ItemDateBeans i=new ItemDateBeans();
			i.setId(Integer.parseInt(itemId));
			i.setName(itemName);
			i.setDetail(itemDetail);
			i.setPrice(itemPrice);
			request.setAttribute("item", i);
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemUpdate.jsp");
			dispatcher.forward(request, response);

			return;
		}

        String image = this.getFileName(part);
        part.write(image);

		dao.UpdateItem(itemName,itemDetail,itemPrice,image, itemId);
		response.sendRedirect("MasterItemServlet");
	}

	 private String getFileName(Part part) {
	        String name = null;
	        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
	            if (dispotion.trim().startsWith("filename")) {
	                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
	                name = name.substring(name.lastIndexOf("\\") + 1);
	                break;
	            }
	        }
	        return name;
	    }


}
