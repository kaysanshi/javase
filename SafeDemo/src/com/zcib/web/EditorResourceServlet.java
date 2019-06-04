package com.zcib.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zcib.domain.Resource;
import com.zcib.factory.BasicFactory;
import com.zcib.service.NewsService;
import com.zcib.service.ResourceService;

/**
 * Servlet implementation class EditorResourceServlet
 */
@WebServlet(description = "修改资源", urlPatterns = { "/addmin/EditorResourceServlet" })
public class EditorResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorResourceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResourceService service=BasicFactory.getFactory().GetInstance(ResourceService.class);
		Resource resource=new Resource();
		String id=request.getParameter("id");
		resource.setId(Integer.parseInt(id));
		Resource resourceInfo=service.getResource(resource);
		request.setAttribute("list", resourceInfo);
		request.getRequestDispatcher("/addmin/EditResource.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
