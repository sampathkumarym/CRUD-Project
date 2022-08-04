package com.springboot.app.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


import lombok.Data;

@Entity
@Data
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Name",nullable=false)
	@Size(min = 3,message = "Please Enter atleast 3 characters in name field!!")
	private String name;
	
	@Column(name="CardNumber")
	private long cardNumber;
	
	@Column(name="Date")
	private Date date;
	
	@Column(name="status")
	private boolean status;
	
	private String message;
	
	
	
	public Person() {
		
	}

	public Person(@Size(min = 3) String name, long cardNumber, Date date, boolean status) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		this.date = date;
		this.status = status;
	}


}
