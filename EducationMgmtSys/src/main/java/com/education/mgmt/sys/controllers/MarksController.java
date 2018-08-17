/**
 * 
 */
package com.education.mgmt.sys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.education.mgmt.sys.dto.StudentCareerDetails;
import com.education.mgmt.sys.service.MarksService;

/**
 * @author 611163
 *
 */
@RestController
public class MarksController {

	@Autowired
	MarksService marksService;
	
	@PostMapping(path="/addStudentMarks", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void registerStudentMarks(@RequestBody StudentCareerDetails studentCareerDetails) {
		marksService.saveMarks(studentCareerDetails);
	}
	
}
