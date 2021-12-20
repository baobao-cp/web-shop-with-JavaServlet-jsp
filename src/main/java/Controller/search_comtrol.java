package Controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import BEAN.category;
import BEAN.product;
import DAO.productDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/search")
public class search_comtrol extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		String txtString = req.getParameter("txt");
		productDAO DAO = new productDAO();
		List<category> listc = DAO.getAll_category();
		//product max_id_product = DAO.get_MAX_idProduct();
		product max_id_product = DAO.get_MAX_idProduct();
		List<product> list = DAO.getAllproduct_by_seachtxt(txtString);
		
		
		req.setAttribute("product", list);		
		req.setAttribute("category", listc);
		req.setAttribute("MAXID", max_id_product);
		
		
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    	RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
		rd.forward(req, resp);
    	
    }
}
