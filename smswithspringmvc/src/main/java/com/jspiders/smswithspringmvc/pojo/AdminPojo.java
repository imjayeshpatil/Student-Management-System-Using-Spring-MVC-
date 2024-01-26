package com.jspiders.smswithspringmvc.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity

@Data
public class AdminPojo {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(nullable = false)
		private String username;
		@Column(nullable = false)
		private String password;
		@Column(nullable = false,unique = true)
		private String email;
}
