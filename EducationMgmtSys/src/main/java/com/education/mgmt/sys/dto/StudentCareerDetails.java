/**
 * 
 */
package com.education.mgmt.sys.dto;

/**
 * @author 611163
 *
 */
public class StudentCareerDetails {

	private String studentCode;
	private String standard;
	private Integer tamil;
	private Integer hindi;
	private Integer english;
	private Integer maths;
	private Integer science;
	private Integer social;
	private Double percentage;
	private String total;
	private String grade;
	
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
	 * @return the standard
	 */
	public String getStandard() {
		return standard;
	}

	/**
	 * @param standard
	 *            the standard to set
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}

	/**
	 * @return the tamil
	 */
	public Integer getTamil() {
		return tamil;
	}

	/**
	 * @param tamil
	 *            the tamil to set
	 */
	public void setTamil(Integer tamil) {
		this.tamil = tamil;
	}

	/**
	 * @return the hindi
	 */
	public Integer getHindi() {
		return hindi;
	}

	/**
	 * @param hindi
	 *            the hindi to set
	 */
	public void setHindi(Integer hindi) {
		this.hindi = hindi;
	}

	/**
	 * @return the english
	 */
	public Integer getEnglish() {
		return english;
	}

	/**
	 * @param english
	 *            the english to set
	 */
	public void setEnglish(Integer english) {
		this.english = english;
	}

	/**
	 * @return the maths
	 */
	public Integer getMaths() {
		return maths;
	}

	/**
	 * @param maths
	 *            the maths to set
	 */
	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	/**
	 * @return the science
	 */
	public Integer getScience() {
		return science;
	}

	/**
	 * @param science
	 *            the science to set
	 */
	public void setScience(Integer science) {
		this.science = science;
	}

	/**
	 * @return the social
	 */
	public Integer getSocial() {
		return social;
	}

	/**
	 * @param social
	 *            the social to set
	 */
	public void setSocial(Integer social) {
		this.social = social;
	}

	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentCareerDetails [studentCode=" + studentCode + ", standard=" + standard + ", tamil=" + tamil
				+ ", hindi=" + hindi + ", english=" + english + ", maths=" + maths + ", science=" + science
				+ ", social=" + social + ", total=" + total + ", grade=" + grade + "]";
	}

	/**
	 * @return the percentage
	 */
	public Double getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

}
