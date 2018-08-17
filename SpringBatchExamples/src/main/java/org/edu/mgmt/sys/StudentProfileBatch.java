/**
 * 
 */
package org.edu.mgmt.sys;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 611163
 *
 */
public class StudentProfileBatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/batch/jobs/student-profile-batch.xml");
		
		JobLauncher jobLauncher = (JobLauncher) applicationContext.getBean("jobLauncher");
		Job job = (Job) applicationContext.getBean("studentProfileJob");
		try {
			JobExecution jobExecution = (JobExecution) jobLauncher.run(job, new JobParameters());
			System.out.println(" The Execution Status :: "+jobExecution.getStatus());
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(" Done. ");
		applicationContext = null;
	}
	
}
