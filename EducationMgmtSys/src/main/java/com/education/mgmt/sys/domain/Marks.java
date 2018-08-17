/**
 * 
 */
package com.education.mgmt.sys.domain;

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
@Table(name = "Marks",schema="PUBLIC")
public class Marks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", insertable = true, unique = true, nullable = false)
	private Integer id;
	private String studentCode;
	private int tamil;
	private int hindi;
	private int english;
	private int maths;
	private int science;
	private int social;

	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
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
	 * @return the tamil
	 */
	public int getTamil() {
		return tamil;
	}

	/**
	 * @param tamil
	 *            the tamil to set
	 */
	public void setTamil(int tamil) {
		this.tamil = tamil;
	}

	/**
	 * @return the hindi
	 */
	public int getHindi() {
		return hindi;
	}

	/**
	 * @param hindi
	 *            the hindi to set
	 */
	public void setHindi(int hindi) {
		this.hindi = hindi;
	}

	/**
	 * @return the english
	 */
	public int getEnglish() {
		return english;
	}

	/**
	 * @param english
	 *            the english to set
	 */
	public void setEnglish(int english) {
		this.english = english;
	}

	/**
	 * @return the maths
	 */
	public int getMaths() {
		return maths;
	}

	/**
	 * @param maths
	 *            the maths to set
	 */
	public void setMaths(int maths) {
		this.maths = maths;
	}

	/**
	 * @return the science
	 */
	public int getScience() {
		return science;
	}

	/**
	 * @param science
	 *            the science to set
	 */
	public void setScience(int science) {
		this.science = science;
	}

	/**
	 * @return the social
	 */
	public int getSocial() {
		return social;
	}

	/**
	 * @param social
	 *            the social to set
	 */
	public void setSocial(int social) {
		this.social = social;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MarksDTO [studentCode=" + studentCode + ", tamil=" + tamil + ", hindi="
				+ hindi + ", english=" + english + ", maths=" + maths + ", science=" + science + ", social=" + social
				+ "]";
	}

}
