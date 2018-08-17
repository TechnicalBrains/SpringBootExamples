/**
 * 
 */
package com.education.mgmt.sys.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 611163
 *
 */
@Entity
@Table(name = "student_details")
public class StudentDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", insertable=true, nullable=false, unique=true, updatable=false)
	private Integer id;
	private String studentCode;
	private String firstName;
	private String lastname;
	private String dateOfBirth;
	private String fathersName;
	private String street;
	private String city;
	private String zipCode;
	private String email;
	private String mobile;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the studentCode
	 */
	public String getStudentCode() {
		return studentCode;
	}

	/**
	 * @param studentCode
	 *            the studentCode to set
	 */
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the fathersName
	 */
	public String getFathersName() {
		return fathersName;
	}

	/**
	 * @param fathersName
	 *            the fathersName to set
	 */
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", studentCode=" + studentCode + ", firstName=" + firstName + ", lastname="
				+ lastname + ", dateOfBirth=" + dateOfBirth + ", fathersName=" + fathersName + ", street=" + street
				+ ", city=" + city + ", zipCode=" + zipCode + ", email=" + email + ", mobile=" + mobile + "]";
	}

}
