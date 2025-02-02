package chapter23;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import bean.Product;
import dao.ProductDAO;
import tool.Action;

public class SearchAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	)throws Exception {

		String keyword=request.getParameter("keyword");

		ProductDAO dao=new ProductDAO();
		List<Product> list=dao.search(keyword);

		request.setAttribute("list", list);

		return "list.jsp";
	}

}
