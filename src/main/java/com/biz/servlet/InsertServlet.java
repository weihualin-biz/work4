package com.biz.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.utils.Tools;

/**
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ����
		String name=request.getParameter("name");
		String birthday=request.getParameter("birthday");
		String description=request.getParameter("descriptoin");
		String scorestr=request.getParameter("score");
		//��ȡҳ��
		String strPage=request.getParameter("pageNum");
		
		
		int pageNum=1;
		double score=0;
		if(strPage!=null&&!strPage.trim().equals("")) {
			pageNum=Integer.parseInt(strPage);
		}
		if(scorestr!=null&&!scorestr.trim().equals("")) {
			score=Double.parseDouble(scorestr);
		}
		//�������id
		UUID uuid=UUID.randomUUID();
	    String id = uuid.toString().replaceAll("-", "");
	    //��id,name��ƴ�ӳ��ַ���
	    String member=id+"~-"+name+"~-"+birthday+"~-"+description;
	    Tools.insertStudent(score, member);
	    //��ת��ԭ����ҳ��
	    response.sendRedirect("ShowPage?pageNum="+pageNum);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
