/**
 * 
 */
package com.education.mgmt.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.mgmt.sys.dao.jpa.MarksRepository;
import com.education.mgmt.sys.domain.Marks;
import com.education.mgmt.sys.dto.StudentCareerDetails;
import com.education.mgmt.sys.service.MarksService;

/**
 * @author 611163
 *
 */
@Service
public class MarksServiceImpl implements MarksService {

	@Autowired
	MarksRepository marksRepository;
	
	@Override
	public void saveMarks(StudentCareerDetails studentCareerDetails) {

		Marks marks = new Marks();
		
		marks.setEnglish(studentCareerDetails.getEnglish());
		marks.setHindi(studentCareerDetails.getHindi());
		marks.setTamil(studentCareerDetails.getTamil());
		marks.setMaths(studentCareerDetails.getMaths());
		marks.setScience(studentCareerDetails.getScience());
		marks.setSocial(studentCareerDetails.getSocial());
		
		marksRepository.save(marks);
		
	}

}
