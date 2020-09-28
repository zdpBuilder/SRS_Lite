package com.srs.dao.impl.file;

import java.io.File;
import java.util.Scanner;

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
public class CourseDAOImplFile extends BaseDAOImpl<Course> implements ICourseDAO{

	@Override
	public void initialize() {
		 Scanner bin = null;
		 try {
			bin = new Scanner(new File("file/Courses.dat"));
			while(bin.hasNext()) {
				String courseNumber = bin.next();
				String courseName = bin.next();
				double courseCredits = bin.nextDouble();
				Course course = new Course(courseNumber, courseName, courseCredits);
				mapObject.put(course.getCourseNo(), course);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				bin.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

	@Override
	public Course getByCourseNo(String courseNo) {
		 
		return mapObject.get(courseNo);
	}

}
