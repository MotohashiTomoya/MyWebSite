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

import dao.ItemDao;

/**
 * Servlet implementation class NewItemServlet
 */
@WebServlet("/NewItemServlet")
@MultipartConfig(location="C:\\Users\\User\\Documents\\GitHub\\MyWebSite\\WebContent\\img", maxFileSize=1048576)
public class NewItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newItem.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String itemName=request.getParameter("itemName");
		String itemDetail=request.getParameter("itemDetail");
		String itemPrice=request.getParameter("itemPrice");
		Part part = request.getPart("image");
        String image = this.getFileName(part);
        part.write(image);


//		空欄になっている場合
		if(itemName.isEmpty()||itemDetail.isEmpty()||itemPrice.isEmpty()||image.isEmpty()) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newItem.jsp");
			dispatcher.forward(request, response);

			return;
		}
		ItemDao dao=new ItemDao();
		dao.InsertInformation(itemName,itemDetail,itemPrice,image);
		response.sendRedirect("ItemServlet");
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
