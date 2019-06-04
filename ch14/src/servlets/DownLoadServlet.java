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
		//�õ������ļ�����Ϣ��Map���󣬷�װ��filePath��fileName��Ϣ��
		Map file=cs.getDownLoadFile(id);
		//ʵ���ļ����ض���
		FileUtil fu=new FileUtil();
		int r=fu.download(this.getServletContext(), response, file);
		//�������ش���
		if(r==1){
			cs.updateHits(id);
		}
	}

}
