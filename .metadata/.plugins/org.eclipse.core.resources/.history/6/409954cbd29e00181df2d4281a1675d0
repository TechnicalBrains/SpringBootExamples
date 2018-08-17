package com.education.mgmt.sys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.education.mgmt.sys.dto.SearchStudentDetailsDTO;
import com.education.mgmt.sys.dto.StudentCareerDetails;
import com.education.mgmt.sys.service.SearchService;

/**
 * @author 611163
 *
 */
@CrossOrigin(methods = { RequestMethod.POST, RequestMethod.GET }, 
			 origins = "http://localhost:4200")
@RestController
public class SearchController {

	@Autowired
	SearchService searchService;

	@PostMapping("/searchStudentInfo")
	public List<StudentCareerDetails> searchStudentDetails(@RequestBody SearchStudentDetailsDTO searchInfo) {
		System.out.println(" The Search Info (searchStudentDetails) :: " + searchInfo);
		return searchService.searchStudentMarksInfo(searchInfo);
	}

}
