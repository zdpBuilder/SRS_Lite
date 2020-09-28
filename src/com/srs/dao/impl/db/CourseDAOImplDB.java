package com.srs.dao.impl.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.srs.base.dao.BaseDAOImpl;
import com.srs.dao.ICourseDAO;
import com.srs.domain.Course;
import com.srs.utils.EmptyUtils;
import com.srs.utils.JDBC;

/**
 * 
 * @ClassName:  CourseDAOImpl   
 * @Description:CourseDAO implements   
 * @author: 张戴鹏(zdpBuilder)
 * @date:   2020年9月28日 上午11:40:18      
 * @Copyright:  张戴鹏(zdpBuilder)
 */
public class CourseDAOImplDB extends BaseDAOImpl<Course> implements ICourseDAO{
	
	@Override
	public void initialize() {
		List<Map<String,Object>> resultSet = null;
		 try {
			 resultSet = JDBC.QueryBySQL("select * from course_catalog");
			if(EmptyUtils.objectIsEmpty(resultSet))
				return;
			mapObject = new HashMap<String,Course>();
			for (Map<String, Object> map : resultSet){
				String courseNumber = (String) map.get("course_no");
				String courseName = (String) map.get("course_name");
				double courseCredits = Double.valueOf(map.get("credits").toString());
				Course course = new Course(courseNumber, courseName, courseCredits);
				mapObject.put(course.getCourseNo(), course);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Course getByCourseNo(String courseNo) {
		 
		return mapObject.get(courseNo);
	}

}
