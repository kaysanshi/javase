package com.zcib.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.zcib.domain.News;
import com.zcib.domain.Resource;
import com.zcib.factory.BasicFactory;
import com.zcib.service.NewsService;
import com.zcib.service.ResourceService;

/**
 * Servlet implementation class SaveEditResourceServlet
 */
@WebServlet(description = "保存修改上传的资源", urlPatterns = { "/addmin/SaveEditResourceServlet" })
public class SaveEditResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEditResourceServlet() {
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
		try {
			BeanUtils.populate(resource, request.getParameterMap());
			Boolean status=service.updateResource(resource);
			if (status==true) {
				response.getWriter().write("1");
			}else{
				response.getWriter().write("0");
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
