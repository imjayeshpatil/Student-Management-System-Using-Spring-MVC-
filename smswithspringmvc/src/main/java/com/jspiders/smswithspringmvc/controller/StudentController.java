package com.jspiders.smswithspringmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.smswithspringmvc.pojo.AdminPojo;
import com.jspiders.smswithspringmvc.pojo.StudentPOJO;
import com.jspiders.smswithspringmvc.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(path = "/add_student", method = RequestMethod.GET)
	public String getPageToAddStudent(HttpSession httpSession) {
		AdminPojo admin = (AdminPojo) httpSession.getAttribute("admin");
		if (admin != null) {
			return "add_student";
		} else {
			return "log_in";
		}
//		return "add_student";

	}
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String getPageToHome(HttpSession httpSession) {
		AdminPojo admin = (AdminPojo) httpSession.getAttribute("admin");
		if (admin != null) {
			return "home";
		} else {
			return "log_in";
		}
//		return "home";

	}

	@RequestMapping(path = "/add_student", method = RequestMethod.POST)
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam long mobile,
			@RequestParam byte age, ModelMap modelMap) {

		studentService.addStudent(name, email, mobile, age);
		modelMap.addAttribute("message", "student added.");

		return "add_student";
	}

	@RequestMapping(path = "/students", method = RequestMethod.GET)
	public String getAllStudent(ModelMap modelMap, HttpSession httpSession) {

		List<StudentPOJO> student = studentService.getAllStudent();

		modelMap.addAttribute("students", student);

		return "get_students";

	}

	@RequestMapping(path = "/delete_student", method = RequestMethod.GET)
	public String deleteStudent(ModelMap modelMap,HttpSession httpSession) {
		AdminPojo admin = (AdminPojo) httpSession.getAttribute("admin");
		if (admin != null) {
		List<StudentPOJO> student = studentService.getAllStudent();
		modelMap.addAttribute("students", student);
		return "delete_student";
		} else {
			return "log_in";
		}

	}

	@RequestMapping(path = "/delete_student", method = RequestMethod.POST)
	public String deleteStudent(@RequestParam int id, ModelMap modelMap) {
		String message = studentService.deleteStudent(id);
		modelMap.addAttribute("message", message);
		List<StudentPOJO> student = studentService.getAllStudent();
		modelMap.addAttribute("students", student);
		return "delete_student";

	}
	
	
	@RequestMapping(path = "edit_student", method = RequestMethod.GET)
	public String getPageToEditStudent(ModelMap modelMap, HttpSession httpSession) {
		AdminPojo admin = (AdminPojo) httpSession.getAttribute("admin");
		if (admin != null) {
		List<StudentPOJO> students = studentService.getAllStudent();
		modelMap.addAttribute("students", students);
		return "edit_student";
		} else {
			return "log_in";
		}
	}

	@RequestMapping(path = "edit_student", method = RequestMethod.POST)
	public String editStudent(@RequestParam long id, ModelMap modelMap) {
		StudentPOJO student = studentService.editStudent(id);
		modelMap.addAttribute("student", student);
		return "update_student";
	}

	@RequestMapping(path = "update_student", method = RequestMethod.POST)
	public String updateStudent(@RequestParam long id, @RequestParam String name, @RequestParam String email,
			@RequestParam long mobile, @RequestParam byte age, ModelMap modelMap) {
		studentService.updateStudent(id, name, email, mobile, age);
		List<StudentPOJO> students = studentService.getAllStudent();
		modelMap.addAttribute("students", students);
		modelMap.addAttribute("message", "Student updated.");
		return "edit_student";
	}
	
	@RequestMapping(path = "get_student", method = RequestMethod.GET)
	public String getAllStudentPage(ModelMap modelMap, HttpSession httpSession) {
		AdminPojo admin = (AdminPojo) httpSession.getAttribute("admin");
		if (admin != null) {
		List<StudentPOJO> students = studentService.getAllStudent();
		modelMap.addAttribute("students", students);
		return "get_student";
		} else {
			return "log_in";
		}
		
	}
}

