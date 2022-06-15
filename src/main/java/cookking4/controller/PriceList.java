package cookking4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookking4.model.RecipeDAO;
import cookking4.model.RecipeVO;

@WebServlet("/PriceList")
public class PriceList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ���ڵ�
		request.setCharacterEncoding("UTF-8");
		
		// �Ķ���� ����
		String ingr_name = request.getParameter("ingr_name");
		String price = request.getParameter("price");
		String price_100 = request.getParameter("price_100");
		
		// �����Ѱ� �����ֱ�
		RecipeVO rvo = new RecipeVO();
		rvo.setIngr_name(ingr_name);
		rvo.setPrice(price);
		rvo.setPrice_100(price_100);
		
		System.out.println("���Ծ�?");
		RecipeDAO dao = new RecipeDAO();
		
		List<RecipeVO> list = dao.priceList();

		if (list != null) {
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("PriceSearch.jsp");
			rd.forward(request, response);
		}

	}

}
