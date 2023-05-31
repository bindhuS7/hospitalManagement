package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.HospitalDao;
import Dto.StaffDto;

@WebServlet("/staffSignup")
public class StaffSignUp extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("Name");
	    String	mail=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String password=req.getParameter("password");
		Date dob=Date.valueOf(req.getParameter("DOB"));
		String gender=req.getParameter("gender");
		
//		int age=LocalDate.now().getYear()-(Date.valueOf(dob)).toLocalDate().getYear();
		
		int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		
		StaffDto staff=new StaffDto();
		staff.setName(name);
		staff.setMobile(Long.parseLong(mobile));
		staff.setEmail(mail);
		staff.setDOB(dob);
		staff.setGender(gender);
		staff.setPassward(password);
		staff.setAge(age);
		
		HospitalDao dao=new HospitalDao();
		dao.saveStaff(staff);
		
		
		
		resp.getWriter().print("<h1>staff  details entered successfully</h1>");
		resp.getWriter().print("<h1>your staff id id"+staff.getId()+"</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
}
