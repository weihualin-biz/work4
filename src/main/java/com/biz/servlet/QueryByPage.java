package com.biz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.po.Student;
import com.biz.utils.Tools;

/**
 * Servlet implementation class QueryByPage
 */
public class QueryByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryByPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       String pageNum=request.getParameter("pageNum");
		System.out.println("∑÷“≥≤È—Ø");
		int page=1;
		if(pageNum!=null&&!pageNum.trim().equals("")) {
			page=Integer.parseInt(pageNum);
		}
		List<Student> list=Tools.queryStudentByPage(page);
	    long pageSum=Tools.getPageNum();
	    
		request.setAttribute("list", list);
		request.setAttribute("pageSum", pageSum);
		request.setAttribute("pageNum", page);
		
		request.getRequestDispatcher("ShowPage.jsp").forward(request, response);
		System.out.println(list);
		System.out.println("pageNum:"+page);
		System.out.println("pageSum:"+pageSum);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
