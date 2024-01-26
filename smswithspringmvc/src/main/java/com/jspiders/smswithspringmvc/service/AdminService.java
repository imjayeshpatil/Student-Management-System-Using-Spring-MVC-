package com.jspiders.smswithspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.smswithspringmvc.pojo.AdminPojo;
import com.jspiders.smswithspringmvc.repository.AdminRepository;
import com.jspiders.smswithspringmvc.repository.StudentRepository;
@Component
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	
	public void addAdmin(String username, String email, String password) {
		AdminPojo adminPojo = new AdminPojo();
		adminPojo.setUsername(username);
		adminPojo.setEmail(email);
		adminPojo.setPassword(password);
		adminRepository.addAdmin(adminPojo);

	}
//	public void getAllAdmin() {
//		AdminRepository.getAllAdmin();
//		
//	}
	public AdminPojo login(String username, String password) {
		AdminPojo adminPojo1 = null;
		List<AdminPojo> admin = adminRepository.getAllAdmin();
		for(AdminPojo adminPojo2: admin) {
			if(adminPojo2.getUsername().equals(username) && adminPojo2.getPassword().equals(password)) {
				adminPojo1= adminPojo2;
			}
			
		}
		return adminPojo1;
	}
	
	public List<AdminPojo> getAllAdmin(){
		return adminRepository.getAllAdmin();
		
	
	}
	public void deleteAdmin(String email) {
		AdminPojo adminToBeDeleted = null;
		List<AdminPojo> admins = adminRepository.getAllAdmin();
		for (AdminPojo admin : admins) {
			if (admin.getEmail().equals(email)) {
				adminToBeDeleted = admin;
			}
		}
		adminRepository.deleteAdmin(adminToBeDeleted);
	}

}
