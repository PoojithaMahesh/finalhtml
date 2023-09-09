package studentwithhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtml.dao.StudentDao;
import studentwithhtml.dto.Student;

public class SelectServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("studentId"));
	
	StudentDao studentDao=new StudentDao();
	Student dbStudent=studentDao.findStudentById(id);
	
	PrintWriter printWriter=resp.getWriter();
	if(dbStudent!=null) {
//		id is present
		printWriter.print(dbStudent);
		
	}else {
		printWriter.print("Sorry that id is not present");
	}
	
}
	
}
