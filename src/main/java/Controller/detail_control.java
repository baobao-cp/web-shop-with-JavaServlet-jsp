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
@WebServlet(urlPatterns= {"/detail"})
public class detail_control extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4638181227495074024L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		Random random = new Random();
		productDAO DAO = new productDAO();
		List<product> list = DAO.getAllproduct();
		Collections.shuffle(list);
		List<category> listc = DAO.getAll_category();
		//product max_id_product = DAO.get_MAX_idProduct();
		product max_id_product = list.get(random.nextInt(list.size()));
		String idString = req.getParameter("pid");
		product product_detail = DAO.get_one_product_by_id(idString);
		System.out.println(product_detail);
		req.setAttribute("detail", product_detail);
		req.setAttribute("product", list);
		req.setAttribute("category", listc);
		req.setAttribute("MAXID", max_id_product);
	}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    	RequestDispatcher rd = req.getRequestDispatcher("Detail.jsp");
		rd.forward(req, resp);
    	
    }
}
