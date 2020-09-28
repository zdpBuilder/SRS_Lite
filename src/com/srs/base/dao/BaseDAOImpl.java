package com.srs.base.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/***
 * 
 * @ClassName:  BaseDAOImpl   
 * @Description:common BaseDAO   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:17:52    
 * @param <T>  
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class BaseDAOImpl<T> implements IBaseDAO<T>{

	protected Map<String, T> mapObject =  new HashMap<String,T>();
	protected List<T> listObject = new ArrayList<T>();
	
	@Override
	public void initialize() {
		 
	}

	@Override
	public List<T> getAllMapStoreData() {
		List<T> list = new LinkedList<T>();
		for (Map.Entry<String, T> entry : mapObject.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}

	@Override
	public List<T> getAllListStoreData() {
		return listObject;
	}

	 
}
