package studentwithhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtml.dao.StudentDao;
import studentwithhtml.dto.Student;

public class SignUpServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		Student student=new Student();
		student.setEmail(email);
		student.setPhone(phone);
		student.setName(name);
		student.setPassword(password);
		
		StudentDao studentDao=new StudentDao();
		Student dbStudent=studentDao.signupStudent(student);
		if(dbStudent!=null) {
//			signed up successfully
//			show him a login.html
			PrintWriter printWriter=resp.getWriter();
			printWriter.print("Yes Signed up successfully");
			RequestDispatcher dispatcher= req.getRequestDispatcher("login.html");
			dispatcher.forward(req, resp);
			
		}
		
		
		
	}
}
