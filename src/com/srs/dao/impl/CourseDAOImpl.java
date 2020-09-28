package com.srs.dao.impl;

import com.srs.base.dao.BaseDAOImpl;
import com.srs.dao.ICourseDAO;
import com.srs.domain.Course;

/**
 * 
 * @ClassName:  CourseDAOImpl   
 * @Description:CourseDAO implements   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:40:18      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class CourseDAOImpl extends BaseDAOImpl<Course> implements ICourseDAO{
	
	
	@Override
	public void initialize() {
		Course c1,c2,c3,c4,c5;
		c1 = new Course("CS101", "C 程序设计", 3.0);
		c2 = new Course("CS102", "面向对象程序设计", 3.0);
		c3 = new Course("CS103", "数据机构与算法", 4.0);
		c4 = new Course("MAT101", "概率与统计", 3.0);
		c5 = new Course("CS201", "离散数学", 3.0);
		
		mapObject.put(c1.getCourseNo(), c1);
		mapObject.put(c2.getCourseNo(), c2);
		mapObject.put(c3.getCourseNo(), c3);
		mapObject.put(c4.getCourseNo(), c4);
		mapObject.put(c5.getCourseNo(), c5);
	}

	@Override
	public Course getByCourseNo(String courseNo) {
		 
		return mapObject.get(courseNo);
	}
}
