package com.education.mgmt.sys.service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.mgmt.sys.dao.jpa.MarksRepository;
import com.education.mgmt.sys.domain.Marks;
import com.education.mgmt.sys.dto.SearchStudentDetailsDTO;
import com.education.mgmt.sys.dto.StudentCareerDetails;
import com.education.mgmt.sys.service.SearchService;

/**
 * @author 611163
 *
 */
@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	MarksRepository marksRepository;
	
	private List<Marks> studentTracks = null;
	
	Function<Marks, StudentCareerDetails> careerFunction = null;
	
	Function<StudentCareerDetails, StudentCareerDetails> marksCalculateFunction = null;

	public SearchServiceImpl() {
		System.out.println(" Search Service Impl Instantiated... ");
		careerFunction = (details) -> {
			
		    StudentCareerDetails studentCareerDetails = new StudentCareerDetails();
		    studentCareerDetails.setStudentCode(details.getStudentCode());
		    studentCareerDetails.setEnglish(details.getEnglish());
		    studentCareerDetails.setHindi(details.getHindi());
		    studentCareerDetails.setMaths(details.getMaths());
		    studentCareerDetails.setScience(details.getScience());
		    studentCareerDetails.setSocial(details.getSocial());
		    studentCareerDetails.setTamil(details.getTamil());
		  
		    return studentCareerDetails;
		    
		};
		
		marksCalculateFunction = (studentCareerDetails) -> {

			int totalMarks = studentCareerDetails.getHindi() + studentCareerDetails.getEnglish()
					+ studentCareerDetails.getMaths() + studentCareerDetails.getScience()
					+ studentCareerDetails.getSocial() + studentCareerDetails.getTamil();

			studentCareerDetails.setTotal(String.valueOf(totalMarks));

			double percentage = (totalMarks * 100) / 600;
			studentCareerDetails.setPercentage(percentage);
			System.out.println(" The Percentage :: " + percentage);
			if (percentage >= 75) {
				studentCareerDetails.setGrade("Distinction");
			} else if (percentage >= 60 && percentage < 75) {
				studentCareerDetails.setGrade("First Class");
			} else if (percentage >= 50 && percentage < 60) {
				studentCareerDetails.setGrade("Second Class");
			} else if (percentage >= 45 && percentage < 50) {
				studentCareerDetails.setGrade("Third Class");
			} else {
				studentCareerDetails.setGrade("Fail");
			}
			return studentCareerDetails;
		};
		
	}
	@Override
	public List<StudentCareerDetails> searchStudentMarksInfo(SearchStudentDetailsDTO searchStudentDetailsDTO) {
		
		if(StringUtils.isNotBlank(searchStudentDetailsDTO.getStandard()) && StringUtils.isNotBlank(searchStudentDetailsDTO.getGrade())
				&& StringUtils.isNotBlank(searchStudentDetailsDTO.getStudentCode())) {
			return searchWithAllOptions(searchStudentDetailsDTO);
		} else if(StringUtils.isNotBlank(searchStudentDetailsDTO.getStandard()) && StringUtils.isBlank(searchStudentDetailsDTO.getGrade())
				&& StringUtils.isBlank(searchStudentDetailsDTO.getStudentCode())) {
			return searchByStandard(searchStudentDetailsDTO);
		} else if(StringUtils.isNotBlank(searchStudentDetailsDTO.getStandard()) 
				&& StringUtils.isNotBlank(searchStudentDetailsDTO.getStudentCode())
				&& StringUtils.isBlank(searchStudentDetailsDTO.getGrade())) {
			return searchStudentByStandard(searchStudentDetailsDTO);
		} else if(StringUtils.isNotBlank(searchStudentDetailsDTO.getStandard()) && StringUtils.isNotBlank(searchStudentDetailsDTO.getGrade())
				&& StringUtils.isBlank(searchStudentDetailsDTO.getStudentCode())) {
			return searchGradeByStandard(searchStudentDetailsDTO);
		} else if(StringUtils.isBlank(searchStudentDetailsDTO.getStandard()) 
					&& StringUtils.isNotBlank(searchStudentDetailsDTO.getGrade())
					&& StringUtils.isNotBlank(searchStudentDetailsDTO.getStudentCode())
				 ) {
			return searchStudentByGrade(searchStudentDetailsDTO);
		}
		return null;
	}
	
	private List<StudentCareerDetails> searchByStandard(SearchStudentDetailsDTO searchStudentDetailsDTO) {
		studentTracks = marksRepository.findAll();
		System.out.println(" The Student Tracks Size :: "+studentTracks.size());
		Predicate<StudentCareerDetails> studentPredicate = (studentCareerDetails) -> {
			return studentCareerDetails.getStandard().equals(searchStudentDetailsDTO.getStandard());
		};
		List<StudentCareerDetails> marksList = studentTracks.stream().map(careerFunction)
																	 .filter(studentPredicate)
																	 .collect(Collectors.toList());
		System.out.println(" The Standard Details :: "+marksList);
		return marksList;
	}
	
	private List<StudentCareerDetails> searchStudentByStandard(SearchStudentDetailsDTO searchStudentDetailsDTO) {
		studentTracks = marksRepository.findAll();
		System.out.println(" The Student Tracks Size :: "+studentTracks.size());
		Predicate<StudentCareerDetails> studentPredicate = (studentCareerDetails) -> {
			return studentCareerDetails.getStandard().equals(searchStudentDetailsDTO.getStandard()) && 
					studentCareerDetails.getStudentCode().equals(searchStudentDetailsDTO.getStudentCode());
		};
		List<StudentCareerDetails> marksList = studentTracks.stream().map(careerFunction)
																	 .filter(studentPredicate)
																	 .collect(Collectors.toList());
		
		System.out.println(" The Marks Details :: "+marksList.size());
		return marksList;
	}
	
	private List<StudentCareerDetails> searchGradeByStandard(SearchStudentDetailsDTO searchStudentDetailsDTO) {
		studentTracks = marksRepository.findAll();
		System.out.println(" The Student Tracks Size :: "+studentTracks.size());
		Predicate<StudentCareerDetails> standardPredicate = (studentCareerDetails) -> {
			return studentCareerDetails.getStandard().equals(searchStudentDetailsDTO.getStandard());
		};
		
		Predicate<StudentCareerDetails> gradePredicate = (studentCareerDetails) -> {
			return studentCareerDetails.getGrade().equalsIgnoreCase(searchStudentDetailsDTO.getGrade());
		};
		
		Predicate<StudentCareerDetails> gradeByStandardPredicate = standardPredicate.and(gradePredicate);
		
		Function<Marks, StudentCareerDetails> trackFunction = careerFunction.andThen(marksCalculateFunction);
		
		List<StudentCareerDetails> studentsMarksByGrade = studentTracks.stream()
																	   .map(trackFunction)
																	   .filter(gradeByStandardPredicate)
																	   .collect(Collectors.toList());
		System.out.println(" The Student Marks By Grade List Size :: "+studentsMarksByGrade.size());
		System.out.println(" The Student Marks By Grade Details :: "+studentsMarksByGrade);
		return studentsMarksByGrade;
	}
	
	private List<StudentCareerDetails> searchStudentByGrade(SearchStudentDetailsDTO searchStudentDetailsDTO) {
		studentTracks = marksRepository.findAll();
		System.out.println(" The Student Tracks Size :: "+studentTracks.size());
		Predicate<StudentCareerDetails> studentPredicate = (studentCareerDetails) -> {
			return studentCareerDetails.getStudentCode().equals(searchStudentDetailsDTO.getStudentCode());
		};
		
		Predicate<StudentCareerDetails> gradePredicate = (studentCareerDetails) -> {
			return studentCareerDetails.getGrade().equalsIgnoreCase(searchStudentDetailsDTO.getGrade());
		};
		
		Predicate<StudentCareerDetails> gradeByStudentPredicate = studentPredicate.and(gradePredicate);
		
		Function<Marks, StudentCareerDetails> trackFunction = careerFunction.andThen(marksCalculateFunction);
		
		List<StudentCareerDetails> studentsMarksByGrade = studentTracks.stream()
																	   .map(trackFunction)
																	   .filter(gradeByStudentPredicate)
																	   .collect(Collectors.toList());
		System.out.println(" The Student Marks By Grade List Size :: "+studentsMarksByGrade.size());
		System.out.println(" The Student Marks By Grade Details :: "+studentsMarksByGrade);
		return studentsMarksByGrade;
	}
	
	private List<StudentCareerDetails> searchWithAllOptions(SearchStudentDetailsDTO searchStudentDetailsDTO) {
		studentTracks = marksRepository.findAll();
		System.out.println(" The Student Tracks Size :: "+studentTracks.size());
		Predicate<StudentCareerDetails> standardPredicate = (studentCareerDetails) -> {
			return studentCareerDetails.getStandard().equals(searchStudentDetailsDTO.getStandard());
		};
		
		Predicate<StudentCareerDetails> gradePredicate = (studentCareerDetails) -> {
			return studentCareerDetails.getGrade().equalsIgnoreCase(searchStudentDetailsDTO.getGrade());
		};
		
		Predicate<StudentCareerDetails> studentCodePredicate = (studentCareerDetails) -> {
			return studentCareerDetails.getStudentCode().equals(searchStudentDetailsDTO.getStudentCode());
		};
		
		Predicate<StudentCareerDetails> searchByAllPredicate = standardPredicate.and(gradePredicate).and(studentCodePredicate);
		
		Function<Marks, StudentCareerDetails> trackFunction = careerFunction.andThen(marksCalculateFunction);
		
		List<StudentCareerDetails> studentsMarksByGrade = studentTracks.stream()
																	      .map(trackFunction)
																	      .filter(searchByAllPredicate)
																	      .collect(Collectors.toList());
		System.out.println(" The Student Marks By Grade List Size :: "+studentsMarksByGrade.size());
		System.out.println(" The Student Marks By Grade Details :: "+studentsMarksByGrade);
		return studentsMarksByGrade;
	}
	
}
