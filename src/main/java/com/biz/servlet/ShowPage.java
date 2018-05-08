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
 * Servlet implementation class ShowPage
 */
public class ShowPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String type=request.getParameter("type");
		String pageNum=request.getParameter("pageNum");
		
		int page=1;
		
		if(pageNum!=null&&!pageNum.trim().equals("")) {
			page=Integer.parseInt(pageNum);
		}
		if(type==null||type.trim().equals("")) {
			//²éÑ¯ÐÅÏ¢
		   
			long pageSum=Tools.getPageNum();
		    while(page>pageSum) {
		    	page--;
		    }
		    List<Student> list=Tools.queryStudentByPage(page);
			request.setAttribute("list", list);
			request.setAttribute("pageSum", pageSum);
			request.setAttribute("pageNum", page);
			
			request.getRequestDispatcher("ShowPage.jsp").forward(request, response);
			System.out.println(list);
			System.out.println("pageNum:"+page);
			System.out.println("pageSum:"+pageSum);
		}else if(type.equals("delete")) {
			//É¾³ý
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String birthday=request.getParameter("birthday");
			String description=request.getParameter("description");
			
			String member=id+"~-"+name+"~-"+birthday+"~-"+description;
			
			System.out.println(member);
			Tools.deleteStudent(member);
			response.sendRedirect("ShowPage?pageNum="+pageNum);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
