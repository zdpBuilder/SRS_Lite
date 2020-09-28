package com.srs.dao;

import com.srs.base.dao.IBaseDAO;
import com.srs.domain.Professor;

/***
 * 
 * @ClassName:  IProfessorDAO   
 * @Description:Carry out the Professors services Operation  
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:29:06      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public interface IProfessorDAO extends IBaseDAO<Professor>{

	/**
	 * 
	 * @Title: getByPID   
	 * @Description: Query Professor By pId
	 * @param: @param pid
	 * @param: @return      
	 * @return: Professor      
	 * @throws
	 */
	Professor getByPID(String pid);
}
