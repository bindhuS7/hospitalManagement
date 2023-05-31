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
import Dto.DoctorDto;
@WebServlet("/doctorSignup")
public class DoctorSignup extends HttpServlet {

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	DoctorDto doctor=new DoctorDto();
	
	
String name=req.getParameter("Name");
String	email=req.getParameter("mail");
long mobile=Long.parseLong(req.getParameter("mobile"));
String qualification=	req.getParameter("qualification");
String 	specialization=req.getParameter("specialization");
	String password=req.getParameter("password");
	Date dob=Date.valueOf(req.getParameter("DOB"));
	String gender=req.getParameter("gender");
	
	int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();	
	
	doctor.setName(name);
	doctor.setEmail(email);
	doctor.setMobile(mobile);
	doctor.setQualification(qualification);
	doctor.setSpecialization(specialization);
	doctor.setPassword(password);
	doctor.setDOB(dob);
	doctor.setGender(gender);
	doctor.setAge(age);
	
	
	HospitalDao dao= new HospitalDao();
	dao.saveDoctor(doctor);
	
	
	resp.getWriter().print("<h1>Doctor details saved successfully</h1>");
	resp.getWriter().print("<h1>your staff id id"+doctor.getId()+"</h1>");
	req.getRequestDispatcher("Login.html").include(req, resp);
	
	
	
}
}
