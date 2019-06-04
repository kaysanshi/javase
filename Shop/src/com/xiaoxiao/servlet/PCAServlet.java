package com.xiaoxiao.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.xiaoxiao.service.PCAService;

public class PCAServlet extends HttpServlet {
	private PCAService pcaService = new PCAService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if("findProvinces".equals(action)){
			findProvinces(request,response);
		}else if("findCities".equals(action)){
			findCities(request,response);
		}else if("findAreas".equals(action)){
			findAreas(request,response);
		}
	}
	
	private void findAreas(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String cityid = request.getParameter("cityid");
		List<Map<String,Object>> areaslist = pcaService.getAreas(cityid);
		JSONArray jsonArray =JSONArray.fromObject(areaslist);
		System.out.println(jsonArray);
		response.getWriter().println(jsonArray.toString());
	}

	private void findCities(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String provinceid = request.getParameter("provinceid");
		System.out.println(provinceid);
		List<Map<String,Object>> citieslist = pcaService.getCities(provinceid);
		JSONArray jsonArray =JSONArray.fromObject(citieslist);
		System.out.println(jsonArray.toString());
		response.getWriter().println(jsonArray.toString());
	}

	private void findProvinces(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 调用Service层获取所有省记录
		//转换成json
		//返回json字符串
		List<Map<String,Object>> provinceslist = pcaService.getProvinces();
		JSONArray jsonArray =JSONArray.fromObject(provinceslist);
		response.getWriter().println(jsonArray.toString());
	}

}
