package com.zcib.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.zcib.domain.Resource;
import com.zcib.factory.BasicFactory;
import com.zcib.service.ResourceService;

/**
 * Servlet implementation class DelResourceServlet
 */
@WebServlet(description = "删除资源", urlPatterns = { "/addmin/DelResourceServlet" })
public class DelResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelResourceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResourceService service=BasicFactory.getFactory().GetInstance(ResourceService.class);
		String id=request.getParameter("id");
		Resource resource=new Resource();
		resource.setId(Integer.parseInt(id));
		try {
			BeanUtils.populate("resource", request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean status=service.deleteResource(resource);
		if (status==true) {
			response.getWriter().write("1");
		}else {
			response.getWriter().write("0");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
