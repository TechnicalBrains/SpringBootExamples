/**
 * 
 */
package com.education.mgmt.sys.service;

import java.util.List;

import com.education.mgmt.sys.dto.SearchStudentDetailsDTO;
import com.education.mgmt.sys.dto.StudentCareerDetails;

/**
 * @author 611163
 *
 */
public interface SearchService {
	
	/**
	 * @param searchStudentDetailsDTO
	 * @return
	 */
	public List<StudentCareerDetails> searchStudentMarksInfo(SearchStudentDetailsDTO searchStudentDetailsDTO);
	
}
