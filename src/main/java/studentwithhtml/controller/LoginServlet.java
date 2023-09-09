package studentwithhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtml.dao.StudentDao;
import studentwithhtml.dto.Student;

public class LoginServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String frontEndEmail=req.getParameter("email");
	String frontEndpassword=req.getParameter("password");
	
	StudentDao studentDao=new StudentDao();
	List<Student> studentsList=studentDao.getAllStudents();
	boolean value=false;
	
	for(Student student:studentsList) {
		if(student.getEmail().equals(frontEndEmail)) {
			value=true;
			break;
		}
	}
	PrintWriter printWriter=resp.getWriter();
	
	if(value) {
//		email is present
		Student dbStudent=studentDao.getStudentByEmail(frontEndEmail);
		if(dbStudent.getPassword().equals(frontEndpassword)) {
//			login success password is crct
			RequestDispatcher dispatcher=req.getRequestDispatcher("select.html");
			dispatcher.forward(req, resp);
		}else {
//			incorrect password
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}
		
		
	}else {
//		email is not present
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
		dispatcher.include(req, resp);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
	
}
