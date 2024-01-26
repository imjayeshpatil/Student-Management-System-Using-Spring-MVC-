package com.jspiders.smswithspringmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.smswithspringmvc.pojo.AdminPojo;
import com.jspiders.smswithspringmvc.repository.AdminRepository;
import com.jspiders.smswithspringmvc.service.AdminService;

@Controller
public class AdminController {
		
	@Autowired
	private AdminService adminService; 
	
	@RequestMapping(path="/add_admin" , method= RequestMethod.GET)
	public String getaddadmin() {
		
		return "add_admin";
	}
	
	@RequestMapping(path="/add_admin" , method= RequestMethod.POST)
	public String getaddadmin(@RequestParam String username,@RequestParam String email,@RequestParam String password, ModelMap modelMap, HttpSession httpSession) {
		adminService.addAdmin(username,email,password);
		modelMap.addAttribute("message", "Admin Added.");
		return "add_admin";
	}
	
	
	
	@RequestMapping(path="log_in" , method= RequestMethod.GET)
	public String logout() {
		return "log_in";
		
	}
	
	@RequestMapping(path="log_in" , method= RequestMethod.POST)
	public String login(@RequestParam String username,@RequestParam String password, ModelMap modelMap, HttpSession httpSession) {
		AdminPojo admin =  adminService.login(username,password);
		if(admin!=null) {
			httpSession.setAttribute("admin", admin);
			httpSession.setMaxInactiveInterval(1800);
			modelMap.addAttribute("message", "Logged in");
			modelMap.addAttribute("message","LOGIN SUCESSFULLY");
			return "home";
		}
		modelMap.addAttribute("message","INVALID USER & ID PASSWORD");
		return "log_in";
	}
	
	
	
	
	@RequestMapping(path = "/delete_admin", method = RequestMethod.GET)
	public String deleteAdmin(@RequestParam String email, ModelMap modelMap, HttpSession httpSession) {
		AdminPojo admin = (AdminPojo) httpSession.getAttribute("admin");
		if (admin != null) {
			adminService.deleteAdmin(email);
			modelMap.addAttribute("message", "Admin deleted");
		}
		return "log_in";
	}

	@RequestMapping(path = "/log_out", method = RequestMethod.GET)
	public String logOut(HttpSession httpSession) {
		httpSession.invalidate();
		return "log_in";
	}
	

}
