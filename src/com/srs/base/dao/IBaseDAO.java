package com.srs.base.dao;

import java.util.List;

/***
 * 
 * @ClassName:  IBaseDAO   
 * @Description:common DAO    
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:18:17    
 * @param <T>  
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public interface IBaseDAO<T> {

	/**
	 * 
	 * @Title: initialize   
	 * @Description: initialized data  
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	void initialize();		
	/**
	 * 
	 * @Title: getAll   
	 * @Description: Get All Data stored in Map    
	 * @param: @return      
	 * @return: List<T>      
	 * @throws
	 */
	List<T> getAllMapStoreData();
	
	/**
	 * 
	 * @Title: getAll   
	 * @Description: Get All Data stored in List  
	 * @param: @return      
	 * @return: List<T>      
	 * @throws
	 */
	List<T> getAllListStoreData();
}
