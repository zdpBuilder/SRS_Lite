package com.srs.dao;


import com.srs.base.dao.IBaseDAO;
import com.srs.domain.Course;

/***
 * 
 * @ClassName:  ICourseDAO   
 * @Description:Carry out the course services Operation   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:19:37      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public interface ICourseDAO extends IBaseDAO<Course>{
	
	/**
	 * 
	 * @Title: getByCourseNo   
	 * @Description: Query course By courseNO   
	 * @param: @param courseNo
	 * @param: @return      
	 * @return: Course      
	 * @throws
	 */
	Course getByCourseNo(String courseNo);
}
