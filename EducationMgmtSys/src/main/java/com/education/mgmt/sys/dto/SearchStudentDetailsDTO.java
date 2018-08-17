/**
 * 
 */
package com.education.mgmt.sys.dto;

/**
 * @author 611163
 *
 */
public class SearchStudentDetailsDTO {

	private String studentCode;
	private String grade;
	private String standard;
	
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearchDTO [studentCode=" + studentCode + ", grade=" + grade + ", standard=" + standard + "]";
	}

}
