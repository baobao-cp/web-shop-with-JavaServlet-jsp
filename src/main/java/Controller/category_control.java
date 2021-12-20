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

@WebServlet(name = "CategoryControl", urlPatterns = {"/category"})
public class category_control extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		productDAO DAO = new productDAO();
		String cid = req.getParameter("id");
		List<product> list = DAO.getAllproduct_byid(cid);
		List<category> listc = DAO.getAll_category();
		product max_id_product = DAO.get_MAX_idProduct();
		req.setAttribute("product", list);
		req.setAttribute("category", listc);
		req.setAttribute("MAXID", max_id_product);
		req.setAttribute("tag", cid);
	}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    	RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
		rd.forward(req, resp);
    	
    }
}
