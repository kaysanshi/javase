package com.zcib.web;



import java.io.IOException;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.domain.Problem;
import com.zcib.factory.BasicFactory;
import com.zcib.service.ProblemService;

/**
 * Servlet implementation class CheckAnswerServlet
 */
/**
 * 校对答案
 * @author 555
 *
 */
@WebServlet(description = "问题校对答案", urlPatterns = { "/CheckAnswerServlet" })
public class CheckAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProblemService service=BasicFactory.getFactory().GetInstance(ProblemService.class);
		//获取随机生成的数据的id拼接到一起然后去查找答案，
		String[] listid=request.getParameterValues("subjectid");
		String title="";
		for(String s:listid){
			title+=s+",";
		}
		System.out.println(title);
		//获取考生提交的答案
				String[] A=request.getParameterValues("subjectOption");
				if (A==null) {
					request.getRequestDispatcher("/ExamieServlet").forward(request, response);
				}
		/**
		 * 出现问题
		 * 
		 
		
		//通过id来查找数据库中的对应id的项;
		List<Object[]> answer=service.serchAnswer(title);
		String s=null;
		for(Object problem : answer) {
		   s += Arrays.toString((Object[])problem);
		}
		System.out.println(s);
		
		//Iterator it = answer.iterator();
		//while(it.hasNext()) {
		 // System.out.println(it.next());
		//}
		
		
		String s1=null;
		for(String string: A){
			s1+=string;
		}
		System.out.println(s1);
		/**
		 *出现问题？？？？
		 
		if (A.toString()==answer.toString()){
			System.out.println("回答正确");
		}else{
			System.out.println("回答正确");
		}
		*/
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
