package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CommonService;
import java.util.Map;
import util.FileUtil;

@WebServlet("/dls")
public class DownLoadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	public DownLoadServlet() {
        super();
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id=request.getParameter("id");
		CommonService cs=new CommonService();
		//得到下载文件的信息，Map对象，封装了filePath和fileName信息。
		Map file=cs.getDownLoadFile(id);
		//实现文件下载动作
		FileUtil fu=new FileUtil();
		int r=fu.download(this.getServletContext(), response, file);
		//更新下载次数
		if(r==1){
			cs.updateHits(id);
		}
	}

}
