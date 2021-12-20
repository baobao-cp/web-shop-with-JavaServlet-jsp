package Controller;

import java.io.IOException;
import java.util.List;

import BEAN.Acount;
import BEAN.category;
import BEAN.product;
import DAO.productDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/manager")
public class Manager_Product extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		productDAO dao = new productDAO();
		HttpSession session = req.getSession();
		Acount acount = (Acount) session.getAttribute("acc");
		List<product> list = dao.getAllproduct_by_sell_ID(acount.getId());
		List<category> listc = dao.getAll_category();
		System.out.println(list);
		System.out.println(acount.getIsSell());
		req.setAttribute("product", list);
		req.setAttribute("listc", listc);
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		req.getRequestDispatcher("ManagerProduct.jsp").forward(req, resp);
	}
}
