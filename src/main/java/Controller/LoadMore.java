package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import BEAN.product;
import DAO.productDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/load")
public class LoadMore extends HttpServlet{
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				productDAO dao = new productDAO();
				String amout = req.getParameter("exits");;
				List<product> nextList = dao.get_next_product(amout);
				
				PrintWriter printWriter = resp.getWriter();
				for(product o : nextList) {
					printWriter.println("<div class=\"product col-12 col-md-6 col-lg-3\">\n"
		                    + "                                <div class=\"card rcorners\" >\n"
		                    + "                                    <img class=\"card-img-top zoom\" src=\""+o.getImage()+"\" alt=\"Card image cap\">\n"
		                    + "                                    <div class=\"card-body\">\n"
		                    + "                                        <h4 class=\"card-title show_txt\"><a href=\"detail?pid="+o.getId()+"\" title=\"View Product\">"+o.getName()+"</a></h4>\n"
		                    + "                                        <p class=\"card-text show_txt\">"+o.getTitle()+"</p>\n"
		                    + "                                        <div class=\"row\">\n"
		                    + "                                            <div class=\"col\">\n"
		                    + "                                                <p class=\"btn btn-danger btn-block\">"+o.getPrice()+" $</p>\n"
		                    + "                                            </div>\n"
		                    + "                                            <div class=\"col\">\n"
		                    + "                                                <a href=\"#\" class=\"btn btn-success btn-block\">Add to cart</a>\n"
		                    + "                                            </div>\n"
		                    + "                                        </div>\n"
		                    + "                                    </div>\n"
		                    + "                                </div>\n"
		                    + "                            </div>");
				}
			}
}
