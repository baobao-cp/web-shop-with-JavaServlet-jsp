package Controller;

import java.io.IOException;



import BEAN.Acount;
import DAO.productDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/add")
public class Add extends HttpServlet{
		
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=UTF-8");
			String name = req.getParameter("name");
			String image = req.getParameter("image");
			String price = req.getParameter("price");
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			String category = req.getParameter("category");
			HttpSession session = req.getSession();
			Acount acount = (Acount) session.getAttribute("acc");
			int cid = acount.getId();
			
			productDAO dao = new productDAO();
			dao.Add(name, image, price, title, description, category, cid);
			
			}
			
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
			
			resp.setContentType("text/html;charset=UTF-8");
			req.getRequestDispatcher("manager").forward(req, resp);
		}
}
