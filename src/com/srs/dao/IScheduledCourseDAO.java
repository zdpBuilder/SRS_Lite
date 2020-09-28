package com.srs.dao;

import com.srs.base.dao.IBaseDAO;
import com.srs.domain.ScheduledCourse;

/***
 * 
 * @ClassName:  IScheduledCourseDAO   
 * @Description:Carry out the ScheduledCourse services Operation   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:29:34      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public interface IScheduledCourseDAO extends IBaseDAO<ScheduledCourse>{

	/**
	 * 
	 * @Title: initialize   
	 * @Description:Initialize all Courses have plan in teaching assignment 
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	void initialize(ICourseDAO courseDAO);	
	/**
	 * 
	 * @Title: getByID   
	 * @Description: According to id query ScheduledCourse
	 * @param: @param id
	 * @param: @return      
	 * @return: ScheduledCourse      
	 * @throws
	 */
	ScheduledCourse getByID(String id);
}
