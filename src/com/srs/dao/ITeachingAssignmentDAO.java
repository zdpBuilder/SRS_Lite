package com.srs.dao;

/***
 * 
 * @ClassName:  ITeachingAssignmentDAO   
 * @Description:Carry out the Teaching Assignment services Operation    
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:30:13      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public interface ITeachingAssignmentDAO {

	/**
	 * 
	 * @Title: initialize   
	 * @Description: initialize Teaching Assignment   
	 * @param: @param professorDAO
	 * @param: @param scheduledCourseDAO      
	 * @return: void      
	 * @throws
	 */
	void initialize(IProfessorDAO professorDAO,IScheduledCourseDAO scheduledCourseDAO);
}
