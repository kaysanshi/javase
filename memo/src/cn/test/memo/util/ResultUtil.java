package cn.test.memo.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ResultUtil {
	public static void toJson(HttpServletResponse response, Object data) {
    	try {
	    	Gson gson = new Gson();
	    	String result = gson.toJson(data);
	    	response.setContentType("application/json; charset=utf-8");
	    	response.setHeader("Cache-Control", "no-cache"); //取消浏览器缓存
	     	PrintWriter out = response.getWriter();
	     	out.print(result);
	     	out.flush();
	    	out.close();
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
