package com.bhasad.api.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employees")
public class Employee {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "employeeNumber")
	private Integer employeeNumber;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "firstName")
    private String firstName;
    
	@Column(name = "extension", nullable = true)
    private String extension;
    
	@Column(name = "email")
    private String email;
    
	@Column(name = "officeCode", nullable = true)
    private Integer officeCode;
    
	@Column(name = "reportsTo", nullable = true)
    private Integer reportsTo;
    
	@Column(name = "jobTitle", nullable = true)
    private String jobTitle;

    public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(Integer officeCode) {
		this.officeCode = officeCode;
	}

	public Integer getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(Integer reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}
