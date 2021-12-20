package Controller;

import java.io.IOException;

import javax.net.ssl.SSLContext;

import BEAN.Acount;
import DAO.productDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class login extends HttpServlet{
			/**
	 * 
	 */
	private static final long serialVersionUID = -7972909307620438317L;

			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
				String name = req.getParameter("user");
				String pass = req.getParameter("pass");
				String repass = req.getParameter("repass");
				productDAO dao = new productDAO();
				
				if(!repass.equals(pass)) {
					resp.sendRedirect("Login.jsp");
				}else {
					if(!dao.check_acount(name)){
						dao.Register(name, repass);
						resp.sendRedirect("home");
					}else {
						req.setAttribute("mes", "Sigup False");	
						req.getRequestDispatcher("Login.jsp").forward(req, resp);
					}
				}
			}
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String name = req.getParameter("user");
			    String pass = req.getParameter("pass");
				productDAO dao = new productDAO();
				Acount acount= dao.check_acount_login(name, pass);
				if(acount!=null) {
					HttpSession ss = req.getSession();
					ss.setAttribute("acc", acount);
					ss.setMaxInactiveInterval(5);
					req.getRequestDispatcher("home").forward(req, resp);
				}else {
					
					req.setAttribute("mess", "Wrong");
					req.getRequestDispatcher("Login.jsp").forward(req, resp);
				}
			}
}
