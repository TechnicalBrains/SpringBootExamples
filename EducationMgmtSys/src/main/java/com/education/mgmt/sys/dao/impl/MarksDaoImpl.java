/**
 * 
 */
package com.education.mgmt.sys.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.education.mgmt.sys.dao.MarksDao;
import com.education.mgmt.sys.dao.jpa.MarksRepository;
import com.education.mgmt.sys.domain.Marks;

/**
 * @author 611163
 *
 */
@Repository
public class MarksDaoImpl implements MarksDao {

	@Autowired
	MarksRepository marksRepository;
	
	public MarksDaoImpl() {
		System.out.println(" Marks DAO Impl is instantiated... ");
	}
	
	/* (non-Javadoc)
	 * @see com.education.mgmt.sys.dao.MarksDao#findAllMarks()
	 */
	@Override
	public List<Marks> findAllMarks() {
		System.out.println(" The Marks Repository Object :: "+marksRepository);
		return marksRepository.findAll();
	}
	
}
