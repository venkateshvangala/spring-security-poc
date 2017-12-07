package com.spring.security.poc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sp_users")
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.TABLE)
	 private int id;
	 
	 
}
