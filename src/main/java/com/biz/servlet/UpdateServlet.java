package com.biz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.utils.Tools;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("sid");
		String name=request.getParameter("name");
		String birthday=request.getParameter("birthday");
		String description=request.getParameter("descriptoin");
		String scorestr=request.getParameter("score");
		String strPage=request.getParameter("pageNum");
		String member1=request.getParameter("member");
		
		String mamber2=id+"~-"+name+"~-"+birthday+"~-"+description;
		double score=0;
		if(scorestr!=null&&!scorestr.trim().equals("")) {
			score=Double.parseDouble(scorestr);
		}
		System.out.println(score);
		Tools.deleteStudent(member1);
		Tools.insertStudent(score, mamber2);
		response.sendRedirect("ShowPage?pageNum="+strPage);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
