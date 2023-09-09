package studentwithhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtml.dao.StudentDao;
import studentwithhtml.dto.Student;

public class EditServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	long phone=Long.parseLong(req.getParameter("phone"));
	
	Student student=new Student();
	student.setId(id);
	student.setName(name);
	student.setEmail(email);
	student.setPassword(password);
	student.setPhone(phone);
	
	StudentDao dao=new StudentDao();
	Student dbStudent=dao.updateStudent(id, student);
	PrintWriter printWriter=resp.getWriter();
	if(dbStudent!=null) {
//		updated successfully
		resp.sendRedirect("https://www.youtube.com/watch?v=qXgF-iJ_ezE");
	}else {
		
		printWriter.print("UPDATion fails that id is not present");
	}
	
	
}
}
