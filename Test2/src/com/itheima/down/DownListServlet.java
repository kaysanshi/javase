package com.itheima.down;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Resource;
import com.itheima.util.DaoUtils;

/**
 * Servlet implementation class DownListServlet
 */
@WebServlet(description = "文件下载", urlPatterns = { "/DownListServlet" })
public class DownListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.查找数据库找出所有的可供下载的资源信息
				String sql = "select * from netdisk";
				QueryRunner runner = new QueryRunner(DaoUtils.getSource());
				List<Resource> list = null;
				try {
					list = runner.query(sql, new BeanListHandler<Resource>(Resource.class));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//2.存入request域中带到jsp页面进行展示
				request.setAttribute("list", list);
				request.getRequestDispatcher("disk/downlist.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
