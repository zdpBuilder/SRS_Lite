package com.srs.dao;

import com.srs.base.dao.IBaseDAO;
import com.srs.domain.Student;

/**
 * 
 * @ClassName:  IStudentDAO   
 * @Description:Carry out the Student services Operation    
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:30:00      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public interface IStudentDAO extends IBaseDAO<Student>{

	/**
	 * 
	 * @Title: getByName   
	 * @Description: Query Student by name
	 * @param: @param name
	 * @param: @return      
	 * @return: Student      
	 * @throws
	 */
	Student getByName(String name);
}
