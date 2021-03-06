package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Student;
import com.service.StudentService;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	System.out.println("Welcome to the application");
	PrintWriter pw = response.getWriter();
	pw.println("Welcome to the servlet program");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw = response.getWriter();
		int sid = Integer.parseInt(request.getParameter("sid"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Student ss = new Student();
		ss.setSid(sid);
		ss.setName(name);
		ss.setAge(age);
		
		StudentService ser = new StudentService();
		
		String result = ser.storeStudentInfo(ss);
		pw.print(result);
	
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
	
	}
}
