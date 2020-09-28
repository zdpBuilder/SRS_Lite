package com.srs.dao.impl.db;

import java.util.List;
import java.util.Map;

import com.srs.base.dao.BaseDAOImpl;
import com.srs.dao.ICourseDAO;
import com.srs.dao.IScheduledCourseDAO;
import com.srs.domain.Course;
import com.srs.domain.ScheduledCourse;
import com.srs.utils.EmptyUtils;
import com.srs.utils.JDBC;

/***
 * 
 * @ClassName:  ScheduledCourseDAOImpl   
 * @Description: ScheduledCourseDAO implements
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:40:51      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class ScheduledCourseDAOImplDB extends BaseDAOImpl<ScheduledCourse> implements IScheduledCourseDAO {
		
	@Override
	public void initialize(ICourseDAO courseDAO) {
		List<Map<String,Object>> resultSet = null;
		 try {
			resultSet = JDBC.QueryBySQL("select * from schedule_course");
			if(EmptyUtils.objectIsEmpty(resultSet))
				return;
			
			for (Map<String, Object> map : resultSet) {
				String courseNumber = (String) map.get("course_no");
				int classNo = (Integer) map.get("calss_no");
				String dayOfWeek = (String) map.get("day_of_week");
				String timeOfDay = (String) map.get("time_of_day");
				String room = (String) map.get("room");
				int seatingCapacity = (Integer) map.get("capacity");
				Course course = courseDAO.getByCourseNo(courseNumber);
				ScheduledCourse scheduledCourse = course.getScheduleCourse(dayOfWeek, timeOfDay, room, seatingCapacity, classNo);
				mapObject.put(scheduledCourse.getFullScheduleCourseNo(),scheduledCourse);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public ScheduledCourse getByID(String id) {
		
		return mapObject.get(id);
	}
}
