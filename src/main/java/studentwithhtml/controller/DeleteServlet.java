package studentwithhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtml.dao.StudentDao;
import studentwithhtml.dto.Student;

public class DeleteServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("studentId"));
	StudentDao studentDao=new StudentDao();
	Student dbStudent=studentDao.deleteStudentById(id);
	PrintWriter printWriter=resp.getWriter();
	if(dbStudent!=null) {
		printWriter.print("Deleted successfully");
	}else {
		printWriter.print("id is not present");
	}
	
	
	
}
}
