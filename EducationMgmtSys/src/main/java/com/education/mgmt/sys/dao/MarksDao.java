/**
 * 
 */
package com.education.mgmt.sys.dao;

import java.util.List;

import com.education.mgmt.sys.domain.Marks;

/**
 * @author 611163
 *
 */
public interface MarksDao {

	/**
	 * @return
	 */
	public List<Marks> findAllMarks();
	
}
