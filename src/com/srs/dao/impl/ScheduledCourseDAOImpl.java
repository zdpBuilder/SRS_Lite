package com.srs.dao.impl;

import com.srs.base.dao.BaseDAOImpl;
import com.srs.dao.ICourseDAO;
import com.srs.dao.IScheduledCourseDAO;
import com.srs.domain.Course;
import com.srs.domain.ScheduledCourse;

/***
 * 
 * @ClassName:  ScheduledCourseDAOImpl   
 * @Description: ScheduledCourseDAO implements
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:40:51      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class ScheduledCourseDAOImpl extends BaseDAOImpl<ScheduledCourse> implements IScheduledCourseDAO {
		
	@Override
	public void initialize(ICourseDAO courseDAO) {
		ScheduledCourse calss1,calss2,calss3,calss4,calss5,calss6,calss7;
		Course course = courseDAO.getByCourseNo("CS101");
		calss1 = course.getScheduleCourse("周一", "上午 8：00-10：00", "A101", 30, 1);
		calss2 = course.getScheduleCourse("周二", "上午 8：00-10：00", "C202",30, 2);

		course = courseDAO.getByCourseNo("CS102");
		calss3 = course.getScheduleCourse("周三", "下午 2：00-4：00", "C105", 25, 1);
		calss4 = course.getScheduleCourse("周四", "下午 4：00-6：00", "D330",25, 2);
		
		course = courseDAO.getByCourseNo("CS103");
		calss5 = course.getScheduleCourse("周一", "下午 6：00-8：00", "E101", 20, 1);
		
		course = courseDAO.getByCourseNo("MAT101");
		calss6 = course.getScheduleCourse("周五", "下午 4：00-6：00", "D241", 15, 1);
		
		course = courseDAO.getByCourseNo("CS201");
		calss7 = course.getScheduleCourse("周一", "下午 4：00-6：00", "A205", 1, 1);
		mapObject.put(calss1.getFullScheduleCourseNo(), calss1);
		mapObject.put(calss2.getFullScheduleCourseNo(), calss2);
		mapObject.put(calss3.getFullScheduleCourseNo(), calss3);
		mapObject.put(calss4.getFullScheduleCourseNo(), calss4);
		mapObject.put(calss5.getFullScheduleCourseNo(), calss5);
		mapObject.put(calss6.getFullScheduleCourseNo(), calss6);
		mapObject.put(calss7.getFullScheduleCourseNo(), calss7);
	}

	@Override
	public ScheduledCourse getByID(String id) {
		
		return mapObject.get(id);
	}

}
