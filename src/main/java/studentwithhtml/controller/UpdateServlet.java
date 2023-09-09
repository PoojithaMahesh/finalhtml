package studentwithhtml.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtml.dao.StudentDao;
import studentwithhtml.dto.Student;

public class UpdateServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 int id=Integer.parseInt(req.getParameter("studentId"));
 StudentDao studentDao=new StudentDao();
 Student dbStudent=studentDao.findStudentById(id);
// dbStudent is null
 if(dbStudent!=null) {
//	 edit 
	 RequestDispatcher dispatcher=req.getRequestDispatcher("edit.html");
	 dispatcher.forward(req, resp);
	 
 }else {
	 RequestDispatcher dispatcher=req.getRequestDispatcher("update.html");
	 dispatcher.include(req, resp);
 }
 
 
 
}
}
