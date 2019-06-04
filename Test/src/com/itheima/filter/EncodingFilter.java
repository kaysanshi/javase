package com.itheima.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(description = "全站乱码过滤器", urlPatterns = { "/*" },
initParams = { 
		@WebInitParam(name ="encode", value = "UTF-8")
})
public class EncodingFilter implements Filter {
	private FilterConfig config=null;
	private String encode=null;
    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//处理get请求的乱码
		response.setContentType("text/html;charset="+encode);
		//处理post请求乱码
		//request.setCharacterEncoding(encode);
		// pass the request along the filter chain
		chain.doFilter(new MyHttpServletRequest((HttpServletRequest)request), response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config=fConfig;
		//获取参数看参数是哪一个然后把他设置给新的编码方式
		encode=config.getInitParameter(encode)==null?"utf-8":config.getInitParameter(encode);
	}

	//装饰：写一个类实现被装饰的一个接口在构造方法传入被装饰者，不想改造的方法调用原有的方法，想改造
	//的自己来写逻辑
	
class MyHttpServletRequest extends HttpServletRequestWrapper{
		private HttpServletRequest request=null;
		private boolean isNotEncode=true;
		public MyHttpServletRequest(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
			this.request=request;
		}
		@Override
		public String getParameter(String name) {
			// TODO Auto-generated method stub
			return getParameterValues(name)==null?null:getParameterValues(name)[0];
		
		
		}
		@Override
		public Map<String, String[]> getParameterMap() {
			// TODO Auto-generated method stub
			try {
				//post提交处理方式
			if (request.getMethod().equalsIgnoreCase("post")) {
				
					request.setCharacterEncoding(encode);
					return request.getParameterMap();
					
				}else if (request.getMethod().equalsIgnoreCase("get")) {
					//get处理方式
					Map<String, String[]> map=request.getParameterMap();
					if (isNotEncode) {
						for(Map.Entry<String, String[]> entry:map.entrySet()){
							String[] vsString=entry.getValue();
							for(int i=0;i<vsString.length;i++){
							vsString[i]=new String(vsString[i].getBytes("iso8859-1"),encode);
							}
						}
						isNotEncode=false;
					}
					
					return map;
				}else{
					return super.getParameterMap();
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException();
				}
			
			
			
				
		}
		@Override
		public String[] getParameterValues(String name) {
			// TODO Auto-generated method stub
			return getParameterMap().get(name);
			
		}	
	}
}
