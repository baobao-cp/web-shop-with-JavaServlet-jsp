package Controller;

import java.io.IOException;
import java.util.List;

import BEAN.category;
import BEAN.product;
import DAO.productDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/editprouct")
public class edit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		req.getRequestDispatcher("Edit.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		productDAO DAO = new productDAO();
		List<category> listc = DAO.getAll_category();
		req.setAttribute("category", listc);
		String pidString = req.getParameter("pid");
		product pro = DAO.get_one_product_by_id(pidString);
		req.setAttribute("detail", pro);
		req.setAttribute("listc", listc);
		
	}
}
